import java.util.HashMap;

public class LectureTime implements Comparable<LectureTime> {
    private int hour;
    private String option;
    private String[] daysOptions= {"SUN,TUE","MON,WED"};


    public LectureTime(int hour , int option) {
        if (option == 0 || option == 1) {
            if (hour < 8 && hour > 16)
                throw new IllegalArgumentException();
            this.hour = hour;
            this.option = daysOptions[option];
        }
    }
    public int getHour(){
        return hour;
    }

    public String getOption(){
        return option;
    }
    @Override
    public int compareTo(LectureTime lectureTime){
        if(this.hour==lectureTime.hour && this.option.equals(lectureTime.option))
            return 0;
        else
            return -1;
    }

    @Override
    public boolean equals(Object o){
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        LectureTime e = (LectureTime) o;
        return (this.hour== e.hour && this.option.equals(e.option));
        }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + hour;
        result= prime*result+(option != null ? option.hashCode() : 0);
        return result;
    }
}
