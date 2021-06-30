package org.sandboxpowered.api.util.math;

public class Maths {
    public static double invsqrt(double r) {
        return 1.0 / java.lang.Math.sqrt(r);
    }

    public static float fma(float a, float b, float c) {
        return a * b + c;
    }

    public static double fma(double a, double b, double c) {
        return a * b + c;
    }

    public static int hsvToRgb(float hue, float saturation, float brightness) {
        int hueStage = (int) (hue * 6.0F) % 6;
        float hueDifference = hue * 6.0F - (float) hueStage;
        float saturatedBrightness = brightness * (1.0F - saturation);
        float hueSaturatedBrightness = brightness * (1.0F - hueDifference * saturation);
        float hueSaturatedBrightnessInv = brightness * (1.0F - (1.0F - hueDifference) * saturation);
        float red;
        float green;
        float blue;
        switch (hueStage) {
            case 0 -> {
                red = brightness;
                green = hueSaturatedBrightnessInv;
                blue = saturatedBrightness;
            }
            case 1 -> {
                red = hueSaturatedBrightness;
                green = brightness;
                blue = saturatedBrightness;
            }
            case 2 -> {
                red = saturatedBrightness;
                green = brightness;
                blue = hueSaturatedBrightnessInv;
            }
            case 3 -> {
                red = saturatedBrightness;
                green = hueSaturatedBrightness;
                blue = brightness;
            }
            case 4 -> {
                red = hueSaturatedBrightnessInv;
                green = saturatedBrightness;
                blue = brightness;
            }
            case 5 -> {
                red = brightness;
                green = saturatedBrightness;
                blue = hueSaturatedBrightness;
            }
            default -> throw new RuntimeException(String.format("Error converting from HSV to RGB. Input was %s, %s, %s", hue, saturation, brightness));
        }

        int clampedRed = clamp((int) (red * 255.0F), 0, 255);
        int clampedGreen = clamp((int) (green * 255.0F), 0, 255);
        int clampedBlue = clamp((int) (blue * 255.0F), 0, 255);
        return clampedRed << 16 | clampedGreen << 8 | clampedBlue;
    }

    public static int clamp(int value, int min, int max) {
        return Math.max(Math.min(value, max), min);
    }
}
