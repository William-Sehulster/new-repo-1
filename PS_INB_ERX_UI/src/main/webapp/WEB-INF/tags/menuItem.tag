<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="path" required="true"%>
<%@ attribute name="pagePermissions" required="false" %>
<%@ attribute name="id" required="false" %>
<%@ attribute name="onclick" required="false" %>
<%@ attribute name="tabindex" required="false" %>
<c:set var="user" value="${ sessionScope.sessionUser}" />
<c:if test="${not empty user }">
<c:choose> 
<c:when test="${empty pagePermissions }">
      <c:choose> 
      <c:when test="${id eq 'help' }">
       <li ><a id="${id }" href="#"  onclick="${onclick}">${name}</a></li> 
      </c:when>   
       <c:otherwise>
	    <li ><a id="${id }" href="${pageContext.request.contextPath}/${path}" onclick="${onclick}" tabindex="${tabindex}">${name}</a></li>
	   </c:otherwise>
       </c:choose>
</c:when>
<c:otherwise>
	<c:forTokens items="${pagePermissions}" var="permission"  delims=",">
	
		<c:if test="${permission eq 'SYSTEM_ADMN' and fn:contains(user,'ROLE_SYSTEM_ADMN') }" >
			<c:set value="true" var="show" scope="page"/>
		</c:if>
		<c:if test="${permission eq 'PHARM_MGR' and fn:contains(user,'ROLE_PHARM_MGR') }" >
			<c:set value="true" var="show" scope="page"/>
		</c:if>
		
		<c:if test="${permission eq 'PBM_ADMN' and fn:contains(user,'ROLE_PBM_ADMN') }" >
			<c:set value="true" var="show" scope="page"/>
		</c:if>
		
		<c:if test="${permission eq 'PHARM_USER' and fn:contains(user,'ROLE_PHARM_USER') }" >
			<c:set value="true" var="show" scope="page"/>
		</c:if>
	
		<c:if test="${permission eq 'READONLY' and fn:contains(user,'ROLE_READONLY') }" >
			<c:set value="true" var="show" scope="page"/>
		</c:if>
			
	</c:forTokens>

	<c:if test="${show eq 'true'}" >
	<li ><a id="${id }" href="${pageContext.request.contextPath}/${path}" onclick="${onclick}">${name}</a></li>
	 </c:if>
</c:otherwise>
</c:choose>
</c:if>
