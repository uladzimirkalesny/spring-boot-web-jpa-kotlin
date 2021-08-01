package by.learning.springwebkt.service

import by.learning.springwebkt.model.Message
import by.learning.springwebkt.repository.MessageRepository
import org.springframework.stereotype.Service

@Service
class MessageService(val messageRepository: MessageRepository) {

    fun getMessages(): List<Message> = messageRepository.findAll()

    fun createMessage(message: Message): Message = messageRepository.save(message)

    fun getMessageById(id: Long): Message = messageRepository.getById(id)

    fun removeMessageById(id: Long) = messageRepository.deleteById(id)

    fun updateMessageContent(id: Long, messageContent: String) = messageRepository.updateMessageContentById(id, messageContent)

    fun updateMessageById(id: Long, message: Message): Message {
        val receivedMessage = messageRepository.findById(id)
        receivedMessage.ifPresent { m -> m.content = message.content }

        return messageRepository.save(receivedMessage.get())
    }
}