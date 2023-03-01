



$(() => { /* 사유 클릭 시 체크표시  */

      $(".reason").click(function() {
            console.log($(this).prev());
            $(this).prev().prop('checked', true);
      });
});

$(() => { /* 신고 관련 */
	/* 신고 버튼 클릭 시 신고 모달창 */

	$(".mdreport").click(function(){
	
		
		$.ajax({
			url : "http://localhost:8080/Report",
			type : "POST",
			data : 
			{
				current : window.location.href,
				targetGb : "COMMENT",
				targetCd : $("input[name='targetCd']").val(),
				userCd : 2,
				reportGb : $("input[name='check']").val()
			},
			
			success : function(data){
				$(".mdcontainer").hide('fast');
				alert("신고 접수가 완료되었습니다.");
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
