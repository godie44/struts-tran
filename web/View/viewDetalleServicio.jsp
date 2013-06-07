<%-- 
    Document   : viewDetalleServicio
    Created on : 18/02/2013, 03:07:00 PM
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
        <title>Detalle</title>
    </head>
    <body>
        <table style="border: 1px;padding: 2">
            <tr>
                    <td>ID</td>
                    <td>Tipo</td>
                    <td>Fecha Inicio</td>
                    <td>Fecha corte</td>
                    <td>Cedula</td>
                    <td>Estado</td>
                    <td>Monto</td>
                </tr>
        <s:iterator value="%{listaRecibos}">
                <tr>
                    <td><s:property value="id"/></td>
                    <td><s:property value="tipo"/></td>
                    <td><s:property value="fecha1"/></td>
                    <td><s:property value="fecha2"/></td>
                    <td><s:property value="cedula"/></td>
                    <td><s:property value="estado"/></td>
                    <td><s:property value="monto"/></td>
                </tr>
            </s:iterator>
                </table>
                <br/><br/>
                
                <s:form action="pagar">
                <s:select 
                
                label="Servicio"  
                list="listaRecibos"  
                name="recibo.id" 
                listValue="id"  
                listKey="id"
                emptyOption="false"  
                headerKey="None"  
                headerValue="None"
                
                />
                
                
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
            <s:submit label="prueba de boton" value="Pagar"/>
                </s:form>
    </body>
</html>
