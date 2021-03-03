dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojo.dom-construct");
dojo.require("dojo.hash");
dojo.require("dijit.registry");
dojo.require("dojo.data.ItemFileWriteStore");
dojo.require("dojox.grid.cells.dijit");
dojo.require("dojox.grid.enhanced.plugins.NestedSorting");
dojo.require("dojo._base.event");
dojo.require("dojo.keys");
dojo.require("dojo.query");
dojo.require("dijit.Dialog");
dojo.require("dojo.Deferred");
dojo.require("dojo.parser");

var csvLoadingDialog;




function buildTrackGridDataSource(dataSourceURL, query) {
	try {
		console.log("buildTrackGridDataSource");
		var dataSource = new dojox.data.JsonQueryRestStore({
			target : dataSourceURL,
			idAttribute : "key"
		});		
		return dataSource;
	} catch (err) {
		alert(err.message);
	}
}

function onKeyEvent(event) {
	return false;
}



function createLinkRefNum(entry) {
	if (entry == null || entry == "null" || entry == "") 
		return "";
	
	console.log("createLinkRefNum");
	
    var inboundOutboundBox2 = dijit.byId("inboundOutbound");
	
	inboundOutbound = inboundOutboundBox2.get("value");

	var relatedMsg = null; 
		
	return "<a aria-label=\"eRx Reference Number "+ entry +"\" href=\"#\" onkeyup=gotoMessageDetails(this,\"" + entry+ "\"); id=\""+entry+"\" onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}

function gotoMessageDetails(element, elementId) {
	
	console.log("gotoMessageDetails");
	document.getElementById(elementId).click();
}



function createRelatedMsgLinkRefNum(entry,index) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
	console.log("createRelatedMsgLinkRefNum");
	var inboundOutbound = "Unknown";
	var relatedMsg = true;

	
	return "<a aria-label=\"Relates to Message ID "+ entry +"\" href=\"#\"  onkeyup=gotoRelatedMessageDetails(this,\"" + entry+ "\"); id=\""+entry+"\" onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}


function gotoRelatedMessageDetails(element, elementId) {
	
	console.log("gotoRelatedMessageDetails");
	document.getElementById(elementId).click();
}

function createLinkRefNumRelated(entry, index) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
	console.log("createLinkRefNumRelated");
	
	var relatedMessageGridId = 'relatedMessagesListGrid';
	var relatedMessageGrid = dijit.byId(relatedMessageGridId);
	if (typeof relatedMessageGrid != 'undefined'){
		if (relatedMessageGrid.getItem(index).message_status.indexOf("OB_MSG")!== -1){
			inboundOutbound = 'Outbound';
		}else{
			inboundOutbound = 'Inbound';
		}	
	}
	else{
    var inboundOutboundBox2 = dijit.byId("inboundOutbound");
	
	inboundOutbound = inboundOutboundBox2.get("value");
	}
	var relatedMsg = null;
	
	return "<a aria-label=\"eRx Reference Number "+ entry +"\" href=\"#\"  onkeyup=gotoRelatedMessages(this,\"" + entry+ "\"); id=\""+entry+"\" onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}


function gotoRelatedMessages(element, elementId) {

    console.log("gotoRelatedMessages");
	document.getElementById(elementId).click();
}


function buildTrackGridLayout(servlet, target) {
	var layout = new Array();
	
	console.log("buildTrackGridLayout");
	
	obj = new Object();
	obj["field"] = 'inboundNcpdpMsgId';
	obj["name"] = "eRx Reference #";
	obj["width"] = '100px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	
	if (target == 'relatedMessagesList'){
	obj["formatter"] = createLinkRefNumRelated;
	}
	else{
	obj["formatter"] = createLinkRefNum;
	}
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'messageType';
	obj["name"] = 'Message Type';
	obj["width"] = '100px';
//	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'patientName';
	obj["name"] = 'Patient Name';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'patientDob';
	obj["name"] = 'Patient DOB';
	obj["width"] = "80px";	
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'patientSsn';
	obj["name"] = 'Patient SSN';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	
	var obj = new Object();
	obj["field"] = 'rxDrugPrescribed';
	obj["name"] = 'Drug Prescribed';
	obj["width"] = "120px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'rxMessageId';
	//obj["fields"] = ["inboundNcpdpMsgId", "rxMessageId"];
	obj["name"] = "Message ID";
	obj["width"] = '159px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	
	var obj = new Object();
	obj["field"] = 'prescriberName';
	obj["name"] = 'Prescriber Name';
	obj["width"] = "250px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'prescriberNpi';
	obj["name"] = 'Prescriber NPI';
	obj["width"] = "85px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'prescriberDEA';
	obj["name"] = 'Prescriber DEA';
	obj["width"] = "120px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "50px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'vaStationId';
	obj["name"] = 'Station ID';
	obj["width"] = "90px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	var obj = new Object();
	obj["field"] = 'pharmacyAddr1';
	obj["name"] = 'Address';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'relToMessageid';
	obj["name"] = "Relates to Message ID";
	obj["width"] = '80px';
	//obj["noresize"] = 'false';
	obj["formatter"] = createRelatedMsgLinkRefNum;

	layout.push(obj);
	

	obj = new Object();
	obj["field"] = 'receivedDate';
	obj["name"] = "Received Date";
	obj["width"] = '80px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'patient_chk_status';
	obj["name"] = "Patient AutoCheck Status";
	obj["width"] = '100px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'provider_chk_status';
	obj["name"] = "Provider AutoCheck Status";
	obj["width"] = '100px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'drug_chk_status';
	obj["name"] = "Drug AutoCheck Status";
	obj["width"] = '100px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	//Note - if the name of this field is changed, then update it in getMessage function as well, otherwise it will break.
	obj = new Object();
	obj["field"] = 'message_status';
	obj["name"] = "Message Status";
	obj["width"] = '100px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	
	return layout;
}

function trackDataGridInit(servlet, parentContainer, responseData) {
	try {
		
		// it should use  ItemFileWriteStore 
		
		console.log("trackDataGridInit");
		
		var recNumber = dojo.byId("trackRecNumber");
		
		var recNumberTitle = dojo.byId("trackRecNumberTitle");
		
		var gridData =  new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		
		dojo.style(dojo.byId('messageList'), "display", "block");
	    
		dojo.style(dojo.byId('messageList'), "height", "290px");
		 
		
		// If the DataGrid already exists, just clear any selected rows and
		// replace the store.
		if (grid != null) {
			if (grid.selection != null) {
				grid.selection.clear();
			}
			grid.setStore(gridData);
				
		} else {
			// DataGrid does not exist.
			var gridLayout = buildTrackGridLayout(servlet, parentContainer);
			grid = new dojox.grid.EnhancedGrid({
				id : gridId,
				showTitle : true,
				columnReordering : false,
				loadingMessage : "Query In Progress...",
				noDataMessage : "Your Query Returned No Results",
				onFetchError : gridFetchError,
				selectable : true,
				selectionMode : 'single',	
				canSort : function(index) {
					return true;
				},
				plugins : {nestedSorting: false}				
			}, document.createElement('div'));
			dojo.byId(parentContainer).appendChild(grid.domNode);
			
			grid.setStore(gridData);
			
			grid.setStructure(gridLayout);
			
			//grid.canSort = function(){return false};  //turn off sorting for now
			
			grid.startup();
			
			dojo.connect(grid, "onKeyDown", function(e) {
				
				switch(e.keyCode){
				case dojo.keys.ENTER:
				case dojo.keys.SPACE:
					

					
					var gridItem = grid.getItem(e.rowIndex);
					
					var cell = grid.getCell(e.cellIndex);
					
					var node = e.cellNode;
					
					// JAWS reads column with respect to their index numbers, since they start out with 0, so this is comment out for now.
					//var columnInfo = 'Column ' + (cell.index + 1) + ' ' + cell.name;
					
					var columnInfo = cell.name;
					
					var sortedColumnUp = dojo.query('.dojoxGridSortUp');
					
					var sortedColumnDown = dojo.query('.dojoxGridSortDown');
					
					var sortedInfo;
					
					
					if( sortedColumnUp !=undefined && sortedColumnUp.length>0) { 
						
						sortedInfo = columnInfo + ' is sorted in ascending order. ';
					}
					
					else if(sortedColumnDown !=undefined && sortedColumnDown.length>0){
						
						
						sortedInfo = columnInfo + ' is sorted in descending order. ';
						
					}
					
					var sortedColumn = dojo.query('.dojoxGridColCaption')[0];
					
					if(sortedColumn!=null){
					
						sortedColumn.setAttribute("aria-label", sortedInfo);
					}
					
					
					
					//console.dir(grid.getSortProps());
			}
				
				dojo.stopEvent(e);
			});
			
			
			
			 
			// hide the inbound_ncpdp_msg_id
			//grid.layout.setColumnVisibility(0, false);
			
		}
		
			
		
	     
		// now show number of records.
		
		if(recNumberTitle!=null){				 
			 
			 dojo.byId("trackRecNumberTitle").style.display="block";
				
       }
		
		 if(recNumber!=null){				 
			 
			 dojo.byId("trackRecNumber").style.display="block";
				
			 dojo.byId("trackRecNumber").innerHTML= responseData.items.length;
       }
		
	 
		 
	} catch (err) {
		var txt = "An error occurred while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

}


function getTrackGrid() {
	var formId = "searchCriteriaForm";
		
	var formObject = dojo.formToObject(formId);
	
	console.log("getTrackGrid");
	
		
   // var dataSourceURL = "/inbound/inb-erx/track/getMessages?json=" + dojo.toJson(formObject);
    
    //dataSourceURL = encodeURIComponent(dataSourceURL);
	
	 var dataSourceURL = "/inbound/inb-erx/track/getMessages";
	 
	 var token = document.querySelector("meta[name='_csrf']").getAttribute("content");
	 var header = document.querySelector("meta[name='_csrf_header']").getAttribute("content");
	 var xhrHeader = '{"' + header + '" : "' + token + '"}';
	 var xhrHeaderObj = JSON.parse(xhrHeader);
	 
    //loading dialog
    
    var loadingDialog = new dijit.Dialog({	            
        title: "Search Status",
		content: "Search in progress, please wait...",
        style: "width: 230px;height:60px;font-size: 14px;text-align: left;",
        draggable: false,
        closable: false,
        onHide: function(){
        	loadingDialog.destroy()
        }
        
    });
	
	try {
		
		
		loadingDialog.show();
		
		// IAM request filtering issue fix -  Change form get to post method
		var deferred =  dojo.xhrPost({
	        url: dataSourceURL,
	        handleAs: "json", 
	        postData : "json=" + dojo.toJson(formObject),
	        headers: xhrHeaderObj,
	        load: function(data, ioArgs) {
	        	
	        	trackDataGridInit("inb-erx","messageList",  data);	           
	        },
	        error: function(error) {
	            console.log("loading of track audit data failed. Exception...", error);	            
	            
	        }
	    });		
		
		deferred.then(function() {
			
			setTimeout(function(){ loadingDialog.hide(); }, 1000);
			
			//loadingDialog.hide();
		});
		
	} catch (err) {
		alert(err.message);
		//hide on error
		loadingDialog.hide();
	}
	
	
}


function getTrackAuditListCSV() {
	
      console.log("getTrackAuditListCSV");
	  
	  csvLoadingDialog = new dijit.Dialog({	            
	        title: "Export Status",
			content: "Export in progress, please wait...",
	        style: "width: 230px;height:60px;font-size: 14px;text-align: left;",
	        draggable: false,
	        closable: false,
	        onHide: function(){
	        	csvLoadingDialog.destroy()
	        }
	        
	    });
	 
	 console.log("Matt was Here and this is a Test");
	var pharmVisnSelect = dojo.byId("csvRequestParam");
	
	setTimeout(function(){ csvLoadingDialog.hide(); }, 5000);
	
	var formId = "searchCriteriaForm";
	
	var formObject = dojo.formToObject(formId);
	
	var getCSVUrl ="/inbound/inb-erx/track/getTrackAuditListCSV?json=" + dojo.toJson(formObject);
	
	location.href= getCSVUrl;
	
	
	
	csvLoadingDialog.show();
		
}




function trackRelatedMessagesDataGridInit(servlet, parentContainer, responseData) {
	try {
	
	    console.log("trackRelatedMessagesDataGridInit");
		
		var relatedMsgRecNumber = dojo.byId("trackRelatedMessagesRecNumber");
		
		var relatedMsgRecNumberTitle = dojo.byId("trackRelatedMessagesRecNumberTitle");
		
		var gridData =  new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		console.log("Matt was Here and this is a Test");
		
		// If the DataGrid already exists, just clear any selected rows and
		// replace the store.
		if (grid != null) {
			console.log("Grid Exists");
			if (grid.selection != null) {
				grid.selection.clear();
			}
			grid.setStore(gridData);
				
		} else {
			// DataGrid does not exist.
			console.log("Grid Does Not Exist, Making Grid");
			var gridLayout = buildTrackGridLayout(servlet, parentContainer);
			grid = new dojox.grid.DataGrid({
				id : gridId,
				showTitle : true,
				columnReordering : false,
				loadingMessage : "Query In Progress...",
				noDataMessage : "Your Query Returned No Results",
				onFetchError : gridFetchError,
				selectionMode : 'single',		
				//autoHeight: true,
				onKeyEvent : onKeyEvent
			}, document.createElement('div'));
			dojo.byId(parentContainer).appendChild(grid.domNode);
			
			grid.setStore(gridData);
			
			grid.setStructure(gridLayout);
			
			//grid.canSort = function(){return false};  //turn off sorting for now
			
			grid.startup();
			
			// now show number of records.
			
			// hide the inbound_ncpdp_msg_id
			//grid.layout.setColumnVisibility(0, false);
			
		}
	} catch (err) {
		var txt = "An error occurred while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}
		
		if(relatedMsgRecNumberTitle!=null){				 
			 
			 dojo.byId("trackRelatedMessagesRecNumberTitle").style.display="block";
				
       }
		
		 if(relatedMsgRecNumber!=null){				 
			 
			 dojo.byId("trackRelatedMessagesRecNumber").style.display="block";
				
			 dojo.byId("trackRelatedMessagesRecNumber").innerHTML= responseData.items.length;
       }

	  var parentMsgInfo = dojo.byId("relatedMessagesParentInfo");
	  
	  if(parentMsgInfo!=null){				 
			 
			 dojo.byId("relatedMessagesParentInfo").style.display="block";
			 
			 
			 //var parentReferenceNumber =  dojo.byId("trackMsgIdHidden").value;
			 
			 var parentHubRefNumber = dojo.byId("trackHubMsgIdHidden").value;
			 
			 var relatedMsg = null;
			 
			 var parentMessageStatus = dojo.byId("trackParentMsgStatusHidden").value;
			 
			 var inboundOutbound = "Inbound"; // set as default.
			 
			 if(parentMessageStatus.indexOf("OB_MSG")!== -1){
				 
				 inboundOutbound= "Outbound";
			 }
			 else{
				 
				 inboundOutbound= "Inbound";
			 }
			 
			 var parentHyperLink = "<a href=\"#\" onclick=\"getMessage('" + parentHubRefNumber + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + parentHubRefNumber	+ "</a>"
				
			 dojo.byId("relatedMessagesParentInfo").innerHTML= "Showing Related Messages for "+ dojo.byId("trackMsgTypeHidden").value +":  eRx Reference # - "+parentHyperLink;
      }
		  
		
}

function getTrackRelatedMessagesGrid() {
	var formId = "searchCriteriaForm";
	
	console.log("getTrackRelatedMessagesGrid");
		
	var formObject = dojo.formToObject(formId);
	
	var messageId = dojo.byId("trackMsgIdHidden").value;
		
    var dataSourceURL = "/inbound/inb-erx/track/getRelatedMessages?messageId=" + messageId;
	
	try {
		 console.log("getTrackRelatedMessagesGrid");
		 
		 
		dojo.xhrGet({
	        url: dataSourceURL,
	        handleAs: "json", 
	        load: function(data, ioArgs) {
	        	
	        	trackRelatedMessagesDataGridInit("inb-erx","relatedMessagesList",  data);	           
	        },
	        error: function(error) {
	            console.log("loading of track audit data failed. Exception...", error);
	        }
	    });		
		
	} catch (err) {
		alert(err.message);
	}
	
	
}
