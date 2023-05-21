import { createApp } from 'vue'
import { createVuetify } from 'vuetify';
import { createRouter, createWebHashHistory } from 'vue-router';
import './style.css'
import App from './App.vue'
import 'vuetify/styles';
import '@mdi/font/css/materialdesignicons.css'
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

import Home from './components/Home.vue';
import Settings from './components/Settings.vue';
import Subscriptions from './components/Subscriptions.vue';
import Admin from './components/Admin.vue';
import axios from 'axios';

const routes = [
  { path: '/', component: Home },
  { path: '/home', component: Home },
  { path: '/settings', component: Settings },
  { path: '/subscriptions', component: Subscriptions },
  { path: '/admin', component: Admin },
] 


const csrfToken = ('; '+document.cookie).split(`; XSRF-TOKEN=`).pop().split(';')[0];
axios.defaults.headers.common['X-XSRF-TOKEN'] = csrfToken

const router = createRouter({
  // 4. Provide the history implementation to use. We are using the hash history for simplicity here.
  history: createWebHashHistory(),
  routes, // short for `routes: routes`
})

const vuetify = createVuetify({
  components,
  directives,
});

createApp(App).use(vuetify).use(router).mount('#app')

