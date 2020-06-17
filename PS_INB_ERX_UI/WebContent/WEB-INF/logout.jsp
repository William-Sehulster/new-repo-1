<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
 <head>
  <title>Inbound eRx Login</title>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="-1" />
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/public/style/main.css"></link>
 </head>
 <body>
  <div id="link508"><a href="#MainContent508"><img alt="Skip to main content" src="${pageContext.request.contextPath}/public/images/1.gif" width="1"></a></div>
  <div id="container">
  <jsp:include page="/WEB-INF/includes/header.jsp" /> 
   <hr />
   <a name="#MainContent508"></a>
   <div id="content">
     <h2 class="titleBar">Logout</h2>
     ${logoutMessage}
     <br>
     <br>      <a href="${pageContext.request.contextPath}/public/landing"><spring:message code="wizard.button.login"/></a>
   </div>
  <br/>
           <br/>   
          <hr />
  </div>
 </body>

 <head>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="-1" />
 </head>
</html>
