class Character(attackpwr: Int, defense: Int, magicattack: Int, magicdefense: Int, maxHP: Int, maxMP: Int) {

  var currentHP: Int = maxHP
  var currentMP: Int = maxMP
  var living: Boolean = true

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


  }
