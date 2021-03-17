dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojox.grid.enhanced.plugins.IndirectSelection");
dojo.require("dojo.dom-construct");
dojo.require("dojox.grid.Selection");
dojo.require("dojo.data.ItemFileWriteStore");


function buildGridDataSource(dataSourceURL, functionToCall, parentContainer) {

   try {
		 
		dojo.xhrGet({
	        url: dataSourceURL,
	        handleAs: "json", 
	        load: function(responseData, ioArgs) {	        	     		
                 
                 functionToCall(responseData, parentContainer);
				
	        },
	        error: function(error) {
	            console.log("loading of reports data failed. Exception...", error);
	        }
	    });		
		
		
		
		
	} catch (err) {
		alert(err.message);
	}
}



function onKeyEvent(event) {
	return false;
}


function numberFormat(entry) {
	if (entry == null || entry == "null" || entry == "") {
		return "0";
	}
		
	return entry.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
};

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
	//obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxCnt';
	obj["name"] = "#New Rx";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxPharmDisabledAtHub';
	obj["name"] = "#Pharmacy Disabled";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxRejectedAtHub';
	obj["name"] = "#Rejected at Hub";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxPassAutoChk';
	obj["name"] = "#Passed Autocheck";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxFailAutoChk';
	obj["name"] = "#Failed Autocheck";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxRejectedByPharmacist';
	obj["name"] = "#Rejected by Pharmacy";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxFilled';
	obj["name"] = "#Rx Filled";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxInProcess';
	obj["name"] = "#Accepted by Pharmacy";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	return layout;
}

function buildAutoCheckReportLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "32px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	var obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "65px";
	//obj["noresize"] = 'true';	
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "220px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxCnt';
	obj["name"] = "#New Rx";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxPassAutoChk';
	obj["name"] = "#Passed Autocheck";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxFailAutoChk';
	obj["name"] = "#Failed Autocheck";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxMviPatFound';
	obj["name"] = "#MVI Patient Found";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxMviPatNotFound';
	obj["name"] = "#MVI Patient Not Found";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxEneElgbEnrl';
	obj["name"] = "#E&E Enrolled/Eligible";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxEneNotElgbEnrl';
	obj["name"] = "#E&E Not Enrolled/Eligible";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxPatNotEnrlSite';
	obj["name"] = "#Patient Not Enrolled at Site";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxDrgMtchFnd';
	obj["name"] = "#Drug Match Found";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxDrgMtchNotFnd';
	obj["name"] = "#Drug Match Failed";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxPvdMtchFnd';
	obj["name"] = "#Provider Match Found";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxPvdMtchNotFnd';
	obj["name"] = "#Provider Match Failed";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	return layout;
}

function buildRejectReasonsReportLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "32px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	var obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "65px";
	//obj["noresize"] = 'true';	
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "220px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	//obj = new Object();
	//obj["field"] = 'pharmacyAddress';
	//obj["name"] = 'Address';
	//obj["width"] = '95px';
	//obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	//layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRx';
	obj["name"] = "#New Rx";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxInProcess';
	obj["name"] = "#Accepted by Pharmacy";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxRejectedByPharmacist';
	obj["name"] = "#Rejected by Pharmacy";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxPatientNotElig';
	obj["name"] = "#Patient Not Eligible";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxPatientNotFound';
	obj["name"] = "#Cannot Resolve Patient";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxProviderNotElig';
	obj["name"] = "#Provider Not Eligible";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxProviderNotFound';
	obj["name"] = "#Cannot Resolve Provider";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxNotEligRefills';
	obj["name"] = "#Not Eligible for Refills";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxNonFormulary';
	obj["name"] = "#Non Formulary";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxDuplicate';
	obj["name"] = "#Duplicate Rx";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxInvalidQty';
	obj["name"] = "#Invalid Qty";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxDupTheraClass';
	obj["name"] = "#Duplicate Therapy Class";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxCsNotAllowed';
	obj["name"] = "#CS Not Allowed";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxMultiErrCallPharm';
	obj["name"] = "#Contact Pharmacy (ERR01)";
	obj["width"] = '170px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxIncorrectPharm';
	obj["name"] = "#Incorrect Pharmacy";
	obj["width"] = '170px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxErrCallPharm';
	obj["name"] = "#Contact Pharmacy (ERR03)";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	return layout;
}


function buildErxSummaryReportLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "32px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	var obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "65px";
	//obj["noresize"] = 'true';	
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "220px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	//obj = new Object();
	//obj["field"] = 'pharmacyAddress';
	//obj["name"] = 'Address';
	//obj["width"] = '95px';
	//obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	//layout.push(obj);

	obj = new Object();
	obj["field"] = 'newRxCnt';
	obj["name"] = "#New Rx";
	obj["width"] = '156px';
