const inputFirstName = document.getElementById("firstName");
const inputLastName = document.getElementById("lastName");
const inputEmail = document.getElementById("email");
const inputPassword = document.getElementById("password");
const inputTerms = document.getElementById("terms");
const btnSignup = document.getElementById("btn-signup");

function signup() {

    if(!validarCampos())
        return ;

    fetch("../auth/signup", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            nombre: inputFirstName.value,
            apellido: inputLastName.value,
            email: inputEmail.value,
            password: inputPassword.value
        })
    }).then(response => {
        if (response.ok) {
            Swal.fire({
                title: "¡Registro Exitoso!",
                text: "Tu cuenta ha sido creada correctamente",
                icon: "success",
                confirmButtonText: "Iniciar Sesión",
                customClass: {
                    confirmButton: 'bg-blue-600 text-white border border-blue-600 hover:bg-blue-700'
                }
            }).then(() => {
                window.location.href = "/MoxxDesignsWebApp/pages/login.html";
            });
        } else {
            return response.text().then(errorMessage => {
                throw new Error(errorMessage);
            });
        }
    }).catch(err => {
        console.error(err);
        Swal.fire({
            title: "Error de Registro",
            text: err.message || "No se pudo crear la cuenta. Intenta de nuevo.",
            icon: "error",
            customClass: {
                confirmButton: 'bg-blue-600 text-white border border-blue-600 hover:bg-blue-700'
            }
        });
    });
}

const init = () => {
    btnSignup.onclick = () => {
        signup();
    };

    document.onkeydown = (event) => {
        if (event.key === "Enter") {
            signup();
        }
    };
}

function validarCampos() {
    if (!inputTerms.checked) {
        Swal.fire({
            title: "Error",
            text: "Debes aceptar los términos y condiciones",
            icon: "warning",
            customClass: {
                confirmButton: 'bg-blue-600 text-white border border-blue-600 hover:bg-blue-700'
            }
        });
        return false;
    }

    if (!inputFirstName.value || !inputLastName.value || !inputEmail.value || !inputPassword.value) {
        Swal.fire({
            title: "Error",
            text: "Por favor, completa todos los campos",
            icon: "error",
            customClass: {
                confirmButton: 'bg-blue-600 text-white border border-blue-600 hover:bg-blue-700'
            }
        });
        return false;
    }

    return true ;
}

init();