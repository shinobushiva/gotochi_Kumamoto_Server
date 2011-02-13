<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin EditOption</title>
</head>
<body>
<p>Hello admin EditOption !!!</p>
<div><a href="#" onClick="history.back(); return false;">前のページにもどる</a></div>

<form action="submitOption"><input type="hidden" name="id"
	value="${option.key.id}" />
<div><span class="name">Type</span><span class="value"><input
	type="text" name="type" value="${f:h(option.type) }" /></span></div>
<div><span class="name">Text</span><span class="value"><textarea
	name="text" rows="10">${f:h(option.text) }</textarea></span></div>
<div><span class="name">Correctness</span><span class="value"><input
	type="text" name="correctness" value="${option.correctness }" /></span></div>

<div><input type="submit"></input></div>
</form>
</body>
</html>
