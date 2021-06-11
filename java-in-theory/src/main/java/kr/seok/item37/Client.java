package kr.seok.item37;

import java.util.*;

class Client {
    public void addPlant(List<Plant> garden) {
        Set<Plant>[] plantsByLifeCycle = new Set[Plant.LifeCycle.values().length];

        for(int i = 0 ; i < plantsByLifeCycle.length ; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        for(Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // 인덱스의 의미를 알 수 없어 직접 레이블을 달아 데이터 확인 작업 필요
        for(int i = 0 ; i < plantsByLifeCycle.length ; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }

    public void addPlantTypeEnumMap(List<Plant> garden) {
        Map<Plant.LifeCycle, Set<Plant>> plantByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        for(Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantByLifeCycle.put(lc, new HashSet<>());
        }

        for(Plant p : garden) {
            plantByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantByLifeCycle);
    }
}
