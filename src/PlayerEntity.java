/**
 * Класс игроков
 */
public class PlayerEntity extends LivingEntity {
    private Armor armor;
    private Weapon weapon;

    public PlayerEntity(String name, double healthPoints, double movementSpeed, Armor armor, Weapon weapon){
        super(name, healthPoints, movementSpeed);
        this.armor = armor;
        this.weapon = weapon;
    }

    public PlayerEntity(){
        super();
        inputFields();
    }

    /**
     * Ввод всех полей объекта игрока
     */
    private void inputFields(){
        armor = new Armor();
        weapon = new Weapon();
    }

    public Armor GetArmor(){
        return armor;
    }

    public Weapon GetWeapon(){
        return weapon;
    }

    public void Hurt(double baseDamage, double elementDamage, Element damageType){
        hurt(armor.GetActualDamage(baseDamage, elementDamage, damageType));
    }

    public void AttackMonster(MonsterEntity monster){
        monster.Hurt(weapon.GetDamage(monster.GetMonsterWeakness()));
    }

    public void Print(){
        super.Print();
        armor.Print();
        weapon.Print();
    }
}
