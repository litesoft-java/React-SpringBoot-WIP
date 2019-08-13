import React, { Component } from 'react'

const TableHeader = () => {
    return (
        <thead>
        <tr>
            <th>AppName</th>
            <th>UserName</th>
            <th>Password</th>
        </tr>
        </thead>
    )
};

const TableBody = props => {
    const rows = props.credentials.map((row, index) => {
        return (
            <tr key={index}>
                <td>{row.applicationName}</td>
                <td>{row.encryptedUserName}</td>
                <td>{row.encryptedPassword}</td>
                <td>
                    <button onClick={() => props.removeCredential(index)}>Delete</button>
                </td>
            </tr>
        )
    });

    return <tbody>{rows}</tbody>
};

class Table extends Component {
    render() {
        const { credentials, removeCredential } = this.props;

        return (
            <table>
                <TableHeader />
                <TableBody credentials={credentials} removeCredential={removeCredential} />
            </table>
        )
    }
}

export default Table