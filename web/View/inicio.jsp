<%-- 
    Document   : inicio
    Created on : 06/02/2013, 12:43:05 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%@taglib uri="/struts-tags" prefix="s" %>
    <%@taglib uri="/struts-jquery-tags" prefix="sj"%>
    <head>
        <sj:head compressed="false"/>
        <title>JSP Page</title>
        <link rel='stylesheet' type='text/css' href="${pageContext.request.contextPath}/View/style.css" />

        <script type='text/javascript' src='${pageContext.request.contextPath}/View/infogrid.js'></script>   
    </head>
    <body>
        <div id="page-wrap">

            <div class="info-col">

                <h2>Cuenta</h2>

                <a class="image ej" href="#">View Image</a>

                <dl>
                    <dt>Movimientos</dt>
                    <dd>
                        <sj:a id="ajaxTarjetas" 
                              href="getTarjetas" 
                              targets="infor" 
                              indicator="indicator" 
                              >
                            Tarjetas
                        </sj:a>
                        <br/>
                        <sj:a id="ajaxDepositar" 
                              href="irdepositar" 
                              targets="infor" 
                              indicator="indicator"      
                              >
                            Depositos</sj:a>
                            <br/>
                        <sj:a id="ajaxRetitar" 
                              href="irretirar" 
                              targets="infor" 
                              indicator="indicator"
                              >
                            Retiros
                        </sj:a>

                    </dd>
                    <dt>Servicios</dt>
                    <dd>
                        
                        <sj:a id="ajaxLuz"
                              value="Luz"
                              name="aServ"
                              href="irservicios" 
                              targets="infor" 
                              indicator="indicator">
                            Consulta de servicios
                        </sj:a>
                        
                    </dd>
                    <dt>Consejos</dt>
                    <dd>No dar tu cuenta de acceso por medio de mensajes.<hr/>
                        No accesar desde lugares o equipos publicos.
                    </dd>
                </dl>

            </div>

            <center>
                <div id="infor">
                    <s:label value="%{msj}"/>
                </div></center>
        </div>
    </body>
</html>
