// perform an ajax http post request
/*
$(document).ready(function() {
    $("#signup-teacher").click(function() {
        event.preventDefault;

        $.ajax({
            url: 'http://localhost:8080/teamnull/api/teacher',
            type: 'POST',
            data: $("#form").serialize(),
            async: true,
            contentType: 'application/json',
            success: function (result) {
                console.log(result)
            }

        });
    });
    

   function f(form, name, email) {
    att = form.action; // Use form.action
    $.post(att, {
        name: name.value, // Use fname.value
        email: email.value,
         // Use lname.value
    }).done(function (data) {
        alert(data);
    });
    return true;
}
*/

// perform an ajax http post request

$('#submit').click( function(event){

$.ajax({
    url: 'http://localhost:8080/api/user',
    type: 'POST',
    data: JSON.stringify({
        email: 'rui.ferrao@academiadecodigo.org',
        imageLink: 'master',
        name: 'ferrao'
    }),
    async: true,
    contentType: 'application/json'
})
});
    

    /*
    $("#signup-school").click(function() {
        var usernameSchool = $("#username-school").val();
        var passwordSchool = $("#password-school").val();
        var emailadressSchool = $("#email-school").val();
        var fullnameSchool = $("#name-school").val();
        var subjectSchool = $("#subject-school").val();

        $.ajax({
            url: 'http://localhost:8080/teamnull/api/school',
            type: 'POST',
            data: JSON.stringify({
                username: usernameSchool,
                password: passwordSchool,
                email: emailadressSchool,
                name: fullnameSchool,
                subject: subjectSchool
            }),
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback,

        });
    });
   
});
 */