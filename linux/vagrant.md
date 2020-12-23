## Vagrant 配置

### 命令

- vagrant box list // 查看目前已有的 box
- vagrant box add // 新增加一个 box
- vagrant box remove // 删除指定 box
- vagrant init // 初始化配置 vagrantfile
- vagrant up // 启动虚拟机
- vagrant ssh // ssh 登录虚拟机
- vagrant suspend // 挂起虚拟机
- vagrant resume // 恢复挂起的虚拟机
- vagrant reload // 重启虚拟机
- vagrant halt // 关闭虚拟机
- vagrant global-status // 虚拟机状态
- vagrant destroy // 删除虚拟机

### windows 系统设置 vagrant 和 VirtualBox 的默认目录为 C 盘以外的目录

> 节省 C 盘空间

#### Vagrant

- 打开高级系统设置--环境变量(用户变量和系统变量均可)

- 新建/编辑 VAGRANT_HOME 环境变量

- 变量值为新建的目录 例如：D:\\VirtualBox\\.vagrant.d

- 保存后重新打开命令行窗口

#### VirtualBox

- 启动 VirtualBox

- 打开管理菜单 -> 全局设置

- 点击常规选项 -> 默认虚拟电脑位置 -> 其他

- 选择除 C 盘外的目录后保存

#### 报错(有可能会出现)

- Vagrant failed to initialize at a very early stage

> 在设置环境变量的目录上右键 -> 授予访问权限 -> 特定用户 -> 当前用户 -> 共享
