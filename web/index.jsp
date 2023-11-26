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
        <form action="engine" method="post">
            <div> 
                <h1 style="text-align: center; color: green"> LEXICON ANALYZER </h1>   
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
                    <p> Design and implement a lexicon analyser technique of Back Naur Form</p>
                    <!--<p> Your system should receive input from the user, such as LastName, FirstName, OtherName, address, email address, password and comment.</p>-->
                    <p>You should implement this using Java programming language. Your program should check each of the words/lexicons entered into the input boxes to be sure that they are not scripts of either javascript or SQL queries. Your program should be designed in such a way that it flags any of such if found. Otherwise, this should be allowed to be stored in a MySQL database created.</p>
                </div>
            </div>

            <div class="form-row">
                <div class="form-group">
                    <button type="submit" class="btn" style="height:50px; width:50px">Analyze/Register</button>
                </div>
            </div>

            
        </form>
    </div>
</body>

</html>
