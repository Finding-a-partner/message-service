package com.finding_a_partner.message_service.service.impl

import com.finding_a_partner.message_service.database.entity.Message
import com.finding_a_partner.message_service.database.repository.MessageDao
import com.finding_a_partner.message_service.mapper.MessageMapper
import com.finding_a_partner.message_service.model.request.MessageRequest
import com.finding_a_partner.message_service.model.response.MessageResponse
import com.finding_a_partner.message_service.service.ChatService
import com.finding_a_partner.message_service.service.MessageService
import org.springframework.stereotype.Service

@Service
class MessageServiceImpl(
    val dao: MessageDao,
    val chatService: ChatService,
    val mapper: MessageMapper,
) : MessageService {
    override fun sendMessage(request: MessageRequest): MessageResponse {
        val chat = chatService.getEntityById(request.chatId)
        val entity = Message(
            chat = chat,
            senderId = request.senderId,
            content = request.content,
        )

        return mapper.entityToResponse(dao.save(entity))
    }
}
