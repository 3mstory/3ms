<<<<<<< HEAD
/* 좋아요,싫어요 비동기처리 */
$(".card-btn-area").on("click", ".btn", function() {
  var seq = parseInt(
    $(this)
      .parents(".card")
      .attr("id")
      .substr(-1)
  );
  var btntx = $(this).children(".card-btntx");
  var type = btntx.hasClass("left") ? "like" : "hate";
  $.ajax({
    //경로입력
    url: "https://my-json-server.typicode.com/JaeCheolSim/JsonHolder/data",
    // data: {
    //   "boardSeq": seq,
    //   "type": type
    // }
    success: function(data) {
      var result = data.result[1];
      var response = result.response;
      if (response === "error") {
        setTimeout(function() {
          $(".vote-toast").toast("show");
        }, 0);
        return;
      }
      var contents = result.cardContent;
      var likecnt = result.likecount;
      var hatecnt = result.hatecount;
      if (type === "like") {
        btntx.text(likecnt);
      } else if (type === "hate") {
        btntx.text(hatecnt);
=======
$(function() {
  /* 카드 컨텐츠 불러오기 예시 */
  $(".accordion").on("click", ".card-btn", function(e) {
    var card = $(e.delegateTarget);
    var cardCont = card.find(".card-contents").text();
    var cardContArea = card.find(".card-collapse");
    var spinner = card.find(".spinner-border");
    var upBtn = card.find(".fa-chevron-up");
    var downBtn = card.find(".fa-chevron-down");
    if (cardCont.trim().length == 0) {
      //한번도 클릭한적 없다면
      cardContArea.hide(); //카드 접힌 상태 유지하기
      $(this)
        .find("i")
        .hide();
      spinner.show();
      $.ajax({
        //경로입력
        url: "https://jsonplaceholder.typicode.com/users",
        type: "GET",
        data: card.attr("id").substr(4)
      }).done(function(data) {
        var content = data[0].email; //이부분 커스텀해주면 될듯!!
        card.find(".card-contents").text(content);
        spinner.hide(); //스피너제거
        cardContArea.show(); //카드 펼치기
        upBtn.show();
      });
    } else {
      upBtn.toggle();
      downBtn.toggle();
    }
  });

  /* 좋아요,싫어요 비동기처리 */
  $(".card-btn-area").on("click", ".btn", function() {
    var seq = parseInt(
      $(this)
        .parents(".card")
        .attr("id")
        .substr(-1)
    );
    var btntx = $(this).children(".card-btntx");
    var type = btntx.hasClass("left") ? "like" : "hate";
    $.ajax({
      //경로입력
      url: "https://my-json-server.typicode.com/JaeCheolSim/JsonHolder/data",
      // data: {
      //   "boardSeq": seq,
      //   "type": type
      // }
      success: function(data) {
        var result = data.result[1];
        var response = result.response;
        if (response === "error") {
          setTimeout(function() {
            $(".vote-toast").toast("show");
          }, 0);
          return;
        }
        var contents = result.cardContent;
        var likecnt = result.likecount;
        var hatecnt = result.hatecount;
        if (type === "like") {
          btntx.text(likecnt);
        } else if (type === "hate") {
          btntx.text(hatecnt);
        }
      },
      error: function(data) {
        console.log(data);
      }
    });
  });

  /* 댓글 비동기 입력 처리*/
  $(".reply_submit_btn").on("click", function(e) {
    var wrapper = $(this).closest(".card-reply-input");
    var input = wrapper.children("input");
    var mention = wrapper.find(".card-reply-mention");
    var card = wrapper.closest(".card");
    var cardId = card.attr("id").substr(-1);
    var text = input.val();
    input.val("");
    input.css("padding-left", "12px");
    mention.text("");
    mention.hide();
    var reqData = {
      cardSeq: cardId,
      content: text
    };
    $.ajax({
      url: "https://my-json-server.typicode.com/JaeCheolSim/JsonHolder/reply",
      //method: "POST",
      //data: reqData,
      success: function(data) {
        var result = data.result;
        if (result !== -1) {
          var replys = wrapper
            .siblings(".card-reply-area")
            .find(".card-replys");
          var replyTmpl = $.templates("#replyTemplate");
          var html = replyTmpl.render(data);
          $(html).appendTo(replys);
        } else {
          makeToast("댓글이 등록 되지 못했습니다.");
        }
      },
      error: function(data) {
        console.log(data);
>>>>>>> 4685fa4af3433701afd24a719fca8d661039c326
      }
    });
  });
  //직접 만든 인피니티 스크롤 라이브러리
  (function() {
    var spinWrap = makeSpinner();
    var isExecuted = false;
    $(window).scroll(function() {
      var top = window.scrollY;
      var docH = document.body.offsetHeight;
      var winH = window.innerHeight;

      if (top >= docH - winH && !isExecuted) {
        isExecuted = true;
        var tmpl = $.templates("#cardTemplate");
        showSpinner(spinWrap);
        $.ajax({
          url:
            "https://my-json-server.typicode.com/JaeCheolSim/JsonHolder/page1",
          success: function(data) {
            var html = tmpl.render(data);
            $(html).appendTo(".accordion");
            hideSpinner(spinWrap);
            isExecuted = false;
          },
          error: function(data) {
            console.log(data);
          }
        });
      }
    });
  })();
});
<<<<<<< HEAD

//직접 만든 인피니티 스크롤 라이브러리
(function() {
  var spinWrap = makeSpinner();
  var isExecuted = false;
  $(window).scroll(function() {
    var top = window.scrollY;
    var docH = document.body.offsetHeight;
    var winH = window.innerHeight;

    if (top >= docH - winH && !isExecuted) {
      isExecuted = true;
      var tmpl = $.templates("#cardTemplate");
      showSpinner(spinWrap);
      $.ajax({
        url: "https://my-json-server.typicode.com/JaeCheolSim/JsonHolder/page1",
        success: function(data) {
          var html = tmpl.render(data);
          $(html).appendTo(".accordion");
          hideSpinner(spinWrap);
          isExecuted = false;
        },
        error: function(data) {
          console.log(data);
        }
      });
    }
  });
})();
=======
>>>>>>> 4685fa4af3433701afd24a719fca8d661039c326
