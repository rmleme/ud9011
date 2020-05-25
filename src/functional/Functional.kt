package functional

enum class Direction {
    NORTH, SOUTH, EAST, WEST, START, END
}

class Game {
    var path = mutableListOf(Direction.START)

    val north = { path.add(Direction.NORTH) }
    val south = { path.add(Direction.SOUTH) }
    val east = { path.add(Direction.EAST) }
    val west = { path.add(Direction.WEST) }

    val end = {
        path.add(Direction.END)
        println("Game Over: $path")
        path.clear()
        println()
        false
    }

    val location = Location()

    fun move(where: () -> Boolean, newLocation: () -> Unit) {
        where()
        newLocation()
    }

    fun makeMove(direction: String?) {
        when (direction) {
            "n" -> move({ north() }, { location.north() })
            "s" -> move({ south() }, { location.south() })
            "e" -> move({ east() }, { location.east() })
            "w" -> move({ west() }, { location.west() })
            else -> move({ end() }, { location.end() })
        }
    }
}

class Location {
    val map = Array(HEIGHT) { arrayOfNulls<String>(WIDTH) }
    var x = 0
    var y = 0

    init {
        map[0][0] = "Trantor"
        map[0][1] = "Santanni"
        map[0][2] = "Siwenna"
        map[0][3] = "Neotrantor"

        map[1][0] = "Terminus"
        map[1][1] = "Anacreon"
        map[1][2] = "Smyrno"
        map[1][3] = "Korell"

        map[2][0] = "Comporellon"
        map[2][1] = "Melpomenia"
        map[2][2] = "Alpha"
        map[2][3] = "Sayshell"

        map[3][0] = "Earth"
        map[3][1] = "Aurora"
        map[3][2] = "Solaria"
        map[3][3] = "Gaia"
    }

    val north = { if (y > 0) y -= 1 }
    val south = { if (y < HEIGHT - 1) y += 1 }
    val west = { if (x > 0) x -= 1 }
    val east = { if (x < WIDTH - 1) x += 1 }
    val end = { x = 0; y = 0}

    fun printCurrentLocation() = println("Current location: [$y][$x] = ${map[y][x]}")

    companion object Constants {
        const val WIDTH = 4
        const val HEIGHT = 4
    }
}

fun main() {
    val game = Game()

    /*println(game.path)
    game.north()
    game.east()
    game.south()
    game.west()
    game.end()
    println(game.path)*/

    while (true) {
        game.location.printCurrentLocation()
        print("Enter a direction: n/s/e/w: ")
        val direction = readLine()
        game.makeMove(direction)
    }
}