<?php
  /**
   * abstract关键字用于定义抽象类
   */
  abstract class ACanEat{
    // 抽象类中至少有一个抽象方法时,该类就定义为抽象类
    abstract public function eat($food);
    public function breath(){
      echo "Breath use the air...\n";
    }
  }
  class Human extends ACanEat{
    // 继承抽象类的子类需要实现抽象类中定义的抽象方法
    public function eat($food){
      echo "Human eating ... $food\n";
    }
  }
  class Animal extends ACanEat{
    public function eat($food){
      echo "Animal eating ... $food\n";
    }
  }
  $obj = new Human();
  $obj->eat("food");
  $obj->breath();
  $monkey= new Animal();
  $monkey->eat("food");
  $monkey->breath();
 ?>