<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<tiles:importAttribute name="stylesheets" />

<link rel="stylesheet" type="text/css" href="<c:url value="/inb-erx/resources/dojo/resources/dojo.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/inb-erx/resources/dijit/themes/claro/claro.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/inb-erx/resources/dojox/grid/resources/claroGrid.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/inb-erx/resources/dojox/grid/enhanced/resources/EnhancedGrid.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/inb-erx/resources/dojox/grid/enhanced/resources/claro/EnhancedGrid.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/inb-erx/resources/dojox/editor/plugins/resources/css/Save.css"/>">


<c:forEach var="stylesheet" items="${stylesheets}">
<link rel="stylesheet" type="text/css" href="<spring:url value="/style/${stylesheet.value}"/>">
</c:forEach>