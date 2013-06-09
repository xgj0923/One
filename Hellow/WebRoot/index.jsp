<%@ page language="java" import="java.util.*" import="com.test.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	String str ="";
	Love lv = new Love();
	str = lv.love();
	System.out.println("str:"+str);
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <script type="text/javascript">
  		function ok(){
  			alert(document.getElementById("name").value+","+document.getElementById("fention").value+
  			",select:"+document.getElementById("select").value);
  		}
  </script>
    <base href="<%=basePath%>">
    
    <title>这个测试</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    这个是测试页. <br>
    <form action="">
		<table bgcolor="red" align="center">
		<tr>登入：<%=request.getParameter("username") %></tr>
    	<tr align="center">
    		<td align="center">
				课程名称:
			</td>
			<td align="center">
				<input type=text name="name" id = "yhj" value ="送玩具宝宝回家" />
			</td>
    	</tr>
    	<tr align="center">
    		<td align="center">
				3-6岁教育指南分类：
			</td align="center">
			<td>
				<input type=text name="fention" id = "yhj" value ="社会" />
			</td>
    	</tr>
    	<tr align="center">
    		<td>
				教材分类：
			</td>
			<td align="center">
				<input type=text name="yhj" id = "Test" value ="做做玩玩" />
			</td>
    	</tr>   
    	<tr align="center">
    		<td>
				活动目标（结果）：
			</td>
			<td align="center">
				<input type=textarea name="yhj" id = "Test" value ="1.能与老师一起收拾玩具。2.会将玩具放到固定的位置。
				" />
			</td>
    	</tr>  
    	<tr align="center">
    		<td>
				家庭共育游戏类型：
			</td>
			<td align="center">
				<select style="width:160px" name="select" id = "select">
					<option value ="1">任务类</option>
					<option value ="2">信息类</option>
					<option value ="3">互动类</option>
					<option value ="4">亲子游戏类</option>
					<option value ="5">录入类</option>
					<option value ="6">家庭记录类</option>
				</select>
			</td>
    	</tr> 
    	<tr align="center">
			<td>
				<input type=text value="<%=str %>"/>
			</td>
    		<td align="center">
				<input type=button name="yhj" id = "yhj" value ="go,go,go" onclick="ok()" />
			</td>
    	</tr> 	
    </table>    
    </form>
  </body>
</html>
