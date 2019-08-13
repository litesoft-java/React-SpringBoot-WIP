import axios from 'axios'

class CredentialsService {

    // noinspection JSMethodCanBeStatic
    retrieveAllCredentials(name) {
        return axios.get(`http://localhost:8080/credentials/` + name);
    }

    // noinspection JSMethodCanBeStatic
    saveCredentials(credential) {
        return axios.post(`http://localhost:8080/credentials`, credential);
    }
}

export default CredentialsService;