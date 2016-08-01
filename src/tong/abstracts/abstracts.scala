package tong.abstracts


object abstracts extends App {

    val concrete = new Concrete
    println(concrete.initial)
    println(concrete.transform("123"))

    val badFruit = new BasFruit
    println(badFruit.m)
    println(badFruit.v)

    val demo = Demo

    val demo2=Demo2
    println(demo2.x)

    println(demo.x)

    val cow=new Cow

    val food=new Food
    val grass=new Grass

    cow.eat(food)
    cow.eat(grass)

    cow.eat2(grass)
}

//抽象成员
trait Abstract {

    val content: T //抽象val 当不知道content的具体内容，但是知道content是不能改变的时候，可以使用val

    type T //抽象类型，type的一种用法

    def transform(x: T): T

    def initial: T

    def current: T

}

class Concrete extends Abstract {
    override type T = String

    override def transform(x: String): String = x + x

    override def initial: String = "Hi"

    override def current: String = initial

    override val content: String = "abstract val"
}


//抽象 val 只能被val重写，不能被def重写,而def 可以被val重写,
abstract class Fruit {

    val v: String

    def m: String

}

abstract class Apple extends Fruit {

    val v: String
    val m: String

}

class BasFruit extends Fruit {
    override val v: String = "bad fruit"

    override def m: String = "print"
}

//懒加载 val
object Demo {
    //初始化demo的时候初始化x
    val x = {
        println("init x"); 123
    }
}

object Demo2 {
    //直到x第一次使用的时候才初始化
    lazy val x = {
        println("lazy init x"); 123
    }
}


class Food

abstract class Animal{

    //这里的参数Food类型不能为Food 的子类型，如grass类型
    def eat(food: Food)

    //为了可以实现吃 grass的类型，如下
    type SpecifiedFood<:Food

    def eat2(food:SpecifiedFood)




}

class Grass extends Food

class Cow extends Animal{



    override def eat(food: Food): Unit = println("eating food")

    override type SpecifiedFood = Grass

    override def eat2(food: Grass): Unit = println("eating grass")
}

