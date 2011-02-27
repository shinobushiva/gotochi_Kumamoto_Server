<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/dataSheet.css" rel="stylesheet" type="text/css">
<title>ピンとクイズのデータ管理</title>
</head>
<body>
<div><a href="../">トップ</a></div>
<h2>ピンとクイズのデータ管理</h2>


<h3>データを取得します</h3>
<div class="block"><a href="getQuizSheet">データシートをダウンロード</a></div>

<h3>データを更新します</h3>
<div class="block">
<form action="uploadQuizSheet" method="POST"
	enctype="multipart/form-data">
<div class="comment">${comment}</div>
<div>ファイルをアップロード</div>
<div><input type="file" name="formFile" /><input type="submit"
	value="送信" /></div>
<div class="template"><a href="getQuizTemplate">テンプレートをダウンロード</a></div>
</form>
</div>

</body>
</html>
