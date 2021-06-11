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
		
	return "<a aria-label=\"eRx Reference Number "+ entry +"\" href=\"#\" onkeyup=gotoMessageDetails(this,\"" + entry+ "\"); id=\""+entry+"\" onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}

function gotoMessageDetails(evt, elementId) {
	
	var elementEventKey = evt.keyCode || evt.which;
	
	// only trigger on enter key.
	if(elementEventKey ==13)
	{	
	  document.getElementById(elementId).click();
	}
}



function createRelatedMsgLinkRefNum(entry, inbOutVal) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
	var inboundOutbound = "Unknown";
	
	if (typeof inbOutVal != 'undefined'  && inbOutVal!=null && inbOutVal.length>1){
		
		inboundOutbound = inbOutVal;
	}
	else
	{
    var inboundOutboundBox2 = dijit.byId("inboundOutbound");
	
	inboundOutbound = inboundOutboundBox2.get("value");
	}

	
	var relatedMsg = true;

	
	return "<a aria-label=\"Relates to Message ID "+ entry +"\" href=\"#\"  onkeyup=gotoRelatedMessageDetails(event,\"" + entry+ "\"); id=\""+entry+"\" onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}


function gotoRelatedMessageDetails(evt, elementId) {
	
	var elementEventKey = evt.keyCode || evt.which;	
	
	// only trigger on enter key.
	if(elementEventKey ==13)
	{	
	  document.getElementById(elementId).click();
	}	
	
}

function createLinkRefNumRelated(entry, inbOutVal) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
	var relatedMessageGridId = 'relatedMessagesListGrid';
	var relatedMessageGrid = dijit.byId(relatedMessageGridId);
	
	var inboundOutbound = "Unknown";
	
	if (typeof inbOutVal != 'undefined'  && inbOutVal!=null && inbOutVal.length>1){
		
		inboundOutbound = inbOutVal;
	}
	else
	{
		
    var inboundOutboundBox2 = dijit.byId("inboundOutbound");
	
	inboundOutbound = inboundOutboundBox2.get("value");
	}
	
	var relatedMsg = null;
	
	return "<a aria-label=\"eRx Reference Number "+ entry +"\" href=\"#\"  onkeyup=gotoRelatedMessages(this,\"" + entry+ "\"); id=\""+entry+"\" onclick=\"getMessage('" + entry + "', '" + inboundOutbound+ "', '"+ relatedMsg + "')\">" + entry	+ "</a>";
}


function gotoRelatedMessages(element, elementId) {
	
	document.getElementById(elementId).click();
}


