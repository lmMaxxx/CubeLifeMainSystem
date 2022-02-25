package eu.mindcreation.cubelifemainsystem.GrundstückeSystem;

public enum Direction {
    SOUTH,
    EAST,
    NORTH,
    WEST,
    UNKNOWN;

    public static Direction getDirectionByYaw(float yaw) {
        float newYaw = (yaw - 90) % 360;

        if(newYaw < 0)
            newYaw += 360;

        if (0 <= newYaw && newYaw < 22.5)
            return Direction.NORTH;

        if (67.5 <= newYaw && newYaw < 112.5)
            return Direction.EAST;

        if (157.5 <= newYaw && newYaw < 202.5)
            return Direction.SOUTH;

        if (247.5 <= newYaw && newYaw < 292.5)
            return Direction.WEST;

        if (337.5 <= newYaw && newYaw <= 360)
            return Direction.NORTH;

        return Direction.UNKNOWN;
    }
}
