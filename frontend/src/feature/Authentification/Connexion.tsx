import CustomInput from "../../components/CustomInput.tsx";
import CustomLabelForm from "../../components/CustomLabelForm.tsx";
import CustomButton from "../../components/CustomButton.tsx";
import { ChangeEvent, FormEvent, useState } from "react";
import { useNavigate } from "react-router-dom";
import USER_LOGIN from "../../type/USER_LOGIN.ts";
import {loginUser} from "./service/ConnexionService.ts";
import {useAuth} from "../../providers/AuthProvider.tsx";

const ConnectionPage = () => {
    const [formData, setFormData] = useState<USER_LOGIN>({ username: "LeYass", password: "ss123" })
    const [error, setError] = useState("")
    const [success, setSuccess] = useState("")
    const { login,isAuthenticated } = useAuth()
    const navigate = useNavigate();

    const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
        setFormData({ ...formData, [e.target.name]: e.target.value })
    }


    console.log(useAuth().isAuthenticated);



    const handleSubmit = async (e: FormEvent<HTMLFormElement>) => {
        e.preventDefault();
        setError("");
        setSuccess("");


        // Logique de soumission simulée
        try {
            const response =await login(formData);
            console.log(response);

            // console.log("response", response);

            // const response = { message: "success" }; // Remplacez par un vrai appel API si nécessaire
            // if (response.message === "2FA") {
                // navigate("/double-auth");
        //     } else if (response.message) {
        //         setSuccess("Successful connection. You are now connected");
        //         setTimeout(() => {
        //             location.href = "/";
        //         }, 2000);
        //     } else {
        //         setError("Username or password incorrect");
        //     }
        }
        catch (err: unknown) {
            const errorMessage = "Error connecting";
            setError(errorMessage);
        }
    }

    if (isAuthenticated) {
        navigate("/cc");
    }

    return (
        <div className="flex items-center justify-center h-screen w-screen">
            <form className="bg-white shadow-md rounded px-8 pt-6 pb-8" onSubmit={handleSubmit}>
                <h1 className="font-bold flex justify-center">Login</h1>
                <div className="my-2">
                    <CustomLabelForm htmlFor="username">Username</CustomLabelForm>
                    <CustomInput disabled={false} id="username" type="text" name="username" value={formData.username} onChange={handleChange} placeholder="Username" />
                </div>
                <div className="my-2">
                    <CustomLabelForm htmlFor="password">Password</CustomLabelForm>
                    <CustomInput disabled={false} id="password" type="password" name="password" value={formData.password} onChange={handleChange} placeholder="Password" />
                </div>

                {error && <p style={{ color: "red" }}>{error}</p>}
                {success && <p style={{ color: "green" }}>{success}</p>}
                <div className="my-2">
                    <CustomButton value="Sign in" type="submit" />
                </div>
            </form>
        </div>
    )

}

export default ConnectionPage;
