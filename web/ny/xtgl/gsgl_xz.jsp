<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
<!--
.STYLE1 {	font-size: 24px;
	font-weight: bold;
}
-->
</style>
<head>
  <META http-equiv=Content-Type content="text/html; charset=UTF-8">
<title>Untitled Document</title>
<script type="text/javascript" src="../tdp/js/validator.js"></script>
<script type="text/javascript" src="../tdp/js/public.js"></script>
<script type="text/javascript" src="../javascript/handleArchive.js"></script>
<script language="JavaScript">
function doDBClick(url,operator,type) {
  if (operator == false) {
    document.forms[0].action = url + "&op=view";
    document.forms[0].submit();
  } else {
    document.forms[0].action = url;
    document.forms[0].submit();
  }
}
</script>
</head>

<body>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;系统管理--&gt;公司管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>
<br>
<form action="${pageContext.request.contextPath}/houtai/gsglSvl?reqType=add" method="post">
  <table width="96%" height="49" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="157" height="23" align="right" bgcolor="#FFFFFF">帐号：</td>
      <td width="435" bgcolor="#FFFFFF"><input name="account" type="text" id="textarea1" value="" size="30" class="pi"></td>
      <td width="176" align="right" bgcolor="#FFFFFF">名称：</td>
      <td width="509" bgcolor="#FFFFFF">
      	<input name="name" type="text" id="textarea2" value="" size="30" class="pi">
      
      </td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">简介：</td>
      <td colspan="3" bgcolor="#FFFFFF"><textarea name="intro" id="textarea3" cols="45" rows="5"></textarea></td>
    </tr>
  </table>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap>
    <input type="submit" name="searchbtn3" value="保  存" class="button_new" >
      <input type="button" name="searchbtn3" value="返  回" class="button_new" onClick=window.history.back() >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</form>
</body>
</html>
