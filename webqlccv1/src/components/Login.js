import { useState } from "react";
import { Button, Container, Form, Nav} from "react-bootstrap";

const Login = () => {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    return <>
        <Container style={{ display: 'flex', justifyContent: 'center', alignItems: 'center'}}>
            <div style={{ display: 'flex',  flexDirection: 'column', width: '50%' }}>
                <h1 className="text-center text-info">Đăng nhập</h1>
                <Form>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Tên đăng nhập</Form.Label>
                        <Form.Control value={username} onChange={e => setUsername(e.target.value)} type="email" placeholder="Nhập đăng nhập" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Mật khẩu</Form.Label>
                        <Form.Control value={password} onChange={e => setPassword(e.target.value)} type="email" placeholder="Nhập mật khẩu" />
                    </Form.Group>
                    <Form.Group className="mb-3 text-end" controlId="exampleForm.ControlInput1">
                        <Button variant="info" type="submit">Đăng nhập</Button>
                    </Form.Group>
                </Form>
            </div>
        </Container>

    </>
}
export default Login;