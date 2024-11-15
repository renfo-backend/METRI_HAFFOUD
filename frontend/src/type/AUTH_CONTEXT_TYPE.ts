import USER_CONNECTION from "../type/USER_LOGIN.ts"
import CONNECTION_RESPONSE_LOGIN from "../type/CONNEXION_RESPONSE_LOGIN.ts"
interface auth_context {
    isAuthenticated: boolean
    login: (userData: USER_CONNECTION) => Promise<CONNECTION_RESPONSE_LOGIN>
    // logout: () => Promise<CONNECTION_RESPONSE_LOGIN>
    // checkDoubleAuth: (code: string, username: string) => Promise<CONNECTION_RESPONSE_LOGIN>
}

export default auth_context