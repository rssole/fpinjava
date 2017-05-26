package com.fpinjava.makingjavafunctional.exercise03_01.mine;

public interface Result {

    void applyEffect();

    abstract class ResultBase<T> implements Result {

        private final T effectParam;
        private final Effect<T> effect;

        public ResultBase(T effectParam, Effect<T> effect) {
            this.effectParam = effectParam;
            this.effect = effect;
        }

        @Override
        public void applyEffect() {
            effect.invoke(effectParam);
        }
    }

    class Success<T> extends ResultBase<T> {
        public Success(T effectParam, Effect<T> effect) {
            super(effectParam, effect);
        }
    }

    class Failure<T> extends ResultBase<T> {
        public Failure(T effectParam, Effect<T> effect) {
            super(effectParam, effect);
        }
    }
}
