<%-- 
    Document   : pagoservicios
    Created on : 11/02/2013, 03:33:02 PM
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
    <center>
        <h1><s:label value="%{tituloServicios}"/></h1>
        <s:form>
                        
            <sj:submit id="ajaxConsulta"
                              value="Consultar"
                              href="verificar" 
                              targets="infoPago" 
                              indicator="indicator"/>
                            
                        
        </s:form>
        <div id="infoPago" style="margin: 0% 25px"></div>
    </center>
    </body>
</html>
