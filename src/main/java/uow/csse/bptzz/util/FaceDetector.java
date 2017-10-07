package uow.csse.bptzz.util;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;


/**
 * Created by Tab Tu, Oct.2 2017
 * Updated by Tab Tu, Oct.2 2017
 * Des: test using OpenCV 3.2 jar package to detect faces on pictures.
 */

public class FaceDetector {

    public static void main(String[] args) {

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        System.out.println("\nRunning FaceDetector");
        CascadeClassifier faceDetector = new CascadeClassifier("/Users/Kevin/Downloads/611PRO/611PRO/data/haarcascades/haarcascade_frontalface_alt.xml");
        Mat image = Imgcodecs.imread("tt.JPG");
        MatOfRect faceDetections = new MatOfRect();
        faceDetector.detectMultiScale(image, faceDetections);

        System.out.println(String.format("Detected %s faces", faceDetections.toArray().length));

        //Mat gray = new Mat();
        //Imgproc.cvtColor(image, gray, Imgproc.COLOR_RGB2GRAY);
        //Imgcodecs.imwrite("gray.png", image);

        for (Rect rect : faceDetections.toArray()) {
            //Imgproc.circle(image,new Point(rect.x, rect.y),5,new Scalar(255,0,0),2);
            Imgproc.rectangle(image, new Point(rect.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height), new Scalar(0, 255, 0), 5);

        }

        Imgcodecs.imwrite("ouput.png", image);


    }
}
