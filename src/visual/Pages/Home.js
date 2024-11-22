import React from 'react';
import { Header } from '../layouts/Header';
import { Carousel } from 'react-responsive-carousel';
import {InfoHome} from '../components/InfoHome';
import 'react-responsive-carousel/lib/styles/carousel.min.css';
import'../assets/styles/Carousel.css';
import Productos from '../components/Productos'; // Asegúrate de que la ruta sea correcta





function Home() {
    
  return (
    <>
     <Header />
     <Carousel
        showArrows={true}
        autoPlay={true}
        infiniteLoop={true}
        interval={3000}
        showThumbs={false}
        showStatus={false}
        dynamicHeight={true}
      >
        <div>
          <img src="https://www.semana.com/resizer/v2/N27XGESYTJHVTOYWHQYH2WCURQ.jpg?auth=e0db3b5ae1941e204931156b65d49d2568ffac8eb55ab16cd0d5749be3834e9a&smart=true&quality=75&width=1280&height=720" alt="Imagen 1" />
        </div>
        <div>
          <img src="https://www.futbolemotion.com/imagesbanners/xs/nike_FC-Barcelona_away24_mb_ok.webp" alt="Imagen 2" />
        </div>
        <div>
          <img src="https://brand.assets.adidas.com/capi/esCO/Images/2-pack-guayos_195-1044678.jpg" alt="Imagen 3" />
        </div>
        <div>
          <img src="https://media.licdn.com/dms/image/v2/D4E12AQEVKipa1fXuFg/article-cover_image-shrink_720_1280/article-cover_image-shrink_720_1280/0/1709235602924?e=2147483647&v=beta&t=MCxpe7TLDRjiTwdcA41TN1Tmz7f0d9rTSR7XLoLUyec" alt="Imagen 4" />
        </div>
      </Carousel>
      
      <InfoHome/>
      <Productos /> {/* Asegúrate de que este componente esté aquí */}

     </>
  );
}

export {Home};
