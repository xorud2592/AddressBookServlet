<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/WEB-INF/view/includes/header.jsp"%>
<h3>새 주소 등록</h3>

<div>
	<form action="<c:url value="/"/>" method="POST">
		<label for="name">이름</label> <br/>
		<input type="text" name="name" id="name" /> <br/>
		<label for="tel">휴대전화</label> <br/>
		<input type="text" name="tel" id="tel" /> <br/>
		<label for="hp">집전화</label> <br/>
		<input type="text" name="hp" id="hp" /> <br/>
		<input type="submit" value="주소 등록" />
	</form>
</div>

<%@ include file="/WEB-INF/view/includes/footer.jsp"%>