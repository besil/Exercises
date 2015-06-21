package commons

/**
 * Created by besil on 20/06/15.
 */
case class Record(sid: String,
                  date: String,
                  time: String,
                  obsType: String,
                  obsValue: Double
                   )

object Importer {
  def getRecord(line: String): Record = {
    val split: Seq[String] = line.split(",")
    val sid = split(0)
    val date = split(1)
    val obsType = split(2)
    val obsValue = split(3).toDouble
    val time: String = if (split.length == 8) split(7) else ""

    Record(sid, date, time, obsType, obsValue)
  }
}