package lotto.domain;

import static java.util.regex.Pattern.matches;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

public class LottoNumber {

  public static final int MIN_LOTTO_NUMBER = 1;
  public static final int MAX_LOTTO_NUMBER = 45;
  private static final Map<Integer, LottoNumber> cachedLottoNumbers = new HashMap<>();

  private int number;

  static {
    IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)
        .forEach(number -> cachedLottoNumbers.put(number, new LottoNumber(number)));
  }

  private LottoNumber(int number) {
    this.number = number;
  }

  public static LottoNumber from(String number) {
    validateEmpty(number);
    validateNumeric(number);
    return from(Integer.parseInt(number.trim()));
  }

  public static LottoNumber from(int number) {
    if (number < 1 || number > 45) {
      throw new IllegalArgumentException("로또번호가 1보다 작거나 45보다 클 수 없습니다.");
    }
    return cachedLottoNumbers.get(number);
  }

  private static void validateEmpty(String number) {
    if (isBlank(number)) {
      throw new IllegalArgumentException("로또 번호는 비어 있을 수 없습니다.");
    }
  }

  private static void validateNumeric(String number) {
    if (!matches("\\d+", number.trim())) {
      throw new IllegalArgumentException("로또 번호는 숫자여야 합니다." + number);
    }
  }

  private static boolean isBlank(String numbers) {
    return numbers == null || numbers.isBlank();
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LottoNumber that = (LottoNumber) o;
    return number == that.number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    return String.valueOf(number);
  }
}
