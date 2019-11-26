<%-- 
    Document   : deleteProduct
    Created on : Nov 5, 2019, 11:37:22 AM
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
        <h1>Are you sure want to delete this product ?</h1>
        <form action="<c:url value="/deleteProduct"></c:url>" method="post">
            <table border: 1px solid black>
                <tr>
                    <td>IDcode</td>
                    <td><c:out value="${product.IDcode}"></c:out></td>
                </tr>
                <tr>
                    <td>Tên sách</td>
                    <td><c:out value="${product.name}"></c:out></td>
                </tr>
                <tr>
                    <td>Tên tác giả</td>
                    <td><c:out value="${product.author}"></c:out></td>
                </tr>
                <tr>
                    <td>Năm xuất bản</td>
                    <td><c:out value="${product.date}"></c:out></td>
                </tr>
                <tr>
                    <td>Số trang</td>
                    <td><c:out value="${product.numberPage}"></c:out></td>
                </tr>
                <tr>
                    <td>Giá</td>
                    <td><c:out value="${product.price}"></c:out></td>
                </tr>
                <tr>
                    <td><button type="submit">Yes</button></td>
                    <td><button><a href="<c:url value="/product"></c:url>">No</a></button></td>
                </tr>
            </table>
        </form>
    </body>
</html>
