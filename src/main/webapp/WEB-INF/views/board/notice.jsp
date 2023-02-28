<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page session="false" %>

<%@ include file="../include/header.jspf" %>

<link href="<c:url value="/resources/dist/css/board/list.css"/>" rel="stylesheet"/>

<section class="py-5">
  <div class="container px-5">
    <div class="row">
      <div class="col-11">
        <div class="search-container">
          <div class="title">
            <h1>공지사항</h1>
            <p>계모임의 소식을 전합니다</p>
          </div>
          <%-- 제목/내용/작성자 기준으로 게시글 검색하는 코드 --%>
          <div class="search-box">
            <form name="search_form" action="/board/getSearchList">
              <select name="type">
                <option selected value="title">제목</option>
                <option value="content">내용</option>
                <option value="name">작성자</option>
              </select>
              <input type="text" name="keyword" value="" placeholder="검색어를 입력하세요."></input>
              <button type="submit">검색</button>
            </form>
          </div>
        </div>
        <table class="table table-hover">
          <colgroup>
            <col width="10%"/>
            <col width="40%"/>
            <col width="15%"/>
            <col width="25%"/>
            <col width="10%"/>
          </colgroup>
          <thead>
          <th>글번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
          </thead>
          <c:forEach var="item" varStatus="status" items="${list}">
            <tr>
              <td>${(paging.total - status.index) - ((paging.nowPage - 1) * 10)}</td>
              <td><a href="read?bid=${item.getBid()}">${item.getTitle()}</a></td>
              <td>${item.getName()}</td>
              <td><fmt:formatDate value="${item.getWriteDate()}" pattern="yyyy-MM-dd"/></td>
              <td>${item.getViews()}</td>
            </tr>
          </c:forEach>
        </table>
        <div class="list-btn-area">
          <input type="button" value="글쓰기" class="btn btn-primary btn-lg px-4 me-sm-3"
                 onclick="location.href='/write'"/>
        </div>
        <ul class="page-list">
          <c:if test="${paging.startPage != 1}">
            <a href="/board/list?nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
          </c:if>
          <c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p">
            <c:choose>
              <c:when test="${p == paging.nowPage}">
                <li>${p}</li>
              </c:when>
              <c:when test="${p != paging.nowPage}">
                <li><a href="/board/list?nowPage=${p }&cntPerPage=${paging.cntPerPage}">${p}</a></li>
              </c:when>
            </c:choose>
          </c:forEach>
          <c:if test="${paging.endPage != paging.lastPage}">
            <a href="/board/list?nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
          </c:if>
        </ul>
      </div>
    </div>
  </div>
</section>

<script>
  let selChange = () => {
    let sel = document.getElementById('cntPerPage').valueOf();
    location.href = "/board/list?nowPage=${paging.nowPage}&cntPerPage=" + sel;
  }
</script>

<%@ include file="../include/footer.jspf" %>

