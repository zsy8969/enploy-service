<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="../css/index.css" rel="stylesheet" type="text/css">
<html>
<style type="text/css">
    <!--
    .STYLE2 {
        font-size: 16px
    }

    .STYLE3 {
        color: #FF0000
    }

    -->
</style>
<head>
    <title>Untitled Document</title>
    <script type="text/javascript" src="../tdp/js/validator.js"></script>
    <script type="text/javascript" src="../tdp/js/public.js"></script>
    <script type="text/javascript" src="../javascript/handleArchive.js"></script>
    <script language="JavaScript">
        function doDBClick(url, operator, type) {
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
            var sex = document.getElementById("textarea410");
            if (sex.value == "男") {
                document.getElementById("radio122").checked = true;
            }
            if (sex.value == "女") {
                document.getElementById("radio133").checked = true;
            }
            var type = document.getElementById("textarea16");
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
        }
    </script>

</head>

<body onload="chek()">
<table width="100%" border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
    <tr>
        <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;业务管理--&gt;订单管理</td>
        <td align="right">&nbsp;</td>
    </tr>
</table>
<br/>
<table width="96%" height="80" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="67%" height="40" align="center" nowrap class="MENU_line1">家政服务消费者订单</td>
    </tr>
    <tr>
        <td align="right" nowrap class="MENU_line1 STYLE2">订单编号：GZ20006300223</td>
    </tr>
