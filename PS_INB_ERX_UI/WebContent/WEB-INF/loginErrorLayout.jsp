<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:url value="/style/main.css" var="main"/>
<spring:url value="/inb-erx/index" var="index"/>
<spring:url value="/images/1.gif" var="spaceimg"/>
<html>
 <head>
  <title>Inbound eRx</title>
  <meta http-equiv="pragma" content="no-cache" />
  <meta http-equiv="cache-control" content="no-cache" />
  <meta http-equiv="expires" content="-1" />
  <link rel="stylesheet" type="text/css"   href="${main}"></link>
 </head>
 <body>
  <div id="link508"><a href="#MainContent508"><img alt="Skip to main content" src="${spaceimg}" width="1"></a></div>
  <div id="container">   
    <jsp:include page="/WEB-INF/includes/header.jsp" /> 
   <hr />  
   <div id="content">  
		<br/>
		<form action="${index}" method="post" >
		
		<div align="center">
			 <br/>			  
		  <p style="font-weight: bold;color: red">${ sessionScope.loginErrorMessage}</p>
		  </div>
		  
		</form>
   </div>            
           <br/>   
          <hr />
          </div>
 </body>
</html>
