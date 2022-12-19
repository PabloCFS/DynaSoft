<%-- 
    Document   : Header
    Created on : 21 jun. 2022, 07:51:04
    Author     : pablo.elizondo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="Styles/cssHeader.css">

<section class="Section-Header">
    <container class="Container-header">
        <div class="columns w-row columns-header">
            
            <div class="column w-col w-col-6 column1-header">
                <img class="logoCFS" src="Sources/Images/logo_cfs-color.png"></img>
            </div>
            
            <div class="column-2 w-col w-col-6 column2-header">
                <form action="ServletLogOut" method="post" name="form">
                    <button type="submit" name="salir" value="Salir" class="button-submit-exit btn-lg">
                        <img class="img-icon-exit" src="Sources/Images/cerrar.png"/>&nbsp;Salir
                    </button>
                </form>
            </div>
        
        </div>
    </container>
</section>