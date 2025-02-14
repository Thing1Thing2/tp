package seedu.address.testutil;

import static seedu.address.testutil.TypicalClients.ALICE;
import static seedu.address.testutil.TypicalClients.BENSON;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.MyInsuRec;
import seedu.address.model.meeting.Meeting;

/**
 * A utility class containing a list of {@code Meeting} objects to be used in tests.
 */
public class TypicalMeetings {
    public static final Meeting MEETING1 = new MeetingBuilder().withDescription("meeting1")
            .withMeetingDate(LocalDate.of(2020, 1, 8))
            .withMeetingTime(LocalTime.of(7, 20, 45, 342123342))
            .withClient(ALICE).build();

    public static final Meeting MEETING2 = new MeetingBuilder().withDescription("meeting2")
            .withMeetingDate(LocalDate.of(2020, 5, 5))
            .withMeetingTime(LocalTime.of(7, 20, 45, 342123321))
            .withClient(BENSON).build();

    private TypicalMeetings() {} // prevents instantiation

    /**
     * Returns an {@code MyInsuRec} with all the typical clients with their repesctive meetings.
     */
    public static MyInsuRec getTypicalMyInsuRec() {
        MyInsuRec cb = TypicalClients.getTypicalMyInsuRec();
        for (Meeting meeting : getTypicalMeetings()) {
            cb.addMeeting(meeting);
        }
        return cb;
    }

    public static List<Meeting> getTypicalMeetings() {
        return new ArrayList<>(Arrays.asList(MEETING1, MEETING2));
    }
}
