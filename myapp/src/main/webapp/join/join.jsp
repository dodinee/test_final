<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<script src="join/js/join.js?ver=1" type="text/javascript" defer></script>
<link rel="stylesheet" href="join/css/join.css?ver=1" type="text/css" />
<title>JoinModal</title>

</head>
<body>
	<div class="joinModal">
		<input type="button" class="clsbtn" value="⤬"/>
		<img
			src="https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/560px-Golde33443.jpg" 
			alt="" class="" /><!-- 바꿔야됨  -->
		<div class="sanName">${p.sanName }</div>
		<ul class="joinInfo">
			<li>날짜 : ${p.partyYmd }</li>
			<li>시간 : ${p.partyTime }</li>
			<c:if test="${p.items != null }">
			<li>준비물 : ${p.items }</li>
			</c:if>
			<c:if test="${p.condition != null }">
			<li>등반조건 : ${p.condition }</li>
			</c:if>
		</ul>
		<div style="color: rgba(79, 197, 61, 1); font-size: 14px; margin-top: 15px;">참가하시겠습니까?</div>
		<input type="button" class="joinbtn" value="참여하기"/>
	</div>
</body>
</html>