#### 安装NodeJs配置全局环境，以 `8.1.2` 版本为例
  1. 下载NodeJs安装包：`node-v8.1.2-linux-x64.tar.xz` 
  2. c => 压缩，x => 解压缩，v => 显示过程信息，f => 以包名为文件名：
      1. `tar -Jxvf node-v8.1.2-linux-x64.tar.xz` => 解压 `xz` 压缩包
      2. `tar -zxvf node-v8.1.2-linux-x64.tar.xz` => 解压 `gz` 压缩包
      3. `tar -jxvf node-v8.1.2-linux-x64.tar.xz` => 解压 `bz` 压缩包
  3. 移动文件：目录自己定，后面的设置需要用到
      1. `sudo mv node-v8.1.2-linux-x64 /usr/local/` => 移动到 `/usr/local/` 目录下
  4. 创建启动命令符号连接：
      1. `sudo ln -s /usr/local/node-v8.1.2-linux-x64/bin/node /usr/bin/node` => `node` 软连接 
      2. `sudo ln -s /usr/local/node-v8.1.2-linux-x64/bin/npm /usr/bin/npm` => `npm` 软连接
  5. 查看启动命令是否创建成功 
      1. `node -v` => v8.1.2 => 否则创建失败，查看 `4` 是否配置正确 
      2. `npm -v` => 5.0.3 => 否则创建失败，查看 `4` 是否配置正确 
  6. 配置全局模块路径、缓存、镜像服务器
      1. `npm config set prefix /usr/local/node-v8.1.2-linux-x64/node_global` => 全局模块存放路径
      2. `npm config set cache /usr/local/node-v8.1.2-linux-x64/node_cache` => 全局缓存路径
      3. `npm config set registry https://registry.npm.taobao.org` => 镜像服务器
  7. 查看 NodeJs 全局设置：下面三种方式都可以
      1. `npm config list -l` => 显示全局设置(最上面几行是用户的设置)
      2. `npm config get prefix/cache/registry` => 显示 `6` 设置的路径
      3. `sudo vim /home/'用户名'/.npmrc` => 输出配置文件
  8. 配置系统环境变量：
      1. `sudo cp /etc/profile /etc/profile.bak` => 备份配置文件
      2. `sudo vim + /etc/profile` => 编辑配置文件并跳转到最后一行
        1. 在文件末尾追加下面指令：`o` -> `wq!`
        
                `export NODE_HOME=/usr/local/node-v8.1.2-linux-x64
                 export PATH=$PATH:$NODE_HOME/node_global/bin => 配置启动命令
                 export NODE_PATH=$NODE_HOME/node_global/lib/node_modules =>配置全局模块路径`
      3. `source /etc/profile` => 使配置文件生效，不用重新启动系统
  9. 测试：
      1. `npm i -g anywhere` => 安装第三方模块
      2. `ll usr/local/node-v8.1.2-linux-x64/node_global/lib/node_modules` => 显示所有文件
      3. `anywhere --help` => 显示帮助命令表示配置成功
      4. `anywhere: 未找到命令` => 表示系统环境配置错误，请检查 `8.2` 的配置路径是否正确
  
