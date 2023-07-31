<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 26/07/2023
  Time: 08:13 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add giảng viên</title>
</head>
<body>
<form action="/giang-vien/add" method="post">
    ma: <input type="text" name="ma"/>
    tên: <input type="text" name="ten"/>
    <br><br>
    tuổi: <input type="text" name="tuoi"/>
    <br><br>
    giới tính:
    <input type="radio" name="gioiTinh" checked value="true"/>Nam
    <input type="radio" name="gioiTinh" value="false"/>Nữ
    <br><br>
    địa chỉ: <input type="text" name="diaChi"/>
    <br><br>
    <button type="submit">add</button>
    <br><br>
    <br><br>
</form>
</body>
</html>
