<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />

<div id="EditPharm">

<h1 class="titleBar"><span class="headerText">Edit Pharmacy</span></h1>
<form:form id="pharmacyEditForm" name="pharmacyEditForm" commandName="pharmacyEditForm" method="POST" action="${pageContext.request.contextPath}/inb-erx/managePharm/updatePharmacy">
<c:if test="${not empty data.errorMessage }">
<div id="errorMessages" class="error" aria-describedby="" tabindex="0">
<p id="errorTitle">
<font class="errorHeader">Error Messages: </font>
<br>
</p>
<div id="errorMessageText">
<c:forEach items="${data.errorMessage}" var="error" varStatus="status">
				<p id="errorOnEditPharm${status.count}">
					&bull;
					${error}
				</p>
			</c:forEach>
</div>
</div>
</c:if>
<c:if test="${fn:length(data.successMessage) > 0}">
<div id="successMessages" class="warning">${data.successMessage} </div>
</c:if>

<div id="pharmacyEditScreen">


    
    <div id="list">
    
    <div id="STORE_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="storeName">
	Pharmacy Name (Published):
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="storeName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.storeName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="storeName" title="Pharmacy's name. This is the published name visible to outside providers">
	</div>
	
	<div id="INBOUND_ERX_ENABLED" class="displayable" style="display: block; opacity: 1;" title="Disable or enable delivery of electronic prescriptions to pharmacy">
	<label for="pharmacyEnabledDisabled">
	Inbound Erx Enabled:
	</label>
	
	<select id="pharmacyEnabledDisabled" class="editable pharmEditScreen " style="display: block; opacity: 1;" name="pharmacyEnabledDisabled">   
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
	<input id="visn" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.visn}"  size="2" maxlength="2" style="display: block; opacity: 1;" name="visn" title="Veteran Integrated Service Network of pharmacy">
	</div>	
	
	<div id="VA_STATION_ID" class="displayable" style="display: block; opacity: 1;">
	<label for="vaStationId">
	VA Station ID
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>:
	</label>
	<input id="vaStationId" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.vaStationId}"  size="20" maxlength="10" style="display: block; opacity: 1;" name="vaStationId" title="VA Station ID of pharmacy">
	</div>
	
    <div id="DIVISION_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="divisionName">
	Pharmacy Name (Internal):
	<span class="requiredField">
    <span class="required">(Required)</span>
    </span>
	</label>
	<input id="divisionName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.divisionName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="divisionName" title="Pharmacy's division name">	
	</div>
   
	<div id="PHARMACY_ADDRESS_LINE_1" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyAddressLine1">
	Pharmacy Address Line 1:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyAddressLine1" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacyAddressLine1}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyAddressLine1" title="First line of pharmacy's address">
	</div>
	
	<div id="PHARMACY_ADDRESS_LINE_2" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyAddressLine2">
	Pharmacy Address Line 2:
	</label>
	<input id="pharmacyAddressLine2" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacyAddressLine2}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyAddressLine2" title="Second line of pharmacy's address">
	</div>
	
	<div id="PHARMACY_CITY" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyCity">
	Pharmacy City:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyCity" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacyCity}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacyCity" title="Pharmacy's city">
	</div>
	
	<div id="PHARMACY_STATE" class="displayable" style="display: block; opacity: 1;" title="Pharmacy's state">
	<label for="pharmacyState">
	Pharmacy State:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>	
	<select name="pharmacyState" class="pharmEditScreen" id="pharmacyState">
    <c:forEach var="item" items="${statesMap}">
        <option value="${item.key}" ${item.key == pharmacyInfo.pharmacyState ? 'selected="selected"' : ''}>${item.value}</option>
    </c:forEach>
    </select>
	</div>
	
	<div id="PHARMACY_ZIPCODE" class="displayable" style="display: block; opacity: 1;" >
	<label for="pharmacyZipcode">
	Pharmacy Zip Code:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyZipcode" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacyZipcode}"  size="20"  maxlength="10" style="display: block; opacity: 1;" name="pharmacyZipcode" title="Pharmacy's zip code">
	</div>
	
	<div id="CROSS_STREET" class="displayable" style="display: block; opacity: 1;">
	<label for="crossStreet">
	Cross Street:
	</label>
	<input id="crossStreet" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.crossStreet}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="crossStreet" title="Major intersection nearest to pharmacy">
	</div>
	
	<div id="PHARMACY_PHONE_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyPhoneNumber">
	Pharmacy Phone Number (TE):
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyPhoneNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacyPhoneNumber}"  size="20"  maxlength="19"  style="display: block; opacity: 1;" name="pharmacyPhoneNumber" title="Pharmacy's phone number">
	</div>
	
		<div id="PHARMACY_FAX_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacyFaxNumber">
	Pharmacy Fax Number (FX):
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<input id="pharmacyFaxNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacyFaxNumber}"  size="20"  maxlength="19"  style="display: block; opacity: 1;" name="pharmacyFaxNumber" title="Pharmacy's fax number">
	</div>
	
    <div id="NCPDP_ID" class="displayable" style="display: block; opacity: 1;">
	<label for="ncpdpId">
	NCPDP ID:
	<span class="requiredField">
    <span class="required">(Required)</span>
    </span>
	</label>
	<input id="ncpdpId" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.ncpdpId}"  size="20" maxlength="7" style="display: block; opacity: 1;" name="ncpdpId" title="Seven-digit NCPDP Provider ID Number">
	</div>
   
    <div id="ACTIVE_START_TIME" class="displayable" style="display: block; opacity: 1;">
	<label for="activeStartTime">
	Active Start Time:<span class="pharmacyEditFormReadOnlyField">(Read Only)</span>    
	</label>
	
	<fmt:formatDate  pattern="MM/dd/yyyy" value="${pharmacyInfo.activeStartTime}" var="parseActiveStartDateVal"/>
	<input id="activeStartTime"  class="editable wizardReadonly" type="text" value="${ parseActiveStartDateVal}"  readonly="readonly"  name="activeStartTime" style="display: block; opacity: 1;" title="Date for the pharmacy to become active in the clearinghouse pharmacy directory">
	</div>
	
    <div id="ACTIVE_END_TIME" class="displayable" style="display: block; opacity: 1;">
    <label for="activeEndTime">
    Active End Time:<span class="pharmacyEditFormReadOnlyField">(Read Only)</span>    
    
    </label>
    <fmt:formatDate  pattern="MM/dd/yyyy" value="${pharmacyInfo.activeEndTime}" var="parseActiveEndDateVal"/>
    <input id="activeEndTime"  class="editable wizardReadonly" type="text" value="${ parseActiveEndDateVal}"   readonly="readonly" name="activeEndTime" style="display: block; opacity: 1;" title="Date for the pharmacy to be de-activated in clearinghouse pharmacy directory">
    </div>     
		
	
	<div id="BIN_LOCATION_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="binLocationNumber">
	Bin Location Number:
	</label>
	<input id="binLocationNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.binLocationNumber}"  size="15" maxlength="35" style="display: block; opacity: 1;" name="binLocationNumber" title="Pharmacy Identifier">
	</div>
	
	<div id="DEA_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="deaNumber">
	DEA Number:
	</label>
	<input id="deaNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.deaNumber}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="deaNumber" title="Pharmacy's DEA Number">
	</div>
	
	<div id="EMAIL" class="displayable" style="display: block; opacity: 1;">
	<label for="email">
	Email:
	</label>
	<input id="email" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.email}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="email" title="Pharmacy's email address">
	</div>
	
	<div id="FILE_ID" class="displayable" style="display: block; opacity: 1;">
	<label for="fileId">
	File ID:<span class="pharmacyAddFormReadOnlyField">(Read Only)</span>
	</label>
	<input id="fileId" class="editable wizardReadonly" type="text" value="${ pharmacyInfo.fileId}"  readonly="readonly" size="20" maxlength="35" style="display: block; opacity: 1;" name="fileId" title="Pharmacy Identifier">
	</div>
	
	<div id="HIN" class="displayable" style="display: block; opacity: 1;">
	<label for="hin">
	HIN:
	</label>
	<input id="hin" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.hin}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="hin" title="Pharmacy's Health Industry Number">
	</div>
	
	<div id="MEDICAID_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="medicaidNumber">
	Medicaid Number:
	</label>
	<input id="medicaidNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.medicaidNumber}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="medicaidNumber" title="Pharmacy's Medicaid Number">
	</div>
	
	<div id="MEDICARE_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="medicareNumber">
	Medicare Number:
	</label>
	<input id="medicareNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.medicareNumber}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="medicareNumber" title="Pharmacy's Medicare Number">
	</div>
	
	<div id="NAIC_CODE" class="displayable" style="display: block; opacity: 1;">
	<label for="naicCode">
	NAIC Code:
	</label>
	<input id="naicCode" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.naicCode}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="naicCode" title="Pharmacy's NAICS Code">
	</div>
			
	<div id="NPI" class="displayable" style="display: block; opacity: 1;">
	<label for="npi">
	NPI:
	<span class="requiredField">
    <span class="required">(Required)</span>
    </span>
	</label>
	<input id="npi" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.npi}"  size="20" maxlength="10" style="display: block; opacity: 1;" name="npi" title="Ten-digit National Provider Identifier">
	</div>
	
	<div id="STORE_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="storeNumber">
	Store Number:
	</label>
	<input id="storeNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.storeNumber}"  size="20" maxlength="35"  style="display: block; opacity: 1;" name="storeNumber" title="Pharmacy's ID number">
	</div>
	
	<div id="PAYER_ID" class="displayable" style="display: block; opacity: 1;">
	<label for="payerId">
	Payer ID:
	</label>
	<input id="payerId" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.payerId}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="payerId" title="Pharmacy's Payer ID">
	</div>
	
		
	<div id="PHARMACIST_AGENT_PREFIX" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistAgentPrefix">
	Pharmacist Agent Prefix:
	</label>
	<input id="pharmacistAgentPrefix" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistAgentPrefix}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistAgentPrefix" title="Prefix for pharmacist agent">
	</div>
	
	<div id="PHARMACIST_AGENT_FIRST_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistAgentFirstName">
	Pharmacist Agent First Name:
	</label>
	<input id="pharmacistAgentFirstName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistAgentFirstName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistAgentFirstName" title="Pharmacist's Agent first name">
	</div>	
	
	<div id="PHARMACIST_AGENT_MIDDLE_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistAgentMiddleName">
	Pharmacist Agent Middle Name:
	</label>
	<input id="pharmacistAgentMiddleName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistAgentMiddleName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistAgentMiddleName" title="Pharmacist's Agent middle name">
	</div>
	
	<div id="PHARMACIST_AGENT_LAST_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistAgentLastName">
	Pharmacist Agent Last Name:
	</label>
	<input id="pharmacistAgentLastName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistAgentLastName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistAgentLastName" title="Pharmacist's Agent last name">
	</div>	
	
	<div id="PHARMACIST_AGENT_SUFFIX" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistAgentSuffix">
	Pharmacist Agent Suffix:
	</label>
	<input id="pharmacistAgentSuffix" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistAgentSuffix}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistAgentSuffix" title="Pharmacist's Agent suffix">
	</div>
	
	<div id="PHARMACIST_PREFIX" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistPrefix">
	Pharmacist Prefix:
	</label>
	<input id="pharmacistPrefix" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistPrefix}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistPrefix" title="Pharmacist's prefix">
	</div>
	
	<div id="PHARMACIST_FIRST_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistFirstName">
	Pharmacist First Name:
	</label>
	<input id="pharmacistFirstName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistFirstName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistFirstName" title="Pharmacist's first name">
	</div>
	
	<div id="PHARMACIST_MIDDLE_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistMiddleName">
	Pharmacist Middle Name:
	</label>
	<input id="pharmacistMiddleName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistMiddleName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistMiddleName" title="Pharmacist's middle name">
	</div>
	
	<div id="PHARMACIST_LAST_NAME" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistLastName">
	Pharmacist Last Name:
	</label>
	<input id="pharmacistLastName" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistLastName}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistLastName" title="Pharmacist's last name">
	</div>
	
	<div id="PHARMACIST_SUFFIX" class="displayable" style="display: block; opacity: 1;">
	<label for="pharmacistSuffix">
	Pharmacist Suffix:
	</label>
	<input id="pharmacistSuffix" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.pharmacistSuffix}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="pharmacistSuffix" title="Pharmacist's suffix">
	</div>
		
	<div id="PPO_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="ppoNumber">
	PPO Number:
	</label>
	<input id="ppoNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.ppoNumber}"  size="20"  maxlength="35" style="display: block; opacity: 1;" name="ppoNumber" title="Pharmacy's PPO number">
	</div>
	
	<div id="PROMOTION_NUMBER" class="displayable" style="display: block; opacity: 1;">
	<label for="promotionNumber">
	Promotion Number:
	</label>
	<input id="promotionNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.promotionNumber}"  size="20"  maxlength="35" style="display: block; opacity: 1;" name="promotionNumber" title="Pharmacy Identifier">
	</div>
	
	<div id="SECONDARY_COVERAGE" class="displayable" style="display: block; opacity: 1;">
	<label for="secondaryCoverage">
	Secondary Coverage:
	</label>
	<input id="secondaryCoverage" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.secondaryCoverage}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="secondaryCoverage" title="Pharmacy Identifier">
	</div>
	
	<div id="SERVICE_LEVEL" class="displayable" style="display: block; opacity: 1;" title="Service level associated with pharmacy">	
	<label for="serviceLevel">
	Service Level:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>

	<c:set var ="serviceLevelValList" value="${fn:split(pharmacyInfo.serviceLevel,',')}"/>
	<c:set var ="serviceLevelVaSelected" value=""/>
		
	<select multiple id="serviceLevel" class="editable pharmEditScreen" style="display: block; opacity: 1;" name="serviceLevel">	  
	  <c:forEach var="serviceLevelItem" items="${serviceLevelMap}">
	     <c:forEach var="serviceLevelVal" items="${serviceLevelValList}">	
	     <c:if test="${serviceLevelItem.key == serviceLevelVal}">	     
	     <c:set var ="serviceLevelVaSelected" value="selected='selected'"/>
	     </c:if>        
        </c:forEach>        
        <option value="${serviceLevelItem.key}" ${serviceLevelVaSelected}>${serviceLevelItem.value}</option>
        <c:set var ="serviceLevelVaSelected" value=""/>
    </c:forEach>
	 </select>	 
	
	</div>
	
	<div id="SPECIALTY_ID" class="displayable" style="display: block; opacity: 1;" title="ID to indicate the nature of a pharmacy">
	<label for="specialtyId">
	Specialty ID:
	<span class="requiredField">
    <span class="required">(Required)</span> 
    </span>
	</label>
	<select   id="specialtyId" class="editable pharmEditScreen" style="display: block; opacity: 1;" name="specialtyId">	  
	  <c:forEach var="specailityItem" items="${specialityMap}">
        <option value="${specailityItem.key}" ${specailityItem.key == pharmacyInfo.specialtyId ? 'selected="selected"' : ''}>${specailityItem.value}</option>
    </c:forEach>
	 </select>	 
	</div>
	
	<div id="STATE_LICENSE_NUMBER" class="displayable" style="display: block; opacity: 1;" title="Pharmacy's State License Number">
	<label for="stateLicenseNumber">
	State License Number:
	</label>
	<input id="stateLicenseNumber" class="editable pharmEditScreen" type="text" value="${ pharmacyInfo.stateLicenseNumber}"  size="20" maxlength="35" style="display: block; opacity: 1;" name="stateLicenseNumber">
	</div>
		
	<div id="TWENTY_FOUR_HOUR_FLAG" class="displayable" style="display: block; opacity: 1;" title="Indicates 24-hour pharmacy">
	<label for="twentyFourHourFlag">
	Twenty Four Hour Flag:
	</label>	
	<select id="twentyFourHourFlag" class="editable pharmEditScreen" style="display: block; opacity: 1;" name="twentyFourHourFlag">   
	  <option value="0"  ${pharmacyInfo.twentyFourHourFlag == 0 ? 'selected="selected"' : ''}>No</option><%-- No --%>
	  <option value="1"  ${pharmacyInfo.twentyFourHourFlag == 1 ? 'selected="selected"' : ''}>Yes</option><%-- Yes --%>	
	 </select>
	 
	</div>
		
	<div id="UPDATED_DATE" class="displayable" style="display: block; opacity: 1;">
	<label for="updatedDate">
	Updated Date:<span class="pharmacyAddFormReadOnlyField">(Read Only)</span>
	</label>
	
	<fmt:formatDate  pattern="MM/dd/yyyy" value="${pharmacyInfo.updatedDate}" var="parseDateVal"/>
	<input id="updatedDate" class="editable wizardReadonly" type="text"  value="${ parseDateVal}"  readonly="readonly" size="20" maxlength="35" style="display: block; opacity: 1;" name="updatedDate" title="Date of last update">
	</div>

	<div>
	<%-- We need this to query the record as NCPDP ID can change --%>
	<input id="pharmacyId"  type="text" value="${ pharmacyInfo.pharmacyId}"  readonly="readonly"  style="display: none; opacity: 0;" name="pharmacyId">
	</div>
	<div class="buttons">
      <button dojoType="dijit.form.Button" type="submit" disabled id="pharmUpdateButton" >Update </button>
      <button dojoType="dijit.form.Button" type="button" id="pharmInfoButton"  onclick="goToPharmacyInfo();">Return To Pharmacy Information </button>  
     </div>
  
    </div>
</form:form>

<span id="pharmacyEditScreen" tabindex="0"  style="width: 1125px; height: 213px; display:block;"></span>
</div>
</div>
