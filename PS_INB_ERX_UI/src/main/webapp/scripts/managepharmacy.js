dojo.require("dojo.hash");
dojo.require("dijit.registry");
dojo.require("dijit._base.wai");

dojo.require("dojo._base.array");

var clearClicked = false;

// defect 792109 fix.
dojo.addOnLoad(function() {
	
	var path = location.pathname;
	
	if (path.match("addNewPharmacy") != null) 
	{
		var url = "/inbound/inb-erx/managePharm/main";
		
		location.href = url;
    } 
	
	
});

require(["dijit/Tooltip", "dojo/domReady!"], function(Tooltip){
    new Tooltip({
        connectId: ["pharmacyFilterFormStationIdSelect"],
        label: "Please select VISN before selecting Station ID."
    });
});

function getPharmacyGrid() {
	var formId = "pharmacyFilterForm";
	var formObject = dojo.formToObject(formId);
	
	dojo.style(dojo.byId('pharmMgmtRecNumberTitle'), "display", "block");
	dojo.style(dojo.byId('pharmMgmtRecNumber'), "display", "block");
	
	var dataSourceURL = "/inbound/inb-erx/managePharm/getPharmacyList?json=" + dojo.toJson(formObject);
	
	try {
		 
		dojo.xhrGet({
	        url: dataSourceURL,
	        handleAs: "json", 
	        load: function(data, ioArgs) {
	        	pharmacyDataGridInit("inb-erx","pharmacyList",  data);	           
	        },
	        error: function(error) {
	            console.log("loading of pharmacy data failed. Exception...", error);
	        }
	    });		
		
		dojo.style(dojo.byId('pharmacyListDummy'), "display", "none");
		dojo.style(dojo.byId('pharmacyList'), "display", "block");
		
		
	} catch (err) {
		alert(err.message);
	}
	
	dojo.hash("");
}


function buildVisnSelectDataSource(dataSourceURL, query) {
	try {
		var dataSource = new dojox.data.JsonQueryRestStore({
			target : dataSourceURL,
			idAttribute : "id"
		});		
		return dataSource;
	} catch (err) {
		alert(err.message);
	}
}


function pharmManagementSearch() {
	
	getPharmacyGrid();
	
	 
}

function clearPharmSearch() {
	
	var pharmVisnSelect = dojo.byId("pharmacyFilterFormVisnSelect");
	
	var pharmStationSelect = dojo.byId("pharmacyFilterFormStationIdSelect");
	
	
	pharmVisnSelect.selectedIndex = 0;
	
	pharmStationSelect.selectedIndex = 0;
	
	dojo.style(dojo.byId('pharmacyList'), "display", "none");
	dojo.style(dojo.byId('pharmacyListDummy'), "display", "block");
	dojo.style(dojo.byId('pharmMgmtRecNumberTitle'), "display", "none");
	dojo.style(dojo.byId('pharmMgmtRecNumber'), "display", "none");
	
	if (dojo.byId('pharmacyManagementSuccessMessages') != null){
		 
		dojo.byId('pharmacyManagementSuccessMessages').innerHTML ="";
	}
	
	
	
	dojo.byId('ncpdpId').value="";
	dojo.byId('pharmacyName').value="";
	
	 
}

function exportPharmSearchResults() {
	
	var formId = "pharmacyFilterForm";
	var formObject = dojo.formToObject(formId);
	
	var getCSVUrl ="/inbound/inb-erx/managePharm/getPharmacyListCSV?json=" + dojo.toJson(formObject);
	location.href= getCSVUrl;
	 
}

function getPharmStationIdSelect(VisnOption) {
	
	var visn = VisnOption.options[VisnOption.selectedIndex].value;
	
	var select = dojo.byId("pharmacyFilterFormStationIdSelect");
	
	var counter = select.options.length;
	
	while(counter--){
		
		select.remove(counter);		
	}
	
	var xhrArgs = {
			url : "/inbound/inb-erx/managePharm/getStationIdsForSelect?visn=" + visn,
			handleAs : "json",
			load : function(data) {
				dojo.forEach(data, function(item) {
					
					
					var option = new Option();
					option.value = item.id;
					option.text = item.label;
					select.add(option);		
					
					
				});
			}

		};
	
	dojo.xhrGet(xhrArgs);
}




function pharmacyManagementActions(buttonId) {

	if(buttonId==null && clearClicked == false){
		
		return false;
	}
	
	else if(buttonId == "pharmSearchClearButton"){
		
	 clearPharmSearch();
	 
	 clearClicked = true;
	 
	 return false;
	 
	}
	
	else if(buttonId == "pharmManagementExportButton"){
		exportPharmSearchResults();
		
		clearClicked = false;
		
		return false;
	}
	
	else if( buttonId =="newPharmAddButton"){
		
		
		document.pharmacyFilterForm.action="/inbound/inb-erx/managePharm/addPharmacy";
		
		document.pharmacyFilterForm.submit();
						
		clearClicked = false;
		
		return true;
	}
	
    else if( buttonId =="pharmSearchButton"){
		
    	pharmManagementSearch();
		
		clearClicked = false;
		
		return true; 
	}
	
	else{

		return false;
	}
}	



