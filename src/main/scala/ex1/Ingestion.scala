package ex1

import com.datastax.spark.connector._
import commons.Record
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

    val years = List("2012, 2013, 2014").map(x => "data/" + x + ".csv.gz")
    println("Using files: ")
    years.foreach(println)

    //    val f1 = sc.textFile("data/2012.csv.gz")


    val l = sc.parallelize(List(Record("0", "0", "0", "0", "0")))

    l.saveToCassandra("meteo", "data")

    val rdd = sc.cassandraTable("meteo", "data")
    println(rdd.count)
    rdd.foreach(println)


    //    println(rdd.map(_.getInt("value")).sum)

    //    f1.take(10).foreach(println)

    //    println(f1.count())

  }
}
