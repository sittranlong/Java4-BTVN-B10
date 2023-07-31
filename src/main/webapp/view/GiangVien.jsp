<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 26/07/2023
  Time: 08:12 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
<form action="/giang-vien/search" method="get">
    tên: <input type="text" name="nameSearch"/>
    <br><br>
    <button type="submit">Search</button>
    <br><br>
    <button><a href="/giang-vien/view-add">Add</a></button>
    <br><br>
    <button><a href="/giang-vien/giang-vien-nu">Giảng viên nữ</a></button>
    <br><br>
    <br><br>
</form>
<table>
    <tr>
        <th>id</th>
        <th>mã</th>
        <th>tên</th>
        <th>tuổi</th>
        <th>giới tính</th>
        <th>địa chỉ</th>
        <th colspan="3">Action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${giangVien}" var="gv">
        <tr>
            <td>${gv.id}</td>
            <td>${gv.ma}</td>
            <td>${gv.ten}</td>
            <td>${gv.tuoi}</td>
            <td>${gv.gioiTinh}</td>
            <td>${gv.diaChi}</td>
            <td>
                <button><a href="/giang-vien/remove?DeleteIMa=${gv.ma}">Delete</a></button>
                <button><a href="/giang-vien/detail?DetailMa=${gv.ma}">Detail</a></button>
                <button><a href="/giang-vien/view-update?UpdateMa=${gv.ma}">Update</a></button>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
