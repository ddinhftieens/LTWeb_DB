<%-- 
    Document   : editProduct
    Created on : Nov 5, 2019, 11:36:08 AM
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
        <h1>Update</h1>
        <h2 id="vadidate" style="color: red"></h2>
        <form action="/editProduct" method="post">
            <table border="1">
                <tr>
                    <td>IDcode</td>
                    <td><input type="text" name="IDcode" value="${product.IDcode}" placeholder="IDcode" readonly=""></td>
                </tr>
                <tr>
                    <td>Tên sách</td>
                    <td><input type="text" name="name" value="${product.name}" placeholder="Tên sách"></td>
                </tr>
                <tr>
                    <td>Tên tác giả</td>
                    <td><input type="text" name="author" value="${product.author}" placeholder="Tên tác giả"></td>
                </tr>
                <tr>
                    <td>Năm xuất bản</td>
                    <td><input type="number" name="date" value="${product.date}" placeholder="Năm xuất bản"></td>
                </tr>
                <tr>
                    <td>Số trang</td>
                    <td><input type="number" name="numberpage" value="${product.numberPage}" placeholder="Số trang"></td>
                </tr>
                <tr>
                    <td>Giá</td>
                    <td><input type="number" name="price" value="${product.price}" placeholder="Giá"></td>
                </tr>
            </table>
                <br>
            <table>
                <tr>
                    <td><button type="button" onclick="vadidate(this.form)">Update Product</button></td>
                    <td><button><a href="<c:url value="/product"></c:url>">View Product</a></button></td>
                </tr>
            </table>
        </form>
        <script>
            function vadidate(form){
                if(form.IDcode.value ==""){
                    document.getElementById("vadidate").innerText = 'You must enter a IDcode for this product';
                }
                else if(form.name.value ==""){
                    document.getElementById("vadidate").innerText = 'You must enter a name for this product';
                }
                else if(form.author.value ==""){
                    document.getElementById("vadidate").innerText = 'You must enter a author for this product';                    
                }
                else if(form.date.value ==""){
                    document.getElementById("vadidate").innerText = 'You must enter a date for this product';                   
                }
                else if(form.numberpage.value ==""){
                    document.getElementById("vadidate").innerText = 'You must enter a page number for this product';                    
                }
                else if(form.price.value ==""){
                    document.getElementById("vadidate").innerText = 'You must enter a price for this product';                   
                }
                else{
                    form.submit();
                }
            }
        </script>
    </body>
</html>