//	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'refillRequest';
	obj["name"] = "#RxRenewal Request";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'refillResponse';
	obj["name"] = "#RxRenewal Response";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'rxChangeRequest';
	obj["name"] = "#RxChange Request";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'rxChangeResponse';
	obj["name"] = "#RxChange Response";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'cancelRx';
	obj["name"] = "#CancelRx Request";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'cancelRxResponse';
	obj["name"] = "#CancelRx Response";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'rxFill';
	obj["name"] = "#RxFill";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);

	return layout;
}


// note if this updated with column addition/removal please also update columns in resetSummaryReportTotalsGrid function, otherwise the display will be out of sync.
function buildSummaryReportTotalsGrid(parentContainer, gridData, recordsTotal) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid');
	var totals = {};	
	var sumTable =  "";
	

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
	
	
	var storeArray = gridData._arrayOfAllItems; 		
			
	for(var arrayElement in storeArray)
	{			
			
		var arrayItem  = storeArray[arrayElement];
					
		for (var s in arrayItem)
		{
			for (var k in totals) 
			{       
				 				  
			  if(k == s) 
			  {						   
			    totals[k] += parseInt(arrayItem[s]);  
			  }	
			}  

			  
		}	

	
	//leverage layout of summaryReport
	var layout = buildSummaryReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width)+ parseInt(layout[1].width) + parseInt(layout[2].width) + parseInt(layout[3].width) + parseInt(layout[4].width) + 46; //45px to account for padding differences
	var tableWidth = totColWidth + parseInt(layout[5].width)+ parseInt(layout[6].width) + parseInt(layout[7].width) + parseInt(layout[8].width) + parseInt(layout[9].width) + parseInt(layout[10].width) + parseInt(layout[11].width) + parseInt(layout[12].width);

	sumTable = 

		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + "; text-align: left;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + "; text-align: left;'>" + numberFormat(totals.newRxPharmDisabledAtHub) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + "; text-align: left;'>" + numberFormat(totals.newRxRejectedAtHub) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + "; text-align: left;'>" + numberFormat(totals.newRxPassAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + "; text-align: left;'>" + numberFormat(totals.newRxFailAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + "; text-align: left;'>" + numberFormat(totals.newRxRejectedByPharmacist) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + "; text-align: left;'>" + numberFormat(totals.newRxFilled) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + "; text-align: left;'>" + numberFormat(totals.newRxInProcess) + "</td>" + "</tr>"
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
				
			    summaryReportRecNumber.innerHTML= recordsTotal;
           }
	
    }	


}

function summaryReportDataGridInit(responseData, parentContainer) {
	try {
		
		var gridData = new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
		
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		var gridLayout = buildSummaryReportLayout(null, parentContainer);
		
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
			
						
			grid.setStore(gridData);			
			
			
			
		}	
		
	
			// generate the table.
			generateDivTable(gridLayout,gridData,parentContainer);			
			
			buildSummaryReportTotalsGrid("summaryReportTotals", gridData, responseData.items.length); 
			
			// remove the grid widget
			 dojo.destroy(grid);
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

}



