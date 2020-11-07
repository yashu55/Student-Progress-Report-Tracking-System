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
    <title>CDAC-Trac.com</title>
</head>

<body class="bg-light">

<!-- NavBar -->


<jsp:include page="navbar.jsp" />  

<!-- Main Details -->
 <div class="container-fluid my-3">
        <div class="row justify-content-around">

            <div class="col-md-10 bg-light shadow px-4 pt-4">
                <div class="row justify-content-center">
                    <div class="col-md-12 justify-content-center align-items-center">
                        <h1 class="text-dark text-center">STUDENT PROGRESS TRACKING SOLUTION</h1>
                        <p class="text-secondary text-center">Track progress of students like never before !!!</p>
                    </div>
                </div>
                <hr>
                <div class="row justify-content-center">

                    <div class="col-md-12 justify-content-center align-items-center">
                        <p class="text-dark text-justify">You can signup and start tracking student progress for
                            free in literally less than a couple of minutes.Entering your student data is as simple as
                            importing it in a couple of clicks and you can see information on their past attendance and
                            grade progress either on thier individual student profile page or by running a fully
                            customizable student report. From there you can quickly assess if each student is on track
                            to succeed in you class.
                        </p>

                    </div>

                </div>
                <div class="row justify-content-center">
                    <div class="col-md-4 justify-content-center align-items-center">
                        <h1 class="display-1 text-info text-center">
                            <i class="fa fa-chart-line"></i></h1>
                        <p class="text-info text-center">
                            Fast insight into exactly how students are progressing in each of their classes.
                        </p>
                    </div>
                    <div class="col-md-4 justify-content-center align-items-center">
                        <h1 class="display-1 text-danger text-center">
                            <i class="fa fa-clock"></i></h1>
                        <p class="text-danger text-center">
                            Know before it's too late if any students need more help based on tracked assessment scores.
                        </p>
                    </div>
                    <div class="col-md-4 justify-content-center align-items-center">
                        <h1 class="display-1 text-success text-center">
                            <i class="fa fa-list-alt"></i></h1>
                        <p class="text-success text-center">
                            Generate integrated reporting to get all of the information back from your tracking easily.
                        </p>
                    </div>
                </div>
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