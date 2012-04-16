function validateStudent() {

    var isValidValue = isValid('#firstName', '#firstNameError');
    isValidValue = isValid('#lastName', '#lastNameError');
    isValidValue = isValid('#standard', '#standardError');
    isValidValue = isValid('#section', '#sectionError');

    if (isValidValue) {
        $("#addStudentForm").submit();
    }
}

function isValid(id, divId) {
    var field = id.split("#");

    if ($(id).val() == "") {
        $(divId).html(field[1] + " cannot be empty");
        return false;
    }
    return true;
}