package kr.seok.lotto.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class Lottos {

    private final List<Lotto> lottoList;

    private Lottos(Collection<Lotto> lottoList) {
        this.lottoList = new ArrayList<>(lottoList);
    }

    public static Lottos of(Collection<Lotto> lottoList) {
        return new Lottos(lottoList);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Lottos)) return false;
        final Lottos lottos = (Lottos) o;
        return Objects.equals(lottoList, lottos.lottoList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoList);
    }
}
