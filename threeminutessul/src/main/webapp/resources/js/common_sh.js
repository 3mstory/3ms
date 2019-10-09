$(".category").on("click",function(){
	nowCategory = $(this).data('category');
});

function isMobile() {
    return /Android|webOS|iPhone|iPad|iPod|BlackBerry|IEMobile|Opera Mini/i.test(navigator.userAgent);
}

function adjustSizeByDevice(){
	if (isMobile()) {
	    // 모바일이면 실행될 코드 들어가는 곳
		
		var bodySize = $("#cont").width();
		
  		$("#title.form-control").css("margin-bottom","20");
  		
  		//List페이지 검색
  		$("#searchSelect").width(bodySize*0.22);
  		$("#searchtext").width(bodySize*0.6);
	} else {
		
		
	    // 모바일이 아니면 실행될 코드 들어가는 곳
	    $('#cont').width("1000px");
	    $('#cont').css('margin','0 auto;');
	    
		  //화면영역 전체크기(위에서 모바일/PC 구분하니까 그 이후에) 잡고 select와 title 조절
  		var bodySize = $("#cont").width();
  		
  		$("#categoryList").width(bodySize*0.14);
  		$("#title").width(bodySize*0.8);
	    
	    $("#categoryList.form-control").css("display","inline-block");
	    $("#title.form-control").css("display","inline-block");
	}
}

//검색어들 사라지도록
$(".navbar-toggler").on("click",function(e){
	$("#search").toggle();
});

//검색버튼
$("#searchBtn").on("click",function(e){
	if($("#searchtext").val() == ""){
		alert("검색어를 입력해주세요.");
		return false;
	}
		
	searchOption = $("#searchSelect").val();
	searchText = $("#searchtext").val();
	var pagecount = 1;
	var tmpl = $.templates("#cardTemplate");
	$.ajax({
		type:"get",
		url:"/threeminutessul/ajaxboardList.tmssul",
		dataType:"json",
		data : "searchoption="+searchOption+"&searchtext="+searchText+"&page = "+pagecount+"&category = "+nowCategory,
		success:function(data){
			$(".accordion").empty();
			console.log(data);
			if(data.length!=0){
				
				var html = tmpl.render(data);
				$(html).appendTo('.accordion');
				
				pagecount++;
			}else{
				var noneData = {searchtext : searchText};
				
				var none = $.templates("#noneTemplate");
				var html = none.render(noneData);
				$(html).appendTo('.accordion');
			}
			$(".navbar-toggler").click();
		},
		error: function(a,b,c){
			console.log(a,b,c);
		}
	});
	
});

$(".deleteBtn").bind("click",function(){
	if(!confirm("해당 썰을 삭제하시겠습니까?")){
		return;
	}
	var boardSeq = $(this).data('boardseq');
	$.ajax({
		type:'POST',
		url:'/threeminutessul/boardDelete.tmssul',
//		contentType:"application/json; charset=utf-8",
		data: 'boardSeq='+boardSeq,
		dataType:'json',
		success:function(result){
			var result = result.result;
			if(result==1){
				location.reload();
			}else{
				alert("알 수 없는 에러 발생.");
			}
		},error:function(xhr, status, er){
			console.log(xhr, status, er);
		}
	});
	
});

$("#joinBtn").on("click", function(e){
	//아이디 중복체크 되었으면.
	if($("input[name='userid']").data('isduplok')){
		if(!$("#password1").val()){
			return false;
		}
		if(!$("#nick").val()){
			return false;
		}
		if(!$("#join-file-input").val()){
			return false;
		}
		$("form").submit();
	}else{
		alert("아이디 중복체크를 해주시기 바랍니다.");
	}
});

$("#idDupl").on("click", function(e){
	var inputId = $("input[name='userid']").val();
	if(!inputId){
		return;
	}
	$("#checktext").css('color', 'red');
	$("#checktext").text("아이디 중복체크중입니다.");
	$.ajax({
		url : 'idduplcheck.tmssul',
		type : 'GET',
	    data : 'inputId='+inputId,
		success : function(result){
			if(result != 'duplicate'){
				//input id 중복체크 상태 true로 변경
				$("#userid").data('isduplok', true);
				$("#checktext").css('color','green');
				$("#checktext").text("확인되었습니다.");
			}else{
				//중복된 상황
				$("#checktext").text("중복된 아이디가 존재합니다.");
			}
		},error : function(a, b, c){
			console.log(a, b, c);
		}
		
	});
});


