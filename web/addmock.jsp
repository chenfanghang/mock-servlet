<%--
  Created by IntelliJ IDEA.
  User: barryfan
  Date: 6/17/19
  Time: 8:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>添加mock</title>
  </head>
  <body>
    <form action="/mock/data/add">
      uri: <input name="uri"><br>
      method: <input name="method"><br>
      text: <input name="text"><br>
      contentType: <input name="content-type"><br>
      <button type="submit">添加</button>
    </form>
  </body>
</html>
