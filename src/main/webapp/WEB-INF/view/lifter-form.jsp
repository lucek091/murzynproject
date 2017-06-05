<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>
    <title>Save Lifter</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">

    <link type="text/css" rel="stylesheet"
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">

</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>LRM - Lifter Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <h3>Save Lifter</h3>

    <form:form action="saveLifter" modelAttribute="lifter" method="post">
        <%--need to associate this data with lifter id--%>
        <form:hidden path="id"/>
        <table>
            <tbody>
            <tr>
                <td><label>First name:</label></td>
                <td><form:input path="firstName"></form:input></td>
            </tr>
            <tr>
                <td><label>Last name:</label></td>
                <td><form:input path="lastName"></form:input></td>
            </tr>
            <tr>
                <td><label>Email name:</label></td>
                <td><form:input path="email"></form:input></td>
            </tr>

            <tr>
                <td><label></label></td>
                <td><input type="submit" value="Save" class="save"/></td>
            </tr>
            </tbody>
        </table>


    </form:form>
    <div style="clear; both;"></div>
    <p>
        <a href="${pageContext.request.contextPath}/lifter/list">Back to the List</a>
    </p>
</div>

</body>
</html>
