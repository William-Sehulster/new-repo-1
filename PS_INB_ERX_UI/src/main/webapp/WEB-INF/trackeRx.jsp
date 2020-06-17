<%-- header, body start and end includes --%>
<jsp:include page="/WEB-INF/layouts/headerLayout.jsp" />

<%-- add page specific css --%>
<link rel="stylesheet" type="text/css" href="/inbound/style/main.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/forms.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/tables.css">

<%-- add page specific js --%>
<script type="text/javascript" src="/inbound/scripts/component/dataGridSupport.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/dataGrid.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/trackDataGrid.js"> </script>
<script type="text/javascript" src="/inbound/scripts/inbound.js"> </script>
<script type="text/javascript" src="/inbound/scripts/trackeRx.js"> </script>


<%-- page body start --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutStart.jsp" />


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />


<h1 class="titleBar"><span class="headerText">Track/Audit eRx</span></h1>

<br/>

<div data-dojo-type="dijit/form/Form" id="searchCriteriaForm" data-dojo-id="searchCriteriaForm" encType="multipart/form-data" action="" method="">


<div style="width: 1100px;" >
<div style="width: 100px;" title="VISN numbers that a VA pharmacy is associated with" >
<label for="trackauditVisnSelection" style="width: 38px;height: 20px;padding-top:2px;">VISN:</label>
<div id="trackauditVisnSelectionDiv"  aria-label="VISN" tabindex="0"  style="width: 60px;margin-top: 0px;">
	
	<select name="trackauditVisnSelection"  id="trackauditVisnSelection" class="dijit dijitReset dijitInline dijitLeft dijitSelect dijitValidationTextBox dijitDownArrowButton dijitSelectFixedWidth dijitValidationTextBoxFixedWidth dijitSelectLabel ">
	            <c:forEach var="item" items="${trackVisnList}">
	      	    <option value="${item.label}">${item.id}</option>
	        	</c:forEach>    
	</select>  	
	
</div> 
</div>
<div style="width: 233px; padding-left: 5px;" >
<label for="pharmacyVaStationId" style="width: 90px;height: 20px;padding-top:2px;">VA Station ID:</label>
<input id="pharmacyVaStationId" name="pharmacyVaStationId"  data-dojo-type="dijit/form/TextBox" value="" maxlength="20" style="width: 127px;padding-top:0px;" title="Station ID of the VA pharmacy"></input> 
</div>
<div style="width: 332px;height: 20px;" title="Beginning date range">
	<label for="dateFrom" style="width: 125px;height: 20px;padding-top:2px; padding-right: 25px;padding-left: 0px; ">From Date:</label> 
	
	<c:set var ="yesterdaysDateVal" value="<%=new java.util.Date(new java.util.Date().getTime() - 60*60*24*1000)%>"/>
	<fmt:formatDate  pattern="yyyy-MM-dd" value="${yesterdaysDateVal}" var="yesterdayDateFormatted"/>
	<input type="text" name="dateFrom" id="dateFrom" constraints="{max: new Date()}" value="${yesterdayDateFormatted}" 
    data-dojo-type="dijit/form/DateTextBox" required="true"  aria-describedby="From Date in MM/DD/YYYY Format" style="padding-top:0px;"/>
</div>
<div style="width: 350px;" title="Ending date range">
	<label for="dateTo" style="width: 125px;height: 20px;padding-top:2px; padding-right: 29px;">To Date:</label> 
	<input type="text" name="dateTo" id="dateTo" constraints="{max: new Date()}" value="now"
    data-dojo-type="dijit/form/DateTextBox" required="true"  aria-describedby="To Date in MM/DD/YYYY Format" style="padding-top:0px;"/>
</div>
</div>

<div style="width: 1100px;" >
<div style="width: 338px;" >
<label for="messageType2" style="width: 125px;height: 20px;padding-top:2px;">Message Type:</label>
<div id="messageType2" name="messageType" value="" style="width: 200px;" data-dojo-type="dijit/form/Select" title="NCPDPD Message Type">
	<span value="">All</span>
	<span value="CancelRx">CancelRx</span>
	<span value="CancelRxResponse">CancelRxResponse</span>
	<span value="Error">Error</span>
	<span value="NewRx">NewRx</span>
	<span value="RefillResponse">RxRenewalResponse</span>
	<span value="RefillRequest">RxRenewalRequest</span>
	<span value="RxChangeResponse">RxChangeResponse</span>
	<span value="RxChangeRequest">RxChangeRequest</span>
	<span value="Status">Status</span>
	<span value="Verify">Verify</span>
</div>
</div>
<label for="messageId2" style="width: 125px;height: 20px;padding-top:2px;">Message ID:</label>
<input id="messageId2" name="messageId" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Message Identifier"></input>
<label for="relatedMessageId2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Relates to Message ID:</label>
<input id="relatedMessageId2" name="relatedMessageId" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Related to Message Identifier"></input>
</div>

<div style="width: 1100px;" >
<label for="patientSsn2" style="width: 125px;height: 20px;padding-top:2px;">Patient SSN:</label>
<input id="patientSsn2" name="patientSsn" data-dojo-type="dijit/form/ValidationTextBox" value="" style="width: 200px;"
 maxlength="11" 
 data-dojo-props="validator: function(text){
 		if (!text){
 		return true;
 		}
 		return dojox.validate.us.isSocialSecurityNumber(text);
 		}, invalidMessage: 'The SSN value must in the format of ###-##-#### or #########', required: false" title="Patient Social Security Number"  ></input>    
