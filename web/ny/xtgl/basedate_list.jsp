<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Untitled Document</title>
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
        function gotoPage() {
            var page=document.getElementById("pageSelect").value;
            if (page != 0) {
                window.location.href="${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryAll&pageNow="+page;
            }else {
                window.location.href="${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryAll&pageNow="+${pageNow};
            }
        }

        function queryByCritria() {
           document.forms.form1.submit();
        }

        //全选
        function allCheck() {
           var allCheck=document.getElementById("checkbox1");
           var checks=document.getElementsByName("checkbox2");
           if (allCheck.checked == true){
               for (i = 0;i<checks.length;i++){
                   checks[i].checked=true;
               }
           }else {
               for (i=0;i<checks.length;i++){
                   checks[i].checked=false;
               }
           }
        }

        function removeData() {
            var count=0;
            var checks=document.getElementsByName("checkbox2");
            for (var i = 0; i < checks.length; i++) {
                if (checks[i].checked==true){
                    count++;
                }
            }
            if (count != 0) {
                var r=confirm("是否删除？");
                if (r==true){
                    document.forms.form2.submit();
                }
            }else {
                alert("请选择记录！");
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
<form id="form1" action="${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryByCritria&pageNow=1" method="post">
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
  <tr>
    <td width="67%" align="right" class="text" nowrap>     &nbsp;&nbsp;&nbsp;类型：
      <select name="selectSort">
        	<option value="1">教育程度</option>
            <option value="2">爱好</option>
            <option value="3">语言</option>
            <option value="4">证照状况</option>
            <option value="5">体检情况</option>
            <option value="6">个人技能</option>
            <option value="7">雇用类型</option>
      </select>
      <input type="button" name="searchbtn" value="查  询" class="button_new" onclick="queryByCritria()">
      <input type="button" name="searchbtn2" value="新  增" class="button_new"onClick="javascript:location.href='ny/xtgl/basedate_add.jsp?totalPages=${totalPages}'" >
      <input type="button" name="searchbtn2" value="删  除" class="button_new"onClick="removeData()" >
	  <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
  </tr>
</table>
</form>
<br>
<form id="form2" action="${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=remove" method="post">
    <input type="hidden" name="pageNow" value="${pageNow}">
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="4%"><input type="checkbox" name="checkbox1" id="checkbox1" onclick="allCheck()"></td>
      <td nowrap align="center" width="6%">序号</td>
      <td width="31%" align="center" nowrap id=".name" >名称</td>
      <td width="38%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true">类型</div></td>
      <td width="21%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
      <c:forEach items="${allDataList}" var="datas">
          <input type="hidden" name="remarks" value="${datas.remarks}"/>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="4%"><input value="${datas.id}" type="checkbox" name="checkbox2" id="checkbox2"></td>
      <td nowrap align="center" width="6%">${datas.id} </td>
      <td align="center" nowrap>${datas.name}</td>
      <td height="14" align="center" nowrap>${datas.sortStr}</td>
      <td align="center" nowrap><a href="ny/xtgl/xgsjzd.jsp?name=${datas.name}&remarks=${datas.remarks}&pageNow=${pageNow}&id=${datas.id}">修改</a>&nbsp;</td>
    </tr>
      </c:forEach>
  </table>
</form>
<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> 当前第${pageNow}页 共${totalRecord}记录 分${totalPages}页显示 </td>
              <td nowrap width="55%" align="right"><input type="hidden" name="currentPage" value="1">
                  <input type="hidden" name="paginationAction" value="">
                  <img src="../image/First_no.gif" alt="第一页" width="18" height="13" border="0" onclick="location.href='${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryAll&pageNow=1'">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Previous_no.gif" alt="上一页" width="14" height="13" border="0" onclick="location.href='${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryAll&pageNow=${pageNow-1}'">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Next_no.gif" alt="下一页" width="14" height="13" border="0" onclick="lastPage()">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Last_no.gif" alt="最后一页" width="18" height="13" border="0" onclick="location.href='${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryAll&pageNow=${totalPages}'">&nbsp;&nbsp;&nbsp;
                  <a href="javascript:gotoPage()">前往</a>
                  <input id="pageSelect" type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' value=''/>页
              </td>
            </tr>
          </table>

      </td>
    </tr>
  </table>

</body>
<script language="JavaScript">
    function lastPage() {
        var pageNow=${pageNow};
        var totalPages=${totalPages};
        if (pageNow == totalPages) {
            window.alert("最后一页了！");
        }else {
            window.location.href="${pageContext.request.contextPath}/houtai/sjzdSvl?reqType=queryAll&pageNow=${pageNow+1}";
        }
    }
</script>
</html>
