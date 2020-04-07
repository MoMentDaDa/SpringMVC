<%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/19
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>模拟错误跳转界面</title>
</head>
<body>
这是错误界面，服务器正忙，错误原因如下
<%--  <%
    out.println(exception.getMessage());
  %>--%>

<%--九大内置对象--%>
内置对象：
<%
    out.println(pageContext.getSession());
    out.println(pageContext.getRequest());
    out.println(pageContext.getResponse());
    out.println(pageContext.getServletConfig());
    out.println(pageContext.getServletConfig());
    out.println(pageContext.getOut());
    out.println(pageContext.getServletContext());
    out.println(pageContext.getPage());
%>




</body>
</html>
