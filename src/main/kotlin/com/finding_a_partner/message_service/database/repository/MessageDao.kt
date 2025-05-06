package com.finding_a_partner.message_service.database.repository

import com.finding_a_partner.message_service.database.entity.Message
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MessageDao : JpaRepository<Message, Long> {
    fun findBySenderIdOrReceiverId(senderId: Long, receiverId: Long): List<Message>
}