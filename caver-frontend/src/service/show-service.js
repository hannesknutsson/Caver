import axios from 'axios'

class ShowService {
  getShows() {
    return new Promise((resolve, reject) => {
      axios
        .get("/api/shows/")
        .then((response) => {
          resolve(response.data)
        })
        .catch((error) => {
          reject(error)
        })
    })
  }
}

export default new ShowService()