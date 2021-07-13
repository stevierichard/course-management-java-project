import React from "react";
import Form from "../../components/Form/Form";

const CreateProfilePage = () => {
  return (
    <div className="container">
      <div className="row">
        <div className="col center-align">
          <h3 style={{ marginTop: 20 }}>create your profile.</h3>
          <Form />
        </div>
      </div>
    </div>
  );
};

export default CreateProfilePage;
