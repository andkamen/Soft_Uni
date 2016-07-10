package com.L03StaticMembers.ShapesVolume;

public class VolumeCalculator {

    public static double calcCubeVolume(Cube cube) {
        return Math.pow(cube.getSide(), 3);
    }

    public static double calcCylinderVolume(Cylinder cylinder) {
        return Math.PI * Math.pow(cylinder.getRadius(), 2) * cylinder.getHeight();
    }

    public static double calcTriangularPrismVolume(TriangularPrism prism) {
        return prism.getHeight() * prism.getBase() * prism.getLength() / 2.0;
    }
}
