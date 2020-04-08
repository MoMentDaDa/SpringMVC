<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>列出登录的人</title>
</head>
<body>
<h4>欢迎界面</h4>
<c:forEach items="${applicationScope.map}" var="me">
    ${me.key} <a href="${pageContext.request.contextPath}/Servlet5?username=${me.key}">踢了他吧</a>
    <br>
</c:forEach>
</body>
</html>
