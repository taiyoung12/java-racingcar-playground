package racing

class utils {
    companion object{
        fun splitName(carNames: String): List<String>{
            return carNames.split(",").map { it.trim() }.filter { it.isNotEmpty() }
        }
    }
}