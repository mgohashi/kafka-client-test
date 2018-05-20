package samples

import org.apache.kafka.clients.consumer.KafkaConsumer

class Consumer(val bootstrapServer:String,
               val topic: String,
               val groupId: String) {

    fun start() {
        println("Consumer Starting...")

        val props = mutableMapOf<String, String>("bootstrap.servers" to bootstrapServer,
                "enable.auto.commit" to "true",
                "auto.commit.interval.ms" to "1000",
                "group.id" to groupId,
                "key.deserializer" to "org.apache.kafka.common.serialization.StringDeserializer",
                "value.deserializer" to "org.apache.kafka.common.serialization.StringDeserializer")

        val kafkaConsumer = KafkaConsumer<String, String>(props.toProperties())

        kafkaConsumer.subscribe(arrayListOf(this.topic))

        while(true) {
            val consumerRecords = kafkaConsumer.poll(100)

            for (item in consumerRecords) {
                println("partition ${item.partition()}, offset ${item.offset()}, key ${item.key()}, val ${item.value()}")
            }
        }
    }

}