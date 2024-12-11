import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import EmployeeService from '../services/EmployeeService';

function UpdateEmployeeComponent() {
  const navigate = useNavigate();
  const { id } = useParams();

  const [employee, setEmployee] = useState({
    firstName: "",
    lastName: "",
    email: ""
  });

  useEffect(() => {
    EmployeeService.getEmployeeById(id).then((res) => {
      setEmployee(res.data);
    });
  }, [id]);

  const updateHandler = (e) => {
    e.preventDefault();
    EmployeeService.updateEmployee(id, employee).then(() => {
      navigate("/employees");
    });
  };

  const cancelHandle = (e) => {
    e.preventDefault();
    navigate("/employees");
  };

  return (
    <div className="container">
      <div className="row mt-2">
        <div className="col-6 offset-md-3">
          <div className="card p-5">
            <h4 className="text-center">Update Employee</h4>
            <form>
              <div className="form-group">
                <label className="my-3">First Name:</label>
                <input
                  type="text"
                  name="firstName"
                  className="form-control"
                  value={employee.firstName}
                  onChange={(e) => setEmployee({ ...employee, firstName: e.target.value })}
                />

                <label className="my-3">Last Name:</label>
                <input
                  type="text"
                  name="lastName"
                  className="form-control"
                  value={employee.lastName}
                  onChange={(e) => setEmployee({ ...employee, lastName: e.target.value })}
                />

                <label className="my-3">Email:</label>
                <input
                  type="email"
                  name="email"
                  className="form-control"
                  value={employee.email}
                  onChange={(e) => setEmployee({ ...employee, email: e.target.value })}
                />

                <button className="mt-3 btn btn-danger" onClick={cancelHandle}>Cancel</button>
                <button className="mt-3 btn btn-success ms-3" onClick={updateHandler}>Save</button>
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>
  );
}

export default UpdateEmployeeComponent;
