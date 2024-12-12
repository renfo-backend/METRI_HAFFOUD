import { useEffect, useState } from "react";
import Navbar from "../../../components/Navbar.tsx";
import JoinPartyModal from "./ModalJoinParty.tsx";
import { getParticipationRequestInvite, createRequestParty } from "./service/JoinPartyService.ts";
import RequestsPartyEntityType from "../../../type/entity/RequestsPartyEntityType.ts";
import {getAllPartyTypes} from "../OrganizeParty/Service/OrganizePartyService.ts";
import FilterParties from "../../../type/entity/FilterParties.ts";

const JoinParty = () => {
    const [parties, setParties] = useState([]);
    const [openModal, setOpenModal] = useState(false);
    const [idParty, setIdParty] = useState(0);
    const [requests, setRequests] = useState<RequestsPartyEntityType[]>([]);
    const [action, setAction] = useState(0);

    // Filtres
    const [filters, setFilters] = useState<FilterParties>({
        capacity: 0,
        location: "",
        partyType: "",
        isPaid: false,
        dateParty: "",
    });

    useEffect(() => {
        const fetchRequests = async () => {
            const participationRequests = await getParticipationRequestInvite();
            setRequests(participationRequests);

            // Charger les soirées initiales avec les filtres
            const partiesData = await getAllPartyTypes(filters);
            setParties(partiesData);
        };
        fetchRequests();
    }, [action]);

    const handleConfirm = async () => {
        console.log("Invitation envoyée !");
        await createRequestParty(idParty);
        setRequests(await getParticipationRequestInvite()); // Rafraîchit les demandes après l'envoi
        setAction(action + 1);
    };

    const getRequestStatus = (partyId) => {
        const request = requests.find((r) => r.party?.id === partyId);
        return request ? request.status : null; // Retourne le statut de la demande ou null si aucune demande
    };

    const applyFilters = async () => {
        const filteredParties = await getAllPartyTypes(filters);
        setParties(filteredParties);
    };

    return (
        <>
            <Navbar />
            {/* Barre de filtre */}
            <div className="bg-gray-100 p-4 rounded-lg shadow-md mb-6">
                <h3 className="text-lg font-semibold mb-4">Filtrer les soirées</h3>
                <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-4">
                    <div>
                        <label className="block text-sm font-medium text-gray-700">Capacité minimale</label>
                        <input
                            type="number"
                            className="w-full p-2 border border-gray-300 rounded-lg"
                            value={filters.capacity}
                            onChange={(e) => setFilters({ ...filters, capacity: Number(e.target.value) })}
                        />
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700">Localisation</label>
                        <input
                            type="text"
                            className="w-full p-2 border border-gray-300 rounded-lg"
                            value={filters.location}
                            onChange={(e) => setFilters({ ...filters, location: e.target.value })}
                        />
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700">Type de soirée</label>
                        <input
                            type="text"
                            className="w-full p-2 border border-gray-300 rounded-lg"
                            value={filters.partyType}
                            onChange={(e) => setFilters({ ...filters, partyType: e.target.value })}
                        />
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700">Payant</label>
                        <select
                            className="w-full p-2 border border-gray-300 rounded-lg"
                            value={filters.isPaid||"false"}
                            onChange={(e) => setFilters({ ...filters, isPaid: e.target.value === "true" })}
                        >
                            <option value="false">Non</option>
                            <option value="true">Oui</option>
                        </select>
                    </div>
                    <div>
                        <label className="block text-sm font-medium text-gray-700">Date de la soirée</label>
                        <input
                            type="date"
                            className="w-full p-2 border border-gray-300 rounded-lg"
                            value={filters.dateParty}
                            onChange={(e) => setFilters({ ...filters, dateParty: e.target.value })}
                        />
                    </div>
                </div>
                <div className="mt-4">
                    <button
                        onClick={applyFilters}
                        className="px-4 py-2 bg-blue-600 text-white rounded-md hover:bg-blue-700 transition"
                    >
                        Appliquer les filtres
                    </button>
                </div>
            </div>

            {/* Liste des soirées */}
            <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
                {parties.map((party) => {
                    const status = getRequestStatus(party.id);

                    return (
                        <div
                            key={party.id}
                            className="bg-white shadow-lg rounded-lg p-6 hover:shadow-xl transition-shadow"
                        >
                            <h2 className="text-xl font-bold text-purple-600 mb-2">{party.name}</h2>
                            <p className="text-gray-700 mb-2">{party.description}</p>
                            <p className="text-gray-600 text-sm mb-4">
                                <span className="font-semibold">Type :</span> {party.partyType.name}
                            </p>
                            <p className="text-gray-600 text-sm mb-4">
                                <span className="font-semibold">Adresse :</span> {party?.address?.street},{" "}
                                {party?.address?.location}
                            </p>
                            <p className="text-gray-600 text-sm mb-4">
                                <span className="font-semibold">Date :</span>{" "}
                                {new Date(party.dateParty).toLocaleDateString()}
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
                                        party.published
                                            ? "bg-green-200 text-green-800"
                                            : "bg-yellow-200 text-yellow-800"
                                    }`}
                                >
                                    {party.published ? "Publié" : "Non Publié"}
                                </span>
                            </div>
                            <div className="mt-4 flex items-center justify-between space-x-4">
                                {status === "ACCEPTED" && (
                                    <span className="px-4 py-2 bg-green-200 text-green-800 rounded-md">
                                        Accepté
                                    </span>
                                )}
                                {status === "REJECTED" && (
                                    <span className="px-4 py-2 bg-red-200 text-red-800 rounded-md">
                                        Refusé
                                    </span>
                                )}
                                {status === "PENDING" && (
                                    <span className="px-4 py-2 bg-yellow-200 text-yellow-800 rounded-md">
                                        EN ATTENTE
                                    </span>
                                )}
                                {!status && (
                                    <button
                                        className="bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700 transition"
                                        onClick={() => {
                                            setIdParty(party.id);
                                            setOpenModal(true);
                                        }}
                                    >
                                        Envoyer une invitation
                                    </button>
                                )}
                            </div>
                        </div>
                    );
                })}
                {openModal && (
                    <JoinPartyModal
                        isOpen={openModal}
                        setIsOpen={setOpenModal}
                        onConfirm={handleConfirm}
                    />
                )}
            </div>
        </>
    );
};

export default JoinParty;
