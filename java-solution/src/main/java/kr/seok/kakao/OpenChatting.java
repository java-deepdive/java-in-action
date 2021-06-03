package kr.seok.kakao;

import java.util.HashMap;
import java.util.Map;

public class OpenChatting {
    private Map<String, String> database = new HashMap<>();

    public String[] solution(String[] record) {
        String[] answer;
        int historyCount = 0;

        for (String command : record) {
            historyCount = manager(historyCount, command);
        }

        answer = new String[historyCount];

        int idx = 0;
        for(int i = 0 ; i < record.length ; i++) {
            String[] tmp = record[i].split(" ");
            if(record[i].startsWith("Enter")) {
                answer[idx++] = database.get(tmp[1]) + "님이 들어왔습니다.";
            } else if(record[i].startsWith("Leave")) {
                answer[idx++] = database.get(tmp[1]) + "님이 나갔습니다.";
            }
        }

        for(String item : answer) {
            System.out.println(item);
        }
        return answer;
    }

    private int manager(int count, String command) {
        String[] entry = command.split(" ");
        String protocol = entry[0];

        if(protocol.equals("Enter")) {
            database.put(entry[1], entry[2]);
            count++;
        }
        if(protocol.equals("Change")) {
            if(database.containsKey(entry[1])) {
                database.put(entry[1], entry[2]);
            }
        }
        if(protocol.equals("Leave")) {
            count++;
        }
        return count;
    }
}
