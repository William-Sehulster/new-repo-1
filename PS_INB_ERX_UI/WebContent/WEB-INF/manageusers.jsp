<%-- header, body start and end includes --%>
<jsp:include page="/WEB-INF/layouts/headerLayout.jsp" />

<%-- add page specific css --%>
<link rel="stylesheet" type="text/css" href="/inbound/style/main.css">
<link rel="stylesheet" type="text/css" href="/inbound/style/tables.css">

<%-- add page specific js --%>
<script type="text/javascript" src="/inbound/scripts/manageusers.js"> </script>
<script type="text/javascript" src="/inbound/scripts/inbound.js"> </script>

<title>User Management</title>

<%-- page body start --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutStart.jsp" />



<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="userRoles">
	<h2 class="titleBar"><span>&nbsp;User Management</span>	
	</h2>
	<form:form name="manageUsersForm" id ="manageUsersForm" modelAttribute="userManagementModel"	method="POST" action="${pageContext.request.contextPath}/inb-erx/manageUsers/saveUserData">
     <c:if test="${not empty data.errorMessage }">
		<div id="errorMessages" class="error" aria-describedby="message section" tabindex="0">
		<p id="errorTitle">
		<font class="errorHeader">Error Messages: </font>
		<br>
		</p>
		<div id="errorMessageText">
		<c:forEach items="${data.errorMessage}" var="error" varStatus="status">
						<p id="errorOnManageUser${status.count}">
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

	 <form:hidden   path="modifiedIds" value="" />
	 <form:hidden   path="modifiedFields" value="" />
	 <form:hidden   path="enableDisableRecords" value="" />     
	 <form:hidden   path="stationIdsSelected" value="" />   
	 <form:hidden   path="modifiedStationIds" value="" />
         <div id="divUserMgmtTableInfo" style="display: none;">
         current users in the system.
         </div>
		 <div class="divUserMgmtTable" tabindex="0" role="table" aria-label="Users" aria-describedby="divUserMgmtTableInfo">		
			<div class="divUserMgmtTableBody">
				<div class="divUserMgmtTableHeaderRow" role="row">
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCellToggleUser">Enable/Disable&nbsp;User</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">First Name</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">Last Name</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">User ID</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCellStatioinID">Station ID</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">Pharmacy Manager</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">PBM Admin</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">Pharmacy User</div>
					<div role="columnheader" tabindex="0" class="divUserMgmtTableCell">Administrator</div>
				</div>
				
				<c:forEach var="item" items="${userMgmt}" varStatus="countVar">
				      <c:choose> 
				      <c:when test="${item.userEnabled eq false }">
				       <c:set  var="disabledField"  value="disabled" scope="page"/> 
				      </c:when>   
				       <c:otherwise>
					   <c:set  var="disabledField" value="" scope="page"/>
					   </c:otherwise>
				       </c:choose>
				<div class="divUserMgmtTableRow" role="row" aria-describedby="Row ${countVar.count}">
					<div class="divUserMgmtTableCellCheckbox" role="cell">
					<input id="deleteRecord${countVar.count}" class="editable" type="checkbox" value=""  size="2" maxlength="2" style="display: block; opacity: 1;" name="enableDisableRecord${countVar.count}" title="Enable / Disable record checkbox for row ${countVar.count}" onclick="UM_EnableDisableRows(this,${countVar.count}, ${item.recId},${item.userEnabled});">
					</div>
					<div class="divUserMgmtTableCell" role="cell">
					<input id="firstNameRow${countVar.count}" class="editable" type="text" value="${item.firstName}"  size="20" maxlength="50" style="display: block; opacity: 1;" name="firstNameRow${countVar.count}" title="First name of user for row ${countVar.count}" onchange="UM_inputValChanged(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
					<div class="divUserMgmtTableCell" role="cell">
					<input id="lastNameRow${countVar.count}" class="editable" type="text" value="${item.lastName}"  size="20" maxlength="50" style="display: block; opacity: 1;" name="lastNameRow${countVar.count}" title="Last name of user for row ${countVar.count}" onchange="UM_inputValChanged(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
					<div class="divUserMgmtTableCell" role="cell">
					<input id="userIDRow${countVar.count}" class="editable" type="text" value="${item.userName}"  size="18" maxlength="20" style="display: block; opacity: 1;" name="userIDRow${countVar.count}" title="VA network user ID (Example: VHAISWXXXXXX) for row ${countVar.count}" onchange="UM_inputValChanged(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
					<div class="divUserMgmtTableCell" role="cell">
					<span id="stationIDSpanRow${countVar.count}">
					<c:choose> 
				      <c:when test="${item.stationIds ne 'All' }">
				        <c:set  var="stationIdsDisplayVar"  value="${fn:substring(item.stationIds,0,20)}.." scope="page"/> 
				      </c:when>   
				      <c:otherwise>
					   <c:set  var="stationIdsDisplayVar" value="${item.stationIds}" scope="page"/>
					  </c:otherwise>
				    </c:choose>
				     <c:choose> 
				      <c:when test="${item.userEnabled eq false }">
				      ${stationIdsDisplayVar} 
				      </c:when>   
				       <c:otherwise>
					   <a aria-label="Change Station Ids " id="stationIDRow${countVar.count}" href="#" onclick="createSelectDialog(this.id,'${item.stationIds}',${item.recId});"  title="Station IDs for row ${countVar.count}">${stationIdsDisplayVar}</a> 
					   </c:otherwise>
				       </c:choose>		
				       </span>								
					</div>
					<div class="divUserMgmtTableCellCheckbox" role="cell">
					<input id="pharmManagerRow${countVar.count}" class="editable" type="checkbox" ${item.pharmMgr == true ?'checked=checked':'' }  size="2" maxlength="2" style="display: block; opacity: 1;" name="pharmManagerRow${countVar.count}" title="Pharmacy manager checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
					<div class="divUserMgmtTableCellCheckbox" role="cell">
					<input id="pbmAdminRow${countVar.count}" class="editable" type="checkbox"  ${item.pbmAdmn == true ?'checked=checked':''}  size="2" maxlength="2" style="display: block; opacity: 1;" name="pbmAdminRow${countVar.count}" title="PBM admin checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
					<div class="divUserMgmtTableCellCheckbox" role="cell">
					<input id="pharmUserRow${countVar.count}" class="editable" type="checkbox"  ${item.pharmUser == true ?'checked=checked':''}  size="2" maxlength="2" style="display: block; opacity: 1;" name="pharmUserRow${countVar.count}" title="Pharmacy User checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
					<div class="divUserMgmtTableCellCheckbox" role="cell">
					<input id="administratorRow${countVar.count}" class="editable" type="checkbox" ${item.systemAdmn == true ?'checked=checked':''}  size="2" maxlength="2" style="display: block; opacity: 1;" name="administratorRow${countVar.count}" title="Administrator checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});" ${disabledField}>
					</div>
				</div>
				</c:forEach>
				
				
			</div>
		</div>  
      
      <div class="manageUsersFields">
      <br>  
      <br>
       <br>
       <span  class="show" tabindex="0" aria-labelledby="Add User" style="width: 60px;"><strong> Add User:</strong></span>   
       </div>
       <div  tabindex="0" class="manageUsersFields">          
      <label for="addUserText">User ID:
      <span class="manageusersRequiredField">
      <span class="manageusersRequired">(Required)</span> 
      </span>
		</label>
		<form:input path="addUserText" maxlength="20" title="VA network user ID (Example: VHAISWXXXXXX)" />
      </div>
      <div  tabindex="0" class="manageUsersFields">      
      <label for="addFirstNameText">First Name:
	  </label>
		<form:input path="addFirstNameText" maxlength="50" title="First name of user"/>
      </div>
      <div  tabindex="0" class="manageUsersFields">      
      <label for="addLastNameText">Last Name:
	  </label>
		<form:input path="addLastNameText" maxlength="50" title="Last name of user" />
      </div>      
      <div id="userRolesListBoxInfo" style="display: none;">
        User Roles multiple select listbox.
      </div>
     <div   tabindex="0"  class="manageUsersFields show" title="Application user roles. To assign a role to the user, click a role in the User Roles check box. The role will be checked or unchecked.">	
		<label for="userRolesSelect" aria-labelledby="User Roles" id="userrolelabel">
		User Roles:		
		</label> 		
		<select multiple="multiple" id="userRolesSelect"  class="manageusersSelect" name="userRolesSelect" role="listbox" aria-describedby="userRolesListBoxInfo" aria-multiselectable="true" onchange="setUserRoleSelectAria(this);">	  
	        <option value="pharmMgr" role="option">Pharmacy Manager</option> 
	        <option value="pbmAdmn" role="option">PBM Admin</option> 
	        <option value="pharmUser" role="option">Pharmacy User</option> 
	        <option value="systemAdmn" role="option">Administrator</option> 
		 </select>
		 
		 <div class="selectedStationdIdsLabelDiv" title="Selected Station IDs for the user to be added. ">
	  	 <label for="selectedStationdIds">Selected Stations IDs:<span class="manageusersRequiredField">
     	 <span class="manageusersRequired">(Required)</span>
     	 </span>      
	  </label>
      </div>  
	</div>	
	
	 <div id="stationIdsListBoxInfo" style="display: none;">
        Station Ids multiple select listbox.
      </div>
	<div  tabindex="0" class="manageUsersFields">      
      <label for="addStationId" id="stationIdlabel">Station ID:     
	  </label>
		   <select multiple="multiple"  id="addStationId"  name="addStationId" onchange="stationIdValueSelected();" style="float: left;" size="8" aria-describedby="stationIdsListBoxInfo" aria-multiselectable="true" role="listbox">
			  <c:forEach var="item" items="${userMgmtStationIds}">
		        <option value="${item.id}">${item.label}</option>
		     </c:forEach>
			</select>	
			
			<button  dojoType="dijit.form.Button" class="manageusersAddBtn" id="manageUsers_AddStationIdsBtn" disabled onClick="stationIdValueAddBtn();">
			Add
		  </button>	 
	   &nbsp;
	   <select multiple="multiple"  class="manageusersStationSelected" 	id="selectedStationdIds" name="selectedStationdIds" onchange="enableRemoveButton();" size="11" aria-multiselectable="true" role="listbox">
	   </select> 
	    &nbsp;
	   <button  dojoType="dijit.form.Button"  class="manageusersRemoveBtn" id="manageUsers_RemoveStationIdsBtn"	disabled onClick="stationIdValueRemoveBtn();">
			Remove
			</button> &nbsp;&nbsp;			
   </div>  
      
     <div>
     <p>
			<br>
			<br>
		&nbsp;
		</p>
     </div>
	<div>
		<p>
			<br>
			<br>
		&nbsp;
		</p>
	</div>
		<div class="buttons">			
			<button  dojoType="dijit.form.Button" id="addUserButton" type="submit" onclick="return processSubmit();">
				Save
			</button>
			<button		dojoType="dijit.form.Button" id="cancelButton" type="button" onclick="manageUserCancel();">Cancel</button>			
		</div> 
		<%-- Stationd Id Select Dialog Start --%>
			<div data-dojo-type="dijit/Dialog" id="stationIdSelectDialog" title="Update Station Ids"  style="width:100%;height: 400px; overflow: hidden">
		
		    <div class="dijitDialogPaneContentArea" style="width:1200px;height: 400px;overflow: hidden">
		      
		       <div class="selectedStationdIdsUpdateLabelDiv" title="Selected Station IDs for the user to be added. ">
			  	 <label for="selectedStationdIds">Selected Stations IDs:<span class="manageusersRequiredField">
		     	 <span class="manageusersRequired">(Required)</span>
		     	 </span>      
			    </label>
		      </div>  
		     <div id="stationIdsUpdateListBoxInfo" style="display: none;">
      		  Station Ids multiple select listbox.
      		</div>	        
		        <div   id="stationIdsUpdateIDiv" style="margin-top: 25px; display: block;">      
			      <label for="updateStationId" style="float: left;width: 5%;">Station ID:     
				  </label>
					   <select multiple="multiple"  id="updateStationId"  name="updateStationId" onchange="stationIdValueSelectedUpdate();" style="float: left;" size="8" aria-describedby="stationIdsUpdateListBoxInfo" aria-multiselectable="true" role="listbox">
						  <c:forEach var="item" items="${userMgmtStationIds}">
					        <option value="${item.id}">${item.label}</option>
					     </c:forEach>
						</select>	
						
						<button  dojoType="dijit.form.Button"  class="manageusersUpdateStationIdsAddBtn" id="manageUsers_AddStationIdsBtnForUpdate" disabled onClick="stationIdUpdateValueAddBtn();">
						Add
					  </button>	 
				   &nbsp;
				   <select multiple="multiple"   class="manageusersStationSelected"	id="selectedStationdIdsForUpdate" name="selectedStationdIdsForUpdate" onchange="" size="11" aria-multiselectable="true" role="listbox">
				   </select> 
				    &nbsp;
				   <button  dojoType="dijit.form.Button"  class="manageusersUpdateStationIdsRemoveBtn"  id="manageUsers_RemoveStationIdsBtnForUpdate"	 onClick="stationIdUpdateValueRemoveBtn();">
						Remove
						</button> &nbsp;&nbsp;			
   				</div>
   				
   				
				<div style="float: left;position: relative;top: 100px;margin-left: 0px;">
	   				  <button data-dojo-type="dijit/form/Button" type="button"  class="manageusersUpdateStationIdsUpdateBtn" id="manageUsers_UpdateStationIdsBtn" disabled onclick="dialogOnUpdate();">
			            Update
			        </button>
			        <button data-dojo-type="dijit/form/Button" type="button"  class="manageusersUpdateStationIdsCancelBtn" id="manageUsers_CancelStationIdsUpdateBtn" onclick="dialogOnCancel();">
			            Cancel
			        </button>
		        </div>
		    </div>	    
		</div>			
		 <%-- Stationd Id Select Dialog End --%>
		 <%-- Hidden multiselect for compare start --%>
		 <div  style="display: none;">
		 <select multiple  id="hiddenUpdateStationId"  name="hiddenUpdateStationId" style="display: none;">
						  <c:forEach var="item" items="${userMgmtStationIds}">
					        <option value="${item.id}">${item.label}</option>
					     </c:forEach>
		</select>
		<input type="hidden" id="stationIdTempIdentifier" value="">
		</div>	
		 
		  <%-- Hidden multiselect for compare end --%>  
	</form:form>  
</div> 
<div class="manageUsersFields">
	<p>
		 <br>Please note: You can add new user and update existing users at the same time.
	</p>
</div>

<%-- end body --%>
<jsp:include page="/WEB-INF/layouts/bodyLayoutEnd.jsp" />