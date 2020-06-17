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

function buildTrackGridDataSource(dataSourceURL, query) {
	try {
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
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
    var inboundOutboundBox2 = dijit.byId("inboundOutbound");
	
	inboundOutbound = inboundOutboundBox2.get("value");

	var relatedMsg = null;
	
	return "<a aria-label=\"eRx Reference Number "+ entry +"\" href=\"#\"  onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}


function createRelatedMsgLinkRefNum(entry,index) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
	var inboundOutbound = "Unknown";
	var relatedMsg = true;
	
	return "<a aria-label=\"Relates to Message ID "+ entry +"\" href=\"#\"  onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}


function createLinkRefNumRelated(entry, index) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
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
	
	return "<a aria-label=\"eRx Reference Number "+ entry +"\" href=\"#\"  onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}



function buildTrackGridLayout(servlet, target) {
	var layout = new Array();
	
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
	obj["name"] = "Message Id";
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
		
		var recNumber = dojo.byId("trackRecNumber");
		
		var recNumberTitle = dojo.byId("trackRecNumberTitle");
		
		var gridData =  new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		if(recNumberTitle!=null){				 
			 
			 dojo.byId("trackRecNumberTitle").style.display="block";
				
       }
		
		 if(recNumber!=null){				 
			 
			 dojo.byId("trackRecNumber").style.display="block";
				
			 dojo.byId("trackRecNumber").innerHTML= responseData.items.length;
       }

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
					
					sortedColumn.setAttribute("aria-label", sortedInfo);
					
					//console.dir(grid.getSortProps());
			}
				
				dojo.stopEvent(e);
			});
			
			
			// now show number of records.
			
			// hide the inbound_ncpdp_msg_id
			//grid.layout.setColumnVisibility(0, false);
			
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
	
		
    var dataSourceURL = "/inbound/inb-erx/track/getMessages?json=" + dojo.toJson(formObject);
	
	try {
		 
		dojo.xhrGet({
	        url: dataSourceURL,
	        handleAs: "json", 
	        load: function(data, ioArgs) {
	        	
	        	trackDataGridInit("inb-erx","messageList",  data);	           
	        },
	        error: function(error) {
	            console.log("loading of track audit data failed. Exception...", error);
	        }
	    });		
		
	} catch (err) {
		alert(err.message);
	}
	
	
}


function getTrackAuditListCSV() {
	var formId = "searchCriteriaForm";
	var formObject = dojo.formToObject(formId);
	
	var getCSVUrl ="/inbound/inb-erx/track/getTrackAuditListCSV?json=" + dojo.toJson(formObject);
	
	location.href= getCSVUrl;
	
}


function trackRelatedMessagesDataGridInit(servlet, parentContainer, responseData) {
	try {
		
		var relatedMsgRecNumber = dojo.byId("trackRelatedMessagesRecNumber");
		
		var relatedMsgRecNumberTitle = dojo.byId("trackRelatedMessagesRecNumberTitle");
		
		var gridData =  new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
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
		
	var formObject = dojo.formToObject(formId);
	
	var messageId = dojo.byId("trackMsgIdHidden").value;
		
    var dataSourceURL = "/inbound/inb-erx/track/getRelatedMessages?messageId=" + messageId;
	
	try {
		 
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
