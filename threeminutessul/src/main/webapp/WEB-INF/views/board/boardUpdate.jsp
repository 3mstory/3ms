<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport"
		content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0,minimal-ui" />
  <title>3분썰 - 익명 썰 게시판</title>
  <link rel="stylesheet" href="resources/css/style.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
    integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
  <link href="https://fonts.googleapis.com/css?family=Nanum+Gothic:400,700,800&amp;subset=korean" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Gugi" rel="stylesheet">
  <link href="https://fonts.googleapis.com/css?family=Sunflower:300" rel="stylesheet">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/octicons/3.5.0/octicons.min.css">
  <link href="resources/css/custom.css" type="text/css" rel="stylesheet">
  
  <!-- 우성환 css -->
  <link rel="stylesheet" href="resources/css/sh.css" />
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="updateBody">
  <nav class="navbar navbar-expand-sm navbar-light bg-white fixed-top">
    <div class="container justify-content-between align-items-center text-secondary">
      <a href="/threeminutessul/boardList.tmssul"><span class="octicon octicon-home text-secondary"></span></a>
      <h3 class="navbar-brand mx-auto p-0 font-header">
        <span class="font-color-main">썰&nbsp;</span>풀기
      </h3>
      <a href="#" onclick="window.history.back();"><i class=" fas fa-times fa-2x text-secondary"></i></a>
    </div>
  </nav>
  <div class="nvbar-hr"></div>

  <div class="container-fluid" id="cont">
    <form action="/threeminutessul/boardUpdateOk.tmssul" method="post" class="mb-0" novalidate>
      <input type="hidden" name="boardSeq" value="${board.boardSeq}"/>
      <div class="form-group my-3">
      	
      	<input type="text" id="title" class="form-control" name="title" placeholder="글 제목을 입력해주세요." required value="${board.title }" >
       	<select id="categoryList" class="form-control" >
      		<c:forEach items = "${categoryList}" var="category">
      			<option value="">${category.categoryName}</option>
      		</c:forEach>
      	</select>
      </div>
      <div class="form-group">
        <textarea class="form-control vh-75" placeholder="내용을 입력해주세요." name="contents" id="write_cont" cols="30" rows="10"
          required>${board.contents}</textarea>
      </div>
      <nav class="btm-navbar container p-0">
        <ul class="row justify-content-center">
          <li class="px-3 align-items-center">
            <a href="#" class="btn btn-outline-none text-secondary" data-target="#write_submit_chk"
              data-toggle="modal">
              <i class="fas fa-check fa-2x"></i>
            </a>
          </li>
        </ul>
      </nav>
      <div class="modal fade" tabindex="-1" role="dialog" id="write_submit_chk">
        <div class="modal-dialog modal-dialog-centered" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <h5 class="modal-title">정말로 제출 하시겠습니까?</h5>
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
            </div>
            <div class="modal-body">
              <p>글이 간결하고 가독성이 좋을 수록 상단에 노출될 확률이 높아집니다. 수정하시겠습니까?</p>
            </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-outline-secondary px-4" data-dismiss="modal">취소</button>
              <button type="submit" class="btn btn-primary px-4">확인</button>
            </div>
          </div>
        </div>
      </div>
    </form>
  </div>
</div>  
  <script src="https://cdn.ckeditor.com/ckeditor5/12.0.0/classic/ckeditor.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
  <script src="resources/js/common.js"></script>
  <script src="resources/js/CKEditor.js"></script>
  
  <!-- 우성환 스크립트 -->
  <script src="resources/js/common_sh.js"></script>
  <script>
  	$(document).ready(function(){
  		//화면 width 조절
  	  	adjustSizeByDevice();
  		
  	});  	
  </script>
</body>
