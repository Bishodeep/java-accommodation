<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Accommodation Portal</title>
    </head>
    <body>
        <%@include file='layoutadmin.jsp'%>
        <div id="main">
            <div class="col-md-12 container " style="height: 700px">
                <div class="card">
                    <div class="card-body">
                        <div class="list-part">
                            <h4 class="card-title">Edit Room Type</h4>

                            <div class="inner-list-part d-flex">
                                <form class="form-inline my-2 my-lg-0" action="admin"
                                      method="get">
                                    <button class="btn btn-danger my-2 my-sm-0" type="submit">Cancel</button>
                                </form>
                            </div>
                        </div>
                        <form action="updateroom" method="post">
                            <input type="text" class="form-control" name="id"
                                   placeholder="Enter type of room" hidden value="${accommodation.getId()}">
                            <div class="form-group row">
                                <label for="location" class="col-sm-2 col-form-label">
                                    Select a Type:&nbsp; </label>
                                <div class="col-sm-7">
                                    <select name="type" class="form-control">
                                        <c:forEach items="${accommodations}" var="type">
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
                                           placeholder="Enter location of room." value="${accommodation.getLocation()}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="charge" class="col-sm-2 col-form-label">
                                    Monthly Charge</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="charge"
                                           placeholder="Enter monthly charge." value="${accommodation.getMonthlyCharge()}">
                                </div>
                            </div>
                            <div class="form-group row">
                                <label for="description" class="col-sm-2 col-form-label">
                                    Description</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="description"
                                           placeholder="Enter description." value="${accommodation.getDescription()}">
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