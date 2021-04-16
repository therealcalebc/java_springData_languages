<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Languages!</title>
</head>
<body>
	<h1><c:out value="${language.name}"/></h1>
	<p><c:out value="${language.creator}"/></p>
	<p><c:out value="${language.currentVersion}"/></p>
	<a href="/languages/${language.id}/edit">Edit</a>
	<form action="/languages/${language.id}" method="post">
		<input type="hidden" name="_method" value="delete">
		<input type="submit" value="Delete">
	</form>
	<a href="/languages">Dashboard</a>
</body>
</html>