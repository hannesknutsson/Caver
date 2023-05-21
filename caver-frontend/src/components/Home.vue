<template>
  <v-container>
    <v-row>
      <h1>Shows</h1>
      <v-divider></v-divider>
    </v-row>

    <v-row  class="mt-10">
    <v-col v-if="shows == null || shows.length == 0">
    <h2>Whoops, no shows have been added yet.</h2>
    </v-col>
    <v-col cols="3" v-for="show in shows">
      <v-card
        max-width="300"
        elevation="5"
        variant="tonal"
        >
        <v-img
          :src="show.imageUrl"
          height="300px"
          cover>
        </v-img>
        <v-card-title>
          {{ show.name }}
        </v-card-title>
        <v-card-subtitle>
          <b>{{ show.publisher }}</b>
        </v-card-subtitle>
        <v-card-subtitle class="mt-5">
          {{ show.description}}
         
        </v-card-subtitle>
        <v-card-actions >
          <v-row>
          </v-row>
          <v-btn variant="text">
            Subscribe
          </v-btn>
        </v-card-actions>
      </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>


<script>
import ShowService from '../service/show-service.js'

export default {
  data () {
    return { 
      shows: []
    }
  },
  created() {
    this.getShows();
    console.log(this.shows)
  },
  methods: {
    async getShows () {
      try {
        this.shows = await ShowService.getShows();
        console.log(this.shows)
      } catch (e) {
        console.error(e)
        this.$emit("notification", "error",  e.response)
      } 
    },
  }
}
</script>

<style scoped>

</style>
