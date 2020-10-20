<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<div id="userRoles">
	<h2 class="titleBar"><span>&nbsp;Users</span>	
	</h2>
	<form:form name="manageUsersForm" id ="manageUsersForm" modelAttribute="userManagementModel"	method="POST" action="${pageContext.request.contextPath}/inb-erx/manageUsers/saveUserData">
     <c:if test="${not empty data.errorMessage }">
		<div id="errorMessages" class="error" aria-describedby="" tabindex="0">
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
	 <form:hidden   path="deleteRecords" value="" />     
      
		 <div class="divUserMgmtTable" tabindex="1">		
			<div class="divUserMgmtTableBody">
				<div class="divUserMgmtTableHeaderRow">
					<div class="divUserMgmtTableCell">&nbsp;Delete Record</div>
					<div class="divUserMgmtTableCell">&nbsp;&nbsp;First Name</div>
					<div class="divUserMgmtTableCell">&nbsp;Last Name</div>
					<div class="divUserMgmtTableCell">&nbsp;&nbsp;User ID</div>
					<div class="divUserMgmtTableCell">&nbsp;&nbsp;Pharmacy Manager</div>
					<div class="divUserMgmtTableCell">&nbsp;&nbsp;PBM Admin</div>
					<div class="divUserMgmtTableCell">&nbsp;Pharmacy Tech</div>
					<div class="divUserMgmtTableCell">&nbsp;&nbsp;Administrator</div>
				</div>
				
				<c:forEach var="item" items="${userMgmt}" varStatus="countVar">
				<div class="divUserMgmtTableRow">
					<div class="divUserMgmtTableCellCheckbox">
					<input id="deleteRecord${countVar.count}" class="editable" type="checkbox" value=""  size="2" maxlength="2" style="display: block; opacity: 1;" name="deleteRecord${countVar.count}" title="Delete record checkbox for row ${countVar.count}" onclick="UM_DeleteRows(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCell">
					<input id="firstNameRow${countVar.count}" class="editable" type="text" value="${item.firstName}"  size="20" maxlength="50" style="display: block; opacity: 1;" name="firstNameRow${countVar.count}" title="First name of user for row ${countVar.count}" onchange="UM_inputValChanged(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCell">
					<input id="lastNameRow${countVar.count}" class="editable" type="text" value="${item.lastName}"  size="20" maxlength="50" style="display: block; opacity: 1;" name="lastNameRow${countVar.count}" title="Last name of user for row ${countVar.count}" onchange="UM_inputValChanged(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCell">
					<input id="userIDRow${countVar.count}" class="editable" type="text" value="${item.userName}"  size="18" maxlength="20" style="display: block; opacity: 1;" name="userIDRow${countVar.count}" title="VA network user ID (Example: VHAISWXXXXXX) for row ${countVar.count}" onchange="UM_inputValChanged(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCellCheckbox">
					<input id="pharmManagerRow${countVar.count}" class="editable" type="checkbox" ${item.pharmMgr == true ?'checked=checked':'' }  size="2" maxlength="2" style="display: block; opacity: 1;" name="pharmManagerRow${countVar.count}" title="Pharmacy manager checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCellCheckbox">
					<input id="pbmAdminRow${countVar.count}" class="editable" type="checkbox"  ${item.pbmAdmn == true ?'checked=checked':''}  size="2" maxlength="2" style="display: block; opacity: 1;" name="pbmAdminRow${countVar.count}" title="PBM admin checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCellCheckbox">
					<input id="pharmTechRow${countVar.count}" class="editable" type="checkbox"  ${item.pharmTech == true ?'checked=checked':''}  size="2" maxlength="2" style="display: block; opacity: 1;" name="pharmTechRow${countVar.count}" title="Pharmacy Tech checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});">
					</div>
					<div class="divUserMgmtTableCellCheckbox">
					<input id="administratorRow${countVar.count}" class="editable" type="checkbox" ${item.systemAdmn == true ?'checked=checked':''}  size="2" maxlength="2" style="display: block; opacity: 1;" name="administratorRow${countVar.count}" title="Administrator checkbox for row ${countVar.count}" onclick="UM_OtherChkBox(this,${countVar.count}, ${item.recId});">
					</div>
				</div>
				</c:forEach>
				
				
			</div>
		</div>  
      
      <div class="manageUsersFields">
      <br>  
      <br>
       <br>
       <strong> Add User:</strong>   
       </div>
       <div class="manageUsersFields">          
      <label for="addUserText">User ID:
      <span class="manageusersRequiredField">
      <span class="manageusersRequired">(Required)</span> 
      </span>
		</label>
		<form:input path="addUserText" maxlength="20" title="VA network user ID (Example: VHAISWXXXXXX)" />
      </div>
      <div class="manageUsersFields">      
      <label for="addFirstNameText">First Name:
	  </label>
		<form:input path="addFirstNameText" maxlength="50" title="First name of user"/>
      </div>
      <div class="manageUsersFields">      
      <label for="addLastNameText">Last Name:
	  </label>
		<form:input path="addLastNameText" maxlength="50" title="Last name of user" />
      </div>
     <div  class="manageUsersFields" title="Application user roles. To assign a role to the user, click a role in the User Roles selection box. The role will be highlighted blue.">	
		<label for="userRolesSelect">
		User Roles:		
		</label>		
		<select multiple id="userRolesSelect"  class="manageusersSelect" name="userRolesSelect">	  
	        <option value="pharmMgr" >Pharmacy Manager</option> 
	        <option value="pbmAdmn" >PBM Admin</option> 
	        <option value="pharmTech" >Pharmacy Tech</option> 
	        <option value="systemAdmn" >Administrator</option> 
		 </select>
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
	</form:form>  
</div> 
<div class="manageUsersFields">
	<p>
		 <br>Please note: You can add new user and update existing users at the same time.
	</p>
</div>
