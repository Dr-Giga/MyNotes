<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">

</head>
<body>

<jsp:include page="_header.jsp"></jsp:include>


<h1></h1>

<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Title Note</th>
        <th>Body Note</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${productList}" var="product" >
        <tr>
            <td>${product.name}</td>
            <td>${product.price}</td>

            <td>
                <a href="deleteProduct?code=${product.code}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>

<a href="newNote" >New Note</a>
<br>
<a href="findNote" >Find Note</a>

<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>