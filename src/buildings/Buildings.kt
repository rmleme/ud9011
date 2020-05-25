package buildings

open class BaseBuildingMaterial(val numberNeeded: Int = 1) {
    fun <T : BaseBuildingMaterial> isSmallBuilding(building: Building<T>) =
        when {
            building.actualMaterialsNeeded < 500 -> println("small building")
            else -> println("large building")
        }
}

class Wood: BaseBuildingMaterial(numberNeeded = 4) {
}

class Brick: BaseBuildingMaterial(numberNeeded = 8) {
}

class Building<out T: BaseBuildingMaterial>(
    val baseMaterial: T,
    val baseMaterialsNeeded: Int = 100,
    val actualMaterialsNeeded: Int = baseMaterial.numberNeeded * baseMaterialsNeeded
) {
    fun build() = println("$actualMaterialsNeeded ${baseMaterial::class.simpleName} required.")
}

fun main() {
    val building = Building(Wood())
    building.build()
    building.baseMaterial.isSmallBuilding(building)
}