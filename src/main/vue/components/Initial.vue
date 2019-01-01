<template>
    <div>
        <input type='text' v-bind:value='message'>
        <button v-on:click='sendHello'>Send</button>
    </div>
</template>

<script>
export default {
    name: "Initial",
    data() {
        return {
            message: 'Hello, Kotlin!'
        }
    },
    methods: {
        sendHello() {
            get('http://localhost:8080/hello?name=Vue')
            .then(this.setResponse)
            .catch(function (error) {
                console.log(error);
            });
        },
        setResponse(response) {
            this.message = response;
        }
    }
};
</script>