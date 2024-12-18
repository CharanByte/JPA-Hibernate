<%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignUp</title>
    <!-- Bootstrap CSS CDN -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
            padding: 20px;
        }
        .form-container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        .form-container h2 {
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-md-6">
            <div class="form-container">
                <h2>Sign Up</h2>
                <form action="signup" method="post">
                    <div class="form-group">
                        <label for="name">Name</label>
                        <input type="text" class="form-control" id="name" name="name" placeholder="Enter name" >
                    </div>
                    <div class="form-group">
                        <label for="name">Email</label>
                        <input type="text" class="form-control" id="age" name="email" placeholder="Enter email">
                    </div>
                    <div class="form-group">
                        <label for="name">Phone Number</label>
                        <input type="text" class="form-control" id="email" name="phoneNo" placeholder="Enter phone number">
                    </div>
                    <div class="form-group">
                        <label for="name">Alternate Email</label>
                        <input type="text" class="form-control" id="password" name="altEmail" placeholder="Enter alternate email">
                    </div>
                    <div class="form-group">
                        <label for="name">Alternate Phone Number</label>
                        <input type="text" class="form-control" id="conPassword" name="altPhhoneNo" placeholder="Enter alternate phone number ">
                    </div>

                    <div class="form-group">
                        <label for="name">Location</label>
                        <input type="text" class="form-control" id="phNo" name="location" placeholder="Enter location">
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!-- Bootstrap JS and dependencies (optional but recommended) -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
</body>
</html>
