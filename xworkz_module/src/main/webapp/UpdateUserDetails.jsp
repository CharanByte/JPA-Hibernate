<%@ page isELIgnored = "false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Update Details</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #e9ecef;
            font-family: Arial, sans-serif;
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
        .form-container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            margin-top: 50px;
        }
        .form-container h2 {
            margin-bottom: 20px;
            font-size: 1.8rem;
            color: #343a40;
            text-align: center;
        }
        .form-group label {
            font-weight: bold;
        }
        .btn {
            margin-top: 20px;
        }
        .text-center {
            color: #28a745;
            margin-bottom: 20px;
        }
        .custom-file-label::after {
            content: "Browse";
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

<div class="container">
    <div class="text-center">
        <h1>${success}</h1>
        <h1>${updateSuccess}</h1>
    </div>
    <div class="row justify-content-center">
        <div class="col-md-8 col-lg-6">
            <div class="form-container">
                <h2>Update Details</h2>
                <form action="update" method="post" enctype="multipart/form-data">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" value="${signupEntity.name}">
                        <small id="nameValid" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" onblur="validData(event)" value="${signupEntity.email}">
                        <small id="emailvalid" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label for="phoneNo">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNo" name="phoneNo" placeholder="Enter phone number" onblur="validData(event)" value="${signupEntity.phoneNo}">
                        <small id="phonevalid" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label for="altEmail">Alternate Email</label>
                        <input type="email" class="form-control" id="altEmail" name="altEmail" placeholder="Enter alternate email" onblur="validData(event)" oninput="altEmailSameOrNot()" value="${signupEntity.altEmail}">
                        <small id="altEmailvalid" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label for="altPhoneNo">Alternate Phone Number</label>
                        <input type="text" class="form-control" id="altPhoneNo" name="altPhoneNo" placeholder="Enter alternate phone number" onblur="validData(event)" oninput="altPhoneNoSameOrNot()" value="${signupEntity.altPhhoneNo}">
                        <small id="altPhonevalid" class="form-text text-danger"></small>
                    </div>
                    <div class="form-group">
                        <label for="location">Location</label>
                        <select class="form-control" id="location" name="location">
                            <option value="">Select option</option>
                            <c:forEach items="${location}" var="loc">
                                <option value="${loc}" ${signupEntity.location == loc ? 'selected' : ''}>${loc}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="formFile" class="form-label">Upload Your File</label>
                        <input type="file" class="form-control" id="formFile" name="thisfile" accept="image/*">
                    </div>
                    <button type="submit" class="btn btn-primary">Update</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>


    const validData=(event)=>{
        const {name,value}=event.target;
        var regex =  /^[A-Z][a-zA-Z]*$/;
        var regex1 = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
         var regex2 = /^[0-9]+$/;
        if(name==="name" && value.length>=2 && regex.test(value)){
            console.log("valid name");
          document.getElementById("nameValid").innerHTML="<span></span>"
        }
        else if(name==="name" && (value.length<2 || !regex.test(value) )){
        console.log("name not valid");
        document.getElementById("nameValid").innerHTML="<span style='color:red'}> name invalid</span>"
        }

        if(name==="email" && (regex1.test(value))){
            console.log("valid email");
            document.getElementById("emailvalid").innerHTML="<span}></span>"
        }
        else if(name==="email" && !regex1.test(value)){
        console.log("email not valid");
        document.getElementById("emailvalid").innerHTML="<span style='color:red'}> Email invalid</span>"
        }


        if(name==="phoneNo" && value.length==10 && regex2.test(value)){
            console.log("phoneNo valid");
            document.getElementById("phonevalid").innerHTML="<span}></span>"
        }
        else if(name==="phoneNo" && (value.length!=10 || !regex2.test(value))){
        console.log("phoneNo invalid");
        document.getElementById("phonevalid").innerHTML="<span style='color:red'}> Phone Number invalid</span>"
        }

        if(name==="altEmail" && regex1.test(value) && value!==document.getElementById("email").value){
            console.log("altvalid email");
            document.getElementById("altEmailvalid").innerHTML="<span}></span>"
        }

        else if(name==="altEmail" && (!regex1.test(value) || value===document.getElementById("email").value)){
        console.log("altemail not valid");
        document.getElementById("altEmailvalid").innerHTML="<span style='color:red'}> Email invalid</span>"
        }

        if(name==="altPhoneNo" && value.length==10 && regex2.test(value) && value!==document.getElementById("phoneNo").value){
            console.log("altphoneNo valid");
            document.getElementById("altPhonevalid").innerHTML="<span}></span>"
        }
        else if(name==="altPhoneNo" && (value.length!=10 || !regex2.test(value) || value===document.getElementById("phoneNo").value)){
        console.log("altphoneNo invalid");
        document.getElementById("altPhonevalid").innerHTML="<span style='color:red'}> Phone Number invalid</span>"
        }
    }

    var altEmailSameOrNot=()=>{
    if(document.getElementById("altEmail").value===document.getElementById("email").value){
              console.log("altEmail and email are same: ");
            document.getElementById("altEmailvalid").innerHTML="<span style='color:red'}>alternate email and email can't be same</span>"
    }
    else if(document.getElementById("altEmail").value!==document.getElementById("email").value){
              console.log("alt and email Notsame: ");
    }
    }
    var altPhoneNoSameOrNot=()=>{
    if(document.getElementById("altPhoneNo").value===document.getElementById("phoneNo").value){
              console.log("altPhoneNo and phone are same");
            document.getElementById("altPhonevalid").innerHTML="<span style='color:red'}>alternate phoneNo and phoneNo can't be same</span>"
    }
    else if(document.getElementById("altPhoneNo").value!==document.getElementById("phoneNo").value){
              console.log("altPhoneNo and phone are Notsame");
    }
    }
</script>


<!-- Bootstrap JS and dependencies (optional but recommended) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</body>
</html>