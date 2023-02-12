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

object DataProcessor {
  def splitArrayToRowArray(splitHeaderRow: Array[String]): Array[String] = ???

  def rowArrayToSolarInstallation(rowData: Array[String]): SolarInstallation = ???

  def computeUniqueCities(dataset: Array[SolarInstallation]): Int = ???

  def computeAverageCostForCity(dataset: Array[SolarInstallation], city: String): Double = ???
}
