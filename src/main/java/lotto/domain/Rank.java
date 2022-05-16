package lotto.domain;

import java.util.Arrays;

public enum Rank {
  TOP(6, 2000000000),
  SECOND(5, 30000000),
  THIRD(5, 1500000),
  FOURTH(4, 50000),
  FIFTH(3, 5000),
  NONE(0, 0);

  private final long cashPrize;
  private final long matchCount;

  Rank(long matchCount, long cashPrize) {
    this.matchCount = matchCount;
    this.cashPrize = cashPrize;
  }

  public static Rank of(final long matchCount, final boolean matchedBonus) {
    Rank rank = getLottoRank(matchCount);
    if (rank.isSecond() && !matchedBonus) {
      return THIRD;
    }
    return rank;
  }

  private static Rank getLottoRank(long matchCount) {
    return Arrays.stream(values())
        .filter(rank -> rank.isMatched(matchCount))
        .findFirst()
        .orElse(NONE);
  }

  private boolean isMatched(long matchCount) {
    return this.matchCount == matchCount;
  }

  public boolean isSecond() {
    return this == SECOND;
  }

}
