package builderPattern;

public class MealBuilder {
    
    public Meal prepareCheeseMeal(){
        Meal meal = new Meal();
        meal.addItem(new CheeseBurger());
        meal.addItem(new Coke());
        return meal;
    }
    
    public Meal prepareChickenMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
