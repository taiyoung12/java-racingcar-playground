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
}
