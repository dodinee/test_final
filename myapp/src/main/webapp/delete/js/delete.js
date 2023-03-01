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