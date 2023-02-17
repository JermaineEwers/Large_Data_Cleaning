package cse250.pa1
/**
 * cse250.pa1.Main.scala
 *
 * Copyright 2021 Oliver Kennedy (okennedy@buffalo.edu)
 *           2021 Andrew Hughes (ahughes6@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 *
 */

import cse250.objects.SolarInstallation

import java.io.{BufferedWriter, FileWriter}
import scala.io.Source
import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks.break

object Main {

  /**
   * Entrypoint for the 250 project
   */
  def main(args: Array[String]): Unit =
  {
    val inputFilename = "data/Solar_Electric_Programs_Reported_by_NYSERDA__Beginning_2000.csv"
    val outputFilename = "data/Solar_Electric_Programs_Reported_by_NYSERDA__Beginning_2000.updated.csv"
    val inputFile = Source.fromFile(inputFilename)
    val outputFile = new BufferedWriter(new FileWriter(outputFilename))

    val dataset = mutable.ArrayBuffer[SolarInstallation]()

    try {
      /**
       * An iterator to the lines of the input file.  Becomes invalid as soon as inputFile is closed.
       * (do not close inputFile until after you finish reading from lines!)
       */
      val lines = inputFile.getLines()

      var numb:Int=0
      for (line<- lines) {
    /* numb+=1
     var ch=line
        var ty: ArrayBuffer[Char]=ArrayBuffer()
        for (i<-ch.indices){
          ty+=ch(i)
        }

      var lin: List[Int]=List()
        var p:Int=0
        var y:Int=0
var t=line(2)
  val k='"'

    var neww:String=""
        var tr:String=""
        for(i<-ch.indices){
          if(ch(i)=='"'.charValue() && y==0){
            y=1
          }
          if(ch(i)==','.charValue() && y==1){
            p=i
            ty.remove(p)
            y=2
          }
          if (ch(i) == '"'.charValue() && y == 2) {
            y = 0
          }


        }*/

     /* if(p!=0) {
        ty.remove(p)
      }*/
       /* if(p!=0){
          ch=ty.mkString
          }*/



        /* var tu:String=""
         var art:String=""
         if(p!=0){
          art= art.concat(lin.toArray.toBuffer.remove(p).toString)
         tu=tu.concat(art)}*/




        val rowData = DataProcessor.splitArrayToRowArray(line.split(","))

        val installation = DataProcessor.rowArrayToSolarInstallation(rowData)
        dataset.append(installation)
        outputFile.write(installation.toString)
        outputFile.write('\n')
      }


    } finally {
      inputFile.close()
      outputFile.close()
    }

    val cities = DataProcessor.computeUniqueCities(dataset.toArray)
    val averageCost = DataProcessor.computeAverageCostForCity(dataset.toArray, "Buffalo")
    println(s"Number of cities: $cities")
    println(s"Average Cost per project in Buffalo: $$$averageCost")
  }

}
