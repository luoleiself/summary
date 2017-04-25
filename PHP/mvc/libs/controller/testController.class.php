<?php
  class testController{
    function show(){
      // $testModel = new testModel(); // 实例化一个模型对象
      $testModel = M("test");
      $data = $testModel->get();
      // $testView = new testView(); // 实例化一个视图对象
      $testView = V("test");
      $testView->display($data);
    }
  }
?>