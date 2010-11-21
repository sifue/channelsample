<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Channel API Sample</title>
<script type="text/javascript" src="/js/channel.js"></script>
<script type="text/javascript" src="/js/jquery-1.4.3.min.js"></script>
<script type="text/javascript">
<!--
	// Global
	channelToken = "${f:h(channelToken)}";
//-->
</script>
<script type="text/javascript" src="/js/message.js"></script>
</head>
<body>
<p>Channel Token is "${f:h(channelToken)}"</p>
<p>Please input message for other user</p>
<form>
<textarea id="textarea_value"></textarea><br />
<input type="button" value="Send message to other user" onclick="myapp.postMessage()"/>
</form>
</body>
</html>
