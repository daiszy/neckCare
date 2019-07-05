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
          <a class="" href="${pageContext.request.contextPath}/Gear.do">添加医疗团队</a>
	      
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">
		<form class="layui-form" action="${pageContext.request.contextPath}/updateQuestion.do" lay-filter="example">
		<input type="text" name="id" value="${id}" hidden>
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">文本域</label>
		    <div class="layui-input-block">
		      <textarea name="result" class="layui-textarea" placeholder="请输入内容"></textarea>
		    </div>
		  </div>
		 
		  <div class="layui-form-item">
		    <div class="layui-input-block">
		      <button class="layui-btn" lay-filter="demo1" lay-submit="">立即提交</button>
		    </div>
		  </div>
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