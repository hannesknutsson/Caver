import axios from 'axios'

class SystemService {
  addShowById(id) {
    return new Promise((resolve, reject) => {
      axios
        .post("/api/system/shows/" + id, null)
        .then((response) => {
          resolve(response.data)
        })
        .catch((error) => {
          reject(error)
        })
    })
  }

  deleteShowById(id) {
    return new Promise((resolve, reject) => {
      axios
        .delete("/api/system/shows/" + id)
        .then((response) => {
          resolve(response.data)
        })
        .catch((error) => {
          reject(error)
        })
    })
  }
}

export default new SystemService()