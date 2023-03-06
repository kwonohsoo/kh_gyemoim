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
                <link href="${path}/resources/dist/css/member/login.css" rel="stylesheet"/>


                <style type="text/css">
                    .p-51 {
                        margin: 0px auto; /*가운데 정렬*/
                        text-align: center;
                    }

                </style>


                <div class="p-51">
                    <div class="text-center">
                        <h1 class="fw-bolder">비밀번호를 확인해 주세요.</h1>
<%--                        <p>계모임 가입으로 목돈 모으기 성공! </p>--%>
                        <br/><br/>
                        <c:choose>
                            <c:when test="${empty memberVO}">
                                <p class="mb-4">조회결과가 없습니다.</p>
                            </c:when>
                            <c:otherwise>
                                <p class="mb-4">${memberVO.password}</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="text-center">
                        <a class="small" href="<%=request.getContextPath()%>/member/findEmail">이메일 찾기</a>
                    </div>
                    <div class="text-center">
                        <a class="small" href="<%=request.getContextPath()%>/member/register">회원가입</a>
                    </div>
                    <div class="text-center">
                        <a class="small" href="<%=request.getContextPath()%>/member/login">로그인</a>
                    </div>
                </div>

                <script>
                    var path = "${pageContext.request.contextPath }";

                    $(document).ready(function () {
                    });
                </script>



            </div>
        </div>
    </div>
</section>
<%@ include file="../include/footer.jspf" %>
