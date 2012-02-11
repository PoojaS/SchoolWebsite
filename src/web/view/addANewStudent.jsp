<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Spring Public School</title>
</head>
<body>
<form:form method="POST" commandName="student">

    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <td>Student Roll</td>
            <td><form:input path="rollNo"/></td>
        </tr>
        <tr>
            <td>Student Name</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Class</td>
            <td><form:input path="standard"/></td>
        </tr>
        <tr>
            <td>Section</td>
            <td><form:input path="section"/></td>
        </tr>
    </table>
    <br/>
    <input type="submit" value="ADD"/>
</form:form>

</body>

</html>