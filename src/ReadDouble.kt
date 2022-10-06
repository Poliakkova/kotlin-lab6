class ReadDouble {
    companion object {
        fun read(valName: String): Double {
            var value = 0.0

            do {
                var entered = true

                try {
                    print("$valName = ")
                    value = readLine()!!.toDouble()

                } catch (e: NumberFormatException) {
                    println("\tError! Wrong number format")
                    entered = false
                }
            } while (!entered)

            return value;
        }
    }
}