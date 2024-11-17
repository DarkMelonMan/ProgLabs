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

    /**
     * Получить ссылку на объект брони
     * @return ссылка на объект брони
     */
    public Armor GetArmor(){
        return armor;
    }

    /**
     * Получить ссылку на объект оружия
     * @return ссылка на объект оружия
     */
    public Weapon GetWeapon(){
        return weapon;
    }

    /**
     * Получить урон
     * @param baseDamage - базовый урон
     * @param elementDamage - стихийный урон
     * @param damageType - тип стихийного урона
     */
    public void Hurt(double baseDamage, double elementDamage, Element damageType){
        hurt(armor.GetActualDamage(baseDamage, elementDamage, damageType));
    }

    /**
     * Атаковать монстра
     * @param monster - ссылка на объект монстра
     */
    public void AttackMonster(MonsterEntity monster){
        monster.Hurt(weapon.GetDamage(monster.GetMonsterWeakness()));
    }

    /**
     * Вывод всех полей объекта игрока
     */
    public void Print(){
        super.Print();
        armor.Print();
        weapon.Print();
    }
}
