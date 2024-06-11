import axios from "axios";

const SERVER_CONTEXT = "/QuanLyChungCu";

export const endpoints = {
    "login": `${SERVER_CONTEXT}/api/login/`
}

export default axios.create({
    baseURL: "http://localhost:8081/"
})