//note if this updated with column addition/removal please also update columns in resetAutoCheckReportTotalsGrid function, otherwise the display will be out of sync.
function buildAutoCheckReportTotalsGrid(parentContainer, gridData, recordsTotal) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid2');
	var totals = {};	
	var sumTable =  "";
	

	totals ["newRxCnt"] = 0;
	totals ["newRxPassAutoChk"] = 0;
	totals ["newRxFailAutoChk"] = 0;
	totals ["newRxMviPatFound"] = 0;
	totals ["newRxMviPatNotFound"] = 0;
	totals ["newRxEneElgbEnrl"] = 0;
	totals ["newRxEneNotElgbEnrl"] = 0;
	totals ["newRxPatNotEnrlSite"] = 0;
	totals ["newRxDrgMtchFnd"] = 0;
	totals ["newRxDrgMtchNotFnd"] = 0;
	totals ["newRxPvdMtchFnd"] = 0;
	totals ["newRxPvdMtchNotFnd"] = 0;

		
	totals.newRxCnt  = 0;
	totals.newRxPassAutoChk  = 0;
	totals.newRxFailAutoChk  = 0;
	totals.newRxMviPatFound  = 0;
	totals.newRxMviPatNotFound  = 0;
	totals.newRxEneElgbEnrl  = 0;
	totals.newRxEneNotElgbEnrl  = 0;
	totals.newRxPatNotEnrlSite  = 0;
	totals.newRxDrgMtchFnd  = 0;
	totals.newRxDrgMtchNotFnd  = 0;
	totals.newRxPvdMtchFnd  = 0;
	totals.newRxPvdMtchNotFnd  = 0;	

	var storeArray = gridData._arrayOfAllItems; 		
	
	for(var arrayElement in storeArray)
	{			
			
		var arrayItem  = storeArray[arrayElement];
					
		for (var s in arrayItem)
		{
			for (var k in totals) 
			{       
				 				  
			  if(k == s) 
			  {						   
			    totals[k] += parseInt(arrayItem[s]);  
			  }	
			}  

			  
		}
		
	
		
	//leverage layout of summaryReport
	var layout = buildAutoCheckReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width)+ parseInt(layout[1].width) + parseInt(layout[2].width) + parseInt(layout[3].width) + 36; //36px to account for padding differences
	var tableWidth = totColWidth + parseInt(layout[4].width) + parseInt(layout[5].width)+ parseInt(layout[6].width) + parseInt(layout[7].width) + parseInt(layout[8].width) + parseInt(layout[9].width) + parseInt(layout[10].width) + parseInt(layout[11].width) + parseInt(layout[12].width) + parseInt(layout[13].width) + parseInt(layout[14].width) + parseInt(layout[15].width);


	sumTable = 
		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + "; text-align: left;'>" + numberFormat(totals.newRxPassAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + "; text-align: left;'>" + numberFormat(totals.newRxFailAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + "; text-align: left;'>" + numberFormat(totals.newRxMviPatFound) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + "; text-align: left;'>" + numberFormat(totals.newRxMviPatNotFound) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + "; text-align: left;'>" + numberFormat(totals.newRxEneElgbEnrl) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + "; text-align: left;'>" + numberFormat(totals.newRxEneNotElgbEnrl) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + "; text-align: left;'>" + numberFormat(totals.newRxPatNotEnrlSite) + "</td>"  +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + "; text-align: left;'>" + numberFormat(totals.newRxDrgMtchFnd) + "</td>"  +
		"<td class='summaryReportTotalsTd' style='width: " + layout[13].width + "; text-align: left;'>" + numberFormat(totals.newRxDrgMtchNotFnd) + "</td>"  +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[14].width + "; text-align: left;'>" + numberFormat(totals.newRxPvdMtchFnd) + "</td>"  +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[15].width + "; text-align: left;'>" + numberFormat(totals.newRxPvdMtchNotFnd) + "</td>" + "</tr>" +
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
				
			    summaryReportRecNumber.innerHTML= recordsTotal;
           }
	
		
  }


}

function autoCheckReportDataGridInit(responseData, parentContainer) {
	try {
		
		var gridData = new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
		
		var gridId = parentContainer + 'Grid2';
		
	
		var grid = dijit.byId(gridId);
		
		var gridLayout = buildAutoCheckReportLayout(null, parentContainer);

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
			
						
			grid.setStore(gridData);			
			
			
		}	
			// generate the table.
			generateDivTable(gridLayout,gridData,parentContainer);
			
			buildAutoCheckReportTotalsGrid("summaryReportTotals", gridData, responseData.items.lenth);		
			
			// remove the grid widget
			dojo.destroy(grid);
			 
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};




