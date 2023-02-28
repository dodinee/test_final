
$(() => {

	$(".ncmt").click(function(){
		$("#reviewForm").attr("action", "/InsertComment");
		$("#reviewForm").attr("method", "post");
		$("#current").attr("value", window.location.href);
		$("#contents").attr("value", $(this).prev().val());

		$("#reviewForm").submit();
	});
});

$(() => { /* 답글 관련 */
	
/* 답글 버튼 클릭시 멘션 작성 창 */	
  $(".mentionbtn").click(function () {
	  
    if ($(this).parent().parent().next().css("display") == "none") {
	    
		$(this).attr('value', "☓ 닫기");
	    $(this).parent().parent().next().show('normal');
		
    } else {
		
    	$(this).parent().parent().next().hide('normal');
		$(this).attr('value', "↪ ︎답글");
	}
  });
	/* 등록버튼 클릭 시 멘션 등록 폼 날리기  */
	$(".men").click(function() {

		$("#reviewForm").attr("action", "/InsertComment");
		$("#reviewForm").attr("method", "post");
		$("#current").attr("value", window.location.href);
		$("#mentionCd").attr("value", $(this).prev().val());
		$("#contents").attr("value", $(this).prev().prev().val());
		
		$("#reviewForm").submit();
	});
});




$(() => { /* 신고 관련 */
	/* 신고 버튼 클릭 시 신고 모달창 */
	$(".reportcmt").click(function() {

		/* 폼 속성 설정 */

		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		
		$(".mdcontainer").children('input[name=current]').attr('value', window.location.href);
		$(".mdcontainer").children('input[name=targetCd]').attr('value', commentCd);
		$(".mdcontainer").children('input[name=targetGb]').attr('value', 'COMMENT');
		

		$('input[name=check]').prop('checked', false); /* 체크 초기화 */

//		if($(".mdcontainer").css('display') == 'none'){ /* 모달창 on/off */
			
			$(".mdcontainer").show('normal').css('display', 'flex');/* on */

			$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
				if($(".mdcontainer").has(e.target).length === 0){
					$(".mdcontainer").hide('fast');
				}
			});
			$(document).keydown(function(e){/* esc입력시 닫기 */
    			var code = e.keyCode || e.which;
 
    			if (code == 27) { // 27은 ESC 키번호
        		$(".mdcontainer").hide('fast');
   				}
			});
	});
	/* 취소 버튼 클릭 시 모달 창 제거 */
	$(".mdcancle").click(function(){
		
		$(".mdcontainer").hide('fast');
	});
	/* 신고 버튼 클릭 시 신고 폼 날리기 ( 아 근데 이거 댓글 한정임.......하....)*/
	$(".reportcmt").click(function() {
		
		
	});
});




$(() => { /* 수정 관련 */
	
	$(".modifycmt").click(function() {
	
		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		let target = $(this).parent().next();
		var contents = target.text();

			/* 댓글 수정 폼 on */
			target.prev().hide('fast');
			target.next().hide('fast');
			target.next().next().show('fast');
			target.attr('contenteditable', true);
			target.toggleClass("update", true);
			target.focus();
		
		$(".updatebtn").click(function() { /* 수정 폼 속성 설정 */
				
		$("#updatecmt").children('input[name="current"]').attr('value', window.location.href);
		$("#updatecmt").children('input[name="contents"]').attr('value', $(this).parent().prev().text());
		$("#updatecmt").children('input[name="commentCd"]').attr('value', commentCd);
		$("#updatecmt").submit();
		});
		
	});
	
	/* 댓글 수정 폼 off  */
	$("input[name='updatecls']").click(function() {

		let target = $(this).parent().prev().prev();

		/* 취소 눌렀을 때 원래 내용으로 되돌아가야되는데 어떻게함....*/
		target.prev().show('fast');
		target.next().show('fast');
		target.next().next().hide('fast');
		target.removeAttr('contenteditable');
		target.toggleClass("update", false);
		
	});
});



$(() => { /* 삭제 관련 */
	
	$(".deletecmt").click(function() {
		
		/* 삭제 폼 속성 설정 */
		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		
		$(".delcontainer").children('input[name=commentCd]').attr('value', commentCd);
		$(".delcontainer").children('input[name=current]').attr('value', window.location.href);
		$("#delete").attr('action', '/DeleteComment');
		
//		if($(".delcontainer").css('display') == 'none'){
			$(".delcontainer").show('normal').css('display', 'grid');
			
			$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
				if($(".delcontainer").has(e.target).length === 0){
					$(".delcontainer").hide('fast');
				}
			});
			$(document).keydown(function(e){/* esc입력시 닫기 */
    			var code = e.keyCode || e.which;
 
    			if (code == 27) {
	        		$(".delcontainer").hide('fast');
   				}
			});		
	});
	
	$(".delcancle").click(function() { /* 취소 클릭 시 닫기  */
		$(".delcontainer").hide('fast');
	});
	
});


$(() => { /* 탑, 코멘트 버튼 스크롤 이벤트 */
	
	$(window).scroll(function(){
    
    if( $(this).scrollTop() < 200 ){
      $(".top").hide('normal');
    }
    else{
      $(".top").show('normal');
    }
    
  });

	$(".cmt").click(function() {
	
	 document.getElementById('cmtwrite').scrollIntoView({behavior : 'smooth'});
	});
	
	$(".top").click(function() {
		
		window.scrollTo({top : 0, behavior: 'smooth'}); 
	});
});





/*d아 신고 ㅡㅡ 
$(() => {
	
	$(".mdreport").click(function() {
		
		var form = $("#report");

					form.attr("method", "POST");
					form.attr("action", "<c:url value="/Report" />");

					form.submit();
	}
})

*/


