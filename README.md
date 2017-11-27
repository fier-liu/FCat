#  **FCat** 
FCat是基于Angular4+SpringCloud的企业级基础功能框架(户权限管理、区域管理、GIS地图、......)，其核心设计目标是分离前后端、开发快速、学习简单、功能强大、不重复造轮子，其目标是帮助企业搭建一套基础功能框架；

- 前端技术：Angular4；
- 后端技术：SpringCloud；

 **QQ群号（1群）：549141844**   

[^_^] 演示地址： http://fcat.xfdmao.com   
用户名：aki  密码：123456

【CSDN教程地址】：http://edu.csdn.net/course/detail/6358
# 架构设计 
![img](http://on-img.com/chart_image/5954b886e4b0ad619ac73246.png)

## 开发环境
- node-v6.11.0-x64.msi
- redis3.X
- jdk1.8
- MySQL Server 5.6
- maven3.X
- IntelliJ IDEA 
- webstorm


## 部署项目
#### 部署  
安装node-v6.11.0-x64.msi  
cdm下运行一下命令：  
```
npm config set registry https://registry.npm.taobao.org
npm install -g @angular/cli
cd FCat\fcat-angular
npm install
```
#### 默认CORS解决跨域问题
``` 
- 后台依次启动：CenterBootstrap、GateBootstrap、UserBootstrap 
- 前端：ng serve  
- 访问： http://localhost:4200 
```

#### 另外一种解决跨域问题——nginx做转发
nginx.conf配置
```
worker_processes  1;
events {
    worker_connections  1024;
}
http {
    include       mime.types;
    default_type  application/octet-stream;
    sendfile        on;
    keepalive_timeout  65;
    server {
        listen       80;
	server_name  localhost; 
        location / {
            proxy_pass   http://localhost:4200;
        } 
	location /apis {
	    rewrite    ^.+apis/?(.*)$ /$1 break;
            include  uwsgi_params;
            proxy_pass   http://localhost:8965;
        }
        error_page   500 502 503 504  /50x.html;
        location = /50x.html {
            root   html;
        }
    }
} 
```


## 功能    
- 项目搭建、架构设计  
- 用户管理     
- 菜单管理  
- 组织类型管理  
- 组织架构管理————组织管理、关联用户、组织授权  
  
 
## 前端效果
![img](http://image.xfdmao.com/fcat/demo/fcat-login.png)
![img](http://image.xfdmao.com/fcat/demo/FCat-userList.png)
![img](http://image.xfdmao.com/fcat/demo/FCat-menu.png)
![img](http://image.xfdmao.com/fcat/demo/FCat-group.png)