import org.scalatest._


//attackpwr: Int, defense: Int, magicattack: Int, magicdefense: Int, maxHP: Int, maxMP: Int

class TestSuite extends FunSuite {
  test("A test for lab game"){
    var character1: Character = new Character(65, 40, 30, 20, 100, 100)
    var character2: Character = new Character(70, 40, 40,30, 100, 100)
    var thanos: Character = new Character(100, 100, 100,100, 100, 100)

    character1.takeDamage(70)
    character2.takeDamage(1000)

    assert(character1.currentHP == 70)
    assert(character2.living == false, character2.living)
  }

}
