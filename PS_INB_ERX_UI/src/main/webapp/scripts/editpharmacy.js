dojo.require("dijit.form.DateTextBox");
dojo.require("dojo.hash");
dojo.require("dijit.registry")

dojo.addOnLoad(function() {
	    
	focusOnPharmPageError();
});


dojo.ready(function() {
	
	connectToPharamElements();
	
});	


function goToPharmacyInfo() {
	
	var url ="/inbound/inb-erx/managePharm/main";
	location.href= url;
	
}



function connectToPharamElements() {
	
	var pharamEditScreenElements = dojo.query(".pharmEditScreen");
	
	pharamEditScreenElements.connect("onkeyup", function(event) {
	       var element = dijit.byId('pharmUpdateButton');
	       
	       if(element!=null)
	       {
	    	    if(element.get('disabled')==true)
	    	    {
	    	    	element.setAttribute('disabled',false);
	    	    }	
	    	   
	       }

	    });
	
	pharamEditScreenElements.connect("onmouseup", function(event) {
	       var element = dijit.byId('pharmUpdateButton');
	       
	       if(element!=null)
	       {
	    	    if(element.get('disabled')==true)
	    	    {
	    	    	element.setAttribute('disabled',false);
	    	    }	
	    	   
	       }

	    });
	
	// For Add.
 var pharamAddScreenElements = dojo.query(".pharmAddScreen");
	
     pharamAddScreenElements.connect("onkeyup", function(event) {
	       var button = dijit.byId('pharmAddButton');
	       
	       if(button!=null)
	       {
	    	    if(button.get('disabled')==true)
	    	    {
	    	    	button.setAttribute('disabled',false);
	    	    }	
	    	   
	       }

	    });
	
     pharamAddScreenElements.connect("onmouseup", function(event) {
	       var button = dijit.byId('pharmAddButton');
	       
	       if(button!=null)
	       {
	    	    if(button.get('disabled')==true)
	    	    {
	    	    	button.setAttribute('disabled',false);
	    	    }	
	    	   
	       }

	    });
	
}

function focusOnPharmPageError(){
	
	// if there are errors scroll to the top and  focus on it.
	var errorElement = dojo.byId("errorMessages");
	
	if(errorElement!=null)
	{
	    errorElement.scrollIntoView();
		errorElement.focus();
		
	}
	
}

