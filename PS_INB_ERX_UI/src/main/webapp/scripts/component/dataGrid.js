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

	obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "59px";
	obj["noresize"] = 'true';
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "48px";
	obj["noresize"] = 'true';	
	layout.push(obj);
	
	obj = new Object();
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
	obj["field"] = 'newRxCntCS';
	obj["name"] = "CS #New Rx";
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
	obj["field"] = 'newRxRejectedAtHubCS';
	obj["name"] = "CS #Rejected at Hub";
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
	obj["field"] = 'newRxPassAutoChkCS';
	obj["name"] = "CS #Passed Autocheck";
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
	obj["field"] = 'newRxFailAutoChkCS';
	obj["name"] = "CS #Failed Autocheck";
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
	obj["field"] = 'newRxRejectedByPharmacistCS';
	obj["name"] = "CS #Rejected by Pharmacy";
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
	obj["field"] = 'newRxFilledCS';
	obj["name"] = "CS #Rx Filled";
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
	
	obj = new Object();
	obj["field"] = 'newRxInProcessCS';
	obj["name"] = "CS #Accepted by Pharmacy";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);	

	return layout;
}

//E.Carlson - Added "#Passed Autocheck CS" and "#Failed Autocheck CS" columns per ERXCS1738.
function buildAutoCheckReportLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "32px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "65px";
	//obj["noresize"] = 'true';	
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "220px";
	//obj["noresize"] = 'true';
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
	obj["field"] = 'newRxPassAutoChk';
	obj["name"] = "#Passed Autocheck";
	obj["width"] = '156px';
	obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'newRxPassAutoChkCs';
	obj["name"] = "#Passed Autocheck CS";
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
	obj["field"] = 'newRxFailAutoChkCs';
	obj["name"] = "#Failed Autocheck CS";
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

// E.Carlson - Removed "newRxCsNotAllowed" per ERXCS-1729. Added newRxInvalidCsDs; newRxPrescriberCsCredInvalid;
// newRxPatientAddrMissing; newRxCsDateIssue.
function buildRejectReasonsReportLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "32px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "65px";
	//obj["noresize"] = 'true';	
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "220px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyAddress';
	obj["name"] = 'Address';
	obj["width"] = '232px';
	obj["noresize"] = 'true';
	//obj["formatter"] = numberFormat;
	layout.push(obj);

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
	
	// Added per above
	obj = new Object();
	obj["field"] = 'newRxInvalidCsDs';
	obj["name"] = "#Missing/Bad CS DS";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	// Added per above
	obj = new Object();
	obj["field"] = 'newRxPrescriberCsCredInvalid';
	obj["name"] = "#Prescriber's CS Credential Invalid";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	// Added per above
	obj = new Object();
	obj["field"] = 'newRxPatientAddrMissing';
	obj["name"] = "#Patient's Address Missing/Mismatched";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	
	// Added per above
	obj = new Object();
	obj["field"] = 'newRxCsDateIssue';
	obj["name"] = "#CS eRx Date Problem";
	obj["width"] = '156px';
	//obj["noresize"] = 'true';
	obj["formatter"] = numberFormat;
	layout.push(obj);
	return layout;
}


