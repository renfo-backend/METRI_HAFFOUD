import PartyEntityType from "../../../../type/entity/PartyEntityType.ts";
import BoardGamesPartyEntityType from "../../../../type/entity/BoardGamesPartyEntityType.ts";
import CONNEXION_RESPONSE_LOGIN from "../../../../type/CONNEXION_RESPONSE_LOGIN.ts";
import axios from "axios";
import Cookies from "universal-cookie";
import LANPartyEntityType from "../../../../type/entity/LANPartyEntityType.ts";
import ClassicPartyEntityType from "../../../../type/entity/ClassicPartyEntityType.ts";
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
    const boardGamesPartyRequest = {
        party,
        boardGamesDetails
    };

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

export const createLANParty = async (party: PartyEntityType, lanDetails: LANPartyEntityType) => {
    const lanPartyRequest = {
        party,
        lanDetails
    };

    try {
        const response = await axios.post<CONNEXION_RESPONSE>(
            "http://localhost:8080/party/addParty/lan",
            lanPartyRequest,
            config
        );

        console.log("Creating LAN party");
        console.log("Détails de la soirée:", party);
        console.log("Détails de la LAN party:", lanDetails);

        // Retourner la réponse
        return response.data as CONNEXION_RESPONSE_LOGIN;
    } catch (error) {
        console.error("Erreur lors de la création de la soirée : ", error);
        throw error;
    }
}

export const createClassicParty = async (party: PartyEntityType, classicDetails: ClassicPartyEntityType) => {

    const classicPartyRequest = {
        party,
        classicDetails
    };

    try {
        const response = await axios.post<CONNEXION_RESPONSE>(
            "http://localhost:8080/party/addParty/classic",
            classicPartyRequest,
            config
        );

        console.log("Creating classic party");
        console.log("Détails de la soirée:", party);
        console.log("Détails de la soirée classique:", classicDetails);

        return response.data as CONNEXION_RESPONSE_LOGIN;
    } catch (error) {
        console.error("Erreur lors de la création de la soirée : ", error);
        throw error;
    }
}


