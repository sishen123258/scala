package tong.cases


abstract class Expr

case class Var(name: String) extends Expr

case class Numbers(num: Double) extends Expr

case class UnOp(operator: String, arg: Expr) extends Expr

case class BinOp(operator: String, left: Expr, right: Expr) extends Expr


object script3 extends App {

    val v = new Var("123")

    println(v)


    //模式匹配的种类

    val expr = BinOp("+", v, v)
    val expr2 = BinOp("+", v, v)
    //通配模式
    expr match {
        case BinOp(_, _, _) =>
            println(expr + " is a binary operation.")
        case _ => expr
    }

    //常量模式
    def describe(x: Any) = x match {
        case 5 => "five"
        case true => "truth"
        case "hello" => "hi!"
        case _ => x
    }

    println(describe(5))
    println(describe(true))
    println(describe("hello"))
    println(describe("3"))

    //变量模式 类似于通配符，不同在于，scala把变量绑定在匹配的对象上
    def variable(x: Any) = x match {
        case 0 => "zero"
        case something => "Not zero: " + something
    }

    println(variable(0))
    println(variable(expr2))

    val e = Var("E")

    //构造器模式 ： scala 支持深度的模式匹配
    def deepMatch(x: Any) = x match {

        case BinOp("+", Var("E"), Numbers(0)) => "a deep match"
        case _ =>

    }

    println(deepMatch(new BinOp("+", e, Numbers(0))))
    println(deepMatch(new BinOp("-", e, Numbers(0))))

    //序列模式
    def ser(x: Any) = x match {
        case List(0, _, _) => "匹配开始元素为0的三元list"
        case List(2, _*) => "匹配开始元素为0的任意list"
        case List(1, _*) => "匹配开始元素为1的任意list"
        case _ =>
    }

    println(ser(List(0, 1, 2)))

    //元祖模式
    def testDemo(expr: Any) = expr match {
        case (a, b, c) => "matched" + a + b + c
        case _ =>
    }

    println(testDemo((1, 2, 3)))

    //类型模式
    def testType(param: Any) = {
        param match {


            case s: String => s.length
            case map: Map[_, _] => map.keys
            case _ => 1

        }
    }

    println(testType(Map(1 -> 2)))
    println(testType("123"))




}




