package spices

import java.lang.IllegalArgumentException

sealed class Spice(val name: String, val spiceness: String = "mild", color: SpiceColor): SpiceColor by color {

    val heat
        get() = when(spiceness) {
            "soft" -> 1
            "mild" -> 5
            "spicy" -> 10
            else -> throw IllegalArgumentException()
        }

    abstract fun prepareSpice()
}

// fun makeSalt() = Spice("salt", "soft")

class Curry(name: String, spiceness: String, color: SpiceColor = YellowSpiceColor): Spice(name, spiceness, color), Grinder {

    override fun grind() {
    }

    override fun prepareSpice() {
        grind()
    }
}

interface Grinder {
    fun grind()
}

enum class Color(val rgb: Int) {
    RED(0xFF0000), GREEN(0x00FF00), BLUE(0x0000FF), YELLOW(0xFFFF00)
}

interface SpiceColor {
    val color: Color
}

object YellowSpiceColor : SpiceColor {
    override val color = Color.YELLOW
}

data class SpiceContainer(val spice: Spice) {
    val label = spice.name
}


fun main(args: Array<String>) {
    // val curry = Curry(name = "curry", spiceness = "mild")
    // print(curry.color)

    val spiceContainers = listOf<SpiceContainer>(
        SpiceContainer(Curry("curry", "mild")),
        SpiceContainer(Curry("pepper", "mild")),
        SpiceContainer(Curry("jalapeno", "mild"))
    )
    spiceContainers.forEach { println(it.label) }
}