package team.baymax.model.appointment;

import static team.baymax.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.Objects;
import java.util.Set;

import team.baymax.model.patient.Patient;
import team.baymax.model.tag.Tag;
import team.baymax.model.util.datetime.Date;
import team.baymax.model.util.datetime.DateTime;
import team.baymax.model.util.datetime.Duration;
import team.baymax.model.util.datetime.Time;
import team.baymax.model.util.uniquelist.UniqueListElement;

/**
 * Represents an Appointment in the appointment book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Appointment implements UniqueListElement {
    private final Patient patient;
    private final DateTime dateTime;
    private final Duration duration;
    private final AppointmentStatus status;
    private final Set<Tag> tags;
    private final Description description;

    /**
     * Every field must be present and not null.
     */
    public Appointment(Patient patient, DateTime dateTime, Duration duration, Description description,
                       Set<Tag> tags, AppointmentStatus status) {
        requireAllNonNull(patient, dateTime, tags, description, duration);
        this.patient = patient;
        this.dateTime = dateTime;
        this.duration = duration;
        this.description = description;
        this.tags = tags;
        this.status = status;
    }

    public Patient getPatient() {
        return patient;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public Date getDate() {
        return dateTime.getDate();
    }

    public Time getTime() {
        return dateTime.getTime();
    }

    public Duration getDuration() {
        return duration;
    }

    public DateTime getEndDateTime() {
        return this.dateTime.plusMinutes(this.duration);
    }

    public Description getDescription() {
        return description;
    }

    public AppointmentStatus getStatus() {
        return status;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /** Returns true if both appointments have the same date and time.
     * This defines a weaker notion of equality between two appointments.
     */
    @Override
    public boolean isSame(UniqueListElement other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;

        return otherAppointment != null
                && otherAppointment.getDateTime().equals(dateTime)
                && otherAppointment.getPatient().equals(patient);
    }

    public int compare(Appointment a1, Appointment a2) {
        return a2.getDateTime().compareTo(a1.getDateTime());
    }

    /**
     * Returns true if both patients have the same identity and data fields.
     * This defines a stronger notion of equality between two patients.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof Appointment)) {
            return false;
        }

        Appointment otherAppointment = (Appointment) other;
        return getPatient().equals(otherAppointment.getPatient())
                && getDateTime().equals(otherAppointment.getDateTime())
                && getTime().equals(otherAppointment.getTime())
                && getDuration().equals(otherAppointment.duration)
                && getDescription().equals(otherAppointment.getDescription())
                && getStatus().equals(otherAppointment.getStatus())
                && getTags().equals(otherAppointment.getTags());
    }

    @Override
    public int hashCode() {
        return Objects.hash(patient, dateTime, status, tags, description);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append(getPatient())
                .append(" Date time: ")
                .append(getDateTime())
                .append(" Description: ")
                .append(getDescription())
                .append(" Tags: ");
        getTags().forEach(builder::append);
        return builder.toString();
    }
}