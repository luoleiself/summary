#### windows配置mongodb:
	1. // 下载zip包,并解压到指定目录
	2. // 新增配置文件
		```
		dbpath=d:\mongodb\db	# 指定数据库的存储路径,可以是解压目录
		logpath=d:\mongodb\log\mongod.log	# 指定日志的存储路径,可以是解压目录
		#logappend=true		# 日志的存储方式是否是追加方法
		#bind_ip=127.0.0.1
		#port=27017
		#master=true
		auth=true	# 开启认证,后面配置
		```
	3. mongod --config "配置文件的的路径" --install --auth --serviceName "serviceName" --serviceDisplayName "serviceNameDisplayName" 
		```
		# --config 配置文件的路径
		# --auth 开启权限认证
		# --install 添加到系统服务中
		# --remove  从系统中移除服务
		# --serviceName 在系统服务中的名字
		# --serviceDisplayName 在系统服务中显示的名字,开启多个服务实例时需要使用该参数
		```
	4. net start serviceName
	5. net stop serviceName
    6. mongo -u userName --authenticationDatabase dbName // 权限分配指定用户名登陆指定数据库
    
