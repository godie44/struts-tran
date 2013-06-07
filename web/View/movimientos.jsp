<%-- 
    Document   : movimientos
    Created on : 11/02/2013, 08:40:41 AM
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
        <table padding="3">
            <tr>
                <td>
                    Numero tarjeta
                </td>
                <td>
                    Fecha de vencimiento
                </td>
                <td>
                    Fecha de emision
                </td>
                <td>
                    Saldo
                </td>
            </tr>
            <s:iterator value="%{listaTarjetas}">
                <tr>
                    <td><s:property value="numero"/></td>
                    <td><s:property value="fechaemision"/></td>
                    <td><s:property value="fechavencimiento"/></td>
                    <td><s:property value="saldo"/></td>
                </tr>
            </s:iterator>
                
                
        </table>
        <s:label value="%{msj}"/>
    </body>
</html>
