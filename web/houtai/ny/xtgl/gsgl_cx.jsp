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
        function queryCompanyByCritria() {
            document.forms.form1.submit();
        }

        function removeCompany() {
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
        
        //全选
        function checkAll() {
           var allCheck=document.getElementById("checkbox");
           var checks=document.getElementsByName("checkbox2");
           if (allCheck.checked==true){
               for (i=0;i<checks.length;i++){
                   checks[i].checked=true;
               }
           }else {
               for (i=0;i<checks.length;i++){
                   checks[i].checked=false;
               }
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
<form id="form1" action="${pageContext.request.contextPath}/houtai/gsglSvl?reqType=queryCompany&pageNow=1" method="post">
<table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
  <tr>
    <td width="67%" align="right" class="text" nowrap>     &nbsp;帐号：
      <input type="text" name="queryAccount" maxlength="20" size="12" value="" class="input">
      &nbsp;&nbsp;名称：
      <input type="text" name="queryName" maxlength="20" size="12" value="" class="input">
      <input type="button" name="searchbtn" value="查  询" class="button_new" onclick="queryCompanyByCritria()">
      <input type="button" name="searchbtn2" value="新  增" class="button_new"onClick="javascript:location.href='ny/xtgl/gsgl_xz.jsp?'" >
      <input type="button" name="searchbtn2" value="删  除" class="button_new"onClick="removeCompany()" >
	  <input type="hidden" name="mod" value="no">
      &nbsp;&nbsp; </td>
  </tr>
</table>
</form>
<br>
<form id="form2" action="${pageContext.request.contextPath}/houtai/gsglSvl?reqType=removeCompany" method="post">
    <input type="hidden" name="pageNow" value="${pageNow}">
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="4%"><input onclick="checkAll()" type="checkbox" name="checkbox" id="checkbox"></td>
      <td nowrap align="center" width="6%">序号</td>
      <td width="31%" align="center" nowrap id=".name" >帐号</td>
      <td width="38%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true">名称</div></td>
      <td width="21%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
      <c:forEach items="${companies}" var="company">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="4%"><input type="checkbox" value="${company.company_id}" name="checkbox2" id="checkbox2"></td>
      <td nowrap align="center" width="6%">${company.company_id} </td>
      <td align="center" nowrap>${company.company_account}</td>
      <td height="14" align="center" nowrap>${company.company_name}</td>
        <input type="hidden" name="intro" value="${company.company_intro}">
      <td align="center" nowrap><a href="ny/xtgl/gsgl_xg.jsp?account=${company.company_account}&name=${company.company_name}&intro=${company.company_intro}&id=${company.company_id}&pageNow=${pageNow}">修改</a>&nbsp;&nbsp;
          <a href="ny/xtgl/xzry.htm">选择人员</a> </td>
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
                  <img src="../image/First_no.gif" alt="第一页" width="18" height="13" border="0" onclick="window.location.href='../houtai/gsglSvl?reqType=queryCompany&pageNow=1&queryAccount=${queryAccount}&queryName=${queryName}'">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Previous_no.gif" alt="上一页" width="14" height="13" border="0" onclick="window.location.href='../houtai/gsglSvl?reqType=queryCompany&pageNow=${pageNow-1}&queryAccount=${queryAccount}&queryName=${queryName}'">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Next_no.gif" alt="下一页" width="14" height="13" border="0" onclick="lastPage()">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Last_no.gif" alt="最后一页" width="18" height="13" border="0" onclick="window.location.href='../houtai/gsglSvl?reqType=queryCompany&pageNow=${totalPages}&queryAccount=${queryAccount}&queryName=${queryName}'">&nbsp;&nbsp;&nbsp;
                  <a href="javascript:gotoPage()">前往</a>
                  <input type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' id='pageSelect' value=''/>
                页 </td>
            </tr>
          </table>

      </td>
    </tr>
  </table>

</body>
<script>
    function gotoPage() {
        var page=document.getElementById("pageSelect").value;
        if (page != 0) {
            window.location.href="${pageContext.request.contextPath}/houtai/gsglSvl?reqType=queryCompany&queryAccount=${queryAccount}&queryName=${queryName}&pageNow="+page;
        }else {
            window.location.href="${pageContext.request.contextPath}/houtai/gsglSvl?reqType=queryCompany&queryAccount=${queryAccount}&queryName=${queryName}&pageNow="+${pageNow};
        }
    }

    //到达最后一页下一页无用化
    function lastPage() {
        var pageNow=${pageNow};
        var totalPages=${totalPages};
        if (pageNow == totalPages) {
            window.alert("最后一页了！");
        }else {
            window.location.href="../houtai/gsglSvl?reqType=queryCompany&pageNow=${pageNow+1}&queryAccount=${queryAccount}&queryName=${queryName}";
        }
    }
</script>
</html>
