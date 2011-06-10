package com.codahale.jerkson.tests

import com.codahale.simplespec.Spec
import org.codehaus.jackson.map.`type`._
import com.codahale.jerkson.ScalaTypeModifier

class ScalaTypeModifierSpec extends Spec {
  private val typeFactory = TypeFactory.defaultInstance.withModifier(ScalaTypeModifier)

  class `Constructing the type from a Seq` {
    def `should return a CollectionLikeType` {
      typeFactory.constructType(classOf[Seq[_]]).toString must
        beEqualTo("[collection-like type;" +
                  " class scala.collection.Seq," +
                  " contains [simple type, class java.lang.Object]]")
    }
  }

  class `Constructing the type from a IndexedSeq` {
    def `should return a CollectionLikeType` {
      typeFactory.constructType(classOf[IndexedSeq[_]]).toString must
        beEqualTo("[collection-like type;" +
                  " class scala.collection.IndexedSeq," +
                  " contains [simple type, class java.lang.Object]]")
    }
  }

  class `Constructing the type from a List` {
    def `should return a CollectionLikeType` {
      typeFactory.constructType(classOf[List[_]]).toString must
        beEqualTo("[collection-like type;" +
                  " class scala.collection.immutable.List," +
                  " contains [simple type, class java.lang.Object]]")
    }
  }

  class `Constructing the type from a Vector` {
    def `should return a CollectionLikeType` {
      typeFactory.constructType(classOf[Vector[_]]).toString must
        beEqualTo("[collection-like type;" +
                  " class scala.collection.immutable.Vector," +
                  " contains [simple type, class java.lang.Object]]")
    }
  }

  class `Constructing the type from a Set` {
    def `should return a CollectionLikeType` {
      typeFactory.constructType(classOf[Set[_]]).toString must
        beEqualTo("[collection-like type;" +
                  " class scala.collection.immutable.Set," +
                  " contains [simple type, class java.lang.Object]]")
    }
  }

  class `Constructing the type from a Map` {
    def `should return a MapLikeType` {
      typeFactory.constructType(classOf[Map[_,_]]).toString must
        beEqualTo("[map-like type;" +
                  " class scala.collection.immutable.Map," +
                  " [simple type, class java.lang.Object] ->" +
                  " [simple type, class java.lang.Object]]")
    }
  }
}
