import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import EmployeeListComponent from './components/EmployeeListComponent';
import HeaderComponent from './components/HeaderComponent';
import FooterComponent from './components/FooterComponent'; // Corrected typo and removed duplicate import
import CreateEmployeeComponent from './components/CreateEmployeeComponent';
import UpdateEmployeeComponent from './components/UpdateEmployeeComponent';

function App() {
  return (
    <div>
      <HeaderComponent />
      <BrowserRouter>
        <div className="container">
          <Routes>
            <Route exact path="/" element={<EmployeeListComponent />} />
            <Route path="/employees" element={<EmployeeListComponent />} />
            <Route path="/add-employee" element={<CreateEmployeeComponent />} />
            <Route path="/update-employee/:id" element={<UpdateEmployeeComponent />} />
          </Routes>
        </div>
      </BrowserRouter>
      <FooterComponent />
    </div>
  );
}

export default App;
