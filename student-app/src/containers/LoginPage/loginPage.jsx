import React from "react";
import { Link } from "react-router-dom";

const loginPage = () => {
  return (
    <main className="container" >
      <div className="row">
        <div className="col " style={{ textAlign: "center" }}>

          <div className="mb-3">
            <label
              htmlFor="login"
              className="form-label"
              style={{ marginTop: 20 }}
            >
              Click to Login
            </label>
            <div>
              <button
                //   onClick={() => {
                //     setCity("");
                //     setGenre("");
                //     setInstrument("");
                //     setEmail("");
                //   }}
                className="btn btn-primary"
                type="submit"
              >
                Login
              </button>
            </div>
            </div>

            <div className="mb-3">
            <label
              htmlFor="login"
              className="form-label"
              style={{ marginTop: 20 }}
            >
              Click to Create Profile
            </label>
            <div>
            <Link to="Create/">
              <button
                //   onClick={() => {
                //     setCity("");
                //     setGenre("");
                //     setInstrument("");
                //     setEmail("");
                //   }}
                className="btn btn-primary"
                type="submit"
              >
                Create
              </button>
              </Link>

            </div>
            </div>

        </div>
      </div>
    </main>
  );
};

export default loginPage;
