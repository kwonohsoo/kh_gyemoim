<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
  <title>게시판</title>
  <style type="text/css">
    li {list-style: none; float: left; padding: 6px;}
  </style>
</head>
<body>

<div id="root">
  <header>
    <h1>게시판</h1>
  </header>
  <hr/>

  <nav>
    홈 - 글 작성
  </nav>
  <hr/>


  <%--items="${listAll} 은 BoardListController에서 이름을 listAll 로 정한 service.listAll() 을 가져온 것
      그리고 var="listAll" 은 ${listAll}을 listAll 이라는 이름으로 선언해준 것--%>
  <%-- action="/board/write" 로 원래는 글 쓰는 곳으로 이동해줘야한다..! 여기서는 일단 boardList.jsp 그대로 적어준다... 나중에 글쓰는 페이지로 수정하기--%>
  <%-- <section> 태그 : HTML 문서에 포함된 독립적인 섹션을 정의할 때 사용--%>
  <section id="container">
    <form role="form" method="get" action="boardRead.jsp">
      <table>
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
            <td>${list.getBid()}</td>
            <td>
              <a href="/board/boardRead?bid=${list.bid}">${list.title}</a>
            </td>
            <td>${list.getName()}</td>
            <td><fmt:formatDate value="${list.getWriteDate()}" pattern="yyyy-MM-dd"/></td>
            <td>${list.getViews()}</td>
          </tr>
        </c:forEach>
      </table>

    </form>
  </section>
  <hr/>
</div>



<div>
  <form action="/board/getSearchList" name="">
    <select name="type">
      <option selected value="title">제목</option>
      <option value="content">내용</option>
      <option value="name">작성자</option>
    </select>
    <input type="text" name="keyword" value=""></input>
    <button type="submit">검색</button>
  </form>
</div>


</body>
</html>
