package io.zipcoder;

public class Music {

    private String[] playList;

    public Music(String[] playList) {
        this.playList = playList;
    }

    public Integer selection(Integer startIndex, String selection) {
        int forward = searchForward(startIndex, selection);
        int backward = searchBackward(startIndex, selection);

        if (forward == 0) {
            return backward;
        } else if (backward == 0)
            return forward;

        if (forward < backward ) {
            return forward;
        } else
            return backward;
    }

    private Integer searchForward(Integer startIndex, String selection){
        int songIndex = 0;
        for (int i = 0; i <= playList.length-1; i++ ){
            if (selection == playList[i] ){
                songIndex = i;
                break;
            }
        }
         return Math.abs(startIndex - songIndex)%playList.length;
    }

    private Integer searchBackward(Integer startIndex, String selection){
        int songIndex = 0;
        for (int i = playList.length-1; i >= 0; i-- ){
            if (selection == playList[i] ){
                songIndex = i;
                break;
            }
        }
        return playList.length%Math.abs(startIndex - songIndex);
    }
}
