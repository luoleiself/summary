1.简介:只是让对象原型的写法更加清晰、更像面向对象编程的语法而已
  eg://定义类
    // 类中的方法不需要使用function关键字
    // 类中的成员不需要逗号隔开
    class Point {
      constructor(x, y) {
        this.x = x;
        this.y = y;
      }
      toString() {
        return '(' + this.x + ', ' + this.y + ')';
      }
    }
2.严格模式:类和模块的内部,默认是严格模式,不需要使用use strict指定运行模式
3.constructor方法:必须有,否则会默认指添加一个空的构造方法,必须使用new关键字调用
4.类的实例对象:与 ES5 一样，实例的属性除非显式定义在其本身（即定义在this对象上）,否则都是定义在原型上（即定义在class上）
5.Class表达式:
  eg:const MyClass = class Me {
      getClassName() {
        return Me.name;
      }
    };
    let p = new MyClass();
6.不存在变量提升:
7.私有方法:ES6不提供私有方法,利用Symbol值的唯一性，将私有方法的名字命名为一个Symbol值
  eg:const bar = Symbol('bar');
    const snaf = Symbol('snaf');
    export default class myClass{
      // 公有方法
      foo(baz) {
        this[bar](baz);
      }
      // 私有方法
      [bar](baz) {
        return this[snaf] = baz;
      }
      // ...
    };
8.私有属性:ES6不支持私有属性,#(提案)
9.this的指向:类中的this默认指向类的实例,单独使用类的方法时,报错
  eg:class Logger {
      printName(name = 'there') {
        this.print(`Hello ${name}`);
      }
      print(text) {
        console.log(text);
      }
    }
    const logger = new Logger();
    const { printName } = logger;
    printName(); // TypeError: Cannot read property 'print' of undefined
  1.解决办法:箭头函数、proxy
10.name属性:返回class关键字后面的类名
11.Class的取值函数(getter)和存值函数(setter):
  eg:class MyClass {
      constructor() {
        // ...
      }
      get prop() {
        return 'getter';
      }
      set prop(value) {
        console.log('setter: '+value);
      }
    }
    let inst = new MyClass();
    inst.prop = 123;
    // setter: 123
    inst.prop
    // 'getter
12.Class的Generator方法:在方法名之前加上星号,可以被遍历
  eg:class Foo {
      constructor(...args) {
        this.args = args;
      }
      * [Symbol.iterator]() {
        for (let arg of this.args) {
          yield arg;
        }
      }
    }
    for (let x of new Foo('hello', 'world')) {
      console.log(x);
    }
    // hello
    // world
13.Class的静态方法:类中被static关键字修饰的方法,不能被实例化,只能通过类名调用,可以继承
  eg:class Foo {
      static classMethod() {
        return 'hello';
      }
    }
    Foo.classMethod() // 'hello'
    var foo = new Foo();
    foo.classMethod()
    // TypeError: foo.classMethod is not a function
  eg:class Foo {
      static classMethod() {
        return 'hello';
      }
    }
    class Bar extends Foo {
      static classMethod() {
        return super.classMethod() + ', too';
      }
    }
    Bar.classMethod() // "hello, too"
14.Class的静态属性和实例属性:
  eg:class MyClass {
      static myStaticProp = 42;
      constructor() {
        console.log(MyClass.myStaticProp); // 42
      }
    }
15.new.target属性:返回new命令作用于的那个构造函数,如果构造函数不是通过new命令调用的,则返回undefined
  eg:function Person(name) {
      if (new.target !== undefined) {
        this.name = name;
      } else {
        throw new Error('必须使用new生成实例');
      }
    }
    // 另一种写法
    function Person(name) {
      if (new.target === Person) {
        this.name = name;
      } else {
        throw new Error('必须使用 new 生成实例');
      }
    }
    var person = new Person('张三'); // 正确
    var notAPerson = Person.call(person, '张三');  // 报错

16.继承:通过extends关键字实现继承;
  1.ES5 的继承，实质是先创造子类的实例对象this，然后再将父类的方法添加到this上面（Parent.apply(this)）。
  2.ES6 的继承机制完全不同，实质是先创造父类的实例对象this（所以必须先调用super方法），然后再用子类的构造函数修改this
    eg:class ColorPoint extends Point {
        constructor(x, y, color) {
          super(x, y); // 调用父类的constructor(x, y)
          this.color = color;
        }
        toString() {
          return this.color + ' ' + super.toString(); // 调用父类的toString()
        }
      }
    eg:class Point {
        constructor(x, y) {
          this.x = x;
          this.y = y;
        }
      }
      class ColorPoint extends Point {
        constructor(x, y, color) {
          this.color = color; // ReferenceError
          super(x, y);
          this.color = color; // 正确
        }
      }
17.Object.getPrototypeOf():可以用来从子类上获取父类
  eg:Object.getPrototypeOf(ColorPoint) === Point
    // true
18.super 关键字:可以当作函数使用，也可以当作对象使用
  1.super作为函数调用时,代表父类的构造函数,子类的构造函数必须执行一次super函数,作为函数只能用在子类的构造函数中,其他地方报错
    // A.prototype.constructor.call(this);
    eg:class A {
        constructor() {
          console.log(new.target.name);
        }
      }
      class B extends A {
        constructor() {
          super();
        }
      }
      new A() // A
      new B() // B
  2.super作为对象时，在普通方法中，指向父类的原型对象；在静态方法中，指向父类
    eg:class A {
        p() {
          return 2;
        }
      }
      class B extends A {
        constructor() {
          super();
          console.log(super.p()); // 2
        }
      }
      let b = new B();
    eg:class A {}
      A.prototype.x = 2;
      class B extends A {
        constructor() {
          super();
          console.log(super.x) // 2
        }
      }
      let b = new B();
  3.ES6 规定，通过super调用父类的方法时，super会绑定子类的this
    eg:class A {
        constructor() {
          this.x = 1;
        }
        print() {
          console.log(this.x);
        }
      }
      class B extends A {
        constructor() {
          super();
          this.x = 2;
        }
        m() {
          super.print();
        }
      }
      let b = new B();
      b.m() // 2
19.类的prototype属性和__proto__属性:
  1.子类的__proto__属性，表示构造函数的继承，总是指向父类
  2.子类prototype属性的__proto__属性，表示方法的继承，总是指向父类的prototype属性
    eg:class A {
      }
      class B extends A {
      }
      B.__proto__ === A // true
      B.prototype.__proto__ === A.prototype // true
20.原生构造函数的继承:
  Boolean()
  Number()
  String()
  Array()
  Date()
  Function()
  RegExp()
  Error()
  Object()
21.Mixin模式的实现:将多个类的接口“混入”（mix in）另一个类
  eg:function mix(...mixins) {
      class Mix {}
      for (let mixin of mixins) {
        copyProperties(Mix, mixin);
        copyProperties(Mix.prototype, mixin.prototype);
      }
      return Mix;
    }
    function copyProperties(target, source) {
      for (let key of Reflect.ownKeys(source)) {
        if ( key !== "constructor"
          && key !== "prototype"
          && key !== "name"
        ) {
          let desc = Object.getOwnPropertyDescriptor(source, key);
          Object.defineProperty(target, key, desc);
        }
      }
    }
    class DistributedEdit extends mix(Loggable, Serializable) {
      // ...
    }
    
