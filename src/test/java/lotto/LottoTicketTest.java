package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketTest {

  @Test
  @DisplayName("로또 티켓 생성")
  void givenLottoNumbers_ShouldCreatedTicket() {
    LottoTicket lottoTicket = new LottoTicket(LottoFactory.create());
    assertThat(lottoTicket).isNotNull();
  }

  @Test
  @DisplayName("로또 번호 6자리 아닐 경우 예외 처리")
  void givenIllegalSizeNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() ->
        new LottoTicket(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5))));
    assertThatIllegalArgumentException().isThrownBy(() ->
        new LottoTicket(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(5), new LottoNumber(6), new LottoNumber(7))));
  }

  @Test
  @DisplayName("로또 번호 중복 예외 처리")
  void givenIllegalDuplicateNumbers_ShouldException() {
    assertThatIllegalArgumentException().isThrownBy(() ->
        new LottoTicket(
            List.of(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4),
                new LottoNumber(6), new LottoNumber(6))));
  }

}