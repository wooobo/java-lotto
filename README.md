# 용어정리

- 로또넘버(LottoNumber) : `1~45`까지의 `숫자`를 가진다.
- 로또(Lotto) : 6개의 `로또넘버` 묶음을 가진다.
- 수익률 : 투자금 과 당첨금에 대한 수익률이다.

# 1단계 미션

- [X] 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
- [X] 로또 1장의 가격은 1000원이다.

# 요구사항 정리

- [x] 로또는 1~45까지의 숫자를 가진다
- [x] 로또는 6개의 숫자 묶음을 가진다.
- [X] 로또 번호 6개는 정렬되어 출력되어야 한다.
- [X] 로또는 중복된 숫자를 가질수 없다.
- [X] 지난주 당첨번호가 존재한다.
- [X] 당첨 통계가 존재한다.
- [X] 수익률이 존재한다.

## 출력예시

```
 
구입금액을 입력해 주세요.
3000
14개를 구매했습니다.
[1, 2, 3, 4, 5, 6]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
6개 일치 (2000000000원)- 0개
총 수익률은 1.66입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)

```
