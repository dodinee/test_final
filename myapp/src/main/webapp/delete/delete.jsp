<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="delete/js/delete.js" type="text/javascript" defer></script>
<link rel="stylesheet" href="delete/css/delete.css" type="text/css" />
<title>Document</title>

</head>
<body>
	<div class="delcontainer">
<!-- 		<input type="hidden" id="targetGb" name="targetGb" value=""> -->
		<input type="hidden" id="targetCd" name="targetCd" value="">
		<div class="delment">삭제하시겠습니까?</div>
		<input type="button" class="delcancle" value="취소" /> 
		<input type="button" class="del" name="remove" value="삭제" />
	</div>
</body>
</html>