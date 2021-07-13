<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Show Customer</title>
</head>
<body>
   
<table>
    <tr>
        <th>Model</th>
        <th>Date Of Manufacture</th>
        <th>Kilometers Travelled</th>
          <th>Brand</th>
        <th>Status</th>
    </tr>
    <c:forEach items="${list}" var="eachItem">
    <tr>
        <td><c:out value="${eachItem.model}"></c:out></td>
        <td><c:out value="${eachItem.current_date}"></c:out></td>
        <td><c:out value="${eachItem.kilometers}"></c:out></td>
         <td><c:out value="${eachItem.brand}"></c:out></td>
     
        <td><c:out value="${eachItem.status}"></c:out></td>
    
    </tr>
    </c:forEach>
</table>
</body>
</html>