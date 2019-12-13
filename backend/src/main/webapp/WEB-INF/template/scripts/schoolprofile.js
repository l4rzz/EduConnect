    $ajax({
        url: 'http://localhost:8080/api/user',
        type: 'GET',
        data: JSON.stringify({
            name: name,
            location: location,
            preferredCountry: preferredCountry
        }),
        contentType: 'application/json',
        success: successCallback,
        error: errorCallback,
    });

    function successCallback(response) {
        // createGets
    }

    function errorCallback(request, status, error) {
        // do something with the error
        createGets();
    }

    function createGets(data) {
        //get the dashboard area
        var schoolprofile = document.querySelector(".schoolprofile");

        var data = "something";
        for (var j = 0; j < data.length; j++) {
            var wrapper = document.createElement("div");
            var name = document.createElement("h5");
            var location = document.createElement("p");

            var nameText = document.createTextNode("School Name");
            name.appendChild(nameText);

            var location = document.createTextNode("Baarn, Netherland");
            location.appendChild(location);

            var preferredCountry = document.createTextNode("Land");
            preferredCountry.appendChild(preferredCountry);

            wrapper.appendChild(name);
            wrapper.appendChild(location);
            wrapper.appendChild(preferredCountry);
        }
        createGets();
    }