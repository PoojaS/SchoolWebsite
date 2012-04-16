<%@ page isELIgnored="false" %>

<html>
<body>
  <table>
      <tr>
          <td>Roll No</td>
          <td>First Name</td>
          <td>Last Name</td>
          <td>Class</td>
          <td>Section</td>
      </tr>
      <tr>
          <td>${student.rollNo}</td>
          <td>${student.firstName}</td>
          <td>${student.lastName}</td>
          <td>${student.standard}</td>
          <td>${student.section}</td>
      </tr>
  </table>

</body>

</html>