<?php
/**
 * [readDirectory 读取文件路径名]
 * @param  [type]                   $path [description]
 * @return [type]                         [description]
 * @author luolei
 * @date   2017-04-08T16:35:44+0800
 */
  function readDirectory($path){
    $handle = opendir($path); // 打开指定目录
    while(($item = readdir($handle)) !== false){
      // ".":当前目录,"..":上级目录
      if($item != "." && $item != ".."){
        if(is_file($path."/".$item)){
          $arr["file"][] = $item;
        }
        if(is_dir($path."/".$item)){
          $arr["dir"][] = $item;
        }
      }
    }
    closedir($handle); // 关闭目录句柄
    return $arr;  
  }
 ?>