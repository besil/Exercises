package ex1

import com.datastax.spark.connector._
import commons.{Importer, Record}
import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by besil on 20/06/15.
 */
object Ingestion {
  def main(args: Array[String]) {
    println("Starting data ingestion")
    val conf = new SparkConf()
      .setAppName("Meteo Demo")
      .setMaster("local[*]")
      .set("spark.cassandra.connection.host", "127.0.0.1")

    val sc: SparkContext = new SparkContext(conf)
    sc.setLogLevel("WARN")

    val years = List("2012", "2013", "2014").map(x => ("data/" + x + ".csv.gz"))

    def save(fileName: String, fraction: Double = 1.0): Unit = {
      println("Saving data from " + fileName)
      val f: RDD[String] = sc.textFile(fileName)
      println("There are " + f.count() + " records")

      val sample = f.sample(true, fraction)
      println("Sampling " + (fraction * 100.0) + "% of them... Taking only " + sample.count)

      sample.map(Importer.getRecord).saveToCassandra("meteo", "data")

    }

    save(years.head, 0.01)

    val rdd = sc.cassandraTable[Record]("meteo", "data")
    println("There are " + rdd.count + " records")

  }
}
