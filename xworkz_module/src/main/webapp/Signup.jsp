<%@ page isELIgnored = "false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
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
                    text-align: center;
                    padding: 100px 20px;
                }
                .main-section h1 {
                    font-size: 3em;
                    font-weight: bold;
                    color: #343a40;
                }

        .form-container h2 {
            margin-bottom: 20px;
            text-align: center;
            color:#fff;
        }
        .form-container .btn {
            display: block;
            width: 100%;
            margin-top: 20px;
     }
      .header-spacing {
                 margin-bottom: 30px;
             }
              .header-spacing {

                     margin-top: 100px;
                 }
                 .form-container{
                 width: 600px;
                             border-radius: 8px;
                             padding: 30px;
                             text-align: left;
                             border: 1px solid rgba(255, 255, 255, 0.5);
                             backdrop-filter: blur(8px);
                             -webkit-backdrop-filter: blur(8px);
                             background: rgba(255, 255, 255, 0.1); /* Glass effect */
                 }

             .form-group {

                        margin: 15px 0;
                        color:#fff;
                    }



    </style>
</head>
<body>
<nav class="navbar navbar-expand-lg">
    <a class="navbar-brand" href="#">
        <img src="https://x-workz.in/static/media/Logo.cf195593dc1b3f921369.png" alt="X-workz Logo">
    </a>
    <div class="navbar-nav">
        <a class="nav-link" href="index.jsp">Home</a>
        <a class="nav-link" href="Signin.jsp">Sign in</a>
    </div>
</nav>

<div class="container header-spacing">
    <div class="row justify-content-center">
        <div class="col-md-6">
 <c:forEach items = "${error}" var = "i">
        <span>${i.defaultMessage}</span>
         </c:forEach>
            <div class="form-container">
                <h2>Sign Up</h2>
                <form action="signup" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="nameid" name="name" placeholder="Enter name"  onblur="validData(event)" onchange="onField()">
                        <span id="nameValid" style="color:red"></span>
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" id="email" name="email" placeholder="Enter email" onblur="validData(event)" >
                        <span id="emailvalid"></span>
                    </div>
                    <div class="form-group">
                        <label for="phoneNo">Phone Number</label>
                        <input type="text" class="form-control" id="phoneNo" name="phoneNo" placeholder="Enter phone number" onblur="validData(event)">
                        <span id="phonevalid"></span>
                    </div>
                    <div class="form-group">
                        <label for="altEmail">Alternate Email</label>
                        <input type="email" class="form-control" id="altEmail" name="altEmail" placeholder="Enter alternate email" onblur="validData(event)" oninput="altEmailSameOrNot()">
                        <span id="altEmailvalid"></span>
                    </div>
                    <div class="form-group">
                        <label for="altPhoneNo">Alternate Phone Number</label>
                        <input type="text" class="form-control" id="altPhoneNo" name="altPhoneNo" placeholder="Enter alternate phone number" onblur="validData(event)" oninput="altPhoneNoSameOrNot()">
                        <span id="altPhonevalid"></span>
                    </div>
                    <div class="form-group">
                        <label for="location">Location</label>
                        <select class="form-control" id="location" name="location">
                        <option value="">Select option</option>
                        <c:forEach items="${location}" var="loc">
                        <option value="${loc}">${loc}</option>
                        </c:forEach>
                        </select>

                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script>
const onField=()=>{
var placeName=document.getElementById("nameid");
   var placeValue=placeName.value;
if(placeValue!=""){
      var xhttp=new XMLHttpRequest();
        xhttp.open("GET","http://localhost:8086/xworkz_module/placeName/" + placeValue,true);
        xhttp.send();

        xhttp.onload = function() {
            document.getElementById("nameValid").innerHTML = this.responseText;
        }
        }

}


const validData=(event)=>{
    const {name,value}=event.target;
    var regex =   /^[A-Za-z]+$/;
    var regex1 = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
     var regex2 = /^[0-9]+$/;
    if(name==="name" && value.length>=2 && regex.test(value) && value!==""){
        console.log("valid name");
      document.getElementById("nameValid").innerHTML="<span></span>"
    }
    else if(name==="name" && (value.length<2 || !regex.test(value) || value==="" )){
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
