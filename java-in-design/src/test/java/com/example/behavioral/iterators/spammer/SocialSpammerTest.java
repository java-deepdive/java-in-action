package com.example.behavioral.iterators.spammer;

import com.example.behavioral.iterators.profile.Profile;
import com.example.behavioral.iterators.social.Facebook;
import com.example.behavioral.iterators.social.LinkedIn;
import com.example.behavioral.iterators.social.SocialNetwork;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class SocialSpammerTest {
    private static List<Profile> data;

    private static Stream<Arguments> createProfile() {
        List<Profile> data = new ArrayList<>();
        data.add(new Profile("anna.smith@bing.com", "Anna Smith", "friends:mad_max@ya.com", "friends:catwoman@yahoo.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("mad_max@ya.com", "Maximilian", "friends:anna.smith@bing.com", "coworkers:sam@amazon.com"));
        data.add(new Profile("bill@microsoft.eu", "Billie", "coworkers:avanger@ukr.net"));
        data.add(new Profile("avanger@ukr.net", "John Day", "coworkers:bill@microsoft.eu"));
        data.add(new Profile("sam@amazon.com", "Sam Kitting", "coworkers:anna.smith@bing.com", "coworkers:mad_max@ya.com", "friends:catwoman@yahoo.com"));
        data.add(new Profile("catwoman@yahoo.com", "Liza", "friends:anna.smith@bing.com", "friends:sam@amazon.com"));

        String friendEmail = "anna.smith@bing.com";
        String sendMsg = "Hey! This is Anna's friend Josh. Can you do me a favor and like this post [link]?";

        return Stream.of(
                Arguments.of(new LinkedIn(data), friendEmail, sendMsg), // 링크드인
                Arguments.of(new Facebook(data), friendEmail, sendMsg) // 페이스북
        );
    }

    @DisplayName("Iterator 프로필 테스트")
    @ParameterizedTest(name = "SendEmail Test ==> Platform: {0}, Friend : {1}, SendMsg : {2}")
    @MethodSource(value = "createProfile")
    void testCase1(SocialNetwork socialNetwork, String friend, String sendMsg) {

        SocialSpammer social = new SocialSpammer(socialNetwork);

        social.sendSpamToFriends(friend, sendMsg);
        social.sendSpamToCoworkers(friend, sendMsg);

        System.out.println(social);
    }
}
