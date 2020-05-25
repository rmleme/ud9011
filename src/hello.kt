import java.util.*

fun getBirthday(): Int {
    print("Enter you birthday: ")
    return readLine()?.toIntOrNull() ?: 1
}

fun getFortune(birthday: Int): String {
    val fortunes = listOf<String>(
        "You will have a great day!",
        "Things will go well for you today.",
        "Enjoy a wonderful day of success.",
        "Be humble and all will turn out well.",
        "Today is a good day for exercising restraint.",
        "Take it easy and enjoy life!",
        "Treasure your friends because they are your greatest fortune."
    )

    val i = when (birthday) {
        28, 31 -> 0
        in 1..7 -> 1
        else -> birthday % fortunes.size
    }

    return fortunes[i]
}

//fun main(args: Array<String>) {
//    dayOfWeek()
//}

fun dayOfWeek() {
    when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
        Calendar.SUNDAY -> println("Sunday")
        Calendar.MONDAY -> println("Monday")
        Calendar.TUESDAY -> println("Tuesday")
        Calendar.WEDNESDAY -> println("Wednesday")
        Calendar.THURSDAY -> println("Thursday")
        Calendar.FRIDAY -> println("Friday")
        Calendar.SATURDAY -> println("Saturday")
        else -> println("Error")
    }
}


fun main(args: Array<String>) {
    /*val time : Int = args[0].toInt()
    if (time < 12) println("Good morning, Kotlin")
    else println("Good night, Kotlin")

    println("Good ${ if (args[0].toInt() < 12) "morning" else "afternoon" }, Kotlin")*/

    /*for (i in 1..10) {
        val fortune = getFortune(getBirthday())
        if (fortune == "Take it easy and enjoy life!") break
        println(fortune)
    }*/

    do {
        var fortune = getFortune(getBirthday())
        if (fortune != "Take it easy and enjoy life!") println(fortune)
    } while (fortune != "Take it easy and enjoy life!")

    /*println(canAddFish(10.0, listOf(3, 3, 3)))
    println(canAddFish(8.0, listOf(2, 2, 2), hasDecorations = false))
    println(canAddFish(9.0, listOf(1, 1, 3), 3))
    println(canAddFish(10.0, listOf(), 7, true))*/
}

fun canAddFish(tankSize: Double, currentFish: List<Int>, fishSize: Int = 2, hasDecorations: Boolean = true): Boolean {
    val decorationCoefficient = if (hasDecorations) 0.8 else 1.0
    val currentFishTotalSize = currentFish.sum()
    return currentFishTotalSize + fishSize <= tankSize * decorationCoefficient
}