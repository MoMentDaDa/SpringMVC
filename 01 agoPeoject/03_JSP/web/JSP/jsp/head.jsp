<%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/19
  Time: 21:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" errorPage="error.jsp" %>
<html>
<head>
    <title>认识和掌握基本用法</title>
</head>
<body>
<%
    String s1 = "我是头";
    out.println(s1);
  //  String ss = request.getParameter("name");
  //  out.println("从1.jsp中获取page数据，获取到的参数是："+ss);

%>


<%
    //企图获取request域对象存进的属性
    String value = (String) pageContext.getAttribute("name");
    out.println(value);
%>
<%
    //使用重载的方法获取request域对象的属性
    String value1 = (String) pageContext.getAttribute("name", pageContext.REQUEST_SCOPE);
    out.println(value1);
%>
<%
    //使用findAttribute查找2.jsp中request域对象的属性
    String value2 = (String) pageContext.findAttribute("name");
    out.println(value2);
%>
</body>
</html>
