

// perform an ajax http get request
$.ajax({
    url: 'http://localhost:8080/api/users',
    async: true,
    success: successCallback,
    error: errorCallback
});
/*
<div class="dashboard-wall">
<h5>school name</h5>
<p class="location">Location Location</p>
<p class="bio">Lorem ipsum dolor, sit Quod sed iusto maiores voluptatibus accusamus!</p>
<p class="date">1298-01-01</p>
</div>
*/
function successCallback(response) {
    // createPosts
}

function errorCallback(request, status, error) {
    // do something with the error
    createPosts();
}

function createPosts(data){
    //get the dashboard area
    var dashboard = document.querySelector(".dashboard");

    var data = "wakawaka";
    for(var i =0; i<data.length; i++){
       // var keys = Object.keys(data[i]);
        //div for each dataobject
        for(var j=0; j<data.length; j++){
        var wrapper = document.createElement("div");
        var name = document.createElement("h5");
        var location = document.createElement("p");
        var bio = document.createElement("p");
        var date = document.createElement("p");
        
        //give content to respective element
        var nameText = document.createTextNode("LUCAS LUCAS");
        name.appendChild(nameText);
        var locationText = document.createTextNode("Utrecht, Netherlands");
        location.appendChild(locationText);
        var bioText = document.createTextNode("Lorem ipsum dolor, sit amet consectetur adipisicing elit. Obcaecati, odio quod? Magni obcaecati a, veritatis quam aut, possimus voluptates architecto minus nam sunt ipsam? Quod sed iusto maiores voluptatibus accusamus!");
        bioText.appendChild(bioText);
        var dateText = document.createTextNode("18-02-2007");
        date.appendChild(dateText);
       
        //append everything in wrapper
        wrapper.appendChild(name);
        wrapper.appendChild(location);
        wrapper.appendChild(bio);
        wrapper.appendChild(date);

        }
        
    }
    //create div
   

    createPosts();
    //create 
}