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
    * ssh-keygen  # 一路回车即可,设置公钥和私钥
