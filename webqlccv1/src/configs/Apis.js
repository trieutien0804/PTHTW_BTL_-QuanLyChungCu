import axios from "axios";
import cookie from "react-cookies";

const SERVER_CONTEXT = "/QuanLyChungCu";

const SERVER = "http://localhost:8081/";

export const endpoints = {
    "login": `${SERVER_CONTEXT}/api/login/`,
    "current-user": `${SERVER_CONTEXT}/api/current-user/`,
    "update-profile": `${SERVER_CONTEXT}/api/update-profile/`,
    "user-bill": `${SERVER_CONTEXT}/api/current-resident/`,
    "create-payment": `${SERVER_CONTEXT}/payment/create_payment`
}

export const authApi = () => {
  return axios.create({
    baseURL: SERVER,
    headers: {
      "Authorization": cookie.load("token")
    }
  })
}

export default axios.create({
  baseURL: SERVER,
});

