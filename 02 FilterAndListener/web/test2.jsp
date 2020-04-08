<%@ page import="Listener.listenerDemo5" %>
<%@ page import="Listener.listenerDemo6" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    //往session域对象中添加属性
    session.setAttribute("aa", "bb");
    //替换session域对象中aa属性的值
    session.setAttribute("aa", "xx");
    //移除session域对象中aa属性
    session.removeAttribute("aa");

    //往request域对象中添加属性
    request.setAttribute("aa", "bb");
    //替换request域对象中aa属性的值
    request.setAttribute("aa", "xx");
    //移除request域对象中aa属性
    request.removeAttribute("aa");
%>
<h4>感知Session 绑定的事件监听器</h4>
<%--<%
    //将javabean对象绑定到Session中
    session.setAttribute("bean", new listenerDemo5("汪哒哒"));
    //从Session中删除javabean对象
    session.removeAttribute("bean");
%>--%>
<br>
<br>
<h4>测试钝化和活化</h4>
一访问JSP页面，HttpSession就创建了，创建好的Session的Id是：
<hr/>
<%--<%
    session.setAttribute("bean2", new listenerDemo6("汪哒哒"));
%>--%>
<br>
<br>
<h4>统计在线人数</h4>
<br>
在线人数：${num}
<br>
<br>
<h4>在线踢人小案例</h4>
<form action="${pageContext.request.contextPath }/Servlet4" method="post">
    用户名：<input type="text" name="username">
    <input type="submit" value="登陆">
</form>
</body>
</html>
