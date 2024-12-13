import { useState } from 'react';
import ClassicPartyForm from "./ClassicPartyForm.tsx";
import LANPartyForm from "./LANPartyForm.tsx";
import BoardGamesPartyForm from "./BoardGamesPartyForm.tsx";
import Navbar from "../../../components/Navbar.tsx";

const CreateParty = () => {
    const [partyType, setPartyType] = useState('');

    const handlePartyTypeChange = (type: string) => {
        setPartyType(type);
    };

    return (
        <>
        <Navbar/>

    <div className="flex items-center justify-center h-screen w-screen">
            <div className="flex flex-col items-center space-y-4 mb-8">
            <h1 className="text-3xl font-bold mb-8">Sélectionnez le type de soirée</h1>
                <button
                    onClick={() => handlePartyTypeChange('boardgames')}
                    className="bg-purple-600 text-white px-6 py-3 rounded-md hover:bg-purple-700"
                >
                    Soirée Jeux de Société
                </button>
                <button
                    onClick={() => handlePartyTypeChange('lan')}
                    className="bg-purple-600 text-white px-6 py-3 rounded-md hover:bg-purple-700"
                >
                    LAN Party
                </button>
                <button
                    onClick={() => handlePartyTypeChange('classic')}
                    className="bg-purple-600 text-white px-6 py-3 rounded-md hover:bg-purple-700"
                >
                    Soirée Classique
                </button>
            </div>

            {partyType === 'boardgames' && (
                <BoardGamesPartyForm/>
            )}

            {partyType === 'lan' && (
                <LANPartyForm/>
            )}

            {partyType === 'classic' && (
                <ClassicPartyForm/>
            )}
        </div>
        </>
    );
};

export default CreateParty;
