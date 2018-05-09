import React, { Component } from 'react';
import axios from 'axios';
import './App.css';
const API = 'http://localhost:8085/demo/all';

class App extends Component {
  constructor(props) {
    super(props);

    this.state = {
      persons: [],
    };
   }

   componentDidMount() {
    axios.get(API)
      .then(res => {
        const persons = res.data;
        this.setState({ persons });
      });
  }
  render() {
    return (
      <div className="App">
        <div className="App-header">
          <h2>Welcome to React and Spring</h2>
        </div>
          <ul>
              { this.state.persons.map(person => <li>{person.name}</li>)}
          </ul>
      </div>
    );
  }
}

export default App;
