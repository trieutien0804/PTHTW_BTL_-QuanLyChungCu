import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/QuanLyChungCu";
const SERVER = "http://localhost:8080/";


export const endpoints = {
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`
}

export const authApi = () =>{
    
    return axios.create ({
        baseURL: SERVER,
        header: {
            "Authorization" : cookie.load("token")
        }
    })
}

export default axios.create({
    baseURL: SERVER
})