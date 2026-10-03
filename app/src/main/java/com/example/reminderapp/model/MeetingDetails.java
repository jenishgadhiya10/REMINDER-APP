package com.example.reminderapp.model;

import java.util.List;

public class MeetingDetails {
    private String id;
    private String title;
    private String time;
    private List<String> attendees;
    private String location;
    private String videoLink;
    private String agenda;
    private String notes;

    public MeetingDetails(String id, String title, String time, List<String> attendees, String location, String videoLink, String agenda, String notes) {
        this.id = id;
        this.title = title;
        this.time = time;
        this.attendees = attendees;
        this.location = location;
        this.videoLink = videoLink;
        this.agenda = agenda;
        this.notes = notes;
    }

    public String getId() { return id; }
    public String getTitle() { return title; }
    public String getTime() { return time; }
    public List<String> getAttendees() { return attendees; }
    public String getLocation() { return location; }
    public String getVideoLink() { return videoLink; }
    public String getAgenda() { return agenda; }
    public String getNotes() { return notes; }
}
