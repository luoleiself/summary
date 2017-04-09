<?php
  /**
   * [getExt 获取文件基本信息]
   * @param  [string]                   $filename [description]
   * @return [type]                             [description]
   * @author luolei
   * @date   2017-04-09T11:49:38+0800
   */
  function getExt($filename){
    return strtolower(pathinfo($filename,PATHINFO_EXTENSION));
  }
  /**
   * [getUniqidName 获取文件名唯一标识符]
   * @param  integer                  $length [description]
   * @return [type]                           [description]
   * @author luolei
   * @date   2017-04-09T11:56:08+0800
   * md5(string $str [, bool $raw_output = false ]) : 计算字符串的 MD5 散列值
   * uniqid(([ string $prefix = "" [, bool $more_entropy = false ]]) :生成一个唯一ID
   * microtime(([ bool $get_as_float ]) :返回当前 Unix 时间戳和微秒数
   * substr() :截取字符串
   */
  function getUniqidName($length = 10){
    return substr(md5(uniqid(microtime(true),true)),0,$length);
  }
 ?>