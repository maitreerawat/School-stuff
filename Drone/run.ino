String readString;
String stringa,stringb,stringc;
int count;
#include <Servo.h>
Servo myservo;
int val = 0;
Servo aESC,bESC,cESC,dESC;

int n=0,n1=0,n2=0,n3=0,n4=0;

void setup() {
  Serial.begin(9600);
  readString="abcdef";
  readString=" ";
  aESC.attach(9);
  bESC.attach(10);
  cESC.attach(11);
  dESC.attach(12);
  /*Serial.println("This Program offers you the following");
  Serial.println("1.Input in a1234 manner for specific motor at specific number");
  Serial.println("2.Input in 1234 manner for all motors at 1234");
  Serial.println("3.Input in a-20,a+20 for increasing/decreasing specific motor at specific number");
  Serial.println("4.Input in -20,+20 for increasing/decreasing all the motors by 20");
  Serial.println("5.Input 0 for all motors to be at 0");*/
}

void loop() {  
        if(Serial.available()>0)
            {while(Serial.available()){
                char c=Serial.read();
                readString +=c;
                delay(2);  
            }
            /*Serial.println("\n");
            Serial.println("INPUT:-");
            Serial.println(readString);*/
            if(readString.length()>0)
               {stringc=readString.substring(2,3);    //a+20
                if(stringc=="+"||stringc=="-")
                { stringa=readString.substring(0,2);
                  stringb=readString.substring(3);
                  n=stringb.toInt();
                  if(stringc=="-")
                   n=n*(-1);
                  }  
                  
                else
                {count=readString.length();
                 stringa=readString.substring(0,2);
                 if((count==7)&&((stringa!=" +")&&(stringa!=" -")))
                  {stringc=readString.substring(1,3);
                   if(stringc!="+"&&stringc!="-")          //1234
                    {stringb=readString.substring(1);
                     n=stringb.toInt();
                     n1=n;
                     n2=n;
                     n3=n;
                     n4=n;
                    }}
                 else
                 {  
                    stringb=readString.substring(2);
                    n=stringb.toInt();
                    if((stringa!=" +")&&(stringa!=" -"))
                    {    
                      if(stringa==" a")
                       n1=n;
                        else if(stringa==" b")
                        n2=n;
                          else if(stringa==" c")
                          n3=n;
                            else if(stringa==" d")
                            n4=n;                        
                              else
                              n1=n2=n3=n4=n;
                       n=0;                 
                 }} }
                if(stringa==" 0")                     //0
                  { n1=n2=n3=n4=0;
                    Serial.println("ZERO");}
                  else if(stringa==" +")                         
                  {  n1+=n;
                     n2+=n;      
                     n3+=n;
                     n4+=n;
                  }
                  else if(stringa==" -")
                  {  n1-=n;
                     n2-=n;      
                     n3-=n;
                     n4-=n;
                  }
                  
                  else if(stringa==" a")
                    { n1+=n;
                      aESC.writeMicroseconds(n1);
                    }
                      else if(stringa==" b")
                      {n2+=n;
                        bESC.writeMicroseconds(n2);
                      }  
                          else if(stringa==" c")
                          {n3+=n;   
                            cESC.writeMicroseconds(n);
                          }
                              else if(stringa==" d")
                                {n4+=n;
                                  dESC.writeMicroseconds(n);
                                }
                                  else
                                    {
                                      aESC.writeMicroseconds(n1);
                                      bESC.writeMicroseconds(n2);
                                      cESC.writeMicroseconds(n3);
                                      dESC.writeMicroseconds(n4);
                                    }  
                   readString=" ";
                   stringa=" ";
                   stringb=" ";
                   stringc=" ";
                   n=0;
                   Serial.println("Motor 1:-");
                   Serial.print(n1);
                   Serial.println("\nMotor 2:-");
                   Serial.print(n2);
                   Serial.println("\nMotor 3:-");
                   Serial.print(n3);
                   Serial.println("\nMotor 4:-");
                   Serial.print(n4);
                                     
                  }//if bracket
            }//2 if bracket
}
 

