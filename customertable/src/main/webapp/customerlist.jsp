<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>

<h1>Customer Management</h1>
<h2>
<a href="/customertable/CustomerServlet?action=INSERT_OR_EDIT">Add Customer</a>
&nbsp;&nbsp;&nbsp;&nbsp;
<a href="/customertable/CustomerServlet?action=listCustomers">List All Customers</a>
&nbsp;&nbsp;&nbsp;
<a href="/customertable/CustomerServlet?action=SEARCH">Search</a>
</h2>


<div align="center">

<table border="1" cellpadding="5">

<caption><h2>List of Customers</h2></caption>

<tr>
<th>Id</th>
<th>Name</th>
<th>Mobile</th>
<th colspan="2">Actions</th>
</tr>

<c:forEach var="customer" items="${customers}">

<tr>
<td><c:out value="${customer.id}"/></td>
<td><c:out value="${customer.name}"/></td>
<td><c:out value="${customer.mobile}"/></td>
<td><a href="CustomerServlet?action=edit&id=<c:out value='${customer.id}'/>">Edit</a></td>
&nbsp;&nbsp;&nbsp;&nbsp;
<td><a href="CustomerServlet?action=delete&id=<c:out value='${customer.id}'/>">Delete</a></td>


</tr>
</c:forEach>
</table>
</div>
</center>
</body>
</html>