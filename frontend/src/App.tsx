import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ConnectionPage from './feature/Authentification/Connexion';
import {AuthProvider} from "./providers/AuthProvider.tsx";
import AccueilPage from "./feature/Accueil.tsx";
import CreateParty from "./feature/Party/CreateParty/CreateParty.tsx";

function App() {
    return (
        <Router>
            <AuthProvider>
                <Routes>
                    <Route path="/connexion" element={<ConnectionPage />} />
                    <Route path="/" element={<AccueilPage />} />
                    <Route path="/create-party" element={<CreateParty />} />
                    <Route path="/join-party" element={<div>Join Party</div>} />
                </Routes>
            </AuthProvider>
        </Router>
    );
}

export default App;
