dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojox.grid.enhanced.plugins.IndirectSelection");
dojo.require("dojo.dom-construct")


function buildGridDataSource(dataSourceURL, query) {
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




function buildSummaryReportLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "31px";
	obj["noresize"] = 'true';
	layout.push(obj);

	var obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "59px";
	obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "48px";
	obj["noresize"] = 'true';	
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "135px";
	obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyAddress';
	obj["name"] = 'Address';
	obj["width"] = '232px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxCnt';
	obj["name"] = "#New Rx";
	obj["width"] = '55.79px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxPharmDisabledAtHub';
	obj["name"] = "#Pharmacy Disabled";
	obj["width"] = '68.59px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxRejectedAtHub';
	obj["name"] = "#Rejected at Hub";
	obj["width"] = '64.39px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxPassAutoChk';
	obj["name"] = "#Passed Autocheck";
	obj["width"] = '64px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxFailAutoChk';
	obj["name"] = "#Failed Autocheck";
	obj["width"] = '64px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxRejectedByPharmacist';
	obj["name"] = "#Rejected by Pharmacist";
	obj["width"] = '68px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxFilled';
	obj["name"] = "#Rx Filled";
	obj["width"] = '35px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxInProcess';
	obj["name"] = "#Rx In Process";
	obj["width"] = '53.5px';
	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);

	return layout;
}

function buildSummaryReportTotalsGrid(parentContainer) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid');
	var totals = {};	
	var sumTable =  "";
	
	//totals ["pharmacyVaStationId"] = 0;
	//totals ["pharmacyNcpdpId"] = 0;
	//totals ["pharmacyDivisionName"] = 0;
	//totals ["pharmacyAddress"] = 0;
	totals ["newRxCnt"] = 0;
	totals ["newRxPharmDisabledAtHub"] = 0;
	totals ["newRxRejectedAtHub"] = 0;
	totals ["newRxPassAutoChk"] = 0;
	totals ["newRxFailAutoChk"] = 0;
	totals ["newRxRejectedByPharmacist"] = 0;
	totals ["newRxFilled"] = 0;
	totals ["newRxInProcess"] = 0;
	
	totals.newRxCnt  = 0;
	totals.newRxPharmDisabledAtHub  = 0;
	totals.newRxRejectedAtHub  = 0;
	totals.newRxPassAutoChk  = 0;
	totals.newRxFailAutoChk  = 0;
	totals.newRxRejectedByPharmacist  = 0;
	totals.newRxFilled  = 0;
	totals.newRxInProcess  = 0;
	
	
	//TODO this fetch is calling the Rest Service again when we should be able to sum the data from the current store

	gridId.store.fetch({onComplete: function(item, request){
		
	if (item != null){
		for (var i = item.length; i--;) {
			for (var k in totals) {
				totals[k] += item[i][k];
	
			}
		}
	}
	
	
	
	//leverage layout of summaryReport
	var layout = buildSummaryReportLayout(null, null);
	

	sumTable = 
		"<table> " +
		"<tr>" +
		"<th style='width: 438px; text-align: right; padding-right: 50px;'>Totals >></th>" +
		"<th style='width: " + layout[5].width + "; text-align: left;'>" + totals.newRxCnt + "</th>" +
		"<th style='width: " + layout[6].width + "; text-align: left;'>" + totals.newRxPharmDisabledAtHub + "</th>" +
		"<th style='width: " + layout[7].width + "; text-align: left;'>" + totals.newRxRejectedAtHub + "</th>" +
		"<th style='width: " + layout[8].width + "; text-align: left;'>" + totals.newRxPassAutoChk + "</th>" +
		"<th style='width: " + layout[9].width + "; text-align: left;'>" + totals.newRxFailAutoChk + "</th>" +
		"<th style='width: " + layout[10].width + "; text-align: left;'>" + totals.newRxRejectedByPharmacist + "</th>" +
		"<th style='width: " + layout[11].width + "; text-align: left;'>" + totals.newRxFilled + "</th>" +
		"<th style='width: " + layout[12].width + "; text-align: left;'>" + totals.newRxInProcess + "</th>" + "</tr>"
	"</table>";
	
	dojo.byId(parentContainer).innerHTML = sumTable;
	
	// now update the record totals.
	
	    var summaryReportRecNumberTitle = dojo.byId("reportRecNumberTitle");
		
		var summaryReportRecNumber = dojo.byId("reportRecNumber");
		
		
		if(summaryReportRecNumberTitle!=null){				 
			 
			  summaryReportRecNumberTitle.style.display="block";				
         }
		
		 if(summaryReportRecNumber!=null){				 
		 	 
		    	summaryReportRecNumber.style.display="block";
				
			    summaryReportRecNumber.innerHTML= item.length;
           }
	
	}});
	


}

function summaryReportDataGridInit(servlet, parentContainer, dataSourceURL) {
	try {
		var gridData = buildGridDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
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
			var gridLayout = buildSummaryReportLayout(servlet, parentContainer);
			grid = new dojox.grid.DataGrid({
				id : gridId,
				showTitle : true,
				columnReordering : false,
				loadingMessage : "Query In Progress...",
				noDataMessage : "Your Query Returned No Results",
				onFetchError : gridFetchError,
				selectionMode : 'single',
				selectable : false,
				showFooter: false,
				sort : false,
				onKeyEvent : onKeyEvent
			}, document.createElement('div'));
			dojo.byId(parentContainer).appendChild(grid.domNode);
			grid.setStore(gridData);
			
			grid.setStructure(gridLayout);
			
			grid.canSort = function(){return false};  //turn off sorting for now
			
			grid.startup();
			
		}
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};


