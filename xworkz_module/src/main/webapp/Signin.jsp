<%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
.reset{
margin-left:70%;

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
 .header-spacing {
            margin-bottom: 30px;
        }
        .lock{
        margin-left:40%;
        }
</style>

</head>
<body>
<nav class="navbar navbar-expand-lg navbar-dark header-spacing">
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
<h3 class="lock"style="color:red">${locked}</h3>
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Sign In</h3>
                </div>
                <div class="card-body">
                    <form action="signin" method="post">
                        <div class="form-group">
                            <label for="userName">User Name</label>
                            <input type="text" class="form-control" id="userName" name="name" required value="${name}" onblur="onField()">
                            <span id="nameValid" style="color:red"></span>
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" class="form-control" id="password" name="password" required>
                               <p style="color:red">${failure}</p>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Login</button>
                        <a href="PasswordReset.jsp" class="reset">Reset Password?</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<script>
const onField=()=>{
console.log("hello")
var filedName=document.getElementById("userName");
   var fieldValue=filedName.value;

      var xhttp=new XMLHttpRequest();
        xhttp.open("GET","http://localhost:8081/xworkz_module/filedName/" + fieldValue,true);
        xhttp.send();

        xhttp.onload = function() {
            document.getElementById("nameValid").innerHTML = this.responseText;
        };
        }
</script>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
