<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>mysite</title>
	<meta http-equiv="content-type" content="text/html; charset=utf-8">
	<link href="${pageContext.request.contextPath}/assets/css/board.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">

			<jsp:include page="/WEB-INF/views/includes/header.jsp"></jsp:include>
		
		<div id="navigation">
			
			<jsp:include page="/WEB-INF/views/includes/navigation.jsp"></jsp:include>
		
		</div>
		
		<div id="content">
			<div id="board" class="board-form">
				<table class="tbl-ex">
					<tr>
						<th colspan="2">글보기</th>
					</tr>
					<tr>
						<td class="label">제목</td>
						<td>${view.title}</td>
					</tr>
					<tr>
						<td class="label">내용</td>
						<td>${view.contents}
							<div class="view-contents">
								
							</div>
						</td>
					</tr>
				</table>
				<div class="bottom">
					<a href="board?a=list">글목록</a>
					<c:if test="${view.no == authUser.no }">
					<a href="board?a=modifyfrom&boardno=${view.boardno}">글수정</a>
					</c:if>
				</div>
			</div>
		</div>

		<div id="footer">
			<jsp:include page="/WEB-INF/views/includes/footer.jsp"></jsp:include>
		</div> <!-- /footer -->
	</div>
</body>
</html>