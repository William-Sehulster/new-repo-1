<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="inb-erx" uri="/WEB-INF/tags"%>

<div class="buttons editable" id="wtButtons"  style="display:none;">
	<c:forEach var="crtAction" items="${allowableActions}">
		<c:choose>
			<c:when test="${crtAction eq 'Modify'}">
				<button type="submit" id="wtModify" value="Modify" class="button">
					<spring:message code="wizard.button.modify" />
				</button>
			</c:when>
			<c:when test="${crtAction eq 'Reject'}">
				<button type="submit" id="wtReject" value="Reject" class="button negative">
					<spring:message code="wizard.button.reject" />
				</button>
			</c:when>
			<c:when test="${crtAction eq 'Approve'}">
				<button type="submit" id="wtApprove" value="Approve" class="button">
					<spring:message code="wizard.button.approve" />
				</button>
			</c:when>
			<c:when test="${crtAction eq 'Submit_for_Delete'}">
				<button type="submit" id="wtSubmit_for_Delete" 	value="Submit_for_Delete" class="button negative">
					<spring:message code="wizard.button.submitdelete" />
				</button>
			</c:when>
			<c:when test="${crtAction eq 'Delete'}">
				<button type="submit" id="wtDelete" value="Delete" 	class="button negative">
					<spring:message code="wizard.button.delete" />
				</button>
			</c:when>

			<c:when test="${crtAction eq 'Submit_as_Reviewed'}">
				<button type="submit" id="wtSubmit_as_Reviewed"	value="Submit_as_Reviewed" class="button">
					<spring:message code="wizard.button.submitreview" />
				</button>
			</c:when>
			<c:when test="${crtAction eq 'Customize'}">
				<button type="submit" id="wtCustomize" value="Customize"	class="button">
					<spring:message code="wizard.button.customize" />
				</button>
			</c:when>
		</c:choose>
	</c:forEach>
	
</div>

