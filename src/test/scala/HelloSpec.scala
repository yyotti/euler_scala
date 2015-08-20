import org.specs2.mutable._

class HelloSpec extends Specification {
  "Hello" should {
    "have tests" in {
      true must beTrue
    }
  }
}
