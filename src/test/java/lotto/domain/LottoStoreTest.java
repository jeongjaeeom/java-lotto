package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoStoreTest {

  @Test
  @DisplayName("로또 구입 금액 입력시 구입금액에 해당하는 로또 발급")
  void buyLottoTickets() {
    assertThat(LottoStore.buy(Money.wons(14000)).getLottoTickets()).hasSize(14);
  }
}
