import 'bootstrap/dist/css/bootstrap.min.css';
import { createContext, useReducer } from "react";
import { Container } from "react-bootstrap";
import cookie from "react-cookies";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import Login from "./components/Login";
import UserBill from './components/UserBill';
import Footer from "./layout/Footer";
import Header from "./layout/Header";
import MyUserReducer from "./reducers/MyUserReducer";

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
                <Route path="/user-bill" element={<UserBill />} />
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