<label for="patientLastName2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Patient Last Name:</label>
<input id="patientLastName2" name="patientLastName" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Patient Last Name"></input>
<label for="patientFirstName2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Patient First Name:</label>
<input id="patientFirstName2" name="patientFirstName" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Patient First Name" ></input>
</div>

<div style="width: 1100px;" >
<label for="patientDob2" style="width: 125px;height: 20px;padding-top:2px;">Patient D.O.B:</label>
<input id="patientDob2" name="patientDob"  data-dojo-type="dijit/form/DateTextBox" value="" style="width: 200px;" title="Patient Date of Birth" ></input>
<label for="prescriberNPI2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Prescriber NPI:</label>
<input id="prescriberNPI2" name="prescriberNPI" data-dojo-type="dijit/form/ValidationTextBox" value="" style="width: 200px;" maxlength="10" data-dojo-props="regExp: '[0-9$%!_]{10,10}', invalidMessage: 'The NPI value must be numeric and 10 digits in length'"  name="prescriberNPI2" title="National Provider Identifier" ></input>    
<label for="prescribedDrug2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Prescribed Drug:</label>
<input id="prescribedDrug2" name="prescribedDrug" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Prescribed Drug from eRx" ></input>
</div>

<div style="width: 1100px;" >
<label for="prescriberLastName2" style="width: 125px;height: 20px;padding-top:2px;">Prescriber Last Name:</label>
<input id="prescriberLastName2" name="prescriberLastName" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Prescriber Last Name"></input>
<label for="prescriberFirstName2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Prescriber First Name:</label>
<input id="prescriberFirstName2" name="prescriberFirstName" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Prescriber First Name" ></input>
<label for="prescriberDEA2" style="width: 125px;height: 20px;padding-top:2px;padding-left:10px;">Prescriber DEA#:</label>
<input id="prescriberDEA2" name="prescriberDEA2" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="35" title="Prescriber DEA Number" ></input>  
</div>

<div style="width: 1100px;" >
<label for="inboundNcpdpMessageId" style="width: 125px;height: 20px;padding-top:2px;">eRx Reference #:</label>
<input id="inboundNcpdpMessageId" name="inboundNcpdpMessageId" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="10" title="Internal VA Processing Hub Unique Identifier (eRx Reference Number)"></input>    

<div style="width: 330px;" title="Received (Inbound messages) or Sent (Outbound messages)" >
<label for="inboundOutbound" style="width: 125px;height: 20px;padding-top:2px;padding-left: 10px;">Sent or Received:</label>
<div id="inboundOutbound" name="inboundOutbound" value="Inbound" style="width: 180px;" data-dojo-type="dijit/form/Select">
	<span value="Inbound">Received</span>
	<span value="Outbound">Sent</span>
</div>
</div>

<div style="width: 420px;" title="Processing Hub Message Status">
<label for="messageStatus" style="width: 100px;height: 20px;padding-top:2px;padding-right: 26px; padding-left: 14px;">Message Status:</label>
<div id="messageStatus" name="messageStatus" style="width: 250px;" data-dojo-type="dijit/form/Select">
	<span value="">All</span>
	<span value="3001">AUTOCHECK_PROCESSING_COMPLETED</span>
    <span value="3002">VISTAOP_DELIVERY_SUCCESSFUL</span>
    <span value="3003">VISTAOP_DELIVERY_IN_PROCESS</span>
    <span value="3005">VISTAOP_DELIVERY_RETRIES_EXCEEDED</span>
    <span value="3009">AUTOCHECK_IN_PROGRESS</span>
    <span value="3010">PHARMACY_INBOUND_ERX_NOT_ENABLED</span>
    <span value="3011">PHARMACY_UNKNOWN</span>
    <span value="4001">OB_MSG_SEND_COMPLETED</span>
    <span value="4005">OB_MSG_DELIVERY_RETRIES_EXCEEDED</span>
    <span value="4009">OB_MSG_SEND_IN_PROGRESS</span>
</div>
</div> 



</div>

<div style="width: 190px;">
<button id="searchButton" type="button"></button>
<button id="clearButton"  type="button"></button>
<button id="exportButton"  type="button"></button>
</div>
<div style="width: 200px;" >
<label for="recordSize" style="width: 75px;height: 20px;padding-top:4px;text-align: left;">Max Records:</label> 
<div id="recordSize" name="recordSizeValue" value="" style="width: 60px; margin-top: 0px;" data-dojo-type="dijit/form/Select" title="Record Size">
	<span value="100">100</span>
	<span value="7500">7500</span>
	<span value="10000">10000</span>
</div> 
</div>

</div>

<div id="showButtonDiv" style="width: 900px; display: none;">
<button id="showButton"  type="button"></button>
<button id="relatedMessagesButton"  type="button"></button>
<button id="printButton"  type="button"></button>
</div>

<h2 class="h2title"><span class="reportTitle"></span></h2>
<div id="queryStatus" style="width: 900px;padding-left: 5px;"></div>

<span id="messageList" tabindex="0"  style="width: 1125px; height: 290px; display: block;"></span><br/>
<span id="trackRecNumberTitle" style="width: 250px;display: none;">
Number of Records:
<span id="trackRecNumber" style="position:relative;top:-14px;left:112px;display: none;">
</span>
</span>

