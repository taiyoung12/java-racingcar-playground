package racing

class Main

fun main(args: Array<String>) {
    val name: String = readlnOrNull().toString()
    val names: List<String> = utils.splitName(name)
    println(names[0])
}

