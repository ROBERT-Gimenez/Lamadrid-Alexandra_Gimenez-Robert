function registrarPaciente() {
    const form = document.getElementById("registroPacienteForm");
    if (form) {
        form.addEventListener("submit", function (event) {
            event.preventDefault();

            let nombre = document.getElementById("nombrePaciente").value;
            let apellido = document.getElementById("apellidoPaciente").value;
            let dni = document.getElementById("dniPaciente").value;
            let fechaIngreso = document.getElementById("fechaIngreso").value;
            let calle = document.getElementById("calle").value;
            let numero = document.getElementById("numero").value;
            let localidad = document.getElementById("localidad").value;
            let provincia = document.getElementById("provincia").value;

            let pacienteData = {
                nombre: nombre,
                apellido: apellido,
                dni: dni,
                fechaIngreso: fechaIngreso,
                domicilio: {
                    calle: calle,
                    numero: numero,
                    localidad: localidad,
                    provincia: provincia,
                }
            };

            fetch("http://localhost:8081/pacientes/registrar", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: JSON.stringify(pacienteData),
            })
            .then((response) => {
                if (!response.ok) {
                    throw new Error(`Error HTTP ${response.status}: ${response.statusText}`);
                }
                return response.json();
            })
            .then((data) => {
                if (data.error) {
                    alert(data.error);
                } else {
                    mostrarPaciente()
                    alert("Paciente registrado con éxito.");
                }
            })
            .catch((error) => {
                console.error("Error:", error);
                alert("Hubo un error al registrar al paciente.");
            });
        });
    }
}

function registrarOdontologo() {
  const form = document.getElementById("registroOdontologoForm");
  if (form) {
    form.addEventListener("submit", function (event) {
      event.preventDefault();

      let nombre = document.getElementById("nombreOdontologo").value;
      let apellido = document.getElementById("apellidoOdontologo").value;
      let matricula = document.getElementById("matriculaOdontologo").value;

      let odontologoData = {
        matricula: matricula,
        nombre: nombre,
        apellido: apellido,
      };

      fetch("http://localhost:8081/odontologos/registrar", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(odontologoData),
      })
         .then((response) => {
                console.log(response);
                if (!response.ok) {
                    throw new Error(`Error HTTP ${response.status}: ${response.statusText}`);
                }
                return response.json();
            })
        .then((data) => {
            if (data.error) {
                 alert(data.error);
             } else {
              console.log(data);
              alert("Odontólogo registrado con éxito.");
     }  })
        .catch((error) => {
          console.error("Error:", error);
          alert("Hubo un error al registrar al odontólogo.");
        });
    });
  }
}


function mostrarPaciente() {
  fetch("http://localhost:8081/pacientes", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      console.log(data);

      const listaPacientes = document.getElementById("listaPacientes");

      listaPacientes.innerHTML = "";

      data.forEach((paciente) => {
        const pacienteElement = document.createElement("div");
        pacienteElement.innerHTML = `
          <h3>${paciente.nombre} ${paciente.apellido}</h3>
          <p>DNI: ${paciente.dni}</p>
          <p>Fecha de Ingreso: ${paciente.fechaIngreso}</p>
          <p>Domicilio: ${paciente.domicilio.calle} ${paciente.domicilio.numero}, ${paciente.domicilio.localidad}, ${paciente.domicilio.provincia}</p>
        `;

        listaPacientes.appendChild(pacienteElement);
      });
    })
    .catch((error) => {
      console.error("Error:", error);
      alert("Hubo un error al obtener la lista de pacientes.");
    });
}

mostrarPaciente()
registrarPaciente();
registrarOdontologo();
