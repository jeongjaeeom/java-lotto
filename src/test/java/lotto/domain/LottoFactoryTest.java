package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFactoryTest {

  @Test
  @DisplayName("로또 갯수 만큼 자동 로또 생성")
  void givenLottoCount_ShouldBeAutoLotto() {
    LottoTicket lottoTicket = LottoFactory.generateAuto(3);
    assertThat(lottoTicket.getLottos()).hasSize(3);
  }
}
