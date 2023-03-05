<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include> --%>
 <c:set var="targetGb" value="SAN_PARTY" scope="request"/>
 <c:set var="targetCd" value="${p.sanPartyCd }" scope="request"/>
<jsp:include page="../header/header.html"></jsp:include><%-- 헤더 --%>
<jsp:include page="../report/report2.jsp"></jsp:include><%-- 신고 --%> 
<jsp:include page="../delete/delete.jsp"></jsp:include><%-- 삭제 --%>
<jsp:include page="../join/join.jsp"></jsp:include><%-- 참여 --%>
 
<%--  <c:set var="targetCd" value="${r.sanReviewCd }" scope="page"/> --%>
 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>PartyDetail</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script src="/header/js/header.js" type="text/javascript" defer></script>
<script src="/review-detail/js/default.js?ver=1" type="text/javascript" defer></script>
<script src="/party-detail/js/party-detail.js?ver=1" type="text/javascript" defer></script>

<link rel="stylesheet" href="/header/css/default.css" type="text/css" />
<link rel="stylesheet" href="/header/css/header.css" type="text/css" />
<link rel="stylesheet" href="/party-detail/css/party-detail.css?ver=1" type="text/css" />


</head>


<body>

<!--  게시글 컨테이너  !-->
	<div class="container">
		<%-- <input type="hidden" id= "targetGb" name="targetGb" value="SAN_PARTY"/>
		<input type="hidden" id= "targetCd" name="targetCd" value="${p.sanPartyCd}"/> --%>
		
		<div class="header">
			<!--  산 이름  -->
			<div class="mnt">🌱 ${p.sanName} 🌱</div> <%-- 산이름 --%>
			<!-- 글 제목 --> 
			<div class="title">${p.title }</div> <%-- 글제목 --%>
			<!--  작성일  -->
			<div class="dt"> <%-- 작성일시  --%>
				<fmt:formatDate pattern="yyyy년 M월 d일 HH:mm" value="${p.createdDt}"></fmt:formatDate>
			</div>
		</div>
		
		<div class="contents">
			<!-- 유저 정보  -->
			<img
				src="data:image/jpeg;base64,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"
				alt="" class="userpic" /> <!-- 바꿔야됨 --> 
			<div class="username">${p.nickname}</div>
			<!--  좋아요 버튼  -->
			<div class="likeCnt">
				<input class= "like" type="button" value=""/>${p.likeCnt }
			</div>
			<!--  글 사진  -->
			<img
				<%-- src="${p.img }" --%>
				src="	https://upload.wikimedia.org/wikipedia/commons/thumb/6/6e/Golde33443.jpg/560px-Golde33443.jpg"
				alt="" class="partyImg" />
			<!-- 모집 정보  -->
			<div class="partyInfo">
				<div class="info">
					<span class="list">날짜</span>
					<span><fmt:formatDate pattern="yyyy년 MM월 dd일 (E)" value="${p.partyYmd}"></fmt:formatDate></span>
				</div>
				<div class="info">
					<span class="list">시간</span>
					<span><fmt:formatDate pattern="a HH시 mm분" value="${p.partyTime}"></fmt:formatDate></span>
				</div>
				<div class="info">
					<span class="list">참여인원</span>
					<span>${p.userCnt} / ${p.partyMax }</span>
				</div>
				<c:if test="${p.items != null}">
				<div class="info">
					<span class="list">준비물</span>
					<span>${p.items }</span>
				</div>
				</c:if>
				<c:if test="${p.condition != null}">
				<div class="info">
					<span class="list">등반조건</span>
					<span>${p.condition }</span>
				</div>
				</c:if>
				<div class="info">
					<span class="list">내용</span>
				</div>
			</div>
			<!--  글 내용  -->
			<div class="content">${p.contents}</div>
			<!--  수정, 삭제, 신고 버튼  -->
			<div class="btns">
				<input type="hidden" id= "targetParty" name="targetParty" value="${p.sanPartyCd}">
				<input type="button" class="modifyRv" name="modifyRv" value="수정" /> 
				<input type="button" class="deleteRv" name="deleteRv" value="삭제" /> 
				<input type="button" class="reportRv" name="reportRv" value="신고" />
			</div>
			<input type="button" class="join" name="join" value="참여하기"/>
		</div>
		<!--  댓글 수  -->
		<div class="cnt">댓글 (${listC.size()})</div>
	</div>
	
	
		<!--   댓글 컨테이너   !-->
	<div class = "container">
       	<c:set var="listC" value="${listC}"/>
       	<!--  댓글 목록  -->
		<!--  새 댓글 작성 폼  -->
		<jsp:include page="../comment/comment.jsp"/>
	</div> 

	<!-- 탑버튼이랑 댓글쓰기버튼  -->
	<div class="to top">top</div> 
	<div class="to cmt">cmt</div>

<jsp:include page="../footer/footer.html"></jsp:include>
</body>

</html>



