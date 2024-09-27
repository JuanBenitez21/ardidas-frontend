import { useRoutes, BrowserRouter} from 'react-router-dom';
import React from 'react';
import { Home } from './Home';
import { Guayos } from './Guayos';
import {Guantes} from './Guantes'
import {Camisetas} from './Camisetas'
import {Canilleras} from './Canilleras';
import {Ofertas} from './Ofertas';
import {Loging} from './Loging';



import 'react-responsive-carousel/lib/styles/carousel.min.css';
import './Carousel.css';
import Register from './Register';
import { InfoHome } from './InfoHome';
import { Form } from 'react-router-dom';

const AppRoutes= ()=>{
  let routes= useRoutes([
    { path: '/', element: <Home /> },
    { path: '/Guayos', element: <Guayos /> },
    { path: '/Guantes', element: <Guantes /> },
    { path: '/Camisetas', element: <Camisetas /> },
    { path: '/Canilleras', element: <Canilleras /> },
    { path: '/Ofertas', element: <Ofertas /> },
    { path: '/Acceder', element: <Loging /> },
    { path: '/Registro', element: <Register /> },

  ]
  )
  return routes
}



const App=()=> {
  return (
    <BrowserRouter>
      <AppRoutes/>
    </BrowserRouter>
  );
}

export default App;
