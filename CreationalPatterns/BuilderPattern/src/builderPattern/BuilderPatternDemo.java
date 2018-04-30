package builderPattern;

public class BuilderPatternDemo {
    public static void main(String[] args) {
        
        MealBuilder mealBuilder = new MealBuilder();
        
        Meal cheeseBurgerMeal = mealBuilder.prepareCheeseMeal();
        
        System.out.println("Cheese Burger Meal:");
        cheeseBurgerMeal.showItems();
        System.out.println("Total cost: "+ cheeseBurgerMeal.getCost());
        
        Meal chickenBurgerMeal = mealBuilder.prepareChickenMeal();
        chickenBurgerMeal.showItems();
        System.out.println("Total cost: "+ chickenBurgerMeal.getCost());
    }
}
