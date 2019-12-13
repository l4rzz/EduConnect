

// perform an ajax http get request
$.ajax({
    url: 'http://localhost:8080/teamnull/api/teacher',
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
    createPosts(response);
    console.log("1", response);
}

function errorCallback(request, status, error) {
    // do something with the error
   console.log("something went wrong");
}

function createPosts(data){
    //get the dashboard area
    var profilePage = document.querySelector("");

    console.log(data);
    for(var i =0; i<data.length; i++){
       var keys = Object.keys(data[i]);
        //div for each dataobject
        for(var j=0; j<data.length; j++){

        $(".name").textContent = "ff";
        $(".email").textContent = "ffrrrrrrrrr"

        }
        
    }
    //create div
   

    createPosts();
    //create 
}