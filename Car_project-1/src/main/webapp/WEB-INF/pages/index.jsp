<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
                  
<head>
<meta charset="ISO-8859-1">
<title>Car Details</title>
</head>

				
					
<body bgcolor="#ff8ac4">
<h1 style="text-align:center" >
<c:out value="${TitleName}"/>
</h1>

<div class="a">
<a href="cars">Add Cars</a><br>
<a href="cars/all">View Cars</a><br>
<a href="cars/status">show available cars</a><br>
<a href="cars/showBrand"> view cars by brand</a>
</div>

</body>
</html>