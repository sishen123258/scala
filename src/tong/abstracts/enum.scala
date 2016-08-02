package tong.abstracts



//scala 里面没有枚举

object Color extends Enumeration{

    val BLUE,YELLOW,RED,WHITE=Value  //Value是Enumeration的内部类
//    val WHITE=Value("WHITE")

}

object Direction extends Enumeration{

    val North=Value("North")
    val East=Value("East")
    val West=Value("West")
    val South=Value("South")

}


object script5 extends App{

    println(Color.BLUE)
    println(Color.WHITE)



}