<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%-- <jsp:include page="/WEB-INF/view/common/header.jsp"></jsp:include> --%>
<jsp:include page="../header/header.html"></jsp:include><%-- 헤더 --%>
<jsp:include page="../report/report2.jsp"></jsp:include><%-- 신고 --%> 
<jsp:include page="../delete/delete.jsp"></jsp:include><%-- 삭제 --%>

 
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>ReviewDetail2222</title>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-migrate/3.4.0/jquery-migrate.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<script src="/header/js/header.js" type="text/javascript" defer></script>
<script src="/review-detail/js/default.js?ver=1" type="text/javascript" defer></script>
<script src="/review-detail/js/review-detail2.js?ver=1" type="text/javascript" defer></script>
<!-- <script src="report/js/report.js?ver=1" type="text/javascript" defer></script> -->

<link rel="stylesheet" href="/header/css/default.css" type="text/css" />
<link rel="stylesheet" href="/header/css/header.css" type="text/css" />
<link rel="stylesheet" href="/review-detail/css/reviewDetail.css?ver=1" type="text/css" />

</head>


<body>

<form id="reviewForm" action = "" method = "" >
	<input type="hidden" id= "targetGb" name="targetGb" value="SAN_REVIEW">
	<input type="hidden" id= "targetCd" name="targetCd" value="${r.sanReviewCd}">
	<input type="hidden" id= "current" name="current" value="">

	<input type="hidden" id= "commentCd" name="commentCd" value="">
	<input type="hidden" id= "mentionCd" name="mentionCd" value="">
	<input type="hidden" id= "contents" name="contents" value="">


<!--  게시글 컨테이너  !-->
	<div class="container">
		<div class="header">
			<div class="mnt">🌱 ${r.sanName} 🌱</div> <%-- 산이름 --%>
			<div class="title">️${r.title}</div> <%-- 글제목 --%>
			<div class="dt"> <%-- 작성일시  --%>
				<fmt:formatDate pattern="MM-dd HH:mm" value="${r.createdDt}"></fmt:formatDate>
			</div>
		</div>
		<div class="contents">
			<img
				src="data:image/jpeg;base64,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"
				alt="" class="userpic" />
			<div class="username">${r.nickname}</div>
			<input class= "like" type="button" value="♥"/>︎
			<div class="content">${r.contents}</div>
			<div class="btns">
				<input type="hidden" id= "targetReview" name="targetReview" value="${r.sanReviewCd}">
				<input type="button" class="modifyRv" name="modifyRv" value="수정" /> 
				<input type="button" class="deleteRv" name="deleteRv" value="삭제" /> 
				<input type="button" class="reportRv" name="reportRv" value="신고" />
			</div>
		</div>
		
		
		
		<div class="cnt">댓글 (${listC.size()})</div>
		
      
      
      
		<!--   댓글 컨테이너   !-->

		<c:forEach items="${listC}" var="c">
			<div class="cmtcontainer">
			
				<c:choose>
					<c:when test="${c.mentionCd == 0}">
						<div class="comments">
					</c:when>
					<c:otherwise>
						<div class="comments mention">
					</c:otherwise>
				</c:choose>
				
				<div class="cmtuser">${c.nickname }</div>
				<div class="cmtdate">
					<fmt:formatDate pattern="MM-dd HH:mm" value="${c.createdDt}"></fmt:formatDate>
				</div>
				<div class="btns">
					<input type="hidden" id= "targetComment" name="targetComment" value="${c.commentCd}">
					<input type="button" class="modifycmt" name="modifycmt" value="수정" /> 
					<input type="button" class="deletecmt" name="deletecmt" value="삭제" /> 
					<input type="button" class="reportcmt" name="reportcmt" value="신고" />
				</div>
				
				<div class="comment">${c.contents}</div>
				<c:if test="${c.mentionCd == 0}">
				<input type="button" class="mentionbtn" name="mentionbtn" value="↪ ︎답글" />
				</c:if>
				<div class="updatebtn">
					<input type="button" name="updatecls" value="취소" />
					<input type="button" name="updatecmt" value="수정" />
				</div>
			</div>
		</div>
	

				
		<!--  멘션 작성 폼  -->
		<c:if test="${c.mentionCd == 0}">
			<div class="mentionwrite">
				<div class="cmtwrite">
					<input type="hidden" id= "targetComment" name="targetComment" value="${c.commentCd}">
					<textarea  name="contents" placeholder="답글을 작성해주세요." required></textarea>
					<input type="button" value="등록" class="insert men"> 
					<input type="reset" value="취소" class="cancle">
				</div>
			</div>
		</c:if>			
	</c:forEach>
	


	<!--  새 댓글 작성 폼  -->
	<div class="cmtwrite" id="cmtwrite">
		<textarea id = "contents" name="contents" placeholder="댓글을 작성해주세요." required></textarea>
		<input type="button" value="등록" class="insert ncmt"> 
		<input type="reset" value="취소" class="cancle">
	</div>
</form>
	
	
	<!-- 탑버튼이랑 댓글쓰기버튼  -->
	<div class="to top">top</div> 
	<div class="to cmt">cmt</div>

	</div>

<jsp:include page="../footer/footer.html"></jsp:include>
</body>

</html>
