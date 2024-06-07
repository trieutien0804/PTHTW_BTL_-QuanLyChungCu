import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import { Container } from "react-bootstrap";
import Footer from "./layout/Footer";
import Home from "./components/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./components/Login";

const App = () => {
  return(
    <>
      <div className="d-flex flex-column min-vh-100">
        <BrowserRouter>
          <Header />
          <main className="flex-grow-1"> {/* Thêm class này để main chiếm hết không gian có thể */}
            <Container>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
              </Routes>
            </Container>
          </main>
          <Footer />
        </BrowserRouter>
      </div>
    </>
  )
}
export default App;