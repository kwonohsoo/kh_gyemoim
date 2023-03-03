<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../include/header.jspf" %>

<link href="${path}/resources/dist/css/member/login.css" rel="stylesheet"/>
<!-- <script src="/test/js/jquery-3.6.0.js"></script> -->
<!-- Page Content-->

<section class="py-5">
  <div class="container px-5">
    <div class="row gx-5 justify-content-center">
      <div class="col-lg-6">

        <section class="login">
          <div id="content">
            <div class="login_wrap">
              <div class="login_wrap_inner">
                <h2 class="log_logo">계모임</h2>
                <h3 class="simp_log_ttl">로그인</h3>

                <form
                        id="loginForm"
                        method="post"
                        action="<%=request.getContextPath()%>/member/loginPost"
                >
                  <fieldset class="login_field">
                    <input
                            id="email"
                            class="login_input"
                            name="email"
                            placeholder="이메일을 입력해 주세요. (Email)"
                            type="email"
                    />

                    <input
                            id="password"
                            class="login_input"
                            name="password"
                            placeholder="비밀번호를 입력해 주세요. (Password)"
                            type="password"
                    />

                    <p class="login_rem">
                      <input id="remEmail" name="useCookie" type="checkbox"/>
                      <label for="remEmail">자동 로그인</label>
                    </p>
                  </fieldset>

                  <div class="login_btns_wrap">
                    <button class="login_btn" id="login" type="submit">
                      로그인
                    </button>
                  </div>
                </form>
                <div class="login_frm_guide">
                  <ul class="p-0">
                    <li>
                      <a href="<%=request.getContextPath()%>/member/findEmail">이메일 찾기</a>
                    </li>
                    <li>｜</li>
                    <li>
                      <a href="<%=request.getContextPath()%>/member/findPwd">비밀번호 찾기</a>
                    </li>
                    <li>｜</li>
                    <li>
                      <a href="<%=request.getContextPath()%>/member/register">회원가입</a>
                    </li>
                  </ul>
                </div>
              </div>
            </div>
          </div>
        </section>
      </div>
    </div>
  </div>
</section>
<%--js--%>

<%--                <script type="text/javascript">--%>
<%--                    let email = document.querySelector('#email')--%>
<%--                    let password = document.querySelector('#password')--%>
<%--                    let btn = document.querySelector('#login')--%>

<%--                    btn.addEventListener('click', () => {--%>
<%--                        if(email.value == "") {--%>
<%--                            email = email.nextElementSibling--%>
<%--                            email.classList.add('warning')--%>
<%--                            setTimeout(() => {--%>
<%--                                email.classList.remove('warning')--%>
<%--                            }, 1500)--%>
<%--                        } else if(password.value == "") {--%>
<%--                            password = password.nextElementSibling--%>
<%--                            password.classList.add('warning')--%>
<%--                            setTimeout(() => {--%>
<%--                                password.classList.remove('warning')--%>
<%--                            }, 1500)--%>
<%--                        }--%>
<%--                    })--%>
<%--                </script>--%>

<%@ include file="../include/footer.jspf" %>
