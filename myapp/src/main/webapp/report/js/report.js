

/* 신고 모달창 on 메소드  */
let reportModal = function(){
	
		const backdrop = document.createElement('div');
		backdrop.classList.add('modalbackground');
		document.body.appendChild(backdrop);
		
	
		$(".mdcontainer").show('normal').css('display', 'flex');/* 신고 모달창 on */

		$('input[name=check]').prop('checked', false); /* 체크 초기화 */
		
		
		/* 신고 모달창 off  */
		
		$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
			if($(".mdcontainer").has(e.target).length === 0){
				$(".mdcontainer").hide('fast');
				backdrop.remove();
			}
		});
		
		$(document).keydown(function(e){/* esc입력시 닫기 */
		
    		var code = e.keyCode || e.which;
 
   			if (code == 27) { // 27은 ESC 키번호
       			$(".mdcontainer").hide('fast');
				backdrop.remove();
 			}
		});
		
		$(".mdcancle").click(function() { /* 취소 버튼 클릭 시 닫기 */
			
			$(".mdcontainer").hide('fast');
			backdrop.remove();
		});
};


$(() => { /* 사유 클릭 시 체크표시  */

      $(".reason").click(function() {
            $(this).prev().prop('checked', true);
      });
});



$(() => {
	/* 신고 버튼 클릭 시 신고 모달창 on */
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

			
$(() => { 

	$(".mdreport").click(function(){
		
		/* 신고 사유 선택됐는지 확인 */
		var radios = document.getElementsByName("check");
   		var checked = false;
   	
   		for (var i = 0; i < radios.length; i++) {
   			if (radios[i].checked) {
       			checked = true;
       			break;
   			}
  	 	}
   		if (!checked) {
   			alert("신고 사유를 선택해주세요.");
   		}
   		else{ /* 선택됐을 경우 post 전송  */
			   
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
	   }
	});
});
