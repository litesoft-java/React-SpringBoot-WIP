import React, { Component } from 'react'
import Table from './Table'
import Form from './Form'
import CredentialsService from "./CredentialsService";


class App extends Component {

    state = {
        credentials: [
        ],
    };

    credentialsService = new CredentialsService();

    removeCredential = index => {
        const { credentials } = this.state;

        this.setState({
            credentials: credentials.filter((credential, i) => {
                return i !== index
            }),
        })
    };

    handleCreate = credential => {
        this.credentialsService.saveCredentials(credential)
            .then(
                response => {
                    console.log(response.data);
                    this.setState({
                        credentials: [...this.state.credentials, response.data]
                    })
                }
            )
        // this.setState({ credentials: [...this.state.credentials, credential] })
    };

    handleFind = userId => {
        // console.log(userId);
        this.credentialsService.retrieveAllCredentials(userId)
            .then(
                response => {
                    console.log(response.data);
                    this.setState({
                        credentials: response.data,
                    })
                }
            )
        // this.setState({ credentials: [...this.state.credentials, character] })
    };

    render() {
        const { credentials } = this.state;

        return (
            <div className="container">
                <Table credentials={credentials} removeCredential={this.removeCredential} />
                <Form handleCreate={this.handleCreate} handleFind={this.handleFind} />
            </div>
        )
    }
}

export default App
