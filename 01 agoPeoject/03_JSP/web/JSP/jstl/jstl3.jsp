<%--
  Created by IntelliJ IDEA.
  User: MoMent
  Date: 2020/3/20
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>请求转发标签</title>
</head>
<body>
<%--<h3>c:url 标签</h3>
<c:url value="jstl1.jsp" var="url">
    <c:param name="name" value="中国！">
    </c:param>
</c:url>
<a href="${url}">我经过了URL地址重写，并且传递了参数过去！</a>
<br>--%>

<%--<h3>c:redirect 标签</h3>
<c:redirect url="jstl1.jsp">
    <c:param name="name" value="wang">
    </c:param>
</c:redirect>
<br>--%>


<h3>import 标签</h3>
<c:import url="http://www.csdn.net" charEncoding="UTF-8" var="net" scope="page"/>
CSDN的源码是：<br><c:out value="${net}"   default="您要的数据找不着" escapeXml="true"/>




<h3>Fmt 标签</h3>
contains:${fn:contains("zhongfucheng",zhong )}<br>
containsIgnoreCase:${fn:containsIgnoreCase("zhongfucheng",ZHONG )}<br>
endsWith:${fn:endsWith("zhongfucheng","eng" )}<br>
escapeXml:${fn:escapeXml("<zhongfucheng>你是谁呀</zhongfucheng>")}<br>
indexOf:${fn:indexOf("zhongfucheng","g" )}<br>
length:${fn:length("zhongfucheng")}<br>
replace:${fn:replace("zhongfucheng","zhong" ,"ou" )}<br>
split:${fn:split("zhong,fu,cheng","," )}<br>
startsWith:${fn:startsWith("zhongfucheng","zho" )}<br>
substring:${fn:substring("zhongfucheng","2" , fn:length("zhongfucheng"))}<br>
substringAfter:${fn:substringAfter("zhongfucheng","zhong" )}<br>
substringBefore:${fn:substringBefore("zhongfucheng","fu" )}<br>
toLowerCase:${fn:toLowerCase("zhonGFUcheng")}<br>
toUpperCase:${fn:toUpperCase("zhongFUcheng")}<br>
trim:${fn:trim("              zhong    fucheng    ")}<br>
<%--将分割成的字符数组用"."拼接成一个字符串--%>
join:${fn:join(fn:split("zhong,fu,cheng","," ),"." )}<br>
<br>


</body>
</html>
