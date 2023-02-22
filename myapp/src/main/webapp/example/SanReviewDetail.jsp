<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%> 
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <style>
      body {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      .mountain {
        background-color: rgb(200, 200, 200);
        border: 3px solid rgb(200, 200, 200);
        border-radius: 10px;
        width: 100px;
        height: 30px;
        text-align: center;
      }
      .title {
        font-size: 30px;
        margin-bottom: 100px;
      }
      .info {
        display: flex;
        justify-content: space-between;
        width: 70%;
      }
      .writer {
        font-size: 20px;
      }
      .contents {
        margin: 100px;
        width: 70%;
      }
      .heart {
        display: flex;
        width: 70%;
        justify-content: flex-end;
      }
    </style>
  </head>
  <body>
    <div class="mountain">${r.sanName}</div>
    <div class="title">${r.title}</div>
    <div class="info">
      <div class="writer">${r.nickname}</div>
      <div class="date">${r.createdDt}</div>
      <input type="button" value="신고" />
    </div>
    <div class="contents">${r.contents}</div>
    <div class="heart">${r.likeCnt}</div>
  </body>
</html>
