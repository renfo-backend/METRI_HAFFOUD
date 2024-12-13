import { useState } from "react";
import ClassicPartyEntityType from "../../../type/entity/ClassicPartyEntityType.ts";
import PartyEntityType from "../../../type/entity/PartyEntityType.ts";
import {createClassicParty} from "./service/CreatePartyService.ts";

const ClassicPartyForm = () => {
    // État pour les informations générales de la soirée
    const [party, setParty] = useState<PartyEntityType>({
        id: 0,
        name: "Nom de la soirée",
        description: "Description de la soirée",
        address: {
            id: 0,
            street: "Rue de la soirée",
            location: "Ville",
        },
        dateParty: "2024-12-15",
        capacity: 50,
        isPaid: false,
        price: 0,
        isPublished: false,
        organizer: {
            id: 0,
            username: "Organisateur",
        },
        participants: [],
        partyType: {
            id: 0,
            name: "Soirée Classique",
            description: "Soirée Classique",
        },
    });

    // État pour les informations spécifiques à la Soirée Classique
    const [classicParty, setClassicParty] = useState<ClassicPartyEntityType>({
        hasMusic: false,
        musicType: "",
    });

    // Gestion des changements dans les informations générales de la soirée
    const handlePartyChange = (field: string, value: any) => {
        setParty((prev) => ({
            ...prev,
            [field]: value,
        }));
    };

    // Gestion des changements dans les informations spécifiques à la Soirée Classique
    const handleClassicPartyChange = (field: string, value: any) => {
        setClassicParty((prev) => ({
            ...prev,
            [field]: value,
        }));
    };

    const handleSubmit = async () => {
        console.log(party);
        console.log(classicParty);
        console.log("Création de la soirée classique");
        await createClassicParty(party, classicParty);
    };

    return (
        <div className="flex flex-col items-center">
            <h1 className="text-2xl font-bold mb-6">Créer une Soirée Classique</h1>
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
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={classicParty.hasMusic}
                    onChange={() =>
                        handleClassicPartyChange("hasMusic", !classicParty.hasMusic)
                    }
                />
                <span>Présence de musique</span>
            </label>
            {classicParty.hasMusic && (
                <input
                    type="text"
                    placeholder="Type de musique (optionnel)"
                    className="mb-4 p-2 border rounded-md"
                    value={classicParty.musicType}
                    onChange={(e) =>
                        handleClassicPartyChange("musicType", e.target.value)
                    }
                />
            )}
            <button
                onClick={handleSubmit}
                className="bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700"
            >
                Créer Soirée
            </button>
        </div>
    );
};

export default ClassicPartyForm;
