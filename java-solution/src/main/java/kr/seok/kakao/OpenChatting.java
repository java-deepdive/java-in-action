package kr.seok.kakao;

import java.util.HashMap;
import java.util.Map;

public class OpenChatting {
    private Map<String, String> database = new HashMap<>();

    public String[] solution(String[] record) {
        String[] answer;
        int historyCount = 0;

        for (String command : record) {
            String[] tmp = command.split(" ");
            String protocol = tmp[0];

            if(protocol.equals("Enter")) {
                database.put(tmp[1], tmp[2]);
                historyCount++;
            }
            if(protocol.equals("Change")) {
                database.put(tmp[1], tmp[2]);
            }
            if(protocol.equals("Leave")) {
                historyCount++;
            }
        }

        answer = new String[historyCount];

        int idx = 0;

        for(String command : record) {
            String[] tmp = command.split(" ");
            String protocol = tmp[0];
            if(protocol.equals("Enter")) {
                answer[idx++] = database.get(tmp[1]) + "님이 들어왔습니다.";
            } else if(protocol.equals("Leave")) {
                answer[idx++] = database.get(tmp[1]) + "님이 나갔습니다.";
            }

        }
        return answer;
    }
}
