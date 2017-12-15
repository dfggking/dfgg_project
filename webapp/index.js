/**
 * Created by jinyingfei on 2017/11/16.
 */
import Vue from 'vue';
import VueRouter from 'vue-router';

Vue.use(VueRouter);
Vue.config.debug = true;
import Mint from 'mint-ui';
Vue.use(Mint);
import App from './vtemp/App.vue';

const routes = [
    {path: '/', component: App}
];

const router = new VueRouter({
    history: true,
    routes
});

const AppVue = new Vue({
    router,
    components: {
    }
}).$mount('#app');

window.router = router;
window.AppVue = AppVue;
