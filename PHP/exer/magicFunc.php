<?php
  /**
   * __tostring;
   * __invoke;
   */
  class MagicTest1{
    // __tostring会在把对象转化为string时调用
    public function __tostring(){
      return "This is the Class MagicTest...\n";
    }
    // __invoke会在把对象当作一个方法调用的时候调用
    public function __invoke($x){
      echo "__invoke called with parameter ".$x."\n";
    }
  }
  $obj1 = new MagicTest1();
  echo $obj1;
  echo "\n";
  $obj1(5);
  /**
   * __call;
   * __callStatic;
   */
  class MagicTest2{
    // 方法的重载,第一个参数为调用的方法的名称,第二个参数为方法的调用的参数
    public function __call($name,$argments){
      echo "Calling $name with parameters: ".implode(",",$argments)."\n";
    }
    // 静态方法的重载,需要定义为static
    public static function __callStatic($name,$argments){
      echo "Static Calling $name with parameters: ".implode(",",$argments)."\n";
    }
  }
  $obj2 = new MagicTest2();
  $obj2->runTest("param1","param2");
  MagicTest2::runTest("param1","param2");
  /**
   * __get,__set,__isset,__unset
   */
  class MagicTest3{
    public function __get($name){
      return "Getting the property".$name."\n";
    }
    public function __set($name,$value){
      echo "Setting the property ".$name." to value ".$value."\n";
    }
    public function __isset($name){
      echo "__isset invoked\n";
      return fasle;
    }
    public function __unset($name){
      echo "unsetting property $name \n";
    }
  }
  $obj3 = new MagicTest3();
  echo $obj3->className."\n"; // Getting the property classname
  $obj3->className = "MagicClassX";
  echo "$obj->className is set".isset($obj->className)."\n";
  echo "$obj->className is set".empty($obj->className)."\n";
  unset($obj->className);
  /**
   * __clone;
   */
  class NbaPlayer{
    public $name;
  }
  $james = new NbaPlayer();
  $james->name = "James";
  $james2 = clone $james;
 ?>