package geekbrains.Lesson07;

public class Bowl {
    private int currentFoodVolume;

    public Bowl(int FoodVolume){
        currentFoodVolume=FoodVolume;
    }

    public int getCurrentFoodVolume() {
        return currentFoodVolume;
    }

    public void info(){
        System.out.printf("Current food amount in the bowl is %s\n", currentFoodVolume);
    }

    public void increaseFoodAmount(int foodAmount){
        currentFoodVolume+=foodAmount;
    }

    public void decreaseFoodAmount(int foodAmount){
        currentFoodVolume-=foodAmount;
    }
}
