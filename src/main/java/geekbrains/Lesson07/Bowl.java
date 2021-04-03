package geekbrains.Lesson07;

public class Bowl {
    private int currentFoodVolume;

    public Bowl(int FoodVolume){
        currentFoodVolume=FoodVolume;
    }

    public int getCurrentFoodVolume() {
        return currentFoodVolume;
    }

    public void setCurrentFoodVolume(int foodVolume){
        currentFoodVolume=foodVolume;
    }

    public void addFoodAmount(int foodAmount){
        setCurrentFoodVolume(getCurrentFoodVolume()+foodAmount);
    }
}
