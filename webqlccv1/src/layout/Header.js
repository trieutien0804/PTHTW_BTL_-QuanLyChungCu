import {  Button, Container, Nav, NavDropdown, Navbar} from "react-bootstrap";
import { Link } from "react-router-dom";
import '../css/Header.css'; 
import { useContext } from "react";
import { MyUserContext } from "../App";


const Header = () => {
    const[user, dispatch] = useContext(MyUserContext);
    const logout = () => {
        dispatch({
            "type": "logout"
        })
    }
   
    return (
    <>
        <Navbar expand="lg" style={{ backgroundColor: '#0C2249' }}>
        <Container>
            <Navbar.Brand className="ContentCenter" to= "/" style={{ fontSize: '2.5em', color: 'white', width: '150px' }}>T&D</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto" style={{ color: 'white' }}>
                    <Link to="/user-bill">Thanh toán hóa đơn</Link>
                    <Link to="/user-locker">Tủ đồ điện tử</Link>
                    <Link to="/user-parking-card">Đăng ký thẻ gửi xe</Link>
                    <Link to="/user-feedback">Phản ánh</Link>
                    <Link to="/user-survey">Khảo sát</Link>
                </Nav>
                {user === null ? <Link variant="outline-secondary" className="nav-link me-2 text-white" to="/login">Đăng nhập</Link> : <>
                    <Link variant="outline-secondary" className="nav-link me-2 text-white" to="/resident">Chào {user.username}</Link>
                    <Button variant="secondary" onClick={logout}>Đăng xuất</Button>
                </>}

            </Navbar.Collapse>
        </Container>
        </Navbar>
    </>)
} 
export default Header;