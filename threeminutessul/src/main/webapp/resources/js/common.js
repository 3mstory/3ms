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
