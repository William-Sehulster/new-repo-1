dojo.require("dojo.hash");
dojo.require("dijit.registry")

dojo.addOnLoad(function() {
	dojo.style(dojo.byId('summaryReport'), "display", "none");
    dojo.style(dojo.byId('summaryReportFilter'), "display", "none");
    

});



dojo.ready(function() {
	var selectBox = dojo.byId("reportSelection");
	var selected = null;
	
	dojo.connect(selectBox, "onchange", null, function(event) {
		selected = getSelected(selectBox);
		
		if (selected == "SUMMRPT") {	
			getSummaryReport();
			getStationIdSelect();
			toggleDivs(selected);				
		}
		if (selected == "DETLRPT") {
			toggleDivs(selected);
		}
		else{
			toggleDivs(selected);
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
	
	summaryReportDataGridInit("inb-erx","summaryReport", "summaryReport/getSummary?json=" + dojo.toJson(formObject) );
	buildSummaryReportTotalsGrid("summaryReportTotals");
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
	
	
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

	 

function toggleDivs(selected){
  if( selected == "SUMMRPT"){
	  dojo.style(dojo.byId('summaryReportFilter'), "display", "block");
      dojo.style(dojo.byId('summaryReport'), "display", "block"); 
      dojo.style(dojo.byId('summaryReportTotals'), "display", "block");
  } else {
      dojo.style(dojo.byId('summaryReportFilter'), "display", "none");
      dojo.style(dojo.byId('summaryReport'), "display", "none");
      dojo.style(dojo.byId('summaryReportTotals'), "display", "none");
  }
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


function getSummaryReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	
	var getCSVUrl ="/inbound/inb-erx/summaryReport/getSummaryReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;
	
}


function csvResponse(){
	
	 return;
}

