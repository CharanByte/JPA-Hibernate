<%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Glassmorphism Login Form</title>
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
            background-attachment: fixed; /* Keeps the background fixed */
        }

        .navbar {
            width: 100%;
            display: flex;
            align-items: center;
            justify-content: space-between;
            padding: 10px 20px;
            position: absolute;
            top: 0;
            left: 0;
            color: #fff;
            z-index: 1000;
        }

        .navbar-brand img {
            height: 40px;
        }

        .navbar-nav {
            display: flex;
            gap: 15px;
        }

        .nav-link {
            color: #fff;
            text-decoration: none;
            font-size: 14px;
            font-weight: 600;
            transition: color 0.3s;
        }

        .nav-link:hover {
            color: #f05454; /* Highlight color on hover */
            text-decoration: underline;
        }

        .wrapper {
            width: 400px;
            border-radius: 8px;
            padding: 30px;
            text-align: center;
            border: 1px solid rgba(255, 255, 255, 0.5);
            backdrop-filter: blur(8px);
            -webkit-backdrop-filter: blur(8px);
            background: rgba(255, 255, 255, 0.1); /* Glass effect */
            margin-top: 80px; /* Space below the navbar */
        }

        h2 {
            font-size: 2rem;
            margin-bottom: 20px;
            color: #fff;
        }

        .input-field {
            position: relative;
            border-bottom: 2px solid #ccc;
            margin: 15px 0;
        }

        .input-field label {
            position: absolute;
            top: 50%;
            left: 0;
            transform: translateY(-50%);
            color: #fff;
            font-size: 16px;
            pointer-events: none;
            transition: 0.15s ease;
        }

        .input-field input {
            width: 100%;
            height: 40px;
            background: transparent;
            border: none;
            outline: none;
            font-size: 16px;
            color: #fff;
        }

        .input-field input:focus~label,
        .input-field input:valid~label {
            font-size: 0.8rem;
            top: 10px;
            transform: translateY(-120%);
        }

        button {
            background: #fff;
            color: #000;
            font-weight: 600;
            border: none;
            padding: 12px 20px;
            cursor: pointer;
            border-radius: 3px;
            font-size: 16px;
            border: 2px solid transparent;
            transition: 0.3s ease;
        }

        button:hover {
            color: #fff;
            border-color: #fff;
            background: rgba(255, 255, 255, 0.15);
        }

        .error-message {
            color: red;
            text-align: left;
            font-size: 14px;
        }

        .display {
            font-size: 13px;
            margin-bottom: 20px;
            color: green;
            text-align: center;
        }
    </style>
</head>
<body>
    <!-- Navbar Section -->
    <div class="navbar">
        <a class="navbar-brand" href="#">
            <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="X-workz Logo">
        </a>
        <div class="navbar-nav">
            <a class="nav-link" href="index.jsp">Home</a>
            <a class="nav-link" href="http://localhost:8083/xworkz_module/Signup">Sign up</a>
            <a class="nav-link" href="Signin.jsp">Sign in</a>
        </div>
    </div>

    <!-- Main Content Section -->
    <div class="wrapper">
        <h2 class="display">${passwordUpdated}</h2>
        <form action="forgotPassword" method="post">
            <h2>Reset Password</h2>
            <div class="input-field">
                <input type="text" name="userName" required>
                <label>Enter user name</label>
            </div>
            <p class="error-message">${invalidUser}</p>
            <div class="input-field">
                <input type="password" name="newPassword" required>
                <label>Enter new password</label>
            </div>
            <div class="input-field">
                <input type="password" name="confirmNewPassword" required>
                <label>Re-enter new password</label>
            </div>
            <button type="submit">Reset Password</button>
        </form>
    </div>
</body>
</html>
