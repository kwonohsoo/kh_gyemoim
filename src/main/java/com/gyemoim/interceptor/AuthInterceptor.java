package com.gyemoim.interceptor;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.service.member.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.util.WebUtils;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

// 로그인처리를 담당하는 인터셉터
public class AuthInterceptor extends HandlerInterceptorAdapter {

    private static final Logger logger = LoggerFactory.getLogger(AuthInterceptor.class);

    @Inject
    private MemberService service;

    @Override
    // preHandle() : 컨트롤러보다 먼저 수행되는 메서드
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // session 객체를 가져옴
        HttpSession session = request.getSession();

        if (session.getAttribute("login") == null) {
            logger.info("current user is not logined");
            saveDest(request);
            Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");
            System.out.println("쿠키가 살아있니?" + loginCookie);
            if (loginCookie != null) {
                MemberVO vo = service.checkLoginBefore(loginCookie.getValue());

                logger.info("MemberVO: " + vo);
                System.out.println("로그인쿠키가 널이 아니고 auth인터셉터 실행함!! ->" + vo.toString());
                if (vo != null) {
                    session.setAttribute("login", vo);
                    return true;
                }
            }
            response.sendRedirect("/member/login");
            return false;
        }
        return true;
    }

    private void saveDest(HttpServletRequest req) {

        String uri = req.getRequestURI();
        String query = req.getQueryString();

        if (query == null || query.equals("null")) {
            query = "";
        } else {
            query = "?" + query;
        }

        if (req.getMethod().equals("GET")) {
            logger.info("dest: " + (uri + query));
            req.getSession().setAttribute("dest", uri + query);
        }
    }
}