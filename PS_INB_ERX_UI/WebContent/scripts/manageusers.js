dojo.require("dijit.form.DateTextBox");
dojo.require("dojo.hash");
dojo.require("dijit.registry")
dojo.require("dojo.parser");
dojo.require("dijit.form.Select");

dojo.require("dijit.form.FilteringSelect");
dojo.require("dijit.Dialog");


var gridFinal = null;
var dataStoreFinal = null;
var modifiedIds = new Array();
var tempArray =  new Array();
var tempEnableDisablelSelectArray =  new Array();
var enableDisableSelectIds =  new Array();


//for values.
var modifiedValues = new Array();
var tempValuesArray =  new Array();


//for station ids modified values.
var modifiedStationIdsValues = new Array();
var tempModifiedStationIdsValuesArray =  new Array();

dojo.addOnLoad(function() {
	    
	UM_loadPage();
	
});



function checkboxModified(element, value) {
	
	var key = element;
	var tempKey = element+"^"+value;
	
	if(value == true){
	  
		var index = dojo.indexOf(modifiedIds,key);
		var tempKeyIndex = dojo.indexOf(modifiedIds,key);
		
		
	    if(index== -1){
	    	
	    	modifiedIds.push(key);
	    	tempArray.push(tempKey);
	    }
	    else{
	    	modifiedIds.splice(index,1);
	    	tempArray.splice(tempKeyIndex,1);
	    	
	    }
    }
	else if(value == false){
		
		var index = dojo.indexOf(modifiedIds,key);
		var tempKeyIndex = dojo.indexOf(modifiedIds,key);
		
		
		if(index > -1){
			modifiedIds.splice(index,1);
			tempArray.splice(tempKeyIndex,1);
		}
		else{
			modifiedIds.push(key);
			tempArray.push(tempKey);
		}
	}
	
}



function EnableDisableCheckboxModified(element, value) {
	
	var key = element;
	var tempKey = element+"^"+value;
	
	if(value == true){
	  
		var index = dojo.indexOf(enableDisableSelectIds,key);
		var tempKeyIndex = dojo.indexOf(enableDisableSelectIds,key);
		
		
	    if(index== -1){
	    	
	    	enableDisableSelectIds.push(key);
	    	tempEnableDisablelSelectArray.push(tempKey);
	    }
	    else{
	    	enableDisableSelectIds.splice(index,1);
	    	tempEnableDisablelSelectArray.splice(tempKeyIndex,1);
	    	
	    }
    }
	else if(value == false){
		
		var index = dojo.indexOf(enableDisableSelectIds,key);
		var tempKeyIndex = dojo.indexOf(enableDisableSelectIds,key);
		
		
		if(index > -1){
			enableDisableSelectIds.splice(index,1);
			tempEnableDisablelSelectArray.splice(tempKeyIndex,1);
		}
		else{
			enableDisableSelectIds.push(key);
			tempEnableDisablelSelectArray.push(tempKey);
		}
	}
	
}





function UM_loadPage(){
	
	
   focusOnError();
	
	resetUserManagementFields();
	
}



function UM_ValuesModified(element, value) {
	
	var key = element;
	var tempKey = element+"^"+value;
	
	var index = dojo.indexOf(modifiedValues,key);
	var tempKeyIndex = dojo.indexOf(modifiedValues,key);
		
	if(index== -1){
		    	
		modifiedValues.push(key);
		tempValuesArray.push(tempKey);
	   }
    else
    {
    	modifiedValues.splice(index,1);
    	tempValuesArray.splice(tempKeyIndex,1);
	   	
	     // add new values.
	   	modifiedValues.push(key);
	   	tempValuesArray.push(tempKey);
	    	
	  }
	
	
}


function UM_EnableDisableRows(element, rowCnt, recId, oldIsEnabled) {
	
	
	// disable other row elements for the delete.
	
	if(element.checked == true){
		
		dojo.byId("firstNameRow"+rowCnt).disabled = true;
		dojo.byId("lastNameRow"+rowCnt).disabled = true;
		dojo.byId("userIDRow"+rowCnt).disabled = true;
		//checkboxes
		dojo.byId("pharmManagerRow"+rowCnt).disabled = true;
		dojo.byId("pbmAdminRow"+rowCnt).disabled = true;
		dojo.byId("pharmUserRow"+rowCnt).disabled = true;
		dojo.byId("administratorRow"+rowCnt).disabled = true;
		
		
	}
	else if(element.checked == false && oldIsEnabled == true){
		
		dojo.byId("firstNameRow"+rowCnt).disabled = false;
		dojo.byId("lastNameRow"+rowCnt).disabled = false;
		dojo.byId("userIDRow"+rowCnt).disabled = false;
		//checkboxes
		dojo.byId("pharmManagerRow"+rowCnt).disabled = false;
		dojo.byId("pbmAdminRow"+rowCnt).disabled = false;
		dojo.byId("pharmUserRow"+rowCnt).disabled = false;
		dojo.byId("administratorRow"+rowCnt).disabled = false;
	}
	
	// now add records for deletion.
	
	var elementFinal = element.name +"~"+ recId;
	
	EnableDisableCheckboxModified(elementFinal,element.checked );
	
	
}


