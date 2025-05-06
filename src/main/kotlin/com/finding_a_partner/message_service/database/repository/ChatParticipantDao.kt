package com.finding_a_partner.message_service.database.repository

import com.finding_a_partner.message_service.database.entity.ChatParticipant
import com.finding_a_partner.message_service.enum.ParticipantType
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ChatParticipantDao : JpaRepository<ChatParticipant, Long> {
    fun findAllByParticipantIdAndParticipantType(
        participantId: Long,
        participantType: ParticipantType,
    ): List<ChatParticipant>

    fun findAllByChatId(
        chatId: Long,
    ): List<ChatParticipant>
}
