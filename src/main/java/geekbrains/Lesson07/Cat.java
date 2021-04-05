package geekbrains.Lesson07;

public class Cat {
    private String name;
    private boolean isBellyful;
    private int appetite;

    public Cat(){
        this.isBellyful=false;
    }

    public Cat(String name, int appetite){
        this();
        this.name=name;
        this.appetite=appetite;
    }

    public String getName() {
        return name;
    }

    public int getAppetite() {
        return appetite;
    }

    public boolean getIsBellyful() {
        return isBellyful;
    }

    public void setIsBellyful(boolean state){
        this.isBellyful=state;
    }


    public void eat(Bowl bowl){
        if (appetite > bowl.getCurrentFoodVolume()){
            System.out.printf("There is not enough food for %s in this bowl... Maybe you can add some?\n", name);
        }
        else {
            bowl.decreaseFoodAmount(appetite);
            this.setIsBellyful(true);
            System.out.printf("%s has eaten.\n", name);
        }
    }
}
