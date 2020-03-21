<link href="../css/index.css" rel="stylesheet" type="text/css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath}/houtai/ny/js/jquery.min.js"></script>
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
    <script language="JavaScript">
        window.onload=function () {
            var empSex=document.getElementById("radio12").value;
            if (empSex == "男") {
                document.getElementById("radio12").checked=true;
                document.getElementById("radio13").checked=false;
            }else if (empSex == "女") {
                document.getElementById("radio12").checked=false;
                document.getElementById("radio13").checked=true;
            }

            var wSex=document.getElementById("radio").value;
            if (wSex == "男") {
                document.getElementById("radio").checked=true;
                document.getElementById("radio2").checked=false;
            }else if (wSex == "女") {
                document.getElementById("radio").checked=false;
                document.getElementById("radio2").checked=true;
            }
            
            var wEdu=document.getElementById("radioEdu1").value;
            if (wEdu == "大专") {
                document.getElementById("radioEdu1").checked=true;
            }else if (wEdu == "高中"){
                document.getElementById("radioEdu2").checked=true;
            } else if (wEdu == "初中") {
                document.getElementById("radioEdu3").checked=true;
            }else if (wEdu == "小学") {
                document.getElementById("radioEdu4").checked=true;
            }

            var types=document.getElementById("checkbox1").value;
            var typesArray=new Array();
            typesArray=types.split(",");//分割字符串
            for (i = 0;i<typesArray.length;i++){
                if (typesArray[i]=="月嫂"){
                    document.getElementById("checkbox1").checked=true;
                }else  if (typesArray[i]=="保姆"){
                    document.getElementById("checkbox2").checked=true;
                }else  if (typesArray[i]=="钟点"){
                    document.getElementById("checkbox3").checked=true;
                }else  if (typesArray[i]=="厨嫂"){
                    document.getElementById("checkbox4").checked=true;
                }else  if (typesArray[i]=="清洁工"){
                    document.getElementById("checkbox5").checked=true;
                }else  if (typesArray[i]=="护工"){
                    document.getElementById("checkbox6").checked=true;
                }else if (typesArray[i]=="早教"){
                    document.getElementById("checkbox7").checked=true;
                }else  if (typesArray[i]=="家教"){
                    document.getElementById("checkbox8").checked=true;
                }else  if (typesArray[i]=="高级管家"){
                    document.getElementById("checkbox9").checked=true;
                }
            }
        }
    </script>
</head>

<body>
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
      <td align="right" nowrap class="MENU_line1 STYLE2">订单编号：${deal.dealId}</td>
    </tr>
  </table>
  <p>雇主：<br>
  </p>
  <table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
      <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td width="13%" bgcolor="#FFFFFF">
          <select>
	  <option>${employer.name}</option>
	  </select></td>
      <td width="12%" align="right" bgcolor="#FFFFFF">性别：</td>
        <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="radioSex1" id="radio12" value="${employer.sex}" >
男
            <input type="radio" name="radioSex1" id="radio13" value="" >
