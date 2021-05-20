<%-- header, body start and end includes --%>
<jsp:include page="/WEB-INF/layouts/headerLayout.jsp" />

<%-- add page specific css --%>
<link rel="stylesheet" type="text/css" href="/inbound/style/main.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/tables.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/reports.css">

<%-- add page specific js --%>
<script type="text/javascript" src="/inbound/scripts/component/dataGridSupport.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/dataGrid.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/formSelect.js"> </script>
<script type="text/javascript" src="/inbound/scripts/inbound.js"> </script>
<script type="text/javascript" src="/inbound/scripts/reports.js"> </script>

<title>Reports</title>
<%-- page body start --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutStart.jsp" />


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<c:set var="user" value="${ sessionScope.sessionUser}" />

<h1 class="titleBar"><span class="headerText">Reports</span></h1>
<br/>

 <div id="reportDropDownInfo" style="display: none;">
      		 Selecting a value from the drop down menu will run the report automatically, and it will take sometime to load the result.
  </div>	
  <div id="reportSearchButtonInfo" style="display: none;">
      		 The report will take sometime to load the result.
  </div>

<div id="report">
	<label for="reportSelection">Select Report:&nbsp;&nbsp;</label> 
	<select  id="reportSelection"  aria-describedby="reportDropDownInfo">
		<option value=""></option>
		<option value="SUMMRPT">Summary Report New Rx Only</option>
		<option value="AUTOCHECKRPT">Auto Check Details Report</option>
		<option value="REJECTRESNRPT">Reject Reasons Report</option>
		<option value="ERXSUMMRPT">eRx Summary Report</option>		
	</select>
</div>

<div id="summaryReportFilter">
<form id="summaryReportForm" >
<h2 class="h2title"><span class="reportTitle"></span></h2>
<label for="visnSelection">VISN:&nbsp;&nbsp;</label> 
<div id="summaryReportFormVisnSelect" tabindex="0"  style="width: 40px; ">
<script>
    getVisnSelect();
    	</script>
</div>

	<label for="pharmacyVaStationId">Station ID:&nbsp;&nbsp;</label> 
	<div id="summaryReportFormSelect" tabindex="0"  style="width: 60px; ">
	<script>

		getStationIdSelect(summaryReportForm.visn);
		
	</script>
	</div>

    <div id="erxFilter" style="visability:hidden;">
	<label for="erxTypeSelection">eRx Type:</label> 
	<select  id="erxTypeSelection">
		<option value="ALL">All</option>	
        <option value="CS">CS</option>	
		<option value="NONCS">Non-CS</option>
	</select>
    </div>

	<label for="dateFrom">&nbsp;From Date:&nbsp;&nbsp;</label> 
	<c:set var ="yesterdaysDateVal" value="<%=new java.util.Date(new java.util.Date().getTime() - 60*60*24*1000)%>"/>
	<fmt:formatDate  pattern="yyyy-MM-dd" value="${yesterdaysDateVal}" var="yesterdayDateFormatted"/>
	<input type="text" name="dateFrom" id="dateFrom" value="${yesterdayDateFormatted}"
    data-dojo-type="dijit/form/DateTextBox" required="true" />

	<label for="dateTo">&nbsp;To Date:&nbsp;&nbsp;</label> 
	<input type="text" name="dateTo" id="dateTo" value="now"
    data-dojo-type="dijit/form/DateTextBox" required="true" />
    
 
  <button dojoType="dijit.form.Button" type="button" aria-describedby="reportSearchButtonInfo">Run Report
  <script type="dojo/method" event="onClick" args="evt">		
		getSummaryReport();
  </script>
  </button>
  <button dojoType="dijit.form.Button" type="button" onclick="clearSearch();">Clear</button>
  <button dojoType="dijit.form.Button" type="button" onclick="getReportCSV();">Export</button>  
    <br/>
    </form>
    
<div id="summaryReport" tabindex="0"  class="generatedReportsDivTableParent"></div>
<div id="summaryReportTotals" tabindex="0" style="overflow-x:auto; white-space: nowrap;"></div>
<span id="reportRecNumberTitle" style="width: 250px;padding-top:10px;display: none;">
Number of Records:
<span id="reportRecNumber" style="position:relative;top:-14px;left:112px;display: none;">
</span>
</span>

<div id="reportRunDateTime" style="padding-top: 5px;"></div>

</div>

<%-- end body --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutEnd.jsp" />