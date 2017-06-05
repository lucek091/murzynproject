<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>

<html>
<head>
    <title>List Lifters</title>

    <%--reference our style sheet--%>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>LRM - Lifters Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">

        <%--put new button: Add lifter--%>
        <input type="button" value="Add Lifter"
            onclick="window.location.href='showFormForAdd'; return false;"
            class="add-button"/>

            <%--add a search box--%>
            <form:form action="search" method="POST">Search lifter: <input type="text" name="theSearchName" />

            <input type="submit" value="Search" class="add-button" />
            </form:form>

        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Action</th>
            </tr>

         <c:forEach var="tempLifter" items="${lifters}">
             <%--construct an update link with lifter id--%>

             <c:url var="updateLink" value="/lifter/showFormForUpdate">
                 <c:param name="lifterId" value="${tempLifter.id}">
                 </c:param>
             </c:url>

             <c:url var="deleteLink" value="/lifter/delete">
                 <c:param name="lifterId" value="${tempLifter.id}">
                 </c:param>
             </c:url>

            <tr>
                <td>${tempLifter.firstName}</td>
                <td>${tempLifter.lastName}</td>
                <td>${tempLifter.email}</td>
                <td>
                    <%--display the update link--%>
                    <a href="${updateLink}">Update</a>
                        |
                    <a href="${deleteLink}" onclick="if
                    (!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>


                </td>
            </tr>
         </c:forEach>
        </table>

    </div>

</div>

</body>

</html>