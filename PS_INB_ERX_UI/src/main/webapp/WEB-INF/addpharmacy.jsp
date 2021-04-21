<%-- header, body start and end includes --%>
<jsp:include page="/WEB-INF/layouts/headerLayout.jsp" />

<%-- add page specific css --%>
<link rel="stylesheet" type="text/css" href="/inbound/style/main.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/tables.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/reports.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/forms.css">

<%-- add page specific js --%>
<script type="text/javascript" src="/inbound/scripts/component/dataGridSupport.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/dataGrid.js"> </script>
<script type="text/javascript" src="/inbound/scripts/component/formSelect.js"> </script>
<script type="text/javascript" src="/inbound/scripts/managepharmacy.js"> </script>
<script type="text/javascript" src="/inbound/scripts/inbound.js"> </script>
<script type="text/javascript" src="/inbound/scripts/editpharmacy.js"> </script>

<title>Add Pharmacy</title>
<%-- page body start --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutStart.jsp" />

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />

<div id="AddPharm">
<h1 class="titleBar"><span class="headerText">Add Pharmacy</span></h1>
<form:form id="pharmacyAddForm" name="pharmacyAddForm" modelAttribute="pharmacyAddForm" method="POST" action="${pageContext.request.contextPath}/inb-erx/managePharm/addNewPharmacy">
<div id="warningMessage" class="warning" aria-describedby="Informational message or warning message section" tabindex="0">
<p id="errorTitle">
<font class="warningHeader">Warning Message: </font>
</p>
<p id="warningOnAddPharm">
					Any changes made on this screen will not  update the Change Healthcare's published pharmacy directory.					
</p>
</div>
<c:if test="${not empty messageData.errorMessage }">
<div id="errorMessages" class="error" aria-describedby="error message section" tabindex="1">
<p id="errorTitle">
	<h3> <font class="errorHeader">Error Messages: </font></h3>
<br>
</p>
<div id="errorMessageText">
<ul role="list">
<c:forEach items="${messageData.errorMessage}" var="error" varStatus="status">
				<li id="errorOnEditPharm${status.count}" role="listitem">					
					${error}
				</li>
			</c:forEach>
 </ul>			
</div>
</div>
</c:if>
<c:if test="${fn:length(messageData.successMessage) > 0}">
<div id="successMessages" class="warning">${messageData.successMessage} 
<br>
</div>
</c:if>

 <div class="buttons">      
      
      <button dojoType="dijit.form.Button" type="button" id="pharmInfoButton"  onclick="goToPharmacyInfo();">Return To Pharmacy Management </button>  
  </div>

