<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin EditItem</title>
</head>
<body>
<p>Hello admin EditItem !!!</p>
<div><a href="#" onClick="history.back(); return false;">前のページにもどる</a></div>

<form action="submitItem"><input type="hidden" name="id"
	value="${item.key.id}" />
<div><span class="name">Name</span><span class="value"><input
	type="text" name="name" value="${item.name }" /></span></div>
<div><span class="name">Description</span><span class="value"><textarea
	rows=10 name="description">${f:h(item.description) }</textarea></span></div>
<div><span class="name">ImageURL</span><span class="value"><input
	type="text" name="imageUrl" value="${item.imageUrl }" /></span></div>

<div><input type="submit"></input></div>
</form>
</body>
</html>
