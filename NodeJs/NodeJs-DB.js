1、第十三章:数据库访问
	1、MongoDB数据库:
		1、特点:
			1、存取效率高:在js环境中支持BSON(二进制json对象)的存取,
			2、非阻塞型数据库:将每一条等待插入的数据记录存储到内存中,
			3、语法支持js:可以在查询语句中使用js函数,增加了读取数据的能力,
			4、面向文档的数据库:允许在父记录中存储子记录,
		2、支持数据类型:
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