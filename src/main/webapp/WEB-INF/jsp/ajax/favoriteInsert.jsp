<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert favorite</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
  
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  
  
</head>
<body>

	<label>제목</label>
	<input type="text" name="name" id="nameInput" class="form-control">
	
	<label>주소</label>
	<div class="d-flex">
	<input type="text" name="url" id="urlInput" class="form-control col-9">
	<button class="btn btn-info col-2 ml-4" id="duplicateBtn">중복확인</button>
	</div>
	<div class="text-danger " id="txt-box">중복된 url입니다</div><br>
	<button type="button" id="addBtn" class="btn btn-success btn-block">추가</button>



	<script>
		$(document).ready(function(){
		$("#txt-box").hide();
			
			$("#duplicateBtn").on("click",function(){
				
				let url = $("#urlInput").val();
				
				if(url == ""){
					alert("주소를 입력하세요");
					return false;
				}
				
				$.ajax({
					type:"get",
					url:"/ajax/favorite/is_duplicate",
					data:{"url":url},
					success:function(data){
						//is_duplicate: true
						//is_duplicate: false
						
						if(data.is_duplicate){
						//중복된 상황
						$("#txt-box").show();
						}else{
						$("#txt-box").hide();
						}
						},
					error:function(){
						alert("에러발생");
					}
					
				});
			
			});
		
			
			$("#addBtn").on("click",function(){
				
				
				let name = $("#nameInput").val();
				let url = $("#urlInput").val();
				
				
				if(name == ""){
					alert("제목을 입력하세요");
					return false;
				}
				if(url == ""){
					alert("주소를 입력하세요");
					return false;
				}
				if((!url.startsWith("http://"))&&(!url.startsWith("https://"))){
					alert("유효하지 않은 주소입니다");
					return false;
					}
				
				
				$.ajax({
					
					type:"post",
					url:"/ajax/favorite/insert",
					data:{"name":name,"url":url},
					success:function(data){
						
						if(data.result =="success"){
							
							location.href="/ajax/favorite/list";
						
						}else{
							alert("추가실패");
						}
						
					},
					error:function(){
						alert("에러발생");
					}
					
					
					
				});
				
				
			});
			
			
		});
	
	
	
	
	</script>

</body>
</html>