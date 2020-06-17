<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page isErrorPage="true"%>

<html lang="en">
 <head>
  <title>Access Denied</title>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="0" />
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css"    href="${pageContext.request.contextPath}/public/style/main.css"></link>
 </head>
 <body>
 
  <div id="link508"><a href="#MainContent508"><img alt="Skip to main content" src="${pageContext.request.contextPath}/public/images/1.gif" width="1"></a></div>
  <div id="container">
   <jsp:include page="includes/header.jsp" />
   
   <jsp:include page="includes/navigation.jsp" />      
   <div>
   <br>
   <p style="font-size: 16px; font-weight: bold;">   
    Access Denied.    
    </p>
    <br>   
   </div>      
   <div>
   <p>
    <h3>
    You are not allowed to view this content.
    </h3>  
    </p>   
   </div>    
   <jsp:include page="includes/footer.jsp" />
  </div>
 </body>
</html>
