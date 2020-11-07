<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="Description" content="Enter your description here" />
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.0/css/all.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css">
    <title>Teacher Login</title>
</head>

<body class="bg-light">

<!-- NavBar -->
<jsp:include page="navbar.jsp" />  

<!-- Teacher Login Form -->
    <div class="container-fluid my-2">
        <div class="row justify-content-around">

            <!--Login Page -->
            <div class="col-md-7 bg-light shadow px-4 pt-4">
                <h4 class="display-4 ">
                    <i class="fa fa-chalkboard-teacher"></i> Teacher Login</h4>
                <p class="text-secondary">Enter valid teacher login details.</p>
                <hr>
                <!--Login form -->
                <form class="was-validated" method="post" action="TeacherLoginSubmit">
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="teacherEmail" id="email" aria-describedby="emailHelpId"
                            placeholder="abc@example.com" pattern="[^\s]+" minlength="3"  required>
                        <small id="emailHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <label for="pwd">Password</label>
                        <input type="password" class="form-control" name="teacherPass" id="pwd" placeholder="Password"
                            minlength="4" maxlength="20" required>
                        <small id="passwordHelpId" class="form-text text-muted">*Required</small>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Submit</button>
                        <button type="reset" class="btn btn-danger">Reset</button>
                    </div>
                </form>
            </div>
        </div>
    </div>



<!-- Footer -->
<%@ include file="footer.htm"%>   

 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.5.1/jquery.slim.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>

</html>