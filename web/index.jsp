
<!DOCTYPE html>
<html>
    <head>
        <title>Accommodation Portal</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <link rel="stylesheet" href="navbaradmin.jsp" type="text/css"/>


    </head>
    <body>
        <div class="container">
            <div class="card" style="margin-top: 50px;">
                <div class="card-body">
                    <div class="main-tab">
                        <ul class="nav nav-tabs" role="tablist">
                            <li class="active">
                                <a class="nav-link active" id="login-tab" data-toggle="tab" href="#login-1" role="tab" aria-controls="login-1" aria-selected="false">Login</a>
                            </li>
                            <li class="active">
                                <a class="nav-link" id="register-tab" data-toggle="tab" href="#register-1" role="tab" aria-controls="register-1" aria-selected="false">Register</a>
                            </li>

                        </ul>
                        <div class="tab-content">
                            <div class="tab-pane fade active show " id="login-1" role="tabpanel" aria-labelledby="graph-tab">
                                <div class="card" style="margin-top: 50px;">
                                    <div class="card-body">
                                        <form action="login"  method="post">
                                            <div class="form-group row">
                                                <label for="firstName" class="col-sm-2 col-form-label">First
                                                    User Name</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control" name="username"
                                                           placeholder="Enter user name">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="lastName" class="col-sm-2 col-form-label">Last
                                                    Password</label>
                                                <div class="col-sm-7">
                                                    <input type="password" class="form-control" name="password"
                                                           placeholder="Enter password">
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary" style="align-items: center;">Login</button>

                                        </form>
                                    </div>
                                </div>
                            </div>
                            <div class="tab-pane fade" id="register-1" role="tabpanel" aria-labelledby="news-tab">
                                <div class="card" >
                                    <div class="card-body">
                                        <h4 style="text-align: center;">Register</h4>
                                        <form action="register"  method="post">
                                            <div class="form-group row">
                                                <label for="firstName" class="col-sm-2 col-form-label">
                                                    Name</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control" name="studentname"
                                                           placeholder="Enter student name">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="address" class="col-sm-2 col-form-label">Address
                                                </label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control" name="address"
                                                           placeholder="Enter address">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="contact" class="col-sm-2 col-form-label">Contact</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control" name="contact"
                                                           placeholder="Enter contact">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="StudentAge" class="col-sm-2 col-form-label">
                                                    Age</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control" name="age"
                                                           placeholder="Enter age">
                                                </div>
                                            </div>

                                            <div class="form-group row">
                                                <label for="username" class="col-sm-2 col-form-label">Use Name</label>
                                                <div class="col-sm-7">
                                                    <input type="text" class="form-control" name="username"
                                                           placeholder="Enter user name">
                                                </div>
                                            </div>
                                            <div class="form-group row">
                                                <label for="password" class="col-sm-2 col-form-label">Password</label>
                                                <div class="col-sm-7">
                                                    <input type="password" class="form-control" name="password"
                                                           placeholder="Enter password">
                                                </div>
                                            </div>
                                            <button type="submit" class="btn btn-primary" style="align-items: center;">Register</button>

                                        </form>
                                    </div>
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