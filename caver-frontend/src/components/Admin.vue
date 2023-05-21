<template>
  <v-container>
    <v-row>
      <h1>Admin</h1>
      <v-divider></v-divider>
    </v-row>

    <v-row class="mt-10">

      <v-col cols="3">
        <v-card
        class="pa-5"
        elevation="5"
        variant="tonal"
        >
          <h2>Add Show to Caver</h2>
          <v-text-field
          v-model="addShowIdInput"
          label="Spotify Show ID"
          placeholder="4rOoJ6Egrf8K2IrywzwOMk"
          type="text">
          </v-text-field>
          <v-btn :loading="addShowIdLoading" @click="addShow">Add</v-btn>
        </v-card>
      </v-col>
      <v-col cols="3">
        <v-card
        class="pa-5"
        elevation="5"
        variant="tonal"
        >
          <h2>Delete Show from Caver</h2>
          <v-text-field
          v-model="deleteShowIdInput"
          label="Spotify Show ID"
          placeholder="4rOoJ6Egrf8K2IrywzwOMk"
          type="text">
          </v-text-field>
          <v-btn :loading="deleteShowIdLoading" @click="deleteShow">Delete</v-btn>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>


<script>
import SystemService from '../service/system-service.js'

export default {
  name: 'App',
  emits: ['notification'],
  data () {
    return { 
      addShowIdInput: null,
      addShowIdLoading: false,
      deleteShowIdInput: null,
      deleteShowIdLoading: false,
    }
  },
  methods: {
    async addShow () {
      try {
        this.addShowIdLoading = true;
        await SystemService.addShowById(this.addShowIdInput);
        this.$emit("notification", "success",  "Added show")
      } catch (e) {
        console.error(e)
        this.$emit("notification", "error",  e.response.data)
      } finally {
        this.addShowIdLoading = false;
      }
    },
    async deleteShow () {
      try {
        this.deleteShowIdLoading = true;
        await SystemService.deleteShowById(this.deleteShowIdInput);
        this.$emit("notification", "success",  "Deleted show")
      } catch (e) {
        console.error(e)
        this.$emit("notification", "error",  e.response.data)
      } finally {
        this.deleteShowIdLoading = false;
      }
    },
  },
}
</script>

<style scoped>

</style>
