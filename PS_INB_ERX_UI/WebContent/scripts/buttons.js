/** 
 * Used to deal with multiple button submissions correctly across
 * all browsers (but mostly to deal with the wonkiness of IE).
 * **/function enableExisting(){    var existingFileButton = document.getElementById('existingUpdateFile');    if(existingFileButton == null)    {        return false;    }    else    {        existingFileButton.className = "";        existingFileButton.disabled = false;        return true;    }}
function enableButton(buttonid)
{
    var buttonToEnable = document.getElementById(buttonid);
    if(buttonToEnable === null)
    {
        return false;
    }
    else
    {
        buttonToEnable.className = "";
        buttonToEnable.disabled = false;
        return true;
    }
}

var pre = {};

pre.elementExist = function(id) {
	if (document.getElementById(id) == null) {
		return false;
	} else {
		if (document.getElementById(id).name == 'undefined') {
			return false;	
		} else {
			return true;
		}		
	}
}

pre.multiButtonSetValue = function() {	
    if(this.id == 'newUpdateFile' || this.id == 'newUpdateFileFull')
    {
	    if(confirm('This operation can take more than 5 minutes to execute. Are you sure you want to download new updates?'))
	    {
	        // need id of hidden field
	        $(this.hiddenFieldID).value = this.getAttribute("buttonValue");

	        return true;
	    }
	    else
	        return false;
    }
    else
    {
        if(this.id == 'drugPairSimpleQuery')
        {
            var showProgress = document.getElementById('drugPairLoadingImage');
            showProgress.className = "loadingShow";
        }
        
	    // need id of hidden field
	    $(this.hiddenFieldID).value = this.getAttribute("buttonValue");

      if( this.id == 'submitdeleteBtn' || this.id == 'deleteBtn' || this.id == 'wtSubmit_for_Delete' || this.id == 'wtDelete' )
	      return confirm('Are you sure you want to submit this request for delete?');
      else
	      return true;
	}
}

pre.multiButtonHandler = function () {
	// get all buttons on for a all forms
	var buttons = $$('form button');
	
	for (var i = 0; i < buttons.length; i++) {
		var form = buttons[i].form;
		
		var hiddenFieldID = form.id + form.name + "hiddenFieldButtonValue";

		// only add the hidden field once!
		if (!pre.elementExist(hiddenFieldID)) {
			var hiddenField = document.createElement("input");
			hiddenField.type = "hidden";
			hiddenField.name = "buttonValue";
			hiddenField.id = hiddenFieldID;
			
			form.appendChild(hiddenField);	
		}
		
		buttons[i].hiddenFieldID = hiddenFieldID;
		buttons[i].onclick = pre.multiButtonSetValue;
	}
}

Event.observe(window, "load", pre.multiButtonHandler);