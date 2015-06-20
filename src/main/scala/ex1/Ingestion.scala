package ex1

import org.apache.spark.{SparkConf, SparkContext}

/**
 * Created by besil on 20/06/15.
 */
object Ingestion {
  def main(args: Array[String]) {
    println("Starting data ingestion")

    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc: SparkContext = new SparkContext(conf)
    val c = sc.parallelize(1 to 10 toList).count
    println(c)
  }
}
