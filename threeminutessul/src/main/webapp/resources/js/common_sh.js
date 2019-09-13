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
  		$("#searchSelect").width(bodySize*0.23);
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



