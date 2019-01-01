import Vue from 'vue'
import Application from "./Application";

var controller = new Vue({
    el: '#application',
    components: { Application },
    template: "<Application />"
});