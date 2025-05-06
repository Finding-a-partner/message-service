package com.finding_a_partner.message_service.controller

import com.finding_a_partner.message_service.database.entity.Message
import com.finding_a_partner.message_service.model.request.MessageRequest
import com.finding_a_partner.message_service.model.response.MessageResponse
import com.finding_a_partner.message_service.service.MessageService
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.SendTo
import org.springframework.stereotype.Controller

@Controller
class MessageController(
    private val service: MessageService,
) {

    @MessageMapping("/chat.sendMessage")
    @SendTo("/topic/chat")
    fun sendMessage(message: MessageRequest): MessageResponse = service.sendMessage(message)
}