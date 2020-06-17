dojo.require("dijit.form.Select");
dojo.require("dojo.parser");
dojo.require("dojo.dom-construct");



function buildSelectDataSource(dataSourceURL, query) {
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

function summaryReportSelectInit(servlet, parentContainer, dataSourceURL) {
	try {
		var selectData = buildSelectDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
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
				name: "stationId",
				style: "width:60px;",
				onFetchError : gridFetchError
			}, "summaryReportFormSelect");
		
			select.setStore(selectData);
			
				
			select.startup();
			
		}
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

}


function visnSelectInit(servlet, parentContainer, dataSourceURL) {
	try {
		var selectData = buildSelectDataSource("/inbound/" + servlet + "/" + dataSourceURL);
			
		var selectId = parentContainer + 'VisnSelect';
		
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
			}, "summaryReportFormVisnSelect");
		
			select.setStore(selectData);
			
				select.on('change', function(evt) {
					    	//alert('myselect_event');
					    	getStationIdSelect(summaryReportForm.visn);
					    });
			
			select.startup();
			
		}
	} catch (err) {
		var txt = "An error occured while building the selectList.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

}


