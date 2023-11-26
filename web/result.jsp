<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="result.css">
    <title>Lexicon Analyzer Rankings</title>
</head>

<body>
    <div class="container">
        <h2>Lexicon Analyzer Rankings</h2>
        <button> <a href="index.jsp">Home</a></button>
        
        <%
    String message = (String) request.getAttribute("saveMessage");
    if (message != null && !message.isEmpty()) {
        out.println("<p style='color: green;'>" + message + "</p>");
    }
%>

        <table>
            <thead>
                <tr>
                    <th>Field Name</th>
                    <th>User Input</th>
                    <th>SQL Injection Rank</th>
                    <th>JavaScript Injection Rank</th>
                    <th>Final Rank</th>
                </tr>
            </thead>
            <tbody>
                <!-- Replace the placeholders with actual values -->
                <tr>
                    <td>Last Name</td>
                    <td>${lastName}</td>
                    <td>${lastNameSqlRank}</td>
                    <td>${lastNameJsRank}</td>
                    <td>${lastNameFinalRank}</td>
                </tr>

                <tr>
                    <td>First Name</td>
                    <td>${firstName}</td>
                    <td>${firstNameSqlRank}</td>
                    <td>${firstNameJsRank}</td>
                    <td>${firstNameFinalRank}</td>
                </tr>

                <tr>
                    <td>Other Name</td>
                    <td>${otherName}</td>
                    <td>${otherNameSqlRank}</td>
                    <td>${otherNameJsRank}</td>
                    <td>${otherNameFinalRank}</td>
                </tr>

                <tr>
                    <td>Address</td>
                    <td>${address}</td>
                    <td>${addressSqlRank}</td>
                    <td>${addressJsRank}</td>
                    <td>${addressFinalRank}</td>
                </tr>

                <tr>
                    <td>Email</td>
                    <td>${email}</td>
                    <td>${emailSqlRank}</td>
                    <td>${emailJsRank}</td>
                    <td>${emailFinalRank}</td>
                </tr>

                <tr>
                    <td>Password</td>
                    <td>${password}</td>
                    <td>${passwordSqlRank}</td>
                    <td>${passwordJsRank}</td>
                    <td>${passwordFinalRank}</td>
                </tr>

                <tr>
                    <td>Comment</td>
                    <td>${comment}</td>
                    <td>${commentSqlRank}</td>
                    <td>${commentJsRank}</td>
                    <td>${commentFinalRank}</td>
                </tr>
            </tbody>
        </table>

        <div class="overall-ranking">
            <h3>Overall SQL Ranking: ${overallRankingSql}</h3>
            <h3>Overall JavaScript Ranking: ${overallRankingJs}</h3>
            <h3>Overall Ranking: ${overallRanking}</h3>
        </div>
    </div>
</body>

</html>
