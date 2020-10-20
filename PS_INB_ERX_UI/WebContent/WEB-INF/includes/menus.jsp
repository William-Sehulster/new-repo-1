<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="inb-erx"%>

<inb-erx:menuItem name="Home" path="inb-erx/homepage" id="index"/>
<inb-erx:menuItem name="Pharmacy Management" path="inb-erx/managePharm/main"  id="managepharmacy" pagePermissions="SYSTEM_ADMN,PHARM_MGR,PBM_ADMN" />
<inb-erx:menuItem name="Track/Audit" path="inb-erx/track/main"  id="trackeRx" pagePermissions="SYSTEM_ADMN,PHARM_MGR,PBM_ADMN,PHARM_TECH"/>	
<inb-erx:menuItem name="Reports" path="inb-erx/reports/main"  id="reports" pagePermissions="SYSTEM_ADMN,PHARM_MGR,PBM_ADMN,PHARM_TECH,READONLY"/>
<inb-erx:menuItem name="User Management" path="inb-erx/manageUsers/main"  id="manageusers" pagePermissions="SYSTEM_ADMN"/>	
<inb-erx:menuItem name="Help" path="" id="help" onclick="return openHelp();" />

