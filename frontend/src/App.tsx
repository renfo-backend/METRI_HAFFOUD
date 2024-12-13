import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ConnectionPage from './feature/Authentification/Connexion';
import {AuthProvider} from "./providers/AuthProvider.tsx";
import AccueilPage from "./feature/Accueil.tsx";
import CreateParty from "./feature/Party/CreateParty/CreateParty.tsx";
import OrganizeParty from "./feature/Party/OrganizeParty/OrganizeParty.tsx";
import JoinParty from "./feature/Party/JoinParty/JoinParty.tsx";
import EditParty from "./feature/Party/OrganizeParty/EditParty.tsx";
import UpComingParty from "./feature/Party/OrganizeParty/UpComingParty.tsx";

function App() {
    return (
        <Router>
            <AuthProvider>
                <Routes>
                    <Route path="/connexion" element={<ConnectionPage />} />
                    <Route path="/" element={<AccueilPage />} />
                    <Route path="/create-party" element={<CreateParty />} />
                    <Route path="/my-parties" element={<OrganizeParty/>} />
                    <Route path="/join-party" element={<JoinParty/>} />
                    <Route path="/edit-party/:id" element={<EditParty />} />
                    <Route path="/upcoming" element={<UpComingParty />} />
                </Routes>
            </AuthProvider>
        </Router>
    );
}

export default App;
