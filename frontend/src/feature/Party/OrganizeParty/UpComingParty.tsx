import { useEffect, useState } from "react";
import { getUpcomingParties} from "./Service/OrganizePartyService.ts";
import Navbar from "../../../components/Navbar";

const UpcomingEvents = () => {
    const [parties, setParties] = useState<PartyEntityType[]>([]);
    const [loading, setLoading] = useState(true);

    useEffect(() => {
        const fetchUpcoming = async () => {
            try {
                const data = await getUpcomingParties();
                setParties(data);
            } catch (error) {
                console.error("Erreur lors de la récupération des soirées à venir :", error);
            } finally {
                setLoading(false);
            }
        };
        fetchUpcoming();
    }, []);

    if (loading) {
        return <div>Chargement des événements à venir...</div>;
    }

    return (
        <>
            <Navbar />
            <div className="container mx-auto p-8">
                <h1 className="text-3xl font-bold text-center mb-8">
                    Mes Événements à Venir
                </h1>
                {parties.length === 0 ? (
                    <p className="text-center">Aucun événement à venir trouvé.</p>
                ) : (
                    <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                        {parties.map((party) => (
                            <div
                                key={party.id}
                                className="bg-white shadow-lg rounded-lg p-6 hover:shadow-xl transition-shadow"
                            >
                                <h2 className="text-xl font-bold text-purple-600 mb-2">
                                    {party.name}
                                </h2>
                                <p className="text-gray-700 mb-2">{party.description}</p>
                                <p className="text-gray-600 text-sm mb-4">
                                    <span className="font-semibold">Type :</span> {party.partyType.name}
                                </p>
                                <p className="text-gray-600 text-sm mb-4">
                                    <span className="font-semibold">Adresse :</span> {party?.address?.street}, {party?.address?.location}
                                </p>
                                <p className="text-gray-600 text-sm mb-4">
                                    <span className="font-semibold">Date :</span> {new Date(party.dateParty).toLocaleDateString()}
                                </p>
                                <p className="text-gray-600 text-sm mb-4">
                                    <span className="font-semibold">Capacité :</span> {party.capacity} participants
                                </p>
                                {party.isPaid && (
                                    <p className="text-gray-600 text-sm mb-4">
                                        <span className="font-semibold">Prix :</span> {party.price}€
                                    </p>
                                )}
                                <div className="mt-4 flex items-center justify-between">
                  <span
                      className={`px-3 py-1 rounded-full text-sm font-semibold ${
                          party.isPublished
                              ? "bg-green-200 text-green-800"
                              : "bg-yellow-200 text-yellow-800"
                      }`}
                  >
                    {party.isPublished ? "Publié" : "Non Publié"}
                  </span>
                                </div>
                            </div>
                        ))}
                    </div>
                )}
            </div>
        </>
    );
};

export default UpcomingEvents;
