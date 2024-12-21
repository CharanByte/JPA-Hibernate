<%@ page isELIgnored = "false"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>SignIn</title>
    <!-- Bootstrap CSS -->
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-5">

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
                               <input type="password" class="form-control" id="newpassword" name="oldPassword" required>

                          </div>
                        <div class="form-group">
                            <label for="password">New Password</label>
                            <input type="password" class="form-control" id="newpassword" name="newPassword" required>

                        </div>
                        <div class="form-group">
                            <label for="conpassword">Confirm Password</label>
                            <input type="password" class="form-control" id="conpassword" name="confirmPassword" required>

                        </div>
                        <button type="submit" class="btn btn-primary btn-block">Reset Password</button>
                           <p style="color:green">${update}</p>
                           <p style="color:red">${noupdate}</p>
                           <p style="color:red">${updated}</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap JS and dependencies -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

</body>
</html>
