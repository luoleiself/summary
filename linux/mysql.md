#### Linux 配置mysql:
	1. sudo apt-cache search mysql  // 使用包管理器查询包
	// apt-get自动安装数据库客户端依赖包:mysql-client-core-5.6,mysql-client-common-5.6
	2. sudo apt-get install mysql-client-5.6
	// apt-get自动安装数据库服务器依赖包:mysql-server-core-5.6,mysql-server-common-5.6 
	3. sudo apt-get install mysql-server-5.6
	4. sudo netstat -tlp // 查看数据连接
	5. sudo service mysql stop	 // 停止数据库服务
		sudo service mysql restart // 重启数据库服务
		sudo service mysql start //启动数据库服务
	6. sudo cp /etc/mysql/my.cnf /etc/mysql/my.cnf.bak // 备份数据库配置文件
	7. sudo vim /etc/mysql/my.cnf // 编辑配置文件,注释端口绑定设置
		// bind-address = 127.0.0.1 // 保存退出
	8. sudo service mysql start
	9. mysql -uroot -proot // 登录数据库
	10. GRANT ALL PRIVILEGES ON *.* TO 'root'@'%' IDENTIFIED BY 'root' WITH GRANT OPTION; // 授权非本机用户登录数据库
	11. FLUSH PRIVILEGES; // 刷新权限
	12. status; // 查看数据库服务器编码方式,Server characterset: latin1 ->需要修改服务器编码方式,执行13.
	13. sudo vim /etc/mysql/my.cnf
		[client] -> 在此后面追加
			default-character-set = utf8
		[mysqld] -> 在此后面追加
			default-character-set = utf8
		[mysql] -> 在此后面追加
			default-character-set = utf8
	14. sudo service restart  // 重启数据库服务
	15. // 再次执行9.和12.查看服务器编码
#### windows配置mysql:
	1. // 下载mysql压缩包,并解压
	2. // 在目录中创建data目录和my.ini文件
	3. // 编辑my.ini文件
		```
		[client]
		port=3306
		default-character-set=utf8

		[mysqld] 
		# 设置为自己MYSQL的安装目录 
		basedir=D:\mysql-5.7.19-winx64 # mysql解压目录
		# 设置为MYSQL的数据目录 
		datadir=D:\mysql-5.7.19-winx64\data # mysql init 目录
		port=3306
		character_set_server=utf8
		sql_mode=NO_ENGINE_SUBSTITUTION,NO_AUTO_CREATE_USER
		#开启查询缓存
		explicit_defaults_for_timestamp=true
		#skip-grant-tables
		```
	4. mysqld --initialize # 管理员模式下,初始化mysql配置文件并写入data目录中
	5. mysqld --install # 在系统服务中添加mysql服务
	6. mysqld --remove # 在系统服务中卸载mysql服务
	7. net start mysql # 启用mysql服务
	8. net stop mysql # 停用mysql服务
	9. set password for root@localhost = password('123456'); # 修改mysql密码,如果需要
	10. alter user user() identified by '123456'; # 修改当前登陆用户的密码,mysql 5.7以上推荐使用，首次登陆失败时查看data/user.err文件查找初始密码
	11. alter user user() identified by '123456' password expire never; # 设置密码永不过期
	12. alter user user() identified by '123456' password expire default; # 设置默认过期时间
	13. alter user user() identified by '123456' password expire interval 90 day; # 设置过期间隔
