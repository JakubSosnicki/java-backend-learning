import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ReservationSystem {

    private final Map<Integer, MeetingRoom> roomsMap = new HashMap<>();
    private final Map<Integer, Set<LocalDate>> roomsSchedule = new HashMap<>();

    /**
     * Method used to add new room to HashMap and
     * initialize new HashSet in roomsSchedule
     * @param id identity of room UNIQUE - connect roomsMap with roomsSchedule
     *           each room has own schedule
     * @param name name of room
     * @param capacity max amount of people in room
     */
    public void addRoom (int id, String name, int capacity) {

        if (!roomsMap.containsKey(id)) {
            MeetingRoom meetingRoom = new MeetingRoom(id, name, capacity);
            //add element to map
            roomsMap.put(id, meetingRoom);
            roomsSchedule.put(id, new HashSet<>());
        } else {
            throw new IllegalArgumentException("This room is already exist");
        }
    }

    /**
     * Overloaded method add object of MeetingRoom class which is already initialize
     * @param room object of MeetingRoom class
     */
    public void addRoom (MeetingRoom room) {
        if (room == null) {
            throw new NullPointerException("Room cannot be null");
        }
        if (!roomsMap.containsKey(room.getId())) {
            roomsMap.put(room.getId(), room);
            roomsSchedule.put(room.getId(), new HashSet<>());
        } else {
            throw new IllegalArgumentException("This room is already exist");
        }
    }

    /**
     * Method used to reserve room on selected date
     * @param roomId
     * @param date
     * @return information about success of reserve date
     */
    public boolean reserveRoom(int roomId, LocalDate date) {
        //if room on this date is available return true
        if (isAvailable(roomId, date)) {
            return roomsSchedule.get(roomId).add(date);
        }
        //if is taken return false
        return false;
    }

    /**
     * Method used to check available of room on specific date
     * @param roomId
     * @param date
     * @return information if room is available or not
     */
    public boolean isAvailable (int roomId, LocalDate date) {
        if (!roomsMap.containsKey(roomId)) {
            throw new IllegalArgumentException("Room with this id doesn't exist");
        }

        if (date == null) {
            throw new IllegalArgumentException("Date is null");
        }
        return !roomsSchedule.get(roomId).contains(date);
    }

    /**
     * Method used to cancel reservation on specific room and date
     * @param roomId
     * @param date
     * @return information then cancel is success or was not reserved
     */
    public boolean cancelReservation (int roomId, LocalDate date) {
        // if room on this date is taken
        if (!isAvailable(roomId, date)) {
            roomsSchedule.get(roomId).remove(date);
            return true;
        }
        return false;
    }
}
