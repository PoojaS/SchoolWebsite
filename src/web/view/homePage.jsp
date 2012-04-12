<%@ page isELIgnored="false" %>

<html>
    <head>
        <title>
            Spring Public School
        </title>
        <script type="text/javascript" src="jquery.js"/>

    </head>
    <body>
        <h1 align="center">Welcome to Spring Public School</h1>
        <br/>
        <br/>


        Welcome ${administrator.userName}!

        <br/>
        <br/>

        <a href="addNewStudent.school">Click to add a New Student</a><br/>
        <a href="listStudents.school">Click to view list of students</a>
        <button>Click me</button>
    </body>
</html>