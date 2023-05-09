// Asynchronous Request using JAvaScript Fetch API

const message = document.querySelector("#message");
const list = document.querySelector("#list");

const URL = "http://localhost:8080/JavaEEAppMVC/api/v1/employees";

const setErrorMessage = function(element, message) {
    element.classList.add("alert");
    element.classList.add("alert-dangers");
    element.textContent = message;
}

fetch(URL).then(response => {
    if (response.ok) {
        return response.json();
    } else {
        setErrorMessage(message,"Request no successful");
    }
}).then(employees => {
    if (employees)  {
        for (const employee of employees){
            let employeeCard = `
            <div class="card" style="width: 18rem;">
              <div class="card-header">
                ${employee.first_name} ${employee.last_name}
              </div>
              <div class="card-body">
                  <ul class="list-group list-group-flush">
                    <li class="list-group-item">User ID: <span id="id">${employee.emp_no}</span></li>
                    <li class="list-group-item">First name: <span id="name">${employee.first_name}</span></li>
                    <li class="list-group-item">Last name: <span id="email">${employee.last_name}</span></li>
                    <li class="list-group-item">Gender: <span id="date">${employee.gender}</span></li>
                    <li class="list-group-item">Birth date: <span id="date">${employee.birth_date}</span></li>
                  </ul>
              </div>
              <div class="card-footer">
                  <a href="/employees/${employee.emp_no}" class="btn btn-primary">Edit</a>
              </div>
            </div>`;
            list.innerHTML += employeeCard;
        }
    } else {
        setErrorMessage(message,"<p>Error - No User Found</p>");
    }
});

