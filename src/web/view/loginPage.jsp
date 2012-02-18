<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Spring Public School</title>
</head>

<body>

    <form:form action="login.school" method="POST" commandName="administrator">
    UserName <form:input path="userName"/>
    <br/>
    Password<form:password path="password"/>
    <br/>
    <input type="submit" value="LOGIN">
    </form:form>

</body>
</html>