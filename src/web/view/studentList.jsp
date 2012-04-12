<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>
        Spring Public School
    </title>
</head>

<body>
<h1 style="border-bottom: #a52a2a">
    List of students in the school
</h1>
<br/>
<form:form commandName="students" action="deleteStudent.school" method="POST">
<%--<form action="deleteStudent.school" method="POST">--%>
    <table border="1" cellpadding="2" cellspacing="2">
        <tr>
            <th>
                Select
            </th>
            <th>
                First Name
            </th>
            <th>
                Last Name
            </th>
            <th>
                Class
            </th>
            <th>
                Section
            </th>
        </tr>

        <c:forEach items="${students}" var="student1" varStatus="i">
            <tr>
                <td>
                        <%--<form:checkbox path="students[${i.index}].checkbox"/>--%>
                        <%--<form:checkbox path="${student1.checkbox}" value=""/>--%>
                    <input type="checkbox"/>
                </td>
                <td>
                        <form:input path="student1.firstName" value= "<c:out value='${student1.firstName}' />"/>
                </td>
                <td>
                        ${student1.lastName}
                </td>
                <td>
                        ${student1.standard}
                </td>
                <td>
                        ${student1.section}
                </td>
            </tr>
        </c:forEach>

    </table>
    <input type="SUBMIT" value="DELETE"/>

<%--</form>--%>
</form:form>
</body>

</html>