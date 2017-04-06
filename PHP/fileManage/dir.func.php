<?php 
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