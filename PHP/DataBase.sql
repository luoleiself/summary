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





