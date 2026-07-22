# 참여 방법 (CONTRIBUTING)

스터디원 전원이 **같은 진도**로 진행합니다. 각자 푼 풀이는 **개인 브랜치에 push → `main`으로 Pull Request**로 반영합니다.

## 협업 흐름 (개인 브랜치 → main PR)
```
main (보호 브랜치, 직접 push 금지)
 └─ mychan   ← 개인 작업 브랜치
```
1. 최신 `main`을 받아옵니다.
   ```bash
   git checkout main && git pull origin main
   ```
2. 작업 브랜치를 만듭니다. (브랜치명: `solve/<아이디>/<파트번호-문제명>`)
   ```bash
   git checkout -b mychan
   ```
3. 풀이를 폴더 규칙에 맞게 추가하고 커밋합니다.
   ```bash
   git add solutions/05-배열/두정수사이의합/Uechann.java
   git commit -m "solve: 05-배열 두정수사이의합 (Uechann)"
   ```
4. 브랜치를 push하고 **`main`으로 PR**을 올립니다.
   ```bash
   git push -u origin mychan
   ```

> 같은 문제를 여러 명이 풀어도 괜찮습니다. 파일명이 `<깃허브아이디>.java`라 서로 충돌하지 않습니다.

## 폴더 구조
```
solutions/<파트번호-파트명>/<문제명>/<깃허브아이디>.java
```
예)
```
solutions/05-배열/두정수사이의합/Uechann.java
```
- 파트번호-파트명은 `plan/` 문서명과 동일하게 맞춥니다(예: `05-배열`, `10-집합-유니온파인드`).
- 문제명 폴더는 공백을 빼고 적습니다(예: `두정수사이의합`).

## 커밋 메시지
```
solve: 05-배열 두정수사이의합 (Uechann)
```

## PR 규칙
- **제목:** `solve: <파트번호-파트명> <문제명> (<아이디>)`
- **본문:** 접근 방법 요약 + 시간복잡도 + (선택) 막혔던 점.
- **대상 브랜치:** 항상 `main`.
- 여러 문제를 한 PR에 묶어도 되지만, 리뷰가 쉽도록 **파트 단위**로 끊는 것을 권장합니다.

## 풀이 코드 규칙
- 각 풀이 **상단 주석**에 접근 방법 1~2줄 + 시간복잡도를 남깁니다.
```java
// 접근: 정렬 후 투 포인터로 합이 target인 쌍 탐색
// 시간복잡도: O(n log n)
public class Solution { /* ... */ }
```
- 통과 후 해당 문제의 체크박스([ ] → [x])를 `plan/`·`schedule/`에서 체크해 PR에 함께 포함합니다.
