import { Link } from 'react-router-dom';
import { useAuth } from '../providers/AuthProvider.tsx';
import Cookies from "universal-cookie";
const cookies = new Cookies()

const Navbar = () => {
    const { isAuthenticated } = useAuth();

    return (
        <nav className="bg-purple-600 p-4 fixed top-0 w-full z-10">
            <div className="container mx-auto flex items-center justify-between">
                <div className="flex items-center">
                    <Link to="/" className="text-white text-2xl font-bold">
                        Soirée Optimisation
                    </Link>
                </div>

                <div className="hidden md:flex space-x-6">
                    <Link to="/" className="text-white hover:text-purple-200">
                        Accueil
                    </Link>
                    <Link to="/events" className="text-white hover:text-purple-200">
                        Événements à venir
                    </Link>
                    <Link to="/my-parties" className="text-white hover:text-purple-200">
                        Mes Soirées
                    </Link>
                    <Link to="/contact" className="text-white hover:text-purple-200">
                        Contact
                    </Link>
                    <Link to="/about" className="text-white hover:text-purple-200">
                        À propos
                    </Link>
                </div>

                <div className="hidden md:flex space-x-4">
                    {!isAuthenticated ? (
                        <>
                            <Link to="/connexion" className="bg-white text-purple-600 px-4 py-2 rounded-md hover:bg-purple-200">
                                Connexion
                            </Link>
                            <Link to="/register" className="bg-purple-800 text-white px-4 py-2 rounded-md hover:bg-purple-700">
                                S'inscrire
                            </Link>
                        </>
                    ) : (
                        <button onClick={() => cookies.remove("token")}>

                        <Link to="/connexion" className="bg-white text-purple-600 px-4 py-2 rounded-md hover:bg-purple-200">
                            Déconnexion
                        </Link>
                        </button>
                    )}
                </div>

                <div className="md:hidden">
                    <button id="mobile-menu-button" className="text-white focus:outline-none">
                        <svg xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" stroke="currentColor" className="w-8 h-8">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M4 6h16M4 12h16m-7 6h7" />
                        </svg>
                    </button>
                </div>
            </div>

            <div id="mobile-menu" className="hidden md:hidden mt-2">
                <Link to="/" className="block text-white hover:text-purple-200 p-2">
                    Accueil
                </Link>
                <Link to="/events" className="block text-white hover:text-purple-200 p-2">
                    Événements à venir
                </Link>
                <Link to="/my-parties" className="block text-white hover:text-purple-200 p-2">
                    Mes Soirées
                </Link>
                <Link to="/contact" className="block text-white hover:text-purple-200 p-2">
                    Contact
                </Link>
                <Link to="/about" className="block text-white hover:text-purple-200 p-2">
                    À propos
                </Link>
                <div className="mt-2 space-y-2">
                    {!isAuthenticated ? (
                        <>
                            <Link to="/connexion" className="block bg-white text-purple-600 px-4 py-2 rounded-md hover:bg-purple-200">
                                Connexion
                            </Link>
                            <Link to="/register" className="block bg-purple-800 text-white px-4 py-2 rounded-md hover:bg-purple-700">
                                S'inscrire
                            </Link>
                        </>
                    ) : (
                        <Link to="/connexion" className="block bg-white text-purple-600 px-4 py-2 rounded-md hover:bg-purple-200">
                            Déconnexion
                        </Link>
                    )}
                </div>
            </div>
        </nav>
    );
};

export default Navbar;
