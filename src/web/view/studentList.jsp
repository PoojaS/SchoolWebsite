<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>
        Spring Public School
    </title>
</head>

<body>
<h1 style="border-bottom: #a52a2a" >
    List of students in the school
</h1>
<br />
 <table border="1" cellpadding="2" cellspacing="2" >
     <tr>
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

     <c:forEach items="${students}" var="student1">
       <tr>
         <td>
             ${student1.firstName}
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
</body>

</html>