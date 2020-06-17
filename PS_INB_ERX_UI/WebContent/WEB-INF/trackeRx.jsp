<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />


<h1 class="titleBar"><span class="headerText">Track/Audit eRx</span></h1>

<br/>

<div data-dojo-type="dijit/form/Form" id="searchCriteriaForm" data-dojo-id="searchCriteriaForm" encType="multipart/form-data" action="" method="">


<div style="width: 1100px;" >
<div style="width: 100px;" title="VISN numbers that a VA pharmacy is associated with" >
<label for="trackauditvisnSelection" style="width: 50px;height: 20px;padding-top:2px;">VISN:</label>
<div id="trackauditvisnSelection" tabindex="0"  style="width: 40px;"  >
	<script>
			trackAuditVisnSelectInit("inb-erx","searchCriteriaForm", "track/getVisnSelect");
	</script>
</div>
</div>
<div style="width: 233px; padding-left: 8px;" >
<label for="pharmacyVaStationId" style="width: 90px;height: 20px;padding-top:2px;">VA Station ID:</label>
<input id="pharmacyVaStationId" name="pharmacyVaStationId"  data-dojo-type="dijit/form/TextBox" value="" maxlength="20" style="width: 130px;" title="Station ID of the VA pharmacy"></input> 
</div>
<div style="width: 332px;height: 20px;" title="Beginning date range"  >
	<label for="dateFrom" style="width: 125px;height: 20px;padding-top:2px; padding-right: 25px; ">From:</label> 
	<input type="text" name="dateFrom" id="dateFrom" constraints="{max: new Date()}" value="now" 
    data-dojo-type="dijit/form/DateTextBox" required="true"  />
</div>
<div style="width: 350px;" title="Ending date range" >
	<label for="dateTo" style="width: 125px;height: 20px;padding-top:2px; padding-right: 29px;">To:</label> 
	<input type="text" name="dateTo" id="dateTo" constraints="{max: new Date()}" value="now"
    data-dojo-type="dijit/form/DateTextBox" required="true"  />
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
	<span value="RefillResponse">RefillResponse</span>
	<span value="RefillRequest">RefillRequest</span>
	<span value="RxChangeResponse">RxChangeResponse</span>
	<span value="RxChangeRequest">RxChangeRequest</span>
	<span value="RxFill">RxFill</span>
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
<label for="patientDob2" style="width: 125px;height: 20px;padding-top:2px;">Patient DOB:</label>
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
<div style="width: 420px;" title="Processing Hub Message Status">
<label for="messageStatus" style="width: 100px;height: 20px;padding-top:2px;padding-right: 23px; padding-left: 12px;">Message Status:</label>
<div id="messageStatus" name="messageStatus" style="width: 200px;" data-dojo-type="dijit/form/Select">
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

<div style="width: 660px;" >
<label for="inboundNcpdpMessageId" style="width: 125px;height: 20px;padding-top:2px;">eRx Reference #:</label>
<input id="inboundNcpdpMessageId" name="inboundNcpdpMessageId" data-dojo-type="dijit/form/TextBox" value="" style="width: 200px;" maxlength="10" title="Internal VA Processing Hub Unique Identifier (eRx Reference Number)"></input>    
</div>
<div style="width: 415px;" title="Received (Inbound messages) or Sent (Outbound messages)" >
<label for="inboundOutbound" style="width: 125px;height: 20px;padding-top:2px; padding-left: 15px; padding-right: 20px;">Sent or Received:</label>
<div id="inboundOutbound" name="inboundOutbound" value="Inbound" style="width: 180px;" data-dojo-type="dijit/form/Select">
	<span value="Inbound">Received</span>
	<span value="Outbound">Sent</span>
</div>
</div>

<div style="width: 900px;">
<button id="searchButton" type="button"></button>
<button id="clearButton"  type="button"></button>
<button id="exportButton"  type="button"></button>
</div>

</div>

