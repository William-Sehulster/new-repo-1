dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojox.grid.enhanced.plugins.IndirectSelection");
dojo.require("dojo.dom-construct");
dojo.require("dojox.grid.Selection");



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
	obj["width"] = "52px";
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


function buildErxSummaryReportLayout(servlet, target) {
	var layout = new Array();
	
	//M. Bolden - 5.0 - get Filter value for eRxType and build grid based off of filter type provided
	//var eRxTypeselectBox = dojo.byId("erxTypeSelection");
	//var selectedIndex = eRxTypeselectBox.options.selectedIndex;
	//var selected = eRxTypeselectBox.options[selectedIndex].value;
	//var selected = erxFilter;
	//selected = "NONCS";
	
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

    //if (selected == "ALL" || selected == "NONCS")
	//{
		obj = new Object();
		obj["field"] = 'newRxCnt';
		obj["name"] = "#New Rx";
		obj["width"] = '156px';
	//	//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}
	
   // if (selected == "ALL" || selected == "CS")
	//{	
		obj = new Object();
		obj["field"] = 'newRxCntCS';
		obj["name"] = "CS #New Rx";
		obj["width"] = '156px';
	//	//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}
	
    //if (selected == "ALL" || selected == "NONCS")
	//{		
		obj = new Object();
		obj["field"] = 'refillRequest';
		obj["name"] = "#RxRenewal Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

   //if (selected == "ALL" || selected == "CS")
	//{		
		obj = new Object();
		obj["field"] = 'refillRequestCS';
		obj["name"] = "CS #RxRenewal Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);	
	//}

    //if (selected == "ALL" || selected == "NONCS")
	//{		
		obj = new Object();
		obj["field"] = 'refillResponse';
		obj["name"] = "#RxRenewal Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "CS")
	//{		
		obj = new Object();
		obj["field"] = 'refillResponseCS';
		obj["name"] = "CS #RxRenewal Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);	
	//}

	//if (selected == "ALL" || selected == "NONCS")
	//{	
		obj = new Object();
		obj["field"] = 'rxChangeRequest';
		obj["name"] = "#RxChange Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "CS")
	//{		
		obj = new Object();
		obj["field"] = 'rxChangeRequestCS';
		obj["name"] = "CS #RxChange Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}
	
   //if (selected == "ALL" || selected == "NONCS")
	//{		
		obj = new Object();
		obj["field"] = 'rxChangeResponse';
		obj["name"] = "#RxChange Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}
	
    //if (selected == "ALL" || selected == "CS")
	//{		
		obj = new Object();
		obj["field"] = 'rxChangeResponseCS';
		obj["name"] = "CS #RxChange Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "NONCS")
	//{	
		obj = new Object();
		obj["field"] = 'cancelRx';
		obj["name"] = "#CancelRx Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "CS")
	//{		
		obj = new Object();
		obj["field"] = 'cancelRxCS';
		obj["name"] = "CS #CancelRx Request";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "NONCS")
	//{		
		obj = new Object();
		obj["field"] = 'cancelRxResponse';
		obj["name"] = "#CancelRx Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "CS")
	//{		
		obj = new Object();
		obj["field"] = 'cancelRxResponseCS';
		obj["name"] = "CS #CancelRx Response";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}

    //if (selected == "ALL" || selected == "NONCS")
	//{		
		obj = new Object();
		obj["field"] = 'rxFill';
		obj["name"] = "#RxFill";
		obj["width"] = '156px';
		//obj["noresize"] = 'true';
		obj["formatter"] = numberFormat;
		layout.push(obj);
	//}
	
    //if (selected == "ALL" || selected == "CS")
	//{		
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
	//}

	return layout;
}


// note if this updated with column addition/removal please also update columns in resetSummaryReportTotalsGrid function, otherwise the display will be out of sync.
function buildSummaryReportTotalsGrid(parentContainer) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid');
	var totals = {};	
	var sumTable =  "";
	

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
	
	
	//TODO this fetch is calling the Rest Service again when we should be able to sum the data from the current store

	gridId.store.fetch({onComplete: function(item, request){
		 
		console.log("Calculating Totals:   Item: " + item[0]); 
		console.log("Calculating Totals:   Item Length: " + item.length);
	if (item != null){
		for (var i = item.length; i--;) {
			for (var k in totals) {
				totals[k] += item[i][k];
	             console.log("item["+i+"]["+k+"] = " + item[i][k]);
			}
		}
	}


	
	//leverage layout of summaryReport
	var layout = buildSummaryReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width)+ parseInt(layout[1].width) + parseInt(layout[2].width) + parseInt(layout[3].width) + parseInt(layout[4].width) + 46; //45px to account for padding differences
	var tableWidth = totColWidth + parseInt(layout[5].width)+ parseInt(layout[6].width) + parseInt(layout[7].width) + parseInt(layout[8].width) + parseInt(layout[9].width) 
	                 + parseInt(layout[10].width) + parseInt(layout[11].width) + parseInt(layout[12].width) + parseInt(layout[13].width) + parseInt(layout[14].width) + parseInt(layout[15].width) 
					 + parseInt(layout[16].width) + parseInt(layout[17].width) + parseInt(layout[18].width) + parseInt(layout[19].width);

	sumTable = 

		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + "; text-align: left;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + "; text-align: left;'>" + numberFormat(totals.newRxCntCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + "; text-align: left;'>" + numberFormat(totals.newRxPharmDisabledAtHub) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + "; text-align: left;'>" + numberFormat(totals.newRxRejectedAtHub) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + "; text-align: left;'>" + numberFormat(totals.newRxRejectedAtHubCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + "; text-align: left;'>" + numberFormat(totals.newRxPassAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + "; text-align: left;'>" + numberFormat(totals.newRxPassAutoChkCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + "; text-align: left;'>" + numberFormat(totals.newRxFailAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[13].width + "; text-align: left;'>" + numberFormat(totals.newRxFailAutoChkCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[14].width + "; text-align: left;'>" + numberFormat(totals.newRxRejectedByPharmacist) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[15].width + "; text-align: left;'>" + numberFormat(totals.newRxRejectedByPharmacistCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[16].width + "; text-align: left;'>" + numberFormat(totals.newRxFilled) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[17].width + "; text-align: left;'>" + numberFormat(totals.newRxFilledCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[18].width + "; text-align: left;'>" + numberFormat(totals.newRxInProcess) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[19].width + "; text-align: left;'>" + numberFormat(totals.newRxInProcessCS) + "</td>" + "</tr>"
	"</table>";
	
	dojo.byId(parentContainer).innerHTML = sumTable;
	//dojo.byId("summaryReportGrid").innerHTML = sumTable;

	
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

}



//note if this updated with column addition/removal please also update columns in resetAutoCheckReportTotalsGrid function, otherwise the display will be out of sync.
function buildAutoCheckReportTotalsGrid(parentContainer) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid2');
	var totals = {};	
	var sumTable =  "";
	

	totals ["newRxCnt"] = 0;
	totals ["newRxPassAutoChk"] = 0;
	totals ["newRxPassAutoChkCs"] = 0;
	totals ["newRxFailAutoChk"] = 0;
	totals ["newRxFailAutoChkCs"] = 0;
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
	totals.newRxPassAutoChkCs  = 0;
	totals.newRxFailAutoChk  = 0;
	totals.newRxFailAutoChkCs  = 0;
	totals.newRxMviPatFound  = 0;
	totals.newRxMviPatNotFound  = 0;
	totals.newRxEneElgbEnrl  = 0;
	totals.newRxEneNotElgbEnrl  = 0;
	totals.newRxPatNotEnrlSite  = 0;
	totals.newRxDrgMtchFnd  = 0;
	totals.newRxDrgMtchNotFnd  = 0;
	totals.newRxPvdMtchFnd  = 0;
	totals.newRxPvdMtchNotFnd  = 0;
	
	
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
	var layout = buildAutoCheckReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width)+ parseInt(layout[1].width) + parseInt(layout[2].width) + parseInt(layout[3].width) + 36; //36px to account for padding differences
	var tableWidth = totColWidth + parseInt(layout[4].width) + parseInt(layout[5].width)+ parseInt(layout[6].width) + 
								   parseInt(layout[7].width) + parseInt(layout[8].width) + parseInt(layout[9].width) + 
								   parseInt(layout[10].width) + parseInt(layout[11].width) + parseInt(layout[12].width) + 
								   parseInt(layout[13].width) + parseInt(layout[14].width) + parseInt(layout[15].width +
								   parseInt(layout[16].width) + parseInt(layout[17].width));


	sumTable = 
		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + "; text-align: left;'>" + numberFormat(totals.newRxPassAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + "; text-align: left;'>" + numberFormat(totals.newRxPassAutoChkCs) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + "; text-align: left;'>" + numberFormat(totals.newRxFailAutoChk) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + "; text-align: left;'>" + numberFormat(totals.newRxFailAutoChkCs) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + "; text-align: left;'>" + numberFormat(totals.newRxMviPatFound) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + "; text-align: left;'>" + numberFormat(totals.newRxMviPatNotFound) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + "; text-align: left;'>" + numberFormat(totals.newRxEneElgbEnrl) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + "; text-align: left;'>" + numberFormat(totals.newRxEneNotElgbEnrl) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[13].width + "; text-align: left;'>" + numberFormat(totals.newRxPatNotEnrlSite) + "</td>"  +
		"<td class='summaryReportTotalsTd' style='width: " + layout[14].width + "; text-align: left;'>" + numberFormat(totals.newRxDrgMtchFnd) + "</td>"  +
		"<td class='summaryReportTotalsTd' style='width: " + layout[15].width + "; text-align: left;'>" + numberFormat(totals.newRxDrgMtchNotFnd) + "</td>"  +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[16].width + "; text-align: left;'>" + numberFormat(totals.newRxPvdMtchFnd) + "</td>"  +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[17].width + "; text-align: left;'>" + numberFormat(totals.newRxPvdMtchNotFnd) + "</td>" + "</tr>" +
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

function autoCheckReportDataGridInit(servlet, parentContainer, dataSourceURL) {
	try {
		var gridData = buildGridDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
		var gridId = parentContainer + 'Grid2';
		
	
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
			var gridLayout = buildAutoCheckReportLayout(servlet, parentContainer);
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




//RejectReasonsReport
//note if this updated with column addition/removal please also update columns in resetRejectReasonsReportTotalsGrid function, otherwise the display will be out of sync.
function buildRejectReasonsReportTotalsGrid(parentContainer) {
	
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
	totals.newRxInvalidCsDs  = 0;
	totals.newRxPrescriberCsCredInvalid  = 0;
	totals.newRxPatientAddrMissing  = 0;
	totals.newRxCsDateIssue  = 0;
	
	
	//TODO this fetch is calling the Rest Service again when we should be able to sum the data from the current store


	gridId.store.fetch({onComplete: function(item, request){
		
	
		if (item != null){
			for (var i = item.length; i--;) {
				for (var k in totals) {
					totals[k] += item[i][k];
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
		+ parseInt(layout[17].width) + parseInt(layout[18].width) 
		+ parseInt(layout[19].width) + parseInt(layout[20].width)
		+ parseInt(layout[21].width + parseInt(layout[22].width));

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
		"<td class='summaryReportTotalsTd' style='width: " + layout[16].width + ";'>" + numberFormat(totals.newRxMultiErrCallPharm) + "</td>" +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[17].width + ";'>" + numberFormat(totals.newRxIncorrectPharm) + "</td>" +
 		"<td class='summaryReportTotalsTd' style='width: " + layout[18].width + ";'>" + numberFormat(totals.newRxErrCallPharm) + "</td>" + 
		"<td class='summaryReportTotalsTd' style='width: " + layout[19].width + ";'>" + numberFormat(totals.newRxInvalidCsDs) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[20].width + ";'>" + numberFormat(totals.newRxPrescriberCsCredInvalid) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[21].width + ";'>" + numberFormat(totals.newRxPatientAddrMissing) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[22].width + ";'>" + numberFormat(totals.newRxCsDateIssue) + "</td>" + "</tr>" +
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

function rejectReasonsReportDataGridInit(servlet, parentContainer, dataSourceURL) {
	try {
		var gridData = buildGridDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
		var gridId = parentContainer + 'Grid3';
		
	
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
			var gridLayout = buildRejectReasonsReportLayout(servlet, parentContainer);
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

//eRxSummaryReport
//note if this updated with column addition/removal please also update columns in resetRejectReasonsReportTotalsGrid function, otherwise the display will be out of sync.
function buildErxSummaryReportTotalsGrid(parentContainer, eRxFilter) {
	
	// clear parent div, defect fix.
	dojo.byId(parentContainer).innerHTML = "";
	
	//sum up the data summaryReportGrid
	var gridId = dijit.byId('summaryReportGrid4');
	var totals = {};	
	var sumTable =  "";
	
	//M. Bolden - 5.0 - get Filter value for eRxType and build grid based off of filter type provided
	//var eRxTypeselectBox = dojo.byId("erxTypeSelection");
	//var selectedIndex = eRxTypeselectBox.options.selectedIndex;
	//var selected = eRxTypeselectBox.options[selectedIndex].value;
	var selected = eRxFilter;
	//selected = "NONCS";
	//M. Bolden - add new columns requested for 5.0 Control Substance summary report

	totals ["newRxCnt"] = 0;
	totals ["newRxCntCS"] = 0;   //5.0
	totals ["refillRequest"] = 0;
	totals ["refillRequestCS"] = 0; //5.0
	totals ["refillResponse"] = 0;
	totals ["refillResponseCS"] = 0; //5.0
	totals ["rxChangeRequest"] = 0;
	totals ["rxChangeRequestCS"] = 0; //5.0
	totals ["rxChangeResponse"] = 0;
	totals ["rxChangeResponseCS"] = 0; //5.0
	totals ["cancelRx"] = 0;
	totals ["cancelRxCS"] = 0; //5.0
	totals ["cancelRxResponse"] = 0;
	totals ["cancelRxResponseCS"] = 0; //5.0
	totals ["rxFill"] = 0;
	totals ["rxFillCS"] = 0; //5.0
	totals ["rxDoNotFillCS"] = 0; //5.0
		
	totals.newRxCnt  = 0;
	totals.newRxCntCS = 0;  //5.0
	totals.refillRequest  = 0;
	totals.refillRequestCS = 0; //5.0
	totals.refillResponse  = 0;
	totals.refillResponseCS = 0; //5.0
	totals.rxChangeRequest  = 0;
	totals.rxChangeRequestCS = 0; //5.0
	totals.rxChangeResponse  = 0;
	totals.rxChangeResponseCS = 0; //5.0
	totals.cancelRx  = 0;
	totals.cancelRxCS = 0; //5.0
	totals.cancelRxResponse  = 0;
	totals.cancelRxResponseCS = 0; //5.0
	totals.rxFill = 0;
	totals.rxFillCS = 0; //5.0
	totals.rxDoNotFillCS = 0; //5.0
	
	
	//TODO this fetch is calling the Rest Service again when we should be able to sum the data from the current store


	gridId.store.fetch({onComplete: function(item, request){
		
	
		if (item != null){
			for (var i = item.length; i--;) {
				for (var k in totals) {
					totals[k] += item[i][k];
				}
			}
		}

	
	//leverage layout of eRxSummaryReport
	var layout = buildErxSummaryReportLayout(null, null);
	
	var totColWidth = parseInt(layout[0].width)+ parseInt(layout[1].width) + parseInt(layout[2].width) + parseInt(layout[3].width) + 36; //36px to account for padding differences
	var tableWidth = totColWidth + parseInt(layout[5].width) 
		+ parseInt(layout[6].width) + parseInt(layout[7].width) + parseInt(layout[8].width)
		+ parseInt(layout[9].width) + parseInt(layout[10].width) + parseInt(layout[11].width);



    //M. Bolden - Add new columns for Controlled Substance to sumTable as well as build it based off of filter type chosen
	
	if(selected == "CS")
	{
     sumTable = 

		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left; padding-top: 3px; padding-bottom: 3px; padding-left: 5px; padding-right: 3px;'>" + numberFormat(totals.newRxCntCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + ";'>" + numberFormat(totals.refillRequestCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + ";'>" + numberFormat(totals.refillResponseCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + ";'>" + numberFormat(totals.rxChangeRequestCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + ";'>" + numberFormat(totals.rxChangeResponseCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + ";'>" + numberFormat(totals.cancelRxCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + ";'>" + numberFormat(totals.cancelRxResponseCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + ";'>" + numberFormat(totals.rxFillCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + ";'>" + numberFormat(totals.doNotFillCS) + "</td>" +
	"</table>";		
		
	}
	
	else if (selected == "NONCS")
	{
	sumTable = 

		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left; padding-top: 3px; padding-bottom: 3px; padding-left: 5px; padding-right: 3px;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + ";'>" + numberFormat(totals.refillRequest) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + ";'>" + numberFormat(totals.refillResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + ";'>" + numberFormat(totals.rxChangeRequest) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + ";'>" + numberFormat(totals.rxChangeResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + ";'>" + numberFormat(totals.cancelRx) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + ";'>" + numberFormat(totals.cancelRxResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + ";'>" + numberFormat(totals.rxFill) + "</td>" +
	"</table>";
	}
	
	else if(selected == "ALL")
	{
	sumTable =	
		
		"<table style='width: " + tableWidth + "px; table-layout: fixed;'>" +
		"<tr>" +
		"<td class='summaryReportTotalsTd' style='width: " + totColWidth + "px; text-align: right; font-weight: bold;'>Totals >>></td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[4].width + "; text-align: left; padding-top: 3px; padding-bottom: 3px; padding-left: 5px; padding-right: 3px;'>" + numberFormat(totals.newRxCnt) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[5].width + ";'>" + numberFormat(totals.newRxCntCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[6].width + ";'>" + numberFormat(totals.refillRequest) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[7].width + ";'>" + numberFormat(totals.refillRequestCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[8].width + ";'>" + numberFormat(totals.refillResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[9].width + ";'>" + numberFormat(totals.refillResponseCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[10].width + ";'>" + numberFormat(totals.rxChangeRequest) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[11].width + ";'>" + numberFormat(totals.rxChangeRequestCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[12].width + ";'>" + numberFormat(totals.rxChangeResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[13].width + ";'>" + numberFormat(totals.rxChangeResponseCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[14].width + ";'>" + numberFormat(totals.cancelRx) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[15].width + ";'>" + numberFormat(totals.cancelRxCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[16].width + ";'>" + numberFormat(totals.cancelRxResponse) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[17].width + ";'>" + numberFormat(totals.cancelRxResponseCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[18].width + ";'>" + numberFormat(totals.rxFill) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[19].width + ";'>" + numberFormat(totals.rxFillCS) + "</td>" +
		"<td class='summaryReportTotalsTd' style='width: " + layout[20].width + ";'>" + numberFormat(totals.doNotFillCS) + "</td>" +
	"</table>";
	}
	
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

function erxSummaryReportDataGridInit(servlet, parentContainer, dataSourceURL, eRxselected) {
	try {
		var gridData = buildGridDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
		var gridId = parentContainer + 'Grid4';
		
	
		var grid = dijit.byId(gridId);
		

		// If the DataGrid already exists, just clear any selected rows and
		// replace the store.
		if (grid != null) {
			if (grid.selection != null) {
				grid.selection.clear();
			}
			grid.setStore(gridData);
			
			var gridLayout2 = buildErxSummaryReportLayout(servlet, parentContainer);
			grid.setStructure(gridLayout2);
				
	} else {
			// DataGrid does not exist.
			var gridLayout = buildErxSummaryReportLayout(servlet, parentContainer);
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

