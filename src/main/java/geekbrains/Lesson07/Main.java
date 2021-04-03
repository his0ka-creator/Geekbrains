package geekbrains.Lesson07;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Cat[] catArr = {
                new Cat("Barsik", 135),
                new Cat("Murzilka", 328),
                new Cat("Albert", 473),
                new Cat("Murka", 757) };
        ArrayList<Cat> stillHungryCats = new ArrayList<Cat>(catArr.length);
        Bowl catBowl = new Bowl(300);
        for (Cat c: catArr){
            c.eat(catBowl);
        }

        for (Cat c: catArr){
            if (c.getIsBellyful()) System.out.printf("%s is bellyful\n",c.getName());
            else {
                System.out.printf("%s is still hungry!!!!\n", c.getName());
                stillHungryCats.add(c);
            }
        }

        int requiredFoodAmount = 0;
        for (Cat c: catArr){
            if (!c.getIsBellyful()) requiredFoodAmount+=c.getAppetite();
        }

        catBowl.addFoodAmount(requiredFoodAmount);

        for(Cat c: catArr){
            c.eat(catBowl);
        }

        for(Cat c: stillHungryCats){
            System.out.printf("%s is bellyful at last!\n",c.getName());
        }

    }
}