//RejectReasonsReport
//note if this updated with column addition/removal please also update columns in resetRejectReasonsReportTotalsGrid function, otherwise the display will be out of sync.
function buildRejectReasonsReportTotalsGrid(parentContainer, gridData, recordsTotal) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid3');
	var totals = {};	
	var sumTable =  "";
	
	totals ["newRx"] = 0;
	totals ["newRxInProcess"] = 0;
	totals ["newRxRejectedByPharmacist"] = 0;
	totals ["newRxPatientNotElig"] = 0;
	totals ["newRxPatientNotFound"] = 0;
	totals ["newRxProviderNotElig"] = 0;
	totals ["newRxProviderNotFound"] = 0;
	totals ["newRxNotEligRefills"] = 0;
	totals ["newRxNonFormulary"] = 0;
	totals ["newRxDuplicate"] = 0;
	totals ["newRxInvalidQty"] = 0;
	totals ["newRxDupTheraClass"] = 0;
	totals ["newRxCsNotAllowed"] = 0;
	totals ["newRxMultiErrCallPharm"] = 0;
	totals ["newRxIncorrectPharm"] = 0;
	totals ["newRxErrCallPharm"] = 0;
		
	totals.newRx  = 0;
	totals.newRxInProcess  = 0;
	totals.newRxRejectedByPharmacist  = 0;
	totals.newRxPatientNotElig  = 0;
	totals.newRxPatientNotFound  = 0;
	totals.newRxProviderNotElig  = 0;
	totals.newRxProviderNotFound  = 0;
	totals.newRxNotEligRefills = 0;
	totals.newRxNonFormulary  = 0;
	totals.newRxDuplicate  = 0;
	totals.newRxInvalidQty  = 0;
	totals.newRxDupTheraClass  = 0;
	totals.newRxCsNotAllowed  = 0;
	totals.newRxMultiErrCallPharm  = 0;
	totals.newRxIncorrectPharm  = 0;
	totals.newRxErrCallPharm  = 0;
	
	
	var storeArray = gridData._arrayOfAllItems; 		
	
	for(var arrayElement in storeArray)
	{			
			
		var arrayItem  = storeArray[arrayElement];
					
		for (var s in arrayItem)
		{
			for (var k in totals) 
			{       
				 				  
			  if(k == s) 
			  {						   
			    totals[k] += parseInt(arrayItem[s]);  
			  }	
			}  

			  
		}

	
	//leverage layout of rejectReasonsReport
	var layout = buildRejectReasonsReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width) + parseInt(layout[1].width) 
	+ parseInt(layout[2].width) + parseInt(layout[3].width) + 36; //36px to account for padding differences
	
	var tableWidth = totColWidth + parseInt(layout[3].width) + parseInt(layout[4].width)
		+ parseInt(layout[5].width)+ parseInt(layout[6].width)
		+ parseInt(layout[7].width) + parseInt(layout[8].width) 
		+ parseInt(layout[9].width) + parseInt(layout[10].width) 
		+ parseInt(layout[11].width) + parseInt(layout[12].width)
		+ parseInt(layout[13].width) + parseInt(layout[14].width)
		+ parseInt(layout[15].width) + parseInt(layout[16].width)
		+ parseInt(layout[17].width) + parseInt(layout[18].width + parseInt(layout[19].width));

	sumTable = 

		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left; padding-top: 3px; padding-bottom: 3px; padding-left: 5px; padding-right: 3px;'>" + numberFormat(totals.newRx) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + ";'>" + numberFormat(totals.newRxInProcess) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + ";'>" + numberFormat(totals.newRxRejectedByPharmacist) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + ";'>"+ numberFormat(totals.newRxPatientNotElig) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + ";'>" + numberFormat(totals.newRxPatientNotFound) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + ";'>" + numberFormat(totals.newRxProviderNotElig) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + ";'>" + numberFormat(totals.newRxProviderNotFound) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + ";'>" + numberFormat(totals.newRxNotEligRefills) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + ";'>" + numberFormat(totals.newRxNonFormulary) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[13].width + ";'>" + numberFormat(totals.newRxDuplicate) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[14].width + ";'>" + numberFormat(totals.newRxInvalidQty) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[15].width + ";'>" + numberFormat(totals.newRxDupTheraClass) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[16].width + ";'>" + numberFormat(totals.newRxCsNotAllowed) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[17].width + ";'>" + numberFormat(totals.newRxMultiErrCallPharm) + "</td>" +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[18].width + ";'>" + numberFormat(totals.newRxIncorrectPharm) + "</td>" +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[19].width + ";'>" + numberFormat(totals.newRxErrCallPharm) + "</td>" + "</tr>" +
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
				
			    summaryReportRecNumber.innerHTML= recordsTotal;
           }

	}
}

function rejectReasonsReportDataGridInit(responseData, parentContainer) {
	try {
		
		var gridData = new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid3';
		
	
		var grid = dijit.byId(gridId);
		
		var gridLayout = buildRejectReasonsReportLayout(null, parentContainer);

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
			
						
			grid.setStore(gridData);			
			
			
		}	
			// generate the table.
			generateDivTable(gridLayout,gridData,parentContainer);
			
			buildRejectReasonsReportTotalsGrid("summaryReportTotals", gridData, responseData.items.length);
			
			// remove the grid widget
			dojo.destroy(grid);
			 
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};