</table>
<br>
<table width="94%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3" class="text_lb">
    <tr>
        <td width="10%" align="right" bgcolor="#FFFFFF">姓名：</td>
        <td width="13%" bgcolor="#FFFFFF"><input name="textarea40" type="text" id="textarea40" value="${List[0].name}"
                                                 size="15" class="pi"></td>
        <td width="12%" align="right" bgcolor="#FFFFFF">性别：</td>
        <input name="textarea40" type="hidden" id="textarea410" value="${List[0].sex}" size="15" class="pi">
        <td width="17%" bgcolor="#FFFFFF"><input type="radio" name="radio" id="radio122" value="M">
            男
            <input type="radio" name="radio" id="radio133" value="W">
            女
        </td>
        <td width="10%" align="right" bgcolor="#FFFFFF">年龄：</td>
        <td width="13%" bgcolor="#FFFFFF"><input name="textarea" type="text" id="textarea" value="${List[0].age}"
                                                 size="15" class="pi"></td>
        <td width="10%" align="right" bgcolor="#FFFFFF">民族：</td>
        <td width="15%" bgcolor="#FFFFFF"><input name="textarea2" type="text" id="textarea2" value="${List[0].nation}"
                                                 size="15" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">籍贯：</td>
        <td bgcolor="#FFFFFF"><input name="textarea5" type="text" id="textarea5" value="${List[0].address}" size="15"
                                     class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">学历：</td>
        <td bgcolor="#FFFFFF"><input name="textarea4" type="text" id="textarea4" value="${List[0].edu}" size="15"
                                     class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">身份证号码：</td>
        <td colspan="3" bgcolor="#FFFFFF"><input name="textarea3" type="text" id="textarea3" value="${List[0].idcard}"
                                                 size="20" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">户口所在地：</td>
        <td colspan="7" bgcolor="#FFFFFF"><input name="textarea12" type="text" id="textarea12"
                                                 value="${List[0].resaddress}" size="65" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">手机：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea22" value="${List[0].phone}"
                                                  size="15" class="pi"></td>
        <td align="right" nowrap bgcolor="#FFFFFF">住宅：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea22" type="text" id="textarea221"
                                                  value="${List[0].nowaddress}" size="15" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">职业：</td>
        <td colspan="3" bgcolor="#FFFFFF"><input name="textarea8" type="text" id="textarea10" value="${List[0].occ}"
                                                 size="20" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">工作单位：</td>
        <td colspan="7" bgcolor="#FFFFFF"><input name="textarea6" type="text" id="textarea6" value="${List[0].workunit}"
                                                 size="65" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">接受工资：</td>
        <td colspan="2" align="left" bgcolor="#FFFFFF">从
            <input name="textarea11" type="text" id="textarea11" value="${List[0].low_price}" size="8" class="pi">
            到
            <input name="textarea23" type="text" id="textarea23" value="${List[0].high_price}" size="8" class="pi"></td>
        <td align="left" bgcolor="#FFFFFF">&nbsp;</td>
        <td align="right" bgcolor="#FFFFFF">介绍费：</td>
        <td colspan="3" bgcolor="#FFFFFF"><input name="textarea24" type="text" id="textarea24"
                                                 value="${List[1].intro_price}" size="20" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">雇用：</td>
        <td colspan="7" bgcolor="#FFFFFF"><input type="checkbox" name="checkbox4" id="checkbox1"/>
            月嫂
            &nbsp;
            <input type="checkbox" name="checkbox" id="checkbox22"/>
            保姆&nbsp;&nbsp;
            <input type="checkbox" name="checkbox" id="checkbox3"/>
            钟点&nbsp;&nbsp;
            <input type="checkbox" name="checkbox" id="checkbox4"/>
            厨嫂
            <input type="checkbox" name="checkbox" id="checkbox5"/>
            清洁工
            &nbsp;
            <input type="checkbox" name="checkbox" id="checkbox6"/>
            护工&nbsp;&nbsp;
            <input type="checkbox" name="checkbox" id="checkbox7"/>
            早教
            &nbsp;&nbsp;
            <input type="checkbox" name="checkbox" id="checkbox"/>
            家教
            &nbsp;&nbsp;
            <input type="checkbox" name="checkbox" id="checkbox2"/>
            高级管家<br>
            备注：
            <input name="textarea9" type="text" id="textarea9" value="${List[1].other}" size="40" class="pi"></td>
    </tr>
    <tr>
        <td colspan="2" align="right" bgcolor="#FFFFFF">服务处所（地址）：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea13" type="text" id="textarea13"
                                                 value="${List[0].servaddress}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td rowspan="6" align="center" bgcolor="#FFFFFF">家<br>
            庭<br>
            资<br>
            料
        </td>
        <td align="right" bgcolor="#FFFFFF">居住地址：</td>
        <td colspan="6" align="left" bgcolor="#FFFFFF"><input name="textarea14" type="text" id="textarea14"
                                                              value="${List[0].fam_address}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">家庭人数：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea15" type="text" id="textarea15"
                                                 value="${List[0].fam_people}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">服务内容：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea16" type="text" id="textarea16"
                                                 value="${List[0].com_request}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">房屋面积：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea17" type="text" id="textarea17"
                                                 value="${List[0].fam_area}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">饮食习惯：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea18" type="text" id="textarea18"
                                                 value="${List[0].fam_diet}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="right" bgcolor="#FFFFFF">其他：</td>
        <td colspan="6" bgcolor="#FFFFFF"><input name="textarea19" type="text" id="textarea19"
                                                 value="${List[0].fam_other}" size="44" class="pi"></td>
    </tr>
    <tr>
        <td align="center" nowrap bgcolor="#FFFFFF">要求服务等级：</td>
        <td colspan="7" align="left" bgcolor="#FFFFFF"><input name="textarea20" type="text" id="textarea20" value=""
                                                              size="65" class="pi"></td>
    </tr>
    <tr>
        <td align="right" nowrap bgcolor="#FFFFFF">经办人：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea21" type="text" id="textarea21"
                                                  value="${List[1].agentid}" size="14" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">登记日期：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea26" type="text" id="textarea26"
                                                  value="${List[1].reg_time}" size="14" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">订单有效期：</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea27" type="text" id="textarea27"
                                                  value="${List[1].deal_time}" size="14" class="pi"></td>
        <td align="right" bgcolor="#FFFFFF">状态</td>
        <td align="left" bgcolor="#FFFFFF"><input name="textarea27" type="text" id="textarea28"
                                                  value="${List[1].statue}" size="14" class="pi"></td>
</table>
<table width="96%" height="63" border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
        <td width="67%" height="63" align="center" nowrap class="text"><input type="submit" name="searchbtn3"
                                                                              value="返  回" class="button_new"
                                                                              onClick="javascript:location.href='${pageContext.request.contextPath}/ny/ywgl/ddgl.jsp'">
            <input type="hidden" name="mod" value="no">
            &nbsp;&nbsp;
        </td>
    </tr>
</table>
</body>
</html>
