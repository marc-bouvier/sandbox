import Vue from 'vue'
import Vuex from 'vuex'
import eisenhowerModule from './modules/eisenhower'

Vue.use(Vuex)

export default new Vuex.Store({
  strict: true,

  modules: {
    eisenhower : eisenhowerModule
  }
})
