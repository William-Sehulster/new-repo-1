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
	
	return "<a class=\"generatedDivTableCellLink\" href=\"" + encodeURI(newEntry) + "\" onkeyup=gotoEditPharm(event,\"" + newEntry+ "\"); id=\""+entry+"\">" + entry	+ "</a>";
}


function gotoEditPharm(evt, elementId) {
	var elementEventKey = evt.keyCode || evt.which;	
	if(elementEventKey ==13)
	{	
	 document.getElementById(elementId).click();
	}
}


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
		
					
		    // get table / grid layout.			
			var gridLayout = buildPharmacyGridLayout(servlet, parentContainer);
			
			// we do need to setup a dummy grid, in order for the datastore to work properly.          
			
			if (grid != null) {
			if (grid.selection != null) {
				grid.selection.clear();
			}
			grid.setStore(gridData);
				
		} else {
			
			// create dummy grid so that item file store works.
			grid = new dojox.grid.DataGrid({
				id : gridId								
			});
			
						
			grid.setStore(gridData);			
			
			
		}	
			// generate the table.
			generateDivTable(gridLayout,gridData,parentContainer);
			
			dojo.style(dojo.byId('pharmacyList'), "display", "block");	
			
			// remove the grid widget
			 dojo.destroy(grid);
		
	} catch (err) {
		var txt = "An error occured while building the results.  The error is: "
				+ err.message + ".";
		alert(txt);
	}

}

// sorting functions.

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
function generateDivTable(layout, gridData, dataGridDivId) {

	    // clear the parent div first.
        dojo.byId(dataGridDivId).innerHTML ="";

		var rowCounter = 1; 
		var recordCounter = 0;
		
		var elementWidthArray = [];
		
		var elementFormatterArray = [];
		
		//variable for aria label
		var divTableStart = "<div class=\"generatedDivTable\" id=\"generatedDivTableID\" tabindex=\"0\" role=\"table\" aria-label=\"Pharmacies\ Table\" aria-describedby=\"divTableInfo\">";
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
			
		for(var arrayElement in storeArray){			
			
			
			var arrayItem  = storeArray[arrayElement];
			
			for (var k in arrayItem)
			{
				if((arrayItem[k]!='') && (k=='stringArray'))
				{
			 	
				 
				 tempStringArray = arrayItem[k];
				 
				 rowCounterString = divTableResultRowStart + "aria-describedby=\"Row" +" " + rowCounter+"\">";
				 
				 divTable = divTable.concat(rowCounterString);
				
                 for (var s in tempStringArray)
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
					   divTable = divTable.concat(rowCellValue);
					 }
                     					 
					 
								
					 divTable = divTable.concat(divTableRowCellEnd);
				 }
				
				 rowCounter++;
				 recordCounter++;
								
			 	 divTable = divTable.concat(divTableResultRowEnd);
				 
				 
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


