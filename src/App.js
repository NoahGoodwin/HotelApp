import './App.css';
import React from "react";
import ReactDOM from "react-dom";
import LoginPage from './LoginPage/Login.js';
import { BrowserRouter as Switch, Route, Router } from 'react-router-dom';
import AdminPage from './AdminPage/Admin';

function App() {
  return (

    <>
      <Switch>

        <Route exact path="/" component={LoginPage} />
        <Route exact path="/admin" component={AdminPage} />

      </Switch>
    </>

  );
}


export default App;
