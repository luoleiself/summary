### nvm (Node Version Manager)
    * wget -qO- https://raw.githubusercontent.com/creationix/nvm/v0.33.0/install.sh | bash
    * command -v nvm  // nvm
    * nvm --help // 查看帮助命令
### umake (ubuntu-make):开发者神器 ，一键搭建开发环境
    * sudo add-apt-repository ppa:ubuntu-desktop/ubuntu-make  # 将ubuntu-make加入apt软件仓库的列表
    * sudo apt update  # 升级apt的软件仓库，为了加入刚才的ubuntu-make
    * sudo apt install ubuntu-make  # 安装ubuntu-make
    * umake --help  # umake的帮助页面
    * man umake  # 用man（手册manuel的缩写）命令来查看umake用法
    * info umake  # umake的信息（info）页面
    * umake 大类 小类
    * umake ide eclipse-jee   # 安装javaEE开发工具
### GNOME Tweaks(优化GNOME3高级设置)
    * 启动应用程序中心，搜索 GNOME Tweaks，并安装
    * 在Dock中搜索Tweaks并启动，做相应设置
### SSH
    * sudo apt-get install openssh-server # 安装ssh服务
    * ps -e | grep ssh  # 查看ssh服务是否启动
    * netstat -tlp | grep ssh # 查看ssh服务是否启动
    * sudo /etc/init.d/ssh start # 启动ssh服务
    * sudo /etc/init.d/ssh stop  # 停止ssh服务
    * sudo /etc/init.d/ssh resart   # 重启ssh服务
    * warning: remote host identificatino has changed!
    * 删除本地 ~/.ssh/known_hosts 中指定的主机那一行
### Nginx
    * sudo apt update   # 第一步安装
    * sudo apt install nginx
    * sudo ufw app list  # 列出防火墙可用application, 第二步配置防火墙
      Output
      Available applications:
         Nginx Full: 此配置文件打开端口80（正常，未加密的网络流量）和端口443（TLS / SSL加密流量）
         Nginx HTTP: 此配置文件仅打开端口80（正常，未加密的网络流量）
         Nginx HTTPS: 此配置文件仅打开端口443（TLS / SSL加密流量）
         OpenSSH
    * sudo ufw allow 'Nginx HTTP' # 配置防火墙允许访问的流量
    * sudo ufw status # 查看防火墙状态
    * sudo systemctl status nginx # 查看系统服务运行状态, 第三步检查系统服务
    * sudo systemctl stop nginx  # 停止web服务器, 第四步管理Nginx进程
    * sudo systemctl start nginx  # 停止时启动web服务器
    * sudo systemctl restart nginx   # 停止后并再次重启web服务器
    * sudo systemctl reload nginx  # 简单更改配置,重新加载不丢失连接
    * sudo systemctl disable nginx   # 禁止服务引导时启动
    * sudo systemctl enable nginx   # 重新启用服务在引导时启动
    * curl -I <url>  # 测试nginx是否正常启动,I 只显示响应头, i 包含所有内容
    * 第五步配置服务器块
    * sudo nginx -t  # 测试nginx文件的语法错误
    * /var/www/html  # 默认情况下的Nginx项目目录
    * /etc/nginx  # Nginx配置目录
    * /etc/nginx/nginx.conf # Nginx的主要配置文件
    * /etc/nginx/sites-available/  # 可存储每个站点服务器块的目录
    * /etc/nginx/sites-enabled/  # 存储启用的每个站点服务器块的目录,通常由链接到sites-available下的配置文件创建的,Nginx服务启动时加载此目录下的配置文件
    * /etc/nginx/snippets  # 包含可以包含在Nginx配置其他地方的配置片段
    * /etc/nginx/koi-utf # 编码转换映射转化文件 | 配置文件
    * /etc/nginx/koi-win
    * /etc/nginx/fastcgi_params  # cgi配置相关，fastcgi | 配置文件
    * /etc/nginx/scgi_params 
    * /etc/nginx/uwsgi_params
    
