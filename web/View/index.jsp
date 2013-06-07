<%-- 
    Document   : index
    Created on : 05/02/2013, 09:18:24 PM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="/struts-tags" prefix="s" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/cssActas.css" />
        <title>JSP Page</title>
    </head>
    <body>
        <div id="contenido">
            <center>
        <h1>Bienvenido!</h1>
        <s:label value="%{msj}"/>
        <s:form action="validar">
            <s:textfield label="Usuario" name="usuario.cedula"/>
            <s:password label="Clave" name="usuario.password"/>
            <s:submit label="prueba de boton" value="Entrar"/>
            
        </s:form>
            </center>        
        </div>
        
        
        
    </body>
   
</html>
