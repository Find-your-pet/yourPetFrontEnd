const PET = new Pet();

document.addEventListener("DOMContentLoaded", event => {

    const roleForm = document.querySelector("#grid-formulario");

    function loadPetTable(){
        const table = document.querySelector("tbody");
        table.innerHTML ="";
        PET.findAll().then(pets => {
            pets.forEach(pet =>{
                const row = document.createElement("tr");
                const cells = [
                    document.createElement("td"),
                    document.createElement("td"),
                    document.createElement("td"),
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
                //buttons[0].textContent = "Registrar";
                //buttons[0].addEventListener("click", event => {
                    
                   // roleForm.id.value = pet.id;
                    //roleForm.edad.value = pet.age;
                    //roleForm.raza.value = pet.breed;
                    //roleForm.color.value = pet.color;
                    //roleForm.descripcion.value = pet.description;
                    //roleForm.genero.value = pet.gender;
                    //roleForm.nombre.value = pet.name;
                    //roleForm.tamano.value = pet.size;

                //}, false);
                       
                    

                    buttons[0].textContent = "Eliminar";
                    buttons[0].addEventListener("click", event => {
                    PET.deleteByID(pet.id).then(pet =>{
                       row.remove();
                       alert('Mascota "' + pet.name + '" eliminado');
                    }).catch(()=>{
                      alert('Mascota no eliminada');
                    });
                    
                }, false);
                    
                cells[0].textContent = pet.id;
                cells[1].textContent = pet.name;
                cells[2].textContent = pet.gender;
                cells[3].textContent = pet.breed;
                cells[4].textContent = pet.age;
                cells[5].textContent = pet.size;
                cells[6].textContent = pet.color;
                cells[7].textContent = pet.description;
                                       
                cells[8].append(...buttons);
                row.append(...cells);
                table.append(row);
            });
        });
    };

    loadPetTable();

    roleForm.addEventListener("submit", event =>{
        event.preventDefault(); 
        const pet = {
            id: roleForm.id.value,
            age: roleForm.edad.value,
            breed: roleForm.raza.value,
            color: roleForm.color.value,
            description: roleForm.descripcion.value,
            gender: roleForm.genero.value,
            name: roleForm.nombre.value,
            size: roleForm.tamano.value         

        };
        PET[pet.id == 0 ? "insert" : "update"](pet).then(pet =>{
            roleForm.reset();
            loadPetTable();
            alert('Mascota "' + pet.name + '" guardada');
            
        }).catch(()=>{
            alert('Mascota no guardada');
        });
    }, false);

}, false);
