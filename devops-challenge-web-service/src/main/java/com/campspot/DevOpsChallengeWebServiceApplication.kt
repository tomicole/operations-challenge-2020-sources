package com.campspot

import com.campspot.configuration.DevOpsChallengeWebServiceConfiguration
import com.campspot.db.CacheClient
import com.campspot.lib.NameLib
import com.campspot.resources.NameResource
import com.fasterxml.jackson.module.kotlin.KotlinModule
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment
import redis.clients.jedis.JedisPool

class DevOpsChallengeWebServiceApplication : Application<DevOpsChallengeWebServiceConfiguration>() {
  override fun getName(): String {
    return "DevOpsChallengeWebService"
  }

  override fun initialize(bootstrap: Bootstrap<DevOpsChallengeWebServiceConfiguration>) {
    bootstrap.objectMapper.registerModule(KotlinModule())
  }

  override fun run(configuration: DevOpsChallengeWebServiceConfiguration,
                   environment: Environment) {

    val redisPool = JedisPool(configuration.redis.host, configuration.redis.port)
    val cacheClient = CacheClient(redisPool = redisPool, mapper = environment.objectMapper)
    val nameLib = NameLib(cacheClient = cacheClient)

    environment.jersey().register(NameResource(nameLib))
  }

  companion object {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
      DevOpsChallengeWebServiceApplication().run(*args)
    }
  }
}
