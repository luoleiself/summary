2017年05月13日
  1.数值运算符:
	  CEIL();进一取整,CEIL(3.01); # 4
	  FLOOR();减一取整,FLOOR(3.01); # 3
	  DIV();整数除法,DIV(3/4); # 0
	  MOD();取余数
	  POWER();幂运算
	  ROUND();四舍五入
	  TRUNCATE();数字截取
  2.比较运算符:
	  [NOT]BETWEEN... AND...;[不]在范围之内
	  [NOT]IN();[不]在列出值范围内
	  IS [NOT] NULL;[不]为空
  3.日期时间函数:
	  NOW();当前日期和时间
	  CURDATE();当前日期
	  CURTIME();当前时间
	  DATE_ADD();日期变化
	  DATEDIFF(date1,date2);获取两个日期时间之间的差值
	  DATE_FORMAT();日期格式化
  4.信息函数:
	  CONNECTION_ID();连接ID
	  DATEBASE();当前数据库
	  LAST_INSERT_ID();最后插入记录的id
	  USER();当前用户
	  VERSION();版本信息
  5.聚合函数:
	  AVG();平均值
	  COUNT();计数
	  MAX();最大值
	  MIN();最小值
	  SUM();求和
  6.加密函数:
	  MD5();信息摘要算法
	  PASSWORD();密码算法
