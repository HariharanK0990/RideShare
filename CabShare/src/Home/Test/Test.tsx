import "./App.css";

function App() {
  return (
    <div className="App">
      <main className="main-content">
        <h1>Make a new Ride</h1>
        <p>request for a ride</p>
        <div className="ride-request">
          <input
            type="text"
            placeholder="Enter location"
            className="input-field"
          />
          <input
            type="text"
            placeholder="Enter destination"
            className="input-field"
          />
          <button className="price-button">See prices</button>
        </div>
      </main>
    </div>
  );
}

export default App;
