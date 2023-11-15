<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/caluculator.css"
</head>
<body>

	<div class="calcDiv">

		<h1>でんたく</h1>

		<div id="resultText">

			<!-- <script>
				const result = eval(${result} ); 
				const resultText = document.getElementById("resultText");
				
				if(result){
					resultText.innerHTML = result;
					}
			</script> -->

			<p class="calcResult">
				<span class="result">${result}</span>
			</p>

		</div>

		<table class="calcTable">

			<tbody>

				<tr>
					<form action="calcu" method="post">
						<td colspan="3"><input type="submit" value="AC"
							class="calcuBtn colspan" name="calcSymbol"></td>

						<td><input type="submit" value="÷" class="calcuBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calcu" method="post">
						<td><input type="submit" value="7" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="8" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="9" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="×" class="calcuBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calcu" method="post">
						<td><input type="submit" value="4" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="5" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="6" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="-" class="calcuBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calcu" method="post">
						<td><input type="submit" value="1" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="2" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="3" class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="+" class="calcuBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calcu" method="post">
						<td colspan="2"><input type="submit" value="0"
							class="calcuBtn colspan" name="calcNum"></td>
						<td><input type="submit" value="." class="calcuBtn"
							name="calcNum"></td>
						<td><input type="submit" value="=" class="calcuBtn"
							name="calcSymbol"></td>

					</form>
				</tr>

			</tbody>

		</table>

	</div>
</body>
</html>