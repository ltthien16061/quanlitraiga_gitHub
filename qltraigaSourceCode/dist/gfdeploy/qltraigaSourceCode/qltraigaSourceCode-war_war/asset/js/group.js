/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//Set datatable chicken supplier
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
    $('#kind-dataTable').DataTable();
} );
function csClick(){
    
    $('.groupAdd-kind').removeClass('fadeOutLeft');
    $('.groupAdd-cs').removeClass('fadeInRight');

    $('.groupAdd-cs').addClass('fadeOutLeft');
    $('.groupAdd-cs').delay(2000).addClass('hidden');
    $('.groupAdd-kind').delay(1000).removeClass('hidden');
    $('.groupAdd-kind').addClass('fadeInRight');
}
function resetClick(){    
    $('.groupAdd-kind').removeClass('fadeInRight');
    $('.groupAdd-cs').removeClass('fadeOutLeft');
    
    $('.groupAdd-kind').addClass('fadeOutLeft');
    $('.groupAdd-kind').delay(2000).addClass('hidden');
    $('.groupAdd-cs').delay(1000).removeClass('hidden');
    $('.groupAdd-cs').addClass('fadeInRight');
}

