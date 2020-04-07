<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script>
        window.onload = function () {
            var myselect = document.getElementById("add");
            var length = myselect.length;
            for (i = 0; i < length; i++) {
                var value = myselect.options[i].value;
                if (value == "${user.address}") {
                    myselect.options[i].selected = true;
                }
            }

            var myRadio = document.getElementsByClassName("radio");
            if (myRadio[0].value == "${user.gender}") {
                myRadio[0].setAttribute("checked", true);
            } else {
                myRadio[1].setAttribute("checked", true);
            }
        }
    </script>
</head>
<body>
<div class="container" style="width: 400px;">
    <h3 style="text-align: center;">修改联系人</h3>
    <form action="${pageContext.request.contextPath}/updateUserServlet" method="post">
        <!--  隐藏域 提交id-->
        <input type="hidden" name="id" value="${user.id}">

        <div class="form-group">
            <label for="name">姓名：</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}" readonly="readonly" placeholder="请输入姓名"/>
        </div>

        <div class="form-group">
            <label>性别： </label>
            <input type="radio" class="radio" name="gender" value="男" style="display: inline;"/>男
            <input type="radio" class="radio" name="gender" value="女" style="display: inline;"/>女
        </div>
        <br>
        <div class=" form-group">
            <label for="age">年龄：</label>
            <input type="text" class="form-control" value="${user.age}" id="age" name="age" placeholder="请输入年龄"/>
        </div>

        <div class="form-group()">
            <label>籍贯：</label>
            <select name="address" id="add">
                <option value="陕西">陕西</option>
                <option value="北京">北京</option>
                <option value="深圳">深圳</option>
                <option value="南京">南京</option>
                <option value="南京">南京</option>
                <option value="杭州">杭州</option>
                <option value="山西">山西</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ：</label>
            <input type="text" id="qq" class="form-control" value="${user.qq}" name="qq" placeholder="请输入QQ号码"/>
        </div>

        <div class="form-group">
            <label for="email">Email：</label>
            <input type="text" id="email" class="form-control" value="${user.email}" name="email" placeholder="请输入邮箱地址"/>
        </div>
        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交"/>
            <input class="btn btn-default" type="reset" value="重置"/>
            <input class="btn btn-default" type="button" value="返回"/>
        </div>
    </form>
</div>
</body>
</html>