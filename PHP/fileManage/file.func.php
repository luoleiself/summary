<?php 
  /**
   * [transByte 文件大小查看]
   * @param  [type]                   $size [description]
   * @return [type]                         [description]
   * @author luolei
   * @date   2017-04-08T16:22:56+0800
   */
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
  /**
   * [createFile 创建文件]
   * @param  [string]                   $filename [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-08T16:22:18+0800
   */
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
  /**
   * [renameFile 文件重命名]
   * @param  [string]                   $oldname [description]
   * @param  [string]                   $newname [description]
   * @return [type]                            [description]
   * @author luolei
   * @date   2017-04-08T16:21:57+0800
   */
  function renameFile($oldname,$newname){
    //验证文件名是否合法
    if(checkFilename($newname)){ 
      $path = dirname($oldname);
      // 检测当前目录下是否存在同名文件
      if(!file_exists($path."/".$newname)){
        // 进行重命名
        if(rename($oldname,$path."/".$newname)){
          return "重命名成功";
        }else{
          return "重命名失败";
        }
      }else{
        return "存在同名文件,请重新命名";
      }
    }else{
      return "非法文件名";
    }
  }
  /**
   * [checkFilename 检测是否重名]
   * @return [type]                   [description]
   * @author luolei
   * @date   2017-04-08T16:23:54+0800
   */
  function checkFilename($filename){
    $pattern = "/[\/,\*,<>,\?\|]/";
    return preg_match($patter, $filename) ? false : true;
  }
  /**
   * [delFile 删除文件]
   * @param  [string]                   $filename [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-08T16:36:45+0800
   * unlink() :删除文件
   */
  function delFile($filename){
    if(unlink($filename)){
      $msg = "删除成功";
    }else{
      $msg = "删除失败";
    }
    return $msg;
  }
  /**
   * [downFile 下载文件]
   * @param  [string]                   $filename [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-08T16:43:11+0800
   * readfile() :输出一个文件,读入一个文件并写入到输出缓冲中
   */
  function downFile($filename){
    header("Content-Disposition:attachment;filename=".$filename);
    header("Content-Length:".filesize($filename));
    readfile($filename);
  }
  /**
   * [copyFile 拷贝目录]
   * @param  [type]                   $filename [description]
   * @param  [type]                   $dstname  [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-09T11:32:38+0800
   */
  function copyFile($filename,$dstname){
    if(file_exists($dstname)){
      if(!file_exists($dstname."/".basename($filename)){
        if(copy($filename,$dstname."/".basename($filename))){
          $mes = "文件复制成功";
        }else{
          $mes = "文件复制失败";
        }
      }else{
        $mes = "存在同名文件";
      }
    }else{
      $mes = "目标路径不存在";
    }
    return $mes;
  }
  /**
   * [cutFile 剪切文件]
   * @param  [type]                   $filename [description]
   * @param  [type]                   $dstname  [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-09T11:36:45+0800
   */
  function cutFile($filename,$dstname){
    if(file_exists($dstname)){
      if(!file_exists($dstname."/".basename($filename)){
        if(rename($filename,$dstname."/".basename($filename))){
          $mes = "文件复制成功";
        }else{
          $mes = "文件复制失败";
        }
      }else{
        $mes = "存在同名文件";
      }
    }else{
      $mes = "目标路径不存在";
    }
    return $mes;
  }
  /**
   * [uploadFile 上传文件]
   * @param  [type]                   $fileInfo [description]
   * @param  [type]                   $path     [description]
   * @param  array                    $allowExt [description]
   * @param  integer                  $maxSize  [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-09T12:00:47+0800
   * pathinfo(string $path [, int $options = PATHINFO_DIRNAME | PATHINFO_BASENAME | PATHINFO_EXTENSION | PATHINFO_FILENAME ]) 
   *   :返回一个关联数组包含有 path 的信息。返回关联数组还是字符串取决于 options
   *  is_upload_file($string) :判断文件是否是通过 HTTP POST 上传的
   *  move_upload_file(string $filename , string $destination) :将上传的文件移动到新位置
   */
  function uploadFile($fileInfo,$path,$allowExt = array("gif","jpeg","jpg","png"),$maxSize = 10485760){
    if($fileInfo["error"] == UPLOAD_ERR_OK){
      if(is_uploaded_file($fileInfo["temp_name"])){
        $ext = getExt($fileInfo["name"]);
        $uniquid = getUniqidName();
        $destination = $path.pathinfo($fileInfo["name"],PATHINFO_FILENAME)."_".$uniqid.".".$ext;
        if(in_array($ext,$allowExt)){
          if($fileInfo["size"] <= $maxSize){
            if(move_uploaded_file($fileInfo["temp_name"],$destination)){
              $mes = "文件上传次成功";
            }else{
              $mes = "文件移动失败";
            }
          }else{
            $mes = "文件过大";
          }
        }else{
          $mes = "非法文件";
        }
      }else{
        $mes = "文件不是通过HTTP POST方式上传上来的";
      }
    }else{
      switch ($fileINf["error"]) {
        case 1:
          $mes = "超过了配置文件的大小";
          break;
        case 2:
          $mes = "超过了表单允许接收数据的大小";
          break;
          case 3:
          $mes = "文件部分被上传";
          break;
      }
    }
    return $mes;
  }
  ?>