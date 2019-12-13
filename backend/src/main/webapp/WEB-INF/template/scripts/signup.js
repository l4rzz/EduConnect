$( document ).ready(function() {
    
    $('#submit-teacher').click( function(event){

        var usernameTeacher = $("#username-teacher").val();
        var passwordTeacher = $("#password-teacher").val();
        var emailTeacher = $("#email-teacher").val();
        var nameTeacher = $("#name-teacher").val();
        var imageLinkTeacher = $("#imageLink-teacher").val();
        var subjectTeacher = $("#subject-teacher").val();

        $.ajax({
            url: 'http://localhost:8080/teamnull/api/teacher/add',
            type: 'POST',
            data: JSON.stringify({
                email: emailTeacher,
                imageLink: imageLinkTeacher,
                name: nameTeacher,
                subject: subjectTeacher
            }),
            async: true,
            contentType: 'application/json'
        })
    });
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