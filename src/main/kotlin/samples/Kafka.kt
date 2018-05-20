@file:JvmName("Kafka")
package samples

fun main(args: Array<String>) {
    val option = args[0]

    when (option) {

        "consumer" -> {
            val consumer = Consumer(
                "127.0.0.1:9092",
                "second_topic",
                "groupId")

            consumer.start()
        }
        "producer" -> {
            val producer = Producer("127.0.0.1:9092",
                    "second_topic")

            producer.start()
        }
        else -> {
            println("Unable to execute: producer or consumer?")
        }
    }

}