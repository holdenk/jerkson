package com.codahale.jerkson

import java.lang.reflect.Type
import org.codehaus.jackson.`type`.JavaType
import org.codehaus.jackson.map.`type`._

/**
 * A {@link TypeModifier}.
 */
object ScalaTypeModifier extends TypeModifier {
  private val ObjectType = SimpleType.construct(classOf[AnyRef])

  def modifyType(javaType: JavaType,
                 jdkType: Type,
                 context: TypeBindings,
                 typeFactory: TypeFactory) = {
    jdkType match {
      case klass: Class[_] if classOf[Seq[_]].isAssignableFrom(klass) =>
        CollectionLikeType.construct(klass, ObjectType)
      case klass: Class[_] if classOf[Set[_]].isAssignableFrom(klass) =>
        CollectionLikeType.construct(klass, ObjectType)
      case klass: Class[_] if classOf[Map[_,_]].isAssignableFrom(klass) =>
        MapLikeType.construct(klass, ObjectType, ObjectType)
      case _ => javaType
    }
  }
}
