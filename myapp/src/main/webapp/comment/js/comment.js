
$(() => { /* 새 댓글 post 전송  */
	
	/* 입력내용에 따라 등록버튼 활성/비활성  */
	$("#contents").on('input', function(){
		
		if($("#contents").val() != ''){
			$(this).next().prop('disabled', false).css({
				'color' : 'white',
				'background-color' : 'rgb(78, 197, 61)',
			});
		}else{
			$(this).next().prop('disabled', true).css({
				'color' : 'gray',
				'background' : 'buttonface' 
			});
		}
	});
	
	$(".cancle").click(function(){
		$(this).prev().prev().val('');
		$(this).prev().prop('disabled', true).css({
				'color' : 'gray',
				'background' : 'buttonface' 
			});
	});
	
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
	
	$(".mentionwrite").hide();
	
  /* 답글 버튼 클릭시 멘션 작성 창 on */	
  	$(".mentionbtn").click(function () {

		/* 다른 멘션창 모두 닫은 후 대상만 on  */
		$(".mentionwrite").hide('normal');
		$(".mcontents").val('');
		$(".mentionbtn").val("↪ ︎답글");
		$(".men").prop('disabled', true).css({
				'color' : 'gray',
				'background' : 'buttonface' 
		});
		
    	if ($(this).parent().parent().next().css("display") == "none") {
	    	
			$(this).val("☓ 닫기");
	    	$(this).parent().parent().next().show('normal');
    	}
  	});
  	/* 취소 클릭 시 멘션 작성 창 off  */
  	$(".cancle").click(function(){
		
		$(this).parent(".mentionwrite").hide('normal');
		$(".mentionbtn").attr('value', "↪ ︎답글");
	});
	
	/* 입력내용에 따라 등록버튼 활성/비활성  */
	$(".mcontents").on('input', function(){
		
		if($(this).val() != ''){
			$(this).next().prop('disabled', false).css({
				'color' : 'white',
				'background-color' : 'rgb(78, 197, 61)',
			});
		}else{
			$(this).next().prop('disabled', true).css({
				'color' : 'gray',
				'background' : 'buttonface' 
			});
		}
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

		/* 댓글 수정중일 때 다른 수정버튼 비활성화 */
		$(".modifycmt").prop('disabled', true);
		
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
	
	
		/* 댓글 수정 폼 off  */
		$("input[name='updatecls']").click(function() {

			/* 수정 중 취소 눌렀을 때 다른 수정버튼 재활성화  */
			$(".modifycmt").prop('disabled', false);
			
			let target = $(this).parent().siblings(".comment");

			/* 취소 눌렀을 때 원래 내용으로 되돌아가야되는데 어떻게함....해결 .. 다시 안해결 ..*/
//			수정버튼이 하나씩만 눌려야됨 댓글 수정중일 때 다른 수정버튼은 비활성화 돼야 됨 ... 해ㅑ결
			/* 멘션이면 답글달기 안생겨야되는데 어캄  ... 해결 */
			target.siblings(".btns").show('fast');	
			target.siblings(".mentionbtn").show('fast');
			target.siblings(".updatebtn").hide('fast');
			target.removeAttr('contenteditable');
			target.html(ddd);
			target.toggleClass("update", false);
		
		});
	
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
	});
});

