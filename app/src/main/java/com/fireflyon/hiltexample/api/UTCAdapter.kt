package com.fireflyon.hiltexample.api

import com.google.gson.*
import java.lang.reflect.Type
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UTCAdapter @Inject constructor(): JsonSerializer<Date?>, JsonDeserializer<Date?> {

    companion object {
        private const val DATE_FORMAT_STRING = "yyyy-MM-dd'T'HH:mm:ss'Z'"
        private val TIME_ZONE = TimeZone.getTimeZone("UTC")
    }

    @Throws(JsonParseException::class)
    override fun deserialize(json: JsonElement?,
                             typeOfT: Type,
                             context: JsonDeserializationContext
    ): Date? {
        json?.let {
            return when{
                it.isJsonPrimitive.not() -> null
                json.asString.isNullOrEmpty() -> null
                else -> {
                    try {
                        val simpleDateFormat = SimpleDateFormat(DATE_FORMAT_STRING)
                        simpleDateFormat.timeZone =
                            TIME_ZONE
                        simpleDateFormat.parse(json.asString)
                    }catch (e: ParseException){
                        throw JsonParseException(e)
                    }
                }
            }
        } ?: return null
    }

    override fun serialize(src: Date?,
                           typeOfSrc: Type,
                           context: JsonSerializationContext
    ): JsonElement? {
        src?.let {
            val simpleDateFormat = SimpleDateFormat(DATE_FORMAT_STRING)
            simpleDateFormat.timeZone =
                TIME_ZONE
            return JsonPrimitive(simpleDateFormat.format(it))
        } ?: return null
    }
}