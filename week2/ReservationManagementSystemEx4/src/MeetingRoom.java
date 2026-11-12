public class MeetingRoom {
    private final int id;
    private final String name;
    private final int capacity;

    public MeetingRoom(int id, String name, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity cannot be zero or less");
        }
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }
}
