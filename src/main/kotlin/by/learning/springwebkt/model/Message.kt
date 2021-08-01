package by.learning.springwebkt.model

import javax.persistence.*

@Entity
@Table(name = "MESSAGES")
data class Message(

        @Id
        @Column(name = "MESSAGE_ID")
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long?,

        @Column(name = "MESSAGE_CONTENT")
        var content: String

)
