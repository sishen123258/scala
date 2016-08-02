package implicts



//让 java String 类变为 scala RandomAccessSeq
object implicts extends App{

    implicit  def intToString (x:Int) ={ x.toString}

    println(123.length)
}

