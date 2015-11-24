<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>  
<title>用户登录</title> 


<link rel="stylesheet" type="text/css" href="../css/login.css" >
<link rel="stylesheet" type="text/css" href="../css/button.css"/>
<script type="text/javascript" src="../js/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="../js/login.js"></script>
<script type="text/javascript" src="../js/layer.js"></script>

</head> 
<body>
<div class="Body_Content">
	<s:form action="login.action" method="post" >
		<s:textfield name="student.name"></s:textfield>
		<s:submit value="提交"></s:submit>
	</s:form>
	
</div>
</body>
</html>