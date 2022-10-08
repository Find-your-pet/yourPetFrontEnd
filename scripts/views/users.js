const USER = new User();

document.addEventListener("DOMContentLoaded", event => {

    const roleForm = document.querySelector("#formulario");

    function loadUserTable(){
        //const table = document.querySelector("tbody");
        //table.innerHTML ="";
        USER.findAll().then(users => {
            users.forEach(user =>{
                const row = document.createElement("tr");
                const cells = [
                    document.createElement("td"),
                    document.createElement("td"),
                    document.createElement("td"),
                    document.createElement("td"),
                    document.createElement("td"),
                    document.createElement("td")
                ];
                const buttons = [
                    document.createElement("button")
                    
                ];
                buttons[0].textContent = "registrar";
                buttons[0].addEventListener("onclick", event => {
                    roleForm.id.value = user.id;
                    roleForm.email.value = user.email;
                    roleForm.apellidos.value = user.lastname;
                    roleForm.nombres.value = user.name;
                    roleForm.contrasena.value = user.password;
                    roleForm.telefono.value = user.phone;
                    
                    
                }, false);
                cells[0].textContent = user.id;
                cells[1].textContent = user.email;
                cells[2].textContent = user.lastname;
                cells[3].textContent = user.name;
                cells[4].textContent = user.password;
                cells[5].textContent = user.phone;
                
                
                //cells[6].append(...buttons);
                //row.append(...cells);
                //table.append(row);
            });
        });
    };

    loadUserTable();

    roleForm.addEventListener("submit", event =>{
        event.preventDefault(); 
        const user = {
            id: roleForm.id.value,
            email: roleForm.email.value,
            lastname: roleForm.apellidos.value,
            name: roleForm.nombres.value,
            password: roleForm.contrasena.value,
            phone: roleForm.telefono.value
                      

        };
        USER[user.id == 0 ? "insert" : "update"](user).then(user =>{
            roleForm.reset();
            loadUserTable();
            alert('Usuario "' + user.name + '" guardado');
            
        }).catch(()=>{
            alert('Usuario no guardado');
        });
    }, false);

}, false);

