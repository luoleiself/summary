/**
 * 1. 原型链继承
 * 重点：让新实例的原型等于父类的实例。
 * 特点：1、实例可继承的属性有：实例的构造函数的属性，父类构造函数属性，父类原型的属性。（新实例不会继承父类实例的属性！）
 * 缺点：1、新实例无法向父类构造函数传参。
 *      2、继承单一。
 *      3、所有新实例都会共享父类实例的属性。（原型上的属性是共享的，一个实例修改了原型属性，另一个实例的原型属性也会被修改！）
 *
 */
function Person(name) {
  this.name = name;
}
Person.prototype.say = function () {
  return this.name;
};
function Per() {}
Per.prototype = new Person();
var per = new Per();
console.log(per);

/**
 * 2. 借助构造函数
 * 重点：用.call()和.apply()将父类构造函数引入子类函数（在子类函数中做了父类函数的自执行（复制））
 * 特点：1. 只继承父类构造函数的属性，没有继承父类原型的属性；
 *      2. 解决了无法向父类构造函数传参，
 *      3. 可以继承多个构造函数属性（call多个）。
 * 缺点：1、只能继承父类构造函数的属性。
 *　　　 2、无法实现构造函数的复用。（每次用每次都要重新调用）
 *　　　 3、每个新实例都有父类构造函数的副本，臃肿。
 */
function Con() {
  Person.call(this, 'gg');
  this.age = 18;
}
var con = new Con();

/**
 * 3. 组合继承(原型+借用构造)
 * 重点：结合了两种模式的优点，传参和复用
 * 特点：1、可以继承父类原型上的属性，可以传参，可复用。
 *　　　　2、每个新实例引入的构造函数属性是私有的。
 * 缺点：调用了两次父类构造函数（耗内存），子类的构造函数会代替原型上的那个父类构造函数。
 */
function SubType(name) {
  Person.call(this, name);
}
SubType.prototype = new Person();
var sub = new SubType('sub');
/**
 * 4. 寄生式继承
 *  借助原型可以基于已有的对象创建新对象，同时还不必须因此创建自定义的类型
 */
function content(obj) {
  function F() {}
  F.prototype = obj;
  return new F();
}
var sup = new Person();
function subObject(obj) {
  var sub = content(obj);
  return sub;
}
var sup2 = subObject(sup);
/**
 * 5. 寄生组合式继承
 * 1、函数的原型等于另一个实例。2、在函数中用apply或者call引入另一个构造函数，可传参
 */
function inheritProperty(subType, superType) {
  var prototype = Object(superType.prototype); //---->创建对象
  prototype.constructor = subType; //---->增强对象
  subType.prototype = prototype; //---->指定对象
}
function Test(name) {
  this.name = name;
  this.colors = ['red', 'blue', 'black'];
}
Test.prototype.sayName = function () {
  alert(this.name);
};
function TestDome(name, age) {
  Test.call(this, name);
  this.age = age;
}
TestDome.prototype.sayAge = function () {
  console.log(this.age);
};
inheritProperty(TestDome, Test);

var t = new TestDome('hello test demo', 18);

/**
 * 6. extends 继承
 */
class A extends B {
  constructor() {
    super();
  }
}
