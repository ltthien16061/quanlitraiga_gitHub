/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Set datatable width
$(document).ready(function() {
    $('#sp-dataTable').DataTable( {
        "columnDefs": [
            {
                "targets": [ 0 ],
                "visible": false,
                "searchable": false
            },
            {
                "targets": [ 2 ],
                "width": "30%"
            }
        ]
    } );
} );
//Get value in datatable
$(".cs-btnDel").click(function() {
    var $name = $(this).closest("tr").find(".sp-name").text(); 
    var $address = $(this).closest("tr").find(".sp-address").text();            
    document.getElementById("csName-Modal").innerHTML = $name;   
    document.getElementById("csAddress-Modal").innerHTML = $address;

});
function showModal(){
    document.getElementById("cs-btnDel").click();
}


