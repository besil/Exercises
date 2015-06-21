package commons

/**
 * Created by besil on 20/06/15.
 */
case class Date(day: String, month: String, year: String) {
  def key(): String = day + "/" + month + "/" + year
}

case class Observation(obsType: String, value: Any)

case class Timestamp(hours: String, minutes: String)

case class Record(stationIdentifier: String, date: Date, observation: Observation, time: Timestamp) {
  def key(): String = stationIdentifier + "-" + date.key + "-" + observation.obsType
}
