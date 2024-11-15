import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import ConnectionPage from './feature/Authentification/Connexion';
import {AuthProvider} from "./providers/AuthProvider.tsx";

function App() {
    return (
        <Router>
            <AuthProvider>
                <Routes>
                    <Route path="/" element={<ConnectionPage />} />
                </Routes>
            </AuthProvider>
        </Router>
    );
}

export default App;
