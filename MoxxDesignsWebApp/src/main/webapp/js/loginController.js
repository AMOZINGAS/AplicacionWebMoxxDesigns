const inputEmail = document.getElementById("email") ;
const inputPassword = document.getElementById("password") ;
const btnLogin = document.getElementById("btn-login") ;

function login() {

    fetch("../auth/login", 
        {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({
                email: inputEmail.value,
                password: inputPassword.value
            })
        }
    ).then(response => {
        if(response.ok) {
            Swal.fire({
                title: "¡Bienvenido!",
                text: "Inicio de Sesión Exitoso",
                icon: "success",
                confirmButtonText: "OK",
                customClass: {
                    confirmButton: 'bg-blue-600 text-white border border-blue-600 hover:bg-blue-700'
                }
            }).then(response =>{
                window.location.href = "/MoxxDesignsWebApp/pages/index.html" ;
            }) ;
        } else {
            return response.text().then(errorMessage => {
                throw new Error(errorMessage);
            });
        }
    }).catch(err => {
        console.log(err) ;
        Swal.fire({
            title: "Error",
            text: err.message,
            icon: "error",
            customClass: {
                confirmButton: 'bg-blue-600 text-white border border-blue-600 hover:bg-blue-700'
            }
        });
    }) ;

}

const init = () => {

    btnLogin.onclick = () => {
        login() ;
    }

    document.onkeydown = (event) => {
        if (event.key === "Enter") {
            login() ;
        }
    }

}

init() ;