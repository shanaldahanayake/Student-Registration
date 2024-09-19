window.onload = function () {
    loadTable();
}

let id;


async function loadTable() {
    let stdTable = document.getElementById("tblStudent");

    let body = `<tr>
                <td>Id</td>
                <td>Name</td>
                <td>Age</td>
                <td>Contact</td>
              
             </tr>`

    await fetch("http://localhost:8081/student/getAll")
        .then(res => res.json())
        .then(data => {
            data.forEach(element => {

                let imageSrc = `data:image/jpeg;base64,${element.image}`;

                body += `<tr>
                <td>${element.id}</td>
                <td>${element.name}</td>
                <td>${element.age}</td>
                <td>${element.contact}</td>   
             </tr>`
            });
            stdTable.innerHTML = body;
        })
        row=stdTable.rows.length; 
        
        getData();
}

function getData() {
    var table = document.getElementById("tblStudent");

    for (var i = 1; i < row; i++) {
        table.rows[i].onclick = function () {
            id=this.cells[0].innerHTML;
            setCard(id);  
        };
    }
}

async function setCard(id){
    await fetch(`http://localhost:8081/student/get/${id}`)
    .then(res=>res.json())
    .then(data=>{
        console.log(data);
        document.getElementById("card-name").innerHTML=data.name;
        document.getElementById("card-age").innerHTML=data.age;
        document.getElementById("card-contact").innerHTML=data.contact;
        document.getElementById("card-guard").innerHTML=data.guardian;
        document.getElementById("card-guardCon").innerHTML=data.guardianAddress;
        document.getElementById("card-guardAdd").innerHTML=data.guardianContact;
        document.getElementById("card-image").src=`data:image/jpeg;base64,${data.image}`;
    })
    .catch(error=>{
        alert(error.message);
    });
    
}

