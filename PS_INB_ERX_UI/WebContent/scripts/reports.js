dojo.require("dojo.hash");
dojo.require("dijit.registry");
dojo.require("dojo.date");
dojo.require("dijit.Dialog");
dojo.require("dojo.Deferred");
dojo.require("dojo.parser");
dojo.require("dojox.grid.Selection");
dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojox.grid.enhanced.plugins.IndirectSelection");

var reportsLoadingDialog;


dojo.addOnLoad(function() {
	dojo.style(dojo.byId('summaryReport'), "display", "none");
    dojo.style(dojo.byId('summaryReportFilter'), "display", "none");

});

var neweRxSummaryReportDefaultDate = false;
var autoCheckReportDefaultDate = false;
var rejectReportDefaultDate = false;
var summaryReportDefaultDate = false;



dojo.ready(function() {
	var selectBox = dojo.byId("reportSelection");
	var selected = null;
	var scrollGrid = null;
	var topGrid = null;
	var bottomGrid = null;

	//M. Bolden - 5.0 - set visibility of eRx Type Filter based off of Report selected.	
	var eRxWidjitID = dojo.byId('erxFilter');	
	var selected_eRx = null;
	
	
	
	dojo.connect(selectBox, "onchange", null, function(event) {
		selected = getSelected(selectBox);
		
		if (selected == "SUMMRPT") {

			//M. Bolden - 5.0 - set eRx Visibility to visible
			eRxWidjitID.style.display = "none";			
			
			var valid = getSummaryReport();
			
			if(valid == true){
				
				toggleDivs();						
				
			}
			
		}
		else if (selected == "AUTOCHECKRPT") {

			
            console.log("reportSelection - On Change - getAutoCheckReport()");
			//M. Bolden - 5.0 - set eRx Visibility to not visible
			eRxWidjitID.style.display = "none";
			
			var valid = getAutoCheckReport();

			
			if(valid == true){
				
				toggleDivs();				
				
			}

			
		}
		else if (selected == "REJECTRESNRPT") {

            console.log("reportSelection - On Change - getRejectReasonsReport()");
			//M. Bolden - 5.0 - set eRx Visibility to not visible
			eRxWidjitID.style.display = "none";
			
			var valid = getRejectReasonsReport();
			
			if(valid == true){
				
				toggleDivs();			
				
			}

		}
		else if (selected == "ERXSUMMRPT") {

            console.log("reportSelection - On Change - getErxSummaryReport()");
			//M. Bolden - 5.0 - set eRx Visibility to not visible
			eRxWidjitID.style.display = "block";
			
			var valid = getErxSummaryReport();
			
			if(valid == true){
				
				toggleDivs();
				
				
			}

			
		}
		else{
			toggleDivs();
		}
		
	});
	

    //M. Bolden - 5.0 - when eRx Type is selected different columns are available to view
	dojo.connect(eRxWidjitID, "onchange", null, function(event) {
		
		var eRx_selectbox = dojo.byId("erxTypeSelection");
		console.log("before selection Widget ID: " + eRx_selectbox);
		selected_eRx = getSelected(eRx_selectbox);
		console.log("after selection");
		
		var grid_obj = dijit.byId("summaryReportGrid4");
		//var grid_obj_totals = dijit.byId("summaryReportTotals");
		console.log("created Grid Object from SummaryReportGrid4");
		grid_obj.beginUpdate();
		//grid_obj_totals.beginUpdate();
		
		if (selected_eRx == "ALL") {

				console.log("eRx Type Selection - On Change - ALL");
				
				//Adjust Main Grid
				//When the selection is ALL, make sure all columns are visible
				grid_obj.layout.setColumnVisibility(0, true);         //visn
				grid_obj.layout.setColumnVisibility(1, true);         //VA Station ID
				grid_obj.layout.setColumnVisibility(2, true);         //NCPDP ID
				grid_obj.layout.setColumnVisibility(3, true);	      //Pharmacyy Name
				grid_obj.layout.setColumnVisibility(4, true);         //#New Rx
				grid_obj.layout.setColumnVisibility(5, true);         //CS #New Rx
				grid_obj.layout.setColumnVisibility(6, true);         //#RxRenewal Request
				grid_obj.layout.setColumnVisibility(7, true);         //CS #RxRenewal Request
				grid_obj.layout.setColumnVisibility(8, true);         //#RxRenewal Request
				grid_obj.layout.setColumnVisibility(9, true);         //CS #RxRenewal Request
				grid_obj.layout.setColumnVisibility(10, true);        //#RxChange Request
				grid_obj.layout.setColumnVisibility(11, true);        //CS #RxChange Request
				grid_obj.layout.setColumnVisibility(12, true);        //#RxChange Response	
				grid_obj.layout.setColumnVisibility(13, true);        //CS #RxChange Response
				grid_obj.layout.setColumnVisibility(14, true);        //#Cancel Rx Request
				grid_obj.layout.setColumnVisibility(15, true);        //CS #Cancel Rx Request
				grid_obj.layout.setColumnVisibility(16, true);        //#Cancel Response
				grid_obj.layout.setColumnVisibility(17, true);        //CS #Cancel Response
				grid_obj.layout.setColumnVisibility(18, true);        //#RxFill
				grid_obj.layout.setColumnVisibility(19, true);        //CS #RxFill
				grid_obj.layout.setColumnVisibility(20, true);        //CS #RxDoNotFill	
            				
			}
			
		else if (selected_eRx == "CS") {
			
                console.log("eRx Type Selection - On Change - CS");
				
				//Adjust Main Grid
				//When the selection is CS, make sure all columns that are CS are visible and those not CS are hidden
				grid_obj.layout.setColumnVisibility(0, true);         //visn
				grid_obj.layout.setColumnVisibility(1, true);         //VA Station ID
				grid_obj.layout.setColumnVisibility(2, true);         //NCPDP ID
				grid_obj.layout.setColumnVisibility(3, true);	      //Pharmacyy Name
				grid_obj.layout.setColumnVisibility(4, false);        //#New Rx
				grid_obj.layout.setColumnVisibility(5, true);         //CS #New Rx
				grid_obj.layout.setColumnVisibility(6, false);        //#RxRenewal Request
				grid_obj.layout.setColumnVisibility(7, true);         //CS #RxRenewal Request
				grid_obj.layout.setColumnVisibility(8, false);        //#RxRenewal Request
				grid_obj.layout.setColumnVisibility(9, true);         //CS #RxRenewal Request
				grid_obj.layout.setColumnVisibility(10, false);       //#RxChange Request
				grid_obj.layout.setColumnVisibility(11, true);        //CS #RxChange Request
				grid_obj.layout.setColumnVisibility(12, false);       //#RxChange Response	
				grid_obj.layout.setColumnVisibility(13, true);        //CS #RxChange Response
				grid_obj.layout.setColumnVisibility(14, false);       //#Cancel Rx Request
				grid_obj.layout.setColumnVisibility(15, true);        //CS #Cancel Rx Request
				grid_obj.layout.setColumnVisibility(16, false);       //#Cancel Response
				grid_obj.layout.setColumnVisibility(17, true);        //CS #Cancel Response
				grid_obj.layout.setColumnVisibility(18, false);       //#RxFill
				grid_obj.layout.setColumnVisibility(19, true);        //CS #RxFill
				grid_obj.layout.setColumnVisibility(20, true);        //CS #RxDoNotFill	
				
		}
		else if (selected_eRx == "NONCS") {
            
                console.log("eRx Type Selection - On Change - NONCS");
				
				//Adjust main Grid
				//When the selection is CS, make sure all columns that are not CS are visible and those CS are hidden
				grid_obj.layout.setColumnVisibility(0, true);         //visn
				grid_obj.layout.setColumnVisibility(1, true);         //VA Station ID
				grid_obj.layout.setColumnVisibility(2, true);         //NCPDP ID
				grid_obj.layout.setColumnVisibility(3, true);	      //Pharmacyy Name
				grid_obj.layout.setColumnVisibility(4, true);         //#New Rx
				grid_obj.layout.setColumnVisibility(5, false);        //CS #New Rx
				grid_obj.layout.setColumnVisibility(6, true);         //#RxRenewal Request
				grid_obj.layout.setColumnVisibility(7, false);        //CS #RxRenewal Request
				grid_obj.layout.setColumnVisibility(8, true);         //#RxRenewal Request
				grid_obj.layout.setColumnVisibility(9, false);        //CS #RxRenewal Request
				grid_obj.layout.setColumnVisibility(10, true);        //#RxChange Request
				grid_obj.layout.setColumnVisibility(11, false);       //CS #RxChange Request
				grid_obj.layout.setColumnVisibility(12, true);        //#RxChange Response	
				grid_obj.layout.setColumnVisibility(13, false);       //CS #RxChange Response
				grid_obj.layout.setColumnVisibility(14, true);        //#Cancel Rx Request
				grid_obj.layout.setColumnVisibility(15, false);       //CS #Cancel Rx Request
				grid_obj.layout.setColumnVisibility(16, true);        //#Cancel Response
				grid_obj.layout.setColumnVisibility(17, false);       //CS #Cancel Response
				grid_obj.layout.setColumnVisibility(18, true);        //#RxFill
				grid_obj.layout.setColumnVisibility(19, false);       //CS #RxFill
				grid_obj.layout.setColumnVisibility(20, false);       //CS #RxDoNotFill
				
		}

		else{
                 console.log("You shouldn't be here! Something went wrong!");
		}
		grid_obj.endUpdate();
		//grid_obj_totals.endUpdate();
		buildErxSummaryReportTotalsGrid("summaryReportTotals", selected_eRx) 
	});	
	
	
	
});	




