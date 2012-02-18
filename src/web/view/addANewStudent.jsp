<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>

<html>
<head>
    <title>Spring Public School</title>
    <style>
        .error {
            color: red;
            font-style: italic;
        }
        .rfq{
            color: #8b0000;
            font-style: oblique;
        }
    </style>
</head>
<body>
<form:form method="POST" commandName="student">

    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <td>
                First Name<br/>
                (RFQ)
            </td>
            <td>
            <form:input path="firstName"/>
            <form:errors path="firstName" cssClass="error"/></td>
        </tr>
        <tr>
            <td>Last Name<br/>
                (RFQ)
            </td>
            <td>
                <form:input path="lastName"/>
                <form:errors path="lastName" cssClass="error"/>
            </td>
        </tr>
        <tr>
            <td>Class<br/>
                (RFQ)
            </td>
            <td>
                <form:input path="standard"/>
                <form:errors path="standard" cssClass="error"/>
            </td>
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