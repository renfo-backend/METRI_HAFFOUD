import Cookies from "universal-cookie";
import axios from "axios";
import PartyEntityType from "../../../../type/entity/PartyEntityType.ts";
import RequestsPartyEntityType from "../../../../type/entity/RequestsPartyEntityType.ts";

const cookies = new Cookies()
const token = cookies.get("token");


const config = {
    headers: {
        "Content-Type": "application/json",
        "Authorization": `Bearer ${token}`
    },
    withCredentials: true
}

export const createRequestParty = async (idParty:number) => {
    try {
        const response = await axios.post(
            "http://localhost:8080/participationRequest/createParticipationRequest",
            null, // Aucun corps n'est envoyé
            {
                ...config,
                params: { idParty }, // Envoyer le paramètre idParty ici
            }
        );
        console.log(response.data);
        return response.data ;
    } catch (error) {
        console.error("Erreur lors de la récupération des soirées : ", error);
        throw error;
    }
}

export const getParticipationRequestInvite = async () => {
    try {
        const response = await axios.get("http://localhost:8080/participationRequest/getParticipationRequestInvite", config);
        console.log(response.data);
        return response.data as RequestsPartyEntityType[];
    } catch (error) {
        console.error("Erreur lors de la récupération des soirées : ", error);
        throw error;
    }
}