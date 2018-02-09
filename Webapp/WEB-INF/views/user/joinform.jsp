<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/user.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jspry/jquery/jquery-1.12.4.js"></script>
	<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		
		<div id="navigation">
		
			<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		
		</div>
			
		<div id="wrapper">
			<div id="content">
				<div id="user">
	
					<form id="join-form" name="joinForm" method="post" action="${pageContext.request.contextPath}/user/insert">
						
						<label class="block-label" for="name">이름</label>
						<input id="name" name="name" type="text" value="">
	
						<label class="block-label" for="email">이메일</label>
						<input id="email" name="email" type="text" value="">
						<input id="but"type="button" value="id 중복체크">
						<div id="check" ></div>
						
						<label class="block-label">패스워드</label>
						<input name="password" type="password" value="">
						
						<fieldset>
							<legend>성별</legend>
							<label>여</label> <input type="radio" name="gender" value="female" checked="checked">
							<label>남</label> <input type="radio" name="gender" value="male">
						</fieldset>
						
						<fieldset>
							<legend>약관동의</legend>
							<input id="agree-prov" type="checkbox" name="agreeProv" value="y">
							<label>서비스 약관에 동의합니다.</label>
						</fieldset>
						
						<input type="hidden" name="a" value="join">
						<input type="submit" value="가입하기">
						
					</form>
					
				</div><!-- /user -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div> <!-- /footer -->
		
	</div> <!-- /container -->

</body>

<script type="text/javascript">
	
	$("#but").on("click",function(){
		var email = $("#email").val();
		var password = "1111";
		console.log(email);
		
		var userVo={
				email: email,
				password : password
				
		}
		$.ajax({

			url : "${pageContext.request.contextPath }/user/api/emailcheck",
			type : "post",
			contentType : "application/json",
			data : JSON.stringify(userVo),
			
			dataType : "json",
			success : function(result){
			/*성공시 처리해야될 코드 작성*/
			if(result == true){
				
				$("#check").text("사용 가능한 이메일 주소 입니다.")
				
			} else {
				
				$("#check").text("사용 불가능한 이메일 주소 입니다.")
				
				}
				
			},
			
			error : function(XHR, status, error) {
			console.error(status + " : " + error);
			}

			});
	});

</script>

</html>