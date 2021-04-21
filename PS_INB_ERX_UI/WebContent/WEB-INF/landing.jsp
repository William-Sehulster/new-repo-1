<!DOCTYPE html>
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
  <meta charset="utf-8">
  <link rel="stylesheet" type="text/css"  href="${main}"></link>
 </head>
 <body>
 <div id="link508"><a href="#MainContent508"><img alt="Skip to main content" src="${spaceimg}" width="1"></a></div>  
 
  <div id="container">
   
    <jsp:include page="/WEB-INF/includes/header.jsp" /> 
   <hr />  
   <div id="content">
   <br />&nbsp;&nbsp;&nbsp;&nbsp;<br />
   
		<br/>
		<form action="${index}" method="post" >
		
		<div align="center">
		<p>	
		<h1><strong>Welcome to Inbound ePrescribing!</strong></h1>			
		</p>
		<p>
		<br>
WARNING - This system may contain Government information which is restricted to authorized<br>
users ONLY.  Unauthorized access, use, misuse, or modification of this computer system or of<br>
the data contained herein or in transit to/from this system constitutes a violation of Title 18,<br>
United States Code, Section 1030, and may subject the individual to Criminal and Civil penalties.<br>
		
		</p>
		<br/>		 
		  <button type="submit"  value="Accept" name="login">
		    Accept
		  </button>
		  <br/>
		  <p>${ sessionScope.loginErrorMessage}</p>
		  </div>

	<input  type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		</form>
   </div>  
           <br/>
           <br/>   
          <hr />
          </div>
 </body>
</html>
