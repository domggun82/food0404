
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderManager from "./components/listers/OrderCards"
import OrderDetail from "./components/listers/OrderDetail"

import CookManager from "./components/listers/CookCards"
import CookDetail from "./components/listers/CookDetail"

import DeiveryManager from "./components/listers/DeiveryCards"
import DeiveryDetail from "./components/listers/DeiveryDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders',
                name: 'OrderManager',
                component: OrderManager
            },
            {
                path: '/orders/:id',
                name: 'OrderDetail',
                component: OrderDetail
            },

            {
                path: '/cooks',
                name: 'CookManager',
                component: CookManager
            },
            {
                path: '/cooks/:id',
                name: 'CookDetail',
                component: CookDetail
            },

            {
                path: '/deiveries',
                name: 'DeiveryManager',
                component: DeiveryManager
            },
            {
                path: '/deiveries/:id',
                name: 'DeiveryDetail',
                component: DeiveryDetail
            },



    ]
})
