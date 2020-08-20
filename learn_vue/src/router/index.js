import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import FirstDemo from '@/components/FirstDemo'
import Container from '@/view/train/Container'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HelloWorld',
      component: HelloWorld
    },
    {
      path: '/first',
      name: 'FirstDemo',
      component: FirstDemo
    },
    {
      path: '/container',
      name: 'Container',
      component: Container
    }
  ]
})
