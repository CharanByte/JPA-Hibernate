<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
               background-color:white;
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
        .main-section p {
            font-size: 1.2em;
            color: #ff5722;
        }
        .main-section .btn {
            background-color: #ff5722;
            color: #ffffff;
            padding: 10px 20px;
            font-size: 1.2em;
            border-radius: 5px;
            border: none;
            text-decoration: none;
        }
        .main-section .btn:hover {
            background-color: #e64a19;
            color: #ffffff;
        }
        .main-image {
            max-width: 100%;
            height: auto;
        }
        .sign-up-btn {
            background-color: #343a40;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
        }
        .sign-up-btn a {
            color: #ffffff;
            text-decoration: none;
        }
        .sign-up-btn:hover {
            background-color: #007bff;
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
            </ul>
        </div>
    </div>
</nav>

<div class="main-section">
    <div class="container">
        <h1>Welcome to X-workz</h1>
        <p>Don`t have an account?</p>
        <button class="sign-up-btn">
            <a href="Signup.jsp">Sign up</a>
        </button>
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
