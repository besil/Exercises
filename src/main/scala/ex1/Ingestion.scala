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

    val f1 = sc.textFile("data/2012.csv.gz")

    println(f1.count())

  }
}
