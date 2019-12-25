package com.volkodav4ik;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class TimeSpan {

    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (minutes > 60) {
            throw new IllegalArgumentException("Не может быть больше 60");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setMinutes(int minutes) {
        this.minutes = minutes;
    }

    public void add(TimeSpan timeSpan) {
        if ((timeSpan.minutes + this.minutes) >= 60) {
            setHours(this.hours + 1);
        }
        setMinutes((timeSpan.minutes + this.minutes) % 60);
        setHours(timeSpan.hours + this.hours);
    }

    public void sub(TimeSpan timeSpan) {
        if ((this.hours - timeSpan.hours) < 0) {
            setHours(0);
            setMinutes(0);
            throw new IllegalArgumentException("Время вышло!");
        } else {
            if ((this.hours - timeSpan.hours) == 0 && (this.minutes - timeSpan.minutes) <= 0) {
                setHours(0);
                setMinutes(0);
                throw new IllegalArgumentException("Время вышло!");
            }
        }
        if (timeSpan.minutes > this.minutes) {
            setHours(this.hours - timeSpan.hours - 1);
            setMinutes(60 + (this.minutes - timeSpan.minutes));
        } else {
            setHours(this.hours - timeSpan.hours);
            setMinutes(this.minutes - timeSpan.minutes);
        }
    }

    private static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public void mult(double times) {
        double minute = round(this.minutes * times, 0);
        setMinutes((int) (minute % 60));
        if (minute >= 60){
            setHours(this.hours + (int) (minute / 60));
        }
        double  hour = round(this.hours * times, 0);
        setHours((int) hour);

    }

    @Override
    public String toString() {
        return "TimeSpan{" +
                "hours=" + hours +
                ", minutes=" + minutes +
                '}';
    }
}