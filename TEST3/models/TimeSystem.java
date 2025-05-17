package models;

public class TimeSystem {
    // نمونه singleton
    private static final TimeSystem INSTANCE = new TimeSystem();

    // فیلدهای زمان بازی
    private int currentHour;
    private int currentDay;
    private String currentSeason;
    private String dayOfWeek;
    private int currentYear;
    public boolean oneSeasonPassed = false;

    // سازنده خصوصی با مقداردهی اولیه
    private TimeSystem() {
        this.currentHour = 9;            // ساعت شروع: 9 صبح
        this.currentDay = 1;             // روز اول فصل
        this.currentSeason = "Spring"; // فصل بهار
        this.dayOfWeek = "Monday";     // دوشنبه
        this.currentYear = 1;            // سال اول
    }

    /** دسترسی به نمونه singleton */
    public static TimeSystem getInstance() {
        return INSTANCE;
    }

    /**
     * جلو بردن زمان بازی به تعداد ساعت مشخص
     * @param hours تعداد ساعت (عدد منفی غیرمجاز است)
     */
    public synchronized boolean advanceTime(int hours) {
        if (hours < 0) throw new IllegalArgumentException();

        int previousDay = currentDay;
        currentHour += hours;

        while (currentHour >= 22) {
            currentHour -= 13;
            advanceDate(1);
        }

        return (currentDay != previousDay);
    }

    public synchronized boolean advanceDate(int days) {
        if (days < 0) throw new IllegalArgumentException();

        int previousDay = currentDay;
        currentDay += days;

        while (currentDay > 28) {
            currentDay -= 28;
            updateSeason();
            oneSeasonPassed = true;
        }

        calculateDayOfWeek();
        return (currentDay != previousDay);
    }

    // محاسبه روز هفته براساس currentDay
    private void calculateDayOfWeek() {
        String[] days = {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
        int index = (currentDay - 1) % 7;
        dayOfWeek = days[index];
    }

    // به‌روزرسانی فصل و سال
    private void updateSeason() {
        String[] seasons = {"Spring","Summer","Fall","Winter"};
        int idx = java.util.Arrays.asList(seasons).indexOf(currentSeason);
        currentSeason = seasons[(idx + 1) % seasons.length];
        if ("Spring".equals(currentSeason)) {
            currentYear++;
        }
    }

    /** نمایش ساعت فعلی با فرمت HH:00 */
    public synchronized String getCurrentTime() {
        return String.format("%02d:00", currentHour);
    }

    /** نمایش تاریخ فعلی */
    public synchronized String getCurrentDate() {
        return String.format("Year %d, %s %d", currentYear, currentSeason, currentDay);
    }

    /** نمایش روز هفته */
    public synchronized String getDayOfWeek() {
        return dayOfWeek;
    }

    /** نمایش ترکیبی ساعت و تاریخ */
    public synchronized String getDateTime() {
        return getCurrentDate() + " " + getCurrentTime() + " (" + dayOfWeek + ")";
    }

    /** نمایش فصل فعلی */
    public synchronized String getCurrentSeason() {
        return currentSeason;
    }

    public synchronized int getCurrentYear() {
        return currentYear;
    }

    public synchronized int getCurrentHour() {
        return currentHour;
    }

    public synchronized int getCurrentDay() {
        return currentDay;
    }


    public synchronized void setCurrentSeason(String season) {
        currentSeason = season;
    }

    public synchronized void setCurrentYear(int year) {
        currentYear = year;
    }
    public synchronized void setCurrentHour(int hour) { this.currentHour = hour; }
    public synchronized void setCurrentDay(int day) { this.currentDay = day;}
    public synchronized void setDayOfWeek(String day) { this.dayOfWeek = day; }
}
