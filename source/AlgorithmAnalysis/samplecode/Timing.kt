import kotlin.time.measureTimedValue
import kotlin.time.DurationUnit

fun sumOfN(n: Int): Long {
  var theSum = 0L
  for (i in 1..n) {
    theSum = theSum + i
  }
  return theSum
}

fun main() {
  
  print("Find sum from 1 to n: ")
  val n = readln().toInt()
  
  for (trial in 0..<25) {
    val (result, elapsedTime)  = measureTimedValue {
      sumOfN(n)
    }
    println(String.format(
      "Trial %2d: Sum %d: time %s",
      trial,
      result,
      elapsedTime.toString(DurationUnit.MILLISECONDS, 4)))
  }
}
