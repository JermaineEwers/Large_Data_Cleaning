package cse250.pa1
/**
 * cse250.pa1.DataProcessor
 *
 * Copyright 2021 Oliver Kennedy (okennedy@buffalo.edu)
 *           2021 Andrew Hughes (ahughes6@buffalo.edu)
 *
 * This work is licensed under the Creative Commons
 * Attribution-NonCommercial-ShareAlike 4.0 International License.
 * To view a copy of this license, visit
 * http://creativecommons.org/licenses/by-nc-sa/4.0/.
 */

import cse250.objects.SolarInstallation

import scala.collection.mutable

object DataProcessor {
  def splitArrayToRowArray(splitHeaderRow: Array[String]): Array[String] ={
    var t: Array[String]=Array()
    var r: List[String]=List()
    for(i<-splitHeaderRow.indices){
    r=r:+splitHeaderRow(i)

    }
    t=r.toArray
    t
  }

  def rowArrayToSolarInstallation(rowData: Array[String]): SolarInstallation = {
 var tor= new SolarInstallation
 val t=SolarInstallation.HEADERS.length
    var rr: List[Int]=List(0,1,3,4,9,11,12,14,15,17,18,19,20,21,22,23,24,25,26,27,28,36,37,38,39,40,41,42,43)
    var y=0
 var i=0
    for (p<-rr){
      tor.fields += (SolarInstallation.REQUIRED_HEADERS(y)->rowData(p))
      y=y+1
    }
   /*while(i<t) {
    if(rowData(i)==SolarInstallation.REQUIRED_HEADERS(y) && y<29){
      tor.fields += (SolarInstallation.REQUIRED_HEADERS(y)->rowData(i))
      rr=rr:+i
      i=i+1
      y=y+1

    }else{
      i=i+1
    }


 }*/
    tor
  }

  def computeUniqueCities(dataset: Array[SolarInstallation]): Int = {
    var t =dataset
    1


  }

  def computeAverageCostForCity(dataset: Array[SolarInstallation], city: String): Double = ???
}
