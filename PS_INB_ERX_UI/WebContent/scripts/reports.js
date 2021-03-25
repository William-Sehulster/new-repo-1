dojo.require("dojo.hash");
dojo.require("dijit.registry");
dojo.require("dojo.date");
dojo.require("dijit.Dialog");
dojo.require("dojo.Deferred");
dojo.require("dojo.parser");

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
	
	
	
	
	dojo.connect(selectBox, "onchange", null, function(event) {
		selected = getSelected(selectBox);
		
		if (selected == "SUMMRPT") {

			var valid = getSummaryReport();
			
			if(valid == true){
				
				toggleDivs();						
				
			}
			
		}
		else if (selected == "AUTOCHECKRPT") {

			var valid = getAutoCheckReport();	
			
			if(valid == true){
				
				toggleDivs();				
				
			}

			
		}
		else if (selected == "REJECTRESNRPT") {

			var valid = getRejectReasonsReport();
			
			if(valid == true){
				
				toggleDivs();			
				
			}

		}
		else if (selected == "ERXSUMMRPT") {

			var valid = getErxSummaryReport();
			
			if(valid == true){
				
				toggleDivs();
				
				
			}

			
		}
		else{
			toggleDivs();
		}
		
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
	
		
		
		if (selected == "SUMMRPT") {
			showModalWin();
			
			
			buildGridDataSource("/inbound/inb-erx/"  + "summaryReport/getSummary?json=" + dojo.toJson(formObject),summaryReportDataGridInit,"summaryReport" );			
			
			dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
			
			hideModalWin();			
			
			toggleDivs();	
			
			
		}
		if (selected == "AUTOCHECKRPT") {
			var valid = getAutoCheckReport();
			
			if(valid == true){
				toggleDivs();			
				
			}
	
		}
		if (selected == "REJECTRESNRPT") {
			
			var valid = getRejectReasonsReport();
			
			if(valid == true){
				toggleDivs();	
				
				
			}
			
		}
		if (selected == "ERXSUMMRPT") {
			var valid = getErxSummaryReport();
			
			if(valid == true){			
				toggleDivs();
				
				
			}
			
		}
		
		
				
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



