

document.getElementById("register").addEventListener("click",
    saveStudent
)




function saveStudent(e) {
    e.preventDefault();
    let nameS = document.getElementById("studentNameInput").value;
    let age = document.getElementById("studentAgeInput").value;
    let contact = document.getElementById("studentContactInput").value;
    let guardian = document.getElementById("gurdianNameInput").value;
    let guardianAddress = document.getElementById("gurdianAddressInput").value;
    let guardianContact = document.getElementById("gurdianContactInput").value;
    let imageFile = document.getElementById("upload").files[0];


    let formData = new FormData();

    formData.append("name", nameS);
    formData.append("age", age);
    formData.append("contact", contact);
    formData.append("guardian", guardian);
    formData.append("guardianAddress", guardianAddress);
    formData.append("guardianContact", guardianContact);
    formData.append("file", imageFile);


    fetch("http://localhost:8081/student/save", {
        method: "POST",
        body: formData,
    })
    .then(response => response.json())
    .then(data => {
        console.log(data);
        alert("Student saved successfully");
    })
    .catch(error => {
        console.error('Error:', error);
        alert("Error saving student");
    });
}

var loadFile = function (event) {
    var image = document.getElementById("image-student");
    image.src = URL.createObjectURL(event.target.files[0]);
};


