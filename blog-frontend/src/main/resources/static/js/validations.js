$(document).ready(function() {
  // Initialize form validation on the registration form.
  // It has the name attribute "registration"
  $("form[name='commentForm']").validate({
    // Specify validation rules
    rules: {
      // The key name on the left side is the name attribute
      // of an input field. Validation rules are defined
      // on the right side
      author: "required",
      comment: "required"
    },
    // Specify validation error messages
    messages: {
      author: "The author is required and cannot be empty",
      comment: "The comment is required and cannot be empty"
    },
    // Make sure the form is submitted to the destination defined
    // in the "action" attribute of the form when valid
    submitHandler: function(form) {
      form.submit();
    }
  });


  $("form[name='signinForm']").validate({
      // Specify validation rules
      rules: {
        // The key name on the left side is the name attribute
        // of an input field. Validation rules are defined
        // on the right side
        email: "required",
        password: "required"
      },
      // Specify validation error messages
      messages: {
        email: "Email is required and cannot be empty",
        password: "Password is required and cannot be empty"
      },
      // Make sure the form is submitted to the destination defined
      // in the "action" attribute of the form when valid
      submitHandler: function(form) {
        form.submit();
      }
    });
});
