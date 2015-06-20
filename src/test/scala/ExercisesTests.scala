import ex2.Exercise2
import org.scalatest.FunSuite

/**
 * Created by besil on 20/06/15.
 */
class ExercisesTests extends FunSuite {

  test("Case limits") {
    assert(Exercise2.leftTruncate(-1) == List())
  }

  test("Case0") {
    assert(Exercise2.leftTruncate(0) == List(0))
  }

  test("Case1234") {
    assert(Exercise2.leftTruncate(1234) == List(1234, 234, 34, 4))
  }

}
