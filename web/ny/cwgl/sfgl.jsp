<link href="../css/index.css" rel="stylesheet" type="text/css">
<link href="../css/button.css" rel="stylesheet" type="text/css">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html><head>
<title>Untitled Document</title>
<script type="text/javascript" src="../js/public.js"></script>
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
        function queryTime() {
            document.forms.formQuery.submit()
        }
    </script>
</head>

<body>

<table width="100%"  border="0" cellpadding="0" cellspacing="0" bordercolor="#FFFFFF" class="where">
  <tr>
    <td>&nbsp;&nbsp;※&nbsp;您的位置：我的桌面--&gt;财务管理--&gt;收费管理</td>
    <td align="right">&nbsp;</td>
  </tr>
</table>
<br/>

<form id="formQuery" action="${pageContext.request.contextPath}/houtai/sfglSvl?reqType=queryByCritria&pageNow=1" method="post">
  <table width="96%" height="30" border="0" align="center" cellpadding="0" cellspacing="0" class="MENU_line">
    <tr>
      <td width="67%" align="right" class="text" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;日期：
        <input type="text" name="searchName2" maxlength="20" size="12"  class="input">
        到
        <input type="text" name="searchName4" maxlength="20" size="12"  class="input">
        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        <input type="button" name="searchbtn" value="查  询" onclick="queryTime()" class="button_new">
      &nbsp;&nbsp; </td>
    </tr>
  </table>
</form>
  <br>
  <table width="96%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#bdc7d3">
    <tr align="center" class="tdtitle">
      <td nowrap align="center" width="5%">序号</td>
   
      <td width="14%" align="center" nowrap id=".name" >客户名称</td>
      <td width="10%" height="24" align="center" nowrap id=".name" ><div align="center" orderBy="true"><strong>介绍费</strong></div></td>
      <td width="11%" height="24" align="center" nowrap id=".phone" ><div align="center" orderBy="true"><strong>成交日期</strong></div></td>
      <td width="12%" align="center" nowrap id=".register" ><div align="center" orderBy="true"><strong>工人</strong></div></td>
      <td width="21%" align="center" nowrap id=".register" ><strong>所属公司</strong></td>
      <td width="14%" align="center" nowrap id=".submit_date" ><strong>操作</strong></td>
    </tr>
      <c:forEach items="${dealList}" var="deals">
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" onDblClick="doDBClick('bl.htm',true,'2');">
      <td nowrap align="center" width="5%">${deals.dealId} </td>
      <td align="center" nowrap>${deals.employerName}</td>
      <td height="14" align="center" nowrap>${deals.referralFee}</td>
      <td align="center" nowrap>${deals.fixDate}</td>
      <td align="center" nowrap>${deals.workName}</td>
      <td align="center" nowrap>${deals.companyName}</td>
      <td align="center" nowrap><a href="${pageContext.request.contextPath}/houtai/sfglSvl?reqType=findOrder&dealId=${deals.dealId}">查看订单</a></td>
    </tr>
      </c:forEach>
    <tr align="center" class="td2"  onmouseover="javascript:changeBgColorOnMouseOver(this);" onMouseOut="javascript:changeBgColorOnMouseOut(this);" >
      <td colspan="3" align="right" nowrap><strong>合计总额：</strong></td>
      <td height="14" colspan="5" align="left" nowrap>${zonge} <strong>元</strong></td>
    </tr>
  </table>
<table width="96%" height="10"  border="0" align="center" cellpadding="0" cellspacing="0">
    <tr>
      <td><input type="hidden" name="orderType" value="asc">
          <input type="hidden" name="orderFid" value=".submit_date">
          <table width="90%" style="font-size:12px;" border="0" cellspacing="3" cellpadding="2">
            <tr>
              <td nowrap width="45%" align="center"> 当前第${pageNow}页 共${totalRecord}记录 分${totalPages}页显示 </td>
              <td nowrap width="55%" align="right"><input type="hidden" name="currentPage" value="1">
                  <input type="hidden" name="paginationAction" value="">
                  <img src="../image/First_no.gif" alt="第一页" width="18" height="13" border="0" onclick="location.href='../houtai/sfglSvl?reqType=queryAll&pageNow=1'">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Previous_no.gif" alt="上一页" width="14" height="13" border="0" onclick="location.href='../houtai/sfglSvl?reqType=queryAll&pageNow=${pageNow-1}'">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Next_no.gif" alt="下一页" width="14" height="13" border="0" onclick="lastPage()">&nbsp;&nbsp;&nbsp;
                  <img src="../image/Last_no.gif" alt="最后一页" width="18" height="13" border="0" onclick="location.href='../houtai/sfglSvl?reqType=queryAll&pageNow=${totalPages}'">&nbsp;&nbsp;&nbsp;
                  <a href="javascript:gotoPage()"  oncontextmenu="return false" onClick="if(this.document.AwaitForm.pageSelect.value==''){ alert('页码必须输入');return false;}
 else {this.document.AwaitForm.paginationAction.value='gotoPage';}">前往</a>
                  <input id="pageSelect" type=text size='4' onlytype='int' onfocus='checkTextBoxInput()' name='pageSelect' />
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
            window.location.href="${pageContext.request.contextPath}/houtai/sfglSvl?reqType=queryAll&pageNow="+page;
        }else {
            window.location.href="${pageContext.request.contextPath}/houtai/sfglSvl?reqType=queryAll&pageNow="+${pageNow};
        }
    }

    //到达最后一页下一页无用化
    function lastPage() {
        var pageNow=${pageNow};
        var totalPages=${totalPages};
        if (pageNow == totalPages) {
            window.alert("最后一页了！");
        }else {
            window.location.href="../houtai/sfglSvl?reqType=queryAll&pageNow=${pageNow+1}";
        }
    }
</script>
</html>
