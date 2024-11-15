import { createContext, useContext, useState, useEffect, ReactNode } from "react";
import { loginUser } from "../feature/Authentification/service/ConnexionService.ts";
import USER_LOGIN from "../type/USER_LOGIN.ts"; // Utilisez USER_LOGIN à la place de USER_CONNECTION
import AUTH_CONTEXT_TYPE from "../type/AUTH_CONTEXT_TYPE.ts";
import Cookies from "universal-cookie";
import CONNECTION_RESPONSE_LOGIN from "../type/CONNEXION_RESPONSE_LOGIN.ts";
import { useLocation } from "react-router-dom";

const cookies = new Cookies();

const defaultContextValue: AUTH_CONTEXT_TYPE = {
    isAuthenticated: false,
    login: async (): Promise<CONNECTION_RESPONSE_LOGIN> => {
        await Promise.resolve();
        return { message: "" };
    },
    // logout: async (): Promise<CONNECTION_RESPONSE_LOGIN> => {
    //     await Promise.resolve();
    //     return { message: "" };
    // },
    // checkDoubleAuth: async (): Promise<CONNECTION_RESPONSE_LOGIN> => {
    //     await Promise.resolve();
    //     return { message: "" };
    // },
};

const AUTH_CONTEXT = createContext<AUTH_CONTEXT_TYPE>(defaultContextValue);

export const AuthProvider = ({ children }: { children: ReactNode }) => {
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const location = useLocation();

    useEffect(() => {
        const result = async () => {
            try {
                console.log(cookies.get("token"));
                console.log(cookies.get("username"));

                if (cookies.get("token") && cookies.get("username")) {
                    setIsAuthenticated(true);
                }
                // const data = await checkIsLogin();
                // if (data.message) {
                //     setIsAuthenticated(true);
                // } else {
                //     setIsAuthenticated(false);
                //     // cookies.remove("token", { path: "/" });
                // }
            } catch (error) {
                setIsAuthenticated(false);
                // cookies.remove("token", { path: "/" });
                throw new Error("Error");
            }
        };
        result().then(r => r).catch((e: unknown) => e);
    }, [location.pathname]);

    const login = async (userData: USER_LOGIN): Promise<CONNECTION_RESPONSE_LOGIN> => {
        const data = await loginUser(userData);
        if (data.message !== "") {
            console.log(data);
            cookies.set("username", userData.username, { path: "/", secure: true, sameSite: "none" });
            cookies.set("token", data.message, { path: "/", secure: true, sameSite: "none" });
            setIsAuthenticated(true);
        }

        return data;
    };

    return (
        <AUTH_CONTEXT.Provider value={{ isAuthenticated, login }}>
            {children}
        </AUTH_CONTEXT.Provider>
    );
};

export const useAuth = () => useContext(AUTH_CONTEXT);
