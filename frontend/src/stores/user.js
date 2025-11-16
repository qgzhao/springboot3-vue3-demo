import { defineStore } from 'pinia'
import { login as loginApi, getCurrentUser } from '@/api/auth'
import { ElMessage } from 'element-plus'
import router from '@/router'

export const useUserStore = defineStore('user', {
  state: () => ({
    token: localStorage.getItem('token') || '',
    userInfo: null
  }),
  
  getters: {
    isLoggedIn: (state) => !!state.token
  },
  
  actions: {
    async login(loginForm) {
      try {
        const res = await loginApi(loginForm)
        this.token = res.data.token
        this.userInfo = res.data.user
        localStorage.setItem('token', this.token)
        ElMessage.success('登录成功')
        router.push('/')
      } catch (error) {
        throw error
      }
    },
    
    async getUserInfo() {
      try {
        const res = await getCurrentUser()
        this.userInfo = res.data
      } catch (error) {
        this.logout()
      }
    },
    
    logout() {
      this.token = ''
      this.userInfo = null
      localStorage.removeItem('token')
      router.push('/login')
    }
  }
})