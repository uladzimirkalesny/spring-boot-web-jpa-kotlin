package by.learning.springwebkt.controller

import by.learning.springwebkt.model.Message
import by.learning.springwebkt.service.MessageService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController()
@RequestMapping("/api/messages")
class MessageController(val messageService: MessageService) {

    @GetMapping("/all")
    fun getMessages(): List<Message> = messageService.getMessages()

    @GetMapping("/message/{id}")
    fun getMessageById(@PathVariable("id") id: Long): ResponseEntity<Message> =
            ResponseEntity(messageService.getMessageById(id), HttpStatus.OK)

    @PostMapping("/message/add")
    fun createMessage(@RequestBody message: Message): ResponseEntity<Message> =
            ResponseEntity(messageService.createMessage(message), HttpStatus.CREATED)

    @DeleteMapping("/message/{id}")
    fun removeMessage(@PathVariable("id") id: Long): ResponseEntity<String> {
        messageService.removeMessageById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }

    @PatchMapping("/message/{id}")
    fun updateMessageContent(@PathVariable("id") id: Long, @RequestBody message: Message): ResponseEntity<Message> {
        messageService.updateMessageContent(id, message.content)
        return ResponseEntity(messageService.getMessageById(id), HttpStatus.OK)
    }

    @PutMapping("/message/{id}")
    fun updateMessage(@PathVariable("id") id: Long, @RequestBody message: Message): ResponseEntity<Message> {
        return ResponseEntity(messageService.updateMessageById(id, message), HttpStatus.OK)
    }

}