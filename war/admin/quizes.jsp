<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin Quizes</title>
</head>
<body>
<p>Hello admin Quizes !!!</p>
<form action="editQuiz"><span><input type="hidden"
	name="pinId" value="${pinId}" /></span><input type="submit" value="問題を作成"></form>
<div><a href="pins">ピンリスト</a></div>
<hr />

<c:forEach var="e" items="${quizes}">
	<div>${e.title}</div>
	<div>
	<form action="editQuiz"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="編集"></form>
	<form action="removeQuiz"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="削除"></form>
	<form action="options"><span><input type="hidden"
		name="quizId" value="${e.key.id}" /></span><input type="submit"
		value="選択肢リスト"></form>
	</div>
	<hr />
</c:forEach>

</body>
</html>
