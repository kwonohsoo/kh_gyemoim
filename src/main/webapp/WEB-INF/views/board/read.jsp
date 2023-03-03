<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ page isELIgnored="false" %>

<%@ include file="../include/header.jspf" %>
<!-- jQuery 3.1.1 -->
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>

<link href="/resources/dist/css/board/read.css" rel="stylesheet"/>

<section class="py-5">
  <div class="container px-5">
    <div class="row">
      <div class="col-11">
        <div class="title">
          <h1>공지사항보드${board.getUNo()}</h1>
          <p>계모임의 소식을 전합니다</p>
        </div>
        <div class="container">
          <table class="table text-center">
            <tr>
              <td><h2>제목: ${board.getTitle()}</h2></td>
            </tr>
            <tr>
              <td class="read-detail">
                <div><b>작성자 : </b>${board.getName()}</div>
                <div><b>작성일자 : </b><fmt:formatDate value="${board.getWriteDate()}" pattern="yyyy-MM-dd"/></div>
                <div><b>조회수 : </b>${board.getViews()}</div>
              </td>
            </tr>
            <tr>
              <td class="read-content p-3">${board.getContent()}</td>
            </tr>

            <c:choose>
              <c:when test="${attached.getFileName() == null}">

              </c:when>
              <c:when test="${attached.getFileName() != null}">
                <tr>
                  <td class="text-start AttachedFile">
                    <b>첨부파일 : </b> <a href="/fileDownload?fileName=${attached.getFileName()}">${attached.getFileName()}<br>
                    <div class="fileImg pt-3"><img id="ImgPreview" name="fileName"
                                                   src="/fileDownload?fileName=${attached.getFileName()}" class="preview"/>
                    </div>
                    <input type="hidden" id="write-input-bid" name="fileName" value="${attached.getFileName()}">
                  </a>
                  </td>
                </tr>
              </c:when>
            </c:choose>

          </table>

          <!--댓글 시작-->
          <div id="reply" class="card bg-light">
            <div class="card-body">
              <textarea class="form-control" name="comm" id="newReplyComm" cols="30" rows="3"
                        placeholder="댓글을 입력해주세요"></textarea>
              <input class="form-control" type="hidden" id="newReplyBid" name="bid" value="${board.getBid()}">
              <input class="form-control" type="hidden" id="newReplyUNo" name="uNo" value="${board.getUNo()}">
              <input class="form-control" type="hidden" id="newReplyName" name="name" value="${board.getName()}">

              <button type="submit" class="btn btn-primary btn-md px-3 mt-2 me-sm-3" id="replyAddBtn">작성</button>

              <table>
                <c:forEach var="reply" items="${reply}">
                  <tr>
                    <td class="fw-bold">${reply.getName()}</td>
                    <td>
                      <div class="reply-contents">${reply.getComm()}</div>
                      <a class="reply-btn" id="">수정하기</a>
                      <a class="reply-btn">삭제하기</a>
                    </td>
                  </tr>
                </c:forEach>
              </table>

            </div>
          </div>

          <div class="read-btn-area mt-4 text-center">
            <input type="button" value="목록보기" class="btn btn-primary btn-lg px-4 me-sm-3"
                   onclick="location.href='/board/list'"/>
            <input type="button" value="수정하기" class="btn btn-primary btn-lg px-4 me-sm-3"
                   onclick="location.href='/modify?bid=${board.getBid()}'"/>
            <input type="button" value="삭제하기" class="btn btn-primary btn-lg px-4 me-sm-3"
                   onclick="location.href='/modify?bid=${board.getBid()}'"/>
          </div>

        </div>
      </div>
    </div>
  </div>


</section>


<!— 댓글작성 —>
<script type="text/javascript">
  $(function () {
    $("#replyAddBtn").on("click", function () {
      let repBid = "${board.getBid()}";
      let repUNo = "${board.getUNo()}";
      let repName = "${board.getName()}";

      let replytextObj = $("#newReplyComm");
      let replytext = replytextObj.val();

      $.ajax({
        type: 'post',
        url: '/replyWrite/',
        headers: {
          "Content-Type": "application/json",
          "X-HTTP-Method-Override": "POST"
        },
        data: JSON.stringify({
          "bid": repBid,
          "uNo": $("#newReplyUNo").val(),
          "comm": replytext,
          "name": repName
        }),
        success: function (result) {
          console.log("result: " + result);
          if (result == 'SUCCESS') {
            location.reload();
          }
        },
        error: function () {
          console.log("ajax 통신 실패");
        }
      });
    });
  });

</script>
<%@ include file="../include/footer.jspf" %>