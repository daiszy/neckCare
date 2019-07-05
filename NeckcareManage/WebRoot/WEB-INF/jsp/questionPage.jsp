<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title></title>

</head>
<body>
	
	
	<table width="100%" border="3" cellspacing="0" cellpadding="0" style="text-align:center">
		
		<tr>
		 <th width="6%">用户姓名</th>
         <th style="width: 15%; text-align: center;">用户问题</th>
         <th style="width: 15%; text-align: center;">时间</th>
         <th style="width: 15%; text-align: center;">标志</th>
         <th style="width: 15%; text-align: center;">回复</th>
         <th style="width: 15%; text-align: center;">操作</th>
		</tr>
		 <c:forEach var="item" items="${question}">
			<tr>
				<td><c:out value="${item.username}"></c:out></td>
				<td><c:out value="${item.question}"></c:out></td>
				<td><c:out value="${item.time}"></c:out></td>
				<td><c:out value="${item.tag}"></c:out></td>
				<td><input type="text" name="result" value="${item.result}"/>
					<input type="text" value="${item.id}" hidden/>
				</td>
				<td><input type="button" value="提交" onClick="aaa('${item.id})"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.7.js"></script>
<script type="text/javascript" >
	function aaa(id){
		var result=$("input[name='result']").val();
		window.location.href='http://localhost:8080/NeckcareManage/updateQuestion.do?id='+id+'&result='+result;
	}
</script>
</html>