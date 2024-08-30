<%--
  Created by IntelliJ IDEA.
  User: aydan_3hdj63t
  Date: 8/27/2024
  Time: 10:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<table border="1">
    <thead>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th>FIN</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Birth Date</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="customer" items="${customers}">
        <tr>
            <td>${customer.firstName}</td>
            <td>${customer.lastName}</td>
            <td>${customer.FIN}</td>
            <td>${customer.email}</td>
            <td>${customer.phone}</td>
            <td>${customer.birhtDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

