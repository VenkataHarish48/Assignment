<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Car Details</title>
</head>
<body bgcolor="00a3a3">

<h1 >ENTER THE CAR DETAILS</h1>
<c:out value="${rowAdded}"></c:out>
<form:form method="post" action="cars">
<table>
<tr>
<td>
<form:label path="model">Car model</form:label>
<form:input class="input1" path="model"/>
</td>
</tr>

<tr>
<td>
<form:label path="current_date">Mfd_Year </form:label>
<form:input class="input1" path="current_date"/>
</td>
</tr>


<tr>
<td>
<form:label path="kilometer">Kilometer</form:label>
<form:input class="input1" path="kilometer"/>
</td>
</tr>

<tr>
<td>
<form:label path="brand">Select Brand</form:label>
<form:select path="brand" items="${groups}" />
</td>
</tr>

<tr>
<td>
<form:label path="status">Select Status</form:label>
<form:select path="status" items="${group}" />
</td>
</tr>

<tr>
<td><input type="submit" value="add"/></td>

</tr>
</table>

</form:form>
</body>
</html>