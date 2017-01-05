/*
单例设计模式：解决一个类在内存中只存在一个对象。
	想要保证对象唯一：
					1,为了避免其他程序过多建立该类对象，先禁止其他程序建立该类对象。
					2,还为了让其他程序可以访问到该类对象，只好在本类中，自定义一个对象。
					3,为了方便其他程序对自定义对象的访问，可以对外提供一些访问方式。
	步骤代码实现：
					1,将构造函数私有化。
					2,在类中创建一个本类对象。
					3,提供一个方法可以获取到该对象。

//饿汉式：Single类一进内存，就建立了对象，然后将对象的地址值赋给方法区的变量。
		  多线程设计中建议使用饿汉式设计模式。
	示例：
		class Single
		{
			//构造函数私有化，不让其他人对对象进行私有化。
			private single(){}
			private static Single s = new Single();
			public static Single getInstance()
			{
				return s;
			}
		}
		
//懒汉式：Single类一进内存，对象还没有存在，只有调用了getInstance()方法后，才建立对象。
		
		特点：实例的延迟加载。
		缺点：问题如果是多线程同时加载时容易出现安全问题，解决办法可以使用同步代码块加双重判断的语句，
			  同步代码块的锁是该类所在的字节码文件对象。
示例：		
		class Single
		{
			private static Single s = null;
			private Single(){}
			public static  Single getInstance()
			{
				if (s==null)
				{
					synchronized(Single.class)//synchronized 同步块，
					{
						if (s==null)
						{
							s = new Single();
						}
					}
				}
				return s;
			}
		}
*/
