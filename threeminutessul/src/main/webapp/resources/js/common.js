$(function () {
  //auto resize textarea
  $('#card_write').on('keyup', function () {
    var text = $('#card_write').val(),
      matches = text.match(/\n/g),
      breaks = matches ? matches.length : 2;
    $('#card_write').attr('rows', breaks + 2);
  });

  $('.card-collapse').on('shown.bs.collapse',function(){
    var topoffset = $('.navbar').outerHeight();
    var target = $(this).parents('.card');
    var tgmargin = target.css('margin-top').substr(-2,0);
    $('html, body').animate({
      scrollTop: target.offset().top - topoffset - tgmargin
    },0);
  });

  $(".custom-file-input").on("change", function () {
    var fileName = $(this).val().split("\\").pop();
    $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
  });

  $(".card-reply-item").on('click','button',function(){
    var cardClpse = $(this).closest('.card-collapse');
    var replyMention = cardClpse.find('.card-reply-mention');
    var replyInput = cardClpse.find('.card-reply-input input');
    replyMention.text('@' + $(this).text());
    var mentionSize = replyMention.outerWidth();
    var inpXpad = replyInput.css('padding-right').substr(0,2);
    var totalPadLft = Number(inpXpad) + mentionSize;
    
    replyInput.removeAttr('placeholder');
    replyInput.css('padding-left',totalPadLft+'px');
  });

  /* 카드 컨텐츠 불러오기 예시 */
  $('.card-btn').click(function(){
	/**
	 * 질문 카드를 접을땐 어떻게해야하지?? 그때는 ajax 타면 안되는데
	 */
    var card = $(this).closest('.card');
    var boardSeq = card.attr('id').substr(5).trim()
    var cardCont = card.find('.card-contents');
    var cardContArea = card.find('.card-collapse');
    var spinner = $(this).find('.spinner-border');
    var upBtn = $(this).find('.fa-chevron-up');
    var downBtn = $(this).find('.fa-chevron-down');
    var commentZone = card.find('.card-reply-body ul');
    var replyCount = card.find('.reply-cnt');
    if(cardCont.text().trim().length == 0){ //한번도 클릭한적 없다면 
      downBtn.hide();
      spinner.addClass('on');
      
	  $.ajax({
	    //경로입력
	    url : '/threeminutessul/commentList.tmssul',
	    type : 'GET',
	    dataType:'JSON',
	    data: 'boardSeq='+boardSeq,
	    success:function(data){
//	    	$("#commentList_"+boardSeq).empty();
//	    	if(data.result.length==0){
//	    		var li = $("<li/>",{
//	    			text : '아직 댓글이 달리지 않았습니다.?'
//	    		});
//	    		$("#commentList_"+boardSeq).append(li);
//	    	}
	    	var commentCount = data.result.length;
	    	var boardContent = data.result[0].boardContent ? data.result[0].boardContent : "내용이 없습니다.";
	    	var likecount = card.find(".likecount");
	    	var hatecount = card.find(".hatecount");
	    	likecount.text(data.result[0].likecount? data.result[0].likecount : 9999);
	    	hatecount.text(data.result[0].hatecount? data.result[0].hatecount : 1111);
	    	
	    	replyCount.text(commentCount);
	    	cardCont.text(boardContent);
	        $.each(data.result,function(index,object){
	        	/**
	        	 * li 태그 생성 구조(boardList 댓글부분 참조)
	        	 */
	        	var li = $("<li/>", {
	        		class : 'card-reply-item my-1'
	        	});
	        	var button = $("<button/>",{
	        		type: 'button',
	        		class : 'btn btn-outline-secondary writer py-0 px-1 align-top',
	        		text : object.nickname
	        	});
	        	var span = $("<span/>",{
	        		text : object.content
	        	});
	        	$(li).append(button);
	        	$(li).append(span);
	        	commentZone.append(li);
	        });
	        spinner.removeClass('on'); //스피너제거
	        cardContArea.show();//카드 펼치기	    
	        upBtn.show();
	        downBtn.hide();
	    },
	    error:function(a,b,c){
	    	if($(a.responseText).text().indexOf("로그인")>-1){
	    		spinner.removeClass('on'); //스피너제거
	    		alert('로그인을 하고 진행해주시기 바랍니다.');
	    		downBtn.show();
	    		/**
	    		 * 여기서 로그인 모달을 띄울 수 있나?
	    		 */
	    	}else{
	    		console.log(a,b,c);
	    	}
	    }
	  });
    }
  });
  
  $('.likeyhate').click(function(){
	var hdboardSeq = $($(this).find("input[type=hidden]")[0]).val();
	var hdtype = $($(this).find("input[type=hidden]")[1]).val();
	$.ajax({
		url:'/threeminutessul/likeyhateAjax.tmssul',
		data : 'type='+hdtype+'&boardSeq='+hdboardSeq,
		type:'GET',
		dataType:'json',
		success:function(data){
			if(data.result==1){
				if(hdtype==1){ //좋아요
					$("#likecount_"+hdboardSeq).text(data.count);
				}else{ //싫어요
					$("#hateecount_"+hdboardSeq).text(data.count);
				}
			}else{
				alert("오류가 발생하였습니다. 잠시뒤 다시 진행해주세요.");
			}
		},error:function(a,b,c){
			console.log(a,b,c);
		}
	});
  });
});