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
        function chck() {
            var sex = document.getElementById("sex")
            if (sex.value == "男"){
                document.getElementById("radio12").checked = true;
            }
            if (sex.value == "女"){
                document.getElementById("radio13").checked = true;
            }
        }
    </script>
</head>

<body onload="chck()">

<input type="hidden" id="sex" value="${allemp[0].sex}">
<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;客户管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>

<form method="post" action="${pageContext.request.contextPath}/ny/employersvl">
    <input type="hidden" name="reqType" value="updateEmpAllDb">
    <input type="hidden" name="emp_id" value="${allemp[0].emp_id}">
  <table width="96%" height="80" border="0" align="center" cellpadding="0" cellspacing="0" >
    <tr>
      <td width="67%" height="40" align="center" nowrap class="MENU_line1">家政服务消费者资料登记表</td>
    </tr>
    <tr>
      <td align="right" nowrap class="MENU_line1 STYLE2">档案编号：GZ20006300223</td>
    </tr>
  </table>
<br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="name" type="text" id="textarea40" value="${allemp[0].name}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">性别：</td>
      <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio12" value="男">
男
  <input type="radio" name="radio" id="radio13" value="女">
女</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF"><input name="age" type="text" id="textarea" value="${allemp[0].age}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="nation" type="text" id="textarea2" value="${allemp[0].nation}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF"><input name="address" type="text" id="textarea5" value="${allemp[0].address}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF"><input name="edu" type="text" id="textarea4" value="${allemp[0].edu}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="idcard" type="text" id="textarea3" value="${allemp[0].idcard}" size="40" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="5" bgcolor="#FFFFFF"><input name="workunit" type="text" id="textarea6" value="${allemp[0].workunit}" size="65" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td bgcolor="#FFFFFF"><input name="occ" type="text" id="textarea7" value="${allemp[0].occ}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">合同号：</td>
      <td colspan="5" bgcolor="#FFFFFF"><input name="contractid" type="text" id="textarea8" value="${allemp[0].contractid}" size="65" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">合同期限：</td>
      <td bgcolor="#FFFFFF"><input name="contracttime" type="text" id="textarea9" value="${allemp[0].contracttime}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">联系电话：</td>
      <td align="center" bgcolor="#FFFFFF">手机</td>
      <td colspan="4" bgcolor="#FFFFFF"><input name="phone" type="text" id="textarea10" value="${allemp[0].phone}" size="44" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">住宅：</td>
      <td bgcolor="#FFFFFF"><input name="mphone" type="text" id="textarea11" value="${allemp[0].mphone}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="resaddress" type="text" id="textarea12" value="${allemp[0].resaddress}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="servaddress" type="text" id="textarea13" value="${allemp[0].servaddress}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="fam_address" type="text" id="textarea14" value="${allemp[0].fam_address}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="fam_people" type="text" id="textarea15" value="${allemp[0].fam_people}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="com_request" type="text" id="textarea16" value="${allemp[0].com_request}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="fam_area" type="text" id="textarea17" value="${allemp[0].fam_area}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="fam_diet" type="text" id="textarea18" value="${allemp[0].fam_diet}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="fam_other" type="text" id="textarea19" value="${allemp[0].fam_other}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="center" nowrap bgcolor="#FFFFFF">要求服务等级：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="remark" type="text" id="textarea20" value="${allemp[0].remark}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="agent" type="text" id="textarea21" value="${allemp[0].agent}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">登记日期：</td>
      <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="reg_time" type="text" id="textarea22" value="${allemp[0].reg_time}" size="65" class="pi"></td>
    </tr>
  </table>
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" align="center" class="text" nowrap><input type="submit" name="searchbtn3" value="保  存" class="button_new" onClick="javascript:location.href='${pageContext.request.contextPath}/ny/ywgl/gzxx.jsp'">
      <input type="button" name="searchbtn3" value="返  回" class="button_new"onClick="javascript:location.href='${pageContext.request.contextPath}/ny/ywgl/gzxx.jsp'" >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</form>
</body>
</html>
