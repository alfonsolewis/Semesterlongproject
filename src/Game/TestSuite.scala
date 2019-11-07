package Game

import org.scalatest._


//attackpwr: Int, defense: Int, magicattack: Int, magicdefense: Int, maxHP: Int, maxMP: Int

class TestSuite extends FunSuite {
  test("A test for lab game"){
    var character1: Character = new Archer(65, 40, 30, 20, 100, 100,10, 1, false, false, false)
    var character2: Character = new Saboteur(70, 40, 40,30, 100, 100, 10, 2, true, false, false)
    var thanos: Character = new Bruiser(100, 100, 100,100, 100, 100, 10, 3, true, false, false)

    character1.takeDamage(70)
    character2.takeDamage(1000)
    thanos.levelUp()

    assert(character1.currentHP == 70)
    assert(character2.living == false, character2.living)
    assert(thanos.health == 100)
    //assert(thanos.levell == 4)

  }

}
