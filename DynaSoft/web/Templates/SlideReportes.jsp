<%-- 
    Document   : SlideReportes
    Created on : 13 dic. 2022, 14:39:55
    Author     : pablo.elizondo
--%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.cfscr.dynasoft.entities.DocumentosERP"%>
<%@page import="com.cfscr.dynasoft.entities.DocumentosCRM"%>
<%@page import="com.cfscr.dynasoft.entities.DocumentoComparativa"%>
<%@page import="com.cfscr.dynasoft.entities.DocumentoAgrupacion"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<jsp:useBean id="docsERP" scope="request" type="java.util.ArrayList" />
<jsp:useBean id="docsCRM" scope="request" type="java.util.ArrayList" />
<jsp:useBean id="docsComparativa" scope="request" type="java.util.ArrayList" />
<jsp:useBean id="docsAgrupacion" scope="request" type="java.util.ArrayList" />


    <div class="carousel-item active contenedor">
        <table class="table table-responsive-lg table-hover" id="tableERP">
            <thead class="bg-secondary text-white thead-docs">
                <tr class="tr-thead-docs">
                    <th class="text-center" colspan="24">Documentos ERP</th>
                </tr>
                
                <tr class="tr-thead-docs">
                    <th class="text-center">Reg.</th>
                    
                    <th class="text-center" id="ocultar">Cliente</th>
                    
                    <th class="text-center">Nombre</th>
                    <th class="text-center">Tipo</th>
                    <th class="text-center">Documento</th>
                    <th class="text-center">Fecha</th>
                    
                    <th class="text-center" id="ocultar">M&oacute;dulo</th>
                    <th class="text-center" id="ocultar">NIT Receptor</th>
                    <th class="text-center" id="ocultar">Contiene Error</th>
                    <th class="text-center" id="ocultar">Error Receptor</th>
                    <th class="text-center" id="ocultar">Error Softland</th>
                    <th class="text-center" id="ocultar">Enviado</th>
                    
                    <th class="text-center">C&oacute;digo Moneda</th>
                    <th class="text-center">Total Gravado</th>
                    <th class="text-center">Total Exento</th>
                    <th class="text-center">Total Venta</th>
                    <th class="text-center">Total Descuentos</th>
                    <th class="text-center">Total Venta Neta</th>
                    <th class="text-center">Total Impuesto</th>
                    <th class="text-center">Total Comprobante</th>
                    <th class="text-center">Total Factura</th>
                    <th class="text-center">CRM</th>
                    <th class="text-center">Aplicaci&oacute;n</th>
                    <th class="text-center">Documento OC</th>
                    <th class="text-center">Monto</th>
                </tr>
            </thead>
            <tbody>
                <%
                    ArrayList<DocumentosERP> docsERPhtml = docsERP;
                    for(int i=0; i<docsERPhtml.size(); i++){
                %>
                <tr class="tr-tbody-docsERP">
                    <td class="text-center"><%=i+1%></td>
                    
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getCliente()%></td>
                    
                    <td class="text-center"><%=docsERPhtml.get(i).getNombre()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTipo()%></td>
                    <td class="text-center">#<%=docsERPhtml.get(i).getDocumento()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getCreateDate()%></td>
                    
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getTipoAsiento()%></td>
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getNitReceptor()%></td>
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getContieneErrores()%></td>
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getErrorWS()%></td>
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getErrorSoftland()%></td>
                    <td class="text-center" id="ocultar"><%=docsERPhtml.get(i).getEnviado()%></td>
                    
                    <td class="text-center"><%=docsERPhtml.get(i).getMoneda()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalGravado()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalExento()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalVenta()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalDescuentos()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalVenta()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalImpuesto()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalComprobante()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getTotalFactura()%></td>
                    <td class="text-center"><%=(docsERPhtml.get(i).getTipo().equals("Nota Crédito")) ? "-" : docsERPhtml.get(i).getCrm()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getAplicacion()%>_</td>
                    <td class="text-center"><%=docsERPhtml.get(i).getDocumentoOC()%></td>
                    <td class="text-center"><%=docsERPhtml.get(i).getMonto()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>               
    </div>
  
    <div class="carousel-item">
        <table class="table table-responsive-lg table-hover" id="tableCRM">
            <thead class="bg-secondary text-black th-thead-docs">
                <tr class="tr-thead-docs">
                    <th class="text-center" colspan="10">Documentos CRM</th>
                </tr>
                
                <tr class="tr-thead-docs">
                    <th class="text-center">Reg.</th>
                    <th class="text-center">Oportunidad</th>
                    <th class="text-center">Tema</th>
                    <th class="text-center">UEN</th>
                    <th class="text-center">Cliente Potencial</th>
                    <th class="text-center">Ingresos Reales</th>
                    <th class="text-center">Est. Profit</th>
                    <th class="text-center">Fecha de cierre real</th>
                    <th class="text-center">Fecha estimada de factura</th>
                    <th class="text-center">Propietario</th>
                </tr>
            </thead>
            
            <tbody>
                <%
                    ArrayList<DocumentosCRM> docsCRMhtml = docsCRM;
                    for(int i=0; i<docsCRMhtml.size(); i++){
                %>
                <tr class="tr-tbody-docsERP">
                    <td class="text-center"><%=i+1%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getOportunidad()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getTema()%>_</td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getUEN()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getClientePotencial()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getIngresosReales()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getEstProfit()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getFechaCierre()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getFechaEstimada()%></td>
                    <td class="text-center"><%=docsCRMhtml.get(i).getPropietario()%></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
    
    <div class="carousel-item">
        <table class="table table-responsive-lg table-hover" id="tableComparativa">
            <thead class="bg-secondary text-black">
                <tr class="tr-thead-docs">
                    <th class="text-center" colspan="15">Documentos Comparativa</th>
                </tr>
                
                <tr class="tr-thead-docs">
                    <th class="text-center">Reg.</th>
                    <th class="text-center">Oportunidad-CRM</th>
                    <th class="text-center">Tipo-ERP</th>
                    <th class="text-center">Nombre Cliente-CRM</th>
                    <th class="text-center">Tema-CRM</th>
                    <th class="text-center"># Factura-ERP</th>
                    <th class="text-center">Monto-ERP</th>
                    <th class="text-center">Profit-CRM</th>
                    <th class="text-center">Ingreso Estimado-CRM</th>
                    <th class="text-center">Total Venta Neta-ERP</th>
                    <th class="text-center">Total Factura-ERP</th>
                    <th class="text-center">Dif. (TotalVenta - IngresoEst.)</th>
                    <th class="text-center">Fecha Est. Fac-CRM</th>
                    <th class="text-center">Fecha-ERP</th>
                    <th class="text-center">Comentarios</th>
                </tr>
            </thead>
            
            <tbody>
                <%
                    ArrayList<DocumentoComparativa> docsCOMhtml = docsComparativa;
                    for(int i=0; i<docsCOMhtml.size(); i++){
                %>
                <tr class="tr-tbody-docsERP">
                    <td class="text-center"><%=i+1%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getOportunidad()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getTipo()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getCliente()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getTema()%>_</td>
                    <td class="text-center">#<%=docsCOMhtml.get(i).getFactura()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getMonto()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getIngresoProfit()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getIngresoEstimado()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getTotalVentaNeta()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getTotalFactura()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getDiferencia()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getFechaEstimada()%></td>
                    <td class="text-center"><%=docsCOMhtml.get(i).getFecha()%></td>
                    <td class="text-center"><%=(docsCOMhtml.get(i).getTipo().equals("Nota Crédito") ||
                                                docsCOMhtml.get(i).getTipo().equals("Otro Crédito") ||
                                                docsCOMhtml.get(i).getTipo().equals("No Match ERP") ||
                                                docsCOMhtml.get(i).getTotalVentaNeta() - docsCOMhtml.get(i).getIngresoEstimado() >= 0)
                            
                        ? " - - - " : "Saldo Negativo"
                    %></td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
            
    <div class="carousel-item">
        <table class="table table-responsive-lg table-hover" id="tableAgrupacion">
            <thead class="bg-secondary text-black">
                <tr class="tr-thead-docs">
                    <th class="text-center" colspan="12">Documentos Agrupaci&oacute;n</th>
                </tr>
                
                <tr class="tr-thead-docs">
                    <th class="text-center">Reg.</th>
                    <th class="text-center">Oportunidad</th>
                    <th class="text-center">Tipo</th>
                    <th class="text-center">Cliente</th>
                    <th class="text-center">Tema</th>
                    <th class="text-center">Monto</th>
                    <th class="text-center">Ingreso Profit</th>
                    <th class="text-center">Ingreso Estimado</th>
                    <th class="text-center">Total Venta</th>
                    <th class="text-center">Total Factura</th>
                    <th class="text-center">Diferencia</th>
                    <th class="text-center">Comentarios</th>
                </tr>
            </thead>
            
            <tbody>
                <%
                    ArrayList<DocumentoAgrupacion> docsAGRhtml = docsAgrupacion;
                    for(int i=0; i<docsAGRhtml.size(); i++){
                %>
                <tr class="tr-tbody-docsERP">
                    <td class="text-center"><%=i+1%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getOportunidad()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getTipo()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getNombreCliente()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getTema()%>_</td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getMonto()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getIngresoProfit()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getIngresoEstimado()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getTotalVenta()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getTotalFactura()%></td>
                    <td class="text-center"><%=docsAGRhtml.get(i).getDiferencia()%></td>
                    <td class="text-center"><%=
                        (docsAGRhtml.get(i).getDiferencia() >= 0)
                        ? " - - - "
                        : "Saldo Negativo"
                        %>
                    </td>
                </tr>
                <%}%>
            </tbody>
        </table>
    </div>
