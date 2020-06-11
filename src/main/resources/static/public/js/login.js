/**
 * 
 */
$(document).ready(function (){
    function noback(){
        window.location.hash="no-back-button";	
        window.location.hash="Again-No-back-button";
        window.onhashchange=function(){window.location.hash="no-back-button";};
    }
    noback();
    $('#btn-ingresar').prop( "disabled", true );
    
    $(':input').keyup(function(){
        var usuario = $('#username').val();
        var pwd = $('#password').val();
        if(usuario.match(/^[A-Z a-z 0-9]+$/) && pwd.match(/^[A-Z a-z 0-9]+$/)){
            $('#btn-ingresar').prop( "disabled", false );
        }else{
            $('#btn-ingresar').prop( "disabled", true );
        }
        if(!usuario.match(/^[A-Z a-z 0-9]+$/) && usuario !== ''){
            alert('Hay un error en el campo usuario');
        }
        if(!pwd.match(/^[A-Z a-z 0-9]+$/) && pwd !== ''){
            alert('Hay un error en el campo contraseña');
        }
    });
    
});