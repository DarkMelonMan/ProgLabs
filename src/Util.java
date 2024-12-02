public class Util {
    public enum Element{
        NONE,
        FIRE,
        MAGIC,
        LIGHTING
    }

    /**
     * Получить общее количество урона, наносимое монстру
     * @param weakness - Тип стихийной слабости монстра
     * @return Общее количество урона с учётом стихийного и физического урона
     */
    public static double CalculatePlayerDamage(Weapon weapon, Element weakness) {
        double damage = weapon.getBaseDamage();
        if (weakness == weapon.getDamageType() && weakness != Util.Element.NONE)
            damage += weapon.getElementDamage();
        else if (weakness != Util.Element.NONE)
            damage += weapon.getElementDamage() * 0.5;
        return damage;
    }

    /**
     * Получить общее количество урона
     * @param armor - ссылка на объект брони
     * @param monster - ссылка на объект монстра
     * @return общее количество урона с учётом базового и стихийного
     */
    public static double CalculateMonsterDamage(Armor armor, MonsterEntity monster){
        double damage = monster.getBaseDamage() * (1 - armor.getBaseDefence() / 100);
        if (armor.getDefenceType() == monster.getDamageType() && monster.getDamageType() != Util.Element.NONE)
            damage += monster.getElementDamage() * (1 - armor.getElementDefence() / 100);
        else if (monster.getDamageType() != Util.Element.NONE) damage += monster.getElementDamage();
        return damage;
    }
}
