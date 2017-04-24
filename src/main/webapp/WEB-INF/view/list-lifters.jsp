<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>
<head>
    <title>List Lifters</title>
</head>

<body>
<div id="wrapper">
    <div id="header">
        <h2>LRM - Lifters Relationship Manager</h2>
    </div>
</div>

<div id="container">
    <div id="content">
        <table>
            <tr>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
            </tr>

         <c:forEach var="tempLifter" items="${lifters}">
            <tr>
                <td>${tempLifter.firstName}</td>
                <td>${tempLifter.lastName}</td>
                <td>${tempLifter.email}</td>
            </tr>
         </c:forEach>
        </table>

    </div>

</div>

</body>

</html>