$(document).ready(function() {

    $("#fakelogin").click(function(event) {

            var userEmail = $("#email").val();

            
            $.get( "http://localhost:8080/teamnull/api/teacher/compare/"+ userEmail);
            });


})