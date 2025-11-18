import kotlin.time.measureTimedValue
import kotlin.time.DurationUnit

fun main() {
  
  print("Find sum from 1 to n: ")
  val n = readln().toLong()
  
  for (trial in 0..<25) {
    val (result, elapsedTime)  = measureTimedValue {
      sumOfNImproved(n)
    }
    println(String.format(
      "Trial %2d: Sum %d: time %s",
      trial,
      result,
      elapsedTime.toString(DurationUnit.MILLISECONDS, 4)))
  }
}
