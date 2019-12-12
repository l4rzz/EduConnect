var ajax;

if (window.XMLHttpRequest) {
    // Mozilla, Safari, IE7+ ...
    ajax = new XMLHttpRequest();
} else if (window.ActiveXObject) {
    // IE 6 and older
    ajax = new ActiveXObject('Microsoft.XMLHTTP');
}

// run this when the ajax request completes
ajax.onreadystatechange = function() {
  if (ajax.readyState === 4 && ajax.status === 200) {
    var data = JSON.parse(ajax.responseText);
   
    //DO STUFF

  }
};


// start the AJAX request
ajax.open('GET', 'http://localhost:8080/', true); //Get the school data AND get teachers data from database
ajax.setRequestHeader('Content-type', 'application/json');
ajax.send();

/*
<div class="dashboard-wall">
<h5>school name</h5>
<p class="location">Location Location</p>
<p class="need">Lorem ipsum dolor, sit Quod sed iusto maiores voluptatibus accusamus!</p>
<p class="date">1298-01-01</p>
</div>
*/
function createPosts(){

}