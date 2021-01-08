# 枚举
被enum关键字修饰的类型就是枚举类型。每一个枚举对象都有一个枚举序数值，默认为从0开始的有序数值。<br/>
注意，定义枚举类的关键字是enum，而不是Enum，所有关键字都是小写的！<br/>
示例：<br/>
public enum Color { RED, GREEN, BLUE }<br/>
以 Color 枚举类型举例，它们的枚举常量依次为 RED，GREEN，BLUE。序数值分别为：0，1，2<br/>
# 枚举的方法
values()：返回 enum 实例的数组，而且该数组中的元素严格保持在 enum 中声明时的顺序。<br/>
name()：返回实例名。<br/>
ordinal()：返回实例声明时的序数值，从0开始：严格保持在 enum 中声明时的顺序。<br/>
getDeclaringClass()：返回实例所属的 enum 类型。<br/>
equals() ：判断是否为同一个对象。比较的是地址。<br/>
hashCode()：返回枚举常量的hashCode。<br/>
compareTo(E e)：比较两个枚举常量谁大谁小，先比较的是两个枚举对象是不是同一个对象(getClass和getDeclaringClass方法)，然后比较的就是枚举常量在枚举类中声明的顺序（做差值），例如FRONT的下标为0，BEHIND下标为1，那么FRONT小于BEHIND；
