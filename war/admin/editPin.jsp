<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<LINK href="/css/jagkuma.css" rel="stylesheet" type="text/css">
<title>admin EditPin</title>
</head>
<body>
<p>Hello admin EditPin !!!</p>
<div><a href="#" onClick="history.back(); return false;">前のページにもどる</a></div>

<form action="submitPin"><input type="hidden" name="id"
	value="${pin.key.id}" />
<div><span class="name">Name</span><span class="value"><input
	type="text" name="name" value="${pin.name }" /></span></div>
<div><span class="name">Latitude</span><span class="value"><input
	type="text" name="latitude" value="${pin.latitude }" /></span></div>
<div><span class="name">Longitude</span><span class="value"><input
	type="text" name="longitude" value="${pin.longitude }" /></span></div>
<div><span class="name">Altitude</span><span class="value"><input
	type="text" name="altitude" value="${pin.altitude }" /></span></div>
<div><span class="name">Type</span><span class="value"><input
	type="text" name="type" value="${pin.type }" /></span></div>
<div><span class="name">AreaCode</span><span class="value"><input
	type="text" name="areaCode" value="${pin.areaCode }" /></span></div>
<div><span class="name">PrefCode</span><span class="value"><input
	type="text" name="prefCode" value="${pin.prefCode }" /></span></div>
<div><span class="name">Point</span><span class="value"><input
	type="text" name="point" value="${pin.point }" /></span></div>
<div><span class="name">URL</span><span class="value"><input
	type="text" name="url" value="${pin.url }" /></span></div>

<div><input type="submit"></input></div>
</form>
</body>
</html>
