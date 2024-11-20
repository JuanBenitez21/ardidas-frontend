import React from 'react';
//import './assets/styles/Header.css';
import '../assets/styles/Header.css'
import ArdidasImage from '../assets/img/Ardidas.jpeg';

import { TodoSearch } from '../components/TodoSearch';

const Header = () => {

    const [searchValue, setSearchValue] = React.useState('');

  return (
    <header className="header">
      <div className="logo">
        <img src={ArdidasImage} alt="Ardidas" />
        <h1 className="ardidas"><a href="/">Ardidas</a></h1>
      </div>
      <div className="search-bar">
      
        <TodoSearch 

            searchValue={searchValue}
            setSearchValue={setSearchValue}
        />
        
      </div>
      <nav className="navigation">
        <ul>
            <li><a href="/guayos">Guayos</a></li>
            <li><a href="/guantes">Guantes de portero</a></li>
            <li><a href="/camisetas">Camisetas</a></li>
            <li><a href="/canilleras">Canilleras</a></li>
            <li className="ofertas"><a href="/ofertas" className="highlight">Ofertas</a></li>
        </ul>
      </nav>
      <div className="user-actions">
        <a href="#">Tiendas</a>
        <a href="/Acceder">Acceder</a>
        <a href="#">Carrito</a>
      </div>
    </header>
    
    
  );
};

export {Header};