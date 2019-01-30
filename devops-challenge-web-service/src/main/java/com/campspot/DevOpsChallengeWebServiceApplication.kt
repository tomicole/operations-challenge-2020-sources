package com.campspot

import com.campspot.lib.NameLib
import com.campspot.resources.NameResource
import io.dropwizard.Application
import io.dropwizard.setup.Bootstrap
import io.dropwizard.setup.Environment

class DevOpsChallengeWebServiceApplication : Application<DevOpsChallengeWebServiceConfiguration>() {

  override fun getName(): String {
    return "DevOpsChallengeWebService"
  }

  override fun initialize(bootstrap: Bootstrap<DevOpsChallengeWebServiceConfiguration>?) {}

  override fun run(configuration: DevOpsChallengeWebServiceConfiguration,
                   environment: Environment) {
    val nameLib = NameLib()
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
