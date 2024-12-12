import { useState } from "react";
import LANPartyEntityType from "../../../type/entity/LANPartyEntityType.ts";
import PartyEntityType from "../../../type/entity/PartyEntityType.ts";
import {createLANParty} from "./service/CreatePartyService.ts";

// Importez le service de création

const LANPartyForm = () => {
    // État pour les informations générales de la soirée
    const [party, setParty] = useState<PartyEntityType>({
        id: 0,
        name: 'PArty',
        description: 'nul ',
        address: {
            id: 0,
            street: '3 rue ',
            location: 'Paris ',
        },
        dateParty: '15/03/2002',
        capacity: 20,
        isPaid: false,
        price: 60,
        isPublished: false,
        organizer: {
            id: 0,
            username: "Organisateur",
        },
        participants: [],
        partyType: {
            id: 0,
            name: "Soiré LAN",
            description: "Soirée LAN",
        },
    });

    // État pour les informations spécifiques à la LAN Party
    const [lanParty, setLanParty] = useState<LANPartyEntityType>({
        videoGames: [
            'League of Legends',
            'Counter Strike',
            'Valorant',],
        platforms: [
            'PC',
            'Console',
        ],
        participantsCanSuggestGames: false,
    });

    const [currentVideoGame, setCurrentVideoGame] = useState("");
    const [currentPlatform, setCurrentPlatform] = useState("");

    // Gestion des changements dans les informations générales de la soirée
    const handlePartyChange = (field: string, value: any) => {
        setParty((prev) => ({
            ...prev,
            [field]: value,
        }));
    };

    // Gestion des changements dans les informations spécifiques à la LAN Party
    const handleLanPartyChange = (field: string, value: any) => {
        setLanParty((prev) => ({
            ...prev,
            [field]: value,
        }));
    };

    const handleAddVideoGame = () => {
        if (currentVideoGame.trim() !== "") {
            setLanParty((prev) => ({
                ...prev,
                videoGames: [...prev.videoGames, currentVideoGame],
            }));
            setCurrentVideoGame("");
        }
    };

    const handleAddPlatform = () => {
        if (currentPlatform.trim() !== "") {
            setLanParty((prev) => ({
                ...prev,
                platforms: [...prev.platforms, currentPlatform],
            }));
            setCurrentPlatform("");
        }
    };

    const handleSubmit = async () => {
        console.log(party);
        console.log(lanParty);

        console.log("Création de la soirée");
        // Envoyer les données au backend
        await createLANParty(party, lanParty);
    };

    return (
        <div className="flex flex-col items-center">
            <h1 className="text-2xl font-bold mb-6">Créer une LAN Party</h1>
            <input
                type="text"
                placeholder="Nom de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={party.name}
                onChange={(e) => handlePartyChange("name", e.target.value)}
            />
            <textarea
                placeholder="Description de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={party.description}
                onChange={(e) => handlePartyChange("description", e.target.value)}
            />
            <input
                type="text"
                placeholder="Adresse"
                className="mb-4 p-2 border rounded-md"
                value={party.address.street}
                onChange={(e) =>
                    handlePartyChange("address", {
                        ...party.address,
                        street: e.target.value,
                    })
                }
            />
            <input
                type="date"
                placeholder="Date de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={party.dateParty}
                onChange={(e) => handlePartyChange("dateParty", e.target.value)}
            />
            <input
                type="number"
                placeholder="Capacité"
                className="mb-4 p-2 border rounded-md"
                value={party.capacity}
                onChange={(e) => handlePartyChange("capacity", parseInt(e.target.value))}
            />
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={party.isPaid}
                    onChange={() => handlePartyChange("isPaid", !party.isPaid)}
                />
                <span>Soirée payante</span>
            </label>
            {party.isPaid && (
                <input
                    type="number"
                    placeholder="Prix"
                    className="mb-4 p-2 border rounded-md"
                    value={party.price}
                    onChange={(e) => handlePartyChange("price", parseFloat(e.target.value))}
                />
            )}
            <div className="mb-4">
                <input
                    type="text"
                    placeholder="Nom des jeux vidéo"
                    className="p-2 border rounded-md"
                    value={currentVideoGame}
                    onChange={(e) => setCurrentVideoGame(e.target.value)}
                />
                <button
                    onClick={handleAddVideoGame}
                    className="ml-2 bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700"
                >
                    Ajouter
                </button>
            </div>
            {lanParty.videoGames.length > 0 && (
                <ul className="mb-4">
                    {lanParty.videoGames.map((game, index) => (
                        <li key={index} className="text-gray-700">
                            {game}
                        </li>
                    ))}
                </ul>
            )}
            <div className="mb-4">
                <input
                    type="text"
                    placeholder="Plateformes (PC, Console)"
                    className="p-2 border rounded-md"
                    value={currentPlatform}
                    onChange={(e) => setCurrentPlatform(e.target.value)}
                />
                <button
                    onClick={handleAddPlatform}
                    className="ml-2 bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700"
                >
                    Ajouter
                </button>
            </div>
            {lanParty.platforms.length > 0 && (
                <ul className="mb-4">
                    {lanParty.platforms.map((platform, index) => (
                        <li key={index} className="text-gray-700">
                            {platform}
                        </li>
                    ))}
                </ul>
            )}
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={lanParty.participantsCanSuggestGames}
                    onChange={() =>
                        handleLanPartyChange(
                            "participantsCanSuggestGames",
                            !lanParty.participantsCanSuggestGames
                        )
                    }
                />
                <span>Les participants peuvent proposer des jeux</span>
            </label>
            <button
                onClick={handleSubmit}
                className="bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700"
            >
                Créer Soirée
            </button>
        </div>
    );
};

export default LANPartyForm;
