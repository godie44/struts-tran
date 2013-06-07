<%-- 
    Document   : retiros
    Created on : 16/02/2013, 10:31:09 AM
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
        <s:form action="retirar">
            <s:select 
                
                label="Tarjeta"  
                list="listaTarjetas"  
                name="tarjeta.numero" 
                listValue="numero"  
                listKey="numero"
                emptyOption="false"  
                headerKey="None"  
                headerValue="None"
                
                />
            
            <s:textfield label="Monto" name="transac.monto"/>
            <s:textfield label="Descripcion" name="transac.descripcion"/>
            <s:submit label="prueba de boton" value="Retirar"/>
            
        </s:form>
    </center>
    </body>
</html>
