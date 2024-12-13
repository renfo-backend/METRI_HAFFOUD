
const JoinPartyModal = ({ isOpen, setIsOpen, onConfirm }) => {
    if (!isOpen) return null;

    return (
        <div className="fixed inset-0 z-50 flex items-center justify-center bg-black bg-opacity-50">
            <div className="bg-white rounded-lg shadow-lg w-11/12 max-w-md">
                <div className="px-6 py-4 border-b flex justify-between items-center">
                    <h3 className="text-lg font-semibold text-gray-900">
                        Rejoindre une soirée
                    </h3>
                    <button
                        onClick={() => setIsOpen(false)}
                        className="text-gray-400 hover:text-gray-600"
                    >
                        ×
                    </button>
                </div>
                <div className="px-6 py-4">
                    <p className="text-gray-700">
                        Vous voulez envoyer une invitation pour rejoindre la soirée ?
                    </p>
                </div>
                <div className="px-6 py-4 flex justify-end space-x-4 border-t">
                    <button
                        onClick={() => setIsOpen(false)}
                        className="px-4 py-2 bg-gray-200 text-gray-700 rounded hover:bg-gray-300"
                    >
                        Non
                    </button>
                    <button
                        onClick={() => {
                            onConfirm();
                            setIsOpen(false);
                        }}
                        className="px-4 py-2 bg-blue-600 text-white rounded hover:bg-blue-700"
                    >
                        Oui
                    </button>
                </div>
            </div>
        </div>
    );
};

export default JoinPartyModal;
