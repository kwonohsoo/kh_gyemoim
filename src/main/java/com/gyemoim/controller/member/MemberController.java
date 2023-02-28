package com.gyemoim.controller.member;

import com.gyemoim.domain.member.MemberVO;
import com.gyemoim.dto.member.LoginDTO;
import com.gyemoim.service.member.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/member")
public class MemberController {

  @Inject
  public MemberService service;


  // 로그인 폼
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public void login(@ModelAttribute("dto") LoginDTO dto) {
  }


  // 로그인 처리
  @RequestMapping(value = "/loginPost", method = RequestMethod.POST)
  public void loginPost(LoginDTO dto, HttpSession session, Model model) throws Exception {

    MemberVO vo = service.login(dto);

    if (vo == null) return;
    model.addAttribute("memberVO", vo);

    System.out.println(vo.toString());
    System.out.println("쿠키 사용 중이니? = " + dto.isUseCookie());

    if (dto.isUseCookie()) {
      int amount = 60 * 60 * 24 * 7;
      Date sessionLimit = new Date(System.currentTimeMillis() + (1000 * amount));

      System.out.println("loginPost에서 service의 keepLogin수행.");

      Map<String, Object> paramMap = new HashMap<>();
      paramMap.put("email", vo.getEmail());
      paramMap.put("sessionId", session.getId());
      paramMap.put("next", sessionLimit);
      service.keepLogin(paramMap);

      System.out.println("서비스 파라맵 되니? = " + vo.getEmail());
      System.out.println("서비스 파라맵 되니? = " + session.getId());
      System.out.println("서비스 파라맵 되니? = " + sessionLimit.toString());
      System.out.println(paramMap);
    }
  }


  // 로그아웃
  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public String logout(HttpServletRequest request,
                       HttpServletResponse response, HttpSession session) throws Exception {

    Object obj = session.getAttribute("login");

    System.out.println("로그아웃 완료");

    if (obj != null) {
      MemberVO vo = (MemberVO) obj;

      session.removeAttribute("login");
      session.invalidate();

      System.out.println("로그아웃 *세션* 지움");

      Cookie loginCookie = WebUtils.getCookie(request, "loginCookie");

      if (loginCookie != null) {
        loginCookie.setPath("/");
        loginCookie.setMaxAge(0);
        response.addCookie(loginCookie);
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("email", vo.getEmail());
        paramMap.put("sessionId", session.getId());
        paramMap.put("next", new Date());
        service.keepLogin(paramMap);
      }
    }
    return "member/logout";
  }
}
