package Game

import play.api.libs.json.{JsValue, Json}

abstract class Character(attackpwr: Int, defense: Int, magicattack: Int, magicdefense: Int, maxHP: Int, maxMP: Int, xp: Int,
                level: Int, power1: Boolean, power2: Boolean, power3: Boolean) {

  var currentHP: Int = maxHP
  var currentMP: Int = maxMP
  var living: Boolean = true

  var excess: Int = 0
  var gainedxp: Int = 0
  var xpp = this.xp
  var levell = this.level
  var health: Int = 100

  var p1: String = ""
  var p2: String = ""
  var p3: String = ""

  var listpowers: List[String] = List()


  def takeDamage(damagetaken: Int): Unit = {
    this.currentHP -= (damagetaken - defense)


    if(this.currentHP <= 0){
      this.living = false
    }
  }

  def physicalAttack(acharacter: Character): Unit = {
    takeDamage(this.attackpwr)
  }

  def magicAttack(bcharacter: Character): Unit = {

    if(bcharacter.currentMP >= 45 && bcharacter.currentMP > 0){
      takeDamage(magicattack)
      this.currentHP += this.magicdefense
      bcharacter.currentMP -= 45
    }

    else if(bcharacter.currentMP > 0){
      takeDamage(magicattack)
      this.currentHP += this.magicdefense
      bcharacter.currentMP -= 25
    }

  }

  def levelUp(): Unit = {
    this.level += 1
    if(this.level == 4){
      this.power2 = true
    }
  }



  def battleOptions(): List[String]

  def takeAction(action: String, character: Character)


  class CharacterObject(var x: Int, var y: Int) {


    def asJsValue(id: String = ""): JsValue ={
      var messageMap: Map[String, JsValue] = Map("x" -> Json.toJson(x), "y" -> Json.toJson(y))
      if(id != ""){
        messageMap += "id" -> Json.toJson(id)
      }
      Json.toJson(messageMap)
    }

    val charactermap: Map[String, CharacterObject] = Map()


    def stopParty(acharacter: CharacterObject): Unit = {

      acharacter.x = 0
      acharacter.y = 0

    }

  }


}
