<%-- 
    Document   : saldo
    Created on : 10/02/2013, 01:29:20 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <%@taglib uri="/struts-tags" prefix="s" %>
     <%@taglib uri="/struts-jquery-tags" prefix="sj"  %>
     <head>
        <sj:head compressed="false"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <s:url var="ajaxTest" value="listaTarjetas.action"/>
        <sj:div href="%{ajaxTest}">
        a
        </sj:div>
        
    </body>
</html>
