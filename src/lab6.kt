import kotlin.math.pow
import kotlin.math.sqrt

typealias ExceptionZero = Exception

fun main() {

    fun task_1_1(a: Double, b: Double, c: Double, d: Double): Double {
        val nums = listOf(a, b, c, d)
        return (nums.maxOrNull() ?: 0) as Double
    }

    fun task_1_2(x: Double): Double = x.pow(4)

    fun task_1_3(a: Double, b: Double, c: Double, x: Double): Double = a * x.pow(2) + b * x + c

    fun task_2_1(y: Double): Array<Double?> {
        val x = arrayOfNulls<Double>(2)
        x[0] = y.pow(0.25)
        x[1] = -y.pow(0.25)
        return x
    }

    fun task_2_2(a: Double, b: Double, c: Double, y: Double): Array<Double?> {
        val x = arrayOfNulls<Double>(2)

        if (a == 0.0) {
            throw ExceptionZero("Error! Division on null")
        }

        val D = b*b - 4 * a * (c-y)
        if (sqrt(D) >= 0) {
            x[0] = (-b - sqrt(D)) / (2*a)
            x[1] = (-b + sqrt(D)) / (2*a)
        }

        return x
    }

    fun task_2_3(a: Double, c: Double, y: Double): Double {
        if (a == 0.0) {
            throw ExceptionZero("Error! Division on null")
        }

        return (y - c) / a
    }

    val a = ReadDouble.read("a")
    val b = ReadDouble.read("b")
    val c = ReadDouble.read("c")
    val d = ReadDouble.read("d")

    println("\t1.1. у = МАХ(a, b, c, d) = " + task_1_1(a, b, c, d));

    val x = ReadDouble.read("x")

    println("\t1.2. y = $x^4 = " + task_1_2(x))
    println("\t1.3. y = $a * $x^2 + $b $x + $c = " + task_1_3(a, b, c, x))

    val y = ReadDouble.read("y")

    println("\t2.1. $y = x^4;  x1 = " + task_2_1(y)[0] + ", x2 = " + task_2_1(y)[1])

    try {
        val task_2_2 = task_2_2(a, b, c, y)
        println("\t2.2. $y = $a * x^2 + $b x + $c;  x1 = ${task_2_2[0]}, x2 = ${task_2_2[1]}")
    } catch (e: ExceptionZero) {
        println("\t" + e.message)
    }

    try {
        println("\t2.3. $y = $a x + $c; x = " + task_2_3(a, c, y))
    } catch (e: ExceptionZero) {
        println("\t" + e.message)
    }
}

