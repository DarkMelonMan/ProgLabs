/**
 * Класс игроков
 */
public class PlayerEntity extends LivingEntity implements IAttack {
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
    @Override
    protected void inputFields() {
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
     * @param monster - ссылка на объект монстра
     */
    public void hurt(MonsterEntity monster){
        hurt(Util.CalculateMonsterDamage(armor, monster));
    }

    /**
     * Атаковать другую сущность
     * @param entity - ссылка на объект сущности
     */
    public void Attack(LivingEntity entity){
        if (entity instanceof MonsterEntity)
            ((MonsterEntity)entity).Hurt(Util.CalculatePlayerDamage(weapon, ((MonsterEntity)entity).GetMonsterWeakness()));
        else entity.hurt(Util.CalculatePlayerDamage(weapon));
    }


    @Override
    public String toString(){
        return super.toString() + armor + weapon;
    }
}
