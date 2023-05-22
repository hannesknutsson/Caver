import axios from 'axios'

class UserService {
  getUser() {
    return new Promise((resolve, reject) => {
      axios
        .get("/api/user")
        .then((response) => {
          resolve(response.data)
        })
        .catch((error) => {
          reject(error)
        })
    })
  }
}
export default new UserService()