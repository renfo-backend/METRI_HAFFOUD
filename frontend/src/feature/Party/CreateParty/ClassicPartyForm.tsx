import { useState } from 'react';

const ClassicPartyForm = () => {
    const [name, setName] = useState('');
    const [address, setAddress] = useState('');
    const [dateParty, setDateParty] = useState('');
    const [capacity, setCapacity] = useState(0);
    const [isPaid, setIsPaid] = useState(false);
    const [price, setPrice] = useState(0);
    const [hasMusic, setHasMusic] = useState(false);
    const [musicType, setMusicType] = useState('');

    return (
        <div className="flex flex-col items-center">
            <h1 className="text-2xl font-bold mb-6">Créer une Soirée Classique</h1>
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
            <label className="flex items-center space-x-2 mb-4">
                <input
                    type="checkbox"
                    checked={hasMusic}
                    onChange={() => setHasMusic(!hasMusic)}
                />
                <span>Présence de musique</span>
            </label>
            {hasMusic && (
                <input
                    type="text"
                    placeholder="Type de musique (optionnel)"
                    className="mb-4 p-2 border rounded-md"
                    value={musicType}
                    onChange={(e) => setMusicType(e.target.value)}
                />
            )}
            <button className="bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700">
                Créer Soirée
            </button>
        </div>
    );
};

export default ClassicPartyForm;
