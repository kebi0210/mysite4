<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/assets/css/guestbook.css" rel="stylesheet" type="text/css">
	<link href="${pageContext.request.contextPath }/assets/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/assets/jspry/jquery/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath }/assets/bootstrap/js/bootstrap.min.js"></script>
	
	
	
	<title>Insert title here</title>
</head>
<body>

	<div id="container">
		
		<c:import url="/WEB-INF/views/includes/header.jsp"></c:import>
		
		<div id="navigation">
		
		<c:import url="/WEB-INF/views/includes/navigation.jsp"></c:import>
		
		</div> <!-- /navigation -->
		
		<div id="wrapper">
			<div id="content">
				<div id="guestbook">
					
						<table>
							<tr>
								<td>이름</td><td><input id="name" type="text" name="name" /></td>
								<td>비밀번호</td><td><input id="password" type="password" name="password" /></td>
							</tr>
							<tr>
								<td colspan=4><textarea class="content" name="content" id="content"></textarea></td>
							</tr>
							<tr>
								<td colspan=4 align=right><input id="confirm" type="submit" VALUE=" 확인 " /></td>
							</tr>
						</table>
						
				
					<ul id="ListArea">
						
						
						
					</ul>
					<input id="buttonNest" type="submit" VALUE=" 더보기 " />
					<input id="buttonBack" type="submit" VALUE=" 접기" />
				</div><!-- /guestbook -->
			</div><!-- /content -->
		</div><!-- /wrapper -->
		
		<div id="footer">
			<c:import url="/WEB-INF/views/includes/footer.jsp"></c:import>
		</div> <!-- /footer -->
		
	</div> <!-- /container -->

	<!-- 삭제팝업(모달)창 -->
		<div class="modal fade" id="del-pop">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
						<h4 class="modal-title">방명록삭제</h4>
					</div>
					<div class="modal-body">
						<label>비밀번호</label>
						<input type="password" name="modalPassword" id="modalPassword"><br>	
						<input type="hidden" name="modalNo" value="" id="modalNo"> <br>	
						<div id="message" ></div>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-default" data-dismiss="modal">취소</button>
						<button type="button" class="btn btn-danger" id="btn_del">삭제</button>
					</div>
				</div><!-- /.modal-content -->
			</div><!-- /.modal-dialog -->
		</div><!-- /.modal -->


</body>



<script type="text/javascript">
var page = 1;

	$(document).ready(function() {
		
		fetchList();
		
		});
	
	
	$("#buttonNest").on("click", function(){
		page +=1;
		
		fetchList();
		
		});
	
		
		$("#confirm").on("click", function(){
			
			var name = $("#name").val();
			var password = $("#password").val();
			var content = $(".content").val();
			
		var guestbookVo={
				name: name,
				password: password,
				content: content
		}
		//console.log(guestbookVo);
			$.ajax({
				
				url : "${pageContext.request.contextPath }/guestbook/api/insertajax",
				type : "POST",
				contentType : "application/json",
				data :JSON.stringify(guestbookVo),
		
				dataType : "json",
				success : function(guestbookVo){
				/*성공시 처리해야될 코드 작성*/
					console.log(guestbookVo);
					var no = guestbookVo.no;
					
					selectList(no)
					
				},
		
				error : function(XHR, status, error) {
				console.error(status + " : " + error);
				}
	
				});
			});
		
		function fetchList(){	
			
			
			
			$.ajax({

				url : "${pageContext.request.contextPath }/guestbook/api/list",
				type : "post",
				//contentType : "application/json",
				data : {page : page},
			
				dataType : "json",
				success : function(guestbooklist){
				/*성공시 처리해야될 코드 작성*/
					//console.log(guestbooklist);
					
					for(var i=0; i<guestbooklist.length; i++){
						render(guestbooklist[i],"down");	
					}
				
				},
			
				error : function(XHR, status, error) {
				console.error(status + " : " + error);
				}

				});
		
		
		$("#ListArea").on("click",".delajax", function(){
			var no = $(this).data("no");
			
			$("#message").text("");
			$("#modalNo").val(no);
			$("#modalPassword").val("");
			$("#del-pop").modal();
			
		

		});
		
		
		$("#btn_del").on("click", function(){
			var guestbookVo = {
					
					no : $("#modalNo").val(),
					password : $("#modalPassword").val()
					
			}
			
			console.log(guestbookVo);
			$.ajax({
				
				url : "${pageContext.request.contextPath }/guestbook/api/deleteajax",
				type : "POST",
				contentType : "application/json",
				data :JSON.stringify(guestbookVo),
		
				dataType : "json",
				success : function(result){
				/*성공시 처리해야될 코드 작성*/
				
				if(result){
					console.log("제거 완료")
					$("#del-pop").modal("hide");
					//$("#gbVlist")+guestbookVo.no.remove();
					
				}else
					console.log("제거 실패");
					$("#message").text("잘못된 비밀번호 입니다.");
					$("#message").css("color","red");
				},
		
				error : function(XHR, status, error) {
				console.error(status + " : " + error);
				}
	
				});
		});
			
		
		}
	
function render(guestbookVo, Updown){
	
	var str="";
	str +="<li id='gbVlist"+guestbookVo.no+"'></td>";
	str += "<li>";
	str += "	<table>";
	str += "		<tr>";
	str += "			<td>[" + guestbookVo.no + "]</td>";
	str += "			<td>" + guestbookVo.name + "</td>";
	str += "			<td>"+ guestbookVo.regdate +"</td>";
	str += "			<td><input class='delajax' type='button' value='삭제'data-no='"+guestbookVo.no+"'></td>";
	str += "		</tr>";
	str += "		<tr>";
	str += "			<td colspan=4>"+ guestbookVo.content +"</td>";
	str += "		</tr>";
	str += "	</table>";
	str += "	<br>";
	str += "</li>";
	
	if(Updown == "up"){
		
		$("#ListArea").prepend(str);
		
	}else if(Updown == "down"){
		
		$("#ListArea").append(str);
		
	}else{
		
		console.log("updown 오류");
	}
	

}

function selectList(no){

	$.ajax({
	
		url : "${pageContext.request.contextPath }/guestbook/api/selectList",
		type : "POST",
		//contentType : "application/json",
		data :{no: no},

		dataType : "json",
		success : function(selectList){
		/*성공시 처리해야될 코드 작성*/
		
		render(selectList,"up")
		$("input[name='name']").val("");
		$("input[password='password']").val("");
		$("textarea[name='content']").val("");
		},

		error : function(XHR, status, error) {
		console.error(status + " : " + error);
		}

		});
}
</script>






</html>