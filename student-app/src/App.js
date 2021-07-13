import { BrowserRouter as Router, Route } from "react-router-dom";
import Header from "./components/Header/Header";
import Create from "./containers/CreateProfilePage/CreateProfilePage";
import Login from "./containers/LoginPage/loginPage";
import Profile from "./containers/ProfilePage/ProfilePage";
import Results from "./containers/ResultsPage/ResultsPage";
import Update from "./containers/UpdateProfilePage/UpdateProfilePage";
import { QueryClient, QueryClientProvider } from "react-query";
const queryClient = new QueryClient();

function App() {
  return (
    <div className="App">


      <div>
      <QueryClientProvider client={queryClient}> 
        <Router>
        <Header />
          <Route exact path="/" component={Login} />
          <Route exact path="/Create" component={Create} />
          <Route exact path="/Profile" component={Profile} />
          <Route exact path="/Results" component={Results} />
          <Route exact path="/Update" component={Update} />
        </Router>
        </QueryClientProvider>
      </div>
    </div>
  );
}

export default App;
