<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Shop application</title></head>
<body>
<form action="/shop/serviceBuyer" method="post">
    <label>Name<input type="text" name="name"/></label>
    <label>Money<input type="text" name="money"/></label>
    <input  type="hidden" name="operation" value="add">
    <input type="submit" name="Submit"/>
</form>
<form action="/shop/serviceBuyer" method="get">
    <input  type="hidden" name="operation" value="view">
    <input type="submit" name="View" value="See buyers"/>
</form>
<c:if test="${buyers != null}">
    <table border="2px">
        <caption border="2px">Buyers info</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Money</th>
        </tr>
<c:forEach items="${buyers}" var="buyer">
    <tr>
        <td>${buyer.id}</td>
        <td>${buyer.name}</td>
        <td>${buyer.money}</td>
    </tr>
</c:forEach>
    </table>
</c:if>

<form action="/shop/serviceCart" method="post">
    <label>Shop<input type="text" name="shop"/></label>
    <label>Buyer Id<input type="text" name="buyerId"/></label>
    <label>Product Id<input type="text" name="productId"/></label>
    <label>Product quantity<input type="text" name="productQuantity"/></label>
    <input  type="hidden" name="operation" value="add">
    <input type="submit" name="Submit"/>
</form>
<form action="/shop/serviceCart" method="get">
    <input  type="hidden" name="operation" value="view">
    <input type="submit" name="View" value="See carts"/>
</form>
<c:if test="${carts != null}">
    <table border="2px">
        <caption border="2px">Carts info</caption>
        <tr>
            <th>Id</th>
            <th>Shop</th>
            <th>Buyer Id</th>
            <th>Product Id</th>
            <th>Product quantity</th>
        </tr>
        <c:forEach items="${carts}" var="cart">
            <tr>
                <td>${cart.id}</td>
                <td>${cart.shop}</td>
                <td>${cart.buyerId}</td>
                <td>${cart.productId}</td>
                <td>${cart.productQuantity}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
