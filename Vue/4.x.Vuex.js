// vuex@4.0.0
import { createApp, computed, watchEffect } from 'vue';
import { createStore, useStore, mapState, mapGetters, mapMutations, mapActions, createNamespacedHelpers } from 'vuex';
// initialization
const store = createStore({
  state() {
    return { count: 0 };
  },
  getters: {},
  mutations: {
    ['COUNT_ADD'](state, payload) {
      state.count = payload;
    },
  },
  actions: {},
});
const app = createApp({});
app.use(store);

// Composition API
export default {
  setup() {
    const store = useStore();

    const count = computed({
      set: (val) => {
        console.log('computed hooks set count by store... ', val);
        store.commit('COUNT_ADD', val);
      },
      get: () => {
        let count = store.state.count;
        console.log('computed hooks get count... ', count);
        return count;
      },
    });

    watchEffect(
      () => {
        console.log('watchEffect... ', count.value);
      },
      { flush: 'post' }
    );

    const increment = () => {
      count.value += 1;
    };

    return { count, increment };
  },
  beforeMount() {
    console.log('beforeMount... ', this.$store);
  },
};
