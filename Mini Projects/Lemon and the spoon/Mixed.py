#THIS PROJECT TRACKS THE LEMON IN THE LEMON AND THE SPOON RACE
import cv2
import numpy as np

lowerBound=np.array([20,100,100])
upperBound=np.array([60,255,255])
cam= cv2.VideoCapture('E:\The Great Maitree\Technical Projects\minip\LemonFinal.mp4')
kernelOpen=np.ones((5,5))
kernelClose=np.ones((20,20))
#2-D array of ones of size 5x5 and 20x20
co=0
ret, img=cam.read()
while ret:
    cv2.imshow("Frame", img)
    imgHSV= cv2.cvtColor(img,cv2.COLOR_BGR2HSV)
    #Conversion from BGR to HSV
    mask=cv2.inRange(imgHSV,lowerBound,upperBound) 
    #A mask is created
    mask = cv2.erode(mask, None, iterations=2)
    # it erodes away the boundaries of foreground object
    mask = cv2.dilate(mask, None, iterations=2)
    #So it increases the white region in the image or size of foreground object increases.
    #Normally, in cases like noise removal, erosion is followed by dilation.
    #Because, erosion removes white noises, but it also shrinks our object. So we dilate it.
    maskOpen=cv2.morphologyEx(mask,cv2.MORPH_OPEN,kernelOpen)
    maskClose=cv2.morphologyEx(maskOpen,cv2.MORPH_CLOSE,kernelClose)
    #Opening is just another name of erosion followed by dilation.
    maskFinal=maskClose
    conts=cv2.findContours(maskFinal.copy(),cv2.RETR_EXTERNAL,cv2.CHAIN_APPROX_SIMPLE)[-2]
    #Contours can be explained simply as a curve joining all the continuous points (along the boundary), having same color or intensity.
    cv2.drawContours(img,conts,-1,(255,0,0),3)
    #Draw Contours
    center = None
    if len(conts) > 0 :
        c = max(conts, key=cv2.contourArea)
        ((x, y), radius) = cv2.minEnclosingCircle(c)
        #It is a circle which completely covers the object with minimum area. 
        M = cv2.moments(c)
        #mage moments help you to calculate some features like center of mass of the object
        center = (int(M["m10"] / M["m00"]), int(M["m01"] / M["m00"]))
        #Finding the Centroid
        if radius>0 :
            # draw the circle and centroid on the frame,
            # then update the list of tracked points
            cv2.circle(img, (int(x), int(y)), int(radius),(0, 255, 255), 2)
            cv2.circle(img, center, 5, (0, 0, 255), -1)
        co=0
    else:
        if (co>10):
            cv2.putText(img, " TRUE", (100,90), cv2.FONT_HERSHEY_SIMPLEX, 3, (255,0,0),5);
        co=co+1
    #show the frame to our screen
    cv2.imshow("Frame", img)
    key = cv2.waitKey(1) & 0xFF

    # if the 'q' key is pressed, stop the loop
    if key == ord("q"):
        break
    ret, img=cam.read()
cv2.destroyAllWindows()


    
