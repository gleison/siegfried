<template>
    <div>
        <input type='text' v-model:value='stock'>
        <input type='text' v-model:value='name'>
        <input type='text' v-model:value='value'>
        <button v-on:click='getInfo'>Send</button>
    </div>
</template>

<script type="text/script">
export default {
    name: "Initial",
    data() {
        return {
            stock: '',
            name: '',
            value: ''
        }
    },
    methods: {
        getInfo() {
            get('http://localhost:8080/stock?symbol=' + this.stock)
            .then(this.setResponse)
            .catch(function (error) {
                console.log(error);
            });
        },
        setResponse(response) {
            var json = JSON.parse(response);
            this.name = json.info.symbol;
            this.value = json.info.price;
        }
    }
};
</script>