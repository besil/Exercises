package ex2

/**
 * Created by besil on 20/06/15.
 */
object Exercise2 {
  /**
   *
   * @param num An integer and  is assumed to be at least 0.
   * @return A list of integers with the first entry being num, and the subsequent ones
   *         are gotten by omitting the left hand most digit one by one.
   *         Eg  num=0 returns List(0).
   *             num=1234 returns List(1234,234,34,4)
   */
  def leftTruncate(num: Int): List[Int] = {
    def myTruncate(n: String, acc: List[Int]): List[Int] = n match {
      case "" => acc
      case "0" => List(0)
      case x if (x.toInt < 0) => List()
      case x => myTruncate(x.substring(1), acc :+ n.toInt)
    }
    myTruncate(num.toString, List())
  }
}
