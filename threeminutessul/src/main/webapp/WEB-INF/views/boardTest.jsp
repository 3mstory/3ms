<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 테스트용</title>
</head>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
	.title:hover{
		cursor:pointer;
	}
</style>
<script>
$(document).ready(function(){
	
	$(".title").bind('click',function(){
		var seq = $(this).data("seq");
		var jsonlist = ${jsonlist} ;
		$.each(jsonlist,function(index,object){
			if(object.seq == seq){
				$("#content").show();		
				$("#boardTable").hide();
				$("#content").text(object.content);	
			}
		});
	});
	$('#return').bind('click',function(){
		$("#content").hide();
		$("#boardTable").show();
	});
});
</script>
<body>
	<input type="button" id="return" value="돌아가기" />
	<div id="content"></div>
	<table id ="boardTable">
		<tr>
			<td>글제목</td>
			<td>작성자</td>
			<td>등록일</td>
			<td>좋아요</td>
			<td>싫어요</td>
			<td>익명여부</td>
		</tr>
		
		<c:forEach items="${list}" var ="board">
			<tr>
				<td class="title" data-seq="${board.boardSeq}">${board.title}</td>
				<td>
					<c:choose>
						<c:when test="${board.isanony ==1}">
							익명
						</c:when>
						<c:otherwise>
							${board.writer}
						</c:otherwise>					
					</c:choose>
				</td>
				<td>${board.regdate }</td>
				<td>${board.likey }</td>
				<td>${board.hate }</td>
				<td>${board.isanony }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>
<input type="hidden" id ="hidden"/>