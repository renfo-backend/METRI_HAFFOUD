import { useState } from 'react';

const LANPartyForm = () => {
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [dateParty, setDateParty] = useState('');
    const [capacity, setCapacity] = useState(0);
    const [isPaid, setIsPaid] = useState(false);
    const [price, setPrice] = useState(0);
    const [videoGames, setVideoGames] = useState<string[]>([]);
    const [platforms, setPlatforms] = useState<string[]>([]);
    const [participantsCanSuggestGames, setParticipantsCanSuggestGames] = useState(false);
    const [currentVideoGame, setCurrentVideoGame] = useState('');
    const [currentPlatform, setCurrentPlatform] = useState('');

    const handleAddVideoGame = () => {
        if (currentVideoGame.trim() !== '') {
            setVideoGames([...videoGames, currentVideoGame]);
            setCurrentVideoGame('');
        }
    };

    const handleAddPlatform = () => {
        if (currentPlatform.trim() !== '') {
            setPlatforms([...platforms, currentPlatform]);
            setCurrentPlatform('');
        }
    };

    return (
        <div className="flex flex-col items-center">
            <h1 className="text-2xl font-bold mb-6">Créer une LAN Party</h1>
            <input
                type="text"
                placeholder="Nom de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={name}
                onChange={(e) => setName(e.target.value)}
            />
            <input
                type="text"
                placeholder="Adresse"
                className="mb-4 p-2 border rounded-md"
                value={address}
                onChange={(e) => setAddress(e.target.value)}
            />
            <input
                type="date"
                placeholder="Date de la soirée"
                className="mb-4 p-2 border rounded-md"
                value={dateParty}
                onChange={(e) => setDateParty(e.target.value)}
            />
            <input
                type="number"
                placeholder="Capacité"
                className="mb-4 p-2 border rounded-md"
                value={capacity}
                onChange={(e) => setCapacity(parseInt(e.target.value))}
            />
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={isPaid}
                    onChange={() => setIsPaid(!isPaid)}
                />
                <span>Soirée payante</span>
            </label>
            {isPaid && (
                <input
                    type="number"
                    placeholder="Prix"
                    className="mb-4 p-2 border rounded-md"
                    value={price}
                    onChange={(e) => setPrice(parseFloat(e.target.value))}
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
            {videoGames.length > 0 && (
                <ul className="mb-4">
                    {videoGames.map((game, index) => (
                        <li key={index} className="text-gray-700">{game}</li>
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
            {platforms.length > 0 && (
                <ul className="mb-4">
                    {platforms.map((platform, index) => (
                        <li key={index} className="text-gray-700">{platform}</li>
                    ))}
                </ul>
            )}
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={participantsCanSuggestGames}
                    onChange={() => setParticipantsCanSuggestGames(!participantsCanSuggestGames)}
                />
                <span>Les participants peuvent proposer des jeux</span>
            </label>
            <button className="bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700">
                Créer Soirée
            </button>
        </div>
    );
};

export default LANPartyForm;
