package net.kigawa.kutil.domain.serializable

import kotlinx.serialization.Serializable
import net.kigawa.kutil.domain.serializable.serializer.SerializableUuidSerializer

@Suppress("EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Serializable(with = SerializableUuidSerializer::class)
open class SerializableUuid(
    val strUuid: String,
) {
}