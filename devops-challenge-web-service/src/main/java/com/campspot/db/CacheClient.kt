package com.campspot.db

import com.campspot.api.HashedName
import com.fasterxml.jackson.databind.ObjectMapper
import javassist.NotFoundException
import redis.clients.jedis.JedisPool
import java.util.*

class CacheClient(private val redisPool: JedisPool, private val mapper: ObjectMapper) {
  fun getName(id: UUID): HashedName {
    redisPool.resource.use { redis ->
      val json = redis.get(id.toString()) ?: throw NotFoundException("Record with ID: $id not found")

      return mapper.readValue(json, HashedName::class.java)
    }
  }

  fun setName(hashed: HashedName) {
    redisPool.resource.use { redis ->
      val json = mapper.writeValueAsString(hashed)

      redis.set(hashed.id.toString(), json)
    }
  }

  fun getIds(): Collection<UUID> {
    redisPool.resource.use { redis ->
      return redis.keys("*").map { UUID.fromString(it) }
    }
  }
}
