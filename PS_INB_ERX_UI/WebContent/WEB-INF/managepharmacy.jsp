<%-- header, body start and end includes --%>
<jsp:include page="/WEB-INF/layouts/headerLayout.jsp" />

<%-- add page specific css --%>
<link rel="stylesheet" type="text/css" href="/inbound/style/main.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/forms.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/tables.css">


<%-- add page specific js --%>

<script type="text/javascript" src="/inbound/scripts/component/dataGridSupport.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/dataGrid.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/pharmacyDataGrid.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/formSelect.js"> </script>
<script type="text/javascript" src="/inbound/scripts/managepharmacy.js"> </script>
<script type="text/javascript" src="/inbound/scripts/inbound.js"> </script>


<title>Pharmacy Management</title>
<%-- page body start --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutStart.jsp" />


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />

<div id="ManagePharm">
<h1 class="titleBar"><span class="headerText">Pharmacy Management</span></h1>
<c:if test="${not empty messageData.errorMessage }">
<div id="errorMessages" class="error" aria-describedby="" tabindex="0">
<p id="errorTitle">
<font class="errorHeader">Error Messages: </font>
<br>
</p>
<div id="errorMessageText">
<c:forEach items="${messageData.errorMessage}" var="error" varStatus="status">
				<p id="errorOnEditPharm${status.count}">
					&bull;
					${error}
				</p>
			</c:forEach>
</div>
</div>
</c:if>
<c:if test="${fn:length(messageData.successMessage) > 0}">
<div id="pharmacyManagementSuccessMessages" class="warning">
<p>${messageData.successMessage}
 <br>
</p>
</div>
</c:if>

<div id="pharmacyManagement">
<form:form id="pharmacyFilterForm"  name="pharmacyFilterForm">
 

 <div id="NCPDP_ID_DIV" tabindex="0" class="pharmacyManagementNCPDPIDDiv" style="display: block; opacity: 1;">
  <label for="ncpdpId" class="pharmacyManagementNCPDPIDInputLabel">
	NCPDP ID:	
	</label>
	<input id="ncpdpId" class="pharmacyManagementNCPDPIDInput" type="text" value=""  size="7" maxlength="7" style="display: block; opacity: 1;" name="ncpdpId">
  
  </div>	  
  
  <div id="PHARM_NAME_DIV" tabindex="0" class="pharmacyManagementPharmacyNameDiv" style="display: block; opacity: 1;">
     <label for="pharmacyName" class="pharmacyManagementPharmacyNameInputLabel">
	 Pharmacy Name:	
	 </label>
	 <input id="pharmacyName" class="pharmacyManagementPharmacyNameInput" type="text" value=""  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyName">
   
   
	    <div tabindex="0" class="pharmacyManagementVisnSelect">
	           <label for="pharmacyFilterFormVisnSelect">VISN:&nbsp;&nbsp; </label> 			
				 
			 <div id="pharmacyFilterFormVisnSelectDiv"  role="option" aria-labeledby="VISN" style="width: 60px; margin-top: 0px;">
			
			   <select name="pharmacyFilterFormVisnSelect"  id="pharmacyFilterFormVisnSelect" onchange="getPharmStationIdSelect(this);">
	            <c:forEach var="item" items="${visnList}">
	      	    <option value="${item.label}">${item.id}</option>
	        	</c:forEach>    
	           </select>  	
					
	          </div>      
	    </div>
   
	   <div  tabindex="0" class="pharmacyManagementStationIDDiv">
	     <label for="pharmacyFilterFormStationIdSelect">Station ID:&nbsp;&nbsp;</label> 
			<div id="pharmacyFilterFormStationIdSelectDiv"  aria-labeledby="Station ID" style="width: 136px; margin-top: 0px;">
			
				   <select name="pharmacyFilterFormStationIdSelect"  id="pharmacyFilterFormStationIdSelect">
		            <option value="All">All</option>        	
		           </select>   
		    </div>
	   </div>
   
   
       </div>
   

<%-- End Inputs --%> 

 <div id="pharmacyManagementButton" class="displayable" style="display: block; opacity: 1;">
 <button dojoType="dijit.form.Button" type="button" id="pharmSearchButton" onclick="pharmacyManagementActions(this.id);" >Search</button> 
 
  <button dojoType="dijit.form.Button" type="button" id="pharmSearchClearButton" onclick="pharmacyManagementActions(this.id);">Clear</button> 
  
  <button dojoType="dijit.form.Button" type="button" id="pharmManagementExportButton" onclick="pharmacyManagementActions(this.id);">Export</button>
    
  <button dojoType="dijit.form.Button" type="button" id="newPharmAddButton" onclick="pharmacyManagementActions(this.id);">Add Pharmacy </button>
   
  </div>
    <br/>
</form:form>

<div class="pharmacyManagementGrid">
<div id="pharmacyList" aria-labeledby="Pharmacy List" class="generatedDivTableParent"></div>

<span id="pharmacyListDummy" aria-labeledby="Pharmacy List" style="width: 1125px; height: 213px; display:none;"></span>
 </div> 

<span id="pharmMgmtRecNumberTitle" style="width: 250px;padding-top:20px;display: none;">
Number of Records:
<span id="pharmMgmtRecNumber" style="position:relative;top:-14px;left:112px;display: none;">
</span>
</span>
</div>
</div>
<%-- remove Pharmacy information added successfully  --%>
<c:remove var="messageData" scope="session" />
<%-- end body --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutEnd.jsp" />