package com.campspot

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class DevOpsChallengeDataServiceApplication : Application<DevOpsChallengeDataServiceConfiguration>() {
  override fun getName(): String {
    return "DevOpsChallengeDataService"
  }

  override fun initialize(bootstrap: Bootstrap<DevOpsChallengeDataServiceConfiguration>?) {
    // TODO: application initialization
  }

  override fun run(configuration: DevOpsChallengeDataServiceConfiguration,
                   environment: Environment) {
    // TODO: implement application
  }

  companion object {
    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
      DevOpsChallengeDataServiceApplication().run(*args)
    }
  }

}
