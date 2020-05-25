package functional

fun List<Int>.divisibleByThree(block: Int.() -> Int): List<Int> {
    val result = mutableListOf<Int>()
    this.forEach { if (block(it) == 0) { result.add(it) } }
    return result
}

fun main() {
    val numbers = listOf<Int>(1,2,3,4,5,6,7,8,9,0)
    println(numbers.divisibleByThree { this % 3 })
}