####  [Vim常用命令:](https://github.com/luoleiself/summary/blob/master/ubuntu/vim)
#### 常见问题：
  1. ubuntu提示密码认证失败：`sudo passwd` 
  2. ubuntu启动器的位置切换：`gsettings set com.canonical.Unity.Launcher launcher-position Bottom(Left)`
  3. ubuntu汉语拼音不能正常提示汉字:
      1. `sudo apt-get install ibus-pinyin`
      2. `sudo apt-get install ibus-libpinyin`
#### 安装NodeJs配置全局环境(方式一)，缺点：版本维护麻烦
  1. 下载NodeJs安装包：`node-v8.1.2-linux-x64.tar.xz` 
  2. c => 压缩，x => 解压缩，v => 显示过程信息，f => 以包名为文件名：
      * `sudo tar -Jxvf node-v8.1.2-linux-x64.tar.xz` => 解压 `xz` 压缩包    
      * `sudo tar -zxvf node-v8.1.2-linux-x64.tar.gz` => 解压 `gz` 压缩包
      * `sudo tar -jxvf node-v8.1.2-linux-x64.tar.bz2` => 解压 `bz2` 压缩包
  3. 移动文件：目录自己定，后面的设置需要用到
      1. `sudo mv node-v8.1.2-linux-x64 /usr/local/` => 移动到 `/usr/local/` 目录下
  4. 创建启动命令符号连接：
      1. `sudo ln -s /usr/local/node-v8.1.2-linux-x64/bin/node /usr/bin/node` => `node` 软连接 
      2. `sudo ln -s /usr/local/node-v8.1.2-linux-x64/bin/npm /usr/bin/npm` => `npm` 软连接
  5. 查看启动命令是否创建成功 
      1. `node -v` => v8.1.2 => 否则创建失败，查看 `4` 是否配置正确 
      2. `npm -v` => 5.0.3 => 否则创建失败，查看 `4` 是否配置正确 
  6. 配置全局模块路径、缓存、镜像服务器
      1. `sudo npm config set prefix /usr/local/node-v8.1.2-linux-x64/node_global` => 全局模块存放路径
      2. `sudo npm config set cache /usr/local/node-v8.1.2-linux-x64/node_cache` => 全局缓存路径
      3. `sudo npm config set registry https://registry.npm.taobao.org` => 镜像服务器
  7. 查看 NodeJs 全局设置：下面三种方式都可以
      * `npm config list -l` => 显示全局设置(最上面几行是用户的设置)
      * `npm config get prefix/cache/registry` => 显示 `6` 设置的路径
      * `sudo vim /home/'用户名'/.npmrc` => 输出配置文件
  8. 配置系统环境变量：
      1. `sudo cp /etc/profile /etc/profile.bak` => 备份配置文件
      2. `sudo vim + /etc/profile` => 编辑配置文件并跳转到最后一行
        1. 在文件末尾追加下面指令：`o` -> `wq`
        
                `export NODE_HOME=/usr/local/node-v8.1.2-linux-x64
                 export PATH=$PATH:$NODE_HOME/node_global/bin => 配置启动命令
                 export NODE_PATH=$NODE_HOME/node_global/lib/node_modules =>配置全局模块路径`
      3. `source /etc/profile` => 使配置文件生效，不用重新启动系统
  9. 测试：
      1. `sudo npm i -g anywhere` => 安装第三方模块
      2. `ll usr/local/node-v8.1.2-linux-x64/node_global/lib/node_modules` => 显示所有文件
      3. `anywhere --help` => 显示帮助命令表示配置成功
      4. `anywhere: 未找到命令` => 表示系统环境配置错误，请检查 `8.2` 的配置路径是否正确
#### 安装NodeJs配置全局环境(方式二)：首先要先删除.npmrc配置文件，.npm文件夹
  1. 下载NodeJs安装包：`node-v8.1.2-linux-x64.tar.xz`
  2. 解压包文件，重命名为 `nodejs`
    * `sudo mv node-v8.1.2-linux-x64/ nodejs`
    * `sudo mv nodejs/ /usr/local/` 移动文件到指定目录
  3. `sudo ln -s /usr/local/nodejs/bin/node /usr/bin/node` 创建 `node` 符号链接
  4. `sudo ln -s /usr/local/nodejs/bin/npm /usr/bin/npm` 创建 `npm` 符号链接
  5. 修改系统环境变量
    * `sudo cp /etc/profile /etc/profile.bak` 备份配置文件
    * `sudo vim + /etc/profile` 文件末尾追加内容，保存并退出
        
            `export NODE_HOME=/usr/local/nodejs
             export PATH=$PATH:$NODE_HOME/bin
             export NODE_PATH=$NODE_HOME/lib/node_modules`
  6. `source /etc/profile` 使配置文件生效，不用重新启动系统 
  7. `sudo npm i -g npm` 安装包
  8. `npm -v` 最新版 `npm`
#### 安装Mysql数据库配置全局环境
