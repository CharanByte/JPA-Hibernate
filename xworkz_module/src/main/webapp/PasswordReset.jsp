<%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
<style>
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
                .message{
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
                 <li class="nav-item">
                                           <a class="nav-link" href="UpdateUserDetails.jsp">Update</a>
                                 </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-5">
 <p class="message" style="color:green">${update}</p>
                           <p class="message" style="color:red">${noupdate}</p>
                           <p class="message" style="color:red">${updated}</p>
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center">Create New Password</h3>
                </div>
                <div class="card-body">
                    <form action="passwordReset" method="post">
                        <div class="form-group">
                            <label for="userName">User Name</label>
                            <input type="text" class="form-control" id="userName" name="name" required value="${dto.name}">
                        </div>

                          <div class="form-group">
                             <label for="password">Old Password</label>
                               <input type="password" class="form-control" id="oldpassword" name="oldPassword" required>

                          </div>
                        <div class="form-group">
                            <label for="password">New Password</label>
                            <input type="password" class="form-control" id="newpassword" name="newPassword" required oninput="getName(event)">

                        </div>
                        <div class="form-group">
                            <label for="conpassword">Confirm Password</label>
                            <input type="password" class="form-control" id="conpassword" name="confirmPassword" required oninput="getName(event)">
                             <span id="validConfPass" style="color:red"></span>
                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Reset Password</button>

                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
var getName=(event)=>{
var {name,value}=event.target;
console.log(name);
console.log(value);
if(name==="confirmPassword" && value===document.getElementById("newpassword").value){
console.log("new password and confirm password matching");
document.getElementById("validConfPass").innerHTML="<span style='color:red'></span>"

}
else if(name==="confirmPassword" && value!==document.getElementById("newpassword").value){
document.getElementById("validConfPass").innerHTML="<span style='color:red'>confirm password invalid</span>"
console.log("new password and confirm password notMatching");

}

}

</script>
<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
