// ADD button onclick functionality
function addMode() {
    var form = document.getElementById("qualification-form");
    var addButton = document.getElementById("circle-icon");

    form.style.display = "block";
    addButton.style.display = "none";
}

function saveEdit() {
    var form = document.getElementById("qualification-form");
    var addButton = document.getElementById("circle-icon");

    form.style.display = "none";
    addButton.style.display = "block";
}

// not executing properly have to check once 
function cancelEdit() {
    var addButton = document.getElementById("circle-icon");

    addButton.style.display = "block";
}

// json data tranferring
$('#saveEdit').on('click', function (){
    var qualification_type = $('#qualification-type').val();
    var course_name = $('#course_name').val();
    var course_type = $('#course_type').val();
    var Stream = $('#Stream').val();
    var course_start = $('#course_start').val();
    var college_name = $('#college_name').val();
    var University_name = $('#University_name').val();
    
    
    jsonObject = {
        "qualification_type":"",
        "course_name":"",
        "course_type":"",
        "Stream":"",
        "course_start":"",
        "college_name":"",
        "University_name":"",
    }
    jsonObject.qualification_type=qualification_type
    jsonObject.course_name=course_name
    jsonObject.course_type=course_type
    jsonObject.Stream=Stream
    jsonObject.course_start=course_start
    jsonObject.college_name=college_name
    jsonObject.University_name=University_name

    var str = JSON.stringify(jsonObject);
    document.write(str);

});
