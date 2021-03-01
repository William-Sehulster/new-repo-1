dojo.require("dijit.form.Select");
dojo.require("dojo.parser");
dojo.require("dojo.dom-construct");
dojo.require("dojox.validate.us");
dojo.require("dijit.registry");
dojo.require("dijit.Dialog");


dojo.ready(function() {

	console.log("Dojo Ready");
	
	require(["dojo/on","dojo/domReady!"], function(on) {
	    on(document, "keyup", function(event) {
	        if (event.keyCode == '13'){
	        	
	        
	        	var triggeringElementTagName = event.target.tagName;
	        	
	        	//console.log(triggeringElementTagName);
	        	
	        	if(triggeringElementTagName =="INPUT" || triggeringElementTagName =="SPAN" ){
	        		
	        	  var searchCritForm = dijit.byId("searchCriteriaForm");
	        	  
	 		        if(searchCritForm.validate()){
	 		        	
	 		        	
	 		        	
	 		        	dojo.style(dojo.byId('messageList'), "display", "block");
	 		        	
	 		        	getTrackGrid();
	 		        	
	 		        	
	 		        	
	 		        }else{
	 		        	alert('Search form contains invalid values. Please correct and try your search again.')
	 		        	return false;
	 		        }
	 		        return true;
	        	}
	        	
		       
	        }
	    });
	});

	require(["dijit/form/Button","dojo/dom", "dojo/domReady!"], function(Button, dom){
	    var myButton = new Button({
	        label: "Search",
	        onClick: function(){
	        var dateValidation = true;	
	        var startDate = dijit.byId('dateFrom');
	    	var endDate = dijit.byId('dateTo');
	    	
                        
	        
	    	dateValidation = validateDates(startDate.get("value"), endDate.get("value"));	
	        
		        if(dateValidation == false){
		        	return false;
		        }
		        else {
		        
		        	var searchCritForm = dijit.byId("searchCriteriaForm");
			        if(searchCritForm.validate()){
			        	
			        	getTrackGrid();
			        	
			        	
			        }else{
			        	alert('Search form contains invalid values. Please correct and try your search again.')
			        	return false;
			        }
			        return true;
		         }        
	          }
	        }, "searchButton").startup();

	}); 

	require(["dijit/form/Button", "dojo/dom", "dojo/domReady!"], function(Button, dom){
	    var myButton = new Button({
	        label: "Clear",
	        onClick: function(){
	        	
	        var recNumber = dojo.byId("trackRecNumber");
	        var recNumberTitle = dojo.byId("trackRecNumberTitle");
	        
	        if(recNumber!=null){
	        	        	
	        	 dojo.byId("trackRecNumber").style.display="none";
	        }
	        
	        if(recNumberTitle!=null){
	        	
	        	 dojo.byId("trackRecNumberTitle").style.display="none";
	        }
	        
	         // clear search status
	         dojo.byId("queryStatus").innerHTML = "";
	         
	        
	         //clearDetail();
	 		 var messageIdBox = dijit.byId("messageId2");
			 messageIdBox.set("value", "");
			 
			 var relatedMessageId2Box = dijit.byId("relatedMessageId2");
			 relatedMessageId2Box.set("value", "");

			 var pharmacyVaStationIdBox = dijit.byId("pharmacyVaStationId");
			 pharmacyVaStationIdBox.set("value", "");

			 //var dateFromBox = dijit.byId("dateFrom");
			 //dateFromBox.reset();
			 setTrackAuditYesterdaysDefaultDate();

			 var dateToBox = dijit.byId("dateTo");
			 dateToBox.reset();

			 var messageTypeBox = dijit.byId("messageType2");
			 messageTypeBox.set("value", "");

			 var messageStatusBox = dijit.byId("messageStatus");
			 messageStatusBox.set("value", "");
			 
			 var patientSsn2Box = dijit.byId("patientSsn2");
			 //patientSsn2Box.set("value", "");
			 patientSsn2Box.reset();

			 var patientLastName2Box = dijit.byId("patientLastName2");
			 patientLastName2Box.set("value", "");

			 var patientFirstName2Box = dijit.byId("patientFirstName2");
			 patientFirstName2Box.set("value", "");
			 
			 var prescriberLastName2Box = dijit.byId("prescriberLastName2");
			 prescriberLastName2Box.set("value", "");

			 var prescriberFirstName2Box = dijit.byId("prescriberFirstName2");
			 prescriberFirstName2Box.set("value", "");

			 var patientDob2Box = dijit.byId("patientDob2");
			 patientDob2Box.reset();

			 var prescriberNPI2Box = dijit.byId("prescriberNPI2");
			 //prescriberNPI2Box.set("value", "");
			 prescriberNPI2Box.reset();
			 
			 
			 var prescriberDEA2Box = dijit.byId("prescriberDEA2");
			 //prescriberNPI2Box.reset();
			 prescriberDEA2Box.set("value", "");

			 var prescribedDrug2Box = dijit.byId("prescribedDrug2");
			 prescribedDrug2Box.set("value", "");
			 
			 var inboundOutboundBox = dijit.byId("inboundOutbound");
			 inboundOutboundBox.set("value", "");
			 
			 //visn select reset.
			 var visnSelect = dojo.byId("trackauditVisnSelection");
			 
			 visnSelect.selectedIndex = 0;
			 
			 
			 // reset Max Records
			 
			 var maxRecordsSelect = dijit.byId("recordSize");
			 maxRecordsSelect.set("value", "100");
			 

	 		 var inboundNcpdpMessageIdBox = dijit.byId("inboundNcpdpMessageId");
			 inboundNcpdpMessageIdBox.set("value", "");
			 
			 dojo.style(dojo.byId('messageList'), "display", "none");
			 
	           }
	        }, "clearButton").startup();
	        
	});


	require(["dijit/form/Button", "dojo/dom", "dojo/domReady!"], function(Button, dom){
	    var myButton = new Button({
	        label: "Export",
	        onClick: function(){
	        getTrackAuditListCSV();		
	           }
	        }, "exportButton").startup();
	        
	});

	require(["dijit/form/Button", "dojo/dom", "dojo/domReady!"], function(Button, dom){
	    var myButton = new Button({
	        label: "Return to Search",
	        onClick: function(){
	         toggleTrackDivs("false");
	        // var messageIdBox = dijit.byId("messageId");
			// messageIdBox.set("value", "");
	           }
	        }, "showButton").startup();
	        
	});
	
    var searchCritFormId = dijit.byId("searchCriteriaForm");
	dojo.connect(searchCritFormId, 'onsubmit', function(evt) {
	    var val_main = validate_this_form(0);
	       if(val_main == false)
	           dojo.stopEvent(evt);
	});
	
	
		
});	


require(["dijit/form/Button", "dojo/dom", "dojo/domReady!"], function(Button, dom){
    console.log("Related Message Button");
    var myButton = new Button({
        label: "Show Related Messages",
        onClick: function(){
        showRelatedMessages();
        
           }
        }, "relatedMessagesButton").startup();
        
});



require(["dijit/form/Button", "dojo/dom", "dojo/domReady!"], function(Button, dom){
    console.log("Print Button");
    var myButton = new Button({
        label: "Print",
        onClick: function(){
         //toggleTrackDivs("false");
         //alert("coming soon");
         printContent();
        // var messageIdBox = dijit.byId("messageId");
		// messageIdBox.set("value", "");
           }
        }, "printButton").startup();
        
});




function printContent() {
    console.log("printContent"); 
      var DocumentContainer = document.getElementById('result1');
    var styleSheets = 
    "<link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/inb-erx/resources/dojo/resources/dojo.css\">" 
    + " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/inb-erx/resources/dijit/themes/claro/claro.css\">"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/inb-erx/resources/dojox/grid/resources/claroGrid.css\">"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/inb-erx/resources/dojox/grid/enhanced/resources/EnhancedGrid.css\">"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/inb-erx/resources/dojox/grid/enhanced/resources/claro/EnhancedGrid.css\">"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/inb-erx/resources/dojox/editor/plugins/resources/css/Save.css\">"
	+ " <link type=\"text/css\" rel=\"stylesheet\" media=\"print\" href=\"/inbound/style/print.css\" />"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/style/main.css\">"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/style/forms.css\">"
	+ " <link rel=\"stylesheet\" type=\"text/css\" href=\"/inbound/style/tables.css\">"; 
    var WindowObject = window.open('', 'PrintWindow', 'width=1050,height=650,top=50,left=50,toolbars=no,scrollbars=yes,status=no,resizable=yes');
    WindowObject.document.writeln('<head>' + styleSheets + '</head><body>' + DocumentContainer.innerHTML + '</body>');
    WindowObject.document.close();
    WindowObject.focus();
    WindowObject.print();
    WindowObject.close();
}

function buildVisnSelectDataSource(dataSourceURL, query) {
	try {
		console.log("buildVisnSelectDataSource");
		var dataSource = new dojox.data.JsonQueryRestStore({
			target : dataSourceURL,
			idAttribute : "id"
		});		
		return dataSource;
	} catch (err) {
		alert(err.message);
	}
}

