<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java考试系统--成绩列表</title>
<link type="text/css" rel="stylesheet" href="css/materialize.min.css">
<link type="text/css" rel="stylesheet" href="css/material_icons.css">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<style type="text/css">
body {
	font-family: Roboto, "Microsoft YaHei";
}

.mytable {
	border-collapse: collapse;
	border-bottom: 2px solid #ddd;
}

.mytable td {
	padding: 5px 10px;
}

.namelink a {
	text-decoration: none;
}

.namelink a:LINK {
	color: #12f;
}

.namelink a:VISITED {
	color: #a2e;
}

.namelink a:HOVER {
	color: #17f;
}
</style>
</head>
<body>
	<%@ include file="include/header.jsp" %>
	<div id="main">
		<div class="container" style="min-height:350px;">
			<table class="mytable">
				<thead>
					<tr>
						<th>序号</th>
						<th>姓名</th>
						<th>成绩</th>
						<th>考试名称</th>
						<th>考试类型</th>
					</tr>
				</thead>
				<s:iterator value="examScoreList" status="st" var="item">
					<tr
						style="background-color:<s:if test="#st.odd">#efefef</s:if><s:else>#ffffff</s:else>">
						<td><s:property value="#st.index+1" /></td>
						<td><s:property value="student.name" /></td>
						<td>
							<a class="namelink"
							href="<s:url action="examdetailwithanswer"><s:param name="stu_id" value="%{student.id}"></s:param><s:param name="exam_id" value="%{exam.id}"></s:param><s:param name="exam_strategy_id" value="%{examStrategy.id}"></s:param></s:url>">
								<s:property value="score" />
							</a>
						</td>
						<td><s:property value="exam.name" /></td>
						<td><s:if test="exam.type==1">随机抽题组卷</s:if><s:else>固定组卷</s:else></td>
					</tr>
				</s:iterator>
			</table>
		</div>
	</div>
	<%@ include file="include/footer.jsp" %>
	
	<script type="text/javascript" src="js/jquery-2.1.1.min.js"></script>
	<script type="text/javascript" src="js/materialize.min.js"></script>
	
	<script>
	    $(document).ready(function () {
	        $('.modal-trigger').leanModal({
	            dismissible: true, //是否点模态对话框外面就可以关闭
	            opacity: 0.6, //接近1，不透明
	        });//使用模态对话框，必须有这句
	        
	        $(".button-collapse").sideNav({
	            menuWidth: 200, // Default is 240
	            edge: 'left', // Choose the horizontal origin
	            closeOnClick: true // Closes side-nav on <a> clicks, useful for Angular/Meteor
	        });
	        
	        $(".collapsible").collapsible({
	            accordion: true
	        });
	    })
	   	
	</script>
	<s:debug></s:debug>
</body>
</html>