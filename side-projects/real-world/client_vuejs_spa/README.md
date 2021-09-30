# Sample of a vuejs SPA 

```
npm install -g @vue/cli
vue create vuejs_spa
cd vuejs_spa
npm audit fix
vue add eslint
# Choose which lint config you want (I picked Standard)
# Lint on save
vue add unit-jest
npm install
npm run serve
```

Create a vue.config.js containing the following to fix "Invalid Host header" when running on gitpod.
```
module.exports = {
    devServer: {
        //fix "Invalid Host header" when running on gitpod
        disableHostCheck: true
    }
}
```

Create the app using localhost:8080

