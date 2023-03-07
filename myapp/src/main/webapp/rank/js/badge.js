

$(() => {
    // 모달창 열림
    $(".pick5Setting > button").on({
        click: function () {
            // $(this).next().showModal();
            // $(".pick5Setting > button + dialog").showModal(); 
            // 왜 jq로 show만 되냐?
            // document.querySelector(".pick5Setting > button + dialog").showModal();
            $$(".pick5Setting > button + dialog").showModal();
        }
    }) // showModal

    var clearPick = function() {
        $("dialog .item").removeClass("pick");
        $(".settingError").css("display", "none");
        $("dialog .item").children(".sanBadge").children("span").remove();
        pickList.length = 0;
    };

    // 모달창 닫으면 대표선택 초기화
    // 서밋
    $(".pick5Setting > button + dialog").on({
        close: function () {
            console.log($$(".pick5Setting > button + dialog").returnValue);

            if ($$(".pick5Setting > button + dialog").returnValue === "submit") {
                const targetURL = "/badge/update.do";

                console.log(pickList)
                
                $.ajax({
                    type: "POST",
                    url: targetURL,
                    data: {
                        pickBadgeList: pickList.toString()
                    },
                    // tranditional : true,

                    error: function () {
                        location.reload();
                    },

                    success: function () {
                        let mesg = "";

                        for (let idx = 0; idx < pickList.length; idx++) {
                            mesg += idx + 1 + " : " + pickList[idx] + "\n";
                        }

                        mesg += "저장완료"

                        console.log(mesg)

                        alert(mesg);

                        // clearPick();

                        location.reload();
                    }
                });
            } else {
                clearPick();
            }// if-else

        }
    }) // modal close



    // 대표로 설정할 뱃지의 id를 담을 리스트
    let pickList = Array();
    // console.log(pickList);

    // 모달에서 대표뱃지선택
    $("dialog .item").on({
        click: function () {
            if ($(this).hasClass("pick")) {
                $(this).removeClass("pick");
                $(this).children(".sanBadge").children("span").remove();

                // 리스트에서 삭제
                let pickItem = $(this).prop("id");

                for (let idx = 0; idx < pickList.length; idx++) {
                    if (pickList[idx] === pickItem) {
                        pickList.splice(idx, 1);
                    } // if
                } //for
            } else {
                // 5개 초과부터 선택안되고 에러메세지 출력
                if ($("dialog .item.pick").length == 5) {
                    $(".settingError").css("display", "block")
                } else {
                    $(this).addClass("pick");

                    // id값을 뱃지리스트에 저장
                    let pickItem = $(this).prop("id");

                    console.log(pickItem);

                    pickList.push(pickItem);

                    console.log(pickList);

                    $(this).children(".sanBadge").append("<span class='dot'></span>");
                } // if-else
            } // if- else

            for (let idx = 0; idx < pickList.length; idx++) {
                let pickNum = idx + 1;
                let selectedBadgeId = "#" + pickList[idx];

                // console.log(selectedBadgeId);
                // console.log($(selectedBadgeId));

                $(selectedBadgeId).children(".sanBadge").children("span").text(pickNum);
            } //for
        }
    }); // item in modal onClick

    // 대표 뱃지는 항상 픽 클래스
    $(".badgeBox#pick5 .item").addClass("pick");

    // 누적치 on/off
    $(".dot").on({
        click: function () {
            if ($(this).next().css('display') == 'block') {
                $(this).next().css('display', 'none');
            } else {
                $(this).next().css('display', 'block');
            } // if-else
        }
    });// stackDot onClick

    $(".dot + .stackList ").on({
        click: function () {
            if ($(this).css('display') == 'block') {
                $(this).css('display', 'none');
            } else {
                $(this).css('display', 'block');
            } // if-else
        }
    }); // stackList onClick

}) // .js