package jp.ac.uryukyu.ie.e175734;

class LivingThing {
    String name;
    int hitPoint;
    int attack;
    int now_hitPoint;
    boolean dead;

    LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        this.now_hitPoint = hitPoint;
        dead = false;

        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    void attack(LivingThing livingThing){
        int damage;
        double random;

        random = Math.random();

        if (dead == false) {
            if ((now_hitPoint / hitPoint) < 0.3 && random < 0.3) {
                damage = (int) (Math.random() * attack * 1.5);
                System.out.printf("%sの攻撃！%sに%dの大ダメージを与えた！\n", name, livingThing.name, damage);
            } else {
                damage = (int) (Math.random() * attack);
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！\n", name, livingThing.name, damage);
            }
            livingThing.wounded(damage);
        }
    }

    void wounded(int damage){
        now_hitPoint = now_hitPoint - damage;

        if (now_hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
