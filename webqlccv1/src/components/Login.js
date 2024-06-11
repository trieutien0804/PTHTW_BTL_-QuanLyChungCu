import { useState } from "react";
import { Button, Container, Form } from "react-bootstrap";
import Apis, { endpoints } from "../configs/Apis";

const Login = () => {
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();

    const login = (event) => {
        event.preventDefault();
        const process = async () => {
            try {
                let res = await Apis.post(endpoints['login'], {
                        "username": username,
                        "password": password
                });
                console.info(res.data);
            } catch (err) {
                console.error(err);
            }

        }
        process();
    }
    return <>
        <Container style={{ display: 'flex', justifyContent: 'center', alignItems: 'center' }}>
            <div style={{ display: 'flex', flexDirection: 'column', width: '50%' }}>
                <h1 className="text-center text-info">Đăng nhập</h1>
                <Form onSubmit={login}>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Tên đăng nhập</Form.Label>
                        <Form.Control value={username} onChange={e => setUsername(e.target.value)} type="text" placeholder="Nhập đăng nhập" />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Mật khẩu</Form.Label>
                        <Form.Control value={password} onChange={e => setPassword(e.target.value)} type="password" placeholder="Nhập mật khẩu" />
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