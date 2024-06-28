import 'bootstrap/dist/css/bootstrap.min.css';
import { createContext, useReducer } from "react";
import { Container } from "react-bootstrap";
import cookie from "react-cookies";
import { BrowserRouter, Route, Routes } from "react-router-dom";
import Home from "./components/Home";
import Login from "./components/Login";
import Resident from './components/Resident';
import UserLocker from './components/UserLocker';
import UserBill from './components/UserBill';
import UserFeedback from './components/UserFeedback';
import UserSurvey from './components/UserSurvey';
import UserParkingCard from './components/UserParkingCard';  
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
                <Route path="/user-locker" element={<UserLocker />} />
                <Route path="/user-feedback" element={<UserFeedback />} />
                <Route path="/user-survey" element={<UserSurvey />} />
                <Route path="/user-parking-card" element={<UserParkingCard />} />
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