<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin PrizeRules</title>
</head>
<body>
<p>Hello admin PrizeRules !!!</p>

<div><a href="index">トップ</a></div>
<form action="editPrizeRule"><input type="submit" value="ルールを作成"></form>
<hr />
<c:forEach var="e" items="${prizeRules}">
	<div>${e.title}</div>
	<div>
	<form action="editPrizeRule"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="編集"></form>
	<form action="removePrizeRule"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="削除"></form>
	</div>
	<hr />
</c:forEach>

</body>
</html>
