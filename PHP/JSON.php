<?php 
  JSON:(Javascript Object Nation),一种轻量级的数据交换格式
    1. 标量(scalar)
    2. 序列(sequence)
    3. 映射(mapping)
  原则:
    1. 并列的数据之间用逗号分割
    2. 映射用冒号表示
    3. 并列数据的集合(数组)用方括号([])表示
    4. 映射的集合(对象)用大括号({})表示
  缺点:
    1. 字符集必须是Unicode,受约束性强
    2. 语法过于严谨
  JSON/serialize:
    1. 都是把其他数据类型转换成一个可以传输的字符串
    2. 都是结构性数据
    1. serialize序列化后的数据格式保存 数据原有类型
    2. JSON数据格式要更简洁
  json_encode($param);
    索引数组->JSON:JSON字符串结构和索引数组结构一致
    关联数组->JSON:JSON字符串结构以对象方式显示
  json_decode($param,[boolean]);
    JSON->索引数组:结构和索引数组结构一致
    JSON->关联数组:以对象方式显示,当第二个参数为true,可以将对象转换成关联数组显示

    
 ?>