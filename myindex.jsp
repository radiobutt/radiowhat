<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>书库网</title>
<link href="css/common.css" rel="stylesheet" media="screen">
</head>
<body>
	<table align="center">
		<div class="search">
			<div class="s-wrap">
		<form action="search">
			<input type="text"  name="Name"> 
			<input type="submit" value="搜索作者">
		</form>
			</div>
		</div>
		</table>
				<div style="font-size: 16px;line-height: 45px;">主页</div>
全部书籍：
				<div class="list">
					<div class="title">书名:</div>
					<div class="author">作者:</div>
					<div class="opration">操作</div>
				</div>
				<s:iterator value="books" var="c">
					<div class="list">
						<div class="title">
						<a href="detail?ISBN=<s:property value="#c.ISBN"/>"><s:property value="#c.Title" /></a>
						</div>
						
						<div class="author">
							<s:property value="#c.Name" />
						</div>
		 	<div class="opration">
							<a href="delete?ISBN=<s:property value="#c.ISBN"/>">删除</a> 						
						</div>
						<br />
					</div>
				</s:iterator>	
	<div class="clear"></div>
<body>
</head>
	