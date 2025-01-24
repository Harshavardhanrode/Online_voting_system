<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vote Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 20px;
            background-color: #f4f4f4;
            display: flex;
            justify-content:space-evenly;
            align-items: center;
            height: 100vh;
        }
        .vote-form {
            background: white;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.2);
            
            width: 800px;
            display:flex;
            justify-content:space-evenly;
            text-align: center;
        }
        h2 {
            margin-bottom: 20px;
        }
        label {
            display: block;
            margin: 10px 0;
        }
        button {
            background-color: #007bff;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
        }
        button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body> 
<h2>Cast Your Vote</h2>
    <form class="vote-form" action="/online_voting_system/submit_vote" method="post">
       
        <label>
            <input type="radio" name="party" value="BJP" required> BJP
        </label>
        <label>
            <input type="radio" name="party" value="Shivsena"> Shivsena
        </label>
        <label>
            <input type="radio" name="party" value="Manase"> Manase
        </label>
        <label>
            <input type="radio" name="party" value="BSP"> BSP
        </label>
        <label>
            <input type="radio" name="party" value="Rastravadi"> Rastravadi
        </label>
        <label>
            <input type="radio" name="party" value="AAP"> AAP
        </label>
        <button type="submit">Submit</button>
    </form>
</body>
</html>
