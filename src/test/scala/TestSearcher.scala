import com.adevinta.Searcher
import org.scalatest._
import flatspec._
import matchers._

class TestSearcher extends AnyFlatSpec with should.Matchers {

  it should "return the rank equals to 50 % for the attached file and passed words" in {
    val rank = Searcher.testSearch(Array[String]("vijay", "vaswani"),"./TestDir/").right.get.head._2
    assert(rank==50.0)
  }

  it should "return 'no matches found' when none of the matches" in {
    val message = Searcher.testSearch(Array[String]("ajay", "vaswani"),"./TestDir/").left.get
    assert(message=="no matches found")
  }

  it should "throw IllegalArgumentException if " in {
    a[IllegalArgumentException] should be thrownBy {
      Searcher.main(Array())
    }
  }
}
