package jp.ac.uryukyu.ie.e175734;

/**
 * ゲームの敵キャラや味方キャラを生成する際のスーパークラス。
 *
 * String name; //名前。
 * int hitPoint; //体力。
 * int attack; //攻撃力。
 * int now_hitPoint; //現在の体力。
 * boolean dead; //生死状態。true = 死んでいる状態。
 * boolean escape; //逃走状態。true = 逃走に成功した状態。
 */
class LivingThing {
    String name;
    int hitPoint;
    int attack;
    int now_hitPoint;
    boolean dead;
    boolean escape;

    /**
     * コンストラクタ。名前，体力，攻撃力を指定する。
     * 指定された体力を元に現在の体力の初期値を設定する。
     *
     * @param name 名前。
     * @param hitPoint 体力。
     * @param attack 攻撃力。
     */
    LivingThing(String name, int hitPoint, int attack){
        this.name = name;
        this.hitPoint = hitPoint;
        this.attack = attack;
        this.now_hitPoint = hitPoint;
        dead = false;
        escape = false;

        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, hitPoint, attack);
    }

    /**
     * 攻撃するメソッド。
     * 相手が死亡状態，または逃走状態でない時に攻撃する。
     * 体力が５割未満の時，３０％の確率で通常の１．５倍の大ダメージを与える。
     *
     * @param livingThing 本クラス。ここでは，攻撃する相手になる。
     */
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

    /**
     * ダメージ処理をするメソッド。
     * 体力が０以下の時，死亡状態にする。
     *
     * @param damage 受けたダメージ。
     */
    void wounded(int damage){
        now_hitPoint -= damage;

        if (now_hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }

    /**
     * 逃走判定を行うメソッド。
     * 死亡状態でない，かつ逃走に成功している状態でない時，逃走に成功した状態にする。
     *
     * @param random 乱数。逃走の成功確率をこれで判定する。
     * @param perHitPoint 現在の体力をパーセンテージで表したもの。
     */
    void escape(double random, double perHitPoint) {
        if (dead == false && escape == false) {
            if (random <= 0.3 && perHitPoint <= 0.3) {
                escape = true;
                System.out.printf("%sは逃走に成功した。\n", name);
                System.out.printf("%sの勝利！\n", name);
            }
        }
    }
}