function buildTrackGridLayout(servlet, target) {
	var layout = new Array();
	
	console.log("buildTrackGridLayout");
	
	obj = new Object();
	obj["field"] = 'receivedDate';
	obj["name"] = "Received Date";
	obj["width"] = '80px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);	
	
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
	obj["field"] = 'erx_type';
	obj["name"] = "eRx Type";
	obj["width"] = '80px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);	
	
	obj = new Object();
	obj["field"] = 'messageType';
	obj["name"] = 'Message Type';
	obj["width"] = '115px';
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
	
	var obj = new Object();
	obj["field"] = 'schedule';
	obj["name"] = 'Schedule';
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
	obj["field"] = 'digital_signature';
	obj["name"] = 'Prescriber DS';
	obj["width"] = "100px";
	//obj["noresize"] = 'true';
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
		
		// define variable here and assign below.
		var gridLayout = buildTrackGridLayout(servlet, parentContainer);
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		
		dojo.style(dojo.byId('messageList'), "display", "block");	 
		
		// If the DataGrid already exists, just clear any selected rows and
		// replace the store.
		
		
		
		if (grid != null) {
			if (grid.selection != null) {
				grid.selection.clear();
			}
			
			
			grid.setStore(gridData);
				
		} else {
			// DataGrid does not exist.			
			// create dummy grid so that item file store works.
			grid = new dojox.grid.DataGrid({
				id : gridId								
			});
			
						
			// hide the inbound_ncpdp_msg_id
			//grid.layout.setColumnVisibility(0, false);
			
		}
		
		grid.setStructure(gridLayout);
		grid.setStore(gridData);
			
		// generate the table.
		generateDivTable(gridLayout,gridData,parentContainer, false);		
		
	    // remove the grid widget
		dojo.destroy(grid);

			 
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
		
		var relatedMsgRecNumber = dojo.byId("trackRelatedMessagesRecNumber");
		
		var relatedMsgRecNumberTitle = dojo.byId("trackRelatedMessagesRecNumberTitle");
		
		var gridData =  new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		// define variable here and assign below.
		var  gridLayout = buildTrackGridLayout(servlet, parentContainer);
		
		// If the DataGrid already exists, just clear any selected rows and
		// replace the store.
		if (grid != null) {
			if (grid.selection != null) {
				grid.selection.clear();
			}			
			grid.setStore(gridData);
				
		} else {
			// DataGrid does not exist.
			
				// create dummy grid so that item file store works.
			grid = new dojox.grid.DataGrid({
				id : gridId								
			});
			
						
			// hide the inbound_ncpdp_msg_id
			//grid.layout.setColumnVisibility(0, false);
			
		}
		grid.setStructure(gridLayout);
		grid.setStore(gridData);	
		// generate the table.
		generateDivTable(gridLayout,gridData,parentContainer,true);	

        // remove the grid widget
		dojo.destroy(grid);		
		
		 
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

//sorting functions.

var getCellValue = function(tr, idx)
{
		
	return tr.children[idx].innerText || tr.children[idx].textContent; 

}

var comparer = function(idx, asc) { 
	
	//console.log("asc:"+asc);
	return function(a, b) { return function(v1, v2) {
		
        return v1 !== '' && v2 !== '' && !isNaN(v1) && !isNaN(v2) ? v1 - v2 : v1.toString().localeCompare(v2);
        
    }(getCellValue(asc ? a : b, idx), getCellValue(asc ? b : a, idx));
}};



//div table generation. This function is different from other generateDivTable functions as it has related messages data.
function generateDivTable(layout, gridData, dataGridDivId, relatedMessagesData) {

	    // clear the parent div first.
        dojo.byId(dataGridDivId).innerHTML ="";

		var rowCounter = 1; 
		var recordCounter = 0;
		
		var elementWidthArray = [];
		
		var elementFormatterArray = [];
		
		//variable for aria label
		var divTableStart = "<div class=\"generatedDivTable\" id=\"generatedDivTableID\" tabindex=\"0\" role=\"table\" aria-label=\"Pharmacies\ Table\" aria-describedby=\"divTableInfo\">";
		var divTableEnd = "</div>" ;
		var divTableBodyStart ="<div class=\"generatedDivTableBody\" role=\"row\">";
		var divTableBodyEnd ="</div>" ;
		var divTableRowStart ="<div id=\"generatedDivTableHeaderRowID\" class=\"generatedDivTableRow generatedDivTableHeaderRow\" role=\"row\">";
		var divTableRowEnd ="</div>" ;
		var divTableRowHeaderStart ="<div title= \"Column can be sorted in ascending or descending order by mouse click or enter key\" class=\"generatedDivTableHeaderCell\" tabindex=\"0\" role=\"columnheader\"";	
		var divTableRowHeaderEnd = "</div>" ;
		var divTableResultRowStart ="<div class=\"generatedDivTableRow\" role=\"row\" ";			
		var divTableResultRowEnd = "</div>" ;		
		var divTableRowCellStart= "<div class=\"generatedDivTableCell\" tabindex=\"0\" role=\"cell\"";
		var divTableRowCellEnd="</div>" ;
		var divTableNoResultRowStart ="<div class=\"generatedDivTableNoRecordRow\" role=\"row\" ";			
		var divTableNoResultRowEnd = "</div>" ;			
		var generatedDivTableNoRecordsCellStart= "<div id=\"generatedDivTableNoRecordsCellID\" class=\"generatedDivTableNoRecordsCell\"  tabindex=\"0\" role=\"cell\"";
		var generatedDivTableNoRecordsCellEnd="</div>" ;
		
		var divTable;
		
		divTable = divTableStart.concat(divTableBodyStart);
		divTable = divTable.concat(divTableRowStart);
		
		var layoutObj;
		var columnNameString ="";
		var rowHeaderString ="";
		var isFormatter = false;
		
		
		for (var key in layout){
			
			
			
			layoutObj = layout[key];
					
			for (var nestedKey in layoutObj){
				
				
				
				if(nestedKey =="name")
				{
										
					columnNameString = layoutObj[nestedKey];	

                 isFormatter = false;					
					
				}
				else if(nestedKey =="width")	{
					
					elementWidthArray.push(layoutObj[nestedKey]);					
					
					rowHeaderString = divTableRowHeaderStart + "style=\"width:" + " " + layoutObj[nestedKey] + ";\">";					
					
					divTable = divTable.concat(rowHeaderString);
					
					divTable = divTable.concat(columnNameString);
					
					divTable = divTable.concat(divTableRowHeaderEnd);
					
					isFormatter = false;
				}
				 else if(nestedKey =="formatter")	{
					
					elementFormatterArray.push(layoutObj[nestedKey]);	

                 isFormatter = true; 					
					
				}
				
			}

             if(isFormatter == false)
				{
					// no formatter, add empty string.
					elementFormatterArray.push('');					
				}
            		
			
		}

		divTable = divTable.concat(divTableRowEnd);
		
		
		var storeArray = gridData._arrayOfAllItems; 
		var tempStringArray;
		var rowCounterString ="";
		var rowCellString ="";
		var rowCellFormatterElement ="";
		
		var rowCellValue;
		var tempHyperlink="";
			
		for(var arrayElement in storeArray){			
			
			
			var arrayItem  = storeArray[arrayElement];
			
			for (var k in arrayItem)
			{
				if((arrayItem[k]!='') && (k=='stringArray'))
				{
			 	
					 tempStringArray = arrayItem[k];
					 
					 rowCounterString = divTableResultRowStart + "aria-describedby=\"Row" +" " + rowCounter+"\">";
					 
					 divTable = divTable.concat(rowCounterString);
					 
					  
				
	              for (var s in tempStringArray)
				     {
						
						 rowCellString = divTableRowCellStart + "style=\"width:" + " " + elementWidthArray[s] + ";\">";
						 
						 divTable = divTable.concat(rowCellString);
						 
						 rowCellValue = tempStringArray[s];					
						 
						 if(typeof elementFormatterArray[s] ==='function')
						 {
						   rowCellFormatterElement = elementFormatterArray[s];		
						   
						   // only for related messages
						   if(relatedMessagesData == true)
						   {
								 if(tempStringArray.indexOf("OB_MSG")!= -1)
								  {
									   // call the formatter function.
									   tempHyperlink = rowCellFormatterElement(rowCellValue, "Outbound");
								  }
								 else
								 {
									   // call the formatter function.
									   tempHyperlink = rowCellFormatterElement(rowCellValue, "Inbound");
								 }
							}
						   else
							{
							   // call the formatter function.
							   tempHyperlink = rowCellFormatterElement(rowCellValue);
							}
						   
						  					   
						   
						   divTable = divTable.concat(tempHyperlink);
						 }
	                  else
	                  {	
	                	  if(rowCellValue == null || rowCellValue ==="null")
	                	  {
	                		  rowCellValue ="";
	                	  }	  
						  
	                	  divTable = divTable.concat(rowCellValue);
					  }
	                  					 
						 
									
						 divTable = divTable.concat(divTableRowCellEnd);
					 }
				
				 rowCounter++;
				 recordCounter++;
								
			 	 divTable = divTable.concat(divTableResultRowEnd);
				 
				 
				}		
				
			}	
			
			
			
		}	
		
		 // if no records found add a dummy row.
		 
		 if(recordCounter == 0)
	     {	
				rowCounterString = divTableNoResultRowStart + "aria-describedby=\"Row" +" " + rowCounter+"\">";
				 
				 divTable = divTable.concat(rowCounterString);
				 
				 rowCellString = generatedDivTableNoRecordsCellStart + "style=\"width:" + " " + "600px" + ";\">";
					 
				 divTable = divTable.concat(rowCellString);

                 divTable = divTable.concat("&nbsp;No record found.");	

                 divTable = divTable.concat(generatedDivTableNoRecordsCellEnd);				 
				 
				 divTable = divTable.concat(divTableNoResultRowEnd);
		 }
		 
		 
		divTable = divTable.concat(divTableBodyEnd);
		divTable = divTable.concat(divTableEnd);
		dojo.byId(dataGridDivId).innerHTML = divTable;
				
		
		// add click event
		Array.prototype.slice.call(document.querySelectorAll('.generatedDivTableHeaderCell')).forEach(function(th) { th.addEventListener('click', function() {
     var table = th.parentNode;
     
			
			// sorting function
			while(table.id.toUpperCase() != 'GENERATEDDIVTABLEID') table = table.parentNode;
			Array.prototype.slice.call(table.querySelectorAll('.generatedDivTableRow:nth-child(n+2)'))
				.sort(comparer(Array.prototype.slice.call(th.parentNode.children).indexOf(th), this.asc = !this.asc))
				.forEach(function(tr) { table.appendChild(tr) });
		   })
    });
	   
	   // add keyup event and trigger on the enter.
	   Array.prototype.slice.call(document.querySelectorAll('.generatedDivTableHeaderCell')).forEach(function(th) { th.addEventListener('keyup', function(evt) {
     
		var columnEventKey = evt.keyCode || evt.which;	
		// Trigger on enter key only
		if(columnEventKey ==13)
		{	
	       var table = th.parentNode;
     
			
			// sorting function
			while(table.id.toUpperCase() != 'GENERATEDDIVTABLEID') table = table.parentNode;
			Array.prototype.slice.call(table.querySelectorAll('.generatedDivTableRow:nth-child(n+2)'))
				.sort(comparer(Array.prototype.slice.call(th.parentNode.children).indexOf(th), this.asc = !this.asc))
				.forEach(function(tr) { table.appendChild(tr) });
		 
		}		
		   })
    });
	
		
}