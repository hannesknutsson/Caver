<template>
    <v-card>
        <v-navigation-drawer
         theme="dark" 
         :width="250" 
         permanent
         dark
        >
        <v-list>
            <v-list-item>
                <v-list-item-title class="title">Caver</v-list-item-title>
                <v-list-item-subtitle>0.0.1</v-list-item-subtitle>
            </v-list-item>
        </v-list> 
        <v-list>
            <v-list-item
                :prepend-avatar="(user != null && user.profilePictureUrl != null) ? user.profilePictureUrl : null"
                :title="user != null ? user.displayName : ''"
            ></v-list-item>
        </v-list>
        <v-divider></v-divider>
        <v-list density="compact" nav>
            <v-list-item prepend-icon="mdi-plus-box-multiple" title="Shows" to="home"></v-list-item>
            <v-list-item prepend-icon="mdi-view-list" title="Subscriptions" to="subscriptions"></v-list-item>
            <v-list-item prepend-icon="mdi-cog" title="Settings" to="settings"></v-list-item>
            <v-list-item prepend-icon="mdi-security" title="Admin" to="admin"></v-list-item>
        </v-list>
        </v-navigation-drawer>
    </v-card>
</template>

<script>
export default {
  props: {
    user: {
        type: Object,
        required: true
    }
  },
  created() {
    console.log(this.user)
  }
}
</script>