package com.finding_a_partner.message_service.controller

import com.finding_a_partner.message_service.model.request.ChatRequest
import com.finding_a_partner.message_service.model.response.ChatDetailResponse
import com.finding_a_partner.message_service.model.response.ChatResponse
import com.finding_a_partner.message_service.service.ChatService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/chats")
class ChatController(
    val service: ChatService,
) {
    @GetMapping()
    fun getAll(): List<ChatResponse> = service.getAll()

//    создать чат
    @PostMapping
    fun create(
        @RequestBody request: ChatRequest,
        @RequestHeader("X-User-Id") userId: Long,
    ): ChatResponse =
        service.create(userId, request)

//    получить чат + участников
    @GetMapping("/{chatId}")
    fun getById(@PathVariable("chatId") chatId: Long): ChatDetailResponse =
        service.getChatWithParticipantsById(chatId)

    @PutMapping("/{chatId}")
    fun update(
        @PathVariable("chatId") chatId: Long,
        @RequestBody request: ChatRequest,
    ) = service.update(chatId, request)

    @DeleteMapping("/{chatId}")
    fun delete(@PathVariable("chatId") chatId: Long) = service.delete(chatId)
}
