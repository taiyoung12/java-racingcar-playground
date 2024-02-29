package racing

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.doReturn
import org.mockito.Mockito.lenient
import org.mockito.junit.jupiter.MockitoExtension

@ExtendWith(MockitoExtension::class)
class RacingTest {
    private val anyCarName: String = "R8"

    private val car: Car = Car(anyCarName)

    @Mock
    lateinit var randomNumber: RandomNumber

    @BeforeEach
    fun setUp(){
        lenient().doReturn(5).`when`(randomNumber).generateNumber(10)
        lenient().doReturn(13).`when`(randomNumber).generateNumber(20)
    }

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

    @Test
    fun `0~9 까지 임의의 수를 뽑을 수 있다`(){
        val number: Int = randomNumber.generateNumber(10)
        val otherNumber: Int = randomNumber.generateNumber(20)

        assertThat(number).isGreaterThanOrEqualTo(0)
            .isLessThanOrEqualTo(9)
        assertThat(otherNumber).isGreaterThanOrEqualTo(11)
            .isLessThanOrEqualTo(20)
    }

    @Test
    fun `4 이상의 난수가 나왔을 때 자동차는 움직일 수 있다`(){
        val actual = Car(anyCarName, 0)

        actual.move(5)
        actual.move(6)


        assertThat(actual.getPosition()).isEqualTo(2)
    }

    @Test
    fun `4 이하의 난수가 나왔을 때 자동차는 움직일 수 없다`(){
        val actual = Car(anyCarName, 0)

        actual.move(3)

        assertThat(actual.getPosition()).isEqualTo(0)
    }

}
