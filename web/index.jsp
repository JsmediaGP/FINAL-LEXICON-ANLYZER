<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="index.css">
    <title>Registration Form</title>
</head>

<body>
    <div class="container">
        <form action="" method="post">
            <div> 
                <h1 style="text-align: center"> LEXICON ANALYZER </h1>   
            </div>
            <br>
            <div class="form-row">
                <div class="form-group">
                    <label for="lastName">Last Name</label>
                    <input type="text" id="lastName" name="lastName" required>
                </div>

                <div class="form-group">
                    <label for="firstName">First Name</label>
                    <input type="text" id="firstName" name="firstName" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="otherName">Other Name</label>
                    <input type="text" id="otherName" name="otherName" required>
                </div>

                <div class="form-group">
                    <label for="address">Address</label>
                    <input type="text" id="address" name="address" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" required>
                </div>

                <div class="form-group">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" required>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <label for="comment">Comment</label>
                    <textarea id="comment" rows="6" name="comment" required></textarea>
                </div>
                
                <div class="form-group">
                    <br>
                    <label for="Read COmment">Project Description</label>
                    <p> This is a LExicon ANalyzer Backus-Naur</p>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <button type="submit" class="btn">Register</button>
                </div>
            </div>

            
        </form>
    </div>
</body>

</html>
