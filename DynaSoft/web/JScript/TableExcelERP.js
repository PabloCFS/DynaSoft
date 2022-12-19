/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
document.getElementById('download-Excel').addEventListener('click', function() {
    var table2excel = new Table2Excel();
    table2excel.export(document.querySelectorAll("#tableERP"));
    
});