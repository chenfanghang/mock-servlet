<%--
  Created by IntelliJ IDEA.
  User: barryfan
  Date: 6/19/19
  Time: 8:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<table border="1">
    <thead>
    <tr>
        <th>地址</th>
        <th>请求方法</th>
        <th>返回值</th>
        <th>内容类型</th>
    </tr>
    </thead>

    <tbody>

    <c:forEach items="${mocklist}" var="mockContentSingle">

        <tr>
            <td>${mockContentSingle.requestContent.uri}</td>
            <td>${mockContentSingle.requestContent.method}</td>
            <td>${mockContentSingle.responseContent.text}</td>
            <td>${mockContentSingle.responseContent.contentType}</td>
        </tr>

    </c:forEach>
    </tbody>
</table>
</body>
</html>
