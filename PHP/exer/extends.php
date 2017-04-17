<?php
  /**
   * extends:类的继承;
   * public;protected;private;访问控制
   * static:
   *   1,静态属性定义时,在访问控制关键字后面添加static关键字即可,
   *   2,在类定义中使用静态成员的时候,使用self关键字后面跟双冒号和$符号
   *   3,在类定义外部访问静态属性,使用类名后面跟双冒号和$符号
   */
  class Human{
    public $name;
    protected $height;
    public $weight;
    private $isHungry = true;
    public function eat($food){
      echo "eating...\n";
    }
    public function info(){
      return $isHungry;
    }

    public static $value = "Static value in Human class";
  }
  class NbaPlayer extends Human{
    private $age;
    public function getAge(){
      return $this->age;
    }
    
    /**
     * 1. 静态属性用于保存类的公有数据
     * 2. 静态方法里面只能访问静态属性
     * 3. 静态成员不需要实例化对象就可以访问
     * 4. 类的内部可以通过self,static关键字访问自身静态成员
     * 5. 可以通过parent关键字访问父类的静态成员
     * 6. 可以通过类的名称在类的外部访问类的静态成员
     */
    public static $president = "David Stern";
    public static changePresident(){
      echo self::$president;
      //echo static::$president;
      echo parent::$value;
    }

  }
  $jordan = new NbaPlayer();
  $jordan -> info();
 ?>