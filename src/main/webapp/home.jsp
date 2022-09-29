<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Shop application</title></head>
<body>
<form action="/shop/serviceShop" method="post">
    <label>Name<input type="text" name="name"/></label>
    <label>Money<input type="text" name="money"/></label>
    <input  type="hidden" name="operation" value="add">
    <input type="submit" name="Submit"/>
</form>
<form action="/shop/serviceShop" method="get">
    <input  type="hidden" name="operation" value="view">
    <input type="submit" name="View" value="See buyers"/>
</form>
<c:if test="${buyers != null}">
    <table border="2px">
        <tr>
            <th>Name</th>
            <th>Money</th>
        </tr>
<c:forEach items="${buyers}" var="buyer">
    <tr>
        <td>${buyer.name}</td>
        <td>${buyer.money}</td>
    </tr>
</c:forEach>
    </table>
</c:if>
</body>
</html>
