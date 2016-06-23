package io.pivotal.tg;


public enum Discipline {
    JUDO {
        @Override
        public String toString() {
            return "judo";
        }
    },
    BJJ {
        @Override
        public String toString() {
            return "bjj";
        }
    }
}
