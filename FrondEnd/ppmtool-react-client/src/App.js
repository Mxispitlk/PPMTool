import React from "react";
import "./App.css";
import Dashboard from "./components/Dashboard";
import "bootstrap/dist/css/bootstrap.min.css";
import { BrowserRouter as Router, Route } from "react-router-dom";
import AddProject from "./components/Project/AddProject";
import Header from "./components/Layout/Header";

function App() {
  return (
    <Router>
      <div className="App">
        <Header />

        <Route path="/dashboard" exact component={Dashboard} />
        <Route path="/addProject" exact component={AddProject} />
      </div>
    </Router>
  );
}

export default App;
