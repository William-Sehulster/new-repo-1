dojo.require("dojo.hash");
dojo.require("dijit.registry");
dojo.require("dojo.date");

function scrollFunction() {
	var topGrid = null;
	var bottomGrid = document.getElementById("summaryReportTotals");
    var scrollGrid = document.getElementsByClassName("dojoxGridScrollbox");	
    
	topGrid0 = scrollGrid[0];
    if (topGrid0 != null){
        topGrid0.scrollLeft = bottomGrid.scrollLeft;}
    topGrid1 = scrollGrid[1];
    if (topGrid1 != null){
        topGrid1.scrollLeft = bottomGrid.scrollLeft;}
    topGrid2 = scrollGrid[2];
    if (topGrid2 != null){
        topGrid2.scrollLeft = bottomGrid.scrollLeft;}
    topGrid3 = scrollGrid[3];
    if (topGrid3 != null){
        topGrid3.scrollLeft = bottomGrid.scrollLeft;}
}

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
				
				getStationIdSelect();
				toggleDivs(selected);
				
//			  	scrollGrid = document.getElementsByClassName("dojoxGridScrollbox");	
//			  	
//			  	topGrid0 = scrollGrid[0];
//			    if (topGrid0 != null){
//			    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//			    topGrid1 = scrollGrid[1];
//			    if (topGrid1 != null){
//			    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//			    topGrid2 = scrollGrid[2];
//			    if (topGrid2 != null){
//			    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//			    topGrid3 = scrollGrid[3];
//			    if (topGrid3 != null){
//			    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//			    
			    //topGrid = scrollGrid[0];
			   // if (topGrid != null){
			   // 	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar

