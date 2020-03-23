<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
<!--
.STYLE2 {font-size: 16px}
-->
</style>
<head>
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
    <script>
        function chek() {
            var sex = document.getElementById("sex1");
            if (sex.value=="男"){
                document.getElementById("radio122").checked=true;
            }
            if(sex.value=="女"){
                document.getElementById("radio133").checked=true;
            }
        }
    </script>
</head>

<body onload="chek()">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;用工管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>


  <table width="96%" height="80" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
      <td width="67%" height="40" align="center" nowrap class="MENU_line1">家政服务消费订单</td>
    </tr>
    <tr>
      <td align="right" nowrap class="MENU_line1 STYLE2">订单编号：GZ20006300223</td>
    </tr>
  </table>
  <p>雇主：<br>
  </p>

<form action="${pageContext.request.contextPath}/ny/employersvl" method="post">
    <input type="hidden" name="reqType" value="useWork">
    <input type="hidden" name="emp_id" value="${employers[0].com_id}">
  <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="13%" bgcolor="#FFFFFF"><select onchange="window.location.href = this.options[this.selectedIndex].value">
          <c:forEach items="${employers}" var="employer">
	  <option value="${pageContext.request.contextPath}/ny/employersvl?reqType=changeByname&name=${employer.name}">${employer.name}</option>
          </c:forEach>
	  </select></td>
      <td width="12%" align="right" bgcolor="#FFFFFF">性别：</td>
      <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="radio1" id="radio122"  value="M">
男
  <input type="radio" name="radio1" id="radio133" value="W">
女</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea1" value="${employers[0].age}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="${employers[0].nation}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea55" value="${employers[0].address}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea44" value="${employers[0].edu}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea33" value="${employers[0].idcard}" size="20" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12" value="${employers[0].resaddress}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">手机：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea26" value="${employers[0].phone}" size="15" class="pi"></td>
      <td align="right" nowrap bgcolor="#FFFFFF">住宅：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${employers[0].nowaddress}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea100" value="${employers[0].occ}" size="20" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea66" value="${employers[0].workunit}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
      <td colspan="2" align="left" bgcolor="#FFFFFF">从
        <input name="textarea11" type="text" id="textarea11" value="${employers[0].low_price}" size="8" class="pi">
      到
      <input name="textarea23" type="text" id="textarea23" value="${employers[0].high_price}" size="8" class="pi"></td>
      <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">介绍费：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea294" type="text" id="textarea24" value="" size="20" class="pi"></td>
    </tr>
    
    
    
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13" value="${employers[0].resaddress}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14" value="${employers[0].fam_address}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15" value="${employers[0].fam_people}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16" value="${employers[0].com_request}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17" value="${employers[0].fam_area}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18" value="${employers[0].fam_diet}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19" value="${employers[0].fam_other}" size="44" class="pi"></td>
    </tr>
    <tr>
      
      <td colspan="8" align="left" bgcolor="#FFFFFF" height="33"></td>
    </tr>
	   <tr>
      <td colspan="8" align="left" nowrap bgcolor="#FFFFFF">工人：</td>
     
    </tr>
	<tr>
	<td colspan="8"  align="left" bgcolor="#FFFFFF">
	<table height="236" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="88" height="23" align="right" bgcolor="#FFFFFF">员工编号：</td>
      <td width="221" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="" size="30" class="pi"></td>
      <td width="75" align="right" bgcolor="#FFFFFF">所属公司：</td>
      <td width="258" bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="" size="30" class="pi"></td>
      <td width="87" rowspan="8" align="center" valign="middle" bgcolor="#FFFFFF"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td bgcolor="#FFFFFF"><select>
	  <option>王强</option><option>马小虎</option>
	  </select></td>
      <td align="right" bgcolor="#FFFFFF">性别：</td>
      <td bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio" value="radio">
        男
          <input type="radio" name="radio" id="radio2" value="radio">
          女</td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="" size="30" class="pi"></td>
      <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
      <td bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="" size="30" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">年龄：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="" size="30" class="pi"></td>
      <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
      <td bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea8" value="" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="31" align="right" bgcolor="#FFFFFF">手机：</td>
      <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea60" value="" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">电话：</td>
      <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
      <td bgcolor="#FFFFFF"><input name="textarea9" type="text" id="textarea90" value="" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">从业时间：</td>
      <td bgcolor="#FFFFFF"><input name="textarea7" type="text" id="textarea7" value="" size="30" class="pi"></td>
    </tr>
    
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
      <td bgcolor="#FFFFFF"><input name="textarea10" type="text" id="textarea10" value="" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">教育程度：</td>
      <td bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio1" value="radio" />
        大专&nbsp;
        <input type="radio" name="radio" id="radio22" value="radio" />
        高中&nbsp;
        <input type="radio" name="radio" id="radio3" value="radio" />
        初中&nbsp;
        <input type="radio" name="radio" id="radio34" value="radio" />
      小学&nbsp; </td>
    </tr>
   
	</table>
	</td>
	</tr>
	<tr>
      <td align="right" nowrap bgcolor="#FFFFFF">雇用类型：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox4" value="月嫂"/>
        月嫂
&nbsp;
<input type="checkbox" name="checkbox" id="checkbox" value="保姆"/>
保姆&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox1" value="钟点"/>
钟点&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox42" value="厨嫂"/>
厨嫂
<input type="checkbox" name="checkbox" id="checkbox3" value="清洁工"/>
清洁工
&nbsp;
<input type="checkbox" name="checkbox" id="checkbox5" value="护工"/>
 护工&nbsp;&nbsp;
 <input type="checkbox" name="checkbox" id="checkbox6" value="早教"/>
 早教
&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox7" value="家教"/>
家教
&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox2" value="高级管家"/>
高级管家<br>
备注：
<input name="textarea9" type="text" id="textarea9" value="" size="40" class="pi"></td>
    </tr>
	  <tr>
      <td align="right" colspan="8" height="33" nowrap bgcolor="#FFFFFF"></td>
	  </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea212" type="text" id="textarea212" value="" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">工资:</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea221" type="text" id="textarea211" value="" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">订单有效期:</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea271" type="text" id="textarea27" value="" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">状态：</td>
      <td align="left" bgcolor="#FFFFFF"><span class="text">
        <select name="select11" id="select" class="input">
          <option>请选择</option>
          <option selected>未成交</option>
          <option>已成交</option>
          <option>在别处成交</option>
          <option>已取消</option>
      </select>
      </span></td>
    </tr>
  </table>
<table width="96%" height="63" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" height="63" align="center" nowrap class="text"><input type="submit" name="searchbtn3" value="保  存" class="button_new" onClick="location.href='${pageContext.request.contextPath}/ny/ywgl/ddgl.jsp';">
      <input type="button" name="searchbtn3" value="返  回" class="button_new" onClick="javascript:location.href='${pageContext.request.contextPath}/ny/ywgl/ddgl.jsp'" >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</form>
<input type="hidden" id="sex1" value="${employers[0].sex}">
</body>

</html>
