<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/22/2024
  Time: 8:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Employee</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">

</head>
<body>
<div class="container " >
    <h2 >Add Employee</h2>
    <form action="add" method="post">
        <div class="form-group mb-3">
            CMND: <input type="text" name="cmnd" required>

        </div>
        <div class="form-group mb-3">
            Name: <input type="text"  name="name" required>

        </div>
        <div class="form-group mb-3">
            Birthday: <input type="date"  name="bird" required>

        </div>
        <div class="form-group mb-3">
            Address: <input type="text"  name="address" required>

        </div>
        <div class="form-group mb-3">
            Position: <input type="text"  name="position" required>

        </div>
        <div class="form-group mb-3">
            Work Room: <input type="text"  name="work-room" required>

        </div>
        <button type="submit" class="btn btn-primary" >Add  </button>
    </form>
</div>
</body>
</html>
