<?php 
  1. File:
    1. file_get_contents($filePath); // 获取文件内容到一个字符串中
    2. is_file($filePath); // 判断给定的路径是否是一个文件;
    3. file_exists($filePath); // 判断文件是否存在;
    4. is_readable($filePath); // 判断文件是否可读
    5. is_writable($filePath); // 判断文件是否可写
    6. fileowner($filePath); // 获取文件的所有者
       filectime($filePath); // 获取文件的创建时间
       filemtime($filePath); // 获取文件的修改时间
       fileatime($filePath); // 获取文件的访问时间
       filesize($filePath); // 获取文件的大小
  2. time:
    1. time(); // 获取服务器当前时间,返回值为当前距离1970年1月1日的0时0分的毫秒数
    2. date_default_timezone_set('Asia/Shanghai'); // 设置时区
    3. date(formatter,date); // 格式化日期函数
      eg:date("y-m-d","18530076746");
    4. strtotime(date); // 获取某个时间的时间戳,单位毫秒数  
      eg:strtotime("2017-4-3");
      eg:strtotime("+5 seconds"); // 解析为unix时间戳
    5. gmdate(formatter,date); // 格式化一个格林威治标准的时间
      eg:gmdate('Y-m-d H:i:s',strtotime("2014-05-01 12:00:01")); // 2014-05-01 04:00:01
  3. GD:
    1. $img = imagecreatetruecolor(100,100);  // 创建一个画布
    2. imagecolorallocate($img, 0xff, 0x00, 0x00); // 对画笔分配颜色
    3. imageline($img,0,0,100,100,$red); // 绘制线条
    4. header("content-type:image/png"); // 输出图像
    5. imagepng($img,"img.png"); // 输出图像保存到文件中
       imagejpeg($img,"img.jpg");
       imagegif($img,"img.gif");
    6. imagedestroy($img); // 删除图像
    7. imagestring(resource $image,int $font,int $x,int $y,string $s,int $col); // 绘制文字
      $font:设置文字大小;
      $x,$y:设置文字位置;
      $s:绘制的文字;
      $col:文字的颜色;
      rg:imagestring($img,5,0,0,"hello world",$red);
    8. imagesetpixel($im,rand(0,100),rand(0,100),$black); // 绘制噪点干扰线段
    9. $im = imagecreatefromjpeg(filename); // 从图片文件创建图像
    10. $logo = imagecreatefrompng(filename); 
    11. imagecopy($im,$logo,15,15,0,0,$width,$height);



 ?>