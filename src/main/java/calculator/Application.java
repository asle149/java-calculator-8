package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        //빈 문자열 처리
        if(input.equals("")){
            System.out.println("결과 : 0");
            return;
        }

        int ans;

        //커스텀 구분자 확인
        String delimiterRegex = ",|:";
        if(input.startsWith("//")) {
            int idx = input.indexOf("\n");
            ///예외처리  if(idx == -1) {}
            String delimiter = input.substring(2, idx);
            delimiterRegex += "|" + Pattern.quote(delimiter);
        }

        List<Integer> nums = new ArrayList<>();
        String[] tokens = input.split(delimiterRegex);
        /// 예외처리
        for(String token : tokens){nums.add(Integer.parseInt(token));}

    }
}
