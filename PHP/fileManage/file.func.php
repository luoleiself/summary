<?php 
  //Bytes/KB/MB/GB/TB/EB
  function transByte($size){ // 转换字节大小
    $arr = array("B","Byte","KB","MB","GB","TB","EB");
    $i = 0;
    while ($size > 1024) {
      $size /= 1024;
      $i++;
    }
    return round($size,2).$arr[$i];
  }
  function createFile($filename){
    // 验证文件名的合法性,是否包含/<>\*?:"|
    $pattern = "/[\/,\*,<>,\?\|]/";
    if(preg_match($pattern,basename($filename))){
      if(!file_exists($filename)){
        if(touch($filename)){
          return "文件创建成功";
        }else{
          return "文件创建失败";
        }
      }else{
        return "文件已存在,请重新命名后创建";
      }
    }else{
      return "非法文件名";
    }
  }
 ?>