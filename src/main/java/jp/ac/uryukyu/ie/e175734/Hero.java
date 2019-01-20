package jp.ac.uryukyu.ie.e175734;

/**
 * ヒーロークラス。
 */
class Hero extends LivingThing {
    Hero(String name, int hitPoint, int attack){
        super(name, hitPoint, attack);
    }

    @Override
    void wounded(int damage){
        now_hitPoint = now_hitPoint - damage;

        if (now_hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは道半ばで力尽きてしまった。\n", name);
        }
    }
}
