<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>
	低头族医疗团队信息管理平台
</title>
</head>
<body>
	<table width="100%" border="3" cellspacing="0" cellpadding="0" style="text-align:center">
		
		<tr>
		 <th width="6%">姓名</th>
         <th style="width: 15%; text-align: center;">电话</th>
         <th style="width: 15%; text-align: center;">密码</th>
         <th style="width: 15%; text-align: center;">创建时间</th>
         <th style="width: 15%; text-align: center;">操作</th>
		</tr>
		 <c:forEach var="item" items="${doctors}">
			<tr>
				<td><c:out value="${item.name}"></c:out></td>
				<td><c:out value="${item.tel}"></c:out></td>
				<td><c:out value="${item.password}"></c:out></td>
				<td><c:out value="${item.time}"></c:out></td>
				<td> <input type="button" value="删除"  onClick="deleteUser(${item.id})" />
					<input type="button" value="修改" onClick="alter(${item.id})" />
				</td>
			</tr>
		</c:forEach>
	
	</table>
	
	<input type="button" value="添加医生" onClick="add()" />
</body>

<script type="text/javascript">
	function deleteUser(id){
	alert("删除成功")
		window.location.href="http://localhost:8080/NeckcareManage/deleteDoctor.do?id="+id
	}
	
	function add(){
		window.location.href="http://localhost:8080/NeckcareManage/jumpAddDoctor.do"
	}
	
	function alter(id){
	window.location.href="http://localhost:8080/NeckcareManage/alterDoctorPage.do?id="+id
	}
</script>
</html>
