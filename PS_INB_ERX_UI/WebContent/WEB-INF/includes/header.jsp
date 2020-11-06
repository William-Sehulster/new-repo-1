<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="user" value="${ sessionScope.sessionUser}" />
<noscript>
	<p>Your browser does not support JavaScript, or JavaScript has been
		disabled. JavaScript is required in order to use this application.</p>
</noscript>
<spring:url value="/images/inbound_banner.jpg" var="banner" />
<spring:url value="/images/1.gif" var="space" />
<spring:url value="/inb-erx/logout" var="logout" />

<div id="header">
	
	<div class="banner">
		<img src="${banner}" alt="U.S. Department of Veterans Affairs" />
	</div>

	<div class="welcome">
		<c:if test="${ user != null }">
			<p>
				Welcome,&nbsp;<b>${user.username} </b> &nbsp;|&nbsp; <a	class="headerLinks" href="${logout}">Logout</a>
			</p>
		</c:if>
	</div>
</div>

<br />
