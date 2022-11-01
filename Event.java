package com.maverickz.mad_project_hope;
//package com.maverickz.mad_project_hope;

public class Event {
    private String name;
    private String eventDate;
    private String eventLocStreet;
    private String eventLocCity;
    private String eventLocDist;
    private String eventStart;
    private String eventEnd;
    private String eventDesc;
    private String eventCont;
    private String ID;
    private String uid;

    public String getUID() {
        return uid;
    }

    public void setUID(String UID) {
        this.uid = UID;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Event() {}

    public Event(String name, String eventDate, String eventLocStreet, String eventLocCity, String eventLocDist, String eventStart, String eventEnd, String eventDesc, String eventCont) {
        this.name = name;
        this.eventDate = eventDate;
        this.eventLocStreet = eventLocStreet;
        this.eventLocCity = eventLocCity;
        this.eventLocDist = eventLocDist;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.eventDesc = eventDesc;
        this.eventCont = eventCont;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocStreet() {
        return eventLocStreet;
    }

    public void setEventLocStreet(String eventLocStreet) {
        this.eventLocStreet = eventLocStreet;
    }

    public String getEventLocCity() {
        return eventLocCity;
    }

    public void setEventLocCity(String eventLocCity) {
        this.eventLocCity = eventLocCity;
    }

    public String getEventLocDist() {
        return eventLocDist;
    }

    public void setEventLocDist(String eventLocDist) {
        this.eventLocDist = eventLocDist;
    }

    public String getEventStart() {
        return eventStart;
    }

    public void setEventStart(String eventStart) {
        this.eventStart = eventStart;
    }

    public String getEventEnd() {
        return eventEnd;
    }

    public void setEventEnd(String eventEnd) {
        this.eventEnd = eventEnd;
    }

    public String getEventDesc() {
        return eventDesc;
    }

    public void setEventDesc(String eventDesc) {
        this.eventDesc = eventDesc;
    }

    public String getEventCont() {
        return eventCont;
    }

    public void setEventCont(String eventCont) {
        this.eventCont = eventCont;
    }
}