<%-- Related Message Start --%>
<span id="relatedMessagesParentInfo" tabindex="0"  style="width: 1125px;margin-top:-30px;margin-bottom:10px;  display: none;"></span> 
<span id="relatedMessagesList" tabindex="0"  style="width: 1125px; height: 290px; display: none;"></span>
<span id="trackRelatedMessagesRecNumberTitle" style="width: 250px;display: none;">
<br/>
Number of Records:
<span id="trackRelatedMessagesRecNumber" style="position:relative;top:-14px;left:112px;display: none;">
</span>
</span>
<%-- Related Message End --%>
   <div id="result1" style="width: 1125px; padding-bottom: 20px;display: none;">
   <div class="Container">
   <div class="ColumnLbls">

   <span id="rxMessageType" style="padding-bottom: 3px; width: 600px;" class="trackH2"></span><br/> 
   </div>
   <div class="Column1" style="width:200px;">
   </div>
   <div class="ColumnLbls">
   
   <span  style="padding-left: 50px;" class="trackLbl">Status: </span><br/>
   </div>
   <div class="Column2" style="width:500px;">
   <span id="messageStatus2" class="trackDataCenter"></span><br/>
   </div>
   <div class="ColumnLbls">
   <span id="receiveDateLbl" class="trackLbl">Received Date: </span><br/>
   </div>
   <div class="Column3">
   <span id="receiveDate" class="trackDataRight">&nbsp;</span><br/>
   </div>
   </div> 
   <div  role="table" id="trackPrescrPatient" class="trackTable">    
   <div role="row">
   		<div class="trackH1" role="rowheader">PHARMACY</div>
   </div>
   <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">
	   <div role="rowheader" class="trackLbl">Name: </div> <div role="cell" id="pharmacyName" class="trackDataMoreRight trackDataLeft">&nbsp;</div> 
	   
	   <div role="columnheader" class="trackLblRight">NCPDP ID: </div><div  role="cell" id="pharmacyNCPDPID" class="trackDataRight">&nbsp;</div><br/> 
	
   	  </div> 
   </div>	  
   <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">
	   <div role="rowheader" class="trackLbl">Address: </div><div role="cell" id="pharmacyAddr1" class="trackDataLeft">&nbsp;</div> <br/> 
	   <div class="trackLbl">&nbsp;</div> <div role="cell" id="pharmacyAddr2" class="trackDataLeft">&nbsp;</div> <br/>	   
   </div> 
   </div>
   <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	
	   <div role="rowheader" class="trackLbl">Phone: </div> <div role="cell" id="pharmacyPhone" class="trackDataLeft">&nbsp;</div>
	   </div>	   
   </div>    
   <div role="row">
    <div role="rowheader" class="trackH1">PRESCRIBER</div>
   </div>   
   <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">	 
	 <div role="rowheader" class="trackLbl">First: </div> <div role="cell" id="prescriberFirstName" class="trackDataLeft">&nbsp;</div>	
	 </div>   
   </div>
    <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">	
	 <div role="rowheader" class="trackLbl">Mid.: </div>  <div role="cell" id="prescriberMidName" class="trackDataLeft">&nbsp;</div>	
	 </div>   
   </div>
      <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">	
	 <div role="rowheader" class="trackLbl">Last: </div>  <div role="cell" id="prescriberLastName" class="trackDataLeft">&nbsp;</div>	
	 </div>   
   </div>
      <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">	
	 <div role="rowheader" class="trackLbl">Address: </div>  <div role="cell" id="prescriberAddr1" class="trackDataLeft">&nbsp;</div><br/> 
	 <div role="rowheader"  class="trackLbl">&nbsp;</div>  <div role="cell" id="prescriberAddr2" class="trackDataLeft">&nbsp;</div>	
	 </div>   
   </div>
      <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">	 
	 <div role="rowheader" class="trackLbl">NPI: </div>  <div role="cell" id="prescriberNPI"  class="trackDataLeft">&nbsp;</div>	 
	 </div>   
   </div>
    <div role="row" class="trackRowGroup"> 
    <div class="ColumnLbls">  	
	 <div role="rowheader" class="trackLbl">Phone: </div> <div role="cell" id="prescriberPhone" class="trackDataMoreRight trackDataLeft">&nbsp;</div>	
	 
	  <div role="columnheader" class="trackLblRight">FAX: </div>  <div role="cell" id="prescriberFax"  class="trackDataRight">&nbsp;</div><br/>
	  </div> 
   </div>   
     
   <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">	
	 <div role="rowheader" class="trackLbl">Agent: </div>  <div role="cell" id="prescriberAgent" class="trackDataLeft">&nbsp;</div>	 
	 </div>   
   </div>
   <div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">
	 <div role="rowheader" class="trackLbl">DEA: </div> <div role="cell" id="prescriberDEA"  class="trackDataMoreRight trackDataLeft">&nbsp;</div>	 
	 <div role="columnheader" class="trackLblRight">State Lic: </div><div role="cell" id="prescriberStateLic"   class="trackDataRight">&nbsp;</div>
	 </div>   
   </div>
   
  
   <div role="row">
     <div role="rowheader" class="trackH1">PATIENT</div>
   </div>
   <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls"> 
	   <div role="rowheader" class="trackLbl">First: </div> <div role="cell" id="patientFirstName" class="trackDataLeft">&nbsp;</div>	  
    </div>
   </div>   
     <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	   
	   <div role="rowheader" class="trackLbl">Mid.: </div> <div role="cell" id="patientMidName" class="trackDataLeft">&nbsp;</div>	   
    </div>
    </div>
    <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	  
	   <div role="rowheader" class="trackLbl">Last: </div>  <div role="cell" id="patientLastName" class="trackDataLeft">&nbsp;</div>	     
    </div>
    </div>
    <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	  
	   <div role="rowheader" class="trackLbl">Address: </div> <div role="cell" id="patientAddr1" class="trackDataMoreRight trackDataLeft">&nbsp;</div>
	   <div role="columnheader" class="trackLblRight">SSN: </div><div role="cell" id="patientSocSn"  class="trackDataRight">&nbsp;</div><br/>	    
	   <div role="cell" class="trackLbl">&nbsp;</div> <div role="cell" id="patientAddr2" class="trackDataLeft">&nbsp;</div>	   
    </div>
    </div>
    <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	   
	   <div role="rowheader" class="trackLbl">DOB: </div>  <div role="cell" id="patientDob" class="trackDataMoreRight trackDataLeft">&nbsp;</div>
	   <div role="columnheader" class="trackLblRight">Gender: </div><div role="cell" id="patientGender"  class="trackDataRight">&nbsp;</div>
    </div>
    </div>   
        <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	   
	   <div role="rowheader" class="trackLbl">Height: </div>  <div role="cell" id="patientHeight" class="trackDataMoreRight trackDataLeft">&nbsp;</div>
	   <div role="columnheader" class="trackLblRight">Weight: </div><div role="cell" id="patientWeight"  class="trackDataRight">&nbsp;</div>
    </div>
    </div>  
       <div role="row" class="trackRowGroup">
	   <div class="ColumnLbls">	   
	   <div role="rowheader" class="trackLbl">Primary Phone: </div>  <div role="cell" id="patientPrimaryPhone" class="trackDataMoreRight trackDataLeft">&nbsp;</div>
	   <div role="columnheader" class="trackLblRight">Home Phone: </div><div role="cell" id="patientHomePhone"  class="trackDataRight">&nbsp;</div>
    </div>
    </div>  
   <div role="row">
  	 <div role="rowheader" class="trackH1">PRESCRIPTION</div>
   </div>
  
   <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Prescribed: </div><div id="rxDrugPrescribed" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div id="rxDrugPrescribedNdc" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  
  
  <div  role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div> <div id="rxQuantity" style="width: 400px;" class="trackDataLeft"></div>
  </div> 
  </div>  
  
  
  <div  role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div id="rxPotencyUnitCode" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div><div id="rxDaysSupply" style="width: 150px;" class="trackDataCenter">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Date Written:  </div> <div id="rxDateWritten" style="width: 100px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div>   
  <div  role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  
  </div>
  </div> 
  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
     <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugForm" style="width: 557px;" class="trackDataCenter">&nbsp;</div>  
    <div role="columnheader" class="trackLbl">&nbsp;</div><div id="rxBlank" style="width: 150px;" class="trackDataCenter">&nbsp;</div>
  	<div role="columnheader" class="trackLbl">Issue Date:  </div> <div id="rxEffectiveDate" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">Drug Strength: </div> <div role="cell" id="rxDrugStrength" style="width: 1000px;" class="trackDataRight">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">Refills: </div>  <div role="cell" id="rxRefills" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
   <div role="row" id="prohibitRenew" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader"  class="trackLbl">Prohibit Renew: </div>  <div role="cell" id="rxProhibitRenewal" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSig" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Orig Ref Num: </div><div role="cell" id="rxReferenceNumber" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">PON: </div><div role="cell" id="prescriberOrderNumber" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">eRx Ref Num: </div> <div role="cell" id="rxErxRefNum" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">      
   <div role="rowheader" class="trackLbl">Message ID: </div> <div role="cell" id="rxMessageId" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Rel to Msg ID: </div>  <div role="cell" id="rxRelToMessageId" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">Substitutions?: </div>  <div role="cell" id="rxDispenseNotes" style="width: 1000px;" class="trackDataRight"> </div>    
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Comments: </div>  <div role="cell" id="rxComments" style="width: 1000px;-ms-word-wrap: break-word;" class="trackDataRight"> </div>  
  </div>
  </div>
  

  
  <div role="row" class="trackRowGroup">
  <div id="benefitsCoordination1" class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Plan ID:  </div><div role="cell" id="patientPlanId" style="width: 558px;" class="trackDataLeft">&nbsp;</div>  
   <div role="columnheader" class="trackLbl">RxGRP: </div> <div role="cell" id="rxGrp" style="width: 200px;" class="trackDataCenter">&nbsp;</div>  
  </div> 
  </div>
  
   <div role="row" class="trackRowGroup">
  <div id="benefitsCoordination2" class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">RxBIN#: </div>  <div role="cell" id="rxBinNum" style="width: 558px;" class="trackDataLeft">&nbsp;</div>
   <div role="columnheader" class="trackLbl">RxPCN: </div> <div role="cell" id="rxPcn" style="width: 200px;" class="trackDataCenter">&nbsp;</div>   
  </div> 
  </div>  
  </div> <%-- NewRx table end --%>
  <%-- Medication Dispensed --%>
  <div role="table" id="trackMedDisp" style="display: none;" class="trackTable"> 
	  <div role="row">
	  <div class="trackH1">MEDICATION DISPENSED</div>
	  </div>
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls">
	  <div role="rowheader" class="trackLbl">Drug Dispensed: </div><div role="cell" id="rxDrugDispensed" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
	  </div>	  
	  </div>
	 <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls">
	  <div role="rowheader" class="trackLbl">NDC: </div> <div role="cell" id="rxDrugDispensedNdc" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
	  </div>	
	  </div>
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls">
	  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityDispensed" style="width: 400px;" class="trackDataLeft"></div>	 
	  </div>	  
	  </div>
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls">	  
	  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeDispensed" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
	   <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyDispensed" style="width: 150px;" class="trackDataCenter">&nbsp;</div>
	   <div role="columnheader" class="trackLbl">Date Written:  </div> <div role="cell" id="rxDateWrittenDispensed" style="width: 100px;" class="trackDataRight">&nbsp;</div> 	  
	  </div>	  
	  </div>		    
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls"> 
	   <div role="rowheader" class="trackLbl">Drug Form: </div>  <div role="cell" id="rxDrugFormDispensed" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>	  
	  </div>
	  </div>	  
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls"> 	   
	   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthDispensed" style="width: 1000px;" class="trackDataRight">&nbsp;</div>	  
	  </div>
	  </div>	  
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls"> 	   
	   <div role="rowheader" class="trackLbl">Req. Refills: </div> <div role="cell" id="rxRefillsDispensed" style="width: 1000px;" class="trackDataRight"> </div> 	    
	  </div>
	  </div>	  
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls"> 	  
	   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigDispensed" style="width: 1000px;" class="trackDataRight"> </div>	   
	  </div>
	  </div>	  
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls"> 	   
	   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesDispensed" style="width: 1000px;" class="trackDataRight"> </div> 	  
	  </div>
	  </div>	  
	  <div role="row" class="trackRowGroup">
	  <div class="ColumnLbls"> 	  
	   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsDispensed" style="width: 1000px;" class="trackDataRight"> </div> 
	  </div>
	  </div>	  
  </div>  
  <%-- Request Response --%>
  <div role="table" id="trackReqRes" style="display: none;" class="trackTable"> 
	   <div role="table" id="trackReq" style="display: none;" class="trackTable">
	   <div role="row">
	    <div class="trackH1">REQUEST</div> 
		</div>
	    <div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 
	    <div role="rowheader" class="trackLbl">Req Ref Num: </div> <div role="cell" id="reqRefNum" class="trackDataLeft"></div>
	    </div>   
	    </div>
	    </div>
	<div role="row">
    <div class="trackH1">RESPONSE</div>
	</div>   
    <div role="row" class="trackRowGroup">
    <div class="ColumnLbls"> 
    <div class="trackLbl">Status: </div><div  role="cell" id="resAprvDenied" class="trackDataLeft"></div>    
    </div> 
    </div>	
	<div role="row" class="trackRowGroup">
    <div class="ColumnLbls">     
    <div class="trackLbl">Reason Code: </div><div  role="cell" id="resReasonCode" class="trackDataLeft"></div>    
    </div> 
    </div> 	
	<div role="row" class="trackRowGroup">
    <div class="ColumnLbls">     
    <div class="trackLbl">Reason: </div><div  role="cell" id="resReason" class="trackDataLeft"></div>    
    </div> 
    </div> 	
	<div role="row" class="trackRowGroup">
    <div class="ColumnLbls">    
    <div class="trackLbl">Note: </div><div  role="cell" id="resNote" class="trackDataLeft"></div>    
    </div> 
    </div>	
	<div role="row" class="trackRowGroup">
    <div class="ColumnLbls">    
    <div class="trackLbl">Resp Ref Num: </div><div  role="cell" id="resRefNum" class="trackDataLeft"></div>
    </div>  
    </div>
    <%-- RxChangeResponse Validated Being--%>
    <div id="rxChangeRespVadlidatedDiv" style="display: none;">
    <div role="row" class="trackRowGroup">
    <div class="ColumnLbls">	 
	 	<div class="trackLbl">Val. Prescr. NPI: </div>  <div role="cell" id="rxChgRespValidatedPrescriberNPI"  class="trackDataLeft">&nbsp;</div>	 
	 	</div> 
	 </div>
	<div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">
	 <div class="trackLbl">Val. Prescr. DEA: </div> <div role="cell" id="rxChgRespValidatedPrescriberDEA"  class="trackDataLeft">&nbsp;</div>	 
	 </div>   
   </div>
   <div role="row" class="trackRowGroup">
   <div class="ColumnLbls">		 
	 <div class="trackLbl" style="width: 130px;">Val. Prescr. State Lic: </div><div role="cell" id="rxChgRespValidatedPrescriberStateLic"   class="trackDataLeft">&nbsp;</div>
	 </div> 
   </div>  
   	<div role="row" class="trackRowGroup">
   	 <div class="ColumnLbls">
	 <div class="trackLbl">Val. Date: </div> <div role="cell" id="rxChgRespValidatedDate"  class="trackDataLeft">&nbsp;</div>	 
	 </div>   
   </div>
    </div><%-- Drug Coverage and  PriorAuthorization --%>
    <div id="rxChangeRespDrugCoveragePADiv" style="display: none;">
	    <div role="row" class="trackRowGroup">
	   	 <div class="ColumnLbls">
		 <div class="trackLbl">Drug Cov Status: </div> <div role="cell" id="rxChgRespDrugCoverageStatus"  class="trackDataLeft">&nbsp;</div>	 
		 </div>   
	   </div> 
	    <div role="row" class="trackRowGroup">
	   	 <div class="ColumnLbls">
		 <div class="trackLbl">Prior Aut: </div> <div role="cell" id="rxChgRespPriorAuthorization"  class="trackDataLeft">&nbsp;</div>	 
		 </div>   
	   </div> 
	    <div role="row" class="trackRowGroup">
	   	 <div class="ColumnLbls">
		 <div class="trackLbl">Prior Aut Status: </div> <div role="cell" id="rxChgRespPriorAuthorizationStatus"  class="trackDataLeft">&nbsp;</div>	 
		 </div>   
	   </div> 
   </div>
    <%-- RxChangeResponse Validated End --%>
     
    	
   </div>
   <%-- Error Verify Status --%>
    <div role="table" id="trackErrVerStat" style="display: none;"> 
	 <div role="row"> 
	  <div role="rowheader" class="trackH1">PHARMACY</div>
	  </div>  
	    <div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 
	     <div role="rowheader" class="trackLbl">NCPDP ID: </div> <div role="cell" id="pharmacyNCPDPID2" style="width: 1000px;"> </div>
	    </div>	  
	    </div>
	    <div role="row">
	    <div role="rowheader" class="trackH1">PRESCRIBER</div>
	    </div> 
			<div role="row" class="trackRowGroup">
			<div class="ColumnLbls"> 
		   <div role="rowheader" class="trackLbl">NPI/Clinic ID: </div><div role="cell" id="rxClinicID" style="width: 1000px;"> </div>
			</div>			
		</div>
	    <div role="row">
	    <div role="rowheader" class="trackH1">PRESCRIPTION</div> 
		</div>
		
	    <div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 
	   <div role="rowheader" class="trackLbl">Message ID: </div> <div  role="cell" id="rxMessageId2" style="width: 1000px;"> </div>	   
	    </div>	  
	    </div>
		 <div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 	   
	   <div role="rowheader" class="trackLbl">Rel to Msg ID: </div><div  role="cell" id="rxRelToMessageId2" style="width: 1000px;"> </div> 
	    </div>	  
	    </div>
		<div role="row">
	    <div role="rowheader" class="trackH1">CODES and DESCRIPTION</div> 
		</div>
	    <div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 
	    <div role="rowheader" class="trackLbl">Code: </div> <div role="cell" id="esvCode" class="trackDataLeft"></div>	   
	    </div>	   
	    </div>
		<div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 	    
	    <div role="rowheader" class="trackLbl">Desc Code: </div>	<div role="cell" id="esvDescriptionCode" class="trackDataLeft"></div>	    
	    </div>	   
	    </div>
		<div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 	    
	    <div role="rowheader" class="trackLbl">Description: </div>	<div role="cell" id="esvDescription" class="trackDataLeft"></div>
	    </div>	   
	    </div>
    </div>  
    <%-- CancelRx --%>
    <div role="table" id="trackCancelRx" style="display: none;" class="trackTable"> 
    <div role="row">
	<div role="rowheader" class="trackH1">REQUEST</div> 
	</div> 
    <div role="row" class="trackRowGroup">
    <div class="ColumnLbls"> 
    <div class="trackLbl">Chg Rx Stat Flg: </div><div id="changeofPrescrStatFlg" class="trackDataLeft"></div>
    </div>   
    </div>
    </div>
    <%--ChangeRequest Medication Requested --%> 
  <div role="table" id="trackChangeRequest" style="display: none;" class="trackTable"> 
     <div role="row">
    <div role="rowheader" class="trackH1" id="rxChangeRequestMedRequstDiv1">MEDICATION REQUESTED</div>
    </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div> 
  </div>
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div> 
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested" style="width: 400px;" class="trackDataLeft"></div>
  </div>
  </div> 
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div> <div role="cell" id="rxPotencyUnitCodeRequested" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div><div role="cell" id="rxDaysSupplyRequested" style="width: 150px;" class="trackDataCenter">&nbsp;</div>
  <div role="columnheader" class="trackLbl" id="rxDateWrittenRequestedLabel">Date Written:  </div><div role="cell" id="rxDateWrittenRequested" style="width: 100px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div>   
  <div role="row" class="trackRowGroup" id="rxChangeRequestDrugFormRequested">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div><div role="cell" id="rxDrugFormRequested" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
    <div role="row" class="trackRowGroup" id="rxChangeRequestDrugStrengthRequested">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested" style="width: 1000px;" class="trackDataRight">&nbsp;</div>   
  </div>
  </div>
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Refills: </div>  <div role="cell" id="rxRefillsRequested" style="width: 1000px;" class="trackDataRight"> </div>    
  </div>
  </div>
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested" style="width: 1000px;" class="trackDataRight"> </div>     
  </div>
  </div>
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested" style="width: 1000px;" class="trackDataRight"> </div> 
  </div>
  </div>
   <!--2-->
