package com.campspot.configuration

import io.dropwizard.Configuration

data class DevOpsChallengeWebServiceConfiguration(
  val redis: RedisConfiguration
) : Configuration()
