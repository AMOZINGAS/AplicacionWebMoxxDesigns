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
                            <button class="btn-remove" onclick="removeProduct(${product.codigo})">🗑️</button>
                        </div>
                    </div>
          `;

                // Agregar el producto al contenedor de productos
                cartContainer.appendChild(productElement);
            });
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

function agregarAlCarrito(producto, buttonElement) {
    console.log(producto.modelo);
    console.log(producto.codigo);

    fetch("../carrito/producto", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify({
            codigo: producto.codigo,
            modelo: producto.modelo,
            marca: producto.marca,
            anio: producto.anio,
            color: producto.color,
            precio: producto.precio,
            imagen: producto.imagen
        })
    })
        .then(response => {
            if (response.ok) {
                obtenerProductos(); // Recargar los productos
            } else if (response.status === 401) {
                Swal.fire({
                    title: "Error",
                    text: "Necesitas iniciar sesión para agregar productos al carrito",
                    icon: "error",
                    customClass: {
                        confirmButton: "btn btn-primary border-0"
                    }
                });
            } else {
                throw new Error("Error al agregar producto");
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
    obtenerProductos(); // Obtener los productos al cargar la página
};

init();
