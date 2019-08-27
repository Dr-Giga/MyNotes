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
<h2>Find Note</h2>
<p style="color: red;">${errorString}</p>

<table border="1" cellpadding="5" cellspacing="1" >
    <tr>
        <th>Title Note</th>
        <th>Body Note</th>
        <th>Delete</th>
    </tr>
    <c:forEach items="${noteList}" var="note" >
        <tr>
            <td>${note.titleNote}</td>
            <td>${note.bodyNote}</td>

            <td>
                <a href="deleteNote?titleNote=${note.titleNote}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>


<p style="color: red;">${errorString}</p>

<form method="POST" action="${pageContext.request.contextPath}/findNote">
    <table border="0">
        <tr>
            <td>Note</td>
            <td><input type="text" name="word" value="${note.word}" /></td>
        </tr>

        <tr>
            <td colspan="2">
                <input type="submit" value="Submit" />
                <a href="mainPage">Cancel</a>
            </td>
        </tr>
    </table>

</form>


<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>