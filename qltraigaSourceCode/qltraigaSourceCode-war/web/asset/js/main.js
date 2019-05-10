/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//sidebar-toggled button
$("#activeSidebar").click(function(){
    var sidebar = $('.sidebar.navbar-nav');
    if(sidebar.hasClass("toggled")){
        sidebar.removeClass("toggled");
    }else{
        sidebar.addClass("toggled");
    }
});


