


$(() => { /* 새 댓글 post 전송  */

	$(".ncmt").click(function(){
		
		$.ajax({
			url : "/InsertComment",
			type : "POST",
			data : 
			{
				targetGb : $(this).siblings("#targetGb").val(),
				targetCd : $(this).siblings("#targetCd").val(),
				userCd : 2, /*수정해야 됨 */
				contents : $(this).prev().val()
			},
			
			success : function(){
				alert("댓글이 등록되었습니다.");
				location.reload();
			},
			error : function(){
			 	alert("댓글 달기  오류남");  /* 나중에 고쳐  */
			}
		});
	});
});


$(() => { /* 답글 관련 */
	
  /* 답글 버튼 클릭시 멘션 작성 창 on */	
  	$(".mentionbtn").click(function () {
	
    	if ($(this).parent().parent().next().css("display") == "none") {
	    	
			$(this).attr('value', "☓ 닫기");
	    	$(this).parent().parent().next().show('normal');
		
    	} else {
		
    		$(this).parent().parent().next().hide('normal');
			$(this).attr('value', "↪ ︎답글");
		}
  	});
  
  	$(".cancle").click(function(){
		console.log('ff');
		$(this).parent().parent().hide('fast');
	});
	/* 등록버튼 클릭 시 멘션 등록 post전송   */
	$(".men").click(function(){
			
		$.ajax({
			url : "/InsertComment",
			type : "POST",
			data : 
			{
				targetGb : $(this).siblings("#targetGb").val(),
				targetCd : $(this).siblings("#targetCd").val(),
				mentionCd : $(this).siblings("#targetComment").val(),
				userCd : 2, /*수정해야 됨 */
				contents : $(this).prev().val()
			},
			
			success : function(data){
				alert("답글이 등록되었습니다.");
				location.reload();
			},
			error : function(){
			 	alert("답글달기  오류남");  /* 나중에 고쳐  */
			}
		});
	});
});

$(() => { /* 수정 관련 */
	
	/* 댓글 수정  */
	$(".modifycmt").click(function() {

		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		let target = $(this).parent().next();
		let ddd = target.html();

		/* 댓글 수정 폼 on */
		target.siblings(".btns").hide('fast');
		target.siblings(".mentionbtn").hide('fast');
		target.siblings(".updatebtn").show('fast');
		target.attr('contenteditable', true);
		target.toggleClass("update", true);
		target.focus();
		
		 /* 수정 post전송  */
		 /* 아수정 됐는데 오류났다고 뜸 ㅋㅋㅋㅋㅋㅋ????왜지?????... 해결... */
		 /* 문제2 : 한번에 하나만 눌리게 해야함..그래야할듯...  */
		$("input[name='updatecmt']").click(function() {

			$.ajax({
				url : "/UpdateComment",
				type : "POST",
				data : 
				{
					commentCd : commentCd,
					userCd : 2,// 수정해야됨 
					contents : $(this).parent().siblings(".comment").html()
				},
				success : function(data){
					alert("댓글 수정이 완료되었습니다.");
					location.reload();
				},
				error : function(){
			 		alert("댓글수정  오류남");  /* 나중에 고쳐  */
				}	
			});
		});
		
	
		/* 댓글 수정 폼 off  */
		$("input[name='updatecls']").click(function() {

			let target = $(this).parent().siblings(".comment");

			/* 취소 눌렀을 때 원래 내용으로 되돌아가야되는데 어떻게함....해결 .. 다시 안해결 ..*/
			/* 멘션이면 답글달기 안생겨야되는데 어캄  ... 해결 */
			target.siblings(".btns").show('fast');	
			target.siblings(".mentionbtn").show('fast');
			target.siblings(".updatebtn").hide('fast');
			target.removeAttr('contenteditable');
			target.html(ddd);
			target.toggleClass("update", false);
		
		});
	});
});