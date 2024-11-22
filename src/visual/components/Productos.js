// src/visual/Pages/Productos.js
import React, { useEffect, useState } from 'react';

function Productos() {
    const [productos, setProductos] = useState([]);

    useEffect(() => {
        fetch('http://localhost:8080/productos')
            .then(response => {
                if (!response.ok) {
                    throw new Error('Network response was not ok');
                }
                return response.json();
            })
            .then(data => setProductos(data))
            .catch(error => console.error('Error fetching productos:', error));
    }, []);

    return (
        <div>
            <h1>Productos</h1>
            <ul>
                {productos.length > 0 ? (
                    productos.map(producto => (
                        <li key={producto.id}>{producto.nombre}</li>
                    ))
                ) : (
                    <li>No hay productos disponibles.</li>
                )}
            </ul>
        </div>
    );
}

export default Productos;