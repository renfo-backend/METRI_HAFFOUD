import PartyEntityType from "../../../../type/entity/PartyEntityType.ts";
import BoardGamesPartyEntityType from "../../../../type/entity/BoardGamesPartyEntityType.ts";
import USER_LOGIN from "../../../../type/USER_LOGIN.ts";
import CONNEXION_RESPONSE_LOGIN from "../../../../type/CONNEXION_RESPONSE_LOGIN.ts";
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
export const createBoardGamesParty = async (party: PartyEntityType, boardGamesDetails: BoardGamesPartyEntityType) => {
    // Construire l'objet que le backend attend
    const boardGamesPartyRequest = {
        party,
        boardGamesDetails
    };

    // Afficher le token pour vérification
    console.log("Token utilisé :", cookies.get("token"));

    // Effectuer la requête avec Axios
    try {
        const response = await axios.post<CONNEXION_RESPONSE>(
            "http://localhost:8080/party/addParty/boardgame",
            boardGamesPartyRequest,
            config
        );

        console.log("Creating board games party");
        console.log("Détails de la soirée:", party);
        console.log("Détails de jeux de société:", boardGamesDetails);

        // Retourner la réponse
        return response.data as CONNEXION_RESPONSE_LOGIN;
    } catch (error) {
        console.error("Erreur lors de la création de la soirée : ", error);
        throw error;
    }
};


