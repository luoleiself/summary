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
			5、--port;指定服务端口27017,web服务的端口+1000,在url中输入localhost:27017
			6、--serviceName;指定服务名称
			7、--serviceDisplayName;指定服务名称,有多个mongodb服务时执行
			8、--install;指定作为一个windows服务安装
			mongod --dbpath "yourDBPath"	
		3、mongodb的概念;
			1、与SQL的关系
				SQL概念				MongoDB概念       		解释
				database				database					数据库
				table						collection				数据表/集合
				row							document					数据记录行/文档
				column					field							数据字段/域
				index						index							索引
				table joins												表连接,MongoDB不支持
				primary key     primary key 			主键,MongoDB自动将_id字段设为主键
			2、数据库:
				1、show dbs;显示全部数据库;
				2、db;显示当前数据库对象或集合
				3、use database;切换数据库对象或集合
				4、命名规范:
					1、不能为空字符串
					2、不能包含空格、点、$、/、\0
					3、全部小写
					4、最多64字节
				5、特殊的数据库:
					1、admin:权限数据库,一些特定的服务器命令需要在此运行,例关闭数据库或者服务器
					2、local:这个数据库永远不会被复制,可以用来存储限于本地单台服务器的任意集合
					3、config:当Mongo用于分片设置时,config数据库在内部使用,用于保存分片的信息
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
		5、基本操作:
			1、Insert:插入
				1、单条插入:MongoDB控制台是一个JavaScript Shell环境,支持所有的js语法,可以直接使用js语法插入
					var  signle = {"name":"hehe","age":26,"gender":"male","address":{"province":"henan","city":"xinyang"},"favouriate":["football","apple"]}
					var  signle = {"name":"xixi","age":20,"gender":"female","address":{"province":"hebei","city":"anyang"},"favouriate":["basketball","apple"]}
					db.user.insert(signle);
				2、批量插入:实现原理采用for循环插入
			2、Find:查询
				1、>,>=,<,<=,!=,=;"$gt","$gte","$lt","$lte","$ne","没有特殊关键字";
					db.user.find({"age":{"$gt":22}});//查询年龄大于22的记录,find age > 22
					db.user.find({"age":{"$lte":22}});//查询年龄小于等于22的记录,find age <= 22
					dd.user.find({"age":{"$ne":22}});//查询年龄不等于22的记录,find age != 22
					dd.user.find({"age":22});//查询年龄等于22的记录,find age == 22
				2、And,OR,In,NotIn,;"无关键字","$or","$in","$nin";
					//查询名字是xixi,城市是anyang的记录,find name == 'xixi' && city == 'anyang'
					db.user.find({"name":"xixi","address.city":"anyang"});
					//查询省份是henan或者hebei的记录,find province == 'henan' || province == 'hebei'
 					db.user.find({"$or":[{"address.province":"henan"},{"address.province":"hebei"}]});
 					//查询省份包含henan或者hebei的记录,find province in ['henan','hebei']
 					db.user.find({"address.province":{"$in":["henan","hebei"]}});
 					//查询省份不包含henan或者hebei的记录,find province not in ['henan','hebei']
 					db.user.find({"address.province":{"$nin":['henan','hebei']}});
 				3、正则表达式:
 					//查询名字以j开头以e结尾的记录,find name startwidth 'h' and  endwidth 'e'
 					db.user.find({"name":/^h/,"name":/e$/});
 					//查询name以e结尾或者省份包含henan或者heebei的记录,
 					//find  name endwidth 'e' || address.province in ['henan','heeber']
 					db.user.find({"$or":[{"name":/e$/},{"address.province":{"$in":["henan","heebei"]}}]});
 				4、$where:
 					//查询这个记录的age < 25的记录,find age < 25
 					db.user.find({$where:function(){return this.age < 25}});
 			3、update:更新
 				1、整体更新://此方法将指定条件的记录的字段名和值替换为当前给定的字段名和值
 					db.user.update({"name":"hehe"},{"name":"xilanhua"});//result: {"_id":ObjectId(),"name":"xilanhua"}
 				2、局部更新:只更新某个键的值,如果有多个符合条件的文档只会修改匹配到的第一个文档
 					1、$inc修改器:(increase);每次修改会在原有的基础上自增$inc指定的值,如果文档中没有key这个值,则会自动创建key
 						//修改name为xixi的文档的age在原有的基础上增加30,_id在前的文档被修改,
 						db.user.update({"name":"xixi"},{"$inc":{"age":30}});//输出结果为age:age+30
 					2、$set:设置符合条件的文档指定的字段的值为当前给定的值,
 						//修改name为xixi的文档的age的值为1200,_id在前的文档被修改,
 						db.user.update({"name":"xixi"},{"$set":{"age":1200}});//输出结果为age:1200
 				3、upsert操作:如果update操作未查到,则在数据库中增加一条记录,需要将第三个参数设置为true
 					//update未查到指定记录则在数据库中增加一个指定的文档
 					db.user.update({"name":"heihei"},{"age":22,"sex":"female","tel":12345678,"hobbit":"hehe"},true);
				4、批量修改:如果update匹配到多个文档,默认只修改第一个文档,第四个参数设置为true,
					//此方法如果未匹配到则增加一条记录,如果匹配到多条则批量修改,
					db.user.update({"name":"xixi"},{"age":30,"phone":9527},true,true);
			4、remove操作:
		6、高级操作:
			1、聚合:
				1、count
				2、distinct
				3、group
				4、markreduce
			2、游标:
	2、MySql数据库: