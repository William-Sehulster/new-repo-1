dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojo.dom-construct");
dojo.require("dojo.data.ItemFileWriteStore");
dojo.require("dojox.grid.cells.dijit");
dojo.require("dojox.grid.enhanced.plugins.NestedSorting");
dojo.require("dojo._base.event");
dojo.require("dojo.keys");
dojo.require("dojo.query");

function onKeyEvent(event) {
	return true;
}


function createLink(entry) {
	if (entry == null || entry == "null" || entry == "") {
		return "";
	}
	
	var newEntry= "/inbound/inb-erx/managePharm/editPharmacy/"+entry;
	return "<a href=\"" + encodeURI(newEntry) + "\" >" + entry	+ "</a>";
};

function buildPharmacyGridLayout(servlet, target) {
	var layout = new Array();
	
	var obj = new Object();
	obj["field"] = 'visn';
	obj["name"] = 'VISN';
	obj["width"] = "60px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	var obj = new Object();
	obj["field"] = 'vaStationId';
	obj["name"] = 'VA Station ID';
	obj["width"] = "100px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'ncpdpId';
	obj["name"] = 'NCPDP ID';
	obj["width"] = "90px";
	//obj["noresize"] = 'true';
	obj["formatter"] = createLink;
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'storeName';
	obj["name"] = 'Pharmacy Name (Published)';
	obj["width"] = "250px";
	//obj["noresize"] = 'true';
	layout.push(obj);
	
	var obj = new Object();
	obj["field"] = 'divisionName';
	obj["name"] = 'Pharmacy Name (Internal)';
	obj["width"] = "250px";
	//obj["noresize"] = 'true';
	layout.push(obj);

	obj = new Object();
	obj["field"] = 'pharmacyAddressLine1';
	obj["name"] = 'Address';
	obj["width"] = '250px';
//	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
//	obj = new Object();
//	obj["field"] = 'pharmacyAddressLine2';
//	obj["name"] = 'Address Line 2';
//	obj["width"] = '250px';
//	obj["noresize"] = 'true';
	//obj["formatter"] = formatSelectable;
//	layout.push(obj);


	obj = new Object();
	obj["field"] = 'pharmacyCity';
	obj["name"] = "City";
	obj["width"] = '112px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyState';
	obj["name"] = "State";
	obj["width"] = '60px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'pharmacyPhoneNumber';
	obj["name"] = "Phone Number";
	obj["width"] = '120px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	obj = new Object();
	obj["field"] = 'inboundErxEnabled';
	obj["name"] = "eRx Enabled?";
	obj["width"] = '120px';
	//obj["noresize"] = 'false';
	//obj["formatter"] = formatSelectable;
	layout.push(obj);
	
	return layout;
}




function pharmacyDataGridInit(servlet, parentContainer, responseData) {
	try {
		var gridData = new dojo.data.ItemFileWriteStore({data: {items : responseData.items}} );
			
		var gridId = parentContainer + 'Grid';
		
		var grid = dijit.byId(gridId);
		
		var pharmRecNumberTitle = dojo.byId("pharmMgmtRecNumberTitle");
		
		var pharmRecNumber = dojo.byId("pharmMgmtRecNumber");
		
		
		if(pharmRecNumberTitle!=null){				 
			 
			pharmRecNumberTitle.style.display="block";
				
        }
		
		if(pharmRecNumber!=null){				 
			 
			pharmRecNumber.style.display="block";
				
			pharmRecNumber.innerHTML= responseData.items.length;
       }
		
			

		// If the DataGrid already exists, just clear any selected rows and
		// replace the store.
		if (grid != null) {
			if (grid.selection != null) {
				grid.selection.clear();
			}
			grid.setStore(gridData);
				
		} else {
			// DataGrid does not exist.
			var gridLayout = buildPharmacyGridLayout(servlet, parentContainer);
			grid = new dojox.grid.EnhancedGrid({
				id : gridId,
				showTitle : true,
				columnReordering : false,
				loadingMessage : "Query In Progress...",
				noDataMessage : "Your Query Returned No Results",
				onFetchError : gridFetchError,
				selectable : true,
				selectionMode : 'single',				
				canSort : function(index) {
					return true;
				},
				plugins : {nestedSorting: false,indirectSelection: false}				
			}, document.createElement('div'));
			dojo.byId(parentContainer).appendChild(grid.domNode);
			
			grid.setStore(gridData);
			
			grid.setStructure(gridLayout);
			
			//grid.canSort = function(){return false};  //turn off sorting for now
			
			grid.startup();
			
			dojo.connect(grid, "onKeyDown", function(e) {
				
				switch(e.keyCode){
				case dojo.keys.ENTER:
				case dojo.keys.SPACE:
					
					var gridItem = grid.getItem(e.rowIndex);
					
					var cell = grid.getCell(e.cellIndex);
					
					var node = e.cellNode;
					
					// JAWS reads column with respect to their index numbers, since they start out with 0, so this is comment out for now.
					//var columnInfo = 'Column ' + (cell.index + 1) + ' ' + cell.name;
					
					var columnInfo = cell.name;
					
					var sortedColumnUp = dojo.query('.dojoxGridSortUp');
					
					var sortedColumnDown = dojo.query('.dojoxGridSortDown');
					
					var sortedInfo;
					
					
					if( sortedColumnUp !=undefined && sortedColumnUp.length>0) { 
						
						sortedInfo = columnInfo + ' is sorted in ascending order. ';
					}
					
					else if(sortedColumnDown !=undefined && sortedColumnDown.length>0){
						
						
						sortedInfo = columnInfo + ' is sorted in descending order. ';
						
					}
					
					var sortedColumn = dojo.query('.dojoxGridColCaption')[0];
					
					sortedColumn.setAttribute("aria-label", sortedInfo);
					
					//console.dir(grid.getSortProps());
			}
				
				dojo.stopEvent(e);
			});
			
			
		}
	} catch (err) {
		var txt = "An error occured while building the dataGrid.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

};


