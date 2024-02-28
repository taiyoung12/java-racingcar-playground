package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RacingTest {
    private val anyCarName: String = "R8"
    private val car: Car = Car(anyCarName)

    @Test
    fun `자동차 이름은 5글자 이하 이다`() {
        val exception = assertThrows(IllegalArgumentException::class.java) {
            Car("AudiR8")
        }

        assertTrue(car.getName().length <= 5, "자동차 이름은 5글자 이하이어야 한다.")
        assertThat(exception.message).isEqualTo("자동차 이름은 5글자 이하 여야만 한다.")
    }

    @Test
    fun `자동차 이름은 , 기준으로 나눠진다`(){
        val carNames = "R1,R2,R3"

        val names: List<String> = utils.splitName(carNames)
        assertTrue(names.size == 3, ", 로 나누어진 자동차 이름은 3개이다")
    }

}
