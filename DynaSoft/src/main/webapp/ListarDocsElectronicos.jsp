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
        <meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1 maxium-scale=1.0, minium-scale=1.0">
        
        <%@include file = "Templates/Bootstrap.jsp"%>
        <link rel="stylesheet" type="text/css" href="Styles/cssListarDocumentos.css">
        <link rel="icon" href="Sources/Images/logo_cfs-color.png">
        <title>CFS DynaSoft</title>
    </head>
    
    <body class="body">
        <script src="JScript/table2excel.js"></script>
        <%@include file = "Templates/Header.jsp" %>
        
        <section class="section-listarDocs" id="id-section-listarDocs">
            <container class="container-listarDocs">
                <div class="div-form">
                    <form class="form-listarDocs" action="ListarDocs" method="post" nam="myForm2">
                        
                        <div class="columns-2 w-row">
                            <div class="column-3 w-col w-col-4 columnsListarDocs">
                                <label for="field" class="field-label-3 label-listarDocs">Fecha Inicio</label>
                                <input type="date" class="date-listarDocs" required="true" oninvalid="this.setCustomValidity('Ingresa una fecha correcta')"
                                       oninput="setCustomValidity('')" name="fecha1"/>
                            </div>
                            
                            <div class="column-3 w-col w-col-4 columnsListarDocs">
                                <label for="field" class="field-label-3 label-listarDocs">Athorization</label>
                                <input type="text" class="text-listarDocs" required="true" oninvalid="this.setCustomValidity('Ingrese un código correcto')"
                                       oninput="setCustomValidity('')" name='textAuthorization'/>
                            </div>
                        </div>
                        
                        <div class="columns-2 w-row">
                            <div class="column-3 w-col w-col-4 columnsListarDocs">
                                <label for="field-2" class="field-label-4 label-listarDocs">Fecha cierre</label>
                                <input type="date" class="date-listarDocs" required="true" oninvalid="this.setCustomValidity('Ingresa una fecha correcta')"
                                       oninput="setCustomValidity('')" name="fecha2"/>
                            </div>
                            
                            <div class='column-3 w-col w-col-4 columnsListarDocs'>
                                <label for="field" class="field-label-3 label-listarDocs">Cookie</label>
                                <input type="text" class="text-listarDocs" required="true" oninvalid="this.setCustomValidity('Ingrese un código correcto')" 
                                       oninput="setCustomValidity('')" name="textCookie"/>
                            </div>
                        </div>
                        
                        <div class="columns-2 w-row" id="div-boton-buscar">
                            <div class="column-5 w-col w-col-4 columnsListarDocs">
                                <button type="submit" name="consultar" value="consultar" class="button-submit-listarDocs btn-lg">
                                    <img class="imagenes-iconos" src="Sources/Images/busqueda.png"/>&nbsp;Consultar
                                </button>
                            </div>
                            
                            <%
                                String valors = (String) session.getAttribute("valor");
                                if(valors.equals("1")){
                            %>
                                <h1>&nbsp;</h1>
                            <% } else if(valors.equals("2")) {%>
                            <br>
                            <div class="column-5 w-col w-col-4 columnsListarDocs">
                                <button type="button" id="download-Excel" name="descargar" class="button-submit-listarDocs btn-lg">
                                    <img class="imagenes-iconos" src="Sources/Images/descargas.png"/>&nbsp;Descargar
                                </button>
                            </div>
                            <% } %>
                        </div>
                    </form>
                        
                </div>
            </container>
        </section>
        
        <section class="section-listarDocs">
            <container class="container-listarDocs2">
                <div id="carouselExampleControls" class="carousel slide" data-bs-ride="carousel">
                    <div class="carousel-inner">
        
                        <%
                            if(valors.equals("1")){
                        %>
                            &nbsp;
                        <% } else if(valors.equals("2")) {%>
                            <%@include file="Templates/SlideReportes.jsp" %>
                        <% } %>
                    </div>
                    
                    <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
            
                    <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleControls" data-bs-slide="next">
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </container>
                    
            <container>
                <%@include file = "Templates/Footer.jsp"%>
            </container>
        </section>
                    
        <script>
            document.getElementById('download-Excel').addEventListener('click', function() {
                var table2excel = new Table2Excel();
                table2excel.export(document.querySelectorAll("#tableERP, #tableCRM, #tableComparativa, #tableAgrupacion"));
            });
        </script>
    </body>
</html>
