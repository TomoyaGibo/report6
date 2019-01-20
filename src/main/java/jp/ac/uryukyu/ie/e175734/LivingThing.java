package jp.ac.uryukyu.ie.e175734;

class LivingThing {
    String name;
    int hitPoint;
    int attack;
    int now_hitPoint;
    boolean dead;
    boolean escape;

    LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        this.now_hitPoint = hitPoint;
        dead = false;
        escape = false;

        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    void attack(LivingThing livingThing){
        int damage;
        double random;
        double perHitPoint;

        random = Math.random();
        perHitPoint = (double)(now_hitPoint) / (double)(hitPoint);

        if (dead == false && escape == false) {
            if (perHitPoint < 0.5 && random <= 0.3) {
                damage = (int) (Math.random() * attack * 1.5);
                System.out.printf("%sの攻撃！%sに%dの大ダメージを与えた！\n", name, livingThing.name, damage);
            } else {
                damage = (int) (Math.random() * attack);
                System.out.printf("%sの攻撃！%sに%dのダメージを与えた！\n", name, livingThing.name, damage);
            }
            livingThing.wounded(damage);
            livingThing.escape(random, perHitPoint);
        }
    }

    void wounded(int damage){
        now_hitPoint = now_hitPoint - damage;

        if (now_hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    void escape(double random, double perHitPoint) {
        if (dead == false && escape == false) {
            if (perHitPoint <= 0.3 && random <= 0.3) {
                escape = true;
                System.out.printf("%sは逃走に成功した。\n", name);
                System.out.printf("%sの勝利！\n", name);
            }
        }
    }
}
