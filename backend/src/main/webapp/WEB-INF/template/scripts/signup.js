$(document).ready(function() {
  $("#submit-teacher").click(function(event) {
    var emailTeacher = $("#email-teacher").val();
    var nameTeacher = $("#name-teacher").val();
    var imageLinkTeacher = $("#imageLink-teacher").val();
    var subjectTeacher = $("#subject-teacher").val();

    $.ajax({
      url: "http://localhost:8080/teamnull/api/teacher/add",
      type: "POST",
      data: JSON.stringify({
        email: emailTeacher,
        imageLink: imageLinkTeacher,
        name: nameTeacher,
        subject: subjectTeacher
      }),
      async: true,
      contentType: "application/json"
    });
  });

  $("#submit-school").click(function(event) {
    var emailSchool = $("#email-school").val();
    var nameSchool = $("#name-school").val();
    var imageLinkSchool = $("#imageLink-school").val();
    var subjectSchool = $("#subject-school").val();

    $.ajax({
      url: "http://localhost:8080/teamnull/api/school/add",
      type: "POST",
      data: JSON.stringify({
        email: emailSchool,
        imageLink: imageLinkSchool,
        name: nameSchool,
        subject: subjectSchool
      }),
      async: true,
      contentType: "application/json"
    });
  });
});
