import USER_LOGIN from "../../../type/USER_LOGIN.ts";
import axios from "axios"
import CONNEXION_RESPONSE_LOGIN from "../../../type/CONNEXION_RESPONSE_LOGIN.ts";
import TokenAuth from "../../../type/TokenAuth.ts";
import Cookies from "universal-cookie";
const cookies = new Cookies()

const authToken: TokenAuth | undefined = cookies.get("token") as TokenAuth | undefined

const config = {
    headers: {
        "Content-Type": "application/json",
    },
    withCredentials: true
}
export const loginUser = async (userData: USER_LOGIN) : Promise<CONNEXION_RESPONSE_LOGIN> =>{
    try {
        const { username, password } = userData
        const response = await axios.post<CONNEXION_RESPONSE>("http://localhost:8080/auth/login" ,{
            username,
            password
        }, config)
        sessionStorage.setItem("username", username)

        return response.data as CONNEXION_RESPONSE_LOGIN
    }
    catch (err: unknown) {
        // if ((err as AXIOS_ERROR).message) {
        //     throw new Error("Error connecting")
        // } else {
        //     throw new Error("Error connecting to server")
        // }
    }
}