function buildErxSummaryReportLayout(servlet, target, selected) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "32px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyVaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "80px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyNcpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "65px";
	//obj["noresize"] = 'true';	
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyDivisionName';
	obj["name"] = 'Pharmacy Name';
	obj["width"] = "220px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyAddress';
	obj["name"] = 'Address';
	obj["width"] = '232px';
	obj["noresize"] = 'true';
	//obj["formatter"] = numberFormat;
	layout.push(obj);

    if (selected == "ALL" || selected == "NONCS")
	{
		obj = new Object();
		obj["field"] = 'newRxCnt';
		obj["name"] = "#New Rx";
		obj["width"] = '156px';
	//	//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}
	
    if (selected == "ALL" || selected == "CS")
	{	
		obj = new Object();
		obj["field"] = 'newRxCntCS';
		obj["name"] = "CS #New Rx";
		obj["width"] = '156px';
	//	//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}
	
    if (selected == "ALL" || selected == "NONCS")
	{		
		obj = new Object();
		obj["field"] = 'refillRequest';
		obj["name"] = "#RxRenewal Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

   if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'refillRequestCS';
		obj["name"] = "CS #RxRenewal Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);	
	}

    if (selected == "ALL" || selected == "NONCS")
	{		
		obj = new Object();
		obj["field"] = 'refillResponse';
		obj["name"] = "#RxRenewal Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'refillResponseCS';
		obj["name"] = "CS #RxRenewal Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);	
	}

	if (selected == "ALL" || selected == "NONCS")
	{	
		obj = new Object();
		obj["field"] = 'rxChangeRequest';
		obj["name"] = "#RxChange Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'rxChangeRequestCS';
		obj["name"] = "CS #RxChange Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}
	
   if (selected == "ALL" || selected == "NONCS")
	{		
		obj = new Object();
		obj["field"] = 'rxChangeResponse';
		obj["name"] = "#RxChange Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}
	
    if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'rxChangeResponseCS';
		obj["name"] = "CS #RxChange Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "NONCS")
	{	
		obj = new Object();
		obj["field"] = 'cancelRx';
		obj["name"] = "#CancelRx Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'cancelRxCS';
		obj["name"] = "CS #CancelRx Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "NONCS")
	{		
		obj = new Object();
		obj["field"] = 'cancelRxResponse';
		obj["name"] = "#CancelRx Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'cancelRxResponseCS';
		obj["name"] = "CS #CancelRx Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

    if (selected == "ALL" || selected == "NONCS")
	{		
		obj = new Object();
		obj["field"] = 'rxFill';
		obj["name"] = "#RxFill";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}
	
    if (selected == "ALL" || selected == "CS")
	{		
		obj = new Object();
		obj["field"] = 'rxFillCS';
		obj["name"] = "CS #RxFill";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);

		obj = new Object();
		obj["field"] = 'rxDoNotFillCS';
		obj["name"] = "CS #RxDoNotFill";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	}

	return layout;
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
			generateDivTable(gridLayout,gridData,parentContainer, "summaryReport");		
			
		   	var recordsTotal = responseData.items.length;
		   	
		   	var summaryReportRecNumberTitle = dojo.byId("reportRecNumberTitle");
			
			var summaryReportRecNumber = dojo.byId("reportRecNumber");
			
			if(summaryReportRecNumberTitle!=null){				 
				 
				  summaryReportRecNumberTitle.style.display="block";				
	         }
			
			 if(summaryReportRecNumber!=null){				 
			 	 
			    	summaryReportRecNumber.style.display="block";
					
				    summaryReportRecNumber.innerHTML= recordsTotal;
	           }
			
		   	
			
			// remove the grid widget
			 dojo.destroy(grid);
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
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
			generateDivTable(gridLayout,gridData,parentContainer, "autoCheckReport");	
			
			var recordsTotal = responseData.items.length;	
			
			var summaryReportRecNumberTitle = dojo.byId("reportRecNumberTitle");
			
			var summaryReportRecNumber = dojo.byId("reportRecNumber");
			
			
			if(summaryReportRecNumberTitle!=null){				 
				 
				  summaryReportRecNumberTitle.style.display="block";				
	         }
			
			 if(summaryReportRecNumber!=null){				 
			 	 
			    	summaryReportRecNumber.style.display="block";
					
				    summaryReportRecNumber.innerHTML= recordsTotal;
	           }
			
			// remove the grid widget
			dojo.destroy(grid);
			 
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};






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
			generateDivTable(gridLayout,gridData,parentContainer, "rejectReasonsReport");
			
			var recordsTotal = responseData.items.length;	
			
			var summaryReportRecNumberTitle = dojo.byId("reportRecNumberTitle");
			
			var summaryReportRecNumber = dojo.byId("reportRecNumber");
			
			
			if(summaryReportRecNumberTitle!=null){				 
				 
				  summaryReportRecNumberTitle.style.display="block";				
	         }
			
			 if(summaryReportRecNumber!=null){				 
			 	 
			    	summaryReportRecNumber.style.display="block";
					
				    summaryReportRecNumber.innerHTML= recordsTotal;
	           }
			
			// remove the grid widget
			dojo.destroy(grid);
			 
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};



function erxSummaryReportDataGridInit(responseData, parentContainer) {
	try {
		
		//M. Bolden - 5.0 -  After master merge eRx Filter no longer work as intended as the widget
		//                   being dynamically manipulated was removed. I will manipulate the table
		//                   directly here everytime the table is called to be generated.  First I 
		//                   need to know the value of the filter.
		
		var eRx_selectbox = dojo.byId("erxTypeSelection");
		console.log("before selection Widget ID: : Data Grid Init Summary Report");
		var selected_eRx = getSelected(eRx_selectbox);
		console.log("after selection: Data Grid Init Summary Report");
					
		var gridData = new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
		
		var gridId = parentContainer + 'Grid4';
		
	
		var grid = dijit.byId(gridId);
		
		var gridLayout = buildErxSummaryReportLayout(null, parentContainer, selected_eRx);

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
			generateDivTable(gridLayout,gridData,parentContainer, "erxSummaryReport", selected_eRx);	
			
			var recordsTotal = responseData.items.length;	
			
			var summaryReportRecNumberTitle = dojo.byId("reportRecNumberTitle");
			
			var summaryReportRecNumber = dojo.byId("reportRecNumber");
			
			
			if(summaryReportRecNumberTitle!=null){				 
				 
				  summaryReportRecNumberTitle.style.display="block";				
	         }
			
			 if(summaryReportRecNumber!=null){				 
			 	 
			    	summaryReportRecNumber.style.display="block";
					
				    summaryReportRecNumber.innerHTML= recordsTotal;
	           }
			
/*
            if (selected_eRx == "ALL")
			{
				console.log("You have selected an eRx type of ALL");
				
				//Adjust Main Grid
				//When the selection is ALL, make sure all columns are visible
				grid.layout.setColumnVisibility(0, true);         //visn
				grid.layout.setColumnVisibility(1, true);         //VA Station ID
				grid.layout.setColumnVisibility(2, true);         //NCPDP ID
				grid.layout.setColumnVisibility(3, true);	      //Pharmacyy Name
				grid.layout.setColumnVisibility(4, true);         //#New Rx
				grid.layout.setColumnVisibility(5, true);         //CS #New Rx
				grid.layout.setColumnVisibility(6, true);         //#RxRenewal Request
				grid.layout.setColumnVisibility(7, true);         //CS #RxRenewal Request
				grid.layout.setColumnVisibility(8, true);         //#RxRenewal Request
				grid.layout.setColumnVisibility(9, true);         //CS #RxRenewal Request
				grid.layout.setColumnVisibility(10, true);        //#RxChange Request
				grid.layout.setColumnVisibility(11, true);        //CS #RxChange Request
				grid.layout.setColumnVisibility(12, true);        //#RxChange Response	
				grid.layout.setColumnVisibility(13, true);        //CS #RxChange Response
				grid.layout.setColumnVisibility(14, true);        //#Cancel Rx Request
				grid.layout.setColumnVisibility(15, true);        //CS #Cancel Rx Request
				grid.layout.setColumnVisibility(16, true);        //#Cancel Response
				grid.layout.setColumnVisibility(17, true);        //CS #Cancel Response
				grid.layout.setColumnVisibility(18, true);        //#RxFill
				grid.layout.setColumnVisibility(19, true);        //CS #RxFill
				grid.layout.setColumnVisibility(20, true);        //CS #RxDoNotFill
			}
			
			if (selected_eRx == "CS")
			{
				console.log("You have selected an eRx type of CS");
				
				//Adjust Main Grid
				//When the selection is CS, make sure all columns that are CS are visible and those not CS are hidden
				grid.layout.setColumnVisibility(0, true);         //visn
				grid.layout.setColumnVisibility(1, true);         //VA Station ID
				grid.layout.setColumnVisibility(2, true);         //NCPDP ID
				grid.layout.setColumnVisibility(3, true);	      //Pharmacyy Name
				grid.layout.setColumnVisibility(4, false);        //#New Rx
				grid.layout.setColumnVisibility(5, true);         //CS #New Rx
				grid.layout.setColumnVisibility(6, false);        //#RxRenewal Request
				grid.layout.setColumnVisibility(7, true);         //CS #RxRenewal Request
				grid.layout.setColumnVisibility(8, false);        //#RxRenewal Request
				grid.layout.setColumnVisibility(9, true);         //CS #RxRenewal Request
				grid.layout.setColumnVisibility(10, false);       //#RxChange Request
				grid.layout.setColumnVisibility(11, true);        //CS #RxChange Request
				grid.layout.setColumnVisibility(12, false);       //#RxChange Response	
				grid.layout.setColumnVisibility(13, true);        //CS #RxChange Response
				grid.layout.setColumnVisibility(14, false);       //#Cancel Rx Request
				grid.layout.setColumnVisibility(15, true);        //CS #Cancel Rx Request
				grid.layout.setColumnVisibility(16, false);       //#Cancel Response
				grid.layout.setColumnVisibility(17, true);        //CS #Cancel Response
				grid.layout.setColumnVisibility(18, false);       //#RxFill
				grid.layout.setColumnVisibility(19, true);        //CS #RxFill
				grid.layout.setColumnVisibility(20, true);        //CS #RxDoNotFill
			}
			
			if (selected_eRx == "NONCS")
			{
				console.log("You have selected an eRx type of NONCS");
				
				//Adjust main Grid
				//When the selection is CS, make sure all columns that are not CS are visible and those CS are hidden
				grid.layout.setColumnVisibility(0, true);         //visn
				grid.layout.setColumnVisibility(1, true);         //VA Station ID
				grid.layout.setColumnVisibility(2, true);         //NCPDP ID
				grid.layout.setColumnVisibility(3, true);	      //Pharmacyy Name
				grid.layout.setColumnVisibility(4, true);         //#New Rx
				grid.layout.setColumnVisibility(5, false);        //CS #New Rx
				grid.layout.setColumnVisibility(6, true);         //#RxRenewal Request
				grid.layout.setColumnVisibility(7, false);        //CS #RxRenewal Request
				grid.layout.setColumnVisibility(8, true);         //#RxRenewal Request
				grid.layout.setColumnVisibility(9, false);        //CS #RxRenewal Request
				grid.layout.setColumnVisibility(10, true);        //#RxChange Request
				grid.layout.setColumnVisibility(11, false);       //CS #RxChange Request
				grid.layout.setColumnVisibility(12, true);        //#RxChange Response	
				grid.layout.setColumnVisibility(13, false);       //CS #RxChange Response
				grid.layout.setColumnVisibility(14, true);        //#Cancel Rx Request
				grid.layout.setColumnVisibility(15, false);       //CS #Cancel Rx Request
				grid.layout.setColumnVisibility(16, true);        //#Cancel Response
				grid.layout.setColumnVisibility(17, false);       //CS #Cancel Response
				grid.layout.setColumnVisibility(18, true);        //#RxFill
				grid.layout.setColumnVisibility(19, false);       //CS #RxFill
				grid.layout.setColumnVisibility(20, false);       //CS #RxDoNotFill
			}
	*/		// remove the grid widget
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
function generateDivTable(layout, gridData, dataGridDivId,reportType, selected) {

	    // clear the parent div first.
        dojo.byId(dataGridDivId).innerHTML ="";
        
        var totals = {};
        
        
        if(reportType === "summaryReport")
        {

            totals ["newRxCnt"] = 0;
			totals ["newRxCntCS"] = 0;
        	totals ["newRxPharmDisabledAtHub"] = 0;
        	totals ["newRxRejectedAtHub"] = 0;
			totals ["newRxRejectedAtHubCS"] = 0;
        	totals ["newRxPassAutoChk"] = 0;
			totals ["newRxPassAutoChkCS"] = 0;
        	totals ["newRxFailAutoChk"] = 0;
			totals ["newRxFailAutoChkCS"] = 0;
        	totals ["newRxRejectedByPharmacist"] = 0;
			totals ["newRxRejectedByPharmacistCS"] = 0;
        	totals ["newRxFilled"] = 0;
			totals ["newRxFilledCS"] = 0;
        	totals ["newRxInProcess"] = 0;
			totals ["newRxInProcessCS"] = 0;
        	
        	totals.newRxCnt  = 0;
			totals.newRxCntCS  = 0;
        	totals.newRxPharmDisabledAtHub  = 0;
        	totals.newRxRejectedAtHub  = 0;
			totals.newRxRejectedAtHubCS  = 0;
        	totals.newRxPassAutoChk  = 0;
			totals.newRxPassAutoChkCS  = 0;
        	totals.newRxFailAutoChk  = 0;
			totals.newRxFailAutoChkCS  = 0;
        	totals.newRxRejectedByPharmacist  = 0;
			totals.newRxRejectedByPharmacistCS  = 0;
        	totals.newRxFilled  = 0;
			totals.newRxFilledCS  = 0;
        	totals.newRxInProcess  = 0;
			totals.newRxInProcessCS  = 0;
            
        }
        else if(reportType === "autoCheckReport")
        {

            totals ["newRxCnt"] = 0;
        	totals ["newRxPassAutoChk"] = 0;
			totals ["newRxPassAutoChkCS"] = 0;
        	totals ["newRxFailAutoChk"] = 0;
			totals ["newRxFailAutoChkCS"] = 0;
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
			totals.newRxPassAutoChkCS  = 0;
        	totals.newRxFailAutoChk  = 0;
			totals.newRxFailAutoChkCS  = 0;
        	totals.newRxMviPatFound  = 0;
        	totals.newRxMviPatNotFound  = 0;
        	totals.newRxEneElgbEnrl  = 0;
        	totals.newRxEneNotElgbEnrl  = 0;
        	totals.newRxPatNotEnrlSite  = 0;
        	totals.newRxDrgMtchFnd  = 0;
        	totals.newRxDrgMtchNotFnd  = 0;
        	totals.newRxPvdMtchFnd  = 0;
        	totals.newRxPvdMtchNotFnd  = 0;	
        }
        else if(reportType === "rejectReasonsReport")
        {
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
        	totals ["newRxMultiErrCallPharm"] = 0;
        	totals ["newRxIncorrectPharm"] = 0;
        	totals ["newRxErrCallPharm"] = 0;
			totals ["newRxInvalidCsDs"] = 0;
			totals ["newRxPrescriberCsCredInvalid"] = 0;
			totals ["newRxPatientAddrMissing"] = 0;
			totals ["newRxCsDateIssue"] = 0;
        		
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
        	totals.newRxMultiErrCallPharm  = 0;
        	totals.newRxIncorrectPharm  = 0;
        	totals.newRxErrCallPharm  = 0;
			totals.newRxInvalidCsDs = 0;
			totals.newRxPrescriberCsCredInvalid = 0;
			totals.newRxPatientAddrMissing = 0;
			totals.newRxCsDateIssue = 0;
        	
             
        }
        else if(reportType === "erxSummaryReport")
        {

            if (selected == "ALL")
			{
				totals ["newRxCnt"] = 0;
				totals ["newRxCntCS"] = 0;
				totals ["refillRequest"] = 0;
				totals ["refillRequestCS"] = 0;
				totals ["refillResponse"] = 0;
				totals ["refillResponseCS"] = 0;
				totals ["rxChangeRequest"] = 0;
				totals ["rxChangeRequestCS"] = 0;
				totals ["rxChangeResponse"] = 0;
				totals ["rxChangeResponseCS"] = 0;
				totals ["cancelRx"] = 0;
				totals ["cancelRxCS"] = 0;
				totals ["cancelRxResponse"] = 0;
				totals ["cancelRxResponseCS"] = 0;
				totals ["rxFill"] = 0;
				totals ["rxFillCS"] = 0;
				totals ["rxDoNotFillCS"] = 0;
					
				totals.newRxCnt  = 0;
				totals.newRxCntCS  = 0;
				totals.refillRequest  = 0;
				totals.refillRequestCS  = 0;
				totals.refillResponse  = 0;
				totals.refillResponseCS  = 0;
				totals.rxChangeRequest  = 0;
				totals.rxChangeRequestCS  = 0;
				totals.rxChangeResponse  = 0;
				totals.rxChangeResponseCS  = 0;
				totals.cancelRx  = 0;
				totals.cancelRxCS  = 0;
				totals.cancelRxResponse  = 0;
				totals.cancelRxResponseCS  = 0;
				totals.rxFill = 0;
				totals.rxFillCS = 0;
				totals.rxDoNotFillCS = 0;
			}
			
			else if (selected == "CS")
			{
				totals ["newRxCntCS"] = 0;
				totals ["refillRequestCS"] = 0;
				totals ["refillResponseCS"] = 0;
				totals ["rxChangeRequestCS"] = 0;
				totals ["rxChangeResponseCS"] = 0;
				totals ["cancelRxCS"] = 0;
				totals ["cancelRxResponseCS"] = 0;
				totals ["rxFillCS"] = 0;
				totals ["rxDoNotFillCS"] = 0;
					
				totals.newRxCntCS  = 0;
				totals.refillRequestCS  = 0;
				totals.refillResponseCS  = 0;
				totals.rxChangeRequestCS  = 0;
				totals.rxChangeResponseCS  = 0;
				totals.cancelRxCS  = 0;
				totals.cancelRxResponseCS  = 0;
				totals.rxFillCS = 0;
				totals.rxDoNotFillCS = 0;
			}
			
			else if (selected == "NONCS")
			{
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
			}
             

        }




		var rowCounter = 1; 
		
		var recordCounter = 0;
		
		var elementWidthArray = [];
		
		var elementFormatterArray = [];
		
		var rowColumnCounter = 1;
		
		//variable for aria label
		var divTableStart = "<div class=\"generatedReportsDivTable\" id=\"generatedDivTableID\" tabindex=\"0\" role=\"table\" aria-label=\"Reports\ Table\" aria-describedby=\"divTableInfo\">";
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
	
		var totalsRowString ="";	
		var addTotalsRow = false;
		var totalsDone = false;
			
		for(var arrayElement in storeArray){			
			
			
			var arrayItem  = storeArray[arrayElement];
			
			for (var k in arrayItem)
			{
				
				 // do the totals row calculation first 
				 for (var totalsCounter in totals) 
    			 {       
					
    				 				  
	     			  if(totalsCounter == k) 
	     			  {						   
												 
	     			    totals[totalsCounter] += parseInt(arrayItem[k]);  
	     			  }	
    			  }  
				
				if((arrayItem[k]!='') && (k=='stringArray'))
				{
			 	
				 
				 tempStringArray = arrayItem[k];				
				 
				 rowCounterString = divTableResultRowStart + "aria-describedby=\"Row" +" " + rowCounter+"\">";
				 
				 divTable = divTable.concat(rowCounterString);
				 
					 
				
                 for (var s in tempStringArray)
			     {
                	 if(selected == "ALL"   ||
					    (s == 0 || s==1 || s==2 || s==3 || s==4) ||
					   (selected == "CS"    && (s==6 || s==8 || s==10 || s==12 || s==14 || s==16 || s==18 || s==20 || s==21) ) || 
					   (selected == "NONCS" && (s==5 || s==7 || s==9 || s==11 || s==13 || s==15 || s==17 || s==19) ))
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
							 if(rowCellValue == null || rowCellValue ==="null")
							 {
								  rowCellValue ="";
							 }	 
							 
							 divTable = divTable.concat(rowCellValue);
						 }
											 
						 
									
						 divTable = divTable.concat(divTableRowCellEnd);
					 
					
					 }
				 }
				
              
                 // if this last row add totals row.
            	 if(rowCounter == storeArray.length ){
            		 
            		 //console.log("last row");
            		 
            		 var totalsRow = rowCounter +1;
            		 
            		 addTotalsRow = true;
            		 
            		 totalsRowString += divTableResultRowStart + "aria-describedby=\"Row" +" " + totalsRow+"\">";
    				 
    				            		 
    				 
    				 for (var s in tempStringArray)
    			     {
                  					
    					    					 
    					if(rowColumnCounter <5){
    					
    						totalsRowString += divTableRowCellStart + "style=\"width:" + " " + elementWidthArray[s] + ";\">";
    						totalsRowString +=  "&nbsp;";
    						totalsRowString += divTableRowCellEnd;
    					}
    					else if(rowColumnCounter == 5){
    						totalsRowString += divTableRowCellStart + "style=\"width:" + " " + elementWidthArray[s] + ";font-weight:bold; text-align:right;\">";
    						totalsRowString +=  "Totals >>>";
    						totalsRowString += divTableRowCellEnd;
    					}
    					else if(rowColumnCounter > 5 && totalsDone == false){
    						
    						for (var totalValues in totals){
    							
    							totalsRowString += divTableRowCellStart + "style=\"width:" + " " + elementWidthArray[s] + ";font-weight:bold\">";
        						totalsRowString += numberFormat(totals[totalValues]) ;
        						totalsRowString += divTableRowCellEnd;
    							
    						}
    						
    						totalsDone = true;
    						
    					}	
    					 
    					 rowColumnCounter++;
    				 }
            	 }
            
            	 
				 rowCounter++;
				 recordCounter++;
								
			 	 divTable = divTable.concat(divTableResultRowEnd);
			 	 
			 	 if(addTotalsRow == true)
			 	 {
			 		 divTable = divTable.concat(totalsRowString);
			 		 
			 		 divTable = divTable.concat(divTableResultRowEnd);
			 	 }	 
				 
				 
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
		var divTableStart = "<div class=\"generatedReportsDivTable\" id=\"generatedDivTableID\" tabindex=\"0\" role=\"table\" aria-label=\"Reports\ Table\" aria-describedby=\"divTableInfo\">";
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
  
  // drop down selection.
function getSelected(selectBox) {
	var selectedIndex = selectBox.options.selectedIndex;
	var selected = selectBox.options[selectedIndex].value;
	return selected;
}