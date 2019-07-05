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

		
    	<table class="layui-table"  id="test" lay-filter="demo"></table>
		<script type="text/html" id="barDemo">
		  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
			<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
		</script>
    </div>
  </div>
  
  <div class="layui-footer">
    <!-- 底部固定区域 -->

  </div>
</div>
<script src="${pageContext.request.contextPath}/invest_admin/js/layui.js"></script>
<script>
  
	layui.use('table', function(){
		var table = layui.table;
		  
			  table.render({
	    elem: '#test'
	    ,url:'${pageContext.request.contextPath}/GearShow.do'
	    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
	    ,cols: [[
	       {type:'checkbox',fixed: 'left'}
	         ,{field:'id', width:80, title: 'id'} 
	      ,{field:'username', width:100, title: '姓名'}
	      ,{field:'tel', width:150, title: '电话'}
	      ,{field:'password', width:150, title: '密码'}
	      ,{field:'gender', width:80, title: '性别' }
	      ,{field:'datetime', title: '创建时间', width:200,sort: true}
	      ,{field:'operate',title: '操作', width:420,fixed: 'right', align:'center', toolbar: '#barDemo'}
	    ]]
	    ,id: 'testReload' 
	    ,page: true
	    /* ,data:msg.data  */
	  });
		//监听表格复选框选择
		  table.on('checkbox(demo)', function(obj){
		    console.log(obj)
		  });
		  //监听工具条
		  table.on('tool(demo)', function(obj){
		    var data = obj.data;
		    if(obj.event === 'del'){
		    	var flag = confirm("确定删除吗");
		    	if(flag==true){
					$.ajax({
					 url:'deleteUser.do',
					 data:{"id":data.id },
					 type:"POST",
					 dataType:'json',
					})
		    	}else{
		    	
		    	}
		    } else if(obj.event === 'edit'){
		     window.location.href="${pageContext.request.contextPath}/alterPage.do?id="+data.id;
		    }
		  });
		  
		  var $ = layui.$, active = {
		    getCheckData: function(){ //获取选中数据
		      var checkStatus = table.checkStatus('test')
		      ,data = checkStatus.data;
		      layer.alert(JSON.stringify(data));
		    }
		    ,getCheckLength: function(){ //获取选中数目
		      var checkStatus = table.checkStatus('test')
		      ,data = checkStatus.data;
		      layer.msg('选中了：'+ data.length + ' 个');
		    }
		    ,isAll: function(){ //验证是否全选
		      var checkStatus = table.checkStatus('test');
		      layer.msg(checkStatus.isAll ? '全选': '未全选')
		    }
		  };
		  
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
	});
	
</script>
</body>
</html>