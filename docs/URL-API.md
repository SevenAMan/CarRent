# URL API
## 总则
1. 前后分离， Ajax+Json通信
2. 返回格式
```json
{
    "status": 0,
    "message": "",
    "data": {
    }
}
```
3. 所有时间均为1970至今的毫秒数

## 验证码
1. get '/validate'
2. \<img src='/validate'>

## 图片
1. hash 
2. \<img src='/img/:hash'>

## 注册
1. post '/user'
```json
{
"name": "",
"email": "",
"password":"",
"license":"驾照码",
"head":"file 头像",
"type": "用户、技师",
"phone?":"",
"code":"验证码"
}
```
2. 激活front`/active?id=:hash`
url: get `/active`
```json
{
"id": "hash"
}
```
## 登录
1. post '/session'
```json
{
    "email": "", 
    "password": "",
    "code": "验证码"
}
```
2. 返回值: 用户实体类
```json
{
"name": "",
"hash": "用户头像的hash"
}
```

## 信息管理
1. get '/user/:email'
返回值
```json
{
"email": "",
"name": "",
"credit": "",
"points": "",
"license": "",
"type": 0,
"hash": "用户头像的hash",
"phone": ""
}
```
2. put '/user'
```json
{
"email": "",
"password": "",
"name": "",
"head": "file"
}
```
3. delete '/user/:email'
4. get '/password' 请求重置密码
```json
{
"email": ""
}
```
5. put '/password' 使用序列码和密码发送重置密码请求
```json
{
"hash":"",
"password": ""
}
```
## 技师审核
1. get '/engineer' 获取当前所有等待审核的技师名单
返回值
```json
{
"email": "",
"name": "",
"credit": "",
"points": "",
"license": "",
"type": 0,
"hash": "用户头像的hash",
"phone": ""
}
```
2. put '/engineer' 管理员审核技师
```json
{
"email": "技师审核通过"
}
```

## 车辆管理
1. get '/type' 获取所有车辆类型, 包括座位数
```json
{
    "type": []
}
```
2. 管理员添加类型，座位数
post '/type'
```json
{
"number": 0
}
```
2. get '/brand/:key' , 名字和logo哈希码
```json
{
"brand": [{
  "name": "",
  "hash": ""
}]
}
```
3. 管理员添加品牌， 名称和logo
post  '/brand'
```json
{
"name": "",
"hash": ""
}
```
3. 用户上传车辆信息
post '/car'
```json
{
"email": "",
"type": "",
"card": "（id）",
"brand": "",
"img":[],
"message": "(2-200)",
"price": ""
}
```
4. 车辆审核发布
    - get '/checkcar'
    - 返回值
    ```json
    {
    "img": [],
    "type": "", 
    "card": "",
    "brand": "",
    "message": ""
    }
    ```
    - put '/checkcar/:card'
5. 查找车辆
   - get '/car', 页号, 每页长度, 汽车类型, 汽车品牌
   ```json
    {
       "page": 0,
       "length": 0,
       "type": 0,
       "brand": ""
    }
    ```
   
## 订单管理
1. 生成订单
    - put '/order'
    ```json
    {
      "email": "",
      "card": "",
      "timebegin": "",
      "timeend": ""
    }
    ```
2. 获取订单
    - get '/user/:id/order'
    返回值
    ```json
    {
    "id": "",
    "card": "",
    "timebegin": "",
    "timeend": ""
    }
    ```
3. 完成订单
put '/order'
```json
{
"id": ""
}
```
3. 取消订单
    - delete '/order/:id'

## 评论
1. post '/comment' 后端生成时间
```json
{
 "content":"comment",
 "orderId":""
}
```
2. get '/comment/:card'
```json
{
"contents": [{
    "name": "",
    "time": "",
    "content": ""
}]
}
```
