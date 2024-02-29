package racing

class Car(
    private val name: String,
    private var position: Int = 0,
    private val randomNumber: RandomNumber
) {
    init {
        require(name.length <=5) {"자동차 이름은 5글자 이하 여야만 한다."}
    }
    fun move(number: Int): Int {
        if (4 < number ){
            this.position += 1
        }

        return position
    }
    fun moveSelf(): Int {
        if(4 < randomNumber.generateNumber(10)){
            this.position +=1
        }

        return position
    }

    fun getName(): String = this.name
    fun getPosition(): Int = this.position

}
