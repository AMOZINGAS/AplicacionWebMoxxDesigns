const loginNavItem = document.querySelector('.navbar-nav .nav-item:last-child');

function getUser() {
    fetch('../usuario', {
        method: 'GET'
    })
    .then(response => {
        if (response.ok) {
            return response.json();
        }
    })
    .then(usuario => {
        manejarInformacionUsuarioEnNavbar(usuario) ;
    })
    .catch(error => {
        console.log("Hubo un error") ;
    });
}

function cerrarSesion() {
    Swal.fire({
        title: 'Cerrar Sesion',
        text: "¿Estás seguro de querer cerrar sesión?",
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: 'Confirmar',
        cancelButtonText: 'Cancelar',
        customClass: {
            confirmButton: 'btn btn-primary border-0',
            cancelButton: 'btn btn-secondary border-0',
        }
    }).then(result => {
        if (result.isConfirmed) {
            fetch("../auth/logout", 
                {
                    method: "POST"
                }
            ).then(response => {
                if(response.ok) {
                    window.location.reload();
                } else {
                    Swal.fire({
                        title: "Error",
                        text: "Error al cerrar sesión",
                        icon: "error",
                        customClass: {
                            confirmButton: 'btn btn-primary border-0',
                        }
                    });
                }
            });
        }
    });
}


function manejarInformacionUsuarioEnNavbar(usuario) {
    const loginNavItem = document.querySelector('.navbar-nav .nav-item:last-child');


    loginNavItem.innerHTML = `
    <span class="nav-link fs-5 fw-bold text-primary">¡Bienvenido ${usuario.nombre} ${usuario.apellido}!</span>
    `;

    const cerrarSesionItem = document.createElement('li');
    cerrarSesionItem.classList.add('nav-item');

    cerrarSesionItem.innerHTML = `
    <button id="cerrar-sesion" class="btn btn-danger ms-2" onclick="cerrarSesion()">
        <i class="fas fa-sign-out-alt"></i> Cerrar Sesión
    </button>
    `;

    const navbarNav = document.querySelector('.navbar-nav');
    navbarNav.appendChild(cerrarSesionItem);
    navbarNav.style.display = 'flex';
    navbarNav.style.alignItems = 'center';

}

const initNavBar = () => {
    
    getUser() ;

} ;

initNavBar() ;