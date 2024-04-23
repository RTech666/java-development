
import static org.junit.Assert.*;
import org.junit.Test;

import com.pluralsight.Room;

public class RoomTest {

    // Create testCheckInCleanUnoccupied test method.
    @Test
    public void testCheckInCleanUnoccupied() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Check in to room.
        room.checkIn();

        // Set isOccupied and isDirty to true.
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    // Create testCheckInOccupied test method.
    @Test
    public void testCheckInOccupied() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Check in to room.
        room.checkIn();

        // Try to check in to room again.
        room.checkIn();

        // Set isOccupied and isDirty to true.
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    // Create testCheckInDirty test method.
    @Test
    public void testCheckInDirty() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Set setDirty to true.
        room.setDirty(true);

        // Check in to room.
        room.checkIn();

        // Set isOccupied and isDirty to true.
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

    // Create testCheckOutCleanOccupied test method.
    @Test
    public void testCheckOutCleanOccupied() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Check in to room.
        room.checkIn();

        // Check out to room.
        room.checkOut();

        // Set isOccupied and isDirty to false.
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    // Create testCheckOutDirtyOccupied test method.
    @Test
    public void testCheckOutDirtyOccupied() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Set setDirty to true.
        room.setDirty(true);

        // Check in to room.
        room.checkIn();

        // Check out to room.
        room.checkOut();

        // Set isOccupied and isDirty to false.
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    // Create testCheckOutUnoccupied test method.
    @Test
    public void testCheckOutUnoccupied() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Check out to room.
        room.checkOut();

        // Set isOccupied and isDirty to false.
        assertFalse(room.isOccupied());
        assertFalse(room.isDirty());
    }

    // Create testCleanRoomDirty test method.
    @Test
    public void testCleanRoomDirty() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Set setDirty to true.
        room.setDirty(true);

        // Clean room.
        room.cleanRoom();

        // Set isDirty to false.
        assertFalse(room.isDirty());
    }

    // Create testCleanRoomClean test method.
    @Test
    public void testCleanRoomClean() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Clean room.
        room.cleanRoom();

        // Set isDirty to false.
        assertFalse(room.isDirty());
    }

    // Create testCleanRoomOccupied test method.
    @Test
    public void testCleanRoomOccupied() {
        // Create room.
        Room room = new Room(2, 139.00);

        // Check in to room.
        room.checkIn();

        // Clean room.
        room.cleanRoom();

        // Set isOccupied and isDirty to true.
        assertTrue(room.isOccupied());
        assertTrue(room.isDirty());
    }

}
