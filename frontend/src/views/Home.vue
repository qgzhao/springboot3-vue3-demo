<template>
  <div class="home-container">
    <el-card>
      <template #header>
        <div class="card-header">
          <span>欢迎回来</span>
        </div>
      </template>
      <div class="welcome">
        <h2>{{ userStore.userInfo?.username }}</h2>
        <p>这是用户管理系统的首页</p>
        <el-descriptions :column="2" border style="margin-top: 20px">
          <el-descriptions-item label="用户名">
            {{ userStore.userInfo?.username }}
          </el-descriptions-item>
          <el-descriptions-item label="邮箱">
            {{ userStore.userInfo?.email || '未设置' }}
          </el-descriptions-item>
          <el-descriptions-item label="手机号">
            {{ userStore.userInfo?.phone || '未设置' }}
          </el-descriptions-item>
          <el-descriptions-item label="状态">
            <el-tag :type="userStore.userInfo?.status === 1 ? 'success' : 'danger'">
              {{ userStore.userInfo?.status === 1 ? '启用' : '禁用' }}
            </el-tag>
          </el-descriptions-item>
          <el-descriptions-item label="注册时间" :span="2">
            {{ userStore.userInfo?.createTime }}
          </el-descriptions-item>
        </el-descriptions>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { useUserStore } from '@/stores/user'

const userStore = useUserStore()
</script>

<style scoped>
.home-container {
  padding: 20px;
}

.welcome {
  padding: 20px;
}

.welcome h2 {
  margin-bottom: 10px;
  color: #303133;
}

.welcome p {
  color: #909399;
}
</style>