package com.xjtuse.summerproject.entity;

public class SendAnnouncement {
    // A class for posting para of Announcement to get Announcement details
    private String course_id;
    private String announcement_id;

    @Override
    public String toString() {
        return "SendAnnouncement{" +
                "course_id='" + course_id + '\'' +
                ", announcement_id='" + announcement_id + '\'' +
                '}';
    }

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAnnouncement_id() {
        return announcement_id;
    }

    public void setAnnouncement_id(String announcement_id) {
        this.announcement_id = announcement_id;
    }
}
