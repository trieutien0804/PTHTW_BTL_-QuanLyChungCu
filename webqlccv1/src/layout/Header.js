import {  Container, Nav, NavDropdown, Navbar} from "react-bootstrap";
import { Link } from "react-router-dom";
import '../css/Header.css'; 


const Header = () => {
    return (
    <>
        <Navbar expand="lg" style={{ backgroundColor: '#0C2249' }}>
        <Container>
            <Navbar.Brand className="ContentCenter" href="/" style={{ fontSize: '2.5em', color: 'white', width: '150px' }}>T&D</Navbar.Brand>
            <Navbar.Toggle aria-controls="basic-navbar-nav" />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="me-auto" style={{ color: 'white' }}>
                    <Link className="nav-link me-3" to= "/">Trang chủ</Link>
                    <Nav.Link href="#link">Tủ đồ</Nav.Link>
                    <Nav.Link href="#link">Phản hồi</Nav.Link>
                    <Nav.Link href="#link">Khảo sát</Nav.Link>

                    <NavDropdown title="Thanh toán dịch vụ" id="basic-nav-dropdown">
                    <NavDropdown.Item href="#action/3.1">Phí quản lý</NavDropdown.Item>
                    <NavDropdown.Item href="#action/3.2">Phí gửi xe</NavDropdown.Item>
                    <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                    <NavDropdown.Divider /> {/*Tạo 1 đường ke ngang trong Dropdow*/}
                    <NavDropdown.Item href="#action/3.4">
                        Separated link
                    </NavDropdown.Item>
                    </NavDropdown>
                    <NavDropdown title="Đăng ký dịch vụ" id="basic-nav-dropdown">
                    <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>
                    <NavDropdown.Item href="#action/3.2">Another action</NavDropdown.Item>
                    <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>
                    <NavDropdown.Divider /> {/*Tạo 1 đường ke ngang trong Dropdow*/}
                    <NavDropdown.Item href="#action/3.4">
                        Separated link
                    </NavDropdown.Item>
                    </NavDropdown>
                </Nav>
                <Link variant="outline-secondary" className="nav-link me-2 text-white" to="/login">Đăng nhập</Link> 

            </Navbar.Collapse>
        </Container>
        </Navbar>
    </>)
} 
export default Header;