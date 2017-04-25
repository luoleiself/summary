<?php
  // 规定url请求格式:index.php?controller=...&method=...
  require_once("function.php");
  $controllerAllow = array("test","index");
  $methodAllow = array("test","index");
  $controller = in_array($_GET["controller"],$controllerAllow)?paramsOrder($_GET["controller"]):"index";
  $method = in_array($_GET["method"],$methodAllow)?paramsOrder($_GET["method"]):"index";
  C($controller,$method);
?>