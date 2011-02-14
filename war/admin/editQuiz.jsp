<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin EditQuiz</title>
</head>
<body>
<p>Hello admin EditQuiz !!!</p>
<div><a href="#" onClick="history.back(); return false;">前のページにもどる</a></div>

<form action="submitQuiz"><input type="hidden" name="id"
	value="${quiz.key.id}" />
<div><span class="name">Title</span><span class="value"><input
	type="text" name="title" value="${f:h(quiz.title) }" /></span></div>
<div><span class="name">HTML</span><span class="value"><textarea
	name="html" rows="10">${f:h(quiz.html) }</textarea></span></div>
<div><span class="name">Point</span><span class="value"><input
	type="text" name="point" value="${quiz.point }" /></span></div>
<div><span class="name">Order</span><span class="value"><input
	type="text" name="order" value="${quiz.order }" /></span></div>

<div><input type="submit"></input></div>
</form>
</body>
</html>
