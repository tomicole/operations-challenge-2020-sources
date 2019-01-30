package com.campspot.lib

import com.campspot.api.HashedName
import com.campspot.api.Name
import com.google.common.hash.Hashing
import java.nio.charset.Charset
import java.util.*
import javax.ws.rs.NotFoundException

class NameLib {
  fun fetchName(id: UUID): HashedName {
    throw NotFoundException("Record with id $id not found")
  }

  fun saveName(name: Name): HashedName {
    return HashedName(
      id = UUID.randomUUID(),
      hash = hashName(name)
    )
  }

  private fun hashName(name: Name): String {
    val hashFunction = Hashing.sha256()
    val hashedBytes = hashFunction
      .hashString("${name.firstName}:${name.lastName}", Charset.forName("UTF-8"))
      .asBytes()

    return String(hashedBytes)
  }
}