<div id="showButtonDiv" style="width: 900px; display: none;">
<button id="showButton"  type="button"></button>
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

   <div id="result1" style="width: 1125px; padding-bottom: 20px;display: none;">
   <div class="Container">
   <div class="ColumnLbls">

   <span id="rxMessageType" style="padding-bottom: 3px; width: 600px;" class="trackH2"></span><br/> 
   </div>
   <div class="Column1" style="width:200px;">
   </div>
   <div class="ColumnLbls">
   <span class="trackLbl">Status: </span><br/>
   </div>
   <div class="Column2" style="width:400px;">
   <span id="messageStatus2" class="trackDataCenter"></span><br/>
   </div>
   <div class="ColumnLbls">
   <span id="receiveDateLbl" class="trackLbl">Received Date: </span><br/>
   </div>
   <div class="Column3">
   <span id="receiveDate" class="trackDataRight">&nbsp;</span><br/>
   </div>
   </div> 
   <div id="trackPrescrPatient" style="display: block;">    
   <div class="trackH1">PHARMACY</div>
   <div class="Container">
   <div class="ColumnLbls">
   <span class="trackLbl">Name: </span><br/> 
   <span class="trackLbl">Address: </span><br/>
   <span class="trackLbl">&nbsp;</span><br/> 
   <span class="trackLbl">Phone: </span><br/>
   </div>
   <div class="Column1">
   <span id="pharmacyName" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="pharmacyAddr1" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="pharmacyAddr2" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="pharmacyPhone" class="trackDataLeft">&nbsp;</span><br/>
   </div>
   <div class="Column2">
   <span class="trackLbl">NCPDP ID: </span><span id="pharmacyNCPDPID" class="trackDataRight">&nbsp;</span><br/> 
   </div>
   </div> 
   <div class="trackH1">PRESCRIBER</div> 
   <div class="Container">
   <div class="ColumnLbls">
   <span class="trackLbl">First: </span><br/> 
   <span class="trackLbl">Mid.: </span><br/> 
   <span class="trackLbl">Last: </span><br/> 
   <span class="trackLbl">Address: </span><br/> 
   <span class="trackLbl">&nbsp;</span><br/> 
   <span class="trackLbl">NPI: </span><br/> 
   <span class="trackLbl">Phone: </span><br/> 
   <span class="trackLbl">Agent: </span><br/> 
   <span class="trackLbl">DEA: </span><br/> 
   </div>
   <div class="Column1">
   <span id="prescriberFirstName" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="prescriberMidName" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="prescriberLastName" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="prescriberAddr1" class="trackDataLeft">&nbsp;</span> <br/> 
   <span id="prescriberAddr2" class="trackDataLeft">&nbsp;</span> <br/> 
   <span id="prescriberNPI"  class="trackDataLeft">&nbsp;</span><br/> 
   <span id="prescriberPhone" class="trackDataLeft">&nbsp;</span><br/> 
   <span id="prescriberAgent" class="trackDataLeft">&nbsp;</span><br/>
   <span id="prescriberDEA"  class="trackDataLeft">&nbsp;</span><br/>
   </div>
   <div class="ColumnLbls">
   <br/>
   <br/>
   <br/>
   <br/>
   <br/>
   <span class="trackLbl">FAX: </span><br/> 
   <br/>
   <br/>
   <span class="trackLbl">State Lic: </span><br/>
   </div>
   <div class="Column2">
   <br/>
   <br/>
   <br/>
   <br/>
   <br/>
   <span id="prescriberFax"  class="trackDataCenter">&nbsp;</span><br/>
    <br/>
    <br/>
   <span id="prescriberStateLic" style="width: 500px;" class="trackDataCenter">&nbsp;</span><br/> 
   </div>
   </div>
   <div class="trackH1">PATIENT</div>
   <div class="Container">
   <div class="ColumnLbls"> 
   <span class="trackLbl">First: </span><br/>
   <span class="trackLbl">Mid.: </span><br/>
   <span class="trackLbl">Last: </span><br/>
   <span class="trackLbl">Address: </span><br/>
   <span class="trackLbl">&nbsp;</span><br/>
   <span class="trackLbl">DOB: </span><br/>
   </div> 
    <div class="Column1">
   <span id="patientFirstName" class="trackDataLeft">&nbsp;</span><br/>
   <span id="patientMidName" class="trackDataLeft">&nbsp;</span><br/>
   <span id="patientLastName" class="trackDataLeft">&nbsp;</span><br/>
   <span id="patientAddr1" class="trackDataLeft">&nbsp;</span><br/>
   <span id="patientAddr2" class="trackDataLeft">&nbsp;</span><br/>
   <span id="patientDob" class="trackDataLeft">&nbsp;</span><br/>
   </div> 
   <div class="ColumnLbls">
   <br/>
   <br/>
   <br/>
   <br/>
   <br/> 
   <span class="trackLbl">Gender: </span><br/>
   </div> 
    <div class="Column2">
    <br/>
    <br/>
    <br/>
    <br/>
    <br/>
   <span id="patientGender"  class="trackDataCenter">&nbsp;</span><br/>
   </div> 
   </div>
   <div class="trackH1">PRESCRIPTION</div>
  <div class="Container">
  <div class="ColumnLbls">
  <span class="trackLbl">Drug Prescribed: </span><br/>
  </div>
  <div class="Column1" style="width: 1000px;">
  <span id="rxDrugPrescribed" style="width: 1000px;" class="trackDataCenter">&nbsp;</span><br/>
  </div>
  </div>
  <div class="Container">
  <div class="ColumnLbls">
  <div class="trackLbl">Quantity: </div>
  <div class="trackLbl">Potency Unit Cd:</div>
  </div>
  <div class="Column1">
  <span id="rxQuantity" style="width: 400px;" class="trackDataLeft"></span><br/> 
  <span id="rxPotencyUnitCode" style="width: 400px;" class="trackDataLeft">&nbsp;</span><br/> 
  </div>
  <div class="ColumnLbls">
  <br/>
  <span class="trackLbl">Days Supply: </span><br/> 
  </div>
  <div class="Column2">
  <br/>
  <span id="rxDaysSupply" style="width: 200px;" class="trackDataCenter">&nbsp;</span><br/> 
  </div>
  <div class="ColumnLbls">
  <br/>
  <span class="trackLbl">Date Written:  </span><br/> 
  </div>
  <div class="Column3">
  <br/>
  <span id="rxDateWritten" style="width: 200px;" class="trackDataRight">&nbsp;</span><br/> 
  </div>
  </div>  
  <div class="Container">
  <div class="ColumnLbls"> 
   <span class="trackLbl">Drug Form: </span><br/> 
   <span class="trackLbl">Drug Strength: </span><br/>
   <span class="trackLbl">Refills: </span><br/> 
   <span class="trackLbl">SIG: </span><br/> 
   <span class="trackLbl">eRx Ref Num: </span><br/> 
   <span class="trackLbl">Message ID: </span><br/> 
   <span class="trackLbl">Rel to Msg ID: </span><br/> 
   <span class="trackLbl">Dispense Notes: </span><br/> 
   <span class="trackLbl">Comments: </span><br/> 
  </div>
  <div class="Column1" style="width: 1000px;">
  <span id="rxDrugForm" style="width: 1000px;" class="trackDataCenter">&nbsp;</span><br/>
  <span id="rxDrugStrength" style="width: 1000px;" class="trackDataRight">&nbsp;</span><br/>
  <span id="rxRefills" style="width: 1000px;" class="trackDataRight"> </span> <br/> 
  <span id="rxSig" style="width: 1000px;" class="trackDataRight"> </span> <br/>
  <span id="rxErxRefNum" style="width: 1000px;" class="trackDataRight"> </span> <br/>  
  <span id="rxMessageId" style="width: 1000px;" class="trackDataRight"> </span><br/>
  <span id="rxRelToMessageId" style="width: 1000px;" class="trackDataRight"> </span><br/> 
  <span id="rxDispenseNotes" style="width: 1000px;" class="trackDataRight"> </span><br/> 
  <span id="rxComments" style="width: 1000px;" class="trackDataRight"> </span><br/>  
  </div>
  </div>
  
  <div class="Container">
  <div class="ColumnLbls"> 
   <div class="trackLbl">Plan ID:  </div>
   <div class="trackLbl">RxBIN#: </div> 
  </div>
  <div class="Column1"> 
  <span id="patientPlanId"  class="trackDataLeft">&nbsp;</span> <br/> 
  <span id="rxBinNum" class="trackDataLeft">&nbsp;</span><br/> 
  </div>
  <div class="ColumnLbls"> 
 <span class="trackLbl">RxGRP: </span><br/> 
  <span class="trackLbl">RxPCN: </span><br/> 
  </div>
  <div class="Column2"> 
  <span id="rxGrp" style="width: 500px;" class="trackDataCenter">&nbsp;</span><br/> 
  <span id="rxPcn" style="width: 200px;" class="trackDataCenter">&nbsp;</span><br/> 
  </div>
  </div>

  </div>
  
 <div id="trackReqRes" style="display: none;"> 
   <div id="trackReq" style="display: none;">
   <div class="trackH1">REQUEST</div> 
    <div class="Container">
    <div class="ColumnLbls"> 
    <span class="trackLbl">Req Ref Num: </span><br/>
    </div>
    <div class="Column1">
     <span id="reqRefNum" class="trackDataLeft"></span><br/>
    </div>
    </div>
    </div>
   <div class="trackH1">RESPONSE</div> 
    <div class="Container">
    <div class="ColumnLbls"> 
    <span class="trackLbl">Status: </span><br/>
    <span class="trackLbl">Reason Code: </span><br/>
    <span class="trackLbl">Reason: </span><br/>
    <span class="trackLbl">Note: </span><br/>
    <span class="trackLbl">Resp Ref Num: </span><br/>
    </div>
    <div class="Column1"> 
    <span id="resAprvDenied" class="trackDataLeft"></span><br/>
   <span id="resReasonCode" class="trackDataLeft"></span><br/>
   <span id="resReason" class="trackDataLeft"></span><br/>
   <span id="resNote" class="trackDataLeft"></span><br/>
   <span id="resRefNum" class="trackDataLeft"></span> <br/>
    </div>
    </div>
   
   </div>
   
    <div id="trackErrVerStat" style="display: none;"> 
    <div class="trackH1">PHARMACY</div>
    
        <div class="Container">
    <div class="ColumnLbls"> 
   <span class="trackLbl">NCPDP ID: </span><br/> 
    </div>
    <div class="Column1"> 
  	<span id="pharmacyNCPDPID2" style="width: 1000px;"> </span><br/> 
    </div>
    </div>
    
    <div class="trackH1">PRESCRIBER</div>
    
        <div class="Container">
    <div class="ColumnLbls"> 
   <span class="trackLbl">NPI/Clinic ID: </span><br/> 
    </div>
    <div class="Column1"> 
  	<span id="rxClinicID" style="width: 1000px;"> </span><br/>
    </div>
    </div>
    
    <div class="trackH1">PRESCRIPTION</div> 
    <div class="Container">
    <div class="ColumnLbls"> 
   <span class="trackLbl">Message ID: </span><br/> 
   <span class="trackLbl">Rel to Msg ID: </span><br/>
    </div>
    <div class="Column1"> 
  	<span id="rxMessageId2" style="width: 1000px;"> </span><br/>
  	<span id="rxRelToMessageId2" style="width: 1000px;"> </span><br/> 
    </div>
    </div>
    <div class="trackH1">CODES and DESCRIPTION</div> 
    <div class="Container">
    <div class="ColumnLbls"> 
    <span class="trackLbl">Code: </span><br/>
    <span class="trackLbl">Desc Code: </span><br/>
    <span class="trackLbl">Description: </span><br/>
    </div>
    <div class="Column1"> 
    <span id="esvCode" class="trackDataLeft"></span><br/>
   	<span id="esvDescriptionCode" class="trackDataLeft"></span><br/>
   	<span id="esvDescription" class="trackDataLeft"></span><br/>
    </div>
    </div>
    </div>
</div>
