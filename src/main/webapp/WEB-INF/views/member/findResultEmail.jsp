<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ include
        file="../include/header.jspf" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>

<!-- Page Content-->
<section class="py-5">
    <div class="container px-5">
        <div class="row gx-5 justify-content-center">
            <div class="col-lg-6">
                <meta charset="UTF-8"/>
                <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
                <link href="${path}/resources/dist/css/member/findResultEmail.css" rel="stylesheet"/>

                <div id="findIdArea1" class="login_wrap_inner">
                    <h2 class="log_logo">계모임</h2>
                    <h1 class="fw-bolder">이메일을 확인해 주세요.</h1>
<%--                    <p>계모임 가입으로 목돈 모으기 성공! </p>--%>
                    <fieldset class="find_field">
                        <c:choose>
                            <c:when test="${empty memberVO}">
                                <p class="mb-4">조회결과가 없습니다.</p>
                            </c:when>
                            <c:otherwise>
                                <p class="mb-4">${memberVO.email}</p>
                            </c:otherwise>
                        </c:choose>
                    </fieldset>

                    <div class="findidpw_btns_wrap">
                        <p>
                            <a href="<%=request.getContextPath()%>/member/findPwd">비밀번호 찾기</a>
                        </p>
                        <p><a href="<%=request.getContextPath()%>/member/login">회원가입</a></p>
                        <p><a href="<%=request.getContextPath()%>/member/login">로그인</a></p>
                    </div>
                </div>

                <script>
                    var path = "${pageContext.request.contextPath }";

                    $(document).ready(function () {});
                </script>




            </div>
        </div>
    </div>
</section>
<%@ include file="../include/footer.jspf" %>