//				bottomGrid = document.getElementById("summaryReportTotals");
//			    if (bottomGrid != null){
//			    	bottomGrid.addEventListener("scroll", scrollFunction);}
			}
			
		}
		else if (selected == "AUTOCHECKRPT") {

			var valid = getAutoCheckReport();
			
			if(valid == true){
				
				getStationIdSelect();
				toggleDivs(selected);
			}
//		    scrollGrid = document.getElementsByClassName("dojoxGridScrollbox");	
//		    topGrid = scrollGrid[1];
//		    if (topGrid != null){
//		    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//
//			bottomGrid = document.getElementById("summaryReportTotals");
//		    if (bottomGrid != null){
//		    	bottomGrid.addEventListener("scroll", scrollFunction);}
			
		}
		else if (selected == "REJECTRESNRPT") {

			var valid = getRejectReasonsReport();
			
			if(valid == true){
				
				getStationIdSelect();
				toggleDivs(selected);
			}
//		    scrollGrid = document.getElementsByClassName("dojoxGridScrollbox");	
//		    topGrid = scrollGrid[2];
//		    if (topGrid != null){
//		    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//
//			bottomGrid = document.getElementById("summaryReportTotals");
//		    if (bottomGrid != null){
//		    	bottomGrid.addEventListener("scroll", scrollFunction);}
		}
		else if (selected == "ERXSUMMRPT") {

			var valid = getErxSummaryReport();
			
			if(valid == true){
				
				getStationIdSelect();
				toggleDivs(selected);
			}
//		    scrollGrid = document.getElementsByClassName("dojoxGridScrollbox");	
//		    topGrid = scrollGrid[3];
//		    if (topGrid != null){
//		    	topGrid.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
//
//			bottomGrid = document.getElementById("summaryReportTotals");
//		    if (bottomGrid != null){
//		    	bottomGrid.addEventListener("scroll", scrollFunction);}
			
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
	
	// onload and for first time only set the default dates.
	if(neweRxSummaryReportDefaultDate == false){
	
		setYesterdaysDefaultDate();
		neweRxSummaryReportDefaultDate = true;
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
			summaryReportDataGridInit("inb-erx","summaryReport", "summaryReport/getSummary?json=" + dojo.toJson(formObject) );
			buildSummaryReportTotalsGrid("summaryReportTotals");
			dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
		}
		if (selected == "AUTOCHECKRPT") {
			var valid = getAutoCheckReport();
			
			if(valid == true){
				
				getStationIdSelect();
				toggleDivs(selected);
			}
	
		}
		if (selected == "REJECTRESNRPT") {
			var valid = getRejectReasonsReport();
			
			if(valid == true){
				getStationIdSelect();
				toggleDivs(selected);
				
			}
			
		}
		if (selected == "ERXSUMMRPT") {
			var valid = getErxSummaryReport();
			
			if(valid == true){			
				getStationIdSelect();
				toggleDivs(selected);
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

	 

function toggleDivs(selected){

    
  if( selected == "SUMMRPT"){
	  dojo.style(dojo.byId('summaryReportFilter'), "display", "block");
      dojo.style(dojo.byId('summaryReport'), "display", "block"); 
      dojo.style(dojo.byId('summaryReportTotals'), "display", "block");
      dojo.style(dojo.byId('summaryReportGrid'), "display", "block");

      if (dojo.byId('summaryReportGrid2') != null){
      dojo.style(dojo.byId('summaryReportGrid2'), "display", "none");
      }
      if (dojo.byId('summaryReportGrid3') != null){
          dojo.style(dojo.byId('summaryReportGrid3'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid4') != null){
          dojo.style(dojo.byId('summaryReportGrid4'), "display", "none");
          }
  } else if ( selected == "AUTOCHECKRPT") {
      dojo.style(dojo.byId('summaryReportFilter'), "display", "block");
      dojo.style(dojo.byId('summaryReport'), "display", "block");
      dojo.style(dojo.byId('summaryReportTotals'), "display", "block");
      if (dojo.byId('summaryReportGrid') != null){
          dojo.style(dojo.byId('summaryReportGrid'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid3') != null){
          dojo.style(dojo.byId('summaryReportGrid3'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid4') != null){
          dojo.style(dojo.byId('summaryReportGrid4'), "display", "none");
          }
      
      if (dojo.byId('summaryReportGrid2') != null){
    	
    	  dojo.style(dojo.byId('summaryReportGrid2'), "display", "block");
      }
      
      
  } else if ( selected == "REJECTRESNRPT") {
      dojo.style(dojo.byId('summaryReportFilter'), "display", "block");
      dojo.style(dojo.byId('summaryReport'), "display", "block");
      dojo.style(dojo.byId('summaryReportTotals'), "display", "block");
      if (dojo.byId('summaryReportGrid') != null){
          dojo.style(dojo.byId('summaryReportGrid'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid2') != null){
          dojo.style(dojo.byId('summaryReportGrid2'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid4') != null){
          dojo.style(dojo.byId('summaryReportGrid4'), "display", "none");
          }
      
      if (dojo.byId('summaryReportGrid3') != null){
      	
    	  dojo.style(dojo.byId('summaryReportGrid3'), "display", "block");
      }
      
     
  } else if ( selected == "ERXSUMMRPT") {
      dojo.style(dojo.byId('summaryReportFilter'), "display", "block");
      dojo.style(dojo.byId('summaryReport'), "display", "block");
      dojo.style(dojo.byId('summaryReportTotals'), "display", "block");
      if (dojo.byId('summaryReportGrid') != null){
          dojo.style(dojo.byId('summaryReportGrid'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid2') != null){
          dojo.style(dojo.byId('summaryReportGrid2'), "display", "none");
          }
      if (dojo.byId('summaryReportGrid3') != null){
          dojo.style(dojo.byId('summaryReportGrid3'), "display", "none");
          }
      
      if (dojo.byId('summaryReportGrid4') != null){
        	
    	  dojo.style(dojo.byId('summaryReportGrid4'), "display", "block");
      }
      
     
  } else {
      dojo.style(dojo.byId('summaryReportFilter'), "display", "none");
      dojo.style(dojo.byId('summaryReport'), "display", "none");
      dojo.style(dojo.byId('summaryReportTotals'), "display", "none");
  }
  
  scrollGrid = document.getElementsByClassName("dojoxGridScrollbox");	
	
	topGrid0 = scrollGrid[0];
  if (topGrid0 != null){
  	topGrid0.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
  topGrid1 = scrollGrid[1];
  if (topGrid1 != null){
  	topGrid1.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
  topGrid2 = scrollGrid[2];
  if (topGrid2 != null){
  	topGrid2.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
  topGrid3 = scrollGrid[3];
  if (topGrid3 != null){
  	topGrid3.style.padding = '0 0 1.4em 0';} //overlap and hide topGrid horizontal scrollbar
  
	bottomGrid = document.getElementById("summaryReportTotals");
  if (bottomGrid != null){
  	bottomGrid.addEventListener("scroll", scrollFunction);}
  
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
	
	var getCSVUrl ="/inbound/inb-erx/summaryReport/getSummaryReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}

function getAutoCheckReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	
	var getCSVUrl ="/inbound/inb-erx/autoCheckReport/getReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}

function getRejectReasonsReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	
	var getCSVUrl ="/inbound/inb-erx/rejectReasonsReport/getReportCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;	
}

function getErxSummaryReportCSV() {
	var formId = "summaryReportForm";
	var formObject = dojo.formToObject(formId);
	
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
	 
	 // reset Totals
	 
	 var newStore = new  dojo.data.ItemFileReadStore({data: {  identifier: "",  items: []}}); // clears the Grid
	 
	 if (dojo.byId('summaryReportGrid') != null){
		 var reportGrid = dijit.byId('summaryReportGrid'); 
			
		 reportGrid.set("noDataMessage","")
		 
		 reportGrid.selection.clear();
		 reportGrid.setStore(newStore);
		 reportGrid.startup();
		 resetReportTotalsGrid("summaryReportTotals");
			
	 }
	 
	 if (dojo.byId('summaryReportGrid2') != null){
		 var reportGrid = dijit.byId('summaryReportGrid2'); 
			
		 reportGrid.set("noDataMessage","")
		 
		 reportGrid.selection.clear();
		 reportGrid.setStore(newStore);
		 reportGrid.startup();
		 resetReportTotalsGrid("summaryReportTotals");
	 }
	 
	 if (dojo.byId('summaryReportGrid3') != null){
		 var reportGrid = dijit.byId('summaryReportGrid3'); 
			
		 reportGrid.set("noDataMessage","")
		 
		 reportGrid.selection.clear();
		 reportGrid.setStore(newStore);
		 reportGrid.startup();
		 resetReportTotalsGrid("summaryReportTotals");

	 }
	 
	 if (dojo.byId('summaryReportGrid4') != null){
		 var reportGrid = dijit.byId('summaryReportGrid4'); 
			
		 reportGrid.set("noDataMessage","")
		 
		 reportGrid.selection.clear();
		 reportGrid.setStore(newStore);
		 reportGrid.startup();
		 resetReportTotalsGrid("summaryReportTotals");

	 }
	 	 
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
	
	
	// onload and for first time only set the default dates.
	if(rejectReportDefaultDate == false){
	
		setYesterdaysDefaultDate();
		rejectReportDefaultDate = true;
	}
	
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
	rejectReasonsReportDataGridInit("inb-erx","summaryReport", "rejectReasonsReport/getReport?json=" + dojo.toJson(formObject) );
	buildRejectReasonsReportTotalsGrid("summaryReportTotals");
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
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
	
	// onload and for first time only set the default dates.
	if(autoCheckReportDefaultDate == false){
	
		setYesterdaysDefaultDate();
		autoCheckReportDefaultDate = true;
	}
	
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
	autoCheckReportDataGridInit("inb-erx","summaryReport", "autoCheckReport/getReport?json=" + dojo.toJson(formObject) );
	buildAutoCheckReportTotalsGrid("summaryReportTotals");
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
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
	
	// onload and for first time only set the default dates.
	if(summaryReportDefaultDate == false){
	
		setYesterdaysDefaultDate();
		summaryReportDefaultDate = true;
	}
	
	//validate Dates
    if(startDate!=null && endDate!=null){
		
		validation = validateDates(startDate.get("value"), endDate.get("value"));
		
		if(validation == false){
			return false;
		}
		
	}
	
	
	erxSummaryReportDataGridInit("inb-erx","summaryReport", "erxSummaryReport/getReport?json=" + dojo.toJson(formObject) );
	buildErxSummaryReportTotalsGrid("summaryReportTotals");
	dojo.byId("reportRunDateTime").innerHTML = "Report as of:  " + getCurrentDateTimeForDisplay();
	
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


