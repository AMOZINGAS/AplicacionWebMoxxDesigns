const productsContainer = document.getElementById("products-container");
var userProducts = [];

function obtenerProductos() {
  fetch("../productos", {
    method: "GET",
  })
    .then((response) => {
      if (response.ok) {
        return response.json();
      }
    })
    .then((productos) => {

      if(productos[1]) 
        userProducts = productos[1] ;

      productsContainer.innerHTML = "" ;

      productos[0].forEach((producto) => {
        const productElement = document.createElement("div");
        productElement.classList.add("col-md-6", "col-lg-4");

        const productoEnCarrito = userProducts.some(
          (userProduct) => userProduct.codigo === producto.codigo
        );

        if (!productoEnCarrito) {
          productElement.innerHTML = `
          <div class="product-card">
            <img src="${producto.imagen}" class="product-image" alt="${producto.modelo}">
            <div class="product-details">
              <h3 class="product-title">${producto.marca}</h3>
              <p class="product-description">Año: ${producto.anio}</p>
              <p class="product-description">Modelo: ${producto.modelo}</p>
              <p class="product-description">Color: ${producto.color}</p>
              <div class="product-price">$${producto.precio}</div>
              <button class="btn-add-cart">
                <i class="fas fa-shopping-cart"></i>
                Agregar al Carrito
              </button>
            </div>
          </div>
        `;

        let button = productElement.querySelector('.btn-add-cart')

        productElement.onclick = () => {
          agregarAlCarrito(producto, button) ;
        }
        } else {
          productElement.innerHTML = `
          <div class="product-card">
            <img src="${producto.imagen}" class="product-image" alt="${producto.modelo}">
            <div class="product-details">
              <h3 class="product-title">${producto.marca}</h3>
              <p class="product-description">Año: ${producto.anio}</p>
              <p class="product-description">Modelo: ${producto.modelo}</p>
              <p class="product-description">Color: ${producto.color}</p>
              <div class="product-price">$${producto.precio}</div>
              <button class="btn-add-cart disabled">
                Producto en el Carrito
              </button>
            </div>
          </div>
        `;
        }
        productsContainer.appendChild(productElement);
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

  console.log(producto.modelo) ;
  console.log(producto.codigo)

  fetch("../carrito/producto",
    {
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
    }
  ).then(response => {
    if (response.ok) {
      obtenerProductos() ;
    } else if (response.status = 401) {
      Swal.fire({
        title: "Error",
        text: "Necesitas iniciar sesión para agregar productos al carrito",
        icon: "error",
        customClass: {
          confirmButton: "btn btn-primary border-0"
        }
      });
    } else {
      throw new Error("Error al agregar producto") ;
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
  });
}

const init = () => {
  obtenerProductos() ;
};

init();