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
            var sex1 = document.getElementById("sex2");
            if (sex.value=="男"){
                document.getElementById("radio122").checked=true;
            }
            if(sex.value=="女"){
                document.getElementById("radio133").checked=true;
            }
            if (sex1.value=="男"){
                document.getElementById("radio1").checked=true;
            }
            if(sex1.value=="女"){
                document.getElementById("radio2").checked=true;
            }
            var type = document.getElementById("textarea166");
            var types = type.value;
            var strs = new Array(); //定义一数组
            strs = types.split(","); //字符分割
            for (i = 0; i < strs.length; i++) {
                if (strs[i] == "月嫂") {
                    document.getElementById("checkbox1").checked = true;

                }
                if (strs[i] == "保姆") {
                    document.getElementById("checkbox22").checked = true;
                }
                if (strs[i] == "钟点") {
                    document.getElementById("checkbox3").checked = true;
                }
                if (strs[i] == "厨嫂") {
                    document.getElementById("checkbox4").checked = true;
                }
                if (strs[i] == "清洁工") {
                    document.getElementById("checkbox5").checked = true;

                }
                if (strs[i] == "护工") {
                    document.getElementById("checkbox6").checked = true;
                }
                if (strs[i] == "早教") {
                    document.getElementById("checkbox7").checked = true;
                }
                if (strs[i] == "家教") {
                    document.getElementById("checkbox").checked = true;
                }
                if (strs[i] == "高级管家") {
                    document.getElementById("checkbox2").checked = true;
                }
            }

            var edu = document.getElementById("textarea156");
            if (edu.value=="大专"){
                document.getElementById("radio").checked=true;
            }
            if(edu.value=="高中"){
                document.getElementById("radio22").checked=true;
            } if(edu.value=="初中"){
                document.getElementById("radio3").checked=true;
            } if(edu.value=="小学"){
                document.getElementById("radio34").checked=true;
            }
            var statu = document.getElementById("textarea157");
            if (statu.value=="未成交"){
                document.getElementById("select").value="a";
            }
            if(statu.value=="已成交"){
                document.getElementById("select").value="b";
            } if(statu.value=="在别处成交"){
                document.getElementById("select").value="c";
            } if(statu.value=="已取消"){
                document.getElementById("select").value="d";
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
    <input type="hidden" name="reqType" value="updateUseWork">
    <input type="hidden" name="dealid" value="${dealList[1].dealid}">
    <input type="hidden" name="emp_id" value="${dealList[1].emp_id}">
    <input type="hidden" name="work_id" value="${dealList[2].work_id}">
  <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="13%" bgcolor="#FFFFFF"><select onchange="window.location.href = this.options[this.selectedIndex].value">

	  <option >${dealList[0].name}</option>

	  </select></td>
      <td width="12%" align="right" bgcolor="#FFFFFF">性别：</td>
      <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="radio1" id="radio122"  value="M">
男
  <input type="radio" name="radio1" id="radio133" value="W">
女</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea1" value="${dealList[0].age}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="${dealList[0].nation}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea55" value="${dealList[0].address}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea44" value="${dealList[0].edu}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea33" value="${dealList[0].idcard}" size="20" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12" value="${dealList[0].resaddress}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">手机：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea26" value="${dealList[0].phone}" size="15" class="pi"></td>
      <td align="right" nowrap bgcolor="#FFFFFF">住宅：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${dealList[0].nowaddress}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea100" value="${dealList[0].occ}" size="20" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea66" value="${dealList[0].workunit}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
      <td colspan="2" align="left" bgcolor="#FFFFFF">从
        <input name="textarea11" type="text" id="textarea11" value="${dealList[0].low_price}" size="8" class="pi">
      到
      <input name="textarea23" type="text" id="textarea23" value="${dealList[0].high_price}" size="8" class="pi"></td>
      <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">介绍费：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea294" type="text" id="textarea24" value="${dealList[1].intro_price}" size="20" class="pi"></td>
    </tr>
    
    
    
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13" value="${dealList[0].servaddress}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14" value="${dealList[0].fam_address}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15" value="${dealList[0].fam_people}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16" value="${dealList[0].com_request}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17" value="${dealList[0].fam_area}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18" value="${dealList[0].fam_diet}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19" value="${dealList[0].fam_other}" size="44" class="pi"></td>
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
      <td width="221" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${dealList[2].work_id}" size="30" class="pi"></td>
      <td width="75" align="right" bgcolor="#FFFFFF">所属公司：</td>
      <td width="258" bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="${dealList[2].company}" size="30" class="pi"></td>
      <td width="87" rowspan="8" align="center" valign="middle" bgcolor="#FFFFFF"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td bgcolor="#FFFFFF"><select>
	  <option>${dealList[2].work_name}</option>
	  </select></td>
      <td align="right" bgcolor="#FFFFFF">性别：</td>
      <td bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio1" value="radio">
        男
          <input type="radio" name="radio" id="radio2" value="radio">
          女</td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="${dealList[2].idcard}" size="30" class="pi"></td>
      <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
      <td bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="${dealList[2].date}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">年龄：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="${dealList[2].age}" size="30" class="pi"></td>
      <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
      <td bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea8" value="${dealList[2].high}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="31" align="right" bgcolor="#FFFFFF">手机：</td>
      <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea60" value="${dealList[2].phone}" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">电话：</td>
      <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${dealList[2].mphone}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
      <td bgcolor="#FFFFFF"><input name="textarea9" type="text" id="textarea90" value="${dealList[2].work_type}" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">从业时间：</td>
      <td bgcolor="#FFFFFF"><input name="textarea7" type="text" id="textarea7" value="${dealList[2].work_time}" size="30" class="pi"></td>
    </tr>
    
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
      <td bgcolor="#FFFFFF"><input name="textarea10" type="text" id="textarea10" value="${dealList[2].flwa}" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">教育程度：</td>
      <td bgcolor="#FFFFFF"><input type="radio" name="radio2" id="radio" value="radio" />
        大专&nbsp;
        <input type="radio" name="radio2" id="radio22" value="radio" />
        高中&nbsp;
        <input type="radio" name="radio2" id="radio3" value="radio" />
        初中&nbsp;
        <input type="radio" name="radio2" id="radio34" value="radio" />
      小学&nbsp; </td>
    </tr>
   
	</table>
	</td>
	</tr>
	<tr>
      <td align="right" nowrap bgcolor="#FFFFFF">雇用类型：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox" id="checkbox1" value="月嫂"/>
        月嫂
&nbsp;
<input type="checkbox" name="checkbox" id="checkbox22" value="保姆"/>
保姆&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox3" value="钟点"/>
钟点&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox4" value="厨嫂"/>
厨嫂
<input type="checkbox" name="checkbox" id="checkbox5" value="清洁工"/>
清洁工
&nbsp;
<input type="checkbox" name="checkbox" id="checkbox6" value="护工"/>
 护工&nbsp;&nbsp;
 <input type="checkbox" name="checkbox" id="checkbox7" value="早教"/>
 早教
&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox" value="家教"/>
家教
&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox2" value="高级管家"/>
高级管家<br>
备注：
<input name="textarea9" type="text" id="textarea9" value="${dealList[1].other}" size="40" class="pi"></td>
    </tr>
	  <tr>
      <td align="right" colspan="8" height="33" nowrap bgcolor="#FFFFFF"></td>
	  </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea212" type="text" id="textarea212" value="${dealList[1].agentid}" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">工资:</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea221" type="text" id="textarea211" value="${dealList[1].price}" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">订单有效期:</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea271" type="text" id="textarea27" value="${dealList[1].deal_time}" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">状态：</td>
      <td align="left" bgcolor="#FFFFFF"><span class="text">
        <select name="select11" id="select" class="input">
          <option value="">请选择</option>
          <option value="a">未成交</option>
          <option value="b">已成交</option>
          <option value="c">在别处成交</option>
          <option value="d">已取消</option>
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
<input type="hidden" id="sex1" value="${dealList[0].sex}">
<input type="hidden" id="sex2" value="${dealList[2].sex}">
<input type="hidden" id="textarea166" value="${dealList[1].employ_type}">
<input type="hidden" id="textarea156" value="${dealList[2].status}">
<input type="hidden" id="textarea157" value="${dealList[1].statue}">
</body>

</html>
