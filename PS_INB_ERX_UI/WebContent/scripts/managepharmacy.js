dojo.require("dojo.hash");
dojo.require("dijit.registry")

dojo.addOnLoad(function() {
    
	getPharmacyGrid();
});


function getPharmacyGrid() {
	var formId = "pharmacyFilterForm";
	var formObject = dojo.formToObject(formId);
	
	//console.log("inside getPharmacyGrid");
	
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
		
		
	} catch (err) {
		alert(err.message);
	}
	
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

function getPharmVisnSelect(servlet, parentContainer, dataSourceURL) {
	try {
		var selectData = buildVisnSelectDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
		var selectId = parentContainer + 'Select';
		
		var select = dijit.byId(selectId);

		// If the select already exists, just clear any selected rows and
		// replace the store.
		if (select != null) {
			if (select.selection != null) {
				select.selection.clear();
			}
			select.setStore(selectData);
				
		} else {
			// select does not exist.
			select = new dijit.form.Select({
				id : selectId,
				name: "visn",
				style: "width:40px;",
				sortByLabel : false,
				onFetchError : gridFetchError
			}, "visnSelect");
		
			select.setStore(selectData);
			
			select.on('change', function(evt) {		
				getPharmacyGrid();
				    });
			
			select.startup();
			
		}
	} catch (err) {
		var txt = "An error occured while building the selectList.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};


