<?php
  /**
   * 可以使用instanceof判断某个对象是否实现了某个接口
   * 类的方法必须有实现,接口的方法必须为空
   */
  interface ICanEat{
    // 接口里面的方法不需要有方法的实现;
    public function eat($food);
  }
  interface ICanPee extends ICanEat{
    public function pee();
  }
  class Human implements ICanEat{
    public function eat($food){
      echo "Human eating ... $food";
    }
  }
  class Animal implements ICanEat{
    public function eat($food){
      echo "Animal eating ... $food";
    }
  }
  /**
   * 多态:多个类实现一个接口,同时实现接口里面方法的不同具体的定义
   */
 ?>