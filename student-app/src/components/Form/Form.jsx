import React, { useState } from "react";
import { useHistory, useParams } from "react-router-dom";
import  api  from '../../api/index';
import { useMutation, useQueryClient } from 'react-query';


const Form = () => {

  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");
  const [email, setEmail] = useState("");
  const [course, setCourse] = useState("");
  const [courseId, setCourseId] = useState("");
  const [gpa, setGpa] = useState("");
  
  const history = useHistory();

  const { id } = useParams();

  const qc = useQueryClient();

  const mutation = useMutation(newStudent => api.add(newStudent, "students"), {
    onSuccess: () => {
      qc.invalidateQueries('students');
      qc.refetchQueries("students").then(() => history.push("/Profile"));
    },
  });

  function handleSubmit(event) {
    event.preventDefault();

    mutation.mutate({ firstName, lastName, email, course, courseId, gpa });
    event.target.reset();
  }
  return (
    <>
      <form onSubmit={handleSubmit}
      
      >
        <div className="mb-3">
        <label htmlFor="firstName" className="form-label"> 
        First Name 
        </label>
          <input
          className="form-control"
            id="firstName"
            type="text"
            name="firstName"
              value={firstName}
              onChange={(e) => {
                setFirstName(e.target.value);
              }}
          />
        </div>

        <div className="mb-3">
        <label htmlFor="lastName" className="form-label"> 
        Last Name 
        </label>
          <input
          className="form-control"
            id="lastName"
            type="text"
            name="lastName"
              value={lastName}
              onChange={(e) => {
                setLastName(e.target.value);
              }}
          />
        </div>

        <div className="mb-3">
        <label htmlFor="email" className="form-label"> 
        Email 
        </label>
          <input
          className="form-control"
            id="email"
            type="email"
            name="email"
              value={email}
              onChange={(e) => {
                setEmail(e.target.value);
              }}
          />
        </div>

        <div className="mb-3">
        <label htmlFor="course" className="form-label"> 
        Course 
        </label>
          <input
          className="form-control"
            id="course"
            type="text"
            name="course"
              value={course}
              onChange={(e) => {
                setCourse(e.target.value);
              }}
          />
        </div>

        <div className="mb-3">
        <label htmlFor="courseId" className="form-label"> 
        Course Id 
        </label>
          <input
          className="form-control"
            id="courseId"
            type="text"
            name="courseId"
              value={courseId}
              onChange={(e) => {
                setCourseId(e.target.value);
              }}
          />
        </div>

        <div className="mb-3">
        <label htmlFor="studentGpa" className="form-label"> 
        Student Gpa 
        </label>
          <input
          className="form-control"
            id="gpa"
            type="text"
            name="gpa"
              value={gpa}
              onChange={(e) => {
                setGpa(e.target.value);
              }}
          />
        </div>

        <button type="submit" className="btn btn-primary">
          Submit
        </button>

      </form>
    </>
  );
};

export default Form;
