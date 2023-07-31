<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 26/07/2023
  Time: 10:46 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<form action="">
  username: <input type="text" name="username"/>
  <br><br>
  password: <input type="password" name="password"/>
  ${errorMessage}
  <br><br>
  <button type="submit">login</button>
  <br><br>
  <br><br>
</form>
</body>
</html>
