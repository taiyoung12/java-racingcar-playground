package racing

class Car(
    private val name: String
) {
    init {
        require(name.length <=5) {"자동차 이름은 5글자 이하 여야만 한다."}
    }

    fun getName(): String = this.name

}
