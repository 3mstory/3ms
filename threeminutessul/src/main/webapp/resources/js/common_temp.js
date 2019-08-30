
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
        var replys = wrapper.siblings(".card-reply-area").find(".card-replys");
        var replyTmpl = $.templates("#replyTemplate");
        var html = replyTmpl.render(data);
        $(html).appendTo(replys);
      } else {
        makeToast("댓글이 등록 되지 못했습니다.");
      }
    },
    error: function(data) {
      console.log(data);
    }
  });
});

