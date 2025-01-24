<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
	*{
	padding:0px;
	margin:0px;
	}
	nav{
	height:50px;
	width:100%;
	background-color:green;
	display:flex;
	justify-content:space-between;
	align-items:center;
	}
	p{
	font-size:25px;
	color:white;
	}
	nav p{
	padding-left:20px;
	padding-right:20px;
	}
	h1{
	padding-top:10px;
	padding-left:20px;
	}
	.parties{
	
	height: 700px;
	width:100%
	
	
	}
	.party1{
	height:300px;
	width:100%;
	
	display:flex;
	justify-content:space-evenly;
	align-items:center;
		
	}
	.party2{
		height:300px;
		width:100%;
		
		display:flex;
	justify-content:space-evenly;
	align-items:center;
	
	}
	.parties .party1 .block{
		height:250px;
		width:15%;
		
	}
	.parties .party2 .block{
		height:250px;
		width:15%;
		
		
	}
	img{
		width: 100%; 
            height: auto; 
            object-fit: cover; 
	}
	.voting_panel{
		height:50px;
		width:100%;
		display:flex;
		justify-content:end;
		
	}
	.voting_panel:hover {
  	color:lightblue;
  
}
</style>
<body>
<nav>
<p>Election by Bharat Sarkar</p>

  <p><%=request.getAttribute("Message") %> </p>


</nav>
<h1 class="header">Hello,
	<%= request.getAttribute("Message") != null ? request.getAttribute("Message") : "" %>	
</h1>


<div class="parties">
	<br><br>
   <div class="party1">
   		<div  class="block"id="bjp">
   			<div>
   			<img  alt="" src="img/bjp.jpg">
   			</div>
   			<p style =" font-size:20px;color:black;text-align:center;">BJP</p>
   			   
   			
   			
   		
   		</div>
   		<div id="shivsena" class="block">
   			<div>
   			<img alt=""  src="img/shivsena.jpg">
   			</div>
   			<p style =" font-size:20px;color:black;text-align:center;">Shivsena</p>
   		</div>
   		<div id="Rashtravadi" class="block">
   			<div>
   			<img  alt="" src="img/ras.jpg">
   			</div>
   			<p style =" font-size:20px;color:black;text-align:center;">Rashtravadi</p>
   		
   		</div>
   </div>
   <br><br>
   <div class="party2">
	   <div id="Aap" class="block">
	   		<div>
   			<img alt=""  src="img/Aap.png">
   			</div>
   			<p style =" font-size:20px;color:black;text-align:center;">Aap</p>
	   	
	   </div>
	   <div id="Manase" class="block">
	   		<div>
   			<img alt=""  src="img/manase.png">
   			</div>
   			<p style =" font-size:20px;color:black;text-align:center;">Manase</p>
	   </div>
	   <div id="bsp" class="block">
	   		<div>
   			<img alt=""  src="img/bsp.jpg">
   			</div>
   			<p style =" font-size:20px;color:black;text-align:center;">BSP</p>
	   
	   </div>
   </div>
  

</div>

<div class="voting_panel">
	<a  href="vote.jsp" style="padding-right:50px;color:blue;font-size:25px;">Vote here </a>
</div>



<script>
var message = "<%= request.getAttribute("Message") != null ? request.getAttribute("Message") : "" %>";

if (message) {
    alert("login sucessful..!");  
}
		
	
		
        
    </script>
</body>
</html>