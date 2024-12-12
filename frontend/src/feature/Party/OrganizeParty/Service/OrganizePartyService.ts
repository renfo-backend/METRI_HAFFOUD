import PartyEntityType from "../../../../type/entity/PartyEntityType.ts";
import axios from "axios";
import Cookies from "universal-cookie";
import RequestsPartyEntityType from "../../../../type/entity/RequestsPartyEntityType.ts";
import {c} from "vite/dist/node/types.d-aGj9QkWt";
import FilterParties from "../../../../type/entity/FilterParties.ts";

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

export const getRequestsByUser = async (id:number) => {
    const config2 = {
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`,
        },
        params: { id },
        withCredentials: true
    };
    try {
        const response = await axios.get("http://localhost:8080/participationRequest/getParticipationRequest", config2);
        console.log(response.data);
        return response.data as RequestsPartyEntityType[];
    } catch (error) {
        console.error("Erreur lors de la récupération des demandes : ", error);
        throw error;
    }
}

export const changePartyStatus = async (id:number,status:string) => {
    try {
        const response = await axios.post<string>(
            "http://localhost:8080/participationRequest/changeStatusParticipationRequest",
            {id,status},
            config
        )
    }catch (error) {
        console.error("Erreur lors de la mise à jour du statut de la soirée : ", error);
        throw error;
    }
}

export const getAllPartyTypes = async (filter:FilterParties) => {
    const config2 = {
        headers: {
            "Content-Type": "application/json",
            "Authorization": `Bearer ${token}`,
        },
        params: filter,
        withCredentials: true
    };

    try {
        const response = await axios.get("http://localhost:8080/party/getAllPartiesWithFilter", config2);
        return response.data as PartyEntityType[];
    } catch (error) {
        console.error("Erreur lors de la récupération des types de soirées : ", error);
        throw error;
    }
}