import { useEffect, useState } from "react";
import {changePartyStatus, deleteParty, getAllParties, getRequestsByUser} from "./Service/OrganizePartyService.ts";
import ModalRequests from "./ModalRequest.tsx";
import Navbar from "../../../components/Navbar.tsx";
import {useNavigate} from "react-router-dom";

const OrganizeParty = () => {
    const [parties, setParties] = useState([]);
    const [requests, setRequests] = useState([]);
    const [openModal, setOpenModal] = useState(false);
    const navigate = useNavigate();

    useEffect(() => {
        const fetchPartiesAndRequests = async () => {
            const partiesData = await getAllParties();
            setParties(partiesData);
        };

        fetchPartiesAndRequests();
    }, []);

    const handleAccept = async (requestId:number) => {
        await changePartyStatus(requestId, "ACCEPTED");
        setOpenModal(false);
    };

    const handleReject = async (requestId:number) => {
        await changePartyStatus(requestId, "REJECTED");
        setOpenModal(false);
    };

    const handleDeleteParty = async (partyId: number) => {
        console.log("deleteParty")
        try {
            await deleteParty(partyId);
            // Après suppression, mettez à jour la liste des soirées en retirant la soirée supprimée
            setParties((prevParties) => prevParties.filter((party) => party.id !== partyId));
        } catch (error) {
            console.error("Erreur lors de la suppression de la soirée :", error);
        }
    };

    return (
        <>
            <Navbar/>
            <div className="container mx-auto p-8">
            <h1 className="text-3xl font-bold text-center mb-8">
                Mes Soirées Organisées
            </h1>
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
                            <span className="font-semibold">Type :</span>{" "}
                            {party.partyType.name}
                        </p>
                        <p className="text-gray-600 text-sm mb-4">
                            <span className="font-semibold">Adresse :</span>{" "}
                            {party?.address?.street}, {party?.address?.location}
                        </p>
                        <p className="text-gray-600 text-sm mb-4">
                            <span className="font-semibold">Date :</span>{" "}
                            {new Date(party.dateParty).toLocaleDateString()}
                        </p>
                        <p className="text-gray-600 text-sm mb-4">
                            <span className="font-semibold">Capacité :</span>{" "}
                            {party.capacity} participants
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
                        <div className="mt-4 flex items-center justify-between space-x-4">
                            <button
                                className="bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700 transition"
                                onClick={() => navigate(`/edit-party/${party.id}`)}
                            >
                                Modifier
                            </button>
                            <button
                                className="bg-purple-600 text-white px-4 py-2 rounded-md hover:bg-purple-700 transition"
                                onClick={() => handleDeleteParty(party.id)}
                            >
                                Supprimer
                            </button>
                            <button
                                className="bg-blue-600 text-white px-4 py-2 rounded-md hover:bg-blue-700 transition"
                                onClick={async () => {
                                    setOpenModal(true); // Ouvre le modal
                                    console.log(`Voir les demandes de la soirée ID: ${party.id}`);
                                    const requestsData = await getRequestsByUser(party?.id);
                                    setRequests(requestsData);
                                }}

                            >
                                Voir les demandes
                            </button>
                        </div>
                    </div>
                ))}
            </div>
                {openModal && (
                    <ModalRequests
                        isOpen={openModal}
                        setIsOpen={setOpenModal}
                        requests={requests}
                        onAccept={handleAccept}
                        onReject={handleReject}
                />
            )}
        </div>
        </>
    );
};

export default OrganizeParty;
