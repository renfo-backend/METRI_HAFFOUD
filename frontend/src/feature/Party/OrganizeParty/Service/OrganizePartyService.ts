import PartyEntityType from "../../../../type/entity/PartyEntityType.ts";
import axios from "axios";
import Cookies from "universal-cookie";

const cookies = new Cookies()
const token = cookies.get("token");


const config = {
    headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    },
    withCredentials: true
}
export const getAllParties = async () => {
    try {
        const response = await axios.get("http://localhost:8080/party/getPartyByOrganizer", config);
        console.log(response.data);
        return response.data as PartyEntityType[];
    } catch (error) {
        console.error("Erreur lors de la récupération des soirées : ", error);
        throw error;
    }
}