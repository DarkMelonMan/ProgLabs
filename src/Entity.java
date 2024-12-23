public abstract class Entity {
    protected double healthPoints;

    /**
     * Получить урон
     * @param damage - количество урона
     */
    public void hurt(double damage){
        healthPoints -= damage;
        if (healthPoints <= 0) {
            healthPoints = 0;
        }
    }
    abstract protected void inputFields();
    abstract public void Print();

    /**
     * Получить количество очков здоровья
     * @return количество очков здоровья
     */
    public double GetHealthPoints(){
        return healthPoints;
    }
}
