package kr.seok.item37;

import java.util.*;

class Client {
    public void addPlantTypeEnumMap(List<Plant> garden) {
        // EnumMap 생성
        Map<Plant.LifeCycle, Set<Plant>> plantByLifeCycle = new EnumMap<>(Plant.LifeCycle.class);

        // EnumMap 내에 Set 컬렉션 생성
        for (Plant.LifeCycle lc : Plant.LifeCycle.values()) {
            plantByLifeCycle.put(lc, new HashSet<>());
        }

        // 사용자가 등록한 식물을 LifeCycle 에 따라 Set을 조회 후 등록
        for (Plant p : garden) {
            plantByLifeCycle.get(p.lifeCycle).add(p);
        }

        System.out.println(plantByLifeCycle);
    }

    public void addPlant(List<Plant> garden) {
        // 식물의 라이프 사이클 종류 정의
        int lifeCycleMaxLength = Plant.LifeCycle.values().length;
        // 1. 정원의 식물들을 라이프 사이클 분류 기준에 따라 식물을 등록
        Set<Plant>[] plantsByLifeCycle = new Set[lifeCycleMaxLength];

        // 2. 배열을 초기화 하기 위해 Set 구현체 생성
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            plantsByLifeCycle[i] = new HashSet<>();
        }

        // 3. 사용자가 등록한 데이터를 Set 컨테이너에 등록
        for (Plant p : garden) {
            plantsByLifeCycle[p.lifeCycle.ordinal()].add(p);
        }

        // 인덱스의 의미를 알 수 없어 직접 레이블을 달아 데이터 확인 작업 필요
        for (int i = 0; i < plantsByLifeCycle.length; i++) {
            System.out.printf("%s: %s%n", Plant.LifeCycle.values()[i], plantsByLifeCycle[i]);
        }
    }
}
