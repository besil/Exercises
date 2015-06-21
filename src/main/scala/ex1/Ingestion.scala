package ex1

import com.datastax.spark.connector._
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

    //    val f1 = sc.textFile("data/2012.csv.gz")

    val rdd = sc.cassandraTable("test", "kv")
    println(rdd.count)
    println(rdd.first)
    println(rdd.map(_.getInt("value")).sum)

    //    f1.take(10).foreach(println)

    //    println(f1.count())

  }
}
