dojo.require("dojox.data.JsonQueryRestStore");
dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojox.grid.enhanced.plugins.IndirectSelection");
dojo.require("dojo.dom-construct");
dojo.require("dojox.grid.EnhancedGrid");
dojo.require("dojox.grid.cells.dijit");

var DATE_PATTERN = "yyyy-MM-dd";
var TIME_PATTERN = "HH:mm:ss";


function formatDate(seconds) {
    if (isNaN(seconds)) {
        return seconds;
    }
    return dojo.date.locale.format(new Date(seconds), {
        selector : "date",
        datePattern : DATE_PATTERN
    });
}
/**
 * Internet Explore has a bug that will not display cell borders in the dojo
 * grid if the data is null this function is designed to take the data and
 * replace a null with a white space.
 * 
 * @param index
 * @returns
 */
function formatIeGrid(cell) {
	if (cell === null || cell === "") {
		cell = '&nbsp;';
	}
	return cell;
}


function formatTimestamp(seconds) {
	if(seconds === null)
		{
		return '&nbsp';
		}
	/*Original Format if TimeStamp was null need acceptance in Code Review.
	 * if (seconds === null)
		{
		return "";
		}*/
    if (isNaN(seconds)) {
        return seconds;
    }
    
    return dojo.date.locale.format(new Date(seconds), {
        datePattern : DATE_PATTERN,
        timePattern : TIME_PATTERN
    });
}

function gridFetchError(errorData, request) {
    // A SyntaxError is returned if a session timeout is found during a fetch
    // request.
    if (errorData.message.toLowerCase() == "syntax error") {
        parent.location = "/inbound/login/login.jsp";
    }
    return "The list of columns set for display could not be loaded from the database.  Resubmit query.  If problem persists, report this error to the support team.";
}



function buildJsonQueryRestStore(dataSourceURL, query) {
    try {
        var dataStore = new dojox.data.JsonQueryRestStore({
            target : dataSourceURL,
            idAttribute : "key",
            cacheByDefault: false
        });
        return dataStore;
    } catch (err) {
        alert(err.message);
    }
};
