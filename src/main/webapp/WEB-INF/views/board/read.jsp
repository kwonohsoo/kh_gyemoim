<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ include file="../include/header.jspf" %>

<link href="resources/dist/css/board/list.css" rel="stylesheet"/>

<section class="py-5">
  <div class="container px-5">
    <div class="row">
      <div class="col-11">
        <div class="title">
          <h1>공지사항</h1>
          <p>계모임의 소식을 전합니다</p>
        </div>
        <div class="container">
          <table>
            <tr>
              <td>Title: ${board.getTitle()}</td>
            </tr>
            <tr>
              <td>
                작성자: ${board.getName()}
                <span><fmt:formatDate value="${board.getWriteDate()}" pattern="yyyy-MM-dd"/></span>
              </td>
            </tr>
            <tr>
              <td>${board.getContent()}</td>
            </tr>
          </table>
          <form action="/delete" method="get">
            <input type="hidden" id="write-input-uNo" name="uNo" value="${login.getUNo()}">
            <input type="hidden" id="write-input-bid" name="bid" value="${board.getBid()}">
            <div class="write-btn-area text-center">
              <button type="submit" class="btn btn-danger btn-lg px-4 me-sm-3">
                글 삭제
              </button>
            </div>
          </form>
          <form action="/replyWrite">
            <p>댓글</p>
            <textarea name="content" id="content" cols="70" rows="2"></textarea>
            <input type="hidden" name="bid" value="${board.getBid()}">
            <p>
              <button type="submit">댓글 작성</button>
            </p>
          </form>
          <table>
            <c:forEach var="reply" items="${reply}">
              <tr>
                <td>${reply.getName()}</td>
                <td>${reply.getComm()}</td>
              </tr>
            </c:forEach>
          </table>
        </div>
      </div>
    </div>
  </div>
</section>

<%@ include file="../include/footer.jspf" %>