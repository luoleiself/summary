1.类的装饰:是一个函数,用来修改类的行为,ES2017引入
  eg:@testable
    class MyTestableClass {
      // ...
    }
    function testable(target) {
      target.isTestable = true;
    }
    MyTestableClass.isTestable // true
2.方法的修饰:第一个参数是所要修饰的目标对象，第二个参数是所要修饰的属性名，第三个参数是该属性的描述对象
  eg:class Person {
      @readonly
      name() { return `${this.first} ${this.last}` }
    }
    function readonly(target, name, descriptor){
      // descriptor对象原来的值如下
      // {
      //   value: specifiedFunction,
      //   enumerable: false,
      //   configurable: true,
      //   writable: true
      // };
      descriptor.writable = false;
      return descriptor;
    }
    readonly(Person.prototype, 'name', descriptor);
    // 类似于
    Object.defineProperty(Person.prototype, 'name', descriptor);
  eg:class Person {
      @nonenumerable
      get kidCount() { return this.children.length; }
    }
    function nonenumerable(target, name, descriptor) {
      descriptor.enumerable = false;
      return descriptor;
    }
3.为什么修饰器不能用于函数:修饰器只能用于类和类的方法，不能用于函数，因为存在函数提升
  eg:var readOnly = require("some-decorator");
    @readOnly
    function foo() { }
    var readOnly;
    @readOnly
    function foo() { }
    readOnly = require("some-decorator");
4.core-decorators.js:是一个第三方模块，提供了几个常见的修饰器
  1.@autobind:使得方法中的this对象，绑定原始对象
    eg:import { autobind } from 'core-decorators';
      class Person {
        @autobind
        getPerson() {
          return this;
        }
      }
      let person = new Person();
      let getPerson = person.getPerson;
      getPerson() === person;
      // true
  2.@readonly:使得属性或方法不可写
    eg:import { readonly } from 'core-decorators';
      class Meal {
        @readonly
        entree = 'steak';
      }
      var dinner = new Meal();
      dinner.entree = 'salmon';
      // Cannot assign to read only property 'entree' of [object Object]
  3.@override:检查子类的方法，是否正确覆盖了父类的同名方法，如果不正确会报错
    eg:import { override } from 'core-decorators';
      class Parent {
        speak(first, second) {}
      }
      class Child extends Parent {
        @override
        speak() {}
        // SyntaxError: Child#speak() does not properly override Parent#speak(first, second)
      }
      // or
      class Child extends Parent {
        @override
        speaks() {}
        // SyntaxError: No descriptor matching Child#speaks() was found on the prototype chain.
        //
        //   Did you mean "speak"?
      }
  4.@deprecate (别名@deprecated):控制台显示一条警告，表示该方法将废除
    eg:import { deprecate } from 'core-decorators';
      class Person {
        @deprecate
        facepalm() {}
        @deprecate('We stopped facepalming')
        facepalmHard() {}
        @deprecate('We stopped facepalming', { url: 'http://knowyourmeme.com/memes/facepalm' })
        facepalmHarder() {}
      }
      let person = new Person();
      person.facepalm();
      // DEPRECATION Person#facepalm: This function will be removed in future versions.
      person.facepalmHard();
      // DEPRECATION Person#facepalmHard: We stopped facepalming
      person.facepalmHarder();
      // DEPRECATION Person#facepalmHarder: We stopped facepalming
      //
      //     See http://knowyourmeme.com/memes/facepalm for more details.
      //
  5.@suppressWarnings:抑制decorated修饰器导致的console.warn()调用。但是，异步代码发出的调用除外
    eg:import { suppressWarnings } from 'core-decorators';
      class Person {
        @deprecated
        facepalm() {}
        @suppressWarnings
        facepalmWithoutWarning() {
          this.facepalm();
        }
      }
      let person = new Person();
      person.facepalmWithoutWarning();
      // no warning is logged
5.使用修饰器实现自动发布事件
6.Mixin
7.Trait:一种修饰器，效果与Mixin类似，但是提供更多功能
8.Babel转码器的支持
