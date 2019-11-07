package Game

class Bruiser(var attackpwr: Int, var defense: Int, var magicattack: Int, var magicdefense: Int, var maxHP: Int, var maxMP: Int, var xp: Int, var level: Int, var power1: Boolean, var power2: Boolean, var power3: Boolean) extends
  Character(attackpwr, defense, magicattack, magicdefense, maxHP, maxMP,xp, level, power1, power2, power3){

  override def battleOptions(): List[String] = {

    this.listpowers

  }

  override def takeAction(action: String, character: Character): Unit = {

  }

}
