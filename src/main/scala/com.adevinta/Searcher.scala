package com.adevinta

import java.nio.file.{Files, Paths}
import java.util.regex.Pattern
import scala.io.StdIn.readLine
import scala.collection.mutable.Map

object Searcher {

  def main(args: Array[String]): Unit = {
    // throwing exception when directory location is not passed.Copied this line from given pdf file.
    if (args.length == 0) throw new IllegalArgumentException("No directory given to index.")
    //  searchText will have contents of command line input,included this to stop search when someone input's with quit
    var seachText = Array[String]("")
    //  loop to continue search until quit
    while (seachText(0) != "quit") {
      print("search>")
      seachText = readLine().split(" ")
      val result = testSearch(seachText,args(0))
      result match {
        case Left(s) => println("no matches found")
        case Right(map) => map.foreach(println)
      }
    }
  }

    // method to calculate rank for each file based on the matching words
    def testSearch(words:Array[String],path:String): Either[String,Seq[(String,Double)]] ={
      // rankMap will be used to keep file name with their associated ranking
      var rankMap = Map[String, Double]()
      // Files.walk will run through all the subfolder
      Files.walk(Paths.get(path)).filter(path => (path.toFile.isFile)).forEach(p => {
        // map will be used contain matching words and their occurrence in single file
        var map = Map[String, Int]()
        scala.io.Source.fromFile(p.toString).getLines().foreach(line => words.foreach(w => if(line.contains(w)) map += (w -> (map.get(w).getOrElse(0)+1))))
        if(map.size>0) rankMap += (p.toString.split(Pattern.quote("\\")).last -> ((map.size * 100) / words.size))
      })
      if(rankMap.size>0) Right(rankMap.toSeq.sortWith(_._2 > _._2).take(10)) else Left("no matches found")
    }
  }