function trackAuditVisnSelectInit(servlet, parentContainer, dataSourceURL) {
	try {
		console.log("trackAuditVisnSelectInit");
		var selectData = buildVisnSelectDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
		var selectId = parentContainer + 'Select';
		
		var select = dijit.byId(selectId);

		// If the select already exists, just clear any selected rows and
		// replace the store.
		if (select != null) {
			if (select.selection != null) {
				select.selection.clear();
			}
			select.setStore(selectData);
				
		} else {
			// select does not exist.
			select = new dijit.form.Select({
				id : selectId,
				name: "visn",
				style: "width:40px;",
				sortByLabel : false,
				onFetchError : gridFetchError
			}, "trackauditVisnSelection");
		
			select.setStore(selectData);
			
			
			select.startup();
			
		}
	} catch (err) {
		var txt = "An error occurred while building the selectList.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};




function clearDetail(){
	
	console.log("clearDetail");
		toggleTrackDivs("false");
		
		dojo.byId("queryStatus").innerHTML = "&nbsp;";
		
 		dojo.byId("receiveDate").innerHTML = "&nbsp;";
 		dojo.byId("messageStatus2").innerHTML = "&nbsp;"
        dojo.byId("rxMessageType").innerHTML = "&nbsp;";
        //Pharmacy
        dojo.byId("pharmacyName").innerHTML = "&nbsp;";
        dojo.byId("pharmacyAddr1").innerHTML = "&nbsp;";
        dojo.byId("pharmacyAddr2").innerHTML = "&nbsp;";
        dojo.byId("pharmacyPhone").innerHTML = "&nbsp;";
        dojo.byId("pharmacyNCPDPID").innerHTML = "&nbsp;";
        //Prescriber
        dojo.byId("prescriberFirstName").innerHTML = "&nbsp;";
        dojo.byId("prescriberMidName").innerHTML = "&nbsp;" ;
		dojo.byId("prescriberLastName").innerHTML = "&nbsp;";
		dojo.byId("prescriberAddr1").innerHTML = "&nbsp;";
		dojo.byId("prescriberAddr2").innerHTML = "&nbsp;";
		dojo.byId("prescriberNPI").innerHTML = "&nbsp;";
		dojo.byId("prescriberDEA").innerHTML = "&nbsp;";
		dojo.byId("prescriberStateLic").innerHTML = "&nbsp;";
		dojo.byId("prescriberPhone").innerHTML = "&nbsp;";
		dojo.byId("prescriberFax").innerHTML = "&nbsp;";
		dojo.byId("prescriberAgent").innerHTML = "&nbsp;";       
        //Patient
        dojo.byId("patientFirstName").innerHTML = "&nbsp;";
        dojo.byId("patientMidName").innerHTML = "&nbsp;";
		dojo.byId("patientLastName").innerHTML = "&nbsp;";
		dojo.byId("patientSocSn").innerHTML = "&nbsp;";
		dojo.byId("patientAddr1").innerHTML = "&nbsp;";
		dojo.byId("patientAddr2").innerHTML = "&nbsp;";
		dojo.byId("patientDob").innerHTML = "";
		dojo.byId("patientGender").innerHTML = "&nbsp;";
		dojo.byId("patientPrimaryPhone").innerHTML = "&nbsp;";
		dojo.byId("patientHomePhone").innerHTML = "&nbsp;";	
		dojo.byId("patientPlanId").innerHTML = "&nbsp;";		
		//Observations...part of Patient section
		dojo.byId("patientWeight").innerHTML = "&nbsp;";
		dojo.byId("patientHeight").innerHTML = "&nbsp;";
		
		dojo.byId("rxProhibitRenewal").innerHTML = "&nbsp;";
        
		//Prescription
        dojo.byId("rxDrugPrescribed").innerHTML = "&nbsp;";
        dojo.byId("rxDrugPrescribedNdc").innerHTML = "&nbsp;";
        dojo.byId("rxQuantity").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupply").innerHTML = "&nbsp;";
		dojo.byId("rxDateWritten").innerHTML = "&nbsp;";
		dojo.byId("rxBlank").innerHTML = "&nbsp;";
		dojo.byId("rxEffectiveDate").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCode").innerHTML = "&nbsp;";
		dojo.byId("rxDrugForm").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrength").innerHTML = "&nbsp;";
		dojo.byId("rxRefills").innerHTML = "&nbsp;";
		dojo.byId("rxSig").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotes").innerHTML = "&nbsp;";
		dojo.byId("rxComments").innerHTML = "&nbsp;";
		dojo.byId("rxGrp").innerHTML = "&nbsp;";
		dojo.byId("rxBinNum").innerHTML = "&nbsp;";
		dojo.byId("rxPcn").innerHTML = "&nbsp;";
		dojo.byId("rxErxRefNum").innerHTML = "&nbsp;";
		dojo.byId("rxMessageId").innerHTML = "&nbsp;";
		dojo.byId("rxRelToMessageId").innerHTML = "&nbsp;";
		//Auto check status
		dojo.style(dojo.byId('trackAutoCheck'), "display", "none"); 
		dojo.byId("rxPatientCheck").innerHTML =  "&nbsp;";
		dojo.byId("rxProviderCheck").innerHTML =  "&nbsp;";
		dojo.byId("rxDrugCheck").innerHTML =  "&nbsp;";
		//Medication Dispensed
		dojo.style(dojo.byId('trackMedDisp'), "display", "none");
		dojo.byId("rxDrugDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxDrugDispensedNdc").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxSigDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesDispensed").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsDispensed").innerHTML = "&nbsp;";

		//Request
		dojo.style(dojo.byId('trackReqRes'), "display", "none"); 
		dojo.byId("reqRefNum").innerHTML = "&nbsp;";
		dojo.style(dojo.byId('trackReq'), "display", "none");
		//Response
		dojo.byId("resAprvDenied").innerHTML = "&nbsp;";
		dojo.byId("resReasonCode").innerHTML = "&nbsp;";
		dojo.byId("resRefNum").innerHTML = "&nbsp;";
		dojo.byId("resNote").innerHTML = "&nbsp;";
		dojo.byId("resReasonCode").innerHTML = "&nbsp;";
		dojo.byId("resRefNum").innerHTML = "&nbsp;";
		dojo.byId("resNote").innerHTML = "&nbsp;";
		dojo.byId("resReasonCode").innerHTML = "&nbsp;";
		dojo.byId("resRefNum").innerHTML = "&nbsp;";
		dojo.byId("resReason").innerHTML = "&nbsp;";
		dojo.byId("resReasonCode").innerHTML = "&nbsp;";
		dojo.byId("resRefNum").innerHTML = "&nbsp;";
		dojo.byId("resReason").innerHTML = "&nbsp;";
		
		//Error, Status, Verify
		dojo.byId("rxMessageId2").innerHTML = "&nbsp;";
		dojo.byId("rxRelToMessageId2").innerHTML = "&nbsp;";
		
		dojo.byId("esvCode").innerHTML = "&nbsp;";
		dojo.byId("esvDescriptionCode").innerHTML = "&nbsp;";
		dojo.byId("esvDescription").innerHTML = "&nbsp;";
		
		dojo.byId("pharmacyNCPDPID2").innerHTML = "&nbsp;";
		dojo.byId("rxClinicID").innerHTML = "&nbsp;";
		
		dojo.byId("rxReferenceNumber").innerHTML = "&nbsp;";
		dojo.byId("prescriberOrderNumber").innerHTML = "&nbsp;";
		
		//CHANGERX
		dojo.style(dojo.byId('trackCancelRx'), "display", "none");
		dojo.byId("changeofPrescrStatFlg").innerHTML = "&nbsp;";
		
		//RXCHANGEREQUEST
		dojo.style(dojo.byId('trackChangeRequest'), "display", "none");	
		dojo.byId("changeRequestType").innerHTML = "&nbsp;";
		dojo.byId("requestReferenceNumber").innerHTML = "&nbsp;";
		
		//Medication Requested
		dojo.byId("rxDrugRequested").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested").innerHTML = "&nbsp;";
		
		//<!--2-->
		dojo.byId("rxDrugRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc2").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested2").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested2").innerHTML = "&nbsp;";
		//<!--3-->
		dojo.byId("rxDrugRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc3").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested3").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested3").innerHTML = "&nbsp;";
		//<!--4-->
		dojo.byId("rxDrugRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc4").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested4").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested4").innerHTML = "&nbsp;";
		//<!--5-->
		dojo.byId("rxDrugRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc5").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested5").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested5").innerHTML = "&nbsp;";
		//<!--6-->
		dojo.byId("rxDrugRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc6").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested6").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested6").innerHTML = "&nbsp;";
		//<!--7-->
		dojo.byId("rxDrugRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc7").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested7").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested7").innerHTML = "&nbsp;";
		//<!--8-->
		dojo.byId("rxDrugRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc8").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested8").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested8").innerHTML = "&nbsp;";
		//<!--9-->
		dojo.byId("rxDrugRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxDrugRequestedNdc9").innerHTML = "&nbsp;";
        dojo.byId("rxQuantityRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupplyRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxDateWrittenRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxPotencyUnitCodeRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxDrugFormRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxDrugStrengthRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxRefillsRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxSigRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxDispenseNotesRequested9").innerHTML = "&nbsp;";
		dojo.byId("rxCommentsRequested9").innerHTML = "&nbsp;";
		
		//RXFILL
		dojo.style(dojo.byId('rxFill'), "display", "none");	
		dojo.byId("rxFillStatus").innerHTML = "&nbsp;";
		dojo.byId("rxFillRefNum").innerHTML = "&nbsp;";
		dojo.byId("rxFillNote").innerHTML = "&nbsp;";
		dojo.byId("rxFillReasonCd").innerHTML = "&nbsp;";
		
}


