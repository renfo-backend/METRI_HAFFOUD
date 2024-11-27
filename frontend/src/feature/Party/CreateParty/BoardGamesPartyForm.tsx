import { useState } from 'react';
import BoardGamesPartyEntityType from "../../../type/entity/BoardGamesPartyEntityType.ts";
import PartyEntityType from "../../../type/entity/PartyEntityType.ts";
import {createBoardGamesParty} from "./service/CreatePartyService.ts";

// Importez les interfaces correspondantes

const BoardGamesPartyForm = () => {
    // État global pour les informations de la soirée
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
    });

    // État spécifique aux soirées jeux de société
    const [boardGamesParty, setBoardGamesParty] = useState<BoardGamesPartyEntityType>({
        boardGames: [
            'Monopoly',
            'Risk',
            'Uno',
        ],
        participantsCanBringGames: true,
    });

    // Pour ajouter un jeu de société à la liste
    const [currentBoardGame, setCurrentBoardGame] = useState('');

    const handlePartyChange = (field: string, value: any) => {
        setParty((prev) => ({
            ...prev,
            [field]: value,
        }));
    };

    const handleBoardGamesPartyChange = (field: string, value: any) => {
        setBoardGamesParty((prev) => ({
            ...prev,
            [field]: value,
        }));
    };

    const handleAddBoardGame = () => {
        if (currentBoardGame.trim() !== '') {
            setBoardGamesParty((prev) => ({
                ...prev,
                boardGames: [...prev.boardGames, currentBoardGame],
            }));
            setCurrentBoardGame('');
        }
    };

    const handleSubmit = async () => {
        // Envoyer les données au backend
        console.log(party);
        console.log(boardGamesParty);
        await createBoardGamesParty(party, boardGamesParty);
        // Ici, vous pouvez envoyer `party` et `boardGamesParty` via une requête HTTP (par exemple, avec Axios)
    };

    return (
        <div className="flex flex-col items-center">
            <h1 className="text-2xl font-bold mb-6">Créer une Soirée Jeux de Société</h1>
            <input
                type="text"
                placeholder="Nom de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={party.name}
                onChange={(e) => handlePartyChange('name', e.target.value)}
            />
            <textarea
                placeholder="Description de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={party.description}
                onChange={(e) => handlePartyChange('description', e.target.value)}
            />
            <input
                type="text"
                placeholder="Adresse"
                className="mb-4 p-2 border rounded-md"
                value={party.address.street}
                onChange={(e) => handlePartyChange('address', {
                    ...party.address,
                    street: e.target.value,
                })}
            />
            {/*<input*/}
            {/*    type="text"*/}
            {/*    placeholder="Location"*/}
            {/*    className="mb-4 p-2 border rounded-md"*/}
            {/*    value={party.adress.location}*/}
            {/*    onChange={(e) => handlePartyChange('a', {*/}
            {/*        ...party.adress,*/}
            {/*        location: e.target.value,*/}
            {/*    })}*/}
            {/*/>*/}
            <input
                type="date"
                placeholder="Date de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={party.dateParty}
                onChange={(e) => handlePartyChange('dateParty', e.target.value)}
            />
            <input
                type="number"
                placeholder="Capacité"
                className="mb-4 p-2 border rounded-md"
                value={party.capacity}
                onChange={(e) => handlePartyChange('capacity', parseInt(e.target.value))}
            />
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={party.isPaid}
                    onChange={() => handlePartyChange('isPaid', !party.isPaid)}
                />
                <span>Soirée payante</span>
            </label>
            {party.isPaid && (
                <input
                    type="number"
                    placeholder="Prix"
                    className="mb-4 p-2 border rounded-md"
                    value={party.price}
                    onChange={(e) => handlePartyChange('price', parseFloat(e.target.value))}
                />
            )}
            <div className="mb-4">
                <input
                    type="text"
                    placeholder="Nom des jeux de société"
                    className="p-2 border rounded-md"
                    value={currentBoardGame}
                    onChange={(e) => setCurrentBoardGame(e.target.value)}
                />
                <button
                    onClick={handleAddBoardGame}
                    className="ml-2 bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700"
                >
                    Ajouter
                </button>
            </div>
            {boardGamesParty.boardGames.length > 0 && (
                <ul className="mb-4">
                    {boardGamesParty.boardGames.map((game, index) => (
                        <li key={index} className="text-gray-700">{game}</li>
                    ))}
                </ul>
            )}
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={boardGamesParty.participantsCanBringGames}
                    onChange={() => handleBoardGamesPartyChange('participantsCanBringGames', !boardGamesParty.participantsCanBringGames)}
                />
                <span>Les participants peuvent apporter des jeux</span>
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

export default BoardGamesPartyForm;
