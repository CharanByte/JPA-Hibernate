<%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Success</title>
    <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>

        .text-center {
            color: #28a745;
           margin-top:10%;
        }
         .navbar {
                    background-color: #343a40;
                }
                .navbar-brand {
                    color: #ffffff !important;
                }
                .navbar-brand:hover {
                    color: #007bff !important;
                }
                .main-section {
                    text-align: center;
                    padding: 100px 20px;
                }
                .main-section h1 {
                    font-size: 3em;
                    font-weight: bold;
                    color: #343a40;
                }
    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="Logo" class="logo" height="50">
        </a>
        <div class="collapse navbar-collapse">
            <ul class="navbar-nav ml-auto">
            <li class="nav-item">
          <a class="nav-link" href="index.jsp">Home</a>
           </li>
                <li class="nav-item">
                    <a class="nav-link" href="Signup.jsp">Sign up</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="Signin.jsp">Sign in</a>
                </li>
                 <li class="nav-item">
                           <a class="nav-link" href="UpdateUserDetails.jsp">Update</a>
                 </li>
            </ul>
        </div>
    </div>
</nav>
<div class="text-center">
    <h1>${success}</h1>
</div>
<!-- Bootstrap JS and dependencies (optional) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.3/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
