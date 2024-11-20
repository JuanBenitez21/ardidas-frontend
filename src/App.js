import { useRoutes, BrowserRouter} from 'react-router-dom';
import React from 'react';
import { Home } from './visual/Pages/Home';
import { Guayos } from './visual/Pages/Guayos';
import {Guantes} from './visual/Pages/Guantes'
import {Camisetas} from './visual/Pages/Camisetas'
import {Canilleras} from './visual/Pages/Canilleras';
import {Ofertas} from './visual/Pages/Ofertas';
import {Loging} from './visual/components/Loging';



import 'react-responsive-carousel/lib/styles/carousel.min.css';
import './visual/assets/styles/Carousel.css';
import Register from './visual/components/Register';

//import { InfoHome } from './InfoHome';
//import { Form } from 'react-router-dom';

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
