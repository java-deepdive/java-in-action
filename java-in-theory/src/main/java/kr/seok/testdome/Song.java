package kr.seok.testdome;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    // Floyd 순환 찾기 알고리즘
    public boolean isRepeatingPlaylist() {
        Song head = nextSong;

        Song slow = head;
        Song fast = head;

        boolean loop = false;

        while(slow != null && fast != null && fast.nextSong != null){
            slow = slow.nextSong;
            fast = fast.nextSong.nextSong;

            if(slow == fast){
                loop = true;
                break;
            }
        }

        return loop;
    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}
