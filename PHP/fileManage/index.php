<?php
  /**
   * [$ext description]
   * @var [type]
   * explode()  :使用一个字符串分割另一个字符串,返回一个数组
   * end()  :将数组的指针指向最后一个元素,并返回其值
   * strtolower() :将一个字符串转换成小写
   */
  $ext = strtolower(end(explode(".", $val)));
  $imageExt = array("gif","jpg","jpeg","png");
  if(in_array($ext, $imageExt)){

  }else{

  }
 ?>