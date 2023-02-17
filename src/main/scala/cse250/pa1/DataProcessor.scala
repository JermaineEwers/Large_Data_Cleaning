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
import scala.collection.mutable.ArrayBuffer

object DataProcessor {
  def splitArrayToRowArray(splitHeaderRow: Array[String]): Array[String] ={
    var t: Array[String]=Array()
    var qq: ArrayBuffer[String]=ArrayBuffer()
    var r: List[String]=List()
    var pp=splitHeaderRow.length
    var tt=0
    var i=0
    while (i < splitHeaderRow.length) {
      if (splitHeaderRow(i).contains("\"") && splitHeaderRow(i+1).contains("\"")  ) {


        var f=(splitHeaderRow(i).concat(",").concat("").concat(splitHeaderRow(i + 1))).replaceAll("\"","")
        r = r :+  f

        i = i + 2
      }else if(splitHeaderRow(i).contains("\"") && !splitHeaderRow(i+1).contains("\"")){
        var s="\""
        var t = splitHeaderRow(i).replaceAll("\"","")
        r=r:+ (s.concat(t).concat(s))
        i+=1
      }
      if (i == pp) {
        i
      } else {
        r = r :+ splitHeaderRow(i)

        i += 1
      }

    }

    var up=r.length
    if(r.length<44){
      while(up<44){
        r=r:+""
        up+=1
      }
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
      if (p>=rowData.length && p<44){
        tor.fields += (SolarInstallation.REQUIRED_HEADERS(y)->"")
      }else{
      tor.fields += (SolarInstallation.REQUIRED_HEADERS(y)->rowData(p))}
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

  /*def bfs[A](graph: Graph[A], startID: Int): Map[Int, Int] = {
    var explored: Set[Int] = Set(startID)

    var toExplore: mutable.Queue[Int] = new mutable.Queue[Int]()
    toExplore.enqueue(startID)

    var Mapp: Map[Int, Int] = Map()

    while (toExplore.nonEmpty) {
      val nodeToExplore = toExplore.dequeue()
      val check = graph.adjacencyList
      for (node <- graph.adjacencyList(nodeToExplore)) {
        if (!explored.contains(node)) {
          toExplore.enqueue(node)
          explored = explored + node
          Mapp = Mapp + (node -> nodeToExplore)
        }
      }
    }
    Mapp
  }*/

  def computeUniqueCities(dataset: Array[SolarInstallation]): Int = {
   /* use deque and queue*/

    var cities: ArrayBuffer[String]=ArrayBuffer()
    var ty=dataset.length
    var i=1
  while(i<ty){
      cities += dataset(i).fields("City")
    i+=1
  }
    /*var numcit:List[String]=List()
    var counted: Set[String] =Set()
    var tocount: mutable.Queue[String] = new mutable.Queue[String]()
    while(tocount.nonEmpty){
      val cit= tocount.dequeue()
      for(city<-cities){
        if(!cities.contains(city)){
          tocount.enqueue(city)
          cities= cities:+city
          numcit=numcit:+city
        }
      }
    }*/

  cities.distinct.length

  }

  def computeAverageCostForCity(dataset: Array[SolarInstallation], city: String): Double = {
    var num: Int=0
    var cost: Double=0.0
    var cities: List[String] = List()
    for (i <- dataset.indices) {
      if (i != 0) {
        if(dataset(i).fields("City")==city) {
          num=num+1

          cost = cost + dataset(i).fields("Project Cost").toDouble
        }
      }
    }

 cost/num

  }

}
