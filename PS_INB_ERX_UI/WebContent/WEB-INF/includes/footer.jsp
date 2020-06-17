<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<c:set var="buildInfo" value="${sessionScope.buildInformation}" />
<div id="footer">
<hr/>
<div id="footerLinks" accesskey="y">
<ul class="footerMenu">
	<%@ include file="menus.jsp"%>
</ul>
 <hr /> 

<div id="buildInfo" align="center">
<c:if test="${ buildInfo != null }">
			<p>
				<label style="font-weight: bold;">Build:</label>&nbsp;<b>${buildInfo}</b>
			</p>
		</c:if>
</div>
</div>


</div>
