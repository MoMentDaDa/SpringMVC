<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %><%--
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
    <title>认识jstl 标签库2</title>
</head>
<body>

<%
    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add("ccc");

    Map map = new HashMap();
    map.put("1", "zhongfucheng");
    map.put("2", "xiaohong");
    map.put("3", "xiaoming");
    session.setAttribute("map", map);

    request.setAttribute("list", list);
    request.setAttribute("number", 4);
%>

<h3>if 标签</h3>
<c:if test="${param.name=='wang'}">
    要带参数访问，我的参数为：wang<br>
</c:if>
<br>
<c:if test="${not empty list}">
    遍历集合...
</c:if>
<br>
<c:if test="${number % 2 = 0}">
    ${number}为偶数
</c:if>
<br>


<h3>choose 标签</h3>
<c:choose>
    <c:when test="${number == 1}">星期一</c:when>
    <c:when test="${number == 2}">星期二</c:when>
    <c:when test="${number == 3}">星期三</c:when>
    <c:when test="${number == 4}">星期四</c:when>
    <c:when test="${number == 5}">星期五</c:when>
    <c:when test="${number == 6}">星期六</c:when>
    <c:when test="${number == 7}">星期天</c:when>
    <c:otherwise>数字输入有误</c:otherwise>
</c:choose>
<br>


<h3>foreach 标签</h3>
<c:forEach items="${list}" var="str" varStatus="s">
    ${s.index} ${s.count} ${str}<br>
</c:forEach>
<br>


<h3>遍历Map</h3>
<c:forEach var="me" items="${map}">
    ${me.key}  ${me.value}<br>
</c:forEach>
<br>


<h3>c:forTokens 标签</h3>
<c:forTokens items="zhongfucheng,ouzicheng,xiaoming,xiaohong" var="name" delims=",">
    ${name}<br>
</c:forTokens>
<br>

</body>
</html>
