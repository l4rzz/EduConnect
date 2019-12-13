$(document).ready(function() {
    $("#login").click(function() {
        var name = $("#name").val();
        var email = $("#email").val();
        var city = $("#city").val();
        var country = $("country").val();
        var preferredcountry = $()
        var bio = $("bio").val();
        var subject = $("subject").val();

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