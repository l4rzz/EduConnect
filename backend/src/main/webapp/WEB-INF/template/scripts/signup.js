// perform an ajax http post request
$(document).ready(function() {
    $("#signup-teacher").click(function() {
        var usernameTeacher = $("#username-teacher").val();
        var passwordTeacher = $("#password-teacher").val();
        var emailadressTeacher = $("#email-teacher").val();
        var fullnameTeacher = $("#name-teacher").val();
        var subjectTeacher = $("#subject-teacher").val();

        $.ajax({
            url: 'http://localhost:8080/api/user',
            type: 'POST',
            data: JSON.stringify({
                username: usernameTeacher,
                password: passwordTeacher,
                email: emailadressTeacher,
                name: fullnameTeacher,
                subject: subjectTeacher
            }),
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback,

        });
    });

    $("#signup-school").click(function() {
        var usernameSchool = $("#username-school").val();
        var passwordSchool = $("#password-school").val();
        var emailadressSchool = $("#email-school").val();
        var fullnameSchool = $("#name-school").val();
        var subjectSchool = $("#subject-school").val();

        $.ajax({
            url: 'http://localhost:8080/api/user',
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

$(function() {
    $("#tabs").tabs();
});