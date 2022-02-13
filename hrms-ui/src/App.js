import logo from './logo.svg';
import './App.css';
import {
    Col,
    Container, Row, Table
} from "reactstrap";
import Navi from "./component/Navi";
import {Component} from "react";
import CvProfile from "./component/CvProfile";



export default class App extends Component {
    constructor() {
        super();
        this.state = {
            user: {
                "id": 1,
                "firstName": "mehmet",
                "lastName": "onar",
                "phoneNumber": "string",
                "email": "monar2@adalet.gmail",
                "authLevel": 1
            }
        };
    }

    componentDidMount() {
        const requestcvOptions = {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                "authLevel": 0,
                "email": "string",
                "firstName": "string",
                "id": 1,
                "lastName": "string",
                "password": "123456",
                "phoneNumber": "string"
            })
        };
        fetch('http://localhost:8080/v1/api/cv/getCv', requestcvOptions)
            .then(response => response.json())
            .then(data => this.setState({ cvs :data }));

        fetch("http://localhost:8080/v1/api/user/getUser?id=1")
            .then(response => response.json())
            .then(data => this.setState({user :data}));

    }

    render() {

       return (
           <div className="App">
               <Container>
                   <Navi/>
                   <CvProfile user={this.state.user}></CvProfile>
               </Container>
           </div>
       );
   }


}

