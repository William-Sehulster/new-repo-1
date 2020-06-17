<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isErrorPage="true"%>

<html>
 <head>
  <title>404 - Page Not Found</title>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="0" />
  <link rel="stylesheet" type="text/css"    href="${pageContext.request.contextPath}/public/style/main.css"></link>
 </head>
 <body>
 
  <div id="link508"><a href="#MainContent508"><img alt="Skip to main content" src="${pageContext.request.contextPath}/public/images/1.gif" width="1"></a></div>
  <div id="container">
   <jsp:include page="includes/header.jsp" />
   
   <jsp:include page="includes/navigation.jsp" />   
   <a name="#MainContent508"></a>
   </br>
   </br>
   </br>
   <p>
   <div>
    <h3>
    The request page was not found.
    </h3>   
   </div>
   </p>   
   <jsp:include page="includes/footer.jsp" />
  </div>
 </body>
</html>
