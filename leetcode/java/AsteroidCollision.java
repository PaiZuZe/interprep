public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {

        int[] newAsteroidField = asteroids.clone();
        int i = 0;
        for (int asteroid : asteroids) {
            if (i == 0) {
                newAsteroidField[i++] = asteroid;
            } else if (!willCollide(newAsteroidField[i - 1], asteroid)) {
                newAsteroidField[i++] = asteroid;
            } else {
                if (newAsteroidField[i - 1] + asteroid <= 0) {
                    while (i > 0 && newAsteroidField[i - 1] + asteroid < 0 && newAsteroidField[i - 1] > 0) {
                        i--;
                    }
                    if (i == 0 || newAsteroidField[i - 1] < 0) {
                        newAsteroidField[i++] = asteroid;
                    }
                    else if (newAsteroidField[i - 1] + asteroid == 0) {
                        i--;
                    }
                }
            }
        }
        int[] resp = new int[i];
        System.arraycopy(newAsteroidField, 0, resp, 0, i);
        return resp;
    }

    private boolean willCollide(int rightAsteroid, int leftAsteroid) {
        return rightAsteroid > 0 && leftAsteroid < 0;
    }
}