// drop down selection.
function getSelected(selectBox) {
	var selectedIndex = selectBox.options.selectedIndex;
	var selected = selectBox.options[selectedIndex].value;
	return selected;
}



function getSummaryReport() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	var validation = true;
	
	
	// limit To/From future dates.
	var startDate = dijit.byId('dateFrom');
	var endDate = dijit.byId('dateTo');
	
	if(startDate!=null)
	{	
		
	  startDate.constraints.max = new Date();
	}
	
	if(endDate!=null)
	{	
		
		endDate.constraints.max = new Date();
	}
	
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
	
	var selectBox = dojo.byId("reportSelection");

	selected = getSelected(selectBox);
	
	//M. Bolden - 5.0 - set visibility of eRx Type Filter based off of Report selected.	
	var eRxWidjitID = dojo.byId('erxFilter');
	
		if (selected == "SUMMRPT") {
			showModalWin();
			

			console.log("getSummaryReport: eRx Summary Report Selected");			
			
			buildGridDataSource("/inbound/inb-erx/"  + "summaryReport/getSummary?json=" + dojo.toJson(formObject),summaryReportDataGridInit,"summaryReport" );			
			
			dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
			
			hideModalWin();			
			
			toggleDivs();	
			
			
		}
		if (selected == "AUTOCHECKRPT") {
						
			console.log("getSummaryReport: Autocheck Report Selected");
			
			var valid = getAutoCheckReport();
			
			if(valid == true){
				toggleDivs();			
				
			}
	
		}
		if (selected == "REJECTRESNRPT") {

			console.log("getSummaryReport: Reject Reasons Report Selected");
			
			var valid = getRejectReasonsReport();
			
			if(valid == true){
				toggleDivs();	
				
				
			}
			
		}
		if (selected == "ERXSUMMRPT") {
			
			console.log("getSummaryReport: New eRx Only Summary Report Selected");
			
			dojo.style("erxFilter", "visibility", "visible");
			
			var valid = getErxSummaryReport();
			
			if(valid == true){			
				toggleDivs();
				
				
			}
			
		}
		
		
		console.log("End getSummaryReport()");		
		return true;
}

