<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/20
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL 运算符</title>
</head>
<body>
<h4>el表达式进行四则运算：</h4>
加法运算：${365+24}<br/>
减法运算：${365-24}<br/>
乘法运算：${365*24}<br/>
除法运算1：${3/4}<br/>
除法运算2：${3 div 4}<br>
取余运算1：${3 % 4}<br>
取余运算2：${3 mod 4}<br>

<h4>el表达式进行关系运算：</h4>
<%--${user == null}和 ${user eq null}两种写法等价--%>
${3 == 4}<br>
${3 > 4}<br>
${3 < 4}<br>
${user == null}<br/>
${user eq null}<br/>

<h4>逻辑运算符</h4>
与操作赋：${3 > 4  && 3 < 4}<br>
或操作赋：${3 > 4  and 3 < 4}<br>
非操作赋：${!false}<br>
三目运算符：${3>2?3:2}<br>

<h4>empty运算符</h4>
<p>有三种情况为空，为null，空串或者串的长度为零的</p>
<%
    String str = "";
    request.setAttribute("str",str);
    List list = new ArrayList();
    request.setAttribute("list",list);
%>
${not empty str}<br>
${not empty list}<br>
${empty null }<br>
${!empty null }<br>
${not empty null }<br>

</body>
</html>
