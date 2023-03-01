
$(() => { /* 새 댓글 작성 폼  */

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
		$(".mdcontainer").children('input[name="targetCd"]').attr('value', commentCd);

		$('input[name=check]').prop('checked', false); /* 체크 초기화 */

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
});




$(() => { /* 수정 관련 */

	// let ddd;
	
	$(".modifycmt").click(function() {

		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		let target = $(this).parent().next();
		let ddd = target.html();
		console.log(ddd);
			/* 댓글 수정 폼 on */
			target.siblings(".btns").hide('fast');
			target.siblings(".mentionbtn").hide('fast');
			target.siblings(".updatebtn").show('fast');
			target.attr('contenteditable', true);
			target.toggleClass("update", true);
			target.focus();
		
		/* 댓글 수정 폼 속성 설정 */
		$("#reviewForm").attr("action", "/UpdateComment");
		$("#reviewForm").attr("method", "post");
		$("#current").attr("value", window.location.href);
		$("#commentCd").attr('value', commentCd);
	
		 /* 수정 폼 속성 설정 */
		$("input[name='updatecmt']").click(function() {

			$("#contents").attr("value", $(this).parent().siblings(".comment").html());
			$("#reviewForm").submit();
		});
		
	
		/* 댓글 수정 폼 off  */
		$("input[name='updatecls']").click(function() {

		let target = $(this).parent().siblings(".comment");

			/* 취소 눌렀을 때 원래 내용으로 되돌아가야되는데 어떻게함....해결 */
			/* 멘션이면 답글달기 안생겨야되는데 어캄 */
			target.siblings(".btns").show('fast');	
			target.siblings(".mentionbtn").show('fast');
			target.siblings(".updatebtn").hide('fast');
			target.removeAttr('contenteditable');
			target.html(ddd);
			target.toggleClass("update", false);
		
		});
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






