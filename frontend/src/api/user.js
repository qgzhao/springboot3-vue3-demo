import request from '@/utils/request'

export const getUserList = (params) => {
  return request({
    url: '/users',
    method: 'get',
    params
  })
}

export const updateUser = (data) => {
  return request({
    url: '/users',
    method: 'put',
    data
  })
}

export const deleteUser = (id) => {
  return request({
    url: `/users/${id}`,
    method: 'delete'
  })
}