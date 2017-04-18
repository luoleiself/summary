<?php
  /**
   *  final:修饰的类不能有子类,修饰的方法不能被重写
   *  overwrite:重写;
   *  子类重写父类方法,方法名一致
   *  1. parent关键字可以调用父类中被子类重写了的方法,父类中定义的静态成员
   *  2. self关键字可以用于访问类自身的成员方法,也可以用于访问自身的静态成员和类常量,不能用于访问类自身的属性;
   *    使用常量的时候不需要在常量名称前面添加$符号;
   *  3. static关键字用于访问类自身定义的静态成员,访问静态属性时需要在属性前面添加$符号
   */
  class BaseClass{
    public static $BaseClassvalue = "Static value in BaseClass class";
    public function test(){
      echo "BaseClass::test called \n";
    }
    // 添加final关键字能够让这个方法不能够在子类中重写
    final public function test1(){
      echo "BaseClass::test1 called \n";
    }
  }
  class ChildClass extends BaseClass{
    const CONST_VALUE = "A Const Value";
    private static $ChildClassValue = "Static value in ChildClass class";
    public function test(){
      echo "ChildClass::test called \n";
      parent::$BaseClassvalue;
      parent::test();
      self::test1();
      self::CONST_VALUE;
      static::$ChildClassValue;
    }
    public function test1(){
      echo "ChildClass::tes1 called \n";
    }
  }
  $obj = new ChildClass();
  $obj -> test();
 ?>