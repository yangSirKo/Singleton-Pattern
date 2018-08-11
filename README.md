# Singleton-Pattern
A variety of singleton partterns
<br><br>
#### Singleton1.java<br>
a bad solution: 只适用与单线程环境的写法。
<br><br>
#### Singleton2.java<br>
a bad solution: 虽然在多线程环境中能工作，但效率不高。
问题：类中为什么要单独创建obj作为锁对象，不用Singleton2 做锁对象？ <br>
解析：个人觉得这个类加载机制有关。每一个类加载器都拥有一个独立的类名称空间，因此如果不同的类加载器加载该类，会产生另一类。而静态变量存储在方法区，可能会保证有同一个obj类对象。
<br><br>
#### Singleton3.java
feasible solution：双重检查 与 延时初始化 + volatile 的解决方案。
问题：为什么需要volatile修饰该静态变量？
解析：对象的创建有三步，1.分配对象空间；2.初始化对象；3.将内存地址赋给该对象的引用。
     对象的创建第二步可能和第三步进行重排序，可能会出现对象未初始化完成，但是对象引用已经指向该对象地址。
     如果并发环境下出现重排序，其他线程判断对象引用不为空，调用该对象时会抛空指针异常，因为此时对象只是分配了空间并没有初始化。 
     因此需要添加 volitile关键字，保证创建对象不会重排序。
<br><br>
#### Singleton4.java           
strongly Recommended solution：利用静态构造函数
加载类时会自动初始化静态成员变量，因此如果对象较大会使项目初始化变慢。
<br><br>
#### Singleton5.java
strongly recommended solution: 基于类初始化的解决方案 
<br><br>
上面的5中写法，似乎解决了效率与懒加载的问题，但是他们都有两个共同的缺点：会被序列化和反射破坏。
<br><br>
#### Singleton6.java
strongly recomment solution: 枚举单例
编写很简单，访问方式也更简单，使用SingletonEnum.INSTANCE进行访问，
这样也就避免调用getInstance方法，更重要的是使用枚举单例的写法，我们完全不用考虑序列化和反射的问题。
枚举序列化是由jvm保证的，每一个枚举类型和定义的枚举变量在JVM中都是唯一的。
