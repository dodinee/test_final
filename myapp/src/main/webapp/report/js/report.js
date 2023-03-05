

/* 신고 모달창 on  */
let reportModal = function(){
	

		$(".mdcontainer").show('normal').css('display', 'flex');/* on */

		$('input[name=check]').prop('checked', false); /* 체크 초기화 */
		
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
		
		$(".mdcancle").click(function() {
			$(".mdcontainer").hide('fast');
		});
};


$(() => { /* 사유 클릭 시 체크표시  */

      $(".reason").click(function() {
            $(this).prev().prop('checked', true);
      });
});



$(() => { /* 신고 관련 */
	/* 신고 버튼 클릭 시 신고 모달창 */
	$(".reportcmt").click( function() {
		
		reportModal();
		
		let commentCd = $(this).parent().children('input[name=targetComment]').val();
		$(".mdcontainer").children('input[name="targetGb"]').attr('value', "COMMENT");
		$(".mdcontainer").children('input[name="targetCd"]').attr('value', commentCd);
	});
	
	$(".reportRv").click( function() {
		
		reportModal();
	});
});


		
		
$(() => { /* 신고 관련 */
	/* 신고 버튼 클릭 시 신고 모달창 */

	$(".mdreport").click(function(){
	
		$.ajax({
			url : "/Report",
			type : "POST",
			data : 
			{
				targetGb : $("input[name='targetGb']").val(),
				targetCd : $("input[name='targetCd']").val(),
				userCd : 2,/* 나중에 바꿔야됨  */
				reportGb : $("input[name='check']:checked").val()
			},
			
			success : function(data){
				
				alert("신고 접수가 완료되었습니다.");
				location.reload();
			},
			error : function(){
			 	alert("신고에서 오류남");  /* 나중에 고쳐  */
			}
		});
	});
	/* 취소 버튼 클릭 시 모달 창 제거 */
	$(".mdcancle").click(function(){
		
		$(".mdcontainer").hide('fast');
	});
});
