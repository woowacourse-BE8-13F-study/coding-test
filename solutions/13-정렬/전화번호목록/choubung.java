/*
처음에 이중 for문을 사용했는데, 시간 초과가 날 것 같긴 했지만 정말 시간 초과가 났다..
생각해보니 정렬을 하면, 굳이 뒤의 모든 걸 검사할 필요가 없었다...`
 */

import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            if (phone_book[i + 1].startsWith(phone_book[i])) {
                return false;
            }
        }

        return true;
    }
}


/*
구버전 코드
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
            }
        }

        return true;
    }
}
 */
