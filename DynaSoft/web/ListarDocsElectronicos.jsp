<%-- 
    Document   : ListarDocsElectronicos
    Created on : 21 jun. 2022, 00:16:01
    Author     : pablo.elizondo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0m maxium-scale=1.0, minium-scale=1.0">
        
        <%@include file = "Templates/Bootstrap.jsp"%>
        <link rel="stylesheet" type="text/css" href="Styles/cssListarDocumentos.css">
        <link rel="icon" href="Sources/Images/logo_cfs-color.png">
        
        <title>CFS DynaSoft</title>
    </head>
    
    
    <body class="body">
        <%@include file = "Templates/Header.jsp" %>
        
        <section class="section-listarDocs">
            <container class="container-listarDocs">
                <div class="div-form">
                    <form class="form-listarDocs" action="ServletConsultarDocumentos" method="post" nam="myForm2">
                        <div class="columns-2 w-row">
                            <div class="column-3 w-col w-col-4 columnsListarDocs">
                                <label for="field" class="field-label-3 label-listarDocs">Fecha Inicio</label>
                                <input type="date" class="date-listarDocs" required="true" oninvalid="this.setCustomValidity('Ingresa una fecha correcta')"
                                       oninput="setCustomValidity('')" name="fecha1"/>
                            </div>
                            
                            <div class="column-4 w-col w-col-4 columnsListarDocs">
                                <label for="field-2" class="field-label-4 label-listarDocs">Fecha cierre</label>
                                <input type="date" class="date-listarDocs" required="true" oninvalid="this.setCustomValidity('Ingresa una fecha correcta')"
                                       oninput="setCustomValidity('')" name="fecha2"/>
                            </div>
                            
                            <div class="column-5 w-col w-col-4 columnsListarDocs">
                                <button type="submit" name="consultar" value="consultar" class="button-submit-listarDocs btn-lg">
                                    <img class="imagenes-iconos" src="Sources/Images/busqueda.png"/>&nbsp;Consultar
                                </button>
                            </div>
                            
                        </div>
                    </form>
                </div>
            </container>
        </section>
        
        </section>

        </section>
        
        <%@include file = "Templates/Footer.jsp"%>
    </body>
</html>
