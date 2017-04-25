<?php
  // 创建控制器方法
  function C($name,$method){
    require_once("/libs/controller/".$name."Controller.class.php");
    eval("$obj = new ".$name."();$obj->".$method."();");
  }
  C("test","show");
  // 创建模型方法
  function M($name){
    require_once("/libs/model/".$name."Model.class.php");
    eval("$obj = new ".$name."Model();");
    return $obj;
  }
  // 创建视图方法
  function V($name){
    require_once("/libs/view/".$name."View.class.php");
    eval("$obj = new ".$name."View();");
    return $obj;
  }
  
  // 参数格式规范
  function paramsOrder($str){
    return (!get_magic_quotes_gpc()) ? paramsOrder($str):$str;
  }
?>