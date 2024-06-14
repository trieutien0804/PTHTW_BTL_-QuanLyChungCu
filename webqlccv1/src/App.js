import { BrowserRouter, Route, Routes } from "react-router-dom";
import Header from "./layout/Header";
import { Container } from "react-bootstrap";
import Footer from "./layout/Footer";
import Home from "./components/Home";
import 'bootstrap/dist/css/bootstrap.min.css';
import Login from "./components/Login";
import { createContext, useReducer } from "react";
import MyUserReducer from "./reducers/MyUserReducer";
import cookie from "react-cookies";
import Resident from "./components/Resident";

export const MyUserContext = createContext();

const App = () => {
  const [user, dispatch] = useReducer(MyUserReducer, cookie.load("user") || null);

  return(
    <MyUserContext.Provider value={[user, dispatch]}>
      <div className="d-flex flex-column min-vh-100">
        <BrowserRouter>
          <Header />
          <main className="flex-grow-1"> 
            <Container>
              <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<Login />} />
                <Route path="/resident" element={<Resident />} />
              </Routes>
            </Container>
          </main>
          <Footer />
        </BrowserRouter>
      </div>
    </MyUserContext.Provider>
  )
}
export default App;