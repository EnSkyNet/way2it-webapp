<%@page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head><title>Shop application</title></head>
<body>
<h5>Buyers</h5>
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
<h5>Carts</h5>
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
<h5>Orders</h5>
<form action="/shop/serviceOrder" method="post">
    <label>Total<input type="text" name="total"/></label>
    <label>Buyer Id<input type="text" name="buyerId"/></label>
    <input  type="hidden" name="operation" value="add">
    <input type="submit" name="Submit"/>
</form>
<form action="/shop/serviceOrder" method="get">
    <input  type="hidden" name="operation" value="view">
    <input type="submit" name="View" value="See orders"/>
</form>
<c:if test="${orders != null}">
    <table border="2px">
        <caption border="2px">Carts info</caption>
        <tr>
            <th>Id</th>
            <th>Total</th>
            <th>Buyer Id</th>
        </tr>
        <c:forEach items="${orders}" var="order">
            <tr>
                <td>${order.id}</td>
                <td>${order.total}</td>
                <td>${order.buyerId}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h5>Products</h5>
<form action="/shop/serviceProduct" method="post">
    <label>Name<input type="text" name="name"/></label>
    <label>Price<input type="text" name="price"/></label>
    <input  type="hidden" name="operation" value="add">
    <input type="submit" name="Submit"/>
</form>
<form action="/shop/serviceProduct" method="get">
    <input  type="hidden" name="operation" value="view">
    <input type="submit" name="View" value="See products"/>
</form>
<c:if test="${products != null}">
    <table border="2px">
        <caption border="2px">Carts info</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Price</th>
        </tr>
        <c:forEach items="${products}" var="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
<h5>Salers</h5>
<form action="/shop/serviceSaler" method="post">
    <label>Name<input type="text" name="name"/></label>
    <input  type="hidden" name="operation" value="add">
    <input type="submit" name="Submit"/>
</form>
<form action="/shop/serviceSaler" method="get">
    <input  type="hidden" name="operation" value="view">
    <input type="submit" name="View" value="See salers"/>
</form>
<c:if test="${salers != null}">
    <table border="2px">
        <caption border="2px">Salers info</caption>
        <tr>
            <th>Id</th>
            <th>Name</th>
        </tr>
        <c:forEach items="${salers}" var="saler">
            <tr>
                <td>${saler.id}</td>
                <td>${saler.name}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