function UM_OtherChkBox(element, rowCnt, recId) {
	
	
	var elementFinal = element.name +"~"+ recId;
	
	checkboxModified(elementFinal,element.checked );
	
	
}


function UM_inputValChanged(element, rowCnt, recId){
	
	var inValue = element.value;

	var elementFnal = element.name +"~"+ recId;
	
		// trim whitespace.
		inValue = inValue.trim();
		
		if(inValue.length ==0){
			return;
		}
		
		var firstNameTemp = "firstNameRow"+rowCnt;
		var lastNameTemp = "lastNameRow"+rowCnt;
		var userNameTemp = "userIDRow"+rowCnt;
		
		
		if(element.name == firstNameTemp){
			if(inValue.length > 50){
				
				alert("First Name can't be greater than 50 characters.");
				inValue="";
				return;
			}
			
			if(inValue.length >=1 && inValue.match(/^[a-zA-Z'-\s]+$/i)){
				
				// matches do nothing.
			}
			else{
				alert("First Name should be only alphabetical letters.");
				inValue="";
				 return;
			}
			
		}
		
		else if(element.name == lastNameTemp){
			
            if(inValue.length > 50){
				
            	alert("Last Name can't be greater than 50 characters.");
            	inValue="";
            	 return;
			}
            
            if(inValue.length >=1 && inValue.match(/^[a-zA-Z'-\s]+$/i)){
				
            	// matches do nothing.
			}
			else{
				  alert("Last Name should be only alphabetical letters.");
				  inValue="";
				  return;
			}
			
		}
        else if(element.name == userNameTemp){
        	
           if(inValue.length > 20){
				
        	   alert("User ID can't be greater than 20 characters.");
        	   inValue="";
        	   return;
			}
           
           // no digits only
            if((inValue.length >=1) && (isNaN(inValue) == false)){
            	alert("User ID should be either alphabetical or alphanumeric letters.");
            	inValue="";
            	return;
   			}
           
            //alphabets or alphanumeric ok.
           if(inValue.length >=1 && inValue.match(/^[a-zA-Z0-9]+$/i)){
        	// matches do nothing.
			}
			else{
				  alert("User ID should be either alphabetical or alphanumeric letters.");
				  inValue="";
				  return;
			}
			
		}

       // validation is clear, call this.		
		
		UM_ValuesModified(elementFnal, inValue);
		
	
	
		
}




function focusOnError(){
	
	// if there are errors scroll to the top and  focus on it.
	var errorElement = dojo.byId("errorMessages");
	
	if(errorElement!=null){
	
		errorElement.scrollIntoView();
		errorElement.focus();
		
	}
	
}

function manageUserCancel() {
	
	var url ="/inbound/inb-erx/manageUsers/main";
	location.href= url;
	
}

function resetUserManagementFields(){
	
	var successMessages = dojo.byId("successMessages");
	
	if(successMessages!=null){
		
		var userId = dojo.byId("addUserText");
		var firstName = dojo.byId("addFirstNameText");
		var lastName = dojo.byId("addLastNameText");
		
		if(userId!=null){
			
			dojo.byId("addUserText").value="";
		}
		
		if(firstName!=null){
			dojo.byId("addFirstNameText").value="";
		}
		
		if(lastName!=null){
			dojo.byId("addLastNameText").value="";
		}
		
	}
	
}


function processSubmit() {

	if(confirm("Are you sure you want to save changes?") == true){
		
		var Ids = tempArray.join(",");
		
		dojo.byId("modifiedIds").value = Ids;
		
		var fieldValues =  tempValuesArray.join(",");
		
		dojo.byId("modifiedFields").value = fieldValues; 
		
		var enableDisableValues =  tempEnableDisablelSelectArray.join(",");
		
		dojo.byId("enableDisableRecords").value = enableDisableValues; 
		
		var userId = dojo.byId("addUserText").value;
		
		var firstName = dojo.byId("addFirstNameText").value;
		
		var lastName = dojo.byId("addLastNameText").value;
		
		// validation checks
		
		// userID
		
		if(userId.length >=1)
		{
			
			// no digits only
	        if( (isNaN(userId) == false) ){
	        	alert("User ID should be either alphabetical or alphanumeric letters.");
	        	return false;
			}
		
	        //alphabets or alphanumeric ok.
	        if(userId.match(/^[a-zA-Z0-9]+$/i) ){
	     	// matches do nothing.
	 		}
	 		else{
	 			  alert("User ID should be either alphabetical or alphanumeric letters.");
	 			  return false;
	 		}
	        
		}
       
		// firstName
		if(firstName.length >=1){
			
			//remove whitespaces.
			firstName = firstName.trim();
			
			if(firstName.match(/^[a-zA-Z'-\s]+$/i)){
				
				// matches do nothing.
			}
			else{
				alert("First Name should be only alphabetical letters.");
				 return false;
			}
		}
		
		// lastName
		if(lastName.length >=1){
			
			//remove whitespaces.
			lastName = lastName.trim();
			
			if(lastName.match(/^[a-zA-Z'-\s]+$/i))
			 {
					
	         	// matches do nothing.
			  }
			  else
			  {
				    alert("Last Name should be only alphabetical letters.");
					  
				    return false;
			  }
		}
		 
		
		
		   // get all values of the selected stations
		
		   var selectedStationsSelect = dojo.byId("selectedStationdIds");
		   
		   var tempStationIdsValuesArray =   new Array();
		   
			for(var i=0; i< selectedStationsSelect.options.length; ++i){
				
				
				tempStationIdsValuesArray.push(selectedStationsSelect.options[i].value);
					
				}
			
			var selectedStationIdValues =  tempStationIdsValuesArray.join(",");
					
			dojo.byId("stationIdsSelected").value = selectedStationIdValues; 
			
			// used as separator for multiple values to be split in controller.
			var modifidStationIdValues =  tempModifiedStationIdsValuesArray.join("-");
			
			dojo.byId("modifiedStationIds").value = modifidStationIdValues; 
			
			// check any values are changed or not.
			
			if( (Ids.length == 0 && fieldValues.length == 0 ) && ( enableDisableValues.length == 0 && userId.length == 0 ) &&
					(firstName.length == 0  && lastName.length == 0 )  && (selectedStationIdValues.length == 0	&& modifidStationIdValues.length == 0 )	)				
			{
			
				alert("Unable to save. User must be added or modified.");
				
				return false;
			}		
			
			
		
		return true;
	}
	else{
		
		return false;
	}
	
	
	
}



function stationIdValueSelected(){
	
	//var stationdFilteringSelect  = dijit.byId("addStationId");
	
	//var selectedOptionIDValues = stationdFilteringSelect._getValueAttr();
	
	//var selectedOptionTextalues = stationdFilteringSelect.get('displayedValue');
	
	dijit.byId("manageUsers_AddStationIdsBtn").setAttribute('disabled',false);
	
}



function stationIdValueAddBtn(){
	
    var stationdFilteringSelect  = dojo.byId("addStationId");
	
	var selectedOptionIDValues = [];
	
	
	for(var i=0; i< stationdFilteringSelect.options.length; ++i){
		
		
		if(stationdFilteringSelect.options[i].selected == true){
			
			selectedOptionIDValues.push(stationdFilteringSelect.options[i].value);
			
		}
	
	}
	
	var selectedOptionTextalues = [];
	
	
	for(var i=0; i< stationdFilteringSelect.options.length; ++i){
		
		
		if(stationdFilteringSelect.options[i].selected == true){
			
			selectedOptionTextalues.push(stationdFilteringSelect.options[i].text);
			
		}
	
	}
	
	var selectedStationsSelect = dojo.byId("selectedStationdIds");
	
	for(var i=0; i< selectedStationsSelect.options.length; ++i){
		
		
		for(var k=0; k< selectedOptionTextalues.length; ++k){
			
			if(selectedStationsSelect.options[i].text == selectedOptionTextalues[k]){
				
				alert(selectedStationsSelect.options[i].text +" already exits. Please choose unique value.");
				
				return;
				
			}
			
		}
		
		
		
		for(var j=0; j< selectedOptionIDValues.length; ++j){
			
			// if user tries to add All when other values are already added.
			if( (selectedStationsSelect.options.length > 0) &&  (selectedOptionIDValues[j]=="All")){
				
				alert("You cannot select Station IDs in addition to the \"All\" value.");
				
				return;
				
			}
		}
		
		
		
		// if user tries to add other values, when all is already added.
		if( (selectedStationsSelect.options.length > 0) &&  (selectedStationsSelect.options[i].value=="All")){
			
			alert("You cannot select Station IDs in addition to the \"All\" value.");
			
			return;
			
		}
		
		
	}
	
	
	for(var i=0; i<selectedOptionIDValues.length; i++){
	
		selectedStationsSelect.options[selectedStationsSelect.options.length] = new Option(selectedOptionTextalues[i], selectedOptionIDValues[i], false, false);
	}
	
	
	
	// now sort the select by values (station ids)
	
	if(selectedStationsSelect.options.length > 1){
		
		
		var tempSelectArray = new Array();
		
		var length = selectedStationsSelect.options.length;
		
		for(var i=length-1; i>=0; --i) {
			
			tempSelectArray.push(selectedStationsSelect.options[i]);
		  
			selectedStationsSelect.removeChild(selectedStationsSelect.options[i]);
		}
		
		tempSelectArray.sort(function(o1,o2){
			
			   if(o1.value > o2.value) {
			      return 1;
			   } else if(o1.value < o2.value) {
			      return -1;
			   }
			   return 0;
			});
		
		
			for(var i=0; i<length; ++i) {
				selectedStationsSelect.appendChild(tempSelectArray[i]);
			}
						
	}
	
	
	// disable add button

	dijit.byId("manageUsers_AddStationIdsBtn").setAttribute('disabled',true);
	
		
}


function enableRemoveButton(){
	
	
	dijit.byId("manageUsers_RemoveStationIdsBtn").setAttribute('disabled',false);
    
	
}



function stationIdValueRemoveBtn(){
	
	var selectedStationsSelect = dojo.byId("selectedStationdIds");
	
	var isSelected = [];
	
	
	for(var i=0; i< selectedStationsSelect.options.length; ++i){
		
		
		isSelected[i] = selectedStationsSelect.options[i].selected;
		
		
	}
	
	var counter = selectedStationsSelect.options.length;
	
	while(counter--){
		
		if(isSelected[counter]){
			
			selectedStationsSelect.remove(counter);	
		}
		
	}
	

	if(selectedStationsSelect.options.length ==0){
		
		dijit.byId("manageUsers_RemoveStationIdsBtn").setAttribute('disabled',true);
	}
	
}

function setStationIdUpdateSelect(selectedVals) {

	
	var selectedStationsSelect = dojo.byId("selectedStationdIdsForUpdate");
	
	
	// since we reuse the select, clear out the values.
	
	var updateSelectLength = selectedStationsSelect.options.length;
	
	for(var i=updateSelectLength-1; i>=0; --i) {
		
		selectedStationsSelect.removeChild(selectedStationsSelect.options[i]);
	}
	
	
	
	if(selectedVals ==='All'){
	
		selectedStationsSelect.options[selectedStationsSelect.options.length] = new Option(selectedVals, selectedVals, false, true);
	}
	else{
		
		var selectedStationIdArray = selectedVals.split(',');
		
		var hiddenStationSelect = dojo.byId("hiddenUpdateStationId");
				
		for( var i=0; i<selectedStationIdArray.length;i++){
			
			
			for (var j=0; j<hiddenStationSelect.length;j++){
				if(selectedStationIdArray[i] == hiddenStationSelect.options[j].value){
					
					selectedStationsSelect.options[selectedStationsSelect.options.length] = new Option(hiddenStationSelect.options[j].text, hiddenStationSelect.options[j].value, false, true);
				}
			}
		}
	}
	
}

function createSelectDialog(elementID,stationIdsVals, recId) {
	
	
	var elementFnal = elementID +"~"+ recId;
	
	dojo.byId("stationIdTempIdentifier").value = elementFnal;
	
	setStationIdUpdateSelect(stationIdsVals);
	
	
	
	var dialogObj = dijit.byId("stationIdSelectDialog");

	// hide the default close button, so that user only clicks on cancel or update button, otherwise scrollbar wont show.
	dialogObj.closeButtonNode.style.display = 'none';
	
	
	dialogObj.show();
	
	 dojo.byId("stationIdsUpdateIDiv").style.display="block";	
	 
	 // hide scrollbars to avoid resize of dialog.
	 
	 document.body.scroll="no";
	 
	
	 
	 
	return dialogObj;

}



function stationIdValueSelectedUpdate(){
	
	//var stationdFilteringSelect  = dijit.byId("updateStationId");
	
	dijit.byId("manageUsers_AddStationIdsBtnForUpdate").setAttribute('disabled',false);
	
}

function stationIdUpdateValueAddBtn(){
	
    var stationdFilteringSelect  = dojo.byId("updateStationId");
	
	var selectedOptionIDValues = [];
	
	for(var i=0; i< stationdFilteringSelect.options.length; ++i){
		
		
		if(stationdFilteringSelect.options[i].selected == true){
			
			selectedOptionIDValues.push(stationdFilteringSelect.options[i].value);
			
		}
	
	}
	
	var selectedOptionTextalues = [];
	
	for(var i=0; i< stationdFilteringSelect.options.length; ++i){
		
		
		if(stationdFilteringSelect.options[i].selected == true){
			
			selectedOptionTextalues.push(stationdFilteringSelect.options[i].text);
			
		}
	
	}
	
	var selectedStationsSelect = dojo.byId("selectedStationdIdsForUpdate");
	
	for(var i=0; i< selectedStationsSelect.options.length; ++i){
		
		
		for(var k=0; k< selectedOptionTextalues.length; ++k){
			
			if(selectedStationsSelect.options[i].text == selectedOptionTextalues[k]){
				
				alert(selectedStationsSelect.options[i].text +" already exits. Please choose unique value.");
				
				return;
				
			}
		}
		
		
		
		for(var j=0; j< selectedOptionIDValues.length; ++j){
			
			// if user tries to add All when other values are already added.
			if( (selectedStationsSelect.options.length > 0) &&  (selectedOptionIDValues[j]=="All")){
				
				alert("You cannot select Station IDs in addition to the \"All\" value.");
				
				return;
				
			}
		}
		
		
		// if user tries to add other values, when all is already added.
		if( (selectedStationsSelect.options.length > 0) &&  (selectedStationsSelect.options[i].value=="All")){
			
			alert("You cannot select Station IDs in addition to the \"All\" value.");
			
			return;
			
		}
		
		
	}
	
	for(var i=0; i<selectedOptionIDValues.length; i++){
	
		selectedStationsSelect.options[selectedStationsSelect.options.length] = new Option(selectedOptionTextalues[i], selectedOptionIDValues[i], false, false);
	}
	
	
	
	// now sort the select by values (station ids)
	
	if(selectedStationsSelect.options.length > 1){
		
		
		var tempSelectArray = new Array();
		
		var length = selectedStationsSelect.options.length;
		
		for(var i=length-1; i>=0; --i) {
			
			tempSelectArray.push(selectedStationsSelect.options[i]);
		  
			selectedStationsSelect.removeChild(selectedStationsSelect.options[i]);
		}
		
		tempSelectArray.sort(function(o1,o2){
			
			   if(o1.value > o2.value) {
			      return 1;
			   } else if(o1.value < o2.value) {
			      return -1;
			   }
			   return 0;
			});
		
		
			for(var i=0; i<length; ++i) {
				selectedStationsSelect.appendChild(tempSelectArray[i]);
			}
						
	}
	
	
	// disable add button
	dijit.byId("manageUsers_AddStationIdsBtnForUpdate").setAttribute('disabled',true);
	
	dijit.byId("manageUsers_UpdateStationIdsBtn").setAttribute('disabled',false);
	
		
}


function stationIdUpdateValueRemoveBtn(){
	
	var selectedStationsSelect = dojo.byId("selectedStationdIdsForUpdate");
	
	var isSelected = [];
	
	
	for(var i=0; i< selectedStationsSelect.options.length; ++i){
		
		
		isSelected[i] = selectedStationsSelect.options[i].selected;
		
		
	}
	
	var counter = selectedStationsSelect.options.length;
	
	while(counter--){
		
		if(isSelected[counter]){
			
			selectedStationsSelect.remove(counter);	
		}
		
	}
	

	if(selectedStationsSelect.options.length ==0){
		
		dijit.byId("manageUsers_RemoveStationIdsBtnForUpdate").setAttribute('disabled',true);
		
		dijit.byId("manageUsers_UpdateStationIdsBtn").setAttribute('disabled',true);
	}
	else{
		
		dijit.byId("manageUsers_UpdateStationIdsBtn").setAttribute('disabled',false);
	}
	
}


function UM_StationIdsValuesModified(element, value) {
	
	var key = element;
	var tempKey = element+"^"+value;
	
	var index = dojo.indexOf(modifiedStationIdsValues,key);
	var tempKeyIndex = dojo.indexOf(modifiedStationIdsValues,key);
		
	if(index== -1){
		    	
		modifiedStationIdsValues.push(key);
		tempModifiedStationIdsValuesArray.push(tempKey);
	   }
    else
    {
    	modifiedStationIdsValues.splice(index,1);
    	tempModifiedStationIdsValuesArray.splice(tempKeyIndex,1);
	   	
	     // add new values.
	   	modifiedStationIdsValues.push(key);
	   	tempModifiedStationIdsValuesArray.push(tempKey);
	    	
	  }
	
	
}


function dialogOnCancel() {
	

	dijit.byId('stationIdSelectDialog').hide();
	
	// redisplay scroll bars.
	
	document.body.scroll="yes";
}

function dialogOnUpdate() {

	var inputModified = dojo.byId("stationIdTempIdentifier").value;
	
	
	// get all values of the selected stations
	
	var selectedStationsSelect = dojo.byId("selectedStationdIdsForUpdate");
	   
	var tempStationIdsValuesArray =   new Array();
	   
	for(var i=0; i<selectedStationsSelect.options.length; ++i){
			
			
		tempStationIdsValuesArray.push(selectedStationsSelect.options[i].value);
				
	}
	

	// defining new function for the array.
	
	Array.prototype.stationIdAlphanumericSort= function(){
	    var a, b, a1, b1;
	    
	    var rx=/(\d+)|(\D+)/g, rd=/\d+/;
	    
	    return this.sort(function(astring, bstring){
	    	
	        a = String(astring).toLowerCase().match(rx);
	        
	        b = String(bstring).toLowerCase().match(rx);
	        
	        while(a.length && b.length){
	        	
	            a1= a.shift();
	            b1= b.shift();
	            
	            if(rd.test(a1) || rd.test(b1)){
	            	
	                if(!rd.test(a1)) 
	                	return 1;
	                if(!rd.test(b1)) 
	                	return -1;
	                
	                if(a1!= b1) 
	                	return a1-b1;
	            }
	            else if(a1!= b1) 
	            	return a1> b1? 1: -1;
	        }
	        return a.length- b.length;
	    });
	}
	
	// sort the array in alphanumeric order.
	
	tempStationIdsValuesArray.stationIdAlphanumericSort();	
	
	var selectedStationIdValues =  tempStationIdsValuesArray.join(",");
	
	UM_StationIdsValuesModified(inputModified,selectedStationIdValues);
	
	// update the page with modified station ids.	
	
	var changedStationIdTrimmed = selectedStationIdValues.substring(0,20)+"..";
	
	var inputElementId = inputModified.split("~");
	
	var spanIdArray = inputElementId[0].split(/([0-9]+)/);
	
	
	dojo.byId("stationIDSpanRow"+spanIdArray[1]+"").innerHTML="";

	dojo.byId("stationIDSpanRow"+spanIdArray[1]+"").innerHTML = "<a aria-label=\"Change Station Ids "+ inputElementId[0] +"\" href=\"#\"  onclick=\"createSelectDialog('" + inputElementId[0] + "', '" + selectedStationIdValues+ "', '"+ inputElementId[1] + "')\">" + changedStationIdTrimmed	+ "</a>"; 
	
		
	dijit.byId('stationIdSelectDialog').hide();
	
	document.body.scroll="yes";
}




function setUserRoleSelectAria(userRoleSelectBox) {
	

	userRoleSelectBox.options[userRoleSelectBox.selectedIndex].setAttribute("aria-activedescendant",userRoleSelectBox.options[userRoleSelectBox.selectedIndex].value);
	
	for(var i=0; i<userRoleSelectBox.options.length; i++){
		
		if(userRoleSelectBox.options[i].selected == true){
			
			userRoleSelectBox.options[i].setAttribute("aria-selected","true");
			userRoleSelectBox.options[i].setAttribute("selected","selected");
			
		}
		else{
			userRoleSelectBox.options[i].setAttribute("aria-selected","false");
			if(userRoleSelectBox.options[i].getAttribute("selected")=="selected" ){
				userRoleSelectBox.options[i].removeAttribute("selected");
			}
			
		}
		
				
	}
	
}