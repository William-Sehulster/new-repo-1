<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:set var="user" value="${ sessionScope.sessionUser}" />


<h1 class="titleBar"><span class="headerText">Inbound eRx Homepage</span></h1>



<div id="compatWarning" style="width: 1000px;height: 200px;display: none;">
<br/>
COMPATIBILITY VIEW WARNING. ACTION REQUIRED. PLEASE READ.<br/>

In order for the Inbound eRx GUI to function properly in Internet Explorer, you will need to change your browser compatibility view settings. <br/>
 To do this: <br/>
 1) Select the gear icon from the top right corner<br/>
 2) Select Compatibility View settings<br/>
 3) Remove "va.gov" from Compatibility View<br/>
 4) Uncheck the checkbox next to "Display Intranet sites in Compatibility View" <br/>
</div>