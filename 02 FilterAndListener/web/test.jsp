<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>认识过滤器</title>
</head>
<body>
<h4>过滤器应用示例---编码过滤器</h4>
<form action="${pageContext.request.contextPath}/Servlet1" method="post">
    <input type="hidden" name="username" value="中国">
    <input type="text" name="password">
    <input type="submit" value="提交">
</form>
<br>
<br>
<h4>过滤器应用示例---全站压缩</h4>
<a href="${pageContext.request.contextPath }/Servlet2">请求第二个servlet--用过滤器压缩输出字节流数据</a><br/><br/>
<a href="${pageContext.request.contextPath }/Servlet2">请求第三个servlet--用过滤器压缩输出字符流数据</a><br/><br/>
<br>
<br>
<h4>过滤器应用示例---敏感词过滤器</h4>
<form action="${pageContext.request.contextPath}/Servlet1" method="post">
    <input type="hidden" name="username" value="中国">
    <input type="text" name="password">
    <input type="submit" value="提交">
</form>
<br>
<br>

<h4>过滤器应用示例---HTML转义</h4>
<form action="${pageContext.request.contextPath}/Servlet2" method="post">
    留言:
    <textarea rows="8" cols="70" name="message">
          <%-- <script type="text/javascript">
            while (true) {
                alert("死循环了，我会不停地弹出了");
            }
          </script>--%>
        <a href="http://www.cnblogs.com">访问博客园</a>
            </textarea>
    <input type="hidden" name="username" value="<h1>你好i好<h1>">
    <input type="submit" value="发表">
</form>
</body>
</html>
