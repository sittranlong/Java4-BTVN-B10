<%--
  Created by IntelliJ IDEA.
  User: LongTH
  Date: 26/07/2023
  Time: 10:56 SA
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detail giảng viên</title>
</head>
<body>
<form action="/giang-vien/hien-thi">
  ma: <input type="text" name="ma" value="${gv.ma}"/>
  tên: <input type="text" name="ten" value="${gv.ten}"/>
  <br><br>
  tuổi: <input type="text" name="tuoi" value="${gv.tuoi}"/>
  <br><br>
  giới tính:
  <input type="radio" name="gioiTinh" checked value="true" ${gV.gioiTinh=="true"?'checked':''}/>Nam
  <input type="radio" name="gioiTinh" value="false" ${gV.gioiTinh=="false"?'checked':''}/>Nữ  <br><br>
  địa chỉ: <input type="text" name="diaChi" value="${gv.diaChi}"/>
  <br><br>
  <button type="submit">back</button>
  <br><br>
  <br><br>
</form>
</body>
</html>
