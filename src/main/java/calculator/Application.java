package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 빈 문자열 처리
        if (input == null || input.isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 커스텀 구분자 확인
        String delimiterRegex = ",|:";
        String payload = input;
        if (payload.startsWith("//")) {
            int nl = payload.indexOf('\n');

            String customDelimiter;
            if (nl >= 0) {
                customDelimiter = payload.substring(2, nl);
                payload = payload.substring(nl + 1);
            } else {
                customDelimiter = payload.substring(2);
                String next = Console.readLine();
                if (next == null || next.isEmpty()) {
                    throw new IllegalArgumentException("본문이 비어 있습니다.");
                }
                payload = next;
            }

            if (customDelimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }
            delimiterRegex += "|" + Pattern.quote(customDelimiter);
        }

        // 숫자 분리
        List<Integer> nums = new ArrayList<>();
        String[] tokens = payload.split(delimiterRegex, -1);
        for(String token : tokens){
            validateToken(token);
            nums.add(Integer.parseInt(token));
        }

        // 계산 구현
        int sum = 0;
        for(int num : nums){
            sum += num;
        }

        System.out.printf("결과 : %d", sum);
    }

    private static void validateToken(String token) {
        // 빈 문자열인지 확인
        if (token == null || token.isEmpty()) {
            throw new IllegalArgumentException("구분자 사이 빈 값은 허용되지 않습니다.");
        }

        // 숫자 형식인지 확인
        for (char ch : token.toCharArray()) {
            if (ch < '0' || ch > '9') {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
        }

        // 양수 확인
        int number = Integer.parseInt(token);
        if (number <=  0) {
            throw new IllegalArgumentException("양수만 허용됩니다.");
        }
    }
}
