class Event {
    private String eventName;
    private String eventTime;
    private int year;
    private int month;
    private int day;

    public Event(String name, String time) {
        this.eventName = name;
        this.eventTime = time;
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventTime() {
        return eventTime;
    }
    
    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }
}