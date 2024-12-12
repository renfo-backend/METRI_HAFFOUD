import Navbar from "../../../components/Navbar.tsx";

const ModalRequests = ({ isOpen, setIsOpen, requests, onAccept, onReject }) => {
    return (
        <>
            {isOpen && (
                <div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
                    <div className="bg-white rounded-lg shadow-lg w-11/12 max-w-2xl">
                        <div className="flex items-center justify-between px-6 py-4 border-b">
                            <h3 className="text-lg font-semibold text-gray-900">
                                Demandes de Participation
                            </h3>
                            <button
                                onClick={() => setIsOpen(false)}
                                className="text-gray-400 hover:text-gray-600"
                            >
                                ×
                            </button>
                        </div>
                        <div className="px-6 py-4 max-h-96 overflow-y-auto">
                            {requests && requests.length === 0 ? (
                                <p className="text-gray-700">Aucune demande pour le moment.</p>
                            ) : (
                                <ul>
                                    {requests.map((request) => (
                                        <li
                                            key={request?.id}
                                            className="flex items-center justify-between px-4 py-2 mb-2 bg-gray-100 rounded-md shadow-sm"
                                        >
                                            <div>
                                                <p className="text-sm font-semibold text-gray-900">
                                                    {request?.users?.username}
                                                </p>
                                                <p className="text-sm text-gray-600">
                                                    Soirée : {request?.party.name}
                                                </p>
                                                {request?.status === "ACCEPTED" && (
                                                    <p className="text-sm font-semibold text-green-600">
                                                        Acceptée
                                                    </p>
                                                )}
                                                {request?.status === "REFUSED" && (
                                                    <p className="text-sm font-semibold text-red-600">
                                                        Refusée
                                                    </p>
                                                )}
                                            </div>
                                            {request?.status === "PENDING" && (
                                                <div className="flex space-x-2">
                                                    <button
                                                        onClick={() => onAccept(request?.id)}
                                                        className="px-4 py-2 text-sm text-white bg-green-600 rounded hover:bg-green-700"
                                                    >
                                                        Accepter
                                                    </button>
                                                    <button
                                                        onClick={() => onReject(request?.id)}
                                                        className="px-4 py-2 text-sm text-white bg-red-600 rounded hover:bg-red-700"
                                                    >
                                                        Refuser
                                                    </button>
                                                </div>
                                            )}
                                        </li>
                                    ))}
                                </ul>
                            )}
                        </div>
                        <div className="flex justify-end px-6 py-4 border-t">
                            <button
                                onClick={() => setIsOpen(false)}
                                className="px-4 py-2 text-gray-700 bg-gray-200 rounded hover:bg-gray-300"
                            >
                                Fermer
                            </button>
                        </div>
                    </div>
                </div>
            )}
        </>
    );
};

export default ModalRequests;
