package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.io.*;

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
        if(input.startsWith("//")) {
            /// todo: 커스텀 구분자 지정
        }

        List<Integer> nums = new ArrayList<>();
        String[] tokens = input.split(",|:");
        for(String token : tokens){nums.add(Integer.parseInt(token));}

    }
}
