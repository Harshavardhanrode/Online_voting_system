<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            background-color: #0a1a2b;
        }
        .container {
            width: 350px;
            padding: 20px;
            background: white;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.3);
            border-radius: 8px;
            text-align: center;
        }
        h1 {
            font-size: 24px;
            margin-bottom: 20px;
        }
        input {
            width: 80%;
            padding: 10px;
            margin: 10px 0px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        button {
            width: 85%;
            padding: 10px;
            background-color: #00bcd4;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
        }
        button:hover {
            background-color: #0097a7;
        }
        .alternate {
            margin-top: 10px;
            font-size: 14px;
        }
        .alternate a {
            color: #00bcd4;
            text-decoration: none;
        }
        .alternate a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Log in</h1>
        <form action="/online_voting_system/LoginServlet" method="post">
            <input type="text" name="username" placeholder="Username" required>
            <input type="text" name="voterid" placeholder="Voter ID" required>
            <button type="submit">Log in</button>
        </form>
        <div class="alternate">
            or, <a href="signup.html">sign up</a>
            <p class="result">
            	<%= request.getAttribute("errorMessage") != null ? request.getAttribute("errorMessage") : "" %>
            </p>
        </div>
    </div>
</body>
</html>