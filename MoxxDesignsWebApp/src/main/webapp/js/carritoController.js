const cartContainer = document.getElementById("cartItems");
var products = [];

function obtenerProductos() {
    fetch("../carrito", {
        method: "GET",
    })
        .then((response) => {
            if (response.ok) {
                return response.json();
            }
        })
        .then((data) => {
            products = data.productos;

            // Limpiar el contenedor de productos antes de agregar nuevos
            cartContainer.innerHTML = "";

            // Iterar sobre los productos disponibles
            products.forEach((product) => {
                const productElement = document.createElement("div");
                productElement.classList.add("cart-item");
                // Producto no está en el carrito, mostrar opción para agregarlo
                productElement.innerHTML = `
                    <div class="row align-items-center">
                        <div class="col-md-2">
                            <img src="${product.imagen}" alt="${product.nombre}" class="img-fluid">
                        </div>
                        <div class="col-md-4">
                            <h5>${product.marca}, ${product.modelo}</h5>
                            <p class="text-muted mb-0">Precio unitario: $${product.precio.toFixed(2)}</p>
                        </div>
                      
                        <div class="col-md-1">
                            <button class="btn-remove" onclick="eliminarProducto(${product.codigo})">🗑️</button>
                        </div>
                    </div>
          `;

                // Agregar el producto al contenedor de productos
                cartContainer.appendChild(productElement);
            });

            calcularPrecioCarrito();
        })
        .catch((err) => {
            Swal.fire({
                title: "Error",
                text: err.message,
                icon: "error",
                customClass: {
                    confirmButton: 'btn btn-primary border-0'
                }
            });
        });
}

function eliminarProducto(codigo) {

    Swal.fire({
        title: "Eliminar Producto",
        text: "¿Quieres eliminar el Producto?",
        icon: "warning",
        customClass: {
            confirmButton: 'btn btn-primary border-0'
        }
    }).then(result => {
        if (result.isConfirmed) {
            const productoEliminar = products.find(product => product.codigo == codigo);

            fetch("../carrito/producto",
                {
                    method: "DELETE",
                    headers: {
                        "Content-Type": "application/json"
                    },
                    body: JSON.stringify({
                        codigo: productoEliminar.codigo,
                        modelo: productoEliminar.modelo,
                        marca: productoEliminar.marca,
                        anio: productoEliminar.anio,
                        color: productoEliminar.color,
                        precio: productoEliminar.precio,
                        imagen: productoEliminar.imagen
                    })
                }
            ).then(response => {
                if (response.ok) {
                    obtenerProductos();
                } else {
                    return response.text().then(error => {
                        throw new Error(error);
                    });
                }
            }).catch(err => {
                Swal.fire({
                    title: "Error",
                    text: err.message,
                    icon: "error",
                    customClass: {
                        confirmButton: 'btn btn-primary border-0'
                    }
                });
            })
        }
    });

}

function calcularPrecioCarrito() {
    const totalLabel = document.getElementById("total");
    let precioTotal = 0.0;
    products.forEach(product => {
        precioTotal += Number(product.precio);
    });
    totalLabel.innerText = "$" + precioTotal.toFixed(2);
}



function hacerPedido() {



    if (products.length === 0) {
        Swal.fire({
            title: "Error",
            text: "El carrito está vacío. Agrega productos antes de hacer un pedido.",
            icon: "error",
            customClass: {
                confirmButton: 'btn btn-primary border-0'
            }
        });
        return;
    }


    const pedido = {
        productosDTO: products
    };


    fetch("../pedido", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(pedido)
    })
        .then(response => {
            if (response.ok) {
                Swal.fire({
                    title: "Pedido realizado",
                    text: "Tu pedido ha sido realizado exitosamente.",
                    icon: "success",
                    customClass: {
                        confirmButton: 'btn btn-primary border-0'
                    }
                }).then(() => {

                    products = [];
                    cartContainer.innerHTML = "";
                    calcularPrecioCarrito();
                });
            } else {
                return response.text().then(error => {
                    throw new Error(error);
                });
            }
        })
        .catch(err => {
            Swal.fire({
                title: "Error",
                text: err.message,
                icon: "error",
                customClass: {
                    confirmButton: 'btn btn-primary border-0'
                }
            });
        });
}

const init = () => {
    obtenerProductos();
};

init();
