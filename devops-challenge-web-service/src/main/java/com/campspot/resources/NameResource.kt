package com.campspot.resources

import com.campspot.api.HashedName
import com.campspot.api.Name
import com.campspot.lib.NameLib
import com.codahale.metrics.annotation.Timed
import javax.validation.Valid
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Path("/names")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
class NameResource(private val nameLib: NameLib) {
  @GET
  @Timed
  @Valid
  fun fetchNames(): Set<HashedName> {
    return nameLib.fetchNames()
  }

  @POST
  @Timed
  @Valid
  fun saveName(@Valid name: Name): HashedName {
    return nameLib.saveName(name)
  }
}
