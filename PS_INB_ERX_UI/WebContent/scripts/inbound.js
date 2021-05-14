
dojo.addOnLoad(function() {
		dojo.require("dojo.parser");
		// notice the second onLoad here:
		dojo.addOnLoad(function() {
			dojo.parser.parse();
			
		});
});

var sessionTime = null;

var timeoutTime = null;

var finalTimeoutTime = null;

var userResponse = false;

var sessionExtended = false;

	dojo.addOnLoad(function() {
		
		setSessionWarningTimer();
		
		highlightTab();
		
		var ie = IeVersion();

		if( ie.IsIE == true && ie.CompatibilityMode == true && ie.TrueVersion == 11){
			
			if(dojo.byId("compatWarning")!=null){
				
				 dojo.style(dojo.byId("compatWarning"), "DISPLAY", "block");
			  }
			}			 
	
});
	
	
function highlightTab(){
	var path = location.pathname;
	if ((path.match("index") != null) || (path.match("homepage")) )
	{
        dojo.addClass(dojo.byId("index"), "activeTab");
        dojo.byId("indexSelectedInfo").innerHTML= "HomePage Selected";
    }
	else if (path.match("vieweRx") != null) 
	{
        dojo.addClass(dojo.byId("vieweRx"), "activeTab");
        dojo.byId("vieweRxSelectedInfo").innerHTML= "View Rx Page Selected";
    } 
	else if (path.match("managePharm") != null) 
	{
        dojo.addClass(dojo.byId("managepharmacy"), "activeTab");
        dojo.byId("managepharmacySelectedInfo").innerHTML= "Pharmacy Management Page Selected";
    }
	else if (path.match("track") != null) 
	{
        dojo.addClass(dojo.byId("trackeRx"), "activeTab");
        dojo.byId("trackeRxSelectedInfo").innerHTML= "Track Audit Page Selected";
    } 
	else if (path.match("reports") != null) 
	{
        dojo.addClass(dojo.byId("reports"), "activeTab");
        dojo.byId("reportsSelectedInfo").innerHTML= "Reports Page Selected";
    } 
	else if (path.match("manageUsers") != null) 
	{
        dojo.addClass(dojo.byId("manageusers"), "activeTab");
        dojo.byId("manageusersSelectedInfo").innerHTML= "User Management Page Selected";
    } 
	else if (path.match("help") != null) 
	{
        dojo.addClass(dojo.byId("help"), "activeTab");
        dojo.byId("helpSelectedInfo").innerHTML= "Help Page Selected";
    }
}

function sessionTimeOutWarning() {  
    
	userResponse = confirm("Your Inbound eRx session will end in two minutes. Do you want to extend it to 30 minutes.");

}

function sessionTimeOutWinClose() {  
	
	if(sessionExtended == false){
		
		 // check if browser is IE.
		var ie = IeVersion();
		
		
		if( ie.IsIE == true ){
			
			     var url ="/inbound/inb-erx/logout";
			
				 window.location.href= url;
		    	
		    	 window.open('', '_self', '');
		    	 
				 window.close();
			
		}
		else
		{
			var url ="/inbound/inb-erx/logout";
			
			window.location.href= url;
		}
		
	}
	
}

function extendSession(){
	
	    // reset
	    sessionExtended = false;
	     
	    if(userResponse == true)
	    {
	  	    	
	    	var url ="/inbound/inb-erx/appManagement/extendSession";
	    	
	    	
	    	dojo.xhrGet({
	            url: url,
	            handleAs: "json", 
	            load: function(data, ioArgs) {
	            	if(data.message =="success"){
	    				  
	    				  alert("Your session has been extented for 30 minutes.");
	    				  sessionExtended = true;
	    				  setSessionWarningTimer();
	    			  }
	    			  else{
	    				  
	    				 alert("Your session request failed. Please close your browser window and relaunch Inbound eRx web application.");
	    			  }
	               
	            },
	            error: function(error) {
	                console.log("Error occurred while submitting session extension request.", error);
	            }
	        });
	    	
	    }	
	    else
	    {
	    	sessionExtended = false;
	    	
	    	sessionTimeOutWinClose();	
	    }    
	    
}


function setSessionWarningTimer(){
	/* Assumes Session timout in the web.xml is set to 29 minutes.  
	   Will send a warning alert at 28 minutes */	
	var maxTime = 60 * 28 * 1000;
	timeoutTime =  60 * 29 * 1000;
    sessionTime = window.setTimeout(sessionTimeOutWarning, maxTime);
    
    window.setTimeout(extendSession, timeoutTime);	
    
    finalTimeoutTime = 60 * 30 * 1000;
    
    window.setTimeout(sessionTimeOutWinClose, finalTimeoutTime);	
}


function resetSessionWarningTimer(){
	    window.clearTimeout(sessionTime);
	    setSessionWarningTimer();
}


function openHelp(){
	var url ="/inbound/inb-erx/help/main";
	var win = window.open('','_blank','width=1026,height=768,left=400,top=0,scrollbars=yes,resizable=yes,status=yes');
	win.location.href= url;
	win.focus();
}	

function formatUsPhone(phone) {

    var phoneTest = new RegExp(/^((\+1)|1)? ?\(?(\d{3})\)?[ .-]?(\d{3})[ .-]?(\d{4})( ?(ext\.? ?|x|X)(\d*))?$/);

    phone = phone.trim();
    var results = phoneTest.exec(phone);
    if (results !== null && results.length > 8) {

        return "(" + results[3] + ") " + results[4] + "-" + results[5] + (typeof results[8] !== "undefined" ? " x" + results[8] : "");

    }
    else {
         return phone;
    }
}

function trueOrFalse() {
    return true;
}

function IeVersion() {
    //Set defaults
    var value = {
        IsIE: false,
        TrueVersion: 0,
        ActingVersion: 0,
        CompatibilityMode: false
    };

    //Try to find the Trident version number
    var trident = navigator.userAgent.match(/Trident\/(\d+)/);
    if (trident) {
        value.IsIE = true;
        //Convert from the Trident version number to the IE version number
        value.TrueVersion = parseInt(trident[1], 10) + 4;
    }

    //Try to find the MSIE number
    var msie = navigator.userAgent.match(/MSIE (\d+)/);
    if (msie) {
        value.IsIE = true;
        //Find the IE version number from the user agent string
        value.ActingVersion = parseInt(msie[1]);
    } else {
        //Must be IE 11 in "edge" mode
        value.ActingVersion = value.TrueVersion;
    }

    //If we have both a Trident and MSIE version number, see if they're different
    if (value.IsIE && value.TrueVersion > 0 && value.ActingVersion > 0) {
        //In compatibility mode if the trident number doesn't match up with the MSIE number
        value.CompatibilityMode = value.TrueVersion != value.ActingVersion;
    }
    return value;
}