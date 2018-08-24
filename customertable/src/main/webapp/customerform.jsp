<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor="green">

<center>
<h1>Customer Management</h1>

<h2>
<a href="/customertable/CustomerServlet?action=INSERT_OR_EDIT">Add New Customer</a>
&nbsp;&nbsp;&nbsp;
<a href="/customertable/CustomerServlet?action=listCustomers">List All Customers</a>
&nbsp;&nbsp;&nbsp;
<a href="/customertable/CustomerServlet?action=SEARCH">Search</a>
</h2>

</center>




<form action="/customertable/CustomerServlet?action=INSERT_OR_EDIT" method="post" name="ABC">
<div align="center">

<table border="1" cellpadding="5">

<input type="hidden" name="id" size="45" value="<c:out value="${customer.id}" />"/>

<tr>
<th>name: </th>
<td>
<input type="text" name="name" size="45" value="<c:out value="${customer.name}" />"/>
</td>
</tr>

<tr>
<th>mobile: </th>
<td>
<input type="text" name="mobile" size="45" value="<c:out value="${customer.mobile}" />"/>
</td>
</tr>

<tr>
<td colspan="2" align="center">
<input type="submit" value="Save"/>
</td>
</tr>

</table>
</div>
</form>
   
</body>
</html>