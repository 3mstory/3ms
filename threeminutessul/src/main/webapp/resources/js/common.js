$(function() {
  //auto resize textarea
  $("#card_write").on("keyup", function() {
    var text = $("#card_write").val(),
      matches = text.match(/\n/g),
      breaks = matches ? matches.length : 2;
    $("#card_write").attr("rows", breaks + 2);
  });

  $(".custom-file-input").on("change", function() {
    var fileName = $(this)
      .val()
      .split("\\")
      .pop();
    $(this)
      .siblings(".custom-file-label")
      .addClass("selected")
      .html(fileName);
  });

  /* 카드 컨텐츠 불러오기 예시 */
  $(".card-btn").click(function() {
    var card = $(this).closest(".card");
    var cardCont = card.find(".card-contents");
    var cardContArea = card.find(".card-collapse");
    var spinner = card.find(".spinner-border");
    var upBtn = card.find(".fa-chevron-up");
    var downBtn = card.find(".fa-chevron-down");
    if (!cardCont.text().trim().length && !$(cardCont).children().length) {
      //한번도 클릭한적 없다면
      $(this)
        .find("i")
        .hide();
      spinner.show();
      var boardSeq = card.attr("id").substr(5);
      $.ajax({
        //경로입력
        url: "/threeminutessul/commentList.tmssul",
        type: "GET",
        data: "boardSeq=" + boardSeq
      }).done(function(data) {
        //card.find('.card-replys').empty();
        if (data.toString().indexOf("<script>") > -1) {
          //쫒겨나야함
          alert("로그인을 하고 진행해주시기 바랍니다.");
          location.href = "/threeminutessul/boardList.tmssul";
        } else {
          var content = data.result[0].boardContent; //이부분 커스텀해주면 될듯!!
          $("#commentCount_" + boardSeq).text(data.result[0].commentCnt); //댓글 ?개
          var boardContent = content ? content : "내용이 없습니다.";
          var likecount = card.find(".likecount");
          var hatecount = card.find(".hatecount");
          likecount.text(data.result[0].likecount);
          hatecount.text(data.result[0].hatecount);
          $(cardCont).append(content);
          //댓글 리스트
          $.each(data.result, function(index, object) {
            if (object.commentCnt != 0) {
              /**
               * li 태그 생성 구조(boardList 댓글부분 참조)
               */
              var li = $("<li/>", {
                class: "card-reply-item my-1"
              });
              var button = $("<button/>", {
                type: "button",
                class: "btn btn-outline-secondary writer py-0 px-1 align-top",
                text: object.nickname
              });
              var span = $("<span/>", {
                text: object.content
              });
              $(li).append(button);
              $(li).append(span);
              card.find(".card-replys").append(li); //댓글 리스트
            }
          });

          spinner.hide(); //스피너제거
          //cardContArea.show();//카드 펼치기

          upBtn.show();
        }
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
        .substr(-2)
    );
    var btntx = $(this).children(".card-btntx");
    var type = btntx.hasClass("left") ? "like" : "hate";
    $.ajax({
      //경로입력
      url: "/threeminutessul/likeyhateAjax.tmssul",
      data: {
        boardSeq: seq,
        type: type
      },
      success: function(data) {
        if (data.result == 1) {
          //var result = data.result[0];
          //var response = result.response;
          //var contents = result.cardContent;
          debugger;
          var likecnt = data.likecount;
          var hatecnt = data.hatecount;
          if (type === "like") {
            btntx.text(likecnt);
          } else if (type === "hate") {
            btntx.text(hatecnt);
          }
        } else if (data.result == -1) {
          setTimeout(function() {
            $(".vote-toast").toast("show");
          }, 0);
        }
      },
      error: function(a, b, c) {
        console.log(a, b, c);
      }
    });
  });

  /* 댓글 비동기 입력 처리*/
  $(".reply_submit_btn").on("click", function(e) {
    var wrapper = $(this).closest(".card-reply-input");
    var input = wrapper.children("input");
    var mention = wrapper.find(".card-reply-mention");
    var card = wrapper.closest(".card");
    var cardId = card.attr("id").substr(-2);
    var text = input.val();
    input.val("");
    input.css("padding-left", "12px");
    mention.text("");
    var reqData = {
      boardSeq: cardId,
      content: text
    };
    debugger;
    $.ajax({
      url: "/threeminutessul/commentInsert.tmssul",
      method: "POST",
      data: reqData,
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
      }
    });
  });

  //직접 만든 인피니티 스크롤 라이브러리
  (function() {
    var pagecount = 2;
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
          url: "/threeminutessul/ajaxboardList.tmssul",
          dataType: "json",
          data: "page=" + pagecount,
          success: function(data) {
            if (data.length != 0) {
              var html = tmpl.render(data);
              $(html).appendTo(".accordion");
              hideSpinner(spinWrap);
              isExecuted = false;
              pagecount++;
            } else {
              hideSpinner(spinWrap);
            }
          },
          error: function(data) {
            console.log(data);
          }
        });
      }
    });
  })();
});

/* 토스트 */
function makeToast(content) {
  var tst = $(".toast");
  if (tst.length > 0) {
    showToast(tst, content);
    return;
  }
  var data = {
    content: content
  };
  var tmpl = $.templates("#toastTemplate");
  tst = tmpl.render(data);
  $(tst).appendTo("body");
  showToast($(".toast"), content);
}

function showToast(tst, content) {
  tst.find(".toast-body").text(content);
  setTimeout(function() {
    tst.toast("show");
  }, 0);
}

/* 스피너 */
function makeSpinner(options) {
  var spinOpts = {
    class: "spinner-border text-primary",
    role: "status"
  };
  Object.assign(spinOpts, options);
  var wrapper = $("<div/>", {
    style: "text-align:center"
  });
  var spinner = $("<div/>", spinOpts);
  var spinner_inner = $("<span/>", {
    class: "sr-only",
    text: "로딩중.."
  });
  spinner.append(spinner_inner);
  wrapper.append(spinner);
  return wrapper;
}

function showSpinner(spinwrap) {
  spinwrap.children().addClass("on");
  spinwrap.appendTo(".accordion");
}

function hideSpinner(spinwrap) {
  spinwrap.children().removeClass("on");
  spinwrap = spinwrap.detach();
}
