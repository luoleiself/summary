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
  /**
   * [renameFolder 重命名文件夹]
   * @param  [string]                   $oldname [旧文件夹名称]
   * @param  [string]                   $newname [新文件夹名称]
   * @return [type]                            [description]
   * @author luolei
   * @date   2017-04-09T10:53:57+0800
   */
  function renameFolder($oldname,$newname){
    if(checkFilename(basename($newname))){
      if(!file_exists($newname)){
        if(rename($oldname, $newname)){
          $mes = "重命名成功";
        }else{
          $mes = "重命名失败";
        }
      }else{
        $mes = "存在同名文件";
      } 
    }else{
      $mes = "非法文件夹名称";
    }
    return $mes;
  }
  /**
   * [cutFolder 剪切文件夹]
   * @param  [string]                   $src [源文件夹名称]
   * @param  [string]                   $dst [目标文件夹名称]
   * @return [type]                        [description]
   * @author luolei
   * @date   2017-04-09T11:09:05+0800
   */
  function cutFolder($src,$dst){
    if(file_exists($dst)){
      if(is_dir($dst)){
        if(!file_exists($dst."/".basename($src))){
          if(rename($src,$dst."/".basename($src))){
            $mes = "剪切成功";
          }else{
            $mes = "剪切失败";
          }
        }else{
          $mes = "存在同名文件夹";
        }
      }else{
        $mes = "不是一个文件夹";
      }
    }else{
      $mes = "目标文件夹不存在";
    }
    return $mes;
  }
  /**
   * [delFolder 删除文件夹]
   * @param  [string]                   $path [源文件夹路径]
   * @return [type]                         [description]
   * @author luolei
   * @date   2017-04-09T11:24:45+0800
   */
  function delFolder($path){
    $handle = opendir($path);
    while (($item = readdir($handle)) !== false) {
      if($item != "." && $item != ".."){
        if(is_file($path."/".$item)){
          unlink($path."/".$item);
        }
        if(is_dir($path."/".$item)){
          $func = __FUNCTION__;
          $func($path."/".$item);
        }
      }
    }
    closedir($handle);
    rmdir($path);
    return "文件夹删除成功";
  }
 ?>