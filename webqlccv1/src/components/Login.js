import { useContext, useState, useRef } from "react";
import { Button, Container, Form, Modal, Alert } from "react-bootstrap";
import Apis, { authApi, endpoints } from "../configs/Apis";
import cookie from "react-cookies";
import { MyUserContext } from "../App";
import { Navigate } from "react-router-dom";


const Login = () => {
    const [user, dispatch] = useContext(MyUserContext);
    const [username, setUsername] = useState();
    const [password, setPassword] = useState();
    //const [userLogin, setUser] = useState({name: "", password:""});
    const [showModal, setShowModal] = useState(false);
    const [newPassword, setNewPassword] = useState("");
    const [confirmPassword, setConfirmPassword] = useState("");
    const [error, setError] = useState(null);
    const newPasswordRef = useRef();
    const confirmPasswordRef = useRef();
    const [infoUser, setInfoUser] = useState({});
    const avatar = useRef();

    const login = (event) => {

        event.preventDefault();

        const process = async () => {
            try {
                const res = await Apis.post(endpoints['login'], {
                    "username": username,
                    "password": password
                });

                if (res.data) {
                    cookie.save("token", res.data);

                    const { data } = await authApi().get(endpoints['current-user']);

                    setInfoUser({ ...data })

                    if (data.isFirstLogin === 1) {
                        setShowModal(true);
                    } else {
                        handleLoginSuccess(data);
                    }
                }

            } catch (err) {
                console.error(err);
            }
        }

        process();
    }

    const handleLoginSuccess = (data) => {
        cookie.save("user", data)

        dispatch({
            "type": "login",
            "payload": data
        });
    };

    const handleUpdateProfile = async () => {
        if (newPassword !== confirmPassword) {
            setError("Mật khẩu xác nhận không khớp");
            return;
        }

        try {
            const formData = new FormData();
            formData.append("id", infoUser.id);
            formData.append("newPassword", newPassword);
            formData.append("avatar", avatar.current.files[0]);
            await authApi().post(endpoints["update-profile"], formData);

            setShowModal(false);
            let { data } = await authApi().get(endpoints['current-user']);
            handleLoginSuccess(data);
        } catch (err) {
            console.error(err);
        }
    };

    if (user !== null)
        return <Navigate to="/" />

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
        <Modal show={showModal} onHide={() => setShowModal(false)}>
            <Modal.Header closeButton>
                <Modal.Title>Bạn cần đổi mật khẩu và upload avatar</Modal.Title>
            </Modal.Header>
            <Modal.Body>
                <Form>
                    {error && <Alert variant="danger">{error}</Alert>}
                    <Form.Group className="mb-3">
                        <Form.Label>Mật khẩu mới:</Form.Label>
                        <Form.Control type="password" value={newPassword} onChange={(e) => setNewPassword(e.target.value)} ref={newPasswordRef} required />
                    </Form.Group>
                    <Form.Group className="mb-3">
                        <Form.Label>Xác nhận mật khẩu:</Form.Label>
                        <Form.Control type="password" value={confirmPassword} onChange={(e) => setConfirmPassword(e.target.value)} ref={confirmPasswordRef} required />
                    </Form.Group>
                    <Form.Group className="mb-3" controlId="exampleForm.ControlInput1">
                        <Form.Label>Ảnh đại diện</Form.Label>
                        <Form.Control type="file" ref={avatar} accept="image/*"/>
                    </Form.Group>
                </Form>
            </Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={() => setShowModal(false)}>
                    Hủy
                </Button>
                <Button variant="primary" onClick={handleUpdateProfile}>
                    Cập nhật
                </Button>
            </Modal.Footer>
        </Modal>
    </>
}
export default Login;