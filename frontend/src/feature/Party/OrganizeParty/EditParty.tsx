import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import { getPartyById, updateParty } from "./Service/OrganizePartyService.ts";

const EditParty = () => {
    const { id } = useParams();
    const navigate = useNavigate();
    const [party, setParty] = useState(null);

    useEffect(() => {
        console.log("id", id)
        const fetchParty = async () => {
            if (id) {
                console.log("ok")
                const partyData = await getPartyById(Number(id));
                console.log("partyData", partyData)
                setParty(partyData);
            }
        };
        fetchParty();
    }, [id]);

    const handleChange = (e) => {
        const { name, value } = e.target;
        setParty((prev) => ({ ...prev, [name]: value }));
    };

    const handleSubmit = async (e) => {
        e.preventDefault();
        await updateParty(Number(id), party);
        // Une fois la mise à jour réussie, retour à la liste
        navigate("/my-parties");
    };


    return (
        <div className="container mx-auto p-8">
            <h1 className="text-3xl font-bold text-center mb-8">Modifier la soirée</h1>
            {party ? (
                <form onSubmit={handleSubmit} className="max-w-md mx-auto space-y-4">
                    <div>
                        <label className="block mb-1" htmlFor="name">Nom</label>
                        <input
                            id="name"
                            name="name" // correspond à party.name
                            value={party.name || ""}
                            onChange={handleChange}
                            className="w-full border p-2 rounded"
                        />
                    </div>
                    <div>
                        <label className="block mb-1" htmlFor="dateParty">Date</label>
                        <input
                            id="dateParty"
                            name="dateParty" // correspond à party.dateParty
                            type="date"
                            value={party.dateParty || ""}
                            onChange={handleChange}
                            className="w-full border p-2 rounded"
                        />
                    </div>
                    <div>
                        <label className="block mb-1" htmlFor="capacity">Capacité</label>
                        <input
                            id="capacity"
                            name="capacity" // correspond à party.capacity
                            value={party.capacity || ""}
                            onChange={handleChange}
                            className="w-full border p-2 rounded"
                        />
                    </div>
                    <div>
                        <label className="block mb-1" htmlFor="street">Adresse</label>
                        <input
                            id="street"
                            name="address.street" // correspond à party.address.street
                            value={party.address?.street || ""}
                            onChange={handleChange}
                            className="w-full border p-2 rounded"
                        />
                    </div>
                    <button
                        type="submit"
                        className="bg-purple-600 text-white px-4 py-2 rounded hover:bg-purple-700"
                    >
                        Mettre à jour
                    </button>
                </form>
            ) : (
                <p>Chargement des données...</p>
            )}
        </div>
    );

};

export default EditParty;
