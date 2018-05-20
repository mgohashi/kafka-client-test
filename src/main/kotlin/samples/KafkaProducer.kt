package samples

import org.apache.kafka.clients.producer.KafkaProducer
import org.apache.kafka.clients.producer.ProducerRecord

class Producer(val bootstrapServer:String,
               val topic: String) {

    fun start() {
        println("Consumer Starting...")

        val props = mapOf("bootstrap.servers" to bootstrapServer,
                "acks" to "1",
                "retries" to "3",
                "auto.commit.interval.ms" to "1000",
                "key.serializer" to "org.apache.kafka.common.serialization.StringSerializer",
                "value.serializer" to "org.apache.kafka.common.serialization.StringSerializer")

        val kafkaProducer = KafkaProducer<String, String>(props.toProperties())

        for (index in 1..100) {
            val producerRecord = ProducerRecord<String, String>(this.topic, "${index}")

            kafkaProducer.send(producerRecord)
        }
        kafkaProducer.flush()
    }

}