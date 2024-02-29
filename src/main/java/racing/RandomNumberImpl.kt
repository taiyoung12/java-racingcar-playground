package racing

import kotlin.random.Random

class RandomNumberImpl: RandomNumber {
    override fun generateNumber(bound: Int): Int {
        return Random.nextInt(10)
    }
}