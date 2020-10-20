<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />

<div id="ManagePharm">
<h1 class="titleBar"><span class="headerText">Pharmacy Management</span></h1>
<c:if test="${not empty data.errorMessage }">
<div id="errorMessages" class="error" aria-describedby="" tabindex="2">
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
<div id="successMessages" class="warning">
<p>${data.successMessage}
 <br>
</p>
</div>
</c:if>

<div id="pharmacyManagement">
<form:form id="pharmacyFilterForm"  name="pharmacyFilterForm" method="POST" action="${pageContext.request.contextPath}/inb-erx/managePharm/addPharmacy">

<label for="visnSelection" style="width: 40px; padding-top: 6px; padding-left: 5px;">VISN: </label> 
<div id="visnSelect" tabindex="3"  style="width: 40px; ">
	<script>
	       getPharmVisnSelect("inb-erx","pharmacyFilterForm", "managePharm/getVisnSelect");
	</script>
</div>

  
  <button dojoType="dijit.form.Button" type="submit" id="newPharmAddButton" >Add Pharmacy </button>
    <br/>
</form:form>

<span id="pharmacyList" aria-labeledby="Pharmacy List" tabindex="4"  style="width: 1125px; height: 213px; display:block;"></span>
  
<span id="pharmMgmtRecNumberTitle" style="width: 250px;padding-top:20px;display: none;">
Number of Records:
<span id="pharmMgmtRecNumber" style="position:relative;top:-14px;left:112px;display: none;">
</span>
</span>
</div>
</div>