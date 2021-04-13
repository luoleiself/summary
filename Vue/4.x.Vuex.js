import { createApp } from 'vue';
import { createStore } from 'vuex';
// initialization
const store = createStore({});
const app = createApp({});
app.use(store);
