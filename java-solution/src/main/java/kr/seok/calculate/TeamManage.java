package kr.seok.calculate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TeamManage {

    public int solution(int[] stats) {
        List<List<Integer>> teams= new ArrayList<>();
        boolean isContain = false;


        for (int i = 0; i < stats.length; i++) {
            isContain = false;
            if (i == 0) {
                List<Integer> firstTeam = new ArrayList<>();
                teams.add(firstTeam);
                firstTeam.add(stats[i]);
                continue;
            }

            for (List<Integer> team : teams) {
                if (Collections.max(team) < stats[i]) {
                    team.add(stats[i]);
                    isContain = true;
                    break;
                }
            }

            if (isContain == false) {
                List<Integer> newTeam = new ArrayList<>();
                teams.add(newTeam);
                newTeam.add(stats[i]);
            }
        }
        return teams.size();
    }
}
