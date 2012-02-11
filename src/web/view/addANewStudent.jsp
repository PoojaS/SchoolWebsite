<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Spring Public School</title>
</head>
<body>
<form action="addNewStudent.school" method="POST">

    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <td>Student Roll</td>
            <td>${student.rollNo}</td>
        </tr>
        <tr>
            <td>Student Name</td>
            <td>${student.name}</td>
        </tr>
        <tr>
            <td>Class</td>
            <td>${student.standard}</td>
        </tr>
        <tr>
            <td>Section</td>
            <td>${student.section}</td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="ADD" align="middle"/>
</form>

</body>

</html>