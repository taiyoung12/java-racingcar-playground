package racing

class Main

fun main(args: Array<String>) {

    val randomNumber: RandomNumber = RandomNumberImpl()

    val name: String = readlnOrNull().toString()
    val names: List<String> = utils.splitName(name)

    val cars: List<Car> = names.map { carName ->
        Car(carName, 0, randomNumber)
    }

    val turns: Int = readlnOrNull()!!.toInt()

    for(t: Int in 0..turns-1){
        cars.map { car ->
            car.moveSelf()
            println(car.getName() + ":" + car.currentPosition())
        }
        println("---------------")
    }

}

