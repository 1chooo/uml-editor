package Shapes;

import java.awt.Graphics;

public class GeneralizationLine extends Line {

    public GeneralizationLine(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public void draw(Graphics g) {
        int width = 10, height = 10;
        int differenceBetweenCoordinatesX = findDifferenceBetweenCoordinatesX(x2, x1), differenceBetweenCoordinatesY = findDifferenceBetweenCoordinatesY(y2, y1);
        double lengthOfSegmentBetween2points = findLengthOfSegmentBetween2points(differenceBetweenCoordinatesX, differenceBetweenCoordinatesY);
        double endPointOfArrowM = findEndPointOfArrow(lengthOfSegmentBetween2points, width);
        double endPointOfArrowN = endPointOfArrowM;

        double arrowHeightYm = height, arrowHeightYn = -height;
        double sinusOfAngleInclinationLineRelativeToAxis = findSinusOfAngleInclinationLineRelativeToAxis(differenceBetweenCoordinatesY, lengthOfSegmentBetween2points);
        double cosineOfAngleInclinationLineRelativeToAxis = findCosineOfAngleInclinationLineRelativeToAxis(differenceBetweenCoordinatesX, lengthOfSegmentBetween2points);

        double calculatedX = calculatedX(endPointOfArrowM, cosineOfAngleInclinationLineRelativeToAxis,
                arrowHeightYm, sinusOfAngleInclinationLineRelativeToAxis, x1);

        arrowHeightYm = findArrowHeightYm(endPointOfArrowM, sinusOfAngleInclinationLineRelativeToAxis,
                arrowHeightYm, cosineOfAngleInclinationLineRelativeToAxis, y1);
        endPointOfArrowM = calculatedX;

        calculatedX = calculateRotatedXCoordinate(endPointOfArrowN, cosineOfAngleInclinationLineRelativeToAxis, arrowHeightYn,
                sinusOfAngleInclinationLineRelativeToAxis, x1);

        arrowHeightYn = calculateRotatedYCoordinate(endPointOfArrowN, sinusOfAngleInclinationLineRelativeToAxis, arrowHeightYn,
                cosineOfAngleInclinationLineRelativeToAxis, y1);
        endPointOfArrowN = calculatedX;

        int[] xpoints = {x2, (int) endPointOfArrowM, (int) endPointOfArrowN};
        int[] ypoints = {y2, (int) arrowHeightYm, (int) arrowHeightYn};

        g.drawLine(x1, y1, x2, y2);
        g.drawPolygon(xpoints, ypoints, 3);
    }

    private int findDifferenceBetweenCoordinatesX(int x2, int x1) {
        return x2 - x1;
    }

    private int findDifferenceBetweenCoordinatesY(int y2, int y1) {
        return y2 - y1;
    }

    private double findLengthOfSegmentBetween2points(int dx, int dy) {
        return Math.sqrt(dx * dx + dy * dy);
    }

    private double findEndPointOfArrow(double lengthOfSegmentBetween2points, int width) {
        return lengthOfSegmentBetween2points - width;
    }

    private double findSinusOfAngleInclinationLineRelativeToAxis(int differenceBetweenCoordinatesY, double lengthOfSegmentBetween2points) {
        return differenceBetweenCoordinatesY / lengthOfSegmentBetween2points;
    }

    private double findCosineOfAngleInclinationLineRelativeToAxis(int differenceBetweenCoordinatesX, double lengthOfSegmentBetween2points) {
        return differenceBetweenCoordinatesX / lengthOfSegmentBetween2points;
    }

    private double calculatedX(double endPointOfArrowM, double cosineOfAngleInclinationLineRelativeToAxis,
                               double arrowHeightYm, double sinusOfAngleInclinationLineRelativeToAxis, int x1) {
        return endPointOfArrowM * cosineOfAngleInclinationLineRelativeToAxis - arrowHeightYm * sinusOfAngleInclinationLineRelativeToAxis + x1;
    }

    private double findArrowHeightYm(double endPointOfArrowM, double sinusOfAngleInclinationLineRelativeToAxis,
                                     double arrowHeightYm, double cosineOfAngleInclinationLineRelativeToAxis, int y1) {
        return endPointOfArrowM * sinusOfAngleInclinationLineRelativeToAxis + arrowHeightYm * cosineOfAngleInclinationLineRelativeToAxis + y1;
    }

    private double calculateRotatedXCoordinate(double endPointOfArrowN, double cosineOfAngleInclinationLineRelativeToAxis,
                                               double arrowHeightYn, double sinusOfAngleInclinationLineRelativeToAxis, int x1) {
        return endPointOfArrowN * cosineOfAngleInclinationLineRelativeToAxis - arrowHeightYn * sinusOfAngleInclinationLineRelativeToAxis + x1;
    }

    private double calculateRotatedYCoordinate(double endPointOfArrowN, double sinusOfAngleInclinationLineRelativeToAxis,
                                               double arrowHeightYn, double cosineOfAngleInclinationLineRelativeToAxis, int y1) {
        return endPointOfArrowN * sinusOfAngleInclinationLineRelativeToAxis + arrowHeightYn * cosineOfAngleInclinationLineRelativeToAxis + y1;
    }
}
