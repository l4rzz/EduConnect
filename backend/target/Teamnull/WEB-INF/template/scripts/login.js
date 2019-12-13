$(document).ready(function() {
    $("#login").click(function() {
        var username = $("#username").val();
        var password = $("#password").val();

        $.ajax({
            url: 'http://localhost:8080/api/user',
            type: 'POST',
            data: JSON.stringify({
                username: username,
                password: password
            }),
            async: true,
            contentType: 'application/json',
            success: successCallback,
            error: errorCallback,

        });
    });
});