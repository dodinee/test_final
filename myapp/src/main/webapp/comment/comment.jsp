<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.zerock.myapp.entity.Comment" %>
<%@page import= "java.util.List" %>
<%@page import= "java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/comment/css/comment.css?ver=1" type="text/css" />
<script src="/comment/js/comment.js?ver=1" type="text/javascript" defer></script>
</head>
<body>


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

				
		<!--  멘션 작성 폼 -->  
		<c:if test="${c.mentionCd == 0}">
			<!-- <div class="mentionwrite"> -->
				<div class="cmtwrite" id="mentionwrite">
					<input type="hidden" id="targetGb" name="targetGb" value="${targetGb}"/>
					<input type="hidden" id="targetCd" name="targetCd" value="${targetCd }"/>
					<input type="hidden" id= "targetComment" name="targetComment" value="${c.commentCd}">
					<textarea  id="mcontents" name="contents" placeholder="답글을 작성해주세요." required></textarea>
					<input type="button" value="등록" class="insert men" disabled> 
					<input type="button" value="취소" class="cancle">
				</div>
			<!-- </div> -->
		</c:if>
	</c:forEach>
	
	<div class="cmtwrite" id="cmtwrite">
	
		<input type="hidden" id="targetGb" name="targetGb" value="${targetGb}"/>
		<input type="hidden" id= "targetCd" name="targetCd" value="${targetCd}"/>	
		<textarea id = "contents" name="contents" placeholder="댓글을 작성해주세요." required></textarea>
		<input type="button" value="등록" class="insert ncmt" disabled> 
		<input type="button" value="취소" class="cancle">
		
	</div>
</body>
</html>