function getStationIdSelect(visn) {
	
	var formId = "summaryReportForm";
	
	// do a  null check to avoid js error.
	if(dojo.byId(formId)!=null){
		
		var formObject = dojo.formToObject(formId);
		var visn = formObject.visn
		
		summaryReportSelectInit("inb-erx","summaryReportForm", "summaryReport/getStationIdSelect?visn=" + visn);
		
	}
	
}

function getVisnSelect() {
	
	visnSelectInit("inb-erx","summaryReportForm", "summaryReport/getVisnSelect");
	
}

	 

function toggleDivs(){

    
	 dojo.style(dojo.byId('summaryReportFilter'), "display", "block");
     dojo.style(dojo.byId('summaryReport'), "display", "block"); 
     dojo.style(dojo.byId('summaryReportTotals'), "display", "block");  
     
}


function getCurrentDateTimeForDisplay(){
	var d = new Date(),
    minutes = d.getMinutes().toString().length == 1 ? '0'+d.getMinutes() : d.getMinutes(),
    hours = d.getHours().toString().length == 1 ? '0'+d.getHours() : d.getHours(),
    //ampm = d.getHours() >= 12 ? 'pm' : 'am',
    months = ['Jan','Feb','Mar','Apr','May','Jun','Jul','Aug','Sep','Oct','Nov','Dec'],
    days = ['Sun','Mon','Tue','Wed','Thu','Fri','Sat'];
    return days[d.getDay()]+' '+months[d.getMonth()]+' '+d.getDate()+' '+d.getFullYear()+' '+hours+':'+minutes;
}


