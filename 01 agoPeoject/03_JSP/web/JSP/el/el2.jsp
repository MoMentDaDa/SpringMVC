<%@ page import="domian.user2" %>
<%@ page import="java.util.*" %><%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/20
  Time: 11:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EL 获取数据</title>
</head>
<body>
<%-- 在四个域对象中存储数据 --%>
<%
    //在域中存储数据
    pageContext.setAttribute("name","王麻子");
    session.setAttribute("name", "李四");
    request.setAttribute("name", "张三");
    session.setAttribute("age", "23");
    request.setAttribute("str", "");
%>
<%--${name}等同于pageContext.findAttribute("name") --%>

<h3>el获取域中值</h3>
${requestScope.name}<br>
${sessionScope.age}<br>
找不到默认输出空：${sessionScope.haha}<br>
不指定范围，按从小到大找：${name}<br>
${sessionScope.name}<br>
<br>
<br>
<!-- 在jsp页面中，使用el表达式可以获取bean，和集合的属性 -->
<%
    user2 u = new user2();
    u.setName("张三");
    u.setAge(23);
    u.setBirthday(new Date());
    request.setAttribute("u", u);

    List list = new ArrayList();
    list.add("aaa");
    list.add("bbb");
    list.add(u);
    request.setAttribute("list", list);

    Map map = new HashMap();
    map.put("sname", "李四");
    map.put("gender", "男");
    map.put("user", u);
    request.setAttribute("map", map);

%>

<br>
使用el表达式可以获取bean和集合的属性：${u.age}
<h3>el获取对象中的值</h3>
${requestScope.u}<br>
${requestScope.u.name}<br>
${u.age}<br>
${u.birthday.month}<br>
${u.birStr}<br>
<br>

<h3>el获取List值</h3>
${list}<br>
${list[0]}<br>
${list[1]}<br>
${list[10]}<br>
${list[2].name}<br>
<br>
<h3>el获取Map值</h3>
${map.gender}<br>
${map["gender"]}<br>
${map.user.name}<br>


<h3>获取请求参数，访问带 username='switch'&password='123456'</h3>
${param.username }<br/>
${paramValues.username[0] }<br/>
${paramValues.password[0] }<br/>
</body>
</html>
