package net.kigawa.kutil.domain.serializable

import kotlinx.serialization.Serializable
import net.kigawa.kutil.domain.serializable.serializer.SerializableUuidSerializer

@Suppress("KotlinNoActualForExpect", "EXPECT_ACTUAL_CLASSIFIERS_ARE_IN_BETA_WARNING")
@Serializable(with = SerializableUuidSerializer::class)
expect open class SerializableUuid(
    strUuid: String,
) {
    val strUuid: String
}