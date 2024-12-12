import Navbar from "../components/Navbar.tsx";
import { Link } from 'react-router-dom';

const AccueilPage = () => {

    return (
        <>
            <Navbar />
            <div className="flex flex-col items-center justify-center h-screen w-screen bg-gray-100">
                <h1 className="text-4xl font-bold text-center mb-4">Bienvenue sur Soirée Optimisation</h1>
                <p className="text-center mb-8">Le site pour organiser vos soirées entre amis</p>
                <div className="flex space-x-4">
                    <Link to="/join-party">
                        <button className="bg-purple-600 text-white px-6 py-3 rounded-md hover:bg-purple-700">
                            Rejoindre une soirée
                        </button>
                    </Link>
                    <Link to="/create-party">
                        <button className="bg-purple-800 text-white px-6 py-3 rounded-md hover:bg-purple-900">
                            Créer une soirée
                        </button>
                    </Link>
                </div>
            </div>
        </>
    );

}

export default AccueilPage;
