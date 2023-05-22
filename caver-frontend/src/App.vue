<template>
    <v-layout v-if="user">
      <NavigationDrawer 
        :user="user"
      />
      <v-main class="ma-10">
        <router-view @notification="notify"></router-view>
      </v-main>
    </v-layout>
    <v-layout v-else>
        <v-container class="fill-height mt-16">
          <v-row class="justify-center fill-height mt-16 " >
              <v-progress-circular size="50" indeterminate></v-progress-circular>
          </v-row>
        </v-container>
    </v-layout>
    <v-snackbar
      v-model="showNotification"
      :color="notificationColor"
      :timeout="2000"
    >
      {{ notificationText }}
    </v-snackbar>
</template>

<script setup>
  import NavigationDrawer from './components/NavigationDrawer.vue'
</script>

<script>
import UserService from './service/user-service'

export default {
  name: 'App',
  data () {
    return { 
      user: null,
      notificationText: null,
      notificationColor: null,
      showNotification: false,
    }
  },
  created: async function () {
    this.user =  await this.getUser();
  },
  methods: {
    async getUser() {
      try {
        return await UserService.getUser();
      } catch (e) {
        console.error(e);
      }
      
    },
    notify(type, message) {
      console.log("notification")
      this.notificationText = message;
      this.notificationColor = type == "error" ? "red" : "green";
      this.showNotification = true;
    },
  },
}
</script>



<style scoped>
</style>
