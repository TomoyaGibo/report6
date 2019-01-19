package jp.ac.uryukyu.ie.e175734;

public class Main {
    public static void main(String[] args) {
        Hero hero = new Hero("勇者", 10, 3);
        Enemy enemy = new Enemy("スライム", 10, 3);

        System.out.printf("%s vs %s\n", hero.name, enemy.name);

        int turn = 0;
        while (hero.dead == false && enemy.dead == false){
            turn++;
            System.out.printf("%dターン目開始！\n", turn);
            hero.attack(enemy);
            enemy.attack(hero);
        }

        System.out.println("戦闘終了");
    }
}