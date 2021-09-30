import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import TheAdmin from '@/components/TheAdmin'
import TheItemComparator from '@/components/TheItemComparator'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/admin',
      name: 'TheAdmin',
      component: TheAdmin
    },
    {
      path: '/comparator',
      name: 'TheItemComparator',
      component: TheItemComparator
    }
  ]
})
