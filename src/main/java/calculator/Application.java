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
        if(input.equals("")){
            System.out.println("결과 : 0\n");
            return;
        }

        // 커스텀 구분자 확인
        String delimiterRegex = ",|:";
        String payload = input;
        if(input.startsWith("//")) {
            if (input.length() <= 2) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }

            String delimiter = input.substring(2);
            if (delimiter.isEmpty()) {
                throw new IllegalArgumentException("잘못된 커스텀 구분자 형식입니다.");
            }

            delimiterRegex += "|" + Pattern.quote(delimiter);

            // 다음 줄 읽기
            payload = Console.readLine();
            if (payload == null || payload.isEmpty()) {
                throw new IllegalArgumentException("본문이 비어 있습니다.");
            }
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

        System.out.printf("결과 : %d\n", sum);
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
