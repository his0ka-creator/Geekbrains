package geekbrains;

public class Lesson06 {
    public static void main(String[] args){
        Cat c1 = new Cat("Матильда");
        Cat c2 = new Cat ("Кнопка");
        Dog d1 = new Dog ("Бобик");
        Dog d2 = new Dog ("Тузик");
        c1.run(250);
        c1.swim(300);
        c2.run(200);
        c2.swim(100);
        d1.run(890);
        d1.swim(7);
        d2.run(300);
        d2.swim(11);
        d2.run(-3);
        System.out.println("Всего было создано кошек: "+Cat.catCount);
        System.out.println("Всего было создано собак: "+Dog.dogCount);
        System.out.println("Всего было создано животных: " + Animal.count);
    }
}

class Animal {
    String name;
    static int count=0;
    Animal(String name){
        this.name = name;
        count++;
    }

    public void run(int distance){
        if (distance<0) {System.out.println("Error #1"); return;}
        System.out.printf("%s пробежал %d метров.\n", name, distance);
    }
    public void swim(int distance){
        if (distance<0) {System.out.println("Error #2"); return;}
        System.out.printf("%s проплыл %d метров.\n", name, distance);
    }


}

class Dog extends Animal{
    static int dogCount=0;
    public Dog(String name){
        super(name);
        dogCount++;
    }

    @Override
    public void run(int distance) {
        if (distance>500){System.out.println("Собаки не могут бежать так далеко. ");return;}
        super.run(distance);
    }
    @Override
    public void swim(int distance){
        if (distance>10){System.out.println("Собаки не умеют плавать так далеко. "); return;}
        super.swim(distance);
    }
}

class Cat extends Animal{
    static int catCount=0;
    public Cat(String name){
        super(name);
        catCount++;
    }

    @Override
    public void run(int distance){
        if (distance > 200){System.out.println("Кошки не умеют бегать так далеко"); return;}
        super.run(distance);
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кошки не умеют плавать");
    }
}
