<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%@ include file="../include/header.jspf" %>

<link href="<c:url value="/resources/dist/css/board/list.css"/>" rel="stylesheet"/>


<div id="root" class="container">
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
        <label for="search-input"></label><input type="text" id="search-input" name="keyword"
                                                 placeholder="검색어를 입력하세요."/>
        <button id="search-button" onclick="formSubmit()">검색</button>
      </form>
    </div>
  </div>

  <%--items="${listAll} 은 BoardListController에서 이름을 listAll 로 정한 service.listAll() 을 가져온 것
      그리고 var="listAll" 은 ${listAll}을 listAll 이라는 이름으로 선언해준 것--%>
  <%-- action="/board/write" 로 원래는 글 쓰는 곳으로 이동해줘야한다..! 여기서는 일단 boardList.jsp 그대로 적어준다... 나중에 글쓰는 페이지로 수정하기--%>
  <%-- <section> 태그 : HTML 문서에 포함된 독립적인 섹션을 정의할 때 사용--%>
  <section id="col-11">
    <form role="form" method="get" action="boardRead.jsp">
      <table class="table table-hover">
        <colgroup>
          <col width="10%"/>
          <col width="40%"/>
          <col width="15%"/>
          <col width="25%"/>
          <col width="10%"/>
        </colgroup>
        <tr>
          <th>게시글 번호</th>
          <th>제목</th>
          <th>작성자</th>
          <th>작성일</th>
          <th>조회수</th>
        </tr>

        <%-- listAll <-- viewAll --%>
        <c:forEach var="list" varStatus="status" items="${listAll}">
          <tr>
            <td>${(paging.total - status.index) - ((paging.nowPage - 1) * 10)}</td>

            <c:choose>
              <c:when test="${list.secret eq 'S'}">
                <c:choose>
                  <c:when test="${list.UNo eq login.UNo}">
                    <td>
                      <a href="read?bid=${list.getBid()}">${list.getTitle()}
                      </a>
                    </td>
                  </c:when>
                  <c:otherwise>
                    <td>
                      <p onclick="secret()">비밀글 입니다.</p>
                    </td>
                  </c:otherwise>
                </c:choose>
              </c:when>

              <c:otherwise>
                <td><a href="read?bid=${list.getBid()}">${list.getTitle()}</a></td>
              </c:otherwise>
            </c:choose>

            <td>${list.getName()}</td>
            <td><fmt:formatDate value="${list.getWriteDate()}" pattern="yyyy-MM-dd"/></td>
            <td>${list.getViews()}</td>
          </tr>
        </c:forEach>
      </table>
    </form>
    <div class="list-btn-area">
      <c:choose>
        <c:when test="${login!=null}">
          <input type="button" value="글쓰기" class="btn btn-primary btn-lg px-4 me-sm-3"
                 onclick="location.href='/write'"/>
        </c:when>
        <c:when test="${login==null}">
          <input type="button" value="글쓰기" class="btn btn-primary btn-lg px-4 me-sm-3"
                 onclick="alert('로그인을 해주세요');"/>
        </c:when>
      </c:choose>
    </div>
    <ul class="page-list">
      <c:if test="${paging.startPage != 1}">
        <a href="/board/getSearchList?keyword=${spv.getKeyword()}&type=${spv.getType()}&nowPage=${paging.startPage - 1}&cntPerPage=${paging.cntPerPage}">&lt;</a>
      </c:if>
      <c:forEach begin="${paging.startPage}" end="${paging.endPage}" var="p">
        <c:choose>
          <c:when test="${p == paging.nowPage}">
            <li>${p}</li>
          </c:when>
          <c:when test="${p != paging.nowPage}">
            <li>
              <a href="/board/getSearchList?keyword=${spv.getKeyword()}&type=${spv.getType()}&nowPage=${p}&cntPerPage=${paging.cntPerPage}&start=${paging.nowPage}&end=${paging.nowPage * 10}">${p}</a>
            </li>
          </c:when>
        </c:choose>
      </c:forEach>
      <c:if test="${paging.endPage != paging.lastPage}">
        <a href="/board/getSearchList?keyword=${spv.getKeyword()}&type=${spv.getType()}&nowPage=${paging.endPage+1 }&cntPerPage=${paging.cntPerPage}">&gt;</a>
      </c:if>
    </ul>
  </section>
  <hr/>
</div>


<%@ include file="../include/footer.jspf" %>
