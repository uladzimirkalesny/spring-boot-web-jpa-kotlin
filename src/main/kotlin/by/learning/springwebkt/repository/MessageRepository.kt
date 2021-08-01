package by.learning.springwebkt.repository

import by.learning.springwebkt.model.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
interface MessageRepository : JpaRepository<Message, Long> {

    @Transactional
    @Modifying
    @Query("UPDATE Message m SET m.content =:messageContent WHERE m.id =:id")
    fun updateMessageContentById(@Param("id") id: Long, @Param("messageContent") messageContent: String)

}