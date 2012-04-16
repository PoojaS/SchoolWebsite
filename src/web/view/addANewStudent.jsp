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

        .rfq {
            color: #8b0000;
            font-style: oblique;
        }
    </style>
</head>
<script type="text/javascript" src="jquery.js"></script>
<script type="text/javascript" src="validate.js"></script>
<body>
<form:form method="POST" commandName="student" id="addStudentForm">

    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <td>
                First Name Is<br/>
                (RFQ)
            </td>
            <td>
                    <form:input path="firstName"/>
                <div id="firstNameError" class="error"></div>
        </tr>
        <tr>
            <td>Last Name<br/>
                (RFQ)
            </td>
            <td>
                <form:input path="lastName"/>
                <div id="lastNameError" class="error"></div>
            </td>
        </tr>
        <tr>
            <td>Class<br/>
                (RFQ)
            </td>
            <td>
                <form:input path="standard"/>
                <div id="standardError" class="error"></div>
            </td>
        </tr>
        <tr>
            <td>Section</td>
            <td><form:input path="section"/>
                <div id="sectionError" class="error"></div>
            </td>
        </tr>
    </table>
    <br/>
    <input type="button" value="ADD" onclick="validateStudent();"/>
</form:form>

</body>

</html>