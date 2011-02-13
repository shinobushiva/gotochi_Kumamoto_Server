<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin EditPrizeRule</title>
</head>
<body>
<p>Hello admin EditPrizeRule!!!</p>
<div><a href="#" onClick="history.back(); return false;">前のページにもどる</a></div>

<form action="submitPrizeRule"><input type="hidden" name="id"
	value="${prizeRule.key.id}" />
<div><span class="name">Title</span><span class="value"><input
	type="text" name="title" value="${prizeRule.title }" /></span></div>
<div><span class="name">Script</span><span class="value"><textarea
	rows=10 cols=30 name="script">${prizeRule.script}</textarea></span></div>
<div><span class="name">Message</span><span class="value"><textarea
	rows=10 cols=30 name="message">${prizeRule.message}</textarea></span></div>
<div><span class="name">Item Id</span><span class="value"><input
	type="text" name="itemId" value="${prizeRule.itemKey.id }" /></span></div>

<div><input type="submit"></input></div>
</form>
</body>
</html>
