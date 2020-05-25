fun main(args: Array<String>) {
    val mood = getMood()
    println(whatShouldIDoToday(mood))
}

fun getMood(): String {
    print("Enter your mood: ")
    return readLine()!!.toString()
}

fun whatShouldIDoToday(mood: String, weather: String = "sunny", temperature: Int = 24): String {
    return when {
        stayInBed(mood, weather, temperature) -> "stay in bed"
        goSwimming(temperature) -> "go swimming"
        mood == "happy" && weather == "Sunny" -> "go for a walk"
        mood == "happy" && temperature < 0 -> "play in the snow"
        else -> "Stay home and read."
    }
}

fun stayInBed(mood: String, weather: String, temperature: Int) = mood == "sad" && weather == "rainy" && temperature == 0

fun goSwimming(temperature: Int) = temperature > 35