<div id="pharmacyManagement">


    
    <div id="list">
    
    
    <div id="STORE_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="storeName">
	Pharmacy Name (Published):
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="storeName" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.storeName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="storeName" title="Pharmacy's name. This is the published name visible to outside providers">
	</div>
	
	 <div id="INBOUND_ERX_ENABLED" class="displayable" style="display: block; opacity: 1;" title="Disable or enable delivery of electronic prescriptions to pharmacy">
	<label for="pharmacyEnabledDisabled">
	Inbound eRx Enabled:
	</label>
	
	<select id="pharmacyEnabledDisabled pharmAddScreen" class="editable " style="display: block; opacity: 1;" name="pharmacyEnabledDisabled">   
	  <option value="0"  ${pharmacyInfo.inboundErxEnabled == 0 ? 'selected="selected"' : ''}>No</option><%-- Disabled --%>
	  <option value="1"  ${pharmacyInfo.inboundErxEnabled == 1 ? 'selected="selected"' : ''}>Yes</option><%-- Enabled --%>	
	 </select>
	</div>
    
    <div id="VISN" class="displayable" style="display: block; opacity: 1;">
	<label for="visn">
	VISN:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="visn" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.visn}"  size="2" maxlength="2" style="display: block; opacity: 1;" name="visn" title="Veteran Integrated Service Network of pharmacy, maximum characters allowed is 2.">
	</div>	
	
	<div id="VA_STATION_ID" class="displayable" style="display: block; opacity: 1;">
	<label for="vaStationId">
	VA Station ID
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>:
	</label>
	<input id="vaStationId" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.vaStationId}"  size="20" maxlength="10" style="display: block; opacity: 1;" name="vaStationId" title="VA Station ID of pharmacy, maximum characters allowed is 10.">
	</div>
    
     <div id="DIVISION_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="divisionName">
	Pharmacy Name (Internal):
	<span class="requiredField">
    <span class="required">(Required)</span>
    </span>
	</label>
	<input id="divisionName" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.divisionName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="divisionName" title="Pharmacy's division name">	
	</div>

	<div id="PHARMACY_ADDRESS_LINE_1" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyAddressLine1">
	Pharmacy Address Line 1:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyAddressLine1" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacyAddressLine1}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyAddressLine1" title="First line of pharmacy's address">
	</div>
	
	<div id="PHARMACY_ADDRESS_LINE_2" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyAddressLine2">
	Pharmacy Address Line 2:
	</label>
	<input id="pharmacyAddressLine2" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacyAddressLine2}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyAddressLine2" title="Second line of pharmacy's address">
	</div>
	
	<div id="PHARMACY_CITY" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyCity">
	Pharmacy City:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyCity" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacyCity}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyCity" title="Pharmacy's city">
	</div>
	
	<div id="PHARMACY_STATE" class="displayable" style="display: block; opacity: 1;" title="Pharmacy's state">
	<label for="pharmacyState">
	Pharmacy State:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>	
	<select name="pharmacyState" class="editable pharmAddScreen" id="pharmacyState">
    <c:forEach var="item" items="${statesMap}">
        <option value="${item.key}" ${item.key == pharmacyInfo.pharmacyState ? 'selected="selected"' : ''}>${item.value}</option>
    </c:forEach>
    </select>
	</div>
	
	<div id="PHARMACY_ZIPCODE" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyZipcode">
	Pharmacy Zip Code:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyZipcode" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacyZipcode}"  size="20"  maxlength="10" style="display: block; opacity: 1;" name="pharmacyZipcode" title="Pharmacy's zip code, maximum characters allowed is 10.">
	</div>
	
	<div id="CROSS_STREET" class="displayable" style="display: block; opacity: 1;">
	<label for="crossStreet">
	Cross Street:
	</label>
	<input id="crossStreet" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.crossStreet}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="crossStreet" title="Major intersection nearest to pharmacy">
	</div>
	
	<div id="PHARMACY_PHONE_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyPhoneNumber">
	Pharmacy Phone Number (TE):
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyPhoneNumber" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacyPhoneNumber}"  size="20"  maxlength="19"  style="display: block; opacity: 1;" name="pharmacyPhoneNumber" title="Pharmacy's phone number">
	</div>
	
		<div id="PHARMACY_FAX_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyFaxNumber">
	Pharmacy Fax Number (FX):
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyFaxNumber" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacyFaxNumber}"  size="20"  maxlength="19"  style="display: block; opacity: 1;" name="pharmacyFaxNumber" title="Pharmacy's fax number">
	</div>

    <div id="NCPDP_ID" class="displayable" style="display: block; opacity: 1;">
	<label for="ncpdpId">
	NCPDP ID:
	<span class="requiredField">
    <span class="required">(Required)</span>
    </span>
	</label>
	<input id="ncpdpId" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.ncpdpId}"  size="20" maxlength="7" style="display: block; opacity: 1;" name="ncpdpId" title="Seven-digit NCPDP Provider ID Number">
	</div>
	
			
	<div id="NPI" class="displayable" style="display: block; opacity: 1;">
	<label for="npi">
	NPI:
	<span class="requiredField">
    <span class="required">(Required)</span>
    </span>
	</label>
	<input id="npi" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.npi}"  size="20" maxlength="10" style="display: block; opacity: 1;" name="npi" title="Ten-digit National Provider Identifier">
	</div>
	
	
	<div id="PHARMACIST_PREFIX" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistPrefix">
	Pharmacist Prefix:
	</label>
	<input id="pharmacistPrefix" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacistPrefix}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistPrefix" title="Pharmacist's prefix">
	</div>
	
	<div id="PHARMACIST_FIRST_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistFirstName">
	Pharmacist First Name:
	</label>
	<input id="pharmacistFirstName" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacistFirstName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistFirstName" title="Pharmacist's first name">
	</div>
	
	<div id="PHARMACIST_MIDDLE_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistMiddleName">
	Pharmacist Middle Name:
	</label>
	<input id="pharmacistMiddleName" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacistMiddleName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistMiddleName" title="Pharmacist's middle name">
	</div>
	
	<div id="PHARMACIST_LAST_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistLastName">
	Pharmacist Last Name:
	</label>
	<input id="pharmacistLastName" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacistLastName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistLastName" title="Pharmacist's last name">
	</div>
	
	<div id="PHARMACIST_SUFFIX" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistSuffix">
	Pharmacist Suffix:
	</label>
	<input id="pharmacistSuffix" class="editable pharmAddScreen" type="text" value="${ pharmacyInfo.pharmacistSuffix}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistSuffix" title="Pharmacist's suffix">
	</div>

	<div id="EAndE_CHECK_ENABLED" class="displayable" style="display: block; opacity: 1;" title="Disable or enable enrollment and eligibility check.">
	<label for="pharmacyEnabledDisabled">
	Enrollment and Eligibility Check Enabled:
	</label>
	
	<select id="eAndeCheckEnabled" class="editable " style="display: block; opacity: 1;" name="eAndeCheckEnabled">   
	  <option value="Y"  ${pharmacyInfo.eandeCheck == 'Y' ? 'selected="selected"' : ''}>Yes</option><%-- Enabled --%>
	  <option value="N"  ${pharmacyInfo.eandeCheck == 'N' ? 'selected="selected"' : ''}>No</option><%-- Disabled --%>	
	 </select>
	</div>

	<div>
	<%-- We need this to query the record as NCPDP ID can change --%>
	<input id="pharmacyId"  type="text" value="${ pharmacyInfo.pharmacyId}"  readonly="readonly"  style="display: none; opacity: 0;" name="pharmacyId">
	</div>
	<div class="buttons">
      <button dojoType="dijit.form.Button" type="submit" disabled id="pharmAddButton" >Save </button>      
     </div>
  
    </div>
</form:form>

<span id="pharmacyEditScreen" tabindex="0"  style="width: 1125px; height: 213px; display:block;"></span>
</div>
</div>

<%-- end body --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutEnd.jsp" />