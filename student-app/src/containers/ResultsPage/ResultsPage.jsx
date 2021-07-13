import React from "react";
import  api  from '../../api/index';
import { useMutation, useQuery, useQueryClient } from 'react-query';
import { Link } from "react-router-dom";

const fetchCourses = async () => await api.index();

const ResultsPage = () => {

  const { status, data, error } = useQuery('courses', fetchCourses);

  switch (status) {
    case 'loading':
      return <p>Loading...</p>;
    case "error":
      return <p>{error.message}</p>;
    default:
  return (
    <main className="container">
      <div className="row">
        <div className="col center-align">
          <table
            class="table table-striped table-hover"
            style={{ marginTop: 20 }}
          >
            <thead>
              <tr>
                <th scope="col">Course Number</th>
                <th scope="col">Course Title</th>
                <th scope="col">Instructor</th>
                <th scope="col">Quarter</th>
              </tr>
            </thead>
            <tbody>
            {data.map(({id, courseNumber, courseTitle, courseInstructor, quarter}) => (
          <tr key={id} data-id={id}>
            <td>{courseNumber}</td>
            <td>{courseTitle}</td>
            <td>{courseInstructor}</td>
            <td>{quarter}</td>
          </tr>
        ))}
            </tbody>
          </table>

          <div className="mb-3">
            <label
              htmlFor="course"
              className="form-label"
              style={{ marginTop: 20 }}
            >
              Return to Profile
            </label>
            <div>
              <Link to={"/Profile"}>
              <button className="btn btn-primary" type="submit">
                
                Return
              </button>
              </Link>
            </div>
          </div>
        </div>
      </div>
    </main>
  );
  }
};

export default ResultsPage;
