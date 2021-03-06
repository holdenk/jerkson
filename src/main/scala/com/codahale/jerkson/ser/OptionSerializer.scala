package com.codahale.jerkson.ser

import org.codehaus.jackson.JsonGenerator
import org.codehaus.jackson.map.{SerializerProvider, JsonSerializer}
import org.codehaus.jackson.map.annotate.JsonCachable

@JsonCachable
class OptionSerializer extends JsonSerializer[Option[_]] {
  def serialize(value: Option[_], json: JsonGenerator,
                provider: SerializerProvider) {
    if (value.isDefined) {
      val obj = value.get.asInstanceOf[Object]
      val serializer = provider.findValueSerializer(obj.getClass, null)
      serializer.serialize(obj, json, provider)
    } else {
      json.writeNull()
    }
  }
}
