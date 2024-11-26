// Agregar al archivo js/templatemo_custom.js

// Función para manejar el carrito de compras
let cart = [];

function initShoppingCart() {
    // Agregar event listeners a todos los botones de "Agregar al Carrito"
    const addToCartButtons = document.querySelectorAll('.add-to-cart');
    
    addToCartButtons.forEach(button => {
        button.addEventListener('click', function(e) {
            const productCard = e.target.closest('.product-card');
            const productName = productCard.querySelector('.product-name h3').textContent;
            const productPrice = productCard.querySelector('.price-tag').textContent;
            const productImage = productCard.querySelector('.product-image img').src;
            
            // Agregar producto al carrito
            addToCart({
                name: productName,
                price: productPrice,
                image: productImage
            });
            
            // Mostrar notificación
            showNotification(`${productName} agregado al carrito`);
        });
    });
}

function addToCart(product) {
    cart.push(product);
    updateCartCount();
    // Guardar carrito en localStorage
    localStorage.setItem('cart', JSON.stringify(cart));
}

function updateCartCount() {
    // Actualizar el contador del carrito en el menú
    const cartButton = document.querySelector('.cartbutton');
    if (cartButton) {
        const count = cart.length;
        cartButton.innerHTML = `<i class="fa fa-shopping-cart"></i> ${count > 0 ? `(${count})` : ''}`;
    }
}

function showNotification(message) {
    // Crear y mostrar una notificación temporal
    const notification = document.createElement('div');
    notification.className = 'cart-notification';
    notification.textContent = message;
    
    document.body.appendChild(notification);
    
    // Eliminar la notificación después de 3 segundos
    setTimeout(() => {
        notification.remove();
    }, 3000);
}

// Inicializar el carrito cuando el documento esté listo
document.addEventListener('DOMContentLoaded', function() {
    // Recuperar carrito del localStorage
    const savedCart = localStorage.getItem('cart');
    if (savedCart) {
        cart = JSON.parse(savedCart);
        updateCartCount();
    }
    
    initShoppingCart();
});