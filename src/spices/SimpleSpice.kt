package spices

class SimpleSpice {
    val name = "curry"

    val spiceness = "mild"

    val heat
        get() = when(spiceness) {
            "mild" -> 5
            else -> 0
        }
}