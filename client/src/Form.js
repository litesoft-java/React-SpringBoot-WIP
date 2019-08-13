import React, {Component} from 'react'

class Form extends Component {
    constructor(props) {
        super(props);

        this.initialState = {
            userId: '',
            applicationName: '',
            encryptedUserName: '',
            encryptedPassword: '',
        };

        this.state = this.initialState
    }

    handleChange = event => {
        const {name, value} = event.target;

        this.setState({
            [name]: value,
        })
    };

    submitFind = () => {
        this.props.handleFind(this.state.userId)
    };

    submitCreate = () => {
        this.props.handleCreate(this.state)
    };

    render() {
        const {userId, applicationName, encryptedUserName, encryptedPassword} = this.state;

        return (
            <form>
                <label>UserId</label>
                <input
                    type="text"
                    name="userId"
                    value={userId}
                    onChange={this.handleChange}/>
                <input type="button" value="Find" onClick={this.submitFind}/>

                <label>AppName</label>
                <input
                    type="text"
                    name="applicationName"
                    value={applicationName}
                    onChange={this.handleChange}/>

                <label>UserName</label>
                <input
                    type="text"
                    name="encryptedUserName"
                    value={encryptedUserName}
                    onChange={this.handleChange}/>

                <label>Password</label>
                <input
                    type="text"
                    name="encryptedPassword"
                    value={encryptedPassword}
                    onChange={this.handleChange}/>

                <input type="button" value="Create" onClick={this.submitCreate}/>
            </form>
        );
    }
}

export default Form;
