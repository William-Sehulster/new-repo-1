<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<script type="text/javascript" src="<spring:url value="/inb-erx/resources/dojo/dojo.js" />"> </script>

<tiles:importAttribute name="scripts" />

<c:forEach var="script" items="${scripts}">
<script type="text/javascript" src="<spring:url value="/scripts/${script.value}"/>"> </script>
</c:forEach>
