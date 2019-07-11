<%--
  Created by IntelliJ IDEA.
  User: barryfan
  Date: 6/19/19
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改mock</title>
</head>
<body>
    <form action="/mock/data/modify">
        uri: <input name="uri"><br>
        method: <input name="method"><br>
        text: <input name="text"><br>
        contentType: <input name="content-type"><br>
        <button type="submit">修改</button>
    </form>
</body>
</html>
