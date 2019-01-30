package com.campspot

import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class DevOpsChallengeWebServiceApplication : Application<DevOpsChallengeWebServiceConfiguration>() {

  override fun getName(): String {
    return "DevOpsChallengeWebService"
  }

  override fun initialize(bootstrap: Bootstrap<DevOpsChallengeWebServiceConfiguration>?) {
    // TODO: application initialization
  }

  override fun run(configuration: DevOpsChallengeWebServiceConfiguration,
                   environment: Environment) {
    // TODO: implement application
  }

  companion object {

    @Throws(Exception::class)
    @JvmStatic
    fun main(args: Array<String>) {
      DevOpsChallengeWebServiceApplication().run(*args)
    }
  }

}