//eRxSummaryReport
//note if this updated with column addition/removal please also update columns in resetRejectReasonsReportTotalsGrid function, otherwise the display will be out of sync.
function buildErxSummaryReportTotalsGrid(parentContainer, gridData, recordsTotal) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid4');
	var totals = {};	
	var sumTable =  "";
	

	totals ["newRxCnt"] = 0;
	totals ["refillRequest"] = 0;
	totals ["refillResponse"] = 0;
	totals ["rxChangeRequest"] = 0;
	totals ["rxChangeResponse"] = 0;
	totals ["cancelRx"] = 0;
	totals ["cancelRxResponse"] = 0;
	totals ["rxFill"] = 0;
		
	totals.newRxCnt  = 0;
	totals.refillRequest  = 0;
	totals.refillResponse  = 0;
	totals.rxChangeRequest  = 0;
	totals.rxChangeResponse  = 0;
	totals.cancelRx  = 0;
	totals.cancelRxResponse  = 0;
	totals.rxFill = 0;
	
	var storeArray = gridData._arrayOfAllItems; 		
	
	for(var arrayElement in storeArray)
	{			
			
		var arrayItem  = storeArray[arrayElement];
					
		for (var s in arrayItem)
		{
			for (var k in totals) 
			{       
				 				  
			  if(k == s) 
			  {						   
			    totals[k] += parseInt(arrayItem[s]);  
			  }	
			}  

			  
		}
	
	//leverage layout of eRxSummaryReport
	var layout = buildErxSummaryReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width)+ parseInt(layout[1].width) + parseInt(layout[2].width) + parseInt(layout[3].width) + 36; //36px to account for padding differences
	var tableWidth = totColWidth + parseInt(layout[5].width) 
		+ parseInt(layout[6].width) + parseInt(layout[7].width) + parseInt(layout[8].width)
		+ parseInt(layout[9].width) + parseInt(layout[10].width) + parseInt(layout[11].width);


	sumTable = 

		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left; padding-top: 3px; padding-bottom: 3px; padding-left: 5px; padding-right: 3px;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + ";'>" + numberFormat(totals.refillRequest) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + ";'>"+ numberFormat(totals.refillResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + ";'>" + numberFormat(totals.rxChangeRequest) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + ";'>" + numberFormat(totals.rxChangeResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + ";'>" + numberFormat(totals.cancelRx) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + ";'>" + numberFormat(totals.cancelRxResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + ";'>" + numberFormat(totals.rxFill) + "</td>" +
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
				
			    summaryReportRecNumber.innerHTML= recordsTotal;
         }

	}
}

function erxSummaryReportDataGridInit(responseData, parentContainer) {
	try {
					
		var gridData = new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
		
		var gridId = parentContainer + 'Grid4';
		
	
		var grid = dijit.byId(gridId);
		
		var gridLayout = buildErxSummaryReportLayout(null, parentContainer);

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
			
						
			grid.setStore(gridData);			
			
			
		}	
		  		   
		  
			// generate the table.
			generateDivTable(gridLayout,gridData,parentContainer);
			
			buildErxSummaryReportTotalsGrid("summaryReportTotals", gridData, responseData.items.length);
			
			// remove the grid widget
			dojo.destroy(grid);
			 
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};


function resetReportTotalsGrid(parentContainer) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid3');
	var totals = {};	
	var sumTable =  "";
	

	dojo.byId(parentContainer).innerHTML = sumTable;
	
	// now update the record totals.
	
    var summaryReportRecNumberTitle = dojo.byId("reportRecNumberTitle");
	
	var summaryReportRecNumber = dojo.byId("reportRecNumber");
	
	
	if(summaryReportRecNumberTitle!=null){				 
		 
		  summaryReportRecNumberTitle.style.display="none";				
     }
		
	 if(summaryReportRecNumber!=null){				 
	 	 
	    	summaryReportRecNumber.style.display="none";
			
		    summaryReportRecNumber.innerHTML= "";
       }
	

}

//sorting functions.

var getCellValue = function(tr, idx)
{
		
	return tr.children[idx].innerText || tr.children[idx].textContent; 

}

var comparer = function(idx, asc) { 
	
	
	return function(a, b) { return function(v1, v2) {
		
        return v1 !== '' && v2 !== '' && !isNaN(v1) && !isNaN(v2) ? v1 - v2 : v1.toString().localeCompare(v2);
        
    }(getCellValue(asc ? a : b, idx), getCellValue(asc ? b : a, idx));
}};


// div table generation.
function generateDivTable(layout, gridData, dataGridDivId) {

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
					   // call the formatter function.
					   tempHyperlink = rowCellFormatterElement(rowCellValue);					   
					   
					   divTable = divTable.concat(tempHyperlink);
					 }
                     else
                     {						 
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
		 
		 if(recordCounter ==0)
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


//dummy div table generation.
function generateDummyDivTable(layout, gridData, dataGridDivId) {

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
		
		 
		 
		divTable = divTable.concat(divTableBodyEnd);
		divTable = divTable.concat(divTableEnd);
		dojo.byId(dataGridDivId).innerHTML = divTable;
				
		
  }