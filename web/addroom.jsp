<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Add Accommodation</title>
    </head>
    <body>
        <%@include file='layoutadmin.jsp'%>
        <div id="main">
            <div class="col-md-12 container " style="height: 700px">
                <div class="card">
                    <div class="card-body">
                        <form action="addroom" method="post">
                            <div class="form-group row">
                                <label for="location" class="col-sm-2 col-form-label">
                                    Select a Type:&nbsp; </label>
                                <div class="col-sm-7">
                                    <select name="type" class="form-control">
                                        <c:forEach items="${listRoom}" var="type">
                                            <option value="${type.getId()}">${type.getType()}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="location" class="col-sm-2 col-form-label">
                                    Location</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="location"
                                           placeholder="Enter location of room.">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="charge" class="col-sm-2 col-form-label">
                                    Monthly Charge</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="charge"
                                           placeholder="Enter monthly charge.">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="description" class="col-sm-2 col-form-label">
                                    Description</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="description"
                                           placeholder="Enter description.">
                                </div>
                            </div>
                            <button type="submit" class="btn btn-primary"
                                    style="align-items: center;">Add</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>