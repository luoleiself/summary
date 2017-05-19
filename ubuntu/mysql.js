配置mysql数据库:
	1.sudo apt-cache search mysql  // 使用包管理器查询包
	// apt-get自动安装数据库客户端依赖包:mysql-client-core-5.6,mysql-client-common-5.6
	2.sudo apt-get install mysql-client-5.6
	// apt-get自动安装数据库服务器依赖包:mysql-server-core-5.6,mysql-server-common-5.6 
	3.sudo apt-get install mysql-server-5.6
	4.sudo netstat -tlp // 查看数据连接
	5.sudo service mysql stop	 // 停止数据库服务
		sudo service mysql restart // 重启数据库服务
		sudo service mysql start //启动数据库服务
	6.sudo cp /etc/mysql/my.cnf /etc/mysql/my.cnf.bak // 备份数据库配置文件
	7.sudo vim /etc/mysql/my.cnf // 编辑配置文件,注释端口绑定设置
		# bind-address = 127.0.0.1 // 保存退出
	8.sudo service mysql start
	9.mysql -uroot -proot // 登录数据库
	10.GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION; // 授权非本机用户登录数据库
	11.FLUSH PRIVILEGES; // 刷新权限
	12.status; // 查看数据库服务器编码方式,Server characterset: latin1 ->需要修改服务器编码方式,执行13.
	13.sudo vim /etc/mysql/my.cnf
		[client] -> 在此后面追加
			default-character-set = utf8
		[mysqld] -> 在此后面追加
			default-character-set = utf8
		[mysql] -> 在此后面追加
			default-character-set = utf8
	14.sudo service restart  // 重启数据库服务
	15.// 再次执行9.和12.查看服务器编码


