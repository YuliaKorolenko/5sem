/**
 * В теле класса решения разрешено использовать только переменные делегированные в класс RegularInt.
 * Нельзя volatile, нельзя другие типы, нельзя блокировки, нельзя лазить в глобальные переменные.
 *
 * @author :TODO: Yulia Korolenko
 */
class Solution : MonotonicClock {
    private var c1a by RegularInt(0)
    private var c1b by RegularInt(0)
    private var c1c by RegularInt(0)
    private var c2a by RegularInt(0)
    private var c2b by RegularInt(0)
    private var c2c by RegularInt(0)

    override fun write(time: Time) {
        // write right-to-left
        c2a = time.d1
        c2b = time.d2
        c2c = time.d3
        c1c = time.d3
        c1b = time.d2
        c1a = time.d1
    }

    override fun read(): Time {
        // read left-to-right
        val r1a = c1a
        val r1b = c1b
        val r1c = c1c
        val r2c = c2c
        val r2b = c2b
        val r2a = c2a
        if (Time(r1a, r1b, r1c) == Time(r2a, r2b, r2c)) {
            return Time(r1a, r1b, r1c)
        } else {
            if (r1a == r2a) {
                if (r1b == r2b) {
                    return Time(r2a, r2b, r2c)
                } else {
                    return Time(r2a, r2b, 0)
                }
            } else {
                return Time(r2a, 0, 0)
            }
        }
    }
}