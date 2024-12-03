const pedidosTableBody = document.getElementById('pedidosTableBody');

var pedidos = [] ;

function obtenerPedidos() {

    fetch("../pedido",
        {
            method: "GET"
        }
    ).then(response => {
        if(response.ok) {
            return response.json() ;
        } else if(response.status == 401) {

        }
    }).then(data => {
        pedidos = data ;
        calcularPrecio() ;
        renderPedidos() ;
    }) ;

}

function renderPedidos() {
    pedidosTableBody.innerHTML = '';

    pedidos.forEach(pedido => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${new Date(
                pedido.fecha_hora.year, 
                pedido.fecha_hora.month - 1,
                pedido.fecha_hora.dayOfMonth
            ).toISOString().split('T')[0]}</td>
            <td>${pedido.cantidad}</td>
            <td>$${pedido.precioTotal.toFixed(2)}</td>
        `;
        pedidosTableBody.appendChild(row);
    });
}

function calcularPrecio() {
    pedidos.forEach(pedido => {
        pedido.precioTotal = 0.0 ;
        pedido.cantidad = 0 ;

        pedido.productosDTO.forEach(producto => {
            pedido.precioTotal += Number(producto.precio) ;
            pedido.cantidad ++ ;
        }) ;
    }) ;
}

const init = () => {
    obtenerPedidos() ;
}

init() ;