package basic.book

import kotlin.random.Random

const val MAX_NUMBER_OF_BOOKS = 3

data class Book(val title: String, val author: String, val year: Int, var pages: Int) {

    fun byTitleAndAuthor() = title to author

    fun byTitleAndAuthorAndYear() = Triple(title, author, year)

    fun canBorrow(numberOfBooksBorrowed: Int) = numberOfBooksBorrowed < MAX_NUMBER_OF_BOOKS

    fun printUrl() = println("$BASE_URL/$title.html")

    companion object Constants {
        const val BASE_URL = "https://library.com"
    }
}

fun Book.weight() = pages * 1.5

fun Book.tornPages(numberOfPages: Int) {
    if (pages >= numberOfPages) pages -= numberOfPages else pages = 0
}

class Puppy {

    fun playWithBook(book: Book) = book.tornPages(Random.nextInt(12))
}

fun main(args: Array<String>) {
    val (title, author, year) = Book(title = "Musashi", author = "Eiji Yoshikawa", year = 1932, pages = 500).byTitleAndAuthorAndYear()
    println("Here is your book $title written by $author in $year.")


    val allBooks = setOf<Book>(
        Book("MacBeth", "William Shakespeare", 1568, 400),
        Book("Romeo and Juliet", "William Shakespeare", 1570, 400),
        Book("Julius Caesar", "William Shakespeare", 1572, 400),
        Book("Hamlet", "William Shakespeare", 1574, 400),
        Book("Otelo", "William Shakespeare", 1576, 400)
    )

    val library = mapOf<String, Set<Book>>("William Shakespeare" to allBooks)

    println(library.any { libraryIt -> libraryIt.value.any { it.title == "Hamlet" } })

    val moreBooks = library.toMutableMap()
    moreBooks["Eiji Yoshikawa"] = setOf<Book>(Book("Musashi", "Eiji Yoshikawa", 1932, 500))

    moreBooks.getOrPut("James Clavell") { setOf<Book>(Book("Xogum", "James Clavell", 1976, 700)) }

    println(moreBooks)


    val book = Book(title = "Musashi", author = "Eiji Yoshikawa", year = 1932, pages = 500)
    book.printUrl()
    val puppy = Puppy()
    while (book.pages > 0) {
        puppy.playWithBook(book)
    }
}