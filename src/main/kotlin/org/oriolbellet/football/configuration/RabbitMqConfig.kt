package org.oriolbellet.football.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitMqConfig {

    val topicExchangeName = "football-exchange"
    val queueName = "play-match"

    @Bean
    fun queue(): Queue {
        return Queue(queueName, false)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(topicExchangeName)
    }

    @Bean
    fun binding(queue: Queue, exchange: TopicExchange?): Binding {
        return BindingBuilder.bind(queue).to(exchange).with("com.oriolbellet.football.play-match")
    }

}