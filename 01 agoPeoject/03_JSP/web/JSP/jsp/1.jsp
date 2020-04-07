<%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/19
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="utf-8" errorPage="error.jsp" %>
<html>
<head>
    <title>认识和掌握基本用法</title>
</head>
<body>
<%
    String s = "HelloJsp";
    out.println(s);
%>
JSP 输出基本类型：<%=10%>
<%-- 这是JSP 注释--%>
<%--模拟页面错误--%>
<%--<%
    int result = 2 / 2;
%>--%>


<%-- 演示 include 指令 --%>
<%--这是静态演示,静态演示包含同一变量会报错：
<%@include file="head.jsp"%>
<br>
<br>
<br>
<%@include file="foot.jsp"%>--%>
这是动态演示，不会报错：
<%--<jsp:include page="head.jsp">
<jsp:include page="head.jsp">--%>

<%--directive 是代替指令<%@%>的语法，和静态跳转一样高--%>
<jsp:directive.include file="head.jsp"></jsp:directive.include>

<jsp:directive.include file="foot.jsp"></jsp:directive.include>

<%-- 演示跳转--%>
<%-- <jsp:forward page="head.jsp">
     <jsp:param name="name" value="wang"/>
 </jsp:forward>--%>

<%--使用 pageContext 对象,只能在本页面生效，但是可以通过设置作用域范围--%>
<%--<%
    request.setAttribute("name", "wang");
%>
<jsp:forward page="head.jsp"></jsp:forward>--%>


</body>
</html>