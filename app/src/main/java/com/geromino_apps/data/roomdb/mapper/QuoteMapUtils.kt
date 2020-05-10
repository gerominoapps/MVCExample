package com.geromino_apps.data.roomdb.mapper

import com.geromino_apps.data.roomdb.entities.QuoteEntity

class QuoteMapUtils {

    fun mapToDomain(
        from: List<QuoteEntity>
    ): List<com.geromino_apps.domain.entities.QuoteEntity> {
        val toReturn = ArrayList<com.geromino_apps.domain.entities.QuoteEntity>()
        for (entity : QuoteEntity  in from) {
            toReturn.add(com.geromino_apps.domain.entities.QuoteEntity().apply {
                author = entity.author
                quote = entity.quote
                timestamp = entity.timestamp
            })
        }
        return toReturn
    }

    fun mapToDAO(
        from: List<com.geromino_apps.domain.entities.QuoteEntity>
    ): List<QuoteEntity> {
        val toReturn = ArrayList<QuoteEntity>()
        for (entity: com.geromino_apps.domain.entities.QuoteEntity in from) {
            toReturn.add(
                QuoteEntity(author = entity.author, quote = entity.quote, timestamp = entity.timestamp)
            )
        }
        return toReturn
    }
}