function getReportCSV(){
	
	var selectBox = dojo.byId("reportSelection");
    selected = getSelected(selectBox);
		
		if (selected == "SUMMRPT") {	
			getSummaryReportCSV();			
		}
		if (selected == "AUTOCHECKRPT") {
			getAutoCheckReportCSV();
		}
		if (selected == "REJECTRESNRPT") {
			getRejectReasonsReportCSV();
		}
		if (selected == "ERXSUMMRPT") {
			getErxSummaryReportCSV();
		}
	
}

function getSummaryReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	showCSVModalWin();
	hideCSVModalWin();
	var getCSVUrl ="/inbound/inb-erx/summaryReport/getSummaryReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}

function getAutoCheckReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	showCSVModalWin();
	hideCSVModalWin();
	var getCSVUrl ="/inbound/inb-erx/autoCheckReport/getReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}

function getRejectReasonsReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	showCSVModalWin();
	hideCSVModalWin();
	var getCSVUrl ="/inbound/inb-erx/rejectReasonsReport/getReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}

function getErxSummaryReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	showCSVModalWin();
	hideCSVModalWin();
	var getCSVUrl ="/inbound/inb-erx/erxSummaryReport/getReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}


function csvResponse(){
	
	 return;
}



function clearSearch() {
	
	 var reportVisnBox = dijit.byId("summaryReportFormVisnSelect");
	 reportVisnBox.reset();
	 reportVisnBox.set("value", 'All');
	 
	 
	 var reportStationId = dijit.byId("summaryReportFormSelect");
	 reportStationId.reset();
	 reportStationId.set("value", 'All');
	 
	
	 var startDate = dijit.byId('dateFrom');
	 
	 var endDate = dijit.byId('dateTo');
	 
	 
		
	 if(startDate!=null)
	 {	
	 	
	  startDate.reset();	
	 
	  startDate.constraints.max = new Date();
	 }
	
	 if(endDate!=null)
	 {	
		
	   endDate.reset();
		
	   endDate.constraints.max = new Date();
	}
	 
	
	 var gridLayout = null;
	 
	 var dummyData = new  dojo.data.ItemFileReadStore({data: {  identifier: "",  items: []}}); // clears the Grid	
	 
	 
	 var selected = null;
	 var selectBox = dojo.byId("reportSelection");
	 
	 selected = getSelected(selectBox);	
			
		if (selected == "SUMMRPT") 
		{

			 gridLayout = buildSummaryReportLayout(null, "summaryReport");
			
			
		}
		else if (selected == "AUTOCHECKRPT") 
		{

			gridLayout = buildAutoCheckReportLayout(null, "summaryReport");			
		}
		else if (selected == "REJECTRESNRPT") 
		{

			gridLayout = buildRejectReasonsReportLayout(null, "summaryReport");		

		}
		else if (selected == "ERXSUMMRPT")
		{

			 gridLayout = buildErxSummaryReportLayout(null, "summaryReport");		
		}
	
     // genertae dummy table.
	 generateDummyDivTable(gridLayout,dummyData,"summaryReport");
	 
	 // reset Totals		
	 resetReportTotalsGrid("summaryReportTotals");
	 	 
	 dojo.byId("reportRunDateTime").innerHTML = "";
	 
	 setYesterdaysDefaultDate();
	 
}

