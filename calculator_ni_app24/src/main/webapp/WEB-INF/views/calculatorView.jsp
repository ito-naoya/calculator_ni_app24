<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>でんたくさん</title>
<link rel="stylesheet" href="./css/caluculator.css"
</head>
<body>

	<div class="calcDiv">

		<h1>でんたく</h1>

		<div id="calcResult">
			<div id="result">

				<%-- ${result} --%>

				<script>
				const calcResult = eval(${calcResult}); 
				const result = document.getElementById("result");
				
				if(calcResult){
					result.innerHTML = calcResult;
				}
				</script>

			</div>
		</div>

		<table class="calcTable">

			<tbody>

				<tr>
					<form action="calc" method="post">
						<td colspan="3"><input type="submit" value="AC"
							class="calcBtn colspan" name="calcSymbol"></td>
						<td><input type="submit" value="÷" class="calcBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calc" method="post">
						<td><input type="submit" value="7" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="8" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="9" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="×" class="calcBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calc" method="post">
						<td><input type="submit" value="4" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="5" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="6" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="-" class="calcBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calc" method="post">
						<td><input type="submit" value="1" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="2" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="3" class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="+" class="calcBtn"
							name="calcSymbol"></td>
					</form>
				</tr>

				<tr>
					<form action="calc" method="post">
						<td colspan="2"><input type="submit" value="0"
							class="calcBtn colspan" name="calcNum"></td>
						<td><input type="submit" value="." class="calcBtn"
							name="calcNum"></td>
						<td><input type="submit" value="=" class="calcBtn"
							name="calcSymbol"></td>

					</form>
				</tr>

			</tbody>

		</table>

	</div>
</body>
</html>