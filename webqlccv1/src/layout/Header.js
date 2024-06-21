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
                    <Link className="nav-link me-3 text-white" to= "/">Trang chủ</Link>
                    <Nav.Link className="text-white" href="#link">Tủ đồ</Nav.Link>
                    <Nav.Link className="text-white" href="#link">Phản hồi</Nav.Link>
                    <Nav.Link className="text-white" href="#link">Khảo sát</Nav.Link>

                    <NavDropdown title={<span className="text-white">Thanh toán dịch vụ</span>} id="basic-nav-dropdown">
                    <NavDropdown.Item href="#action/3.1">Phí quản lý</NavDropdown.Item>
                    <NavDropdown.Item href="#action/3.2">Phí gửi xe</NavDropdown.Item>
                    <NavDropdown.Divider />
                    <NavDropdown.Item href="#action/3.4">
                        Separated link
                    </NavDropdown.Item>
                    </NavDropdown>
                    <NavDropdown title={<span className="text-white">Đăng ký dịch vụ</span>} id="basic-nav-dropdown">
                    <NavDropdown.Item className="text-white" href="#action/3.1">Action</NavDropdown.Item>
                    <NavDropdown.Item className="text-white" href="#action/3.2">Another action</NavDropdown.Item>
                    <NavDropdown.Item className="text-white" href="#action/3.3">Something</NavDropdown.Item>
                    </NavDropdown>
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