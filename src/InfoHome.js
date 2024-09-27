import React from 'react';
import './InfoHome.css';


function InfoHome() {
    return (
      <div class="container">
        <div class="images-and-size">
            <img alt="" src="https://static.nike.com/a/images/f_auto/dpr_3.0,cs_srgb/h_500,c_limit/cfac28f8-46ae-4b44-8205-4787b662f752/el-mejor-calzado-rosa-de-nike-para-comprar-ahora.jpg">
            </img>
            <div class=" slidesshow-buttons">
                <span class="focus"></span>
                <span></span>
                <span></span>
            </div>
            <p class="pick">Escoje una talla</p>
            <div class="sizes">
                <span>5</span>
                <span>6</span>
                <span>7</span>
                <span class="focus">8</span>
                <span>9</span>
                <span>10</span>
                <span>11</span>
                <span>12</span>
            </div>
        </div>
        <div class="product">
            <p> Producto destacado</p>
            <h1>bla bla bla</h1>
            <h2>$200</h2>
            <p class="description">
                ajunte una descripcion
            </p>
            <div class="buttons">
                <button class="add">Comprar</button>
                <button class="like">
                    <span>♥</span>
                </button>
            </div>   
        </div>
      </div>
    );
  }
  
  export {InfoHome};