女</td>
      <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
      <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${employer.age}" size="15" class="pi"></td>
      <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
      <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="${employer.nation}" size="15" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">籍贯：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="${employer.address}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">学历：</td>
      <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="${employer.edu}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="${employer.idcard}" size="20" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12" value="${employer.resaddress}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">手机：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${employer.phone}" size="15" class="pi"></td>
      <td align="right" nowrap bgcolor="#FFFFFF">住宅：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${employer.nowaddress}" size="15" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">职业：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea10" value="${employer.occ}" size="20" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${employer.workunit}" size="65" class="pi"></td>
    </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
      <td colspan="2" align="left" bgcolor="#FFFFFF">从
        <input name="textarea11" type="text" id="textarea11" value="${employer.low_price}" size="8" class="pi">
      到
      <input name="textarea23" type="text" id="textarea23" value="${employer.high_price}" size="8" class="pi"></td>
      <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
      <td align="right" bgcolor="#FFFFFF">介绍费：</td>
      <td colspan="3" bgcolor="#FFFFFF"><input name="textarea24" type="text" id="textarea24" value="${deal.referralFee}" size="20" class="pi"></td>
    </tr>
    
    
    
    <tr>
      <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13" value="${employer.servaddress}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
      庭<br>
      资<br>
      料</td>
      <td align="right" bgcolor="#FFFFFF">居住地址：</td>
      <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14" value="${employer.fam_address}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15" value="${employer.fam_people}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">服务内容：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16" value="${employer.fam_content}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17" value="${employer.fam_area}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18" value="${employer.fam_diet}" size="44" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">其他：</td>
      <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19" value="${employer.fam_other}" size="44" class="pi"></td>
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
      <td width="221" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${work.work_id}" size="30" class="pi"></td>
      <td width="75" align="right" bgcolor="#FFFFFF">所属公司：</td>
      <td width="258" bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="${deal.companyName}" size="30" class="pi"></td>
      <td width="87" rowspan="8" align="center" valign="middle" bgcolor="#FFFFFF"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">姓名：</td>
      <td bgcolor="#FFFFFF"><select>
	  <option>${work.work_name}</option>
	  </select></td>
      <td align="right" bgcolor="#FFFFFF">性别：</td>
       <td bgcolor="#FFFFFF"><input type="radio" name="radioSex2" id="radio" value="${work.sex}" > <%--<c:if test="${work.sex=='男'}">checked="checked"</c:if>--%>
        男
          <input type="radio" name="radioSex2" id="radio2" value="" > <%-- <c:if test="${work.sex=='女'}">checked="checked"</c:if>--%>
          女</td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">身份证号码：</td>
      <td bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="${work.idcard}" size="30" class="pi"></td>
      <td height="23" align="right" bgcolor="#FFFFFF">出生年月：</td>
      <td bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="${work.date}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td align="right" bgcolor="#FFFFFF">年龄：</td>
      <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="${work.age}" size="30" class="pi"></td>
      <td height="23" align="right" bgcolor="#FFFFFF">身高：</td>
      <td bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea8" value="${work.high}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="31" align="right" bgcolor="#FFFFFF">手机：</td>
      <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${work.mphone}" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">电话：</td>
      <td bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${work.phone}" size="30" class="pi"></td>
    </tr>
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">工种：</td>
      <td bgcolor="#FFFFFF"><input name="textarea9" type="text" id="textarea9" value="${work.work_type}" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">从业时间：</td>
      <td bgcolor="#FFFFFF"><input name="textarea7" type="text" id="textarea7" value="${work.work_time}" size="30" class="pi"></td>
    </tr>
    
    <tr>
      <td height="23" align="right" bgcolor="#FFFFFF">缺陷：</td>
      <td bgcolor="#FFFFFF"><input name="textarea10" type="text" id="textarea10" value="${work.flwa}" size="30" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">教育程度：</td>
      <td bgcolor="#FFFFFF"><input type="radio" name="radioEdu" id="radioEdu1" value="${work.edu}" />
        大专&nbsp;
        <input type="radio" name="radioEdu" id="radioEdu2" value="radio" />
        高中&nbsp;
        <input type="radio" name="radioEdu" id="radioEdu3" value="radio" />
        初中&nbsp;
        <input type="radio" name="radioEdu" id="radioEdu4" value="radio" />
      小学&nbsp; </td>
    </tr>
   
	</table>
	</td>
	</tr>
	<tr>
      <td align="right" nowrap bgcolor="#FFFFFF">雇用类型：</td>
      <td colspan="7" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox4" id="checkbox1" value="${deal.hireType}" />
        月嫂
&nbsp;
<input type="checkbox" name="checkbox4" id="checkbox2" />
保姆&nbsp;&nbsp;
<input type="checkbox" name="checkbox4" id="checkbox3" />
钟点&nbsp;&nbsp;
<input type="checkbox" name="checkbox4" id="checkbox4" />
厨嫂
<input type="checkbox" name="checkbox" id="checkbox5" />
清洁工
&nbsp;
<input type="checkbox" name="checkbox" id="checkbox6" />
 护工&nbsp;&nbsp;
 <input type="checkbox" name="checkbox" id="checkbox7" />
 早教
&nbsp;&nbsp;
<input type="checkbox" name="checkbox" id="checkbox8" />
家教
&nbsp;&nbsp;
<input type="checkbox" name="checkbox2" id="checkbox9" />
高级管家<br>
备注：
<input name="textarea9" type="text" id="textarea1" value="${work.skill},${work.self}" size="40" class="pi"></td>
    </tr>
	  <tr>
      <td align="right" colspan="8" height="33" nowrap bgcolor="#FFFFFF"></td>
	  </tr>
    <tr>
      <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea21" type="text" id="textarea21" value="${deal.agentId}" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">工资:</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea21" type="text" id="textarea21" value="${deal.wage}" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">订单有效期:</td>
      <td align="left" bgcolor="#FFFFFF"><input name="textarea27" type="text" id="textarea27" value="${deal.dealValidity}" size="14" class="pi"></td>
      <td align="right" bgcolor="#FFFFFF">状态：</td>
      <td align="left" bgcolor="#FFFFFF"><span class="text">
        <select name="select" id="select" class="input">
          <option>${deal.state}</option>

      </select>
      </span></td>
    </tr>
  </table>
<table width="96%" height="63" border="0" align="center" cellpadding="0" cellspacing="0" >
  <tr>
    <td width="67%" height="63" align="center" nowrap class="text">
      <input type="submit" name="searchbtn3" value="返  回" class="button_new"onClick="window.history.back()" >
      <input type="hidden" name="mod" value="no">
    &nbsp;&nbsp; </td>
  </tr>
</table>
</body>
</html>
