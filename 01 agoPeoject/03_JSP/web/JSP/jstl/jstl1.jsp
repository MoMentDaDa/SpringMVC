<%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/20
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>认识jstl 标签库</title>
</head>
<body>

<%-- <c:out/>标签支持标签体，default属性上的数据可以写在标签体中 --%>
<h3>out 标签</h3>
<%
    session.setAttribute("name", "汪哒哒");
%>
<%--<c:out value="${name}" escapeXml="true">您要的数据找不着</c:out>--%>
<c:out value="${name}" default="您要的数据找不着" escapeXml="true"/>
<%--escapeXml="false"表示value值中的html标签不进行转义，而是直接输出,默认不转 --%>
<c:out value="&lt未使用字符转义&gt" escapeXml="false" />
<%--  使用了转义字符&lt和&gt分别转换成<和>符号。 --%>
<c:out value="&lt使用字符转义&gt" escapeXml="true"/>
<br>
<br>

<%--由于下面变量需要做加法运算，所以要定义出来，不然服务器是不知道我的变量是Integer类型的 --%>
<h3>set 标签</h3>
<% Integer sessionCount = 0;Integer applicationCount = 0; %>
<c:set var="sessionCount" value="${sessionCount+1}" scope="session"/>
<c:set var="applicationCount" value="${applicationCount+1}" scope="application"/>
你一共访问该页面：${sessionCount}<br>
你一共访问该页面：${applicationCount}<br>
<br>

<%--创建出JavaBean对象，设置为session范围的属性--%>
<h3>target 标签</h3>
<jsp:useBean id="person" class="domian.user2" scope="session"/>
<%--获取到person对象，设置age属性的值为32--%>
<c:set target="${person}" property="age" value="32"/>
user年龄为：${person.age}<br>
<br>

<%-- catch异常标签--%>
<h3>catch 异常标签</h3>
<c:catch var="message">
    <%--target属性只能是EL表达式，现在我是字符串，获取不到对象，肯定会抛出异常的！--%>
    <c:set target="person" property="age" value="32"/>
</c:catch>
错误信息为：${message}
<br>

<%--删除session属性--%>
<h3>remove 标签</h3>
<c:remove var="person" scope="page"></c:remove>
${person.age==null?"存在session的person对象被删除了！":"我还在呢！"}
<br>



</body>
</html>
