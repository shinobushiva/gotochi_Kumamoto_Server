<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin Items</title>
</head>
<body>
<p>Hello admin Items !!!</p>

<div><a href="index">トップ</a></div>
<form action="editItem"><input type="submit" value="アイテムを作成"></form>
<hr />
<c:forEach var="e" items="${items}">
	<div>${e.name} ${e.key.id }</div>
	<div>
	<form action="editItem"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="編集"></form>
	<form action="removeItem"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="削除"></form>

	</div>
	<hr />
</c:forEach>

</body>
</html>
