dojo.require("dijit.form.DateTextBox");
dojo.require("dojo.hash");
dojo.require("dijit.registry")
dojo.require("dojo.parser");

var gridFinal = null;
var dataStoreFinal = null;
var modifiedIds = new Array();
var tempArray =  new Array();
var tempDelSelectArray =  new Array();
var delSelectIds =  new Array();


//for values.
var modifiedValues = new Array();
var tempValuesArray =  new Array();

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



function deleteCheckboxModified(element, value) {
	
	var key = element;
	var tempKey = element+"^"+value;
	
	if(value == true){
	  
		var index = dojo.indexOf(delSelectIds,key);
		var tempKeyIndex = dojo.indexOf(delSelectIds,key);
		
		
	    if(index== -1){
	    	
	    	delSelectIds.push(key);
	    	tempDelSelectArray.push(tempKey);
	    }
	    else{
	    	delSelectIds.splice(index,1);
	    	tempDelSelectArray.splice(tempKeyIndex,1);
	    	
	    }
    }
	else if(value == false){
		
		var index = dojo.indexOf(delSelectIds,key);
		var tempKeyIndex = dojo.indexOf(delSelectIds,key);
		
		
		if(index > -1){
			delSelectIds.splice(index,1);
			tempDelSelectArray.splice(tempKeyIndex,1);
		}
		else{
			delSelectIds.push(key);
			tempDelSelectArray.push(tempKey);
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


function UM_DeleteRows(element, rowCnt, recId) {
	
	
	// disable other row elements for the delete.
	
	if(element.checked == true){
		
		dojo.byId("firstNameRow"+rowCnt).disabled = true;
		dojo.byId("lastNameRow"+rowCnt).disabled = true;
		dojo.byId("userIDRow"+rowCnt).disabled = true;
		//checkboxes
		dojo.byId("pharmManagerRow"+rowCnt).disabled = true;
		dojo.byId("pbmAdminRow"+rowCnt).disabled = true;
		dojo.byId("pharmTechRow"+rowCnt).disabled = true;
		dojo.byId("administratorRow"+rowCnt).disabled = true;
	}
	else if(element.checked == false){
		
		dojo.byId("firstNameRow"+rowCnt).disabled = false;
		dojo.byId("lastNameRow"+rowCnt).disabled = false;
		dojo.byId("userIDRow"+rowCnt).disabled = false;
		//checkboxes
		dojo.byId("pharmManagerRow"+rowCnt).disabled = false;
		dojo.byId("pbmAdminRow"+rowCnt).disabled = false;
		dojo.byId("pharmTechRow"+rowCnt).disabled = false;
		dojo.byId("administratorRow"+rowCnt).disabled = false;
	}
	
	// now add records for deletion.
	
	var elementFinal = element.name +"~"+ recId;
	
	deleteCheckboxModified(elementFinal,element.checked );
	
	
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

       // validation is clear call this.		
		
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
		
		var deleteValues =  tempDelSelectArray.join(",");
		
		dojo.byId("deleteRecords").value = deleteValues; 
		
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
		 
		
		
		return true;
	}
	else{
		
		return false;
	}
	
	
}


