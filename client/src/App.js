import React, { useState, useEffect } from 'react';
import axios from 'axios';
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  const [data, setData] = useState([]);
  const [mood, setMood] = useState('american romance');
  const [limit, setLimit] = useState('15');

  useEffect(() => {
    // fetchData();
  }, []);

  const fetchData = async () => {
    try {
      const response = await axios.get('/movies?mood='
          + mood
          + '&limit='
          + limit);
      setData(response.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const handleMoodChange = (e) => {
        setMood(e.target.value);
  };

  const handleLimitChange = (e) => {
      if (e.target.value > 50) {
          setLimit(50);
      } else {
          setLimit(e.target.value);
      }
  };

  return (
      <div className="container mt-5">
          <h1>Moodflicks</h1>
          <hr/>
          <div className="mb-1">
              <div className="row">
                  <div className="col-6">
                      <label htmlFor="mood" className="form-label">What is Your Mood?</label>
                      <input
                          type="text"
                          className="form-control"
                          id="mood"
                          name="mood"
                          value={mood}
                          onChange={handleMoodChange}
                      />
                  </div>
                  <div className="col-6">
                      <div className="mb-3">
                          <label htmlFor="limit" className="form-label">Search Results (limit 50)</label>
                          <input
                              type="number"
                              className="form-control"
                              id="limit"
                              name="limit"
                              value={limit}
                              onChange={handleLimitChange}
                          />
                      </div>
                  </div>
              </div>
          </div>
          <button onClick={fetchData} className="btn btn-primary">Find Movies</button>
          <hr/>
          <table className="table">
              <thead>
              <tr>
                  <th>Poster</th>
                  <th>Title</th>
                  <th>Plot</th>
                  <th>Released</th>
                  <th>Cast</th>
              </tr>
              </thead>
              <tbody>
              {data.map(movie => (
                  <tr key={movie.id.timestamp}>
                      <td><img src={movie.poster} alt={movie.title} width="75px"/></td>
                      <td>{movie.title}</td>
                      <td>{movie.fullplot}</td>
                      <td>{movie.year}</td>
                      <td>{movie.cast.join(", ")}</td>
                  </tr>
              ))}
              </tbody>
          </table>
      </div>
  );
}

export default App;
