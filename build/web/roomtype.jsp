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
            <div class="col-md-12 container "style="height:700px">
                <div class="card" >
                    <div class="card-body">
                        <form action="roomtype"  method="post">
                            <div class="form-group row">
                                <label for="type" class="col-sm-2 col-form-label">
                                    Type</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="type"
                                           placeholder="Enter type of room">
                                </div>
                            </div>

                            <div class="form-group row">
                                <label for="available" class="col-sm-2 col-form-label">
                                    Available Number</label>
                                <div class="col-sm-7">
                                    <input type="text" class="form-control" name="available"
                                           placeholder="Enter number of room available.">
                                </div>
                            </div>

                            <button type="submit" class="btn btn-primary" style="align-items: center;">Add</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>