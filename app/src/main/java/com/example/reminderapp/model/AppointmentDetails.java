package com.example.reminderapp.model;

public class AppointmentDetails {
    private String id;
    private String title;
    private String type;
    private String time;
    private String location;
    private String specialist;
    private String notes;

    public AppointmentDetails(String id, String title, String type, String time, String location, String specialist, String notes) {
        this.id = id;
        this.title = title;
        this.type = type;
        this.time = time;
        this.location = location;
        this.specialist = specialist;
        this.notes = notes;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getType() { return type; }
    public String getTime() { return time; }
    public String getLocation() { return location; }
    public String getSpecialist() { return specialist; }
    public String getNotes() { return notes; }
}