<div id="trackMedRequested2" style="display: none;"> 
   <div role="row">
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #2</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested2" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc2" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div> <div role="cell" id="rxQuantityRequested2" style="width: 400px;" class="trackDataLeft"></div>  
  </div> 
  </div>
   <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div> <div role="cell" id="rxPotencyUnitCodeRequested2" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyRequested2" style="width: 150px;" class="trackDataCenter">&nbsp;</div>
  <div role="columnheader" class="trackLbl" id="rxDateWrittenRequested2Label">Date Written:  </div> <div role="cell" id="rxDateWrittenRequested2" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div> 
  </div>
  <div role="row" class="trackRowGroup" id="rxChangeRequestDrugFormRequested2">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested2" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
   <div role="row" class="trackRowGroup" id="rxChangeRequestDrugStrengthRequested2">
  <div class="ColumnLbls">    
  <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested2" style="width: 1000px;" class="trackDataRight">&nbsp;</div>  
  </div>
  </div>
  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested2" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested2" style="width: 1000px;" class="trackDataRight"> </div>    
  </div>
  </div>
  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested2" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested2" style="width: 1000px;" class="trackDataRight"> </div>
  </div>
  </div>
   </div> 
   <!--3-->
<div id="trackMedRequested3" style="display: none;"> 
  <div role="row">
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #3</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested3" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc3" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div> 
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested3" style="width: 400px;" class="trackDataLeft"></div>
  </div> 
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested3" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyRequested3" style="width: 150px;" class="trackDataCenter">&nbsp;</div> 
  <div role="columnheader" class="trackLbl" id="rxDateWrittenRequested3Label">Date Written:  </div> <div role="cell" id="rxDateWrittenRequested3" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div> 
  </div>      
  <div role="row" class="trackRowGroup" id="rxChangeRequestDrugFormRequested3">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested3" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup" id="rxChangeRequestDrugStrengthRequested3">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested3" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested3" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested3" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested3" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
   <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested3" style="width: 1000px;" class="trackDataRight"> </div> 
  </div>
  </div>  
  </div> <!--  Medication Requested 3 RxChangeRequest Fix -->
    <!--4-->
    <div id="trackMedRequested4" style="display: none;">
  <div role="row">	
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #4</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested4" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc4" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested4" style="width: 400px;" class="trackDataLeft"></div>  
  </div>
  </div> 
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested4" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyRequested4" style="width: 150px;" class="trackDataCenter">&nbsp;</div> 
  <div role="columnheader" class="trackLbl">Date Written:  </div>  <div role="cell" id="rxDateWrittenRequested4" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div>
  </div> 
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested4" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested4" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested4" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested4" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested4" style="width: 1000px;" class="trackDataRight"> </div> 
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested4" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>
  
  </div>
     <!--5-->
     <div id="trackMedRequested5" style="display: none;">
   <div role="row">	 
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #5</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested5" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc5" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested5" style="width: 400px;" class="trackDataLeft"></div>
  </div> 
  </div>
   <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested5" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div><div role="cell" id="rxDaysSupplyRequested5" style="width: 150px;" class="trackDataCenter">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Date Written:  </div>  <div role="cell" id="rxDateWrittenRequested5" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div> 
  </div>
   
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested5" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested5" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
   </div>
  </div>
  
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested5" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested5" style="width: 1000px;" class="trackDataRight"> </div>    
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested5" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>
  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Substitutions?: </div><div role="cell" id="rxDispenseNotesRequested5" style="width: 1000px;" class="trackDataRight"> </div> 
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">       
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested5" style="width: 1000px;" class="trackDataRight"> </div>
  </div>
  </div>  
  </div> 
   <!--6-->
   <div id="trackMedRequested6" style="display: none;"> 
   <div role="row">	  
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #6</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested6" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>  
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc6" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested6" style="width: 400px;" class="trackDataLeft"></div> 
  </div>
  </div> 
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested6" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyRequested6" style="width: 150px;" class="trackDataCenter">&nbsp;</div> 
  <div role="columnheader" class="trackLbl">Date Written:  </div> <div role="cell" id="rxDateWrittenRequested6" style="width: 100px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div> 
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested6" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested6" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested6" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested6" style="width: 1000px;" class="trackDataRight"> </div>    
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">      
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested6" style="width: 1000px;" class="trackDataRight"> </div> 
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Comments: </div>   <div role="cell" id="rxCommentsRequested6" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>  
  </div>
       <!--7-->
  <div id="trackMedRequested7" style="display: none;"> 
  <div role="row">	   
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #7</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested7" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc7" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>  
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested7" style="width: 400px;" class="trackDataLeft"></div>  
  </div> 
  </div>  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested7" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyRequested7" style="width: 150px;" class="trackDataCenter">&nbsp;</div> 
  <div role="columnheader" class="trackLbl">Date Written:  </div> <div role="cell" id="rxDateWrittenRequested7" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div> 
  </div> 
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested7" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested7" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested7" style="width: 1000px;" class="trackDataRight"> </div>     
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested7" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested7" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested7" style="width: 1000px;" class="trackDataRight"> </div> 
  </div>
  </div>
  
  </div>
        <!--8-->
  <div id="trackMedRequested8" style="display: none;"> 
  <div role="row">		
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #8</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested8" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc8" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested8" style="width: 400px;" class="trackDataLeft"></div>  
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested8" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div><div role="cell" id="rxDaysSupplyRequested8" style="width: 150px;" class="trackDataCenter">&nbsp;</div> 
  <div role="columnheader" class="trackLbl">Date Written:  </div>  <div role="cell" id="rxDateWrittenRequested8" style="width: 100px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div>  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested8" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>  
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested8" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested8" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested8" style="width: 1000px;" class="trackDataRight"> </div>  
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested8" style="width: 1000px;" class="trackDataRight"> </div> 
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested8" style="width: 1000px;" class="trackDataRight"> </div>
  </div>
  </div>
  
  </div>
  <!--9-->
  <div id="trackMedRequested9" style="display: none;"> 
  <div role="row">
  <div role="rowheader" class="trackH1">MEDICATION REQUESTED #9</div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Drug Requested: </div><div role="cell" id="rxDrugRequested9" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">NDC: </div><div role="cell" id="rxDrugRequestedNdc9" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  </div>
  </div>
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">
  <div role="rowheader" class="trackLbl">Quantity: </div><div role="cell" id="rxQuantityRequested9" style="width: 400px;" class="trackDataLeft"></div>  
  </div> 
  </div>  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">  
  <div role="rowheader" class="trackLbl">Quantity UOM:</div><div role="cell" id="rxPotencyUnitCodeRequested9" style="width: 557px;" class="trackDataLeft">&nbsp;</div>
  <div role="columnheader" class="trackLbl">Days Supply: </div> <div role="cell" id="rxDaysSupplyRequested9" style="width: 150px;" class="trackDataCenter">&nbsp;</div> 
  <div role="columnheader" class="trackLbl">Date Written:  </div> <div role="cell" id="rxDateWrittenRequested9" style="width: 100px;" class="trackDataRight">&nbsp;</div> 
  </div> 
  </div>  
  <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Drug Form: </div> <div role="cell" id="rxDrugFormRequested9" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">    
   <div role="rowheader" class="trackLbl">Drug Strength: </div><div role="cell" id="rxDrugStrengthRequested9" style="width: 1000px;" class="trackDataRight">&nbsp;</div>
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Refills: </div> <div role="cell" id="rxRefillsRequested9" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">SIG: </div> <div role="cell" id="rxSigRequested9" style="width: 1000px;" class="trackDataRight"> </div>   
  </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls">   
   <div role="rowheader" class="trackLbl">Substitutions?: </div> <div role="cell" id="rxDispenseNotesRequested9" style="width: 1000px;" class="trackDataRight"> </div> 
   </div>
  </div>
  
    <div role="row" class="trackRowGroup">
  <div class="ColumnLbls"> 
   <div role="rowheader" class="trackLbl">Comments: </div> <div role="cell" id="rxCommentsRequested9" style="width: 1000px;" class="trackDataRight"> </div>
  </div>
  </div>   
  </div>
  <div role="row">
    <div role="rowheader" class="trackH1">REQUEST</div> 
   </div>
    <div role="row" class="trackRowGroup">
    <div class="ColumnLbls"> 
    <div role="rowheader" class="trackLbl">Chg Req Type: </div><div role="cell" id="changeRequestType" class="trackDataLeft"></div>    
    </div>  
    </div>
	<div role="row" class="trackRowGroup">
    <div class="ColumnLbls">     
    <div role="rowheader" class="trackLbl">Req Ref Num: </div><div id="requestReferenceNumber" class="trackDataLeft"></div>
    </div>  
    </div>	
   </div>
	<%-- End Change Request --%>   
    <%-- RxFill --%>
	<div role="table" id="rxFill" style="display: none;" class="trackTable"> 
		<div role="row">
	    <div role="rowheader" class="trackH1">FILL STATUS</div> 
		</div>
	    <div role="row" class="trackRowGroup">
	    <div class="ColumnLbls"> 
	    <div role="rowheader" class="trackLbl">Status: </div><div role="cell" id="rxFillStatus" class="trackDataLeft"></div>    
	    </div>
	    </div>	
		<div role="row" class="trackRowGroup">
	    <div class="ColumnLbls">    
	    <div role="rowheader" class="trackLbl">Ref Num: </div><div role="cell" id="rxFillRefNum" class="trackDataLeft"></div>   
	    </div>
	    </div>	
		<div role="row" class="trackRowGroup">
	    <div class="ColumnLbls">    
	    <div role="rowheader" class="trackLbl">Note: </div><div role="cell" id="rxFillNote" class="trackDataLeft"></div>    
	    </div>
	    </div>	
		<div role="row" class="trackRowGroup">
	    <div class="ColumnLbls">     
	    <div role="rowheader" class="trackLbl">Reason Code: </div><div role="cell" id="rxFillReasonCd" class="trackDataLeft"></div>
	    </div>
	    </div>
    </div>  
    <%-- NewRx Autocheck validations--%>
 <div role="table" id="trackAutoCheck" style="display: none;">
   <div role="row">
     <div role="rowheader" class="trackH1">AUTOCHECK VALIDATIONS</div> 
   </div>	 
     <div role="row" class="trackRowGroup">
  		<div class="ColumnLbls">
  		<div role="rowheader" class="trackLbl">Patient Check: </div><div role="cell" id="rxPatientCheck" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  		</div>  		
  	</div>
  	  <div role="row" class="trackRowGroup">
  		<div class="ColumnLbls">
  		<div role="rowheader" class="trackLbl">Provider Check: </div><div role="cell" id="rxProviderCheck" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  		</div>  		
  	</div>
  	 <div role="row" class="trackRowGroup">
  		<div class="ColumnLbls">
  		<div role="rowheader" class="trackLbl">Drug Check: </div><div role="cell" id="rxDrugCheck" style="width: 1000px;" class="trackDataCenter">&nbsp;</div>
  		</div>  	
  	</div>
  </div>  
    <input id="trackMsgIdHidden" name="trackMsgIdHidden"  type="hidden" value="" style="display: none;"></input> 
    <input id="trackHubMsgIdHidden" name="trackHubMsgIdHidden"  type="hidden" value="" style="display: none;"></input> 
     <input id="trackMsgTypeHidden" name="trackMsgTypeHidden"  type="hidden" value="" style="display: none;"></input>
     <input id="trackParentMsgStatusHidden" name="trackParentMsgStatusHidden"  type="hidden" value="" style="display: none;"></input>   
    </div><%--result1 div end --%>
    
<%-- end body --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutEnd.jsp" />