function getRejectReasonsReport() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	var validation = true;
	
	
	// limit To/From future dates.
	var startDate = dijit.byId('dateFrom');
	var endDate = dijit.byId('dateTo');
	
	if(startDate!=null)
	{	
		
	  startDate.constraints.max = new Date();
	}
	
	if(endDate!=null)
	{	
		
		endDate.constraints.max = new Date();
	}
		
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
    showModalWin();    
	
	buildGridDataSource("/inbound/inb-erx/"  + "rejectReasonsReport/getReport?json=" + dojo.toJson(formObject),rejectReasonsReportDataGridInit,"summaryReport" );
		
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
	hideModalWin();
	return true;
		
}

function getAutoCheckReport() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	var validation = true;
	
	
	// limit To/From future dates.
	var startDate = dijit.byId('dateFrom');
	var endDate = dijit.byId('dateTo');
	
	if(startDate!=null)
	{	
		
	  startDate.constraints.max = new Date();
	}
	
	if(endDate!=null)
	{	
		
		endDate.constraints.max = new Date();
	}
	
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
    showModalWin();	
	
	buildGridDataSource("/inbound/inb-erx/"  + "autoCheckReport/getReport?json=" + dojo.toJson(formObject),autoCheckReportDataGridInit,"summaryReport" );	
	
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
	hideModalWin();
	return true;
		
}

function getErxSummaryReport() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	var validation = true;
	
	// limit To/From future dates.
	var startDate = dijit.byId('dateFrom');
	var endDate = dijit.byId('dateTo');
	
	//M. Bolden - 5.0 - added variable to capture value of eRx Type filter value.
	var eRxTypeFilter = dojo.byId('erxTypeSelection');
    var eRxselected = getSelected(eRxTypeFilter);
	
	if(startDate!=null)
	{	
	
	
		
	  startDate.constraints.max = new Date();
	}
	
	if(endDate!=null)
	{	
		
		endDate.constraints.max = new Date();
	}
		
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
	
    showModalWin();    
	
	buildGridDataSource("/inbound/inb-erx/"  + "erxSummaryReport/getReport?json=" + dojo.toJson(formObject),erxSummaryReportDataGridInit,"summaryReport" );
	
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
	hideModalWin();
	
	return true;
}



function setYesterdaysDefaultDate() {
	
	var startDate = dijit.byId('dateFrom');
	
	var yesterdayDate = new Date(); 
	  
	yesterdayDate.setDate(yesterdayDate.getDate() - 1);	
	
	startDate.set("value", yesterdayDate);
	
}

function validateDates(startDateVal, endDateVal) {
    
	var compareValue = 0;
	
	// earliest date is June 1 2017 When Inbound eRx rolled out.
	var earlyStartDate = new Date(); 
	earlyStartDate.setFullYear(2017);
	earlyStartDate.setMonth(5); // 0 is January, 5 is June
	earlyStartDate.setDate(1);
	earlyStartDate.setHours(0,0,0,0); // set to midnight.
	
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

function showModalWin() {
	
	 reportsLoadingDialog = new dijit.Dialog({	            
	        title: "Search Status",
			content: "Search in progress, please wait...",
	        style: "width: 230px;height:60px;font-size: 14px;text-align: left;",
	        draggable: false,
	        closable: false,
	        onHide: function(){
	        	reportsLoadingDialog.destroy()
	        }
	        
	    });
	    
	    	
	 reportsLoadingDialog.show();
	
}

function hideModalWin() {

	setTimeout(function(){ reportsLoadingDialog.hide(); }, 1000);
}
	


function showCSVModalWin() {
	
	 reportsLoadingDialog = new dijit.Dialog({	            
	        title: "Export Status",
			content: "Export in progress, please wait...",
	        style: "width: 230px;height:60px;font-size: 14px;text-align: left;",
	        draggable: false,
	        closable: false,
	        onHide: function(){
	        	reportsLoadingDialog.destroy()
	        }
	        
	    });
	    
	    	
	 reportsLoadingDialog.show();
	
}

function hideCSVModalWin() {

	setTimeout(function(){ reportsLoadingDialog.hide(); }, 5000);
}



