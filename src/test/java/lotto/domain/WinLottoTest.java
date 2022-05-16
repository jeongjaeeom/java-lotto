package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinLottoTest {

  @Test
  @DisplayName("당첨 번호 생성")
  void givenLottoNumbers_ShouldCreatedTicket() {
    assertThat(new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7))
        .isEqualTo(new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7));
  }


  @Test
  @DisplayName("로또 1등")
  void givenLotto_shouldBeTopLottoRank() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
    WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    assertThat(LottoGame.match(lotto, winLotto)).isEqualTo(Rank.TOP);
  }

  @Test
  @DisplayName("로또 2등")
  void givenLotto_shouldBeSecondLottoRank() {
    Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
    WinLotto winLotto = new WinLotto(List.of(1, 2, 3, 4, 5, 6), 7);
    assertThat(LottoGame.match(lotto, winLotto)).isEqualTo(Rank.SECOND);
  }
}