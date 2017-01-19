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
				1、命名规范:
					1、不能为空字符串
					2、不能包含空格、点、$、/、\0
					3、全部小写
					4、最多64字节
				2、特殊的数据库:
					1、admin:权限数据库,一些特定的服务器命令需要在此运行,例关闭数据库或者服务器
					2、local:这个数据库永远不会被复制,可以用来存储限于本地单台服务器的任意集合
					3、config:当Mongo用于分片设置时,config数据库在内部使用,用于保存分片的信息
					4、test:默认数据库,
			3、文档:是一个键值对(key-value)(BSON),MongoDB的文档不需要设置相同的字段,并且相同的字段不需要相同的数据类型
				1、{"name":"hehe","address":{"province":"henan","city":"xinyang"}}
			4、集合:MongoDB文档组,类似于RDBMS的table,集合存于数据库中,没有固定结构,
				1、命名规范:
					1、集合名不能是空字符串,
					2、集合名不能含有空字符\0,此字符表示集合名的结尾
					3、集合名不能以system.开头,为系统保留字
					4、集合名不能出现保留字
				2、capped collections:固定大小的collections
					1、db.createCollection("name",{capped:true,size:1000000});//创建一个固定大小的集合
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
			12、Double;双精度浮点值
			13、Min/Max keys;将一个值与BSON元素的最低值和最高值相对比
			14、Timestamp;时间戳,记录文档修改或添加的具体时间
			15、Symbol;符号,数据类型类似于字符串,一般采用特殊符号类型的语言
			16、Binary Data;二进制数据
			17、Regular Expression;正则表达式类型
		5、基本操作:
			1、数据库操作:
				1、show dbs;显示全部数据库;新创建的数据库不会显示,需要先插入一条记录
				2、show collections;显示当前数据中所有的集合,
				3、db;显示当前数据库
				4、use DATABASE_NAME;如果数据不存在则创建数据库,否则切换到指定数据库
				5、db.dropDatabase();删除当前数据库,返回一个 Object
				6、db.COLLECTION_NAME.drop();删除集合,返回 Boolean,true删除成功,集合为空时无法执行删除操作,先插入文档然后再删除
				7、db.COLLECTION_NAME.save(document);向集合中插入文档,如果指定了_id字段,则替换集合中指定的文档
				8、pretty();以格式化的方式显示所有文档,
				9、limit(NUMBER);返回匹配到的结果的指定的个数,NUMBER:正整数
 				10、skip(NUMBER);跳过的记录条数,NUMBER:正整数,default:0,
 				11、sort({"key":[1,-1]});对查询到的结果按照指定字段进行排序,1为升序,-1为降序,默认按照升序排序
 				12、db.COLLECTION_NAME.ensureIndex({"key":[1,-1]});将给定的字段进行升序/降序创建索引,
 				13、explain();显示该文档的详细信息
 				14、db.COLLECTION_NAME.getIndexes();获取指定集合的所有索引,返回一个 Object,
 				15、db.COLLECTION_NAME.dropIndex({"key":[1,-1]});删除指定索引,返回一个 Object,{"nIndexesWas" : 2, "ok" : 1 }
 				16、db.isMaster();副本集服务器上判断当前服务器是否是主节点;
 				17、mongostat;MongoDB不支持自带的状态监测工具,在命令状态下回间隔固定时间获取MongoDB的运行状态
 					D:\mongodb\bin>mongostat
 				18、mongotop;MongoDB的内置工具,该工具提供一个方法来跟踪MongoDB的实例,统计时间消费,默认时间为1秒
 					D:\mongodb\bin>mongotop 10 //每10秒统计一次
 			2、集合的操作
				1、Insert:插入
					0、db.COLLECTION_NAME.insert(document);向集合中插入文档,返回一个 Object,如果该集合不存在,则自动创建该集合并插入文档
					1、单条插入:MongoDB控制台是一个JavaScript Shell环境,支持所有的js语法,可以直接使用js语法插入
						var  signle = {"name":"hehe","age":26,"gender":"male","address":{"province":"henan","city":"xinyang"},"favouriate":["football","apple"]}
						var  signle = {"name":"xixi","age":20,"gender":"female","address":{"province":"hebei","city":"anyang"},"favouriate":["basketball","apple"]}
						db.user.insert(signle);
					2、批量插入:实现原理采用for循环插入
				2、Find:查询
					0、db.COLLECTION_NAME.find().pretty();以格式化的方式显示所有文档,
							1、pretty();使用格式化的方式显示所有文档
						db.COLLECTION_NAME.findOne();
						db.COLLECTION_NAME.find(<query>,<projection>);
							1、query;指定查询条件,
							2、projection;显示查询结果的指定字段,1为显示,0为不显示,
						db.user.find({},{"name":1,"address":1,"favouriate":1});//只显示user集合中的三列文档
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
	 				5、$type:检索集合中匹配的数据类型,
	 					1、Double:1,String:2,Object:3,Array:4,Binary Data:5,ObjectId:7,Boolean:8,Date:9,Null:10,Regexp:11,JavaScript:13,
	 					2、Symbol:14,javaScript(width scope):15,32-bit integer:16,Timestamp:17,64-bit integer:18,min key:255,max key:127,
	 					db.user.find({"name":{"$type":2}});//查询name类型为String的文档,
	 			3、update:更新
	 				0、db.COLLECTION_NAME.update(<query>,<update>,{upsert:<boolean>,multi:<boolean>,writeConcern:<document>});更新集合中的指定文档
	 					1、query:查询条件
	 					2、update:update的对象和一些更新的操作符,
	 					3、upsert:如果未匹配到对象,是否插入一条新文档,default:false,不插入
	 					4、multi:如果匹配到多条文档,是否全部更新,default:false,只更新第一条
	 					5、writeConcern:可选,抛出异常的级别
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
				4、remove操作:删除指定的文档
					0、db.COLLECTION_NAME.remove([<query>],[{justOne:<boolean>,writeConcern:<document>}]);
						db.COLLECTION_NAME.remove({});删除集合中的所有文档
						1、query:删除文档的条件,
						2、justOne:如果设为true或者1,则只删除一条文档,
						3、writeConcern:抛出异常的级别,
			3、索引:是特殊的数据结构,存储在一个易于遍历读取的数据集合中,是对数据库表中一列或多列的值进行排序的一种结构
				db.COLLECTION_NAME.ensureIndex({"key":[1,-1]});将给定的字段按照升序/降序方式创建索引,可以创建多个索引
				1、可接收的参数:
					1、background:Boolean,default:false,指定索引以后台方式创建,建立索引时会阻塞其他数据库操作,可以指定此方式
					2、unique:Boolean,default:false,指定索引是否唯一
					3、name:String,索引名称,如果未指定,MongoDB通过连接索引的字段名和排序方式生成一个索引
					4、dropDups:Boolean,default:false,建立唯一索引是否删除重复记录,
					5、sparse:Boolean,default:false,对文档不存在的字段数据不启用索引,
					6、expireAfterSeconds:Integer,设定集合的生存时间,单位为秒;
					7、v:index version;索引的版本号,默认版本号取决于MongoDB创建索引时运行版本
					8、weights:document,索引权重值,范围1 ~ 99999之间,表示该索引相对于其他索引字段的得分权重
					9、default_language:String,default:English,对于文本索引,决定了停用词及词干和词器的规则的列表,
					10、language_override:String,default:language,对于文本索引,指定了包含在文档中的字段名,语言覆盖默认的language,
				db.user.ensureIndex({"name":1,"age":-1},{background:true});在后台创建user集合的索引字段,
				2、单索引:(Signle Field Index);MongoDB默认创建的_id索引
				3、复合索引:(Compound Index);针对多个字段联合创建索引,
					//首先按照第一索引字段进行排序,当第一个索引字段相同时按照第二个索引字段进行排序
					db.COLLECTION_NAME.ensureIndex({"key":[1,-1],"key":[1,-1]});
				4、多key索引:(Multikey Index);索引的字段为一个数组时,多key索引会为数组中的每一个建立一条索引
			4、主从复制:
				1、第一步:我们把mongodb文件夹放在D盘和E盘，模拟放在多服务器上
				2、第二步:启动D盘上的mongodb，把该数据库指定为主数据库,端口还是默认的27017
					>mongodb --dbpath='XXX' --master //创建MongoDB数据库主服务器
				3、第三步:同样的方式启动E盘上的mongodb，指定该数据库为从属数据库
					//创建MongoDB数据库从服务器并连接主服务器
					>mongod --dbpath=xxxx --port=8888 --slave --source=127.0.0.1:27017 
			5、副本集:主从集群数据库,
				1、第一步:既然我们要建立集群，就得取个集群名字，这里就取我们的公司名shopex, --replSet表示让服务器知道shopex下还有其他数据库，
						这里就把D盘里面的mongodb程序打开，端口为2222。指定端口为3333是shopex集群下的另一个数据库服务器
					>mongod --dbpath  D:\mongodb\data\db --port 2222 --replSet colony/127.0.0.1:3333
				2、第二步:既然上面说3333是另一个数据库服务器,不要急,现在就来开,这里把E盘的mongodb程序打开
					>mongod --dbpath  E:\mongodb\data\db --port 3333 --replSet colony/127.0.0.1:2222
				3、第三步:ok，看看上面的日志红色区域，似乎我们还没有做完，是的，log信息告诉我们要初始化一下“副本集“，既然日志这么说，那我也就
						这么做，随便连接一下哪个服务器都行，不过一定要进入admin集合
					>mongo 127.0.0.1:2222/admin
					>var confi = {"replSetInitiate":{"_id":"colony","members":[{"_id":1,"host":"127.0.0.1:2222"},{"_id":2,"host":"127.0.0.1:3333"}]}};
					>db.runCommand(confi);
				4、第四步:开启成功后，我们要看看谁才能成为主数据库服务器，可以看到端口为2222的已经成为主数据库服务器
				5、第五步:我们知道sql server里面有一个叫做仲裁服务器，那么mongodb中也是有的，跟sql server一样，仲裁只参与投票选举，这里我们
						把F盘的mongodb作为仲裁服务器，然后指定shopex集群中的任一个服务器端口，这里就指定2222
					>mongod --dbpath  F:\mongodb\data\db --port 4444 --replSet colony/127.0.0.1:2222
				6、服务器已经开启后,可以在admin集合中使用rs.addArb("hostname:port")追加新添加的服务器即可,
				7、使用rs.status()来查看下集群中的服务器状态，图中我们可以清楚的看到谁是主，还是从，还是仲裁
				8、需要配置集群数据库的查询功能:rs.slaveOk()
			6、分片技术:将集合进行拆分成,拆分后的数据均摊到几个片上
				1、概念:
					1、mongos:片键,mongos是一个路由服务器,它会根据管理员设置的片键将数据分摊到自己管理的mongod集群,
						数据和片的对应关系以及相应的配置信息保存在config服务器上
					2、mongod:一个普通的数据库实例,如果不分片的话会直接连上mongod
				2、操作:
					1、首先我们准备4个mongodb程序，我这里是均摊在C，D，E，F盘上，当然你也可以做多个文件夹的形式
					2、开启config服务器:C:\mongodb\bin>mongod --dbpath C:\mongodb\bin --port 2222
					3、开启mongos服务器:D:\mongodb\bin>mongos --port 3333 --configdb 127.0.0.1:2222
					4、启动mongod服务器:对分片来说,也就是要添加片了,这里开启E，F盘的mongodb,端口为:4444，5555
						E:\mongodb\bin>mongod --dbpath E:\mongodb\bin --prot 4444
						F:\mongodb\bin>mongod --dbpath F:\mongodb\bin --prot 5555
					5、服务配置:addshard();
			7、数据备份和恢复:
				1、copy:将服务器暂时关闭才能进行操作,然后重启服务器
				2、mongodump,mongorestore:
					1、mongodump -h dbhost -d dbname -o dbdirectory
					2、mongorestore -h hostname -d dbname -drop dbbackup
						-h:服务器地址
						-d:需要备份的数据库实例
						-o:备份的数据库的存放位置
						-drop:恢复时,先删除当前数据,再进行恢复,恢复完成后删除备份数据
					>mongodump --port 2222 -d test -o D:\mongodb\backup
					>mongorestore --port 2222 -d test -drop D:\mongodb\backup\test
				3、加锁:db.runCommand({"fsync":1,"lock":1});
				4、解锁:db.$cmd.unlock.findOne()
		6、高级操作:
			1、http:\/\/www.runoob.com/mongodb/mongodb-aggregate.html
				1、聚合:db.COLLECTION_NAME.aggregate(AGGREGATE_OPERATION);
					1、$sum:计算总和;
						db.mycol.aggregate([{$group:{_id:"$by_user", num_tutorial:{$sum : "$likes"}}}])
					2、$avg:计算平均值;
						db.mycol.aggregate([{$group:{_id:"$by_user", num_tutorial:{$avg : "$likes"}}}])
					3、$min:获取集合中所有文档对应值的最小值;
						db.mycol.aggregate([{$group:{_id:"$by_user", num_tutorial:{$min : "$likes"}}}])
					4、$max:获取集合中所有文档对应值的最大值;
						db.mycol.aggregate([{$group:{_id:"$by_user", num_tutorial:{$max : "$likes"}}}])
					5、$push:在结果文档中插入值到一个数组中;
						db.mycol.aggregate([{$group:{_id:"$by_user", url:{$push: "$url"}}}])
					6、$addToSet:在结果文档中插入值到一个数组中,但不创建副本;	
						db.mycol.aggregate([{$group:{_id:"$by_user", url:{$addToSet : "$url"}}}])
					7、$first:根据资源文档的排序获取第一个文档数据;	
						db.mycol.aggregate([{$group:{_id:"$by_user", first_url:{$first : "$url"}}}])
					8、$last:根据资源文档的排序获取最后一个文档数据;
						db.mycol.aggregate([{$group:{_id:"$by_user", last_url:{$last : "$url"}}}])
				2、管道操作:
					1、$project:修改输入文档的结构;
						db.user.aggregate({$project:{title:1,author:1}});//输出结果只有_id,title,author三个字段,
					2、$match:用于过滤数据,只输出符合条件的文档;
						//$match用于获取分数大于70小于或等于90记录,然后将符合条件的记录送到下一阶段$group管道操作符进行处理
						db.atticals.aggregate([
							{$match:{score:{$gt:70,$lte:90}}},
							{$group:{ _id:null,count:{$sum:1}}}
						])
					3、$limit:用来限制MongoDB聚合管道返回的文档数;
						db.articals.aggregate({$limit:5});//经过管道处理后,返回前5个文档,
					4、$skip:在聚合管道中跳过指定的文档,返回剩余的文档;
						db.articals.aggregate({$skip:5});//经过管道处理后,过滤掉前5个文档,
					5、$unwind:将文档的某个数组类型字段拆分为多条,每条包含数组中的一个值;
					6、$group:将集合中的文档分组,可用于统计结果;
					7、$sort:将输入文档排序输出;
					8、$geoNear:输出接近某一地理位置的有序文档;
			2、http:\/\/www.cnblogs.com/huangxincheng/archive/2012/02/21/2361205.html
				1、db.COLLECTION_NAME.count():统计符合条件的文档的个数,返回 Number
					db.user.count({"address.province":"henan"});//统计省份是henan的文档,1
				2、db.COLLECTION_NAME.distinct();统计指定字段的不重复的值,返回一个 Array
					db.user.distinct("name");返回name不重复的值组成的数组
				3、db.COLLECTION_NAME.group();将文档进行分组输出;
					1、key:指定分组的id,
					2、initial:每组分享一个初始化函数,为每一个分组创建一个存储值的容器,
					3、$reduce:Function,第一个参数为当前的文档对象,第二个参数为上一次function累计操作的对象,
						调用次数根据initial初始化的容器的长度有关
					4、condition:可选,过滤条件,
					5、finalize:Function,可选,每一组文档执行完毕后都会触发该函数,
					db.person.insert({"name":"jack","age":20});
					db.person.insert({"name":"jackson","age":22});
					db.person.insert({"name":"joe","age":26});
					db.person.insert({"name":"mary","age":20});
					db.person.insert({"name":"alice","age":22});
					db.person.insert({"name":"maria","age":25});
					db.person.group({
						"key":{"age":true},
						"initial":{"person":[]},
						"reduce":function(doc,out){out.person.push(doc.name);},
						"finalize":function(out){out.count = out.person.length;},
						"condition":{"age":{"$gt":20}}
					})
				4、mapReduce:是一种编程模式,用在分布计算中,其中包含了一个map函数和一个reduce函数;
					1、map:映射函数,里面会调用emit(key,value),集合会按照你指定的key进行映射分组
					2、reduce:简化函数,会对map分组的数据进行简化,
					3、mapReduce:最后执行的函数;
						1、result:存放的集合名;
						2、input:传入文档的个数;
						3、emit:此函数被调用的次数;
						4、reduce:此函数被调用的次数;
						5、output:最后返回文档的个数;
			3、游标:
	2、MySql数据库: