<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="ISO-8859-1">
        <title>Accommodation Portal</title>

    </head>
    <body>
        <%@include file='layoutadmin.jsp'%>
        <div id="main">
            <div class="col-md-12 container " style="height: 500px">
                <div class="main-tab rt-2">
                    <ul class="nav nav-tabs" role="tablist">
                        <li class="active">
                            <a class="nav-link active" id="room-tab" data-toggle="tab" href="#room-1" role="tab" aria-controls="room-1" aria-selected="false">Rooms</a>
                        </li>
                        <li class="active">
                            <a class="nav-link" id="type-tab" data-toggle="tab" href="#type-1" role="tab" aria-controls="type-1" aria-selected="false">Configurations</a>
                        </li>
                        <li class="active">
                            <a class="nav-link" id="userroom-tab" data-toggle="tab" href="#userroom-1" role="tab" aria-controls="userroom-1" aria-selected="false">Assigned Rooms</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane fade  " id="type-1" role="tabpanel" aria-labelledby="graph-tab">
                            <div class="card">
                                <div class="card-body">
                                    <div class="list-part">
                                        <h4 class="card-title">Accommodation Type</h4>

                                        <div class="inner-list-part d-flex" style="float: right;">
                                            <form class="form-inline my-2 my-lg-0"
                                                  action="roomtype" method="get">
                                                <button class="btn btn-success my-2 my-sm-0" type="submit">Add</button>
                                            </form>
                                        </div>
                                    </div>
                                    <table class="table table-bordered table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>Type</th>
                                                <th>Available</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="type" items="${accommodationTypes}">
                                                <tr>
                                                    <td><c:out value="${type.getType()}" /></td>
                                                    <td><c:out value="${type.getAvailable()}" /></td>
                                                    <td><a
                                                            href="roomtypeupdate?id=<c:out value='${type.getId()}' />">Edit</a>
                                                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                                            href="roomtypedelete?id=<c:out value='${type.getId()}' />">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade active show" id="room-1" role="tabpanel" aria-labelledby="news-tab">
                            <div class="card">
                                <div class="card-body">
                                    <div class="list-part">
                                        <h4 class="card-title">Available Rooms</h4>
                                        <div class="inner-list-part d-flex" style="float: right;">
                                            <form class="form-inline my-2 my-lg-0" action="addroom"
                                                  method="get">
                                                <button class="btn btn-success my-2 my-sm-0" type="submit">Add</button>
                                            </form>
                                        </div>
                                    </div>
                                    <table class="table table-bordered table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>Type</th>
                                                <th>Location</th>
                                                <th>Monthly Charge</th>
                                                <th>Room available</th>
                                                <th>Room description</th>
                                                <th></th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="accommodation" items="${accommodations}">
                                                <tr>
                                                    <td><c:out value="${accommodation.getTypeName()}" /></td>
                                                    <td><c:out value="${accommodation.getLocation()}" /></td>
                                                    <td><c:out value="${accommodation.getMonthlyCharge()}" /></td>
                                                    <td><c:out value="${accommodation.getAvailable()}" /></td>
                                                    <td><c:out value="${accommodation.getDescription()}" /></td>
                                                    <td><a
                                                            href="updateroom?id=<c:out value='${accommodation.getId()}' />">Edit</a>
                                                        &nbsp;&nbsp;&nbsp;&nbsp; <a
                                                            href="roomdelete?id=<c:out value='${accommodation.getId()}' />">Delete</a>
                                                    </td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane fade" id="userroom-1" role="tabpanel" aria-labelledby="news-tab">
                            <div class="card">
                                <div class="card-body">
                                    <div class="list-part">
                                        <h4 class="card-title">Assigned Room to Students</h4>
                                    </div>
                                    <table class="table table-bordered table-striped table-hover">
                                        <thead>
                                            <tr>
                                                <th>Student Name</th>
                                                <th>Room Type</th>
                                                <th>Room Description</th>
                                                <th>Payment Status</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="assignroom" items="${assignRooms}">
                                                <tr>
                                                    <td><c:out value="${assignroom.getName()}" /></td>
                                                    <td><c:out value="${assignroom.getRoomType()}" /></td>
                                                    <td><c:out value="${assignroom.getDescription()}" /></td>
                                                    <td><c:out value="${assignroom.getPayment()}" /></td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
<script src="https://code.jquery.com/jquery-3.5.0.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
<footer>
    <strong>Copyright &copy; 2020 <a href="#">Sabal</a>.</strong>
    All rights reserved.
</footer> 
</html