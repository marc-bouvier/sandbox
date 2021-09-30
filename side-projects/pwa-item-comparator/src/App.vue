<template>
  <div id="app">
    <header>
      <span>Vue.js PWA</span>
    </header>
    <main>
      <h2>Essential Links</h2>
      <ul>
        <li><a href="/#" rel="noopener">Home</a></li>
        <li><a href="/#/admin" rel="noopener">Admin</a></li>
        <li><a href="/#/comparator"  rel="noopener">Comparateur</a></li>
      </ul>
      <router-view></router-view>
    </main>
  </div>
</template>

<script>
export default {
  name: "app"
};
</script>

<style>
body {
  margin: 0;
}

#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}

main {
  text-align: center;
  margin-top: 40px;
}

header {
  margin: 0;
  height: 56px;
  padding: 0 16px 0 24px;
  background-color: #35495e;
  color: #ffffff;
}

header span {
  display: block;
  position: relative;
  font-size: 20px;
  line-height: 1;
  letter-spacing: 0.02em;
  font-weight: 400;
  box-sizing: border-box;
  padding-top: 16px;
}
</style>
