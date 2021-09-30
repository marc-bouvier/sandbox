import {createLocalVue, shallowMount } from '@vue/test-utils'
import HelloWorld from '@/components/HelloWorld.vue'
import Vuetify from 'vuetify'

describe('HelloWorld.vue', () => {
  it('matches snapshot', () => {
      const msg = 'message'
    const localVue = createLocalVue()
    localVue.use(Vuetify)

    const wrapper = shallowMount(HelloWorld, {
      localVue:localVue,
      propsData: { msg }
    })
    expect(wrapper.html()).toMatchSnapshot()
  })
})
