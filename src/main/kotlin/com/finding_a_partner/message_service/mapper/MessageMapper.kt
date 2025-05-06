package com.finding_a_partner.message_service.mapper

import com.finding_a_partner.message_service.database.entity.Message
import com.finding_a_partner.message_service.model.response.MessageResponse
import org.springframework.stereotype.Component

@Component
class MessageMapper {
    fun entityToResponse(entity: Message): MessageResponse =
        MessageResponse(
            id = entity.id,
            chat = entity.chat,
            senderId = entity.senderId,
            content = entity.content,
            createdAt = entity.createdAt,
            status = entity.status,
        )
}
