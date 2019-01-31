package com.campspot.healthchecks

import com.codahale.metrics.health.HealthCheck
import redis.clients.jedis.JedisPool


class RedisHealthCheck(private val redisPool: JedisPool): HealthCheck() {
  override fun check(): Result {
    try {
      redisPool.resource.use { redis ->
        val pong = redis.ping()

        if (pong.isNullOrBlank()) {
          return Result.unhealthy("Redis PING failed")
        }

        return Result.healthy()
      }
    } catch (e: Exception) {
      return Result.unhealthy(e)
    }
  }
}