function getMessage(id, inOut,relatedMsg){
	
	var changeRequestTypeVal = null;
	// hide number of records
	
	 var recNumber = dojo.byId("trackRecNumber");
   
	 var recNumberTitle = dojo.byId("trackRecNumberTitle");
     
     if(recNumber!=null){
     	        	
     	 dojo.byId("trackRecNumber").style.display="none";
     }
     
     if(recNumberTitle!=null){
     	
     	 dojo.byId("trackRecNumberTitle").style.display="none";
     }
     
     var trackMessageListGrid = dijit.byId("messageListGrid");
     var trackMainGridMsgStatus = null;
     

     if(trackMessageListGrid!=null)
  	 {
  		
  		var trackMainGridStore = trackMessageListGrid.store;
  		
  		trackMainGridStore.fetch( { query: { inboundNcpdpMsgId: id },  
             onItem: function(item) {

            	 trackMainGridMsgStatus = trackMainGridStore.getValue( item, 'message_status' );
             }
  		});
  		
  		
  		
  		if( trackMainGridMsgStatus!=null && trackMainGridMsgStatus.indexOf("OB_MSG")!== -1){
  			
  			inOut = "Outbound";
  		}
  	 }
     

     var relatedMessagesGrid = dijit.byId("relatedMessagesListGrid");
     
     // message status for related message grid. 
     var messageStatus = null;
	 
	 

     // By default the get message is set to inbound, it should be change based on the message for related messages.
 	if(relatedMessagesGrid!=null)
 	{
 		
 		
 		var gridStore = relatedMessagesGrid.store;
 		
 		gridStore.fetch( { query: { inboundNcpdpMsgId: id },  
            onItem: function(item) {
               //console.log( gridStore.getValue( item, 'message_status' ) );
               
               messageStatus = gridStore.getValue( item, 'message_status' );
            }
 		});
 		
 		
 		
 		if( messageStatus!=null && messageStatus.indexOf("OB_MSG")!== -1){
 			
 			inOut = "Outbound";
 		}
 	}	
  

    var relatedMsgSearch="";
    
    if(relatedMsg!="null"  && relatedMsg == "true" ){
    	
    	relatedMsgSearch ="true";
    	
    }
	
	//The code assumes right now that if the variable "inOut" is not "Outbound" it is currently set to
	//"Inbound" and does not account for the fact that "Both can also be a selection.  The below code
	//corrects this.
	if (inOut.localeCompare("Outbound") != 0)
		inOut = "Inbound";
	
	
    console.log("getMessage5");
    var param1 = id;
    var param2 = inOut;
    var param3= relatedMsgSearch;
    var paramObj = {};
    paramObj.messageId = param1;
    paramObj.inboundOutbound = param2;
    paramObj.relatedMsgSearch = param3;
    
    var jsonStr = JSON.stringify(paramObj);
    var token = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var header = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
    

    var xhrHeader = '{"' + header + '" : "' + token + '"}';
    console.log(xhrHeader);

    var xhrHeaderObj = JSON.parse(xhrHeader);
    console.log(xhrHeaderObj);

	
    var  xhrArgs = {
      url: "getMessage",
      postData: "json=" + jsonStr,
      handleAs: "text",
      headers: xhrHeaderObj ,
      load: function(jsondata){
       var data = JSON.parse(jsondata);
	   

		
        if (data.dataError != null){
			console.log("getMessage load function1 Error");
        	if (data.dataError.search("actual 0") != -1){
        		dojo.byId("queryStatus").innerHTML = "No match found.";
        	}
        	else{
        		dojo.byId("queryStatus").innerHTML = "An unexpected exception occurred when searching for message. Please contact your system administrator."; 
        	}
        } 
        else {
        dojo.byId("queryStatus").innerHTML = "";
        clearDetail();
        toggleTrackDivs("true");
        
        var inboundOutboundBox3 = dijit.byId("inboundOutbound");
    	
    	inboundOutbound1 = inboundOutboundBox3.get("value");

    	// For related messages the option of sent/received selected on GUI might be different.
    	if ((inboundOutbound1 == 'Inbound')  && (messageStatus!=null && messageStatus.indexOf("OB_MSG")==-1 ) ){
    		inboundOutbound2 = 'Received';
    	}else{
    		inboundOutbound2 = 'Sent';
    	}
              
        if (data.message_status != null){
        dojo.byId("messageStatus2").innerHTML = data.message_status};
		if (data.receivedDate != null){
        dojo.byId("receiveDate").innerHTML = data.receivedDate};
        dojo.byId("rxMessageType").innerHTML = data.messageType;
        //Pharmacy
        if (data.pharmacyName != null){
        dojo.byId("pharmacyName").innerHTML = data.pharmacyName};
        if (data.pharmacyAddr1 != null){
        dojo.byId("pharmacyAddr1").innerHTML = data.pharmacyAddr1};
		if (data.pharmacyAddr2 != null && data.pharmacyAddr2 != ",   " ){
		dojo.byId("pharmacyAddr2").innerHTML = data.pharmacyAddr2};
        if (data.pharmacyPhone != null){
        dojo.byId("pharmacyPhone").innerHTML = formatUsPhone(data.pharmacyPhone)};
        
        if (data.pharmacyNcpdpid != null){
        dojo.byId("pharmacyNCPDPID").innerHTML = data.pharmacyNcpdpid};
        
        //Prescriber
        if (data.prescriberFirstName != null){
        dojo.byId("prescriberFirstName").innerHTML = data.prescriberFirstName};
        if (data.prescriberMidName != null){
        dojo.byId("prescriberMidName").innerHTML = data.prescriberMidName};
        if (data.prescriberLastName != null){
		dojo.byId("prescriberLastName").innerHTML = data.prescriberLastName};
		if (data.pharmacyAddr1 != null){
		dojo.byId("prescriberAddr1").innerHTML = data.prescriberAddr1};
		if (data.prescriberAddr2 != null && data.prescriberAddr2 != ",   " ){
		dojo.byId("prescriberAddr2").innerHTML = data.prescriberAddr2};
		
        if (data.prescriberNPI != null){
        dojo.byId("prescriberNPI").innerHTML = data.prescriberNPI
        };	
		
		if (data.prescriberDEA != null){
		dojo.byId("prescriberDEA").innerHTML = data.prescriberDEA};
		if (data.prescriberStateLic != null){
		dojo.byId("prescriberStateLic").innerHTML = data.prescriberStateLic};
		if (data.prescriberPhone != null){
		dojo.byId("prescriberPhone").innerHTML = formatUsPhone(data.prescriberPhone)};
		if (data.prescriberFax != null){
		dojo.byId("prescriberFax").innerHTML = formatUsPhone(data.prescriberFax)}; 
		if (data.prescriberAgent != null){       
		dojo.byId("prescriberAgent").innerHTML = data.prescriberAgent};        
        //Patient
		if (data.patientFirstName != null){
        dojo.byId("patientFirstName").innerHTML = data.patientFirstName};
        if (data.patientMidName != null){
        dojo.byId("patientMidName").innerHTML = data.patientMidName};
        if (data.patientLastName != null){
		dojo.byId("patientLastName").innerHTML = data.patientLastName};
		if (data.patientSocSn != null){
		dojo.byId("patientSocSn").innerHTML = data.patientSocSn};
		if (data.pharmacyAddr1 != null){
		
			if(data.pharmacyAddr1=="" || data.pharmacyAddr1==" " )
			{
				dojo.byId("patientAddr1").innerHTML = "&nbsp;";
			}
			else 
			{
				dojo.byId("patientAddr1").innerHTML = data.patientAddr1;
			}
		
		
		}
		if (data.patientAddr2 != null && data.patientAddr2 != ",   " ){
		dojo.byId("patientAddr2").innerHTML = data.patientAddr2};
		if (data.patientDob != null){
		dojo.byId("patientDob").innerHTML = data.patientDob};
		if (data.patientGender != null){
		dojo.byId("patientGender").innerHTML = data.patientGender};	
		if (data.patientPrimaryPhone != null){
			dojo.byId("patientPrimaryPhone").innerHTML = formatUsPhone(data.patientPrimaryPhone)};
		if (data.patientHomePhone != null){
				dojo.byId("patientHomePhone").innerHTML = formatUsPhone(data.patientHomePhone)};			
		if (data.planId != null){
		dojo.byId("patientPlanId").innerHTML = data.planId};
		//Observations		
    	if (data.patientWeight != null){
			dojo.byId("patientWeight").innerHTML = data.patientWeight};	
		if (data.patientHeight != null){
			dojo.byId("patientHeight").innerHTML = data.patientHeight};
			
		if (data.prohibitRenewalRequest != null){
				dojo.byId("rxProhibitRenewal").innerHTML = data.prohibitRenewalRequest};		

        //Prescription
        if (data.rxDrugPrescribed != null){
        dojo.byId("rxDrugPrescribed").innerHTML = data.rxDrugPrescribed};
        if (data.rxDrugPrescribedNdc != null){
        dojo.byId("rxDrugPrescribedNdc").innerHTML = data.rxDrugPrescribedNdc};
        if (data.rxQuantity != null){
        dojo.byId("rxQuantity").innerHTML = data.rxQuantity};
        if (data.rxDaysSupply != null){
		dojo.byId("rxDaysSupply").innerHTML = data.rxDaysSupply};
		if (data.rxDateWritten != null){
		dojo.byId("rxDateWritten").innerHTML = data.rxDateWritten};
		if (data.rxIssueDate != null){
		dojo.byId("rxEffectiveDate").innerHTML = data.rxIssueDate};
		if (data.rxPotencyUnitCode != null){
		dojo.byId("rxPotencyUnitCode").innerHTML = data.rxPotencyUnitCode};
		if (data.rxDrugForm != null){
		dojo.byId("rxDrugForm").innerHTML = data.rxDrugForm};
		if (data.rxDrugStrength != null){
		dojo.byId("rxDrugStrength").innerHTML = data.rxDrugStrength};
		if (data.rxRefills != null){
		dojo.byId("rxRefills").innerHTML = data.rxRefills};
		if (data.rxSig != null){
		dojo.byId("rxSig").innerHTML = data.rxSig};
		if (data.rxDispenseNotes != null){
		dojo.byId("rxDispenseNotes").innerHTML = data.rxDispenseNotes};
		if (data.rxComments != null){
		dojo.byId("rxComments").innerHTML = data.rxComments};
		if ( data.rxGrp != null){
		dojo.byId("rxGrp").innerHTML = data.rxGrp};
		if (data.rxBinNum != null){
		dojo.byId("rxBinNum").innerHTML = data.rxBinNum};
		if (data.rxPcn != null){
		dojo.byId("rxPcn").innerHTML = data.rxPcn};
		if (data.inboundNcpdpMsgId != null){
			dojo.byId("rxErxRefNum").innerHTML = data.inboundNcpdpMsgId};
		dojo.byId("rxMessageId").innerHTML = data.rxMessageId;
		// set the value for the relates to message id.
		dojo.byId("trackHubMsgIdHidden").value = data.inboundNcpdpMsgId;
		dojo.byId("trackMsgIdHidden").value = data.rxMessageId;
		dojo.byId("trackMsgTypeHidden").value = data.messageType;
		dojo.byId("trackParentMsgStatusHidden").value = data.message_status;
		
		if (data.relToMessageid != null){
		dojo.byId("rxRelToMessageId").innerHTML = data.relToMessageid};
		dojo.byId("rxMessageId2").innerHTML = data.rxMessageId;
		if (data.relToMessageid != null){
		dojo.byId("rxRelToMessageId2").innerHTML = data.relToMessageid};
		if (data.rxReferenceNumber != null){	
		dojo.byId("rxReferenceNumber").innerHTML = data.rxReferenceNumber};
		if (data.prescriberOrderNumber != null){
		dojo.byId("prescriberOrderNumber").innerHTML = data.prescriberOrderNumber};
		
			
		//AutoCheck Status
		if (data.rxPatientCheck != null){
			 dojo.byId("rxPatientCheck").innerHTML = data.rxPatientCheck};
		if (data.rxProviderCheck != null){
			 dojo.byId("rxProviderCheck").innerHTML = data.rxProviderCheck};
		if (data.rxDrugCheck != null){
			 dojo.byId("rxDrugCheck").innerHTML = data.rxDrugCheck};
			 
		//Medication Dispensed
		if (data.rxDrugDispensed != null){
		 dojo.byId("rxDrugDispensed").innerHTML = data.rxDrugDispensed};
	    if (data.rxDrugDispensedNdc != null){
	     dojo.byId("rxDrugDispensedNdc").innerHTML = data.rxDrugDispensedNdc};
		if (data.rxQuantityDispensed != null){
		 dojo.byId("rxQuantityDispensed").innerHTML = data.rxQuantityDispensed};
		if (data.rxDaysSupplyDispensed != null){
		 dojo.byId("rxDaysSupplyDispensed").innerHTML = data.rxDaysSupplyDispensed};
	    if (data.rxDateWrittenDispensed != null){
		 dojo.byId("rxDateWrittenDispensed").innerHTML = data.rxDateWrittenDispensed};
		if (data.rxPotencyUnitCodeDispensed != null){
		 dojo.byId("rxPotencyUnitCodeDispensed").innerHTML = data.rxPotencyUnitCodeDispensed};
		if (data.rxDrugFormDispensed != null){
	     dojo.byId("rxDrugFormDispensed").innerHTML = data.rxDrugFormDispensed};
		if (data.rxDrugStrengthDispensed != null){
		 dojo.byId("rxDrugStrengthDispensed").innerHTML = data.rxDrugStrengthDispensed};
		if (data.rxRefillsDispensed != null){
		 dojo.byId("rxRefillsDispensed").innerHTML = data.rxRefillsDispensed};
		if (data.rxSigDispensed != null){
		 dojo.byId("rxSigDispensed").innerHTML = data.rxSigDispensed};
		if (data.rxDispenseNotesDispensed != null){
		 dojo.byId("rxDispenseNotesDispensed").innerHTML = data.rxDispenseNotesDispensed};
		if (data.rxCommentsDispensed != null){
		 dojo.byId("rxCommentsDispensed").innerHTML = data.rxCommentsDispensed};
		//Request
		if (data.reqRefno != null){
		dojo.byId("reqRefNum").innerHTML = data.reqRefno;
		}
		//Response
		if (data.resType != null){
		dojo.byId("resAprvDenied").innerHTML = data.resType;
		}
		if (data.resAprvReasonCd != null){
		dojo.byId("resReasonCode").innerHTML = data.resAprvReasonCd;
		}
				
		if (data.resAprvRefno != null){
		dojo.byId("resRefNum").innerHTML = data.resAprvRefno;
		}
		if (data.resAprvNote != null){
		dojo.byId("resNote").innerHTML = data.resAprvNote;
		}
		if (data.resAprvWthChngReasonCd != null){
		dojo.byId("resReasonCode").innerHTML = data.resAprvWthChngReasonCd;
		}
		if (data.resAprvWthChngRefno != null){
		dojo.byId("resRefNum").innerHTML = data.resAprvWthChngRefno;
		}
		if (data.resAprvWthChngNote != null){
		dojo.byId("resNote").innerHTML = data.resAprvWthChngNote;
		}
		if (data.resDenialReasonCd != null){
		dojo.byId("resReasonCode").innerHTML = data.resDenialReasonCd;
		}
		if (data.resDenialRefno != null){
		dojo.byId("resRefNum").innerHTML = data.resDenialRefno;
		}
		if (data.resDenialReason != null){
		dojo.byId("resReason").innerHTML = data.resDenialReason;
		}
		if (data.resDenialNrxReasonCd != null){
		dojo.byId("resReasonCode").innerHTML = data.resDenialNrxReasonCd;
		}
		if (data.resDenialNrxRefno != null){
		dojo.byId("resRefNum").innerHTML = data.resDenialNrxRefno;
		}
		if (data.resDenialNrxReason != null){
		dojo.byId("resReason").innerHTML = data.resDenialNrxReason;
		}
		
		//display patient-provider-drug validation status for NEWRX and RXRENEWALRESPONSE only	
		if (data.messageType.toUpperCase() == 'NEWRX'  || data.messageType.toUpperCase() == 'RXCHANGERESPONSE' || (data.messageType.toUpperCase() == 'RXRENEWALRESPONSE' && data.resType.toUpperCase() == 'REPLACE'))
		{
			dojo.style(dojo.byId('trackAutoCheck'), "display", "block"); 
		}
		else
		{
			dojo.style(dojo.byId('trackAutoCheck'), "display", "none"); 
		}
		//display medication dispensed for REFILLREQUEST and others	
		if (data.rxDrugDispensed != null){
			dojo.style(dojo.byId('trackMedDisp'), "display", "block"); 
			}
		dojo.style(dojo.byId('prohibitRenew'), "display", "block");
		dojo.style(dojo.byId('benefitsCoordination1'), "display", "block");
		dojo.style(dojo.byId('benefitsCoordination2'), "display", "block");
		//don't display prohibitRenewal
		if (data.messageType.toUpperCase() == 'RXRENEWALREQUEST' || data.messageType.toUpperCase() == 'RXRENEWALRESPONSE'){ 
			dojo.style(dojo.byId('prohibitRenew'), "display", "none");
			}
		//display response/request if present
		if (data.messageType.toUpperCase() == 'RXRENEWALRESPONSE' ||data.messageType.toUpperCase() == 'REFILLRESPONSE' || data.messageType.toUpperCase() == 'RXCHANGERESPONSE' || data.messageType.toUpperCase() == 'CANCELRXRESPONSE' ){
		dojo.style(dojo.byId('trackReqRes'), "display", "block");
		//don't display benefits coordination
		dojo.style(dojo.byId('benefitsCoordination1'), "display", "none");
		dojo.style(dojo.byId('benefitsCoordination2'), "display", "none");
		}
		//if Error or Verify don't show empty Patient or Prescription
		if (data.messageType.toUpperCase() == 'ERROR' || data.messageType.toUpperCase() == 'VERIFY' || data.messageType.toUpperCase() == 'STATUS' ){
			if (data.esvCode != null){
				dojo.byId("esvCode").innerHTML = data.esvCode;
				}
			if (data.esvDescriptionCode != null){
				dojo.byId("esvDescriptionCode").innerHTML = data.esvDescriptionCode;
				}
			if (data.esvDescription != null){
				dojo.byId("esvDescription").innerHTML = data.esvDescription;
				}
			
			dojo.byId("rxMessageType").innerHTML = data.messageType + '<span style="font-size: 12px;"> - (' + inboundOutbound2 + ')</span>';
			dojo.byId("pharmacyNCPDPID2").innerHTML = data.pharmacyNcpdpid;
			dojo.byId("rxClinicID").innerHTML = data.clinicId;

			dojo.style(dojo.byId('trackPrescrPatient'), "display", "none");
			dojo.style(dojo.byId('trackErrVerStat'), "display", "block");
		} else{
			dojo.style(dojo.byId('trackPrescrPatient'), "display", "block");
			dojo.style(dojo.byId('trackErrVerStat'), "display", "none");
		}
		
		if (data.messageType.toUpperCase() == 'CANCELRX'){
			if (data.changeofPrescrStatFlg != null){
				dojo.byId("changeofPrescrStatFlg").innerHTML = data.changeofPrescrStatFlg;
				} 
			dojo.style(dojo.byId('trackCancelRx'), "display", "block");
		} else{
			dojo.style(dojo.byId('trackCancelRx'), "display", "none");	
		}
		
		if (data.messageType.toUpperCase() == 'RXCHANGEREQUEST'){
			if (data.changeRequestType != null){
				dojo.byId("changeRequestType").innerHTML = data.changeRequestType;
				
				changeRequestTypeVal =  data.changeRequestType;
				
			}
			
			
			if (data.rxReferenceNumber != null){
			
				dojo.byId("requestReferenceNumber").innerHTML = data.rxReferenceNumber;
			}
			
			if((null!= changeRequestTypeVal) && (changeRequestTypeVal =='Prior Authorization' ||changeRequestTypeVal =='Prescriber Authorization' ))
			{
				// Medication Requested section is blank.
				
				// Defect fix - reset- if more than one medication request than change title of medication request to medication requested # 1, else don't change it.
				dojo.byId("rxChangeRequestMedRequstDiv1").innerHTML = "MEDICATION REQUESTED";
				
				if (data.requestReferenceNumber != null){
					dojo.byId("requestReferenceNumber").innerHTML = data.requestReferenceNumber;
					}
				//Medication Requested
				if (data.rxDrugRequested != null){
					dojo.byId("rxDrugRequested").innerHTML = "&nbsp;";
					}
			    if (data.rxDrugRequestedNdc != null){
			    	dojo.byId("rxDrugRequestedNdc").innerHTML= "&nbsp;";
					}
				if (data.rxQuantityRequested != null){
					dojo.byId("rxQuantityRequested").innerHTML = "&nbsp;";
					}
				if (data.rxDaysSupplyRequested != null){
					dojo.byId("rxDaysSupplyRequested").innerHTML = "&nbsp;";
					}
			    if (data.rxDateWrittenRequested != null){
			    	dojo.byId("rxDateWrittenRequested").innerHTML = "&nbsp;";
					}
				if (data.rxPotencyUnitCodeRequested != null){
					dojo.byId("rxPotencyUnitCodeRequested").innerHTML = "&nbsp;";
					}
				if (data.rxDrugFormRequested != null){
					dojo.byId("rxDrugFormRequested").innerHTML = "&nbsp;";
					}
				if (data.rxDrugStrengthRequested != null){
					dojo.byId("rxDrugStrengthRequested").innerHTML = "&nbsp;";
					}
				if (data.rxRefillsRequested != null){
					dojo.byId("rxRefillsRequested").innerHTML = "&nbsp;";
					}
				if (data.rxSigRequested != null){
					dojo.byId("rxSigRequested").innerHTML = "&nbsp;";
					}
				if (data.rxDispenseNotesRequested != null){
					dojo.byId("rxDispenseNotesRequested").innerHTML = "&nbsp;";
					}
				if (data.rxCommentsRequested != null){
					dojo.byId("rxCommentsRequested").innerHTML = "&nbsp;";
					}
				 
				 dojo.style(dojo.byId('trackChangeRequest'), "display", "block");
				 //<!--2-->
				if(data.rxDrugRequested2 !=null){
					dojo.byId("rxDrugRequested2").innerHTML = "&nbsp;";
					
					// Defect fix - if more than one medication request than change title of medication request to medication requested # 1, else don't change it.					
					
					dojo.byId("rxChangeRequestMedRequstDiv1").innerHTML = "MEDICATION REQUESTED #1";
				    
					if (data.rxDrugRequestedNdc2 != null){
				     dojo.byId("rxDrugRequestedNdc2").innerHTML = "&nbsp;";
					}
					if (data.rxQuantityRequested2 != null){
					 dojo.byId("rxQuantityRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxDaysSupplyRequested2 != null){
					 dojo.byId("rxDaysSupplyRequested2").innerHTML = "&nbsp;";
					}
				    if (data.rxDateWrittenRequested2 != null){
					 dojo.byId("rxDateWrittenRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxPotencyUnitCodeRequested2 != null){
					 dojo.byId("rxPotencyUnitCodeRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxDrugFormRequested2 != null){
				     dojo.byId("rxDrugFormRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxDrugStrengthRequested2 != null){
					 dojo.byId("rxDrugStrengthRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxRefillsRequested2 != null){
					 dojo.byId("rxRefillsRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxSigRequested2 != null){
					 dojo.byId("rxSigRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxDispenseNotesRequested2 != null){
					 dojo.byId("rxDispenseNotesRequested2").innerHTML = "&nbsp;";
					}
					if (data.rxCommentsRequested2 != null){
					 dojo.byId("rxCommentsRequested2").innerHTML = "&nbsp;";
					}
					 dojo.style(dojo.byId('trackMedRequested2'), "display", "block");
					 }
				else {
					dojo.style(dojo.byId('trackMedRequested2'), "display", "none");
				}
				 //<!--3-->
				 if(data.rxDrugRequested3 !=null){
						dojo.byId("rxDrugRequested3").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc3 != null){
					     dojo.byId("rxDrugRequestedNdc3").innerHTML = "&nbsp;";
					    }
						if (data.rxQuantityRequested3 != null){
						 dojo.byId("rxQuantityRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxDaysSupplyRequested3 != null){
						 dojo.byId("rxDaysSupplyRequested3").innerHTML = "&nbsp;";
						}
					    if (data.rxDateWrittenRequested3 != null){
						 dojo.byId("rxDateWrittenRequested3").innerHTML = "&nbsp;";
					    }
						if (data.rxPotencyUnitCodeRequested3 != null){
						 dojo.byId("rxPotencyUnitCodeRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxDrugFormRequested3 != null){
					     dojo.byId("rxDrugFormRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxDrugStrengthRequested3 != null){
						 dojo.byId("rxDrugStrengthRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxRefillsRequested3 != null){
						 dojo.byId("rxRefillsRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxSigRequested3 != null){
						 dojo.byId("rxSigRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxDispenseNotesRequested3 != null){
						 dojo.byId("rxDispenseNotesRequested3").innerHTML = "&nbsp;";
						}
						if (data.rxCommentsRequested3 != null){
						 dojo.byId("rxCommentsRequested3").innerHTML = "&nbsp;";
						}
						 dojo.style(dojo.byId('trackMedRequested3'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested3'), "display", "none");
					}
				 //<!--4-->
				 if(data.rxDrugRequested4 !=null){
						dojo.byId("rxDrugRequested4").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc4 != null){
					     dojo.byId("rxDrugRequestedNdc4").innerHTML = "&nbsp;";
					    }
						if (data.rxQuantityRequested4 != null){
						 dojo.byId("rxQuantityRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxDaysSupplyRequested4 != null){
						 dojo.byId("rxDaysSupplyRequested4").innerHTML = "&nbsp;";
						}
					    if (data.rxDateWrittenRequested4 != null){
						 dojo.byId("rxDateWrittenRequested4").innerHTML = "&nbsp;";
					    }
						if (data.rxPotencyUnitCodeRequested4 != null){
						 dojo.byId("rxPotencyUnitCodeRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxDrugFormRequested4 != null){
					     dojo.byId("rxDrugFormRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxDrugStrengthRequested4 != null){
						 dojo.byId("rxDrugStrengthRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxRefillsRequested2 != null){
						 dojo.byId("rxRefillsRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxSigRequested4 != null){
						 dojo.byId("rxSigRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxDispenseNotesRequested4 != null){
						 dojo.byId("rxDispenseNotesRequested4").innerHTML = "&nbsp;";
						}
						if (data.rxCommentsRequested4 != null){
						 dojo.byId("rxCommentsRequested4").innerHTML = "&nbsp;";
						}
						 dojo.style(dojo.byId('trackMedRequested4'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested4'), "display", "none");
					}
				 //<!--5-->
				 if(data.rxDrugRequested5 !=null){
						dojo.byId("rxDrugRequested5").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc5 != null){
					     dojo.byId("rxDrugRequestedNdc5").innerHTML = "&nbsp;";
					    }
						if (data.rxQuantityRequested5 != null){
						 dojo.byId("rxQuantityRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxDaysSupplyRequested5 != null){
						 dojo.byId("rxDaysSupplyRequested5").innerHTML = "&nbsp;";
						}
					    if (data.rxDateWrittenRequested5 != null){
						 dojo.byId("rxDateWrittenRequested5").innerHTML = "&nbsp;";
					    }
						if (data.rxPotencyUnitCodeRequested5 != null){
						 dojo.byId("rxPotencyUnitCodeRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxDrugFormRequested5 != null){
					     dojo.byId("rxDrugFormRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxDrugStrengthRequested5 != null){
						 dojo.byId("rxDrugStrengthRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxRefillsRequested5 != null){
						 dojo.byId("rxRefillsRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxSigRequested5 != null){
						 dojo.byId("rxSigRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxDispenseNotesRequested5 != null){
						 dojo.byId("rxDispenseNotesRequested5").innerHTML = "&nbsp;";
						}
						if (data.rxCommentsRequested5 != null){
						 dojo.byId("rxCommentsRequested5").innerHTML = "&nbsp;";
						}
						 dojo.style(dojo.byId('trackMedRequested5'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested5'), "display", "none");
					}
				 //<!--6-->
				 if(data.rxDrugRequested6 !=null){
						dojo.byId("rxDrugRequested6").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc6 != null){
					     dojo.byId("rxDrugRequestedNdc6").innerHTML = data.rxDrugRequestedNdc6;
					    }
						if (data.rxQuantityRequested6 != null){
						 dojo.byId("rxQuantityRequested6").innerHTML = data.rxQuantityRequested6;
						}
						if (data.rxDaysSupplyRequested6 != null){
						 dojo.byId("rxDaysSupplyRequested6").innerHTML = data.rxDaysSupplyRequested6;
						}
					    if (data.rxDateWrittenRequested6 != null){
						 dojo.byId("rxDateWrittenRequested6").innerHTML = data.rxDateWrittenRequested6;
					    }
						if (data.rxPotencyUnitCodeRequested6 != null){
						 dojo.byId("rxPotencyUnitCodeRequested6").innerHTML = data.rxPotencyUnitCodeRequested6;
						}
						if (data.rxDrugFormRequested6 != null){
					     dojo.byId("rxDrugFormRequested6").innerHTML = data.rxDrugFormRequested6;
						}
						if (data.rxDrugStrengthRequested6 != null){
						 dojo.byId("rxDrugStrengthRequested6").innerHTML = data.rxDrugStrengthRequested6;
						}
						if (data.rxRefillsRequested6 != null){
						 dojo.byId("rxRefillsRequested6").innerHTML = data.rxRefillsRequested6;
						}
						if (data.rxSigRequested6 != null){
						 dojo.byId("rxSigRequested6").innerHTML = data.rxSigRequested6;
						}
						if (data.rxDispenseNotesRequested6 != null){
						 dojo.byId("rxDispenseNotesRequested6").innerHTML = data.rxDispenseNotesRequested6;
						}
						if (data.rxCommentsRequested6 != null){
						 dojo.byId("rxCommentsRequested6").innerHTML = data.rxCommentsRequested6;
						}
						 dojo.style(dojo.byId('trackMedRequested6'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested6'), "display", "none");
					}
				 //<!--7-->
				 if(data.rxDrugRequested7 !=null){
						dojo.byId("rxDrugRequested7").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc7 != null){
					     dojo.byId("rxDrugRequestedNdc7").innerHTML = "&nbsp;";
					    }
						if (data.rxQuantityRequested7 != null){
						 dojo.byId("rxQuantityRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxDaysSupplyRequested7 != null){
						 dojo.byId("rxDaysSupplyRequested7").innerHTML = "&nbsp;";
						}
					    if (data.rxDateWrittenRequested7 != null){
						 dojo.byId("rxDateWrittenRequested7").innerHTML = "&nbsp;";
					    }
						if (data.rxPotencyUnitCodeRequested7 != null){
						 dojo.byId("rxPotencyUnitCodeRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxDrugFormRequested7 != null){
					     dojo.byId("rxDrugFormRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxDrugStrengthRequested7 != null){
						 dojo.byId("rxDrugStrengthRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxRefillsRequested7 != null){
						 dojo.byId("rxRefillsRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxSigRequested7 != null){
						 dojo.byId("rxSigRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxDispenseNotesRequested7 != null){
						 dojo.byId("rxDispenseNotesRequested7").innerHTML = "&nbsp;";
						}
						if (data.rxCommentsRequested7 != null){
						 dojo.byId("rxCommentsRequested7").innerHTML = "&nbsp;";
						}
						 dojo.style(dojo.byId('trackMedRequested7'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested7'), "display", "none");
					}
				 //<!--8-->
				 if(data.rxDrugRequested8 !=null){
						dojo.byId("rxDrugRequested8").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc8 != null){
					     dojo.byId("rxDrugRequestedNdc8").innerHTML = "&nbsp;";
					    }
						if (data.rxQuantityRequested8 != null){
						 dojo.byId("rxQuantityRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxDaysSupplyRequested8 != null){
						 dojo.byId("rxDaysSupplyRequested8").innerHTML = "&nbsp;";
						}
					    if (data.rxDateWrittenRequested8 != null){
						 dojo.byId("rxDateWrittenRequested8").innerHTML = "&nbsp;";
					    }
						if (data.rxPotencyUnitCodeRequested8 != null){
						 dojo.byId("rxPotencyUnitCodeRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxDrugFormRequested8 != null){
					     dojo.byId("rxDrugFormRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxDrugStrengthRequested8 != null){
						 dojo.byId("rxDrugStrengthRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxRefillsRequested8 != null){
						 dojo.byId("rxRefillsRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxSigRequested8 != null){
						 dojo.byId("rxSigRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxDispenseNotesRequested8 != null){
						 dojo.byId("rxDispenseNotesRequested8").innerHTML = "&nbsp;";
						}
						if (data.rxCommentsRequested8 != null){
						 dojo.byId("rxCommentsRequested8").innerHTML = "&nbsp;";
						}
						 dojo.style(dojo.byId('trackMedRequested8'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested8'), "display", "none");
					}
				 //<!--9-->
				 if(data.rxDrugRequested9 !=null){
						dojo.byId("rxDrugRequested9").innerHTML = "&nbsp;";
					    if (data.rxDrugRequestedNdc9 != null){
					     dojo.byId("rxDrugRequestedNdc9").innerHTML = "&nbsp;";
					    }
						if (data.rxQuantityRequested2 != null){
						 dojo.byId("rxQuantityRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxDaysSupplyRequested2 != null){
						 dojo.byId("rxDaysSupplyRequested9").innerHTML = "&nbsp;";
						}
					    if (data.rxDateWrittenRequested9 != null){
						 dojo.byId("rxDateWrittenRequested9").innerHTML = "&nbsp;";
					    }
						if (data.rxPotencyUnitCodeRequested9 != null){
						 dojo.byId("rxPotencyUnitCodeRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxDrugFormRequested9 != null){
					     dojo.byId("rxDrugFormRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxDrugStrengthRequested9 != null){
						 dojo.byId("rxDrugStrengthRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxRefillsRequested9 != null){
						 dojo.byId("rxRefillsRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxSigRequested9 != null){
						 dojo.byId("rxSigRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxDispenseNotesRequested9 != null){
						 dojo.byId("rxDispenseNotesRequested9").innerHTML = "&nbsp;";
						}
						if (data.rxCommentsRequested9 != null){
						 dojo.byId("rxCommentsRequested9").innerHTML = "&nbsp;";
						}
						 dojo.style(dojo.byId('trackMedRequested9'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested9'), "display", "none");
					}
				
				 
				 
			
			}	
			else
			{
				if (data.requestReferenceNumber != null){
					dojo.byId("requestReferenceNumber").innerHTML = data.requestReferenceNumber;
					}
				//Medication Requested
				if (data.rxDrugRequested != null){
					dojo.byId("rxDrugRequested").innerHTML = data.rxDrugRequested;
					
					// Defect fix - reset- if more than one medication request than change title of medication request to medication requested # 1, else don't change it.
					dojo.byId("rxChangeRequestMedRequstDiv1").innerHTML = "MEDICATION REQUESTED";
					
					}
			    if (data.rxDrugRequestedNdc != null){
			    	dojo.byId("rxDrugRequestedNdc").innerHTML = data.rxDrugRequestedNdc;
					}
				if (data.rxQuantityRequested != null){
					dojo.byId("rxQuantityRequested").innerHTML = data.rxQuantityRequested;
					}
				if (data.rxDaysSupplyRequested != null){
					dojo.byId("rxDaysSupplyRequested").innerHTML = data.rxDaysSupplyRequested;
					}
			    if (data.rxDateWrittenRequested != null){
			    	dojo.byId("rxDateWrittenRequested").innerHTML = data.rxDateWrittenRequested;
					}
				if (data.rxPotencyUnitCodeRequested != null){
					dojo.byId("rxPotencyUnitCodeRequested").innerHTML = data.rxPotencyUnitCodeRequested;
					}
				if (data.rxDrugFormRequested != null){
					dojo.byId("rxDrugFormRequested").innerHTML = data.rxDrugFormRequested;
					}
				if (data.rxDrugStrengthRequested != null){
					dojo.byId("rxDrugStrengthRequested").innerHTML = data.rxDrugStrengthRequested;
					}
				if (data.rxRefillsRequested != null){
					dojo.byId("rxRefillsRequested").innerHTML = data.rxRefillsRequested;
					}
				if (data.rxSigRequested != null){
					dojo.byId("rxSigRequested").innerHTML = data.rxSigRequested;
					}
				if (data.rxDispenseNotesRequested != null){
					dojo.byId("rxDispenseNotesRequested").innerHTML = data.rxDispenseNotesRequested;
					}
				if (data.rxCommentsRequested != null){
					dojo.byId("rxCommentsRequested").innerHTML = data.rxCommentsRequested;
					}
				 
				 dojo.style(dojo.byId('trackChangeRequest'), "display", "block");
				 //<!--2-->
				if(data.rxDrugRequested2 !=null){
					dojo.byId("rxDrugRequested2").innerHTML = data.rxDrugRequested2;
				    
					
					// Defect fix - if more than one medication request than change title of medication request to medication requested # 1, else don't change it.					
					
					dojo.byId("rxChangeRequestMedRequstDiv1").innerHTML = "MEDICATION REQUESTED #1";
					
					if (data.rxDrugRequestedNdc2 != null){
				     dojo.byId("rxDrugRequestedNdc2").innerHTML = data.rxDrugRequestedNdc2;
					}
					if (data.rxQuantityRequested2 != null){
					 dojo.byId("rxQuantityRequested2").innerHTML = data.rxQuantityRequested2;
					}
					if (data.rxDaysSupplyRequested2 != null){
					 dojo.byId("rxDaysSupplyRequested2").innerHTML = data.rxDaysSupplyRequested2;
					}
				    if (data.rxDateWrittenRequested2 != null){
					 dojo.byId("rxDateWrittenRequested2").innerHTML = data.rxDateWrittenRequested2;
					}
					if (data.rxPotencyUnitCodeRequested2 != null){
					 dojo.byId("rxPotencyUnitCodeRequested2").innerHTML = data.rxPotencyUnitCodeRequested2;
					}
					if (data.rxDrugFormRequested2 != null){
				     dojo.byId("rxDrugFormRequested2").innerHTML = data.rxDrugFormRequested2;
					}
					if (data.rxDrugStrengthRequested2 != null){
					 dojo.byId("rxDrugStrengthRequested2").innerHTML = data.rxDrugStrengthRequested2;
					}
					if (data.rxRefillsRequested2 != null){
					 dojo.byId("rxRefillsRequested2").innerHTML = data.rxRefillsRequested2;
					}
					if (data.rxSigRequested2 != null){
					 dojo.byId("rxSigRequested2").innerHTML = data.rxSigRequested2;
					}
					if (data.rxDispenseNotesRequested2 != null){
					 dojo.byId("rxDispenseNotesRequested2").innerHTML = data.rxDispenseNotesRequested2;
					}
					if (data.rxCommentsRequested2 != null){
					 dojo.byId("rxCommentsRequested2").innerHTML = data.rxCommentsRequested2;
					}
					 dojo.style(dojo.byId('trackMedRequested2'), "display", "block");
					 }
				else {
					dojo.style(dojo.byId('trackMedRequested2'), "display", "none");
				}
				 //<!--3-->
				 if(data.rxDrugRequested3 !=null){
						dojo.byId("rxDrugRequested3").innerHTML = data.rxDrugRequested3;
					    if (data.rxDrugRequestedNdc3 != null){
					     dojo.byId("rxDrugRequestedNdc3").innerHTML = data.rxDrugRequestedNdc3;
					    }
						if (data.rxQuantityRequested3 != null){
						 dojo.byId("rxQuantityRequested3").innerHTML = data.rxQuantityRequested3;
						}
						if (data.rxDaysSupplyRequested3 != null){
						 dojo.byId("rxDaysSupplyRequested3").innerHTML = data.rxDaysSupplyRequested3;
						}
					    if (data.rxDateWrittenRequested3 != null){
						 dojo.byId("rxDateWrittenRequested3").innerHTML = data.rxDateWrittenRequested3;
					    }
						if (data.rxPotencyUnitCodeRequested3 != null){
						 dojo.byId("rxPotencyUnitCodeRequested3").innerHTML = data.rxPotencyUnitCodeRequested3;
						}
						if (data.rxDrugFormRequested3 != null){
					     dojo.byId("rxDrugFormRequested3").innerHTML = data.rxDrugFormRequested3;
						}
						if (data.rxDrugStrengthRequested3 != null){
						 dojo.byId("rxDrugStrengthRequested3").innerHTML = data.rxDrugStrengthRequested3;
						}
						if (data.rxRefillsRequested3 != null){
						 dojo.byId("rxRefillsRequested3").innerHTML = data.rxRefillsRequested3;
						}
						if (data.rxSigRequested3 != null){
						 dojo.byId("rxSigRequested3").innerHTML = data.rxSigRequested3;
						}
						if (data.rxDispenseNotesRequested3 != null){
						 dojo.byId("rxDispenseNotesRequested3").innerHTML = data.rxDispenseNotesRequested3;
						}
						if (data.rxCommentsRequested3 != null){
						 dojo.byId("rxCommentsRequested3").innerHTML = data.rxCommentsRequested3;
						}
						 dojo.style(dojo.byId('trackMedRequested3'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested3'), "display", "none");
					}
				 //<!--4-->
				 if(data.rxDrugRequested4 !=null){
						dojo.byId("rxDrugRequested4").innerHTML = data.rxDrugRequested4;
					    if (data.rxDrugRequestedNdc4 != null){
					     dojo.byId("rxDrugRequestedNdc4").innerHTML = data.rxDrugRequestedNdc4;
					    }
						if (data.rxQuantityRequested4 != null){
						 dojo.byId("rxQuantityRequested4").innerHTML = data.rxQuantityRequested4;
						}
						if (data.rxDaysSupplyRequested4 != null){
						 dojo.byId("rxDaysSupplyRequested4").innerHTML = data.rxDaysSupplyRequested4;
						}
					    if (data.rxDateWrittenRequested4 != null){
						 dojo.byId("rxDateWrittenRequested4").innerHTML = data.rxDateWrittenRequested4;
					    }
						if (data.rxPotencyUnitCodeRequested4 != null){
						 dojo.byId("rxPotencyUnitCodeRequested4").innerHTML = data.rxPotencyUnitCodeRequested4;
						}
						if (data.rxDrugFormRequested4 != null){
					     dojo.byId("rxDrugFormRequested4").innerHTML = data.rxDrugFormRequested4;
						}
						if (data.rxDrugStrengthRequested4 != null){
						 dojo.byId("rxDrugStrengthRequested4").innerHTML = data.rxDrugStrengthRequested4;
						}
						if (data.rxRefillsRequested2 != null){
						 dojo.byId("rxRefillsRequested4").innerHTML = data.rxRefillsRequested4;
						}
						if (data.rxSigRequested4 != null){
						 dojo.byId("rxSigRequested4").innerHTML = data.rxSigRequested4;
						}
						if (data.rxDispenseNotesRequested4 != null){
						 dojo.byId("rxDispenseNotesRequested4").innerHTML = data.rxDispenseNotesRequested4;
						}
						if (data.rxCommentsRequested4 != null){
						 dojo.byId("rxCommentsRequested4").innerHTML = data.rxCommentsRequested4;
						}
						 dojo.style(dojo.byId('trackMedRequested4'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested4'), "display", "none");
					}
				 //<!--5-->
				 if(data.rxDrugRequested5 !=null){
						dojo.byId("rxDrugRequested5").innerHTML = data.rxDrugRequested5;
					    if (data.rxDrugRequestedNdc5 != null){
					     dojo.byId("rxDrugRequestedNdc5").innerHTML = data.rxDrugRequestedNdc5;
					    }
						if (data.rxQuantityRequested5 != null){
						 dojo.byId("rxQuantityRequested5").innerHTML = data.rxQuantityRequested5;
						}
						if (data.rxDaysSupplyRequested5 != null){
						 dojo.byId("rxDaysSupplyRequested5").innerHTML = data.rxDaysSupplyRequested5;
						}
					    if (data.rxDateWrittenRequested5 != null){
						 dojo.byId("rxDateWrittenRequested5").innerHTML = data.rxDateWrittenRequested5;
					    }
						if (data.rxPotencyUnitCodeRequested5 != null){
						 dojo.byId("rxPotencyUnitCodeRequested5").innerHTML = data.rxPotencyUnitCodeRequested5;
						}
						if (data.rxDrugFormRequested5 != null){
					     dojo.byId("rxDrugFormRequested5").innerHTML = data.rxDrugFormRequested5;
						}
						if (data.rxDrugStrengthRequested5 != null){
						 dojo.byId("rxDrugStrengthRequested5").innerHTML = data.rxDrugStrengthRequested5;
						}
						if (data.rxRefillsRequested5 != null){
						 dojo.byId("rxRefillsRequested5").innerHTML = data.rxRefillsRequested5;
						}
						if (data.rxSigRequested5 != null){
						 dojo.byId("rxSigRequested5").innerHTML = data.rxSigRequested5;
						}
						if (data.rxDispenseNotesRequested5 != null){
						 dojo.byId("rxDispenseNotesRequested5").innerHTML = data.rxDispenseNotesRequested5;
						}
						if (data.rxCommentsRequested5 != null){
						 dojo.byId("rxCommentsRequested5").innerHTML = data.rxCommentsRequested5;
						}
						 dojo.style(dojo.byId('trackMedRequested5'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested5'), "display", "none");
					}
				 //<!--6-->
				 if(data.rxDrugRequested6 !=null){
						dojo.byId("rxDrugRequested6").innerHTML = data.rxDrugRequested6;
					    if (data.rxDrugRequestedNdc6 != null){
					     dojo.byId("rxDrugRequestedNdc6").innerHTML = data.rxDrugRequestedNdc6;
					    }
						if (data.rxQuantityRequested6 != null){
						 dojo.byId("rxQuantityRequested6").innerHTML = data.rxQuantityRequested6;
						}
						if (data.rxDaysSupplyRequested6 != null){
						 dojo.byId("rxDaysSupplyRequested6").innerHTML = data.rxDaysSupplyRequested6;
						}
					    if (data.rxDateWrittenRequested6 != null){
						 dojo.byId("rxDateWrittenRequested6").innerHTML = data.rxDateWrittenRequested6;
					    }
						if (data.rxPotencyUnitCodeRequested6 != null){
						 dojo.byId("rxPotencyUnitCodeRequested6").innerHTML = data.rxPotencyUnitCodeRequested6;
						}
						if (data.rxDrugFormRequested6 != null){
					     dojo.byId("rxDrugFormRequested6").innerHTML = data.rxDrugFormRequested6;
						}
						if (data.rxDrugStrengthRequested6 != null){
						 dojo.byId("rxDrugStrengthRequested6").innerHTML = data.rxDrugStrengthRequested6;
						}
						if (data.rxRefillsRequested6 != null){
						 dojo.byId("rxRefillsRequested6").innerHTML = data.rxRefillsRequested6;
						}
						if (data.rxSigRequested6 != null){
						 dojo.byId("rxSigRequested6").innerHTML = data.rxSigRequested6;
						}
						if (data.rxDispenseNotesRequested6 != null){
						 dojo.byId("rxDispenseNotesRequested6").innerHTML = data.rxDispenseNotesRequested6;
						}
						if (data.rxCommentsRequested6 != null){
						 dojo.byId("rxCommentsRequested6").innerHTML = data.rxCommentsRequested6;
						}
						 dojo.style(dojo.byId('trackMedRequested6'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested6'), "display", "none");
					}
				 //<!--7-->
				 if(data.rxDrugRequested7 !=null){
						dojo.byId("rxDrugRequested7").innerHTML = data.rxDrugRequested7;
					    if (data.rxDrugRequestedNdc7 != null){
					     dojo.byId("rxDrugRequestedNdc7").innerHTML = data.rxDrugRequestedNdc7;
					    }
						if (data.rxQuantityRequested7 != null){
						 dojo.byId("rxQuantityRequested7").innerHTML = data.rxQuantityRequested7;
						}
						if (data.rxDaysSupplyRequested7 != null){
						 dojo.byId("rxDaysSupplyRequested7").innerHTML = data.rxDaysSupplyRequested7;
						}
					    if (data.rxDateWrittenRequested7 != null){
						 dojo.byId("rxDateWrittenRequested7").innerHTML = data.rxDateWrittenRequested7;
					    }
						if (data.rxPotencyUnitCodeRequested7 != null){
						 dojo.byId("rxPotencyUnitCodeRequested7").innerHTML = data.rxPotencyUnitCodeRequested7;
						}
						if (data.rxDrugFormRequested7 != null){
					     dojo.byId("rxDrugFormRequested7").innerHTML = data.rxDrugFormRequested7;
						}
						if (data.rxDrugStrengthRequested7 != null){
						 dojo.byId("rxDrugStrengthRequested7").innerHTML = data.rxDrugStrengthRequested7;
						}
						if (data.rxRefillsRequested7 != null){
						 dojo.byId("rxRefillsRequested7").innerHTML = data.rxRefillsRequested7;
						}
						if (data.rxSigRequested7 != null){
						 dojo.byId("rxSigRequested7").innerHTML = data.rxSigRequested7;
						}
						if (data.rxDispenseNotesRequested7 != null){
						 dojo.byId("rxDispenseNotesRequested7").innerHTML = data.rxDispenseNotesRequested7;
						}
						if (data.rxCommentsRequested7 != null){
						 dojo.byId("rxCommentsRequested7").innerHTML = data.rxCommentsRequested7;
						}
						 dojo.style(dojo.byId('trackMedRequested7'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested7'), "display", "none");
					}
				 //<!--8-->
				 if(data.rxDrugRequested8 !=null){
						dojo.byId("rxDrugRequested8").innerHTML = data.rxDrugRequested8;
					    if (data.rxDrugRequestedNdc8 != null){
					     dojo.byId("rxDrugRequestedNdc8").innerHTML = data.rxDrugRequestedNdc8;
					    }
						if (data.rxQuantityRequested8 != null){
						 dojo.byId("rxQuantityRequested8").innerHTML = data.rxQuantityRequested8;
						}
						if (data.rxDaysSupplyRequested8 != null){
						 dojo.byId("rxDaysSupplyRequested8").innerHTML = data.rxDaysSupplyRequested8;
						}
					    if (data.rxDateWrittenRequested8 != null){
						 dojo.byId("rxDateWrittenRequested8").innerHTML = data.rxDateWrittenRequested8;
					    }
						if (data.rxPotencyUnitCodeRequested8 != null){
						 dojo.byId("rxPotencyUnitCodeRequested8").innerHTML = data.rxPotencyUnitCodeRequested8;
						}
						if (data.rxDrugFormRequested8 != null){
					     dojo.byId("rxDrugFormRequested8").innerHTML = data.rxDrugFormRequested8;
						}
						if (data.rxDrugStrengthRequested8 != null){
						 dojo.byId("rxDrugStrengthRequested8").innerHTML = data.rxDrugStrengthRequested8;
						}
						if (data.rxRefillsRequested8 != null){
						 dojo.byId("rxRefillsRequested8").innerHTML = data.rxRefillsRequested8;
						}
						if (data.rxSigRequested8 != null){
						 dojo.byId("rxSigRequested8").innerHTML = data.rxSigRequested8;
						}
						if (data.rxDispenseNotesRequested8 != null){
						 dojo.byId("rxDispenseNotesRequested8").innerHTML = data.rxDispenseNotesRequested8;
						}
						if (data.rxCommentsRequested8 != null){
						 dojo.byId("rxCommentsRequested8").innerHTML = data.rxCommentsRequested8;
						}
						 dojo.style(dojo.byId('trackMedRequested8'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested8'), "display", "none");
					}
				 //<!--9-->
				 if(data.rxDrugRequested9 !=null){
						dojo.byId("rxDrugRequested9").innerHTML = data.rxDrugRequested9;
					    if (data.rxDrugRequestedNdc9 != null){
					     dojo.byId("rxDrugRequestedNdc9").innerHTML = data.rxDrugRequestedNdc9;
					    }
						if (data.rxQuantityRequested2 != null){
						 dojo.byId("rxQuantityRequested9").innerHTML = data.rxQuantityRequested9;
						}
						if (data.rxDaysSupplyRequested2 != null){
						 dojo.byId("rxDaysSupplyRequested9").innerHTML = data.rxDaysSupplyRequested9;
						}
					    if (data.rxDateWrittenRequested9 != null){
						 dojo.byId("rxDateWrittenRequested9").innerHTML = data.rxDateWrittenRequested9;
					    }
						if (data.rxPotencyUnitCodeRequested9 != null){
						 dojo.byId("rxPotencyUnitCodeRequested9").innerHTML = data.rxPotencyUnitCodeRequested9;
						}
						if (data.rxDrugFormRequested9 != null){
					     dojo.byId("rxDrugFormRequested9").innerHTML = data.rxDrugFormRequested9;
						}
						if (data.rxDrugStrengthRequested9 != null){
						 dojo.byId("rxDrugStrengthRequested9").innerHTML = data.rxDrugStrengthRequested9;
						}
						if (data.rxRefillsRequested9 != null){
						 dojo.byId("rxRefillsRequested9").innerHTML = data.rxRefillsRequested9;
						}
						if (data.rxSigRequested9 != null){
						 dojo.byId("rxSigRequested9").innerHTML = data.rxSigRequested9;
						}
						if (data.rxDispenseNotesRequested9 != null){
						 dojo.byId("rxDispenseNotesRequested9").innerHTML = data.rxDispenseNotesRequested9;
						}
						if (data.rxCommentsRequested9 != null){
						 dojo.byId("rxCommentsRequested9").innerHTML = data.rxCommentsRequested9;
						}
						 dojo.style(dojo.byId('trackMedRequested9'), "display", "block");
						 }
				 else {
						dojo.style(dojo.byId('trackMedRequested9'), "display", "none");
					}
			}
			
				 
			 //For RxChange hide RxBIN and others.			 
			 dojo.style(dojo.byId('benefitsCoordination1'), "display", "none");
			 dojo.style(dojo.byId('benefitsCoordination2'), "display", "none");
			 
			 //hide Drug form and Drug strength fields.
			 dojo.style(dojo.byId('rxChangeRequestDrugFormRequested'), "display", "none");
			 dojo.style(dojo.byId('rxChangeRequestDrugStrengthRequested'), "display", "none");
			 
			 //hide Drug form and Drug strength fields.
			 dojo.style(dojo.byId('rxChangeRequestDrugFormRequested2'), "display", "none");
			 dojo.style(dojo.byId('rxChangeRequestDrugStrengthRequested2'), "display", "none");
			 
			 //hide Drug form and Drug strength fields.
			 dojo.style(dojo.byId('rxChangeRequestDrugFormRequested3'), "display", "none");
			 dojo.style(dojo.byId('rxChangeRequestDrugStrengthRequested3'), "display", "none");
			 
			 //hide Date Written
			 dojo.style(dojo.byId('rxDateWrittenRequestedLabel'), "display", "none");
			 dojo.style(dojo.byId('rxDateWrittenRequested'), "display", "none");
			 
			 dojo.style(dojo.byId('rxDateWrittenRequested2Label'), "display", "none");
			 dojo.style(dojo.byId('rxDateWrittenRequested2'), "display", "none");
			 
			 dojo.style(dojo.byId('rxDateWrittenRequested3Label'), "display", "none");
			 dojo.style(dojo.byId('rxDateWrittenRequested3'), "display", "none");
			 
			 
		} else{
			dojo.style(dojo.byId('trackChangeRequest'), "display", "none");	
		}
		
		// RxChangeResponse
		if ( data.messageType.toUpperCase() == 'RXCHANGERESPONSE' )  
		{
			
			//Update Response Reference # to that RxChangeResponse.
			
			dojo.byId("resRefNum").innerHTML = data.inboundNcpdpMsgId;
			
			
			if (data.rxChangeResponseNote != null){
			     dojo.byId("resNote").innerHTML = data.rxChangeResponseNote;
			}
			
			
			
			
			
			if ( (data.resType != null ) && (data.resType.toUpperCase() == 'VALIDATED')  )
			{
				dojo.style(dojo.byId('rxChangeRespVadlidatedDiv'), "display", "block");	
				
				
				if (data.validatedPrescriberNPI != null){
					 dojo.byId("rxChgRespValidatedPrescriberNPI").innerHTML = data.validatedPrescriberNPI;
				    }
					if (data.validatedPrescriberDEA != null){
					 dojo.byId("rxChgRespValidatedPrescriberDEA").innerHTML = data.validatedPrescriberDEA;
					}
					if (data.validatedPrescriberStateLic != null){
				     dojo.byId("rxChgRespValidatedPrescriberStateLic").innerHTML = data.validatedPrescriberStateLic;
					}
					if (data.rxChangeResponseValidatedDate != null){
					     dojo.byId("rxChgRespValidatedDate").innerHTML = data.rxChangeResponseValidatedDate;
					}
					
					if (data.rxChangValidatedReasonCode != null){
					     dojo.byId("resReasonCode").innerHTML = data.rxChangValidatedReasonCode;
					}
					
					if (data.rxChangeVLDReasonDescription != null){
					     dojo.byId("resReason").innerHTML = data.rxChangeVLDReasonDescription;
					}
					
			}
			else if ( (data.resType != null ) && (data.resType.toUpperCase() == 'DENIED')  )
			{
				
				// hide validated div.				
				dojo.style(dojo.byId('rxChangeRespVadlidatedDiv'), "display", "none");	
				
				if (data.rxChangeDeniedReasonCode != null){
				     dojo.byId("resReasonCode").innerHTML = data.rxChangeDeniedReasonCode;
				}
					
				
				if (data.rxChangeDNDReasonDescription != null){
				     dojo.byId("resReason").innerHTML = data.rxChangeDNDReasonDescription;
				}
				
				if (data.rxChangeResponseDenialReason != null){
				     dojo.byId("resNote").innerHTML = data.rxChangeResponseDenialReason;
				}
				
				
				//Drug Coverage
				dojo.style(dojo.byId('rxChangeRespDrugCoveragePADiv'), "display", "block");
				
				if (data.rxChangeDrugCoverageStatusCode != null){
				     dojo.byId("rxChgRespDrugCoverageStatus").innerHTML = data.rxChangeDrugCoverageStatusCode;
				}
				
				// PA and PA status
				if (data.rxChangeResponsePriorAuthorization != null){
				     dojo.byId("rxChgRespPriorAuthorization").innerHTML = data.rxChangeResponsePriorAuthorization;
				}
				
				if (data.rxChangeResponsePriorAuthorizationStatus != null){
				     dojo.byId("rxChgRespPriorAuthorizationStatus").innerHTML = data.rxChangeResponsePriorAuthorizationStatus;
				}
				
					
			}
			else{  
				
				// hide validated div.				
				dojo.style(dojo.byId('rxChangeRespVadlidatedDiv'), "display", "none");	
				
				// Approved, Approved with Change.
				
				//Drug Coverage
				dojo.style(dojo.byId('rxChangeRespDrugCoveragePADiv'), "display", "block");
				
				if (data.rxChangeDrugCoverageStatusCode != null){
				     dojo.byId("rxChgRespDrugCoverageStatus").innerHTML = data.rxChangeDrugCoverageStatusCode;
				}
				
				// PA and PA status
				if (data.rxChangeResponsePriorAuthorization != null){
				     dojo.byId("rxChgRespPriorAuthorization").innerHTML = data.rxChangeResponsePriorAuthorization;
				}
				
				if (data.rxChangeResponsePriorAuthorizationStatus != null){
				     dojo.byId("rxChgRespPriorAuthorizationStatus").innerHTML = data.rxChangeResponsePriorAuthorizationStatus;
				}
			}
			 
		}
		else{
			
			dojo.style(dojo.byId('rxChangeRespVadlidatedDiv'), "display", "none"); 
		}
		
		if (data.messageType.toUpperCase() == 'RXFILL'){
			if (data.rxFillStatus != null){
				dojo.byId("rxFillStatus").innerHTML = data.rxFillStatus;
				}
			if (data.rxFillRefNum != null){
				dojo.byId("rxFillRefNum").innerHTML = data.rxFillRefNum;
			}
			if (data.rxFillNote != null){
				dojo.byId("rxFillNote").innerHTML = data.rxFillNote;
			}
			if (data.rxFillReasonCd != null){
				dojo.byId("rxFillReasonCd").innerHTML = data.rxFillReasonCd;
			}
			dojo.style(dojo.byId('rxFill'), "display", "block");
		} else{
			dojo.style(dojo.byId('rxFill'), "display", "none");	
		}
			
		}
      },
      error: function(error){
        dojo.byId("queryStatus").innerHTML = "An unexpected exception occurred when retrieving message. Please contact your system administrator.";
        toggleTrackDivs("false");
      }
    }
    //hide related message info text before loading message displays.
    dojo.style(dojo.byId('relatedMessagesParentInfo'), "display", "none");
    
    dojo.byId("queryStatus").innerHTML = "Loading Message...";
    // Call the asynchronous xhrPost
    var deferred = dojo.xhrPost(xhrArgs);
}




function toggleTrackDivs(showIt){
  console.log("toggleTrackDivs");
  if( showIt == "true"){
	  dojo.style(dojo.byId('result1'), "display", "block");
	  dojo.style(dojo.byId('messageList'), "display", "none");
	  dojo.style(dojo.byId('messageList'), "height", "0px");
	  dojo.style(dojo.byId('showButtonDiv'), "display", "block");
	  dojo.style(dojo.byId('searchCriteriaForm'), "display", "none");
	  
	  var recNumber = dojo.byId("trackRecNumber");		
	  var recNumberTitle = dojo.byId("trackRecNumberTitle");
	  if(recNumberTitle!=null){				 
			 
			 dojo.byId("trackRecNumberTitle").style.display="none";	
			 
			 dojo.style(dojo.byId('messageList'), "display", "none");
       }
		
		 if(recNumber!=null){				 
			 
			 dojo.byId("trackRecNumber").style.display="none";			
         }
	   
  } else {
      dojo.style(dojo.byId('result1'), "display", "none");
      dojo.style(dojo.byId('messageList'), "display", "block");
      dojo.style(dojo.byId('messageList'), "height", "290px");
      dojo.style(dojo.byId('showButtonDiv'), "display", "none");
      dojo.style(dojo.byId('searchCriteriaForm'), "display", "block"); 
      
      // hide related message grid.      
      dojo.style(dojo.byId('relatedMessagesList'), "display", "none");
      dojo.byId("trackRelatedMessagesRecNumberTitle").style.display="none";	
      dojo.byId("trackRelatedMessagesRecNumber").style.display="none";	
      dojo.style(dojo.byId('relatedMessagesParentInfo'), "display", "none");
            
      var recNumber = dojo.byId("trackRecNumber");		
	  var recNumberTitle = dojo.byId("trackRecNumberTitle");
	  
	  if(recNumberTitle!=null){				 
			 
			 dojo.byId("trackRecNumberTitle").style.display="block";				
       }
		
		 if(recNumber!=null){				 
			 
			 dojo.byId("trackRecNumber").style.display="block";			
        }
  }
}

function setTrackAuditYesterdaysDefaultDate() {
	
	console.log("setTrackAuditYesterdaysDefaultDate");
	var startDate = dijit.byId("dateFrom");
	
	var twoDaysOld = new Date(); 
	  
	twoDaysOld.setDate(twoDaysOld.getDate() - 1);	
	
	if(startDate!=null){
		
		startDate.set("value", twoDaysOld);
	}
	
}


function showRelatedMessages(){
	 
	      console.log("showRelatedMessages");
	      dojo.style(dojo.byId('result1'), "display", "none");
	      dojo.style(dojo.byId('relatedMessagesList'), "display", "none");

          console.log("showRelatedMessages");
	      getTrackRelatedMessagesGrid();
	      
	      dojo.style(dojo.byId('relatedMessagesList'), "display", "block");
	      dojo.style(dojo.byId('relatedMessagesList'), "height", "290px");
	      
	      dojo.style(dojo.byId('trackRelatedMessagesRecNumberTitle'), "display", "none");
	      dojo.style(dojo.byId('trackRelatedMessagesRecNumber'), "display", "none");
	      
	      dojo.style(dojo.byId('relatedMessagesParentInfo'), "display", "none");
	  
}

function validateDates(startDateVal, endDateVal) {
    
	console.log("validateDates");
	var compareValue = 0;
	
	// earliest date is June 1 2017 When Inbound eRx rolled out.
	var earlyStartDate = new Date(); 
	earlyStartDate.setFullYear(2017);
	earlyStartDate.setMonth(5); // 0 is January, 5 is June
	earlyStartDate.setDate(1);
	earlyStartDate.setHours(0,0,0,0);// set to midnight.
	compareValue = dojo.date.compare(startDateVal,earlyStartDate);
	
	if(compareValue == -1){
		
		alert("From Date cannot be less than June 1st 2017. Please choose correct date.");
		
		return false;
		
	}
	
		
	compareValue =	dojo.date.compare(startDateVal,endDateVal);
	
	if(compareValue == 1){
	
		alert("To Date cannot be less than From Date. Please choose correct date.");
		
		return false;
		
	}
	else if(compareValue == 0 || compareValue == -1){
		// 0 means both dates are equal -1 means To date is great than From date which is correct.
		
		return true;
	}
	
	
	
}

