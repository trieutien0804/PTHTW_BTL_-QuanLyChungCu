import { Image } from 'react-bootstrap';
import homeImage from '../images/chungcu2.jpg'; 


const Home = () => {
  return (

      <Image src={homeImage} alt="Home Image" style={{ width: '100%', height: '100%', objectFit: 'cover' }} />

  )
}

export default Home;