<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/includes/header.jsp"%>

<jsp:include page="/WEB-INF/view/includes/nav.jsp" />
<form action="<c:url value="/"/>">
	<input type="hidden" name="a" value="search" /> <label
		for="searchName">검색어</label> <input type="text" name="searchName"
		id="searchName" /> <input type="submit" value="검색" />
</form>
<br />

<table border=1>
	<tr style="background: lightgray">
		<th width="100">이름</th>
		<th width="200">휴대전화</th>
		<th width="200">전화번호</th>
		<th width="100">도구</th>
	</tr>
	<c:forEach items="${ list }" var="vo">
		<tr align="center">
			<td>${ vo.name }</td>
			<td>${ vo.showTel()}</td>
			<td>${ vo.showHp() }</td>
			<td colspan="2">
				<form action="<c:url value="/?a=delete"/>">
					<input type="hidden" name="a" value="delete" /> <input
						type="hidden" name="id" value="${ vo.id }" /> <input
						type="submit" value="삭제" />
				</form>
			</td>
		</tr>
	</c:forEach>
</table>

<p>
	<a href="<c:url value="/?a=form"/>">새 주소 추가</a>
</p>
<%@ include file="/WEB-INF/view/includes/footer.jsp"%>
