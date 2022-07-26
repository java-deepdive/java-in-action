# 숫자 야구 게임 구현

컴퓨터가 랜덤한 숫자 세 개를 선택, 플레이어가 숫자 세 개를 임의로 선택

플레이어가 선택한 수와 컴퓨터가 선택했던 수와의 몇 가지 규칙에 따라 스트라이크, 볼로 정의 한다.

- 사용자가 선택한 숫자가 컴퓨터가 선택한 숫자와 같은 자리에 같은 수가 있다면 스트라이크
- 사용자가 선택한 숫자가 컴퓨터가 선택한 숫자와 다른 자리에 같은 수가 있다면 볼

위 규칙에 따른 예시

컴퓨터가 528일 때

- 플레이어가 547을 선택하는 경우, 1스트라이크
- 플레이어가 824일 때, 1스트라이크, 1볼
- 플레이어가 931일 때, Miss

위 과정을 반복하여 컴퓨터가 선택했던 3개의 숫자를 모두 맞추어 3스트라이크가 되면 게임이 종료된다.

게임 종료 후 게임을 다시 시작하거나 완전히 종료할 수 있다.

