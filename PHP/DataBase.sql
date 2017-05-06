数据类型:
  1.字符型:
    1.定长字符:char;字符长度固定,实际值少于定义长度时用空格填充
    2.变长字符:varchar;字符长度不固定,实际值少于定义长度时不用空格填充
    3.文本:text:存储实际字符,但空间至少为2K,适用于长文本数据
  2.数值型:
    1.整数型:(tinyint/smallint/int/bigint);不带小数
      1.tinyint:1B;0~255;
      2.smallint:2B;-32768~32767;
      3.int/integer:4B;-2147483648~2147483647;
      4.bigint:8B;-9223372036854775808~9223372036854775807
    2.精确数值型:(numeric);小数部分
      1.numeric/decimal(p,s);p表示精度,s表示小数所占位数
    3.浮点型:(float/real);近似数值型
      1.float:4B,-3.4E+38~3.4E+38;
      2.real:4B,-3.4E+38~3.4E+38;
    4.货币型:(money/smallmoney);
      1.money:8B,-922337203685477.5808~922337203685477.5807
      2.smallmoney:4B,-214748.3648~214748.3647;
    5.位型:(Bit);表示真或假
      1.Bit:1B,
  3.日期时间型:
    1.smalldatetime:4B
    2.datetime:8B
  4.二进制型:
    1.Binary:
    2.Varibinary:
    3.Image:
  5.其他数据类型:
    1.时间戳型:
    2.唯一标识符型
    3.游标型:
    4.变体型:
    5.通用型:
    6.XML型:
  6. 约束:
    1. 主键约束:PRIMARY KEY
    2. 唯一约束:UNIQUE KEY
    3. 默认约束:DEFAULT
    4. 非空约束:NOT NULL
2017年05月06日
  1.设置默认存储引擎: default-storage-engine=INNODB
  2.查看创建表的引擎: SHOW CREATE TABLE tableName;
  3.显示索引: SHOW INDEXS FROM provinces;
  4.添加外键约束: 
    CREATE TABLE provinces(
      id SMALLINT UNSIGNED PRIMARY KEY AUTO_INCREMENT,
      pname VARCHAR(20) NOT NULL
    );
    CREATE TABLE users(
      id SMALLINT UNSIENED PRIMARY KEY AUTO_INCREMENT,
      username VARCHAR(10) NOT NULL,
      pid SMALLINT UNSIGNED,
      FOREIGN KEY (pid) REFERENCES provinces (id) ON DELETE CASCADE
    );
  5.外键约束的参照(物理约束):
    CASCADE: 从父表删除或更新且自动删除或更新子表中匹配的行
    SET NULL: 从设置父表删除或更新行,并设置子表中的外键列为NULL,如果使用该选项,必须保证子表列约束不为NOT NULL
    RESTRICT: 拒绝对父表的删除或更新操作
    NO ACTION: 标准SQL的关键字,在MYSQL中与RESTRICT相同
  6.表级约束与列级约束:
    对一个数据列建立的约束,列级约束
    对多个数据列建立的约束,表级约束
    表级约束只能在列定义后声明;
  7.修改数据表:
    添加单列: ALTER TABLE tbl_name ADD column_name column_definition [FIRST | AFTER column_name ];
    添加多列: ALTER TABLE tbl_name ADD (column_name column_definition,...);
    删除列:   ALTER TABLE tbl_name DROP column_name1,DROP column_name2,...;
    添加主键/唯一/默认/外键/约束: ALTER TABLE tbl_name ADD PRIMAREY KEY (column_name);
    添加/删除默认约束: ALTER TABLE tbl_name ALTER column_name {SET DEFAULT literal | DROP DEFAULT};
    删除主键约束: ALTER TABLE tbl_name DROP PRIMARY KEY;
    删除唯一约束: ALTER TABLE tbl_name DROP INDEX cloumn_name;
    删除外键约束: ALTER TABLE tbl_name DROP FORIGN KEY column_name;
    修改列定义: ALTER TABLE tbl_name MODIFY column_name column_definition [FIRST | AFTER column_name];
    修改列名称: ALTER TABLE tbl_name CHANGE old_col_name new_col_name column_definition [FIRST | AFTER column_name];
    修改多个表名: RENAME TABLE tbl_name TO new_tbl_name [,tbl_name2 TO new_tbl_name,...];
  8.总结:
    约束: NOT NULL,PRIMARY KEY,UINQUE KEY,DEFAULT,FOREIGN KEY,表级约束,列级约束
    修改数据表:增加/删除字段、列定义、列名称、列定义、表名(两种方式)
  9.操作记录:
    插入记录(insert,insert select,insert set): INSERT [INTO] tbl_name [(column_name,...)] VALUES ({expr | DEFAULT});
    更新记录(单表操作、多表操作): UPDATE tbl_name SET column_name = {expr | DEFAULT},...[WHERE where_condition];
    删除记录(单表操作、多表操作): DELETE FROM tbl_name [WHERE where_condition];
    查找记录: 
      AS:查询字段别名,username AS name
      WHERE:查询条件
      GROUP BY:查询结果分组,[GROUP BY{col_name | position} [ASC | DESC],]
      HAVING:分组条件,SELECT sex FROM users GROUP BY sex HAVING count(id) > 5;
      ORDER BY:查询结果排序,[ORDER BY{col_name | position} [ASC | DESC],]
      LIMIT:限制结果数量,SELECT * FROM tbl_name LIMIT 2,2; // 返回3,4两条记录


create table 系(系编号 char(4),primary key(系编号),foreign key(学院编号) references 学院(学院编号));
alter table 系 add 系名称 varchar(255);
alter table 系 alter 系名称 varchar(20);
alter table 系 drop 系名称;
insert into 系 values("","","","");
insert 系("","","") values("","","");
update 系 set "" = "","" = "" where "" = "";
delete * from 系 where "" = "";

索引:
  1.聚簇索引:索引存放顺序和数据的物理顺序是一致的,一个表只能有一个该索引,
  2.非聚簇索引:
  3.唯一索引:
sp_helpindex 系
drop index 系.系编号


视图:view;从若干个表或已经存在的视图中按照某种条件提取的数据组成的虚表,视图与其引用的数据源之间的关系是相关联的
视图是外模式,是已经编译好的sql语句
表是内模式
create view 系 as





