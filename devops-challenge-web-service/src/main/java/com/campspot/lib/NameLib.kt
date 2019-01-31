package com.campspot.lib

import com.campspot.api.HashedName
import com.campspot.api.Name
import com.campspot.db.CacheClient
import com.google.common.hash.Hashing
import java.nio.charset.Charset
import java.util.*

class NameLib(private val cacheClient: CacheClient) {
  fun fetchName(id: UUID): HashedName {
    return cacheClient.getName(id)
  }

  fun saveName(name: Name): HashedName {
    val hashed = HashedName(
      id = UUID.randomUUID(),
      hash = hashName(name)
    )

    cacheClient.setName(hashed)
    return hashed
  }

  private fun hashName(name: Name): String {
    val hashFunction = Hashing.sha256()
    val hashedBytes = hashFunction
      .hashString("${name.firstName}:${name.lastName}", Charset.forName("UTF-8"))
      .asBytes()

    return String(hashedBytes)
  }
}
