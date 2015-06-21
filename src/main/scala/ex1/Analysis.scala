package ex1

import com.datastax.spark.connector._
import commons.Record
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by besil on 21/06/15.
 */
object Analysis {
  def main(args: Array[String]) {
    println("Starting data ingestion")
    val conf = new SparkConf()
      .setAppName("Meteo Demo Analysis")
      .setMaster("local[*]")
      .set("spark.cassandra.connection.host", "127.0.0.1")

    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    val data = sc.cassandraTable[Record]("meteo", "data")

    println("There are " + data.count + " records")
  }
}
