

$(() =>{ /* 참여하기 모달창 on/off  */
	
	
	$(".join").click(function() {
		
		$(".joinModal").show('fast').css('display', 'flex');	
		
		$(document).mouseup(function (e){ /* 외부 영역 클릭 시 닫기 */
		
			if($(".joinModal").has(e.target).length === 0){
				$(".joinModal").hide('fast');
			}
		});
		
		$(document).keydown(function(e){/* esc입력시 닫기 */
		
    		var code = e.keyCode || e.which;
 
   			if (code == 27) { // 27은 ESC 키번호
       			$(".joinModal").hide('fast');
 			}
		});
		
		$(".clsbtn").click(function() {
			$(".joinModal").hide('fast');
		});
	});
});

