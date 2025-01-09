<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@200;300;400;500;600;700&display=swap");

        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Open Sans", sans-serif;
        }

        body {
            display: flex;
            align-items: center;
            justify-content: center;
            flex-direction: column;
            min-height: 100vh;
            width: 100%;
            padding: 0;
            background: url("https://img.freepik.com/free-photo/sunlight-shining-single-mountain-top-sunset-with-dark-cloudy-sky_181624-377.jpg?ga=GA1.1.11952807.1720176591&semt=ais_hybrid") no-repeat center center/cover;
            background-attachment: fixed;
        }

        .navbar {
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 20px 40px;
            position: absolute;
            top: 0;
            left: 0;
            z-index: 1000;
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
            color: #fff;
        }

        .navbar-brand img {
            height: 45px;
        }

        .navbar-nav {
            display: flex;
            gap: 15px;
        }

        .nav-link {
            color: #fff;
            text-decoration: none;
            font-size: 16px;
            font-weight: 600;
            transition: color 0.3s;
        }

        .nav-link:hover {
            color: #FFA600;
            text-decoration: none;
        }

        .main-section {
            width: 600px;
            padding: 30px;
            margin-top: 80px;
            text-align: center;
            background: rgba(255, 255, 255, 0.1);
            border-radius: 10px;
            backdrop-filter: blur(10px);
            -webkit-backdrop-filter: blur(10px);
        }

        .main-section h1 {
                   font-size: 2.5em;
                   margin-bottom: 20px;
                   color: #6AB187;
               }

               .main-section h1 span {
                   display: inline-block;
                   opacity: 0;
                   animation: fadeIn 2s forwards;
               }

               .main-section h1 span:nth-child(1) {
                   animation-delay: 0.2s;
               }

               .main-section h1 span:nth-child(2) {
                   animation-delay: 0.4s;
               }

               .main-section h1 span:nth-child(3) {
                   animation-delay: 0.6s;
               }

               .main-section h1 span:nth-child(4) {
                   animation-delay: 0.8s;
               }

               .main-section h1 span:nth-child(5) {
                   animation-delay: 1s;
               }

               .main-section h1 span:nth-child(6) {
                   animation-delay: 1.2s;
               }

               .main-section h1 span:nth-child(7) {
                   animation-delay: 1.4s;
               }

               @keyframes fadeIn {
                   0% {
                       opacity: 0;
                       transform: translateX(20px);
                   }
                   100% {
                       opacity: 1;
                       transform: translateX(0);
                   }
                   }

        .main-section p {
            font-size: 1.2em;
            color: #ffd700; /* Gold for contrast */
            margin-bottom: 20px;
        }

        .main-section .btn {
            background-color: #007bff;
            color: #ffffff;
            padding: 10px 20px;
            font-size: 1.2em;
            border-radius: 5px;
            border: none;
            text-decoration: none;
            transition: background-color 0.3s, transform 0.2s;
        }

        .main-section .btn:hover {
            background-color: #0056b3;
            transform: scale(1.05);
        }
        h1 span{
        color: #97BC62;
        }
    </style>
</head>
<body>

<!-- Navbar Section -->
<nav class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="#">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="X-workz Logo">
    </a>
    <div class="navbar-nav">
        <a class="nav-link" href="index.jsp">Home</a>
        <a class="nav-link" href="Signup">Sign up</a>
        <a class="nav-link" href="Signin.jsp">Sign in</a>
    </div>
</nav>

<!-- Main Content Section -->
<div class="main-section">
    <h1>Welcome to <span>X</span><span>-</span><span>w</span><span>o</span><span>r</span><span>k</span><span>z</span></h1>
    <p>Don`t have an account? <span> Sign up today!</span></p>
    <a href="Signup" class="btn">Sign up</a>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
