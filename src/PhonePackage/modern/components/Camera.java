package PhonePackage.modern.components;

import java.util.List;

public class Camera {
    private final int megaPixels;
    private final List<String> functions;
    private final int cameraFormat;

    public Camera(int megaPixels, List<String> functions, int cameraFormat) {
        this.megaPixels = megaPixels;
        this.functions = functions;
        this.cameraFormat = cameraFormat;
    }

    public int getMegaPixels() {
        return megaPixels;
    }

    public List<String> getFunctions() {
        return functions;
    }

    public int getCameraFormat() {
        return cameraFormat;
    }
}
