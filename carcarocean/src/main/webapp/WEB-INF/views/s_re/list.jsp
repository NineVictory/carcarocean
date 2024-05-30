<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매후기게시판 목록</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
<jsp:include page="/WEB-INF/views/common/header.jsp" />
</head>
<body>
<div class="page-main">
	<div class="content-main">
		<h2>판매후기게시판 목록</h2>
		<form id="search_form" action="list.do" method="get">
			<ul class="search">
				<li>
					<select name="keyfield">
						<%-- c:if와 selected를 쓰는건 검색을 계속 유지 시키기 위해서 --%>
						<option value="1" <c:if test="${param.keyfield ==1}">selected</c:if>>제목</option>
						<option value="2" <c:if test="${param.keyfield ==2}">selected</c:if>>작성자</option>
						<option value="3" <c:if test="${param.keyfield ==3}">selected</c:if>>제조사</option>
					</select>
				</li>
				<li>
				<input type="search" size="16" name="keyword" id="keyword" value="${param.keyword}">
				</li>
				<li>
				<input type="submit" value="검색">
				
				</li>
				
			</ul>
		</form>
		<div class="list-space align-right">
			<input type="button" value="글쓰기" 
				onclick="location.href='writeForm.do'"	
					<c:if test="${empty user_num}">disabled="disabled" </c:if> <%-- 비홯성화 시키는 법 --%>
			> <!-- input 닫는 꺽쇄 -->
			<input type="button" value="목록" onclick="location.href='list.do'">
			<input type="button" value="홈으로" onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>
		<c:if test="${count==0}">
		<div class="result-display">
			표시할 게시물이 없습니다.
		</div>
		</c:if>
		<c:if test="${count>0}">
			<table>
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>차명/제조사</th>
					<th>작성일</th>
				</tr>
				<c:forEach var="s_re" items="${list}">
				<tr>
					<td>${s_re.s_re_num}</td>
					<td><a href="detail.do?s_re_num=${s_re.s_re_num}"><b>${s_re.s_re_title}</b></a></td>
					<td>${s_re.mem_id}</td>
					<td>${s_re.sell_cname} / ${s_re.sell_maker}</td>
					<td> ${s_re.s_re_reg} </td>
					
					
				</tr>
				</c:forEach>
			</table>
			<div class="align-center">${page}</div>
		</c:if>
	</div>
</div>
</body>
</html>