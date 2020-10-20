dojo.require("dijit.form.Select");
dojo.require("dojo.parser");
dojo.require("dojo.dom-construct");
dojo.require("dojox.validate.us")


dojo.ready(function() {

	
	require(["dojo/on", "dojo/domReady!"], function(on) {
	    on(document, "keyup", function(event) {
	        if (event.keyCode == '13'){
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
	    });
	});

	require(["dijit/form/Button", "dojo/dom", "dojo/domReady!"], function(Button, dom){
	    var myButton = new Button({
	        label: "Search",
	        onClick: function(){
		    	        
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
	        	
	         //clearDetail();
	 		 var messageIdBox = dijit.byId("messageId2");
			 messageIdBox.set("value", "");
			 
			 var relatedMessageId2Box = dijit.byId("relatedMessageId2");
			 relatedMessageId2Box.set("value", "");

			 var pharmacyVaStationIdBox = dijit.byId("pharmacyVaStationId");
			 pharmacyVaStationIdBox.set("value", "");

			 var dateFromBox = dijit.byId("dateFrom");
			 dateFromBox.reset();

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

			 var prescribedDrug2Box = dijit.byId("prescribedDrug2");
			 prescribedDrug2Box.set("value", "");
			 
			 var inboundOutboundBox = dijit.byId("inboundOutbound");
			 inboundOutboundBox.set("value", "");
			 
			 var visnBox = dijit.byId("searchCriteriaFormSelect");
			 visnBox.reset();
			 visnBox.set("value", 'All');

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
			}, "trackauditvisnSelection");
		
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
		dojo.byId("patientAddr1").innerHTML = "&nbsp;";
		dojo.byId("patientAddr2").innerHTML = "&nbsp;";
		dojo.byId("patientDob").innerHTML = "";
		dojo.byId("patientGender").innerHTML = "&nbsp;";
		dojo.byId("patientPlanId").innerHTML = "&nbsp;";
        //Prescription
        dojo.byId("rxDrugPrescribed").innerHTML = "&nbsp;";
        dojo.byId("rxQuantity").innerHTML = "&nbsp;";
		dojo.byId("rxDaysSupply").innerHTML = "&nbsp;";
		dojo.byId("rxDateWritten").innerHTML = "&nbsp;";
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

		
		dojo.style(dojo.byId('trackReqRes'), "display", "none"); 
		//Request
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

}


function getMessage(id, inOut){
	
	// hide number of records
	
	 var recNumber = dojo.byId("trackRecNumber");
   
	 var recNumberTitle = dojo.byId("trackRecNumberTitle");
     
     if(recNumber!=null){
     	        	
     	 dojo.byId("trackRecNumber").style.display="none";
     }
     
     if(recNumberTitle!=null){
     	
     	 dojo.byId("trackRecNumberTitle").style.display="none";
     }
  

    var param1 = id;
    var param2 = inboundOutbound;
    var paramObj = {};
    paramObj.messageId = param1;
    paramObj.inboundOutbound = param2;
    var jsonStr = JSON.stringify(paramObj);
    var token = document.querySelector("meta[name='_csrf']").getAttribute("content");
    var header = document.querySelector("meta[name='_csrf_header']").getAttribute("content");

    var xhrHeader = '{"' + header + '" : "' + token + '"}';
    //console.log(xhrHeader);
    var xhrHeaderObj = JSON.parse(xhrHeader);
    //console.log(xhrHeaderObj);
    var  xhrArgs = {
      url: "getMessage",
      postData: "json=" + jsonStr,
      handleAs: "text",
      headers: xhrHeaderObj ,
      load: function(jsondata){
       var data = JSON.parse(jsondata);
        
        if (data.dataError != null){
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
    	
    	if (inboundOutbound1 == 'Inbound'){
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
		if (data.pharmacyAddr1 != null){
		dojo.byId("patientAddr1").innerHTML = data.patientAddr1};
		if (data.patientAddr2 != null && data.patientAddr2 != ",   " ){
		dojo.byId("patientAddr2").innerHTML = data.patientAddr2};
		if (data.patientDob != null){
		dojo.byId("patientDob").innerHTML = data.patientDob};
		if (data.patientGender != null){
		dojo.byId("patientGender").innerHTML = data.patientGender};
		if (data.planId != null){
		dojo.byId("patientPlanId").innerHTML = data.planId};
        //Prescription
        if (data.rxDrugPrescribed != null){
        dojo.byId("rxDrugPrescribed").innerHTML = data.rxDrugPrescribed};
        if (data.rxQuantity != null){
        dojo.byId("rxQuantity").innerHTML = data.rxQuantity};
        if (data.rxDaysSupply != null){
		dojo.byId("rxDaysSupply").innerHTML = data.rxDaysSupply};
		if (data.rxDateWritten != null){
		dojo.byId("rxDateWritten").innerHTML = data.rxDateWritten};
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
		if (data.relToMessageid != null){
		dojo.byId("rxRelToMessageId").innerHTML = data.relToMessageid};
		dojo.byId("rxMessageId2").innerHTML = data.rxMessageId;
		if (data.relToMessageid != null){
		dojo.byId("rxRelToMessageId2").innerHTML = data.relToMessageid};
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
		
		//display response/request if present
		if (data.messageType.toUpperCase() == 'REFILLRESPONSE'){
		dojo.style(dojo.byId('trackReqRes'), "display", "block"); 
		}
		//if Error or Verify don't show empty Patient or Prescription
		if (data.messageType.toUpperCase() == 'ERROR' || data.messageType.toUpperCase() == 'VERIFY' || data.messageType.toUpperCase() == 'STATUS'){
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
			
		}
      },
      error: function(error){
        dojo.byId("queryStatus").innerHTML = "An unexpected exception occurred when retrieving message. Please contact your system administrator.";
        toggleTrackDivs("false");
      }
    }
    dojo.byId("queryStatus").innerHTML = "Searching for Message...";
    // Call the asynchronous xhrPost
    var deferred = dojo.xhrPost(xhrArgs);
}








function toggleTrackDivs(showIt){
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
