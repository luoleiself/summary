<?php 
  // 启用session,该方法必须位于顶部;
  session_start(); 
  // 创建一个真彩色图像,默认返回黑色北京
  $image = imagecreatetruecolor(100, 30);
  // 为一幅图像分配颜色
  $bgcolor = imagecolorallocate($image,255,255,255);
  // 区域填充
  imagefill($image, 0, 0, $bgcolor);

  // 随机生成数字;
  /*for ($i=0; $i < 4; $i++) { 
    $fontsize = 8;
    $fontcolor = imagecolorallocate($image,rand(0,120),rand(0,120),rand(0,120));
    $fontcontent = rand(0,9);
    $x = ($i * 100 / 4) + rand(5,10);
    $y = rand(5,10);
    // 水平地画一行字符串
    imagestring($image,$fontsize,$x,$y,$fontcontent,$fontcolor);
  }*/
  $captch_code = "";
  // 随机生成字母和数字
  /*for ($i=0; $i < 4; $i++) { 
    $fontsize = 22;
    $fontcolor = imagecolorallocate($image,rand(0,120),rand(0,120),rand(0,120));
    $data = 'abcdefghijkmnpqrstuvwxyz23456789';
    $fontcontent = substr($data,rand(0,strlen($data)),1);
    $captch_code .= $fontcontent;

    $x = ($i * 100 / 4) + rand(5,10);
    $y = rand(5,10);

    imagestring($image,$fontsize,$x,$y,$fontcontent,$fontcolor);
  }*/
  // 中文验证码
  $fontface = "ttfFileName";
  $strdb = array("木","可","往","咱");
  for ($i=0; $i < ; $i++) { 
    $fontcolor = imagecolorallocate($image,rand(0,120),rand(0,120),rand(0,120));
    $cd = $strdb[$i];
    $captch_code = $cn;

    imagettftext($image,mt_rand(20,24),mt_rand(-60,60),mt_rand(40*$i+20),mt_rand(30,35),$fontcolor,$fontface,$cn);
  }
  $_SESSION["authcode"] = $captch_code; // 保存session信息
  // 创建干扰点
  for ($i=0; $i < 200; $i++) { 
    $pointcolor = imagecolorallocate($image,rand(50,200),rand(50,200),rand(50,200));
    // 增加干扰点
    imagesetpixel($image, rand(1,99), rand(1,29), $pointcolor);
  }
  // 创建干扰线
  for ($i=0; $i < 4; $i++) { 
    $linecolor = imagecolorallocate($image,rand(80,220),rand(80,220),rand(80,220));
    // 增加干扰线
    imageline($image,rand(1,99),rand(1,29),rand(1,99),rand(1,29),$linecolor);
  }
  header("Content-type:image/png");
  imagepng($image);

  // 删除
  imagedestroy($image);
 ?>