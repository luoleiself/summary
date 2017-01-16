1、第十三章:数据库访问
	-1、关系型数据库:
		1、遵循的原则:ACID
			1、原子性:Atomicity;事务里的操作要么全部做完,要么全部都不做
			2、一致性:Consistency;事务的运行不会改变数据库原本的一致性约束
			3、独立性:Isolation;并发的事务之间不会相互影响
			4、持久性:Durability;事务提交后,所做的修改将会永久的保存在数据库中
	0、NoSQL:Not Only SQL;用于超大规模数据的存储
	1、MongoDB数据库:基于分布式文件存储的开源数据库系统
		1、特点:
			1、存取效率高:在js环境中支持BSON(二进制json对象)的存取,
			2、非阻塞型数据库:将每一条等待插入的数据记录存储到内存中,
			3、语法支持js:可以在查询语句中使用js函数,增加了读取数据的能力,
			4、面向文档的数据库:允许在父记录中存储子记录,
		2、mongodb的启动参数说明:
			1、--bind_ip;绑定服务IP,指定127,只能本机访问,不指定默认本地所有Ip访问,
			2、--logpath;指定mongodb日志
			3、--logappend;使用追加的方式写日志
			4、--dbpath;指定数据库路径
			5、--port;指定服务端口27017,web服务的端口+1000,在url中输入localhost:28017
			6、--serviceName;指定服务名称
			7、--serviceDisplayName;指定服务名称,有多个mongodb服务时执行
			8、--install;指定作为一个windows服务安装
			mongod --dbpath "yourDbPath" --logpath "yourFileName" --logappend --install //将mongodb作为windows服务启动
		3、mongodb的概念;
			SQL概念				MongoDB概念       		解释
			database				database					数据库
			table						collection				数据表/集合
			row							document					数据记录行/文档
			column					field							数据字段/域
			index						index							索引
			table joins												表连接,MongoDB不支持
			primary key     primary key 			主键,MongoDB自动将_id字段设为主键
		4、支持数据类型:
			1、Array;数组;cardsInHand:[9,4,3];
			2、Boolean;布尔值,true/false;
			3、Code;数据库内部可运行的一段js脚本;new BSON.Code("function(){}");
			4、Date;当前日期和时间;lastUpdated:new Date();
			5、DBRef;数据库引用;bestFriendId:new BSON.DBRef("users","friendObjectId");
			6、Integer;整数值;pageViews:50;
			7、Long;长整数值;starsInUniverser = new BSON.Long("100000009999");
			8、Hash;一个键值形式的数据字典;userNames:{"first":"hehe","last":"xixi"};
			9、Null;null值;bestFriend = null;
			10、ObjectID;用于索引对象的一个12字节的代码;表现形式为一个24位的十六进制字符串;myRecordId:new BSON.ObjectId();
			11、String;字符串;fullName:"hehe";
	2、MySql数据库: