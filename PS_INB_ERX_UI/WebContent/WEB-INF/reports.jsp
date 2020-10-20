<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />

<h1 class="titleBar"><span class="headerText">Reports</span></h1>
<br/>

<div id="report">
	<label for="reportSelection">Select Report:&nbsp;&nbsp;</label> 
	<select  id="reportSelection">
		<option value=""></option>
		<option value="SUMMRPT">Summary Report</option>	
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


	<label for="dateFrom">&nbsp;From:&nbsp;&nbsp;</label> 
	<input type="text" name="dateFrom" id="dateFrom" value="now"
    data-dojo-type="dijit/form/DateTextBox" required="true" />

	<label for="dateTo">&nbsp;To:&nbsp;&nbsp;</label> 
	<input type="text" name="dateTo" id="dateTo" value="now"
    data-dojo-type="dijit/form/DateTextBox" required="true" />
    
 
  <button dojoType="dijit.form.Button" type="button">Run Report
  <script type="dojo/method" event="onClick" args="evt">		
		getSummaryReport();
  </script>
  </button>
  <button dojoType="dijit.form.Button" type="button" onclick="getSummaryReportCSV();">Export</button>
  
  
    <br/>
    </form>
    
<span id="summaryReport" tabindex="0"  style="width: 1125px; height: 213px;"></span>
<div id="summaryReportTotals" tabindex="0"  style="width: 1125px; height: 30px;"></div>
<div id="reportRunDateTime" style="padding-top: 5px;"></div>
<span id="reportRecNumberTitle" style="width: 250px;padding-top:10px;display: none;">
Number of Records:
<span id="reportRecNumber" style="position:relative;top:-14px;left:112px;display: none;">
</span>
</span>
</div>

