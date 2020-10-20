<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ attribute name="modelAttribute" required="true"%>
<%@ attribute name="displayErrorHeader" required="false"
    description="Can choose to hide error header.  The default is to display it."%>
<%@ attribute name="errorType" required="false"
	description="Can be field, global or all.  The default is global only."%>

<div id="userMessages">
	<c:set var="inb-erxErrors" value="" />
	<c:set var="hideErrorDiv" value="none" />
	<spring:hasBindErrors name="${modelAttribute}">
		<c:choose>
			<c:when test="${errorType == 'all' }">
				<c:set var="inb-erxErrors" value="${errors.allErrors}" />
			</c:when>
			<c:when test="${errorType == 'field' }">
				<c:set var="inb-erxErrors" value="${errors.fieldErrors }" />
			</c:when>
			<c:when test="${errorType == 'global' }">
				<c:set var="inb-erxErrors" value="${errors.globalErrors}" />
			</c:when>
			<c:otherwise>
				<c:set var="inb-erxErrors" value="${errors.globalErrors}" />
			</c:otherwise>
		</c:choose>

		<c:if test="${fn:length(inb-erxErrors) > 0}">
			<c:set var="hideErrorDiv" value="block" />
		</c:if>
	</spring:hasBindErrors>
	
	<c:forEach begin="1" end="${fn:length(inb-erxErrors)}" varStatus="count">
       <c:set var="describedBy" value="${describedBy } errorOnPage${count.count }">
       
       </c:set>
    </c:forEach>
    
	<div id="errorMessages" class="error" style="display: ${hideErrorDiv}" tabindex="0" aria-describedby="${describedBy}">
		<c:choose>
            <c:when test="${displayErrorHeader=='false'}">
            </c:when>
            <c:otherwise>
                <p id="errorTitle">
                    <font class="errorHeader"><spring:message code="label.error.header" /> </font><br />
                </p>
            </c:otherwise>
        </c:choose>
		
		<div id="errorMessageText">
			<c:forEach items="${inb-erxErrors}" var="error" varStatus="status">
				<p id="errorOnPage${status.count}">
					&bull;
					<spring:message message="${error}" />
				</p>
			</c:forEach>
		</div>
	</div>
	<c:choose>
		<c:when test="${fn:length(warningMessages) > 0}">
			<c:set var="warningDivStyle" value="block" />
		</c:when>
		<c:otherwise>
			<c:set var="warningDivStyle" value="none" />
		</c:otherwise>
	</c:choose>
	<div id="warningMessages" class="warning"
		style="display: ${warningDivStyle}">
		<c:if test="${fn:length(warningMessages) > 0}">
			<p>
				<font class="warningHeader"><spring:message
						code="label.warning.header" /> </font><br />
			<div id="warningMessageText">
				<ul>
					<c:forEach var="warningMessage" items="${warningMessages}">
						<li>${warningMessage}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>

	<c:choose>
		<c:when test="${fn:length(informationMessages) > 0}">
			<c:set var="infoDivStyle" value="block" />
		</c:when>
		<c:otherwise>
			<c:set var="infoDivStyle" value="none" />
		</c:otherwise>
	</c:choose>
	<div id="infoMessages" class="informational noneditable"
		style="display: ${infoDivStyle}">
		<c:if test="${fn:length(informationMessages) > 0}">
			<p>
				<font class="informationalHeader"><spring:message
						code="label.informational.header" /> </font><br />
			<div id="infoMessageText">
				<ul>
					<c:forEach var="infoMessage" items="${informationMessages}">
						<li>${infoMessage}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>
	</div>
</div>
