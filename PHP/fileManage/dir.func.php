<?php
/**
 * [readDirectory 读取文件路径名]
 * @param  [type]                   $path [description]
 * @return [type]                         [description]
 * @author luolei
 * @date   2017-04-08T16:35:44+0800
 * opendir() :打开一个目录路径,返回一个路径句柄
 * readdir() :读取一个路径句柄中的文件名并返回,失败时返回false
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
  /**
   * [dirSize 得到文件大小]
   * @param  [string]                   $path [description]
   * @return [type]                         [description]
   * @author luolei
   * @date   2017-04-09T10:09:43+0800
   */
  function dirSize($path){
    $sum = 0;
    global $sum;
    $handle = opendir($path);
    while (($item = readdir($path)) !== false) {
      if($item != "." && $item != ".."){
        if(is_file($path."/".$item)){
          $sum += filesize($path."/".$item);
        }
        if(is_dir($path."/".$item)){}
          $func = __FUNCTION__;
          $func($path."/".$item);
      }
    }
    closedir($handle);
    return $sum;
  }
  /**
   * [copyFolder description]
   * @param  [string]                   $src [源文件路径名]
   * @param  [string]                   $dst [目标文件路径名]
   * @return [type]                        [description]
   * @author luolei
   * @date   2017-04-09T10:31:23+0800
   * mkdir(param1,param2,param3) :创建目录,
   *   param1: 代表要创建的额多级目录的路径
   *   param2: 设定目录的权限,默认0777,最大访问权限
   *   param3: 表示允许创建多级目录
   */
  function copyFolder($src,$dst){
    if(!file_exists($dst)){
      mkdir($dst,0777,true);
    }
    $handle = opendir($src);
    while (($item = readdir($handle)) !== false) {
      if($item != "." && $item != ".."){
        if(is_file($sec."/".$item)){
          copy($src."/".$item, $dst."/".$item);
        }
        if(is_dir($src."/".$item)){
          $func = __FUNCTION__;
          $func($src."/".$item, $dst."/".$item);
        }
      }
    }
    closedir($handle);
    return "复制成功";
  }
 ?>