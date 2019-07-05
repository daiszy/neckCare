<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>低头族健康监测后台</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/invest_admin/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">低头族健康监测后台</div>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
     <ul class="layui-nav layui-nav-tree"  lay-filter="test">
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="${pageContext.request.contextPath}/selectUser.do">用户管理</a>
         
        </li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="${pageContext.request.contextPath}/AllDoctors.do">医疗团队管理</a>
          <a class="" href="${pageContext.request.contextPath}/jumpAddDoctor.do">添加医疗团队</a>
	      
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">

	<%-- <form action="${pageContext.request.contextPath}/alterUser.do"  method="post">
		姓名:<input type="text" name="username" value="${user.username}"><br>
		密码:<input type="password" name="tel" value="${user.password}"><br>
		电话:<input type="text" name="password" value="${user.tel}"><br>
		性别:<input type="text" name="gender" value="${user.gender}"><br>
		<input type="text" name="id" value="${user.id}" hidden>
		<input type="submit" value="修改"> <br>
	</form> --%>
<form class="layui-form" action="${pageContext.request.contextPath}/alterUser.do" lay-filter="example">
  <div class="layui-form-item">
    <label class="layui-form-label">姓名</label>
    <div class="layui-input-block">
      <input name="username" class="layui-input" type="text"  value="${user.username}" placeholder="请输入姓名" autocomplete="off" lay-verify="title">
    </div>
  </div>
  <div class="layui-form-item">
    <label class="layui-form-label">密码框</label>
    <div class="layui-input-block">
      <input name="password" class="layui-input" type="password" value="${user.password}" placeholder="请输入密码" autocomplete="off">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">电话</label>
    <div class="layui-input-block">
      <input name="tel" class="layui-input" type="text" value="${user.tel}" placeholder="请输入电话" autocomplete="off">
    </div>
  </div>
   <div class="layui-form-item">
    <label class="layui-form-label">性别</label>
    <div class="layui-input-block">
      <input name="gender" class="layui-input" type="text" value="${user.gender}" placeholder="请输入性别" autocomplete="off">
    </div>
  </div>
  <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
    </div>
  </div>
  <input type="text" name="id" value="${user.id}" hidden>
</form>
	
    	
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->

  </div>
</div>
<script src="${pageContext.request.contextPath}/invest_admin/js/layui.js"></script>

</body>
</html>