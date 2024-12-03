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
      productos.forEach((producto) => {
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
            <img src="https://moto.suzuki.es/assets/img/image-moto-slider-home-1.png" class="product-image" alt="${producto.modelo}">
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
      buttonElement.innerText = "Producto en el Carrito";
      buttonElement.onclick = null;
      buttonElement.classList.add("btn-add-cart", "disabled");
    } else if (response.status = 401) {
      Swal.fire({
        title: "Error",
        text: "Necesitas iniciar sesión para agregar productos al carrito",
        icon: "error",
        customClass: {
          confirmButton: "btn btn-primary border-0"
        }
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
  });
}

async function obtenerProductosEnCarritoDeUsuario() {

  fetch("../carrito",
    {
      method: "GET"
    }
  ).then(response => {
    if (response.ok) {
      return response.json();
    } else if (response.status == 401) {
      return;
    }
  }).then(products => {
    userProducts = products;
  }).catch(err => {

  });

}

const init = () => {
  obtenerProductosEnCarritoDeUsuario() ;
  obtenerProductos() ;
};

init();