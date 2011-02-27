<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>選択肢のリスト</title>
</head>
<body>
<div><a href="index">トップ</a></div>
<div><a href="pins">ピンのリスト</a></div>
<h2>選択肢のリスト</h2>
<form action="editOption"><span><input type="hidden"
	name="quizId" value="${quizId}" /></span><input type="submit" value="選択肢を作成"></form>
<hr />

<c:forEach var="e" items="${options}">
	<div>${f:h(e.text)}</div>
	<div>
	<form action="editOption"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="編集"></form>
	<form action="removeOption"><span><input type="hidden"
		name="id" value="${e.key.id}" /></span><input type="submit" value="削除"></form>
	</div>
	<hr />
</c:forEach>

</body>
</html>
