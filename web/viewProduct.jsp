<%-- 
    Document   : viewProduct
    Created on : Nov 5, 2019, 11:33:54 AM
    Author     : NguyenDinhTien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Products</h1>
        <table cellspacing="5" cellpadding="5" border="1">
            <tr>
                <th>IDcode</th>
                <th>Tên sách</th>
                <th>Tên tác giả</th>
                <th>Năm xuất bản</th>
                <th>Số trang</th>
                <th>Giá</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            <c:forEach var="i" items="${listProduct}" varStatus="k">
                <tr>
                    <td><c:out value="${i.IDcode}"></c:out></td>
                    <td><c:out value="${i.name}"></c:out></td>
                    <td><c:out value="${i.author}"></c:out></td>
                    <td><c:out value="${i.date}"></c:out></td>
                    <td><c:out value="${i.numberPage}"></c:out></td>
                    <td><c:out value="${i.price}"></c:out></td>
                    <td><a href="<c:url value="/editProduct?IDcode=${i.IDcode}"></c:url>">Edit</a></td>
                    <td><a href="<c:url value="/deleteProduct?IDcode=${i.IDcode}"></c:url>">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <button onclick="window.location.href = '/addProduct'">AddProduct</button>
    </body>
</html>
