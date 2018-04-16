import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'
import login from '@/components/login'
import chat from '@/components/chat'
import index from '@/components/index'
import sysmenu from '@/components/sys/menu/sysmenu'
import sysrole from '@/components/sys/role/sysrole'
import sysuser from '@/components/sys/user/sysuser'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'login',
      component: login
    },
    {
      path: '/',
      name: 'first',
      component: login
    },
    {
      path: '/home',
      name: 'index',
      component: index,
      children: [
        {
          path: 'index',
          name: 'index',
          component: HelloWorld,
        },
        {
          path: 'test',
          name: 'test',
          // component: N,
        },
      ]
    },
    {
      path: '/sys',
      name: 'index',
      component: index,
      children: [
        {
          path: 'menu',
          name: 'sysmenu',
          component: sysmenu,
        },
        {
          path: 'role',
          name: 'sysrole',
          component: sysrole,
        },
         {
          path: 'user',
          name: 'sysuser',
          component: sysuser,
        },
      ]
    },
    {
      path: '/chat',
      name: 'chat',
      component: chat
    }
  ]
})
