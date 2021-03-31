<%@page import="com.ltk.addressbook.dao.AddressVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:choose>
	<c:when test="${searchName != null }">
		<h3>목록 (검색어: ${ searchName })</h3>
	</c:when>
	<c:otherwise>
		<h3>목록</h3>
	</c:otherwise>
</c:choose>