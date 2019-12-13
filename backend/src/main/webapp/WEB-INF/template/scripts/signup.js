$(document).ready(function() {
  $("#submit-teacher").click(function(event) {
    var emailTeacher = $("#email-teacher").val();
    var nameTeacher = $("#name-teacher").val();
    var imageLinkTeacher = $("#imageLink-teacher").val();
    var subjectTeacher = $("#subject-teacher").val();
    var cityTeacher = $("#city-teacher").val();
    var countryTeacher = $("#country-teacher").val();
    var startDateTeacher = $("#startavail-teacher").val();
    var endDateTeacher = $("#endavail-teacher").val();

    $.ajax({
      url: "http://localhost:8080/teamnull/api/teacher/add",
      type: "POST",
      data: JSON.stringify({
        email: emailTeacher,
        imageLink: imageLinkTeacher,
        name: nameTeacher,
        subject: subjectTeacher,
        city: cityTeacher,
        country: countryTeacher,
        startDate: startDateTeacher,
        endDate: endDateTeacher
      }),
      async: true,
      contentType: "application/json"
    });

    window.location.href = "landing-page.html";
  });

  $("#submit-school").click(function(event) {
    var emailSchool = $("#email-school").val();
    var nameSchool = $("#name-school").val();
    var imageLinkSchool = $("#imageLink-school").val();
    var subjectSchool = $("#subject-school").val();
    var citySchool = $("#city-school").val();
    var countrySchool = $("#country-school").val();
    var startVacSchool = $("#startvac-school").val();
    var endVacSchool = $("#endvac-school").val();

    $.ajax({
      url: "http://localhost:8080/teamnull/api/school/add",
      type: "POST",
      data: JSON.stringify({
        email: emailSchool,
        imageLink: imageLinkSchool,
        name: nameSchool,
        subject: subjectSchool,
        city: citySchool,
        country: countrySchool,
        startDate: startVacSchool,
        endDate: endVacSchool
      }),
      async: true,
      contentType: "application/json"
    });

    window.location.href = "landing-page.html";
  });
});
