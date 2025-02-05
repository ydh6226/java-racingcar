package step3.domain.car;

import java.util.Objects;

import static step3.utils.ValidationUtils.checkArgument;
import static step3.utils.ValidationUtils.checkPositive;

public class Location implements Comparable<Location> {

    private static final int DEFAULT_INTERVAL = 1;

    private final int interval;

    private int location;

    public static Location placeOn(Integer location) {
        return new Location(location, DEFAULT_INTERVAL);
    }

    public static Location placeOn(Integer location, Integer interval) {
        return new Location(location, interval);
    }

    private Location(Integer location, Integer interval) {
        checkArguments(location, interval);
        this.location = location;
        this.interval = interval;
    }

    private void checkArguments(Integer location, Integer interval) {
        checkArgument(location != null, "location is required");
        checkPositive(interval, "interval is not Positive");
    }

    public void goForward() {
        location += interval;
    }

    public int getLocation() {
        return location;
    }

    public Location copy() {
        return new Location(location, DEFAULT_INTERVAL);
    }

    @Override
    public int compareTo(Location other) {
        if (other == null) {
            return 0;
        }
        return Integer.compare(location, other.location);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location1 = (Location) o;
        return location == location1.location;
    }

    @Override
    public int hashCode() {
        return Objects.hash(location);
    }

    @Override
    public String toString() {
        return "Location{" +
                "location=" + location +
                '